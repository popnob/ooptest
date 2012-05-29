package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

public class WorldRenderer
{
    /** Reference to the World object. */
    public World worldObj;
    private int glRenderList;
    public static int chunksUpdated = 0;
    public int posX;
    public int posY;
    public int posZ;

    /** Pos X minus */
    public int posXMinus;

    /** Pos Y minus */
    public int posYMinus;

    /** Pos Z minus */
    public int posZMinus;

    /** Pos X clipped */
    public int posXClip;

    /** Pos Y clipped */
    public int posYClip;

    /** Pos Z clipped */
    public int posZClip;
    public boolean isInFrustum;
    public boolean skipRenderPass[];

    /** Pos X plus */
    public int posXPlus;

    /** Pos Y plus */
    public int posYPlus;

    /** Pos Z plus */
    public int posZPlus;

    /** Boolean for whether this renderer needs to be updated or not */
    public boolean needsUpdate;

    /** Axis aligned bounding box */
    public AxisAlignedBB rendererBoundingBox;

    /** Chunk index */
    public int chunkIndex;

    /** Is this renderer visible according to the occlusion query */
    public boolean isVisible;

    /** Is this renderer waiting on the result of the occlusion query */
    public boolean isWaitingOnOcclusionQuery;

    /** OpenGL occlusion query */
    public int glOcclusionQuery;

    /** Is the chunk lit */
    public boolean isChunkLit;
    private boolean isInitialized;

    /** All the tile entities that have special rendering code for this chunk */
    public List tileEntityRenderers;
    private List tileEntities;

    /** Bytes sent to the GPU */
    private int bytesDrawn;
    public boolean isVisibleFromPosition;
    public double visibleFromX;
    public double visibleFromY;
    public double visibleFromZ;
    private boolean needsBoxUpdate;
    public boolean isInFrustrumFully;
    public static int globalChunkOffsetX = 0;
    public static int globalChunkOffsetZ = 0;
    public boolean isUpdating;
    private WrUpdateState updateState;
    public int activeSet;
    public int activeListIndex[] =
    {
        0, 0
    };
    public int glWorkLists[][][];
    public boolean tempSkipRenderPass[];

    public WorldRenderer(World par1World, List par2List, int par3, int par4, int par5, int par6)
    {
        isVisibleFromPosition = false;
        needsBoxUpdate = false;
        isInFrustrumFully = false;
        isUpdating = false;
        updateState = new WrUpdateState();
        activeSet = 0;
        glWorkLists = new int[2][2][16];
        tempSkipRenderPass = new boolean[2];
        glRenderList = -1;
        isInFrustum = false;
        skipRenderPass = new boolean[2];
        isVisible = true;
        isInitialized = false;
        tileEntityRenderers = new ArrayList();
        worldObj = par1World;
        tileEntities = par2List;
        glRenderList = par6;
        int i = 0x60000 + 64 * (glRenderList / 3);

        for (int j = 0; j < 2; j++)
        {
            int k = i + j * 2 * 16;

            for (int l = 0; l < 2; l++)
            {
                int i1 = k + l * 16;

                for (int j1 = 0; j1 < 16; j1++)
                {
                    glWorkLists[j][l][j1] = i1 + j1;
                }
            }
        }

        posX = -999;
        setPosition(par3, par4, par5);
        needsUpdate = false;
    }

    /**
     * Sets a new position for the renderer and setting it up so it can be reloaded with the new data for that position
     */
    public void setPosition(int par1, int par2, int par3)
    {
        if (par1 == posX && par2 == posY && par3 == posZ)
        {
            return;
        }

        if (isUpdating)
        {
            updateRenderer();
        }

        setDontDraw();
        posX = par1;
        posY = par2;
        posZ = par3;
        posXPlus = par1 + 8;
        posYPlus = par2 + 8;
        posZPlus = par3 + 8;
        posXClip = par1 & 0x3ff;
        posYClip = par2;
        posZClip = par3 & 0x3ff;
        posXMinus = par1 - posXClip;
        posYMinus = par2 - posYClip;
        posZMinus = par3 - posZClip;
        float f = 0.0F;
        rendererBoundingBox = AxisAlignedBB.getBoundingBox((float)par1 - f, (float)par2 - f, (float)par3 - f, (float)(par1 + 16) + f, (float)(par2 + 16) + f, (float)(par3 + 16) + f);
        needsBoxUpdate = true;
        markDirty();
        isVisibleFromPosition = false;
    }

    private void setupGLTranslation()
    {
        GL11.glTranslatef(posXClip, posYClip, posZClip);
    }

    /**
     * Will update this chunk renderer
     */
    public void updateRenderer()
    {
        if (worldObj == null)
        {
            return;
        }
        else
        {
            updateRenderer(0L);
            finishUpdate();
            return;
        }
    }

