package net.minecraft.src;

import java.util.Random;

public abstract class BlockFluid extends Block
{
    protected BlockFluid(int par1, Material par2Material)
    {
        super(par1, (par2Material != Material.lava ? 12 : 14) * 16 + 13, par2Material);
        float f = 0.0F;
        float f1 = 0.0F;
        setBlockBounds(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
        setTickRandomly(true);
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return blockMaterial != Material.lava;
    }

    public int getBlockColor()
    {
        return 0xffffff;
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        if (blockMaterial == Material.water)
        {
            int i = 0;
            int j = 0;
            int k = 0;

            for (int l = -1; l <= 1; l++)
            {
                for (int i1 = -1; i1 <= 1; i1++)
                {
                    int j1 = par1IBlockAccess.getBiomeGenForCoords(par2 + i1, par4 + l).waterColorMultiplier;
                    i += (j1 & 0xff0000) >> 16;
                    j += (j1 & 0xff00) >> 8;
                    k += j1 & 0xff;
                }
            }

            return (i / 9 & 0xff) << 16 | (j / 9 & 0xff) << 8 | k / 9 & 0xff;
        }
        else
        {
            return 0xffffff;
        }
    }

    /**
     * Returns the percentage of the fluid block that is air, based on the given flow decay of the fluid.
     */
    public static float getFluidHeightPercent(int par0)
    {
        if (par0 >= 8)
        {
            par0 = 0;
        }

        float f = (float)(par0 + 1) / 9F;
        return f;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        if (par1 == 0 || par1 == 1)
        {
            return blockIndexInTexture;
        }
        else
        {
            return blockIndexInTexture + 1;
        }
    }

    /**
     * Returns the amount of fluid decay at the coordinates, or -1 if the block at the coordinates is not the same
     * material as the fluid.
     */
    protected int getFlowDecay(World par1World, int par2, int par3, int par4)
    {
        if (par1World.getBlockMaterial(par2, par3, par4) != blockMaterial)
        {
            return -1;
        }
        else
        {
            return par1World.getBlockMetadata(par2, par3, par4);
        }
    }

    /**
     * Returns the flow decay but converts values indicating falling liquid (values >=8) to their effective source block
     * value of zero.
     */
    protected int getEffectiveFlowDecay(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        if (par1IBlockAccess.getBlockMaterial(par2, par3, par4) != blockMaterial)
        {
            return -1;
        }

        int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if (i >= 8)
        {
            i = 0;
        }

        return i;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Returns whether this block is collideable based on the arguments passed in Args: blockMetaData, unknownFlag
     */
    public boolean canCollideCheck(int par1, boolean par2)
    {
        return par2 && par1 == 0;
    }

    /**
     * Returns Returns true if the given side of this block type should be rendered (if it's solid or not), if the
     * adjacent block is at the given coordinates. Args: blockAccess, x, y, z, side
     */
    public boolean isBlockSolid(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        Material material = par1IBlockAccess.getBlockMaterial(par2, par3, par4);

        if (material == blockMaterial)
        {
            return false;
        }

        if (par5 == 1)
        {
            return true;
        }

        if (material == Material.ice)
        {
            return false;
        }
        else
        {
            return super.isBlockSolid(par1IBlockAccess, par2, par3, par4, par5);
        }
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        Material material = par1IBlockAccess.getBlockMaterial(par2, par3, par4);

        if (material == blockMaterial)
        {
            return false;
        }

        if (par5 == 1)
        {
            return true;
        }

        if (material == Material.ice)
        {
            return false;
        }
        else
        {
            return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int i)
    {
        return null;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 4;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Returns a vector indicating the direction and intensity of fluid flow.
     */
    private Vec3D getFlowVector(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        Vec3D vec3d = Vec3D.createVector(0.0D, 0.0D, 0.0D);
        int i = getEffectiveFlowDecay(par1IBlockAccess, par2, par3, par4);

        for (int j = 0; j < 4; j++)
        {
            int k = par2;
            int l = par3;
            int i1 = par4;

            if (j == 0)
            {
                k--;
            }

            if (j == 1)
            {
                i1--;
            }

            if (j == 2)
            {
                k++;
            }

            if (j == 3)
            {
                i1++;
            }

            int j1 = getEffectiveFlowDecay(par1IBlockAccess, k, l, i1);

            if (j1 < 0)
            {
                if (par1IBlockAccess.getBlockMaterial(k, l, i1).blocksMovement())
                {
                    continue;
                }

                j1 = getEffectiveFlowDecay(par1IBlockAccess, k, l - 1, i1);

                if (j1 >= 0)
                {
                    int k1 = j1 - (i - 8);
                    vec3d = vec3d.addVector((k - par2) * k1, (l - par3) * k1, (i1 - par4) * k1);
                }

                continue;
            }

            if (j1 >= 0)
            {
                int l1 = j1 - i;
                vec3d = vec3d.addVector((k - par2) * l1, (l - par3) * l1, (i1 - par4) * l1);
            }
        }

        if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) >= 8)
        {
            boolean flag = false;

            if (flag || isBlockSolid(par1IBlockAccess, par2, par3, par4 - 1, 2))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2, par3, par4 + 1, 3))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2 - 1, par3, par4, 4))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2 + 1, par3, par4, 5))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2, par3 + 1, par4 - 1, 2))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2, par3 + 1, par4 + 1, 3))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2 - 1, par3 + 1, par4, 4))
            {
                flag = true;
            }

            if (flag || isBlockSolid(par1IBlockAccess, par2 + 1, par3 + 1, par4, 5))
            {
                flag = true;
            }

            if (flag)
            {
                vec3d = vec3d.normalize().addVector(0.0D, -6D, 0.0D);
            }
        }

        vec3d = vec3d.normalize();
        return vec3d;
    }

    /**
     * Can add to the passed in vector for a movement vector to be applied to the entity. Args: x, y, z, entity, vec3d
     */
    public void velocityToAddToEntity(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3D par6Vec3D)
    {
        Vec3D vec3d = getFlowVector(par1World, par2, par3, par4);
        par6Vec3D.xCoord += vec3d.xCoord;
        par6Vec3D.yCoord += vec3d.yCoord;
        par6Vec3D.zCoord += vec3d.zCoord;
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate()
    {
        if (blockMaterial == Material.water)
        {
            return 5;
        }

        return blockMaterial != Material.lava ? 0 : 30;
    }

    /**
     * 'Goes straight to getLightBrightnessForSkyBlocks for Blocks, does some fancy computing for Fluids'
     */
    public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int i = par1IBlockAccess.getLightBrightnessForSkyBlocks(par2, par3, par4, 0);
        int j = par1IBlockAccess.getLightBrightnessForSkyBlocks(par2, par3 + 1, par4, 0);
        int k = i & 0xff;
        int l = j & 0xff;
        int i1 = i >> 16 & 0xff;
        int j1 = j >> 16 & 0xff;
        return (k <= l ? l : k) | (i1 <= j1 ? j1 : i1) << 16;
    }

    /**
     * How bright to render this block based on the light its receiving. Args: iBlockAccess, x, y, z
     */
    public float getBlockBrightness(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float f = par1IBlockAccess.getLightBrightness(par2, par3, par4);
        float f1 = par1IBlockAccess.getLightBrightness(par2, par3 + 1, par4);
        return f <= f1 ? f1 : f;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return blockMaterial != Material.water ? 0 : 1;
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (blockMaterial == Material.water)
        {
            if (par5Random.nextInt(10) == 0)
            {
                int i = par1World.getBlockMetadata(par2, par3, par4);

                if (i <= 0 || i >= 8)
                {
                    par1World.spawnParticle("suspended", (float)par2 + par5Random.nextFloat(), (float)par3 + par5Random.nextFloat(), (float)par4 + par5Random.nextFloat(), 0.0D, 0.0D, 0.0D);
                }
            }

            for (int j = 0; j < 0; j++)
            {
                int l = par5Random.nextInt(4);
                int i1 = par2;
                int j1 = par4;

                if (l == 0)
                {
                    i1--;
                }

                if (l == 1)
                {
                    i1++;
                }

                if (l == 2)
                {
                    j1--;
                }

                if (l == 3)
                {
                    j1++;
                }

                if (par1World.getBlockMaterial(i1, par3, j1) != Material.air || !par1World.getBlockMaterial(i1, par3 - 1, j1).blocksMovement() && !par1World.getBlockMaterial(i1, par3 - 1, j1).isLiquid())
                {
                    continue;
                }

                float f = 0.0625F;
                double d6 = (float)par2 + par5Random.nextFloat();
                double d7 = (float)par3 + par5Random.nextFloat();
                double d8 = (float)par4 + par5Random.nextFloat();

                if (l == 0)
                {
                    d6 = (float)par2 - f;
                }

                if (l == 1)
                {
                    d6 = (float)(par2 + 1) + f;
                }

                if (l == 2)
                {
                    d8 = (float)par4 - f;
                }

                if (l == 3)
                {
                    d8 = (float)(par4 + 1) + f;
                }

                double d9 = 0.0D;
                double d10 = 0.0D;

                if (l == 0)
                {
                    d9 = -f;
                }

                if (l == 1)
                {
                    d9 = f;
                }

                if (l == 2)
                {
                    d10 = -f;
                }

                if (l == 3)
                {
                    d10 = f;
                }

                par1World.spawnParticle("splash", d6, d7, d8, d9, 0.0D, d10);
            }
        }

        if (blockMaterial == Material.water && par5Random.nextInt(64) == 0)
        {
            int k = par1World.getBlockMetadata(par2, par3, par4);

            if (k > 0 && k < 8)
            {
                par1World.playSoundEffect((float)par2 + 0.5F, (float)par3 + 0.5F, (float)par4 + 0.5F, "liquid.water", par5Random.nextFloat() * 0.25F + 0.75F, par5Random.nextFloat() * 1.0F + 0.5F);
            }
        }

        if (blockMaterial == Material.lava && par1World.getBlockMaterial(par2, par3 + 1, par4) == Material.air && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4))
        {
            if (par5Random.nextInt(100) == 0)
            {
                double d = (float)par2 + par5Random.nextFloat();
                double d2 = (double)par3 + maxY;
                double d4 = (float)par4 + par5Random.nextFloat();
                par1World.spawnParticle("lava", d, d2, d4, 0.0D, 0.0D, 0.0D);
                par1World.playSoundEffect(d, d2, d4, "liquid.lavapop", 0.2F + par5Random.nextFloat() * 0.2F, 0.9F + par5Random.nextFloat() * 0.15F);
            }

            if (par5Random.nextInt(200) == 0)
            {
                par1World.playSoundEffect(par2, par3, par4, "liquid.lava", 0.2F + par5Random.nextFloat() * 0.2F, 0.9F + par5Random.nextFloat() * 0.15F);
            }
        }

        if (par5Random.nextInt(10) == 0 && par1World.isBlockNormalCube(par2, par3 - 1, par4) && !par1World.getBlockMaterial(par2, par3 - 2, par4).blocksMovement())
        {
            double d1 = (float)par2 + par5Random.nextFloat();
            double d3 = (double)par3 - 1.05D;
            double d5 = (float)par4 + par5Random.nextFloat();

            if (blockMaterial == Material.water)
            {
                par1World.spawnParticle("dripWater", d1, d3, d5, 0.0D, 0.0D, 0.0D);
            }
            else
            {
                par1World.spawnParticle("dripLava", d1, d3, d5, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public static double func_293_a(IBlockAccess par0IBlockAccess, int par1, int par2, int par3, Material par4Material)
    {
        Vec3D vec3d = null;

        if (par4Material == Material.water)
        {
            vec3d = ((BlockFluid)Block.waterMoving).getFlowVector(par0IBlockAccess, par1, par2, par3);
        }

        if (par4Material == Material.lava)
        {
            vec3d = ((BlockFluid)Block.lavaMoving).getFlowVector(par0IBlockAccess, par1, par2, par3);
        }

        if (vec3d.xCoord == 0.0D && vec3d.zCoord == 0.0D)
        {
            return -1000D;
        }
        else
        {
            return Math.atan2(vec3d.zCoord, vec3d.xCoord) - (Math.PI / 2D);
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        checkForHarden(par1World, par2, par3, par4);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        checkForHarden(par1World, par2, par3, par4);
    }

    /**
     * Forces lava to check to see if it is colliding with water, and then decide what it should harden to.
     */
    private void checkForHarden(World par1World, int par2, int par3, int par4)
    {
        if (par1World.getBlockId(par2, par3, par4) != blockID)
        {
            return;
        }

        if (blockMaterial == Material.lava)
        {
            boolean flag = false;

            if (flag || par1World.getBlockMaterial(par2, par3, par4 - 1) == Material.water)
            {
                flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2, par3, par4 + 1) == Material.water)
            {
                flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2 - 1, par3, par4) == Material.water)
            {
                flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2 + 1, par3, par4) == Material.water)
            {
                flag = true;
            }

            if (flag || par1World.getBlockMaterial(par2, par3 + 1, par4) == Material.water)
            {
                flag = true;
            }

            if (flag)
            {
                int i = par1World.getBlockMetadata(par2, par3, par4);

                if (i == 0)
                {
                    par1World.setBlockWithNotify(par2, par3, par4, Block.obsidian.blockID);
                }
                else if (i <= 4)
                {
                    par1World.setBlockWithNotify(par2, par3, par4, Block.cobblestone.blockID);
                }

                triggerLavaMixEffects(par1World, par2, par3, par4);
            }
        }
    }

    /**
     * Creates fizzing sound and smoke. Used when lava flows over block or mixes with water.
     */
    protected void triggerLavaMixEffects(World par1World, int par2, int par3, int par4)
    {
        par1World.playSoundEffect((float)par2 + 0.5F, (float)par3 + 0.5F, (float)par4 + 0.5F, "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

        for (int i = 0; i < 8; i++)
        {
            par1World.spawnParticle("largesmoke", (double)par2 + Math.random(), (double)par3 + 1.2D, (double)par4 + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }
}