    public void finishUpdate()
    {
        for (int i = 0; i < 2; i++)
        {
            if (skipRenderPass[i])
            {
                continue;
            }

            GL11.glNewList(glRenderList + i, GL11.GL_COMPILE);

            for (int l = 0; l <= activeListIndex[i]; l++)
            {
                int j1 = glWorkLists[activeSet][i][l];
                GL11.glCallList(j1);
            }

            GL11.glEndList();
        }

        if (activeSet == 0)
        {
            activeSet = 1;
        }
        else
        {
            activeSet = 0;
        }

        for (int j = 0; j < 2; j++)
        {
            if (skipRenderPass[j])
            {
                continue;
            }

            for (int i1 = 0; i1 <= activeListIndex[j]; i1++)
            {
                int k1 = glWorkLists[activeSet][j][i1];
                GL11.glNewList(k1, GL11.GL_COMPILE);
                GL11.glEndList();
            }
        }

        for (int k = 0; k < 2; k++)
        {
            activeListIndex[k] = 0;
        }
    }

    public boolean updateRenderer(long l)
    {
        if (worldObj == null)
        {
            return true;
        }

        needsUpdate = false;

        if (!isUpdating)
        {
            if (needsBoxUpdate)
            {
                float f = 0.0F;
                GL11.glNewList(glRenderList + 2, GL11.GL_COMPILE);
                RenderItem.renderAABB(AxisAlignedBB.getBoundingBoxFromPool((float)posXClip - f, (float)posYClip - f, (float)posZClip - f, (float)(posXClip + 16) + f, (float)(posYClip + 16) + f, (float)(posZClip + 16) + f));
                GL11.glEndList();
                needsBoxUpdate = false;
            }

            if (Reflector.hasClass(3))
            {
                Object obj = Reflector.getFieldValue(30);
                Reflector.callVoid(obj, 30, new Object[0]);
                Reflector.callVoid(40, new Object[0]);
            }

            Chunk.isLit = false;
        }

        int i = posX;
        int j = posY;
        int k = posZ;
        int i1 = posX + 16;
        int j1 = posY + 16;
        int k1 = posZ + 16;
        ChunkCache chunkcache = null;
        RenderBlocks renderblocks = null;
        HashSet hashset = null;

        if (!isUpdating)
        {
            for (int l1 = 0; l1 < 2; l1++)
            {
                tempSkipRenderPass[l1] = true;
            }

            int i2 = 1;
            chunkcache = new ChunkCache(worldObj, i - i2, j - i2, k - i2, i1 + i2, j1 + i2, k1 + i2);
            renderblocks = new RenderBlocks(chunkcache);
            hashset = new HashSet();
            hashset.addAll(tileEntityRenderers);
            tileEntityRenderers.clear();
        }

        if (isUpdating || !chunkcache.func_48452_a())
        {
            bytesDrawn = 0;
            Tessellator tessellator = Tessellator.instance;
            boolean flag = Reflector.hasClass(1);
            int j2 = 0;

            do
            {
                if (j2 >= 2)
                {
                    break;
                }

                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;

                for (int k2 = j; k2 < j1; k2++)
                {
                    if (isUpdating)
                    {
                        isUpdating = false;
                        chunkcache = updateState.chunkcache;
                        renderblocks = updateState.renderblocks;
                        hashset = updateState.setOldEntityRenders;
                        j2 = updateState.renderPass;
                        k2 = updateState.y;
                        flag1 = updateState.flag;
                        flag2 = updateState.hasRenderedBlocks;
                        flag3 = updateState.hasGlList;

                        if (flag3)
                        {
                            GL11.glNewList(glWorkLists[activeSet][j2][activeListIndex[j2]], GL11.GL_COMPILE);

                            if (flag)
                            {
                                Reflector.callVoid(13, new Object[]
                                        {
                                            Integer.valueOf(j2)
                                        });
                            }

                            tessellator.setRenderingChunk(true);
                            tessellator.startDrawingQuads();
                            tessellator.setTranslation(-globalChunkOffsetX, 0.0D, -globalChunkOffsetZ);
                        }
                    }
                    else if (flag3 && l != 0L && System.nanoTime() - l > 0L && activeListIndex[j2] < 15)
                    {
                        if (flag)
                        {
                            Reflector.callVoid(14, new Object[]
                                    {
                                        Integer.valueOf(j2)
                                    });
                        }

                        tessellator.draw();
                        GL11.glEndList();
                        tessellator.setRenderingChunk(false);
                        tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                        activeListIndex[j2] = activeListIndex[j2] + 1;
                        updateState.chunkcache = chunkcache;
                        updateState.renderblocks = renderblocks;
                        updateState.setOldEntityRenders = hashset;
                        updateState.renderPass = j2;
                        updateState.y = k2;
                        updateState.flag = flag1;
                        updateState.hasRenderedBlocks = flag2;
                        updateState.hasGlList = flag3;
                        isUpdating = true;
                        return false;
                    }

                    for (int l2 = k; l2 < k1; l2++)
                    {
                        for (int i3 = i; i3 < i1; i3++)
                        {
                            int j3 = chunkcache.getBlockId(i3, k2, l2);

                            if (j3 <= 0)
                            {
                                continue;
                            }

                            if (!flag3)
                            {
                                flag3 = true;
                                GL11.glNewList(glWorkLists[activeSet][j2][activeListIndex[j2]], GL11.GL_COMPILE);

                                if (flag)
                                {
                                    Reflector.callVoid(13, new Object[]
                                            {
                                                Integer.valueOf(j2)
                                            });
                                }

                                tessellator.setRenderingChunk(true);
                                tessellator.startDrawingQuads();
                                tessellator.setTranslation(-globalChunkOffsetX, 0.0D, -globalChunkOffsetZ);
                            }

                            Block block = Block.blocksList[j3];

                            if (j2 == 0 && block.hasTileEntity())
                            {
                                TileEntity tileentity = chunkcache.getBlockTileEntity(i3, k2, l2);

                                if (TileEntityRenderer.instance.hasSpecialRenderer(tileentity))
                                {
                                    tileEntityRenderers.add(tileentity);
                                }
                            }

                            int k3 = block.getRenderBlockPass();
                            boolean flag4 = true;

                            if (k3 != j2)
                            {
                                flag1 = true;
                                flag4 = false;
                            }

                            if (flag)
                            {
                                flag4 = Reflector.callBoolean(11, new Object[]
                                        {
                                            block, Integer.valueOf(j2)
                                        });
                            }

                            if (!flag4)
                            {
                                continue;
                            }

                            if (flag)
                            {
                                Reflector.callVoid(15, new Object[]
                                        {
                                            block, renderblocks
                                        });
                            }

                            flag2 |= renderblocks.renderBlockByRenderType(block, i3, k2, l2);

                            if (flag)
                            {
                                Reflector.callVoid(16, new Object[]
                                        {
                                            block, renderblocks
                                        });
                            }
                        }
                    }
                }

                if (flag3)
                {
                    if (flag)
                    {
                        Reflector.callVoid(14, new Object[]
                                {
                                    Integer.valueOf(j2)
                                });
                    }

                    bytesDrawn += tessellator.draw();
                    GL11.glEndList();
                    tessellator.setRenderingChunk(false);
                    tessellator.setTranslation(0.0D, 0.0D, 0.0D);
                }
                else
                {
                    flag2 = false;
                }

                if (flag2)
                {
                    tempSkipRenderPass[j2] = false;
                }

                if (!flag1)
                {
                    break;
                }

                j2++;
            }
            while (true);
        }

        HashSet hashset1 = new HashSet();
        hashset1.addAll(tileEntityRenderers);
        hashset1.removeAll(hashset);
        tileEntities.addAll(hashset1);
        hashset.removeAll(tileEntityRenderers);
        tileEntities.removeAll(hashset);
        isChunkLit = Chunk.isLit;
        isInitialized = true;
        chunksUpdated++;
        isVisible = true;
        isVisibleFromPosition = false;
        skipRenderPass[0] = tempSkipRenderPass[0];
        skipRenderPass[1] = tempSkipRenderPass[1];
        isUpdating = false;
        return true;
    }

    /**
     * Returns the distance of this chunk renderer to the entity without performing the final normalizing square root,
     * for performance reasons.
     */
    public float distanceToEntitySquared(Entity par1Entity)
    {
        float f = (float)(par1Entity.posX - (double)posXPlus);
        float f1 = (float)(par1Entity.posY - (double)posYPlus);
        float f2 = (float)(par1Entity.posZ - (double)posZPlus);
        return f * f + f1 * f1 + f2 * f2;
    }

    /**
     * When called this renderer won't draw anymore until its gets initialized again
     */
    public void setDontDraw()
    {
        for (int i = 0; i < 2; i++)
        {
            skipRenderPass[i] = true;
        }

        isInFrustum = false;
        isInitialized = false;
    }

    public void stopRendering()
    {
        setDontDraw();
        worldObj = null;
    }

    /**
     * Takes in the pass the call list is being requested for. Args: renderPass
     */
    public int getGLCallListForPass(int par1)
    {
        if (!isInFrustum)
        {
            return -1;
        }

        if (!skipRenderPass[par1])
        {
            return glRenderList + par1;
        }
        else
        {
            return -1;
        }
    }

    public void updateInFrustum(ICamera par1ICamera)
    {
        isInFrustum = par1ICamera.isBoundingBoxInFrustum(rendererBoundingBox);

        if (isInFrustum && Config.isOcclusionEnabled() && Config.isOcclusionFancy())
        {
            isInFrustrumFully = par1ICamera.isBoundingBoxInFrustumFully(rendererBoundingBox);
        }
        else
        {
            isInFrustrumFully = false;
        }
    }

    /**
     * Renders the occlusion query GL List
     */
    public void callOcclusionQueryList()
    {
        GL11.glCallList(glRenderList + 2);
    }

    /**
     * Checks if all render passes are to be skipped. Returns false if the renderer is not initialized
     */
    public boolean skipAllRenderPasses()
    {
        if (!isInitialized)
        {
            return false;
        }
        else
        {
            return skipRenderPass[0] && skipRenderPass[1];
        }
    }

    /**
     * Marks the current renderer data as dirty and needing to be updated.
     */
    public void markDirty()
    {
        needsUpdate = true;
    }
}
