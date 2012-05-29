package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer
{
    /** The normal small chest model. */
    private ModelChest chestModel;

    /** The large double chest model. */
    private ModelChest largeChestModel;

    public TileEntityChestRenderer()
    {
        chestModel = new ModelChest();
        largeChestModel = new ModelLargeChest();
    }

    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityChestAt(TileEntityChest par1TileEntityChest, double par2, double par4, double par6, float par8)
    {
        int i;

        if (par1TileEntityChest.worldObj == null)
        {
            i = 0;
        }
        else
        {
            Block block = par1TileEntityChest.getBlockType();
            i = par1TileEntityChest.getBlockMetadata();

            if (block != null && i == 0)
            {
                ((BlockChest)block).unifyAdjacentChests(par1TileEntityChest.worldObj, par1TileEntityChest.xCoord, par1TileEntityChest.yCoord, par1TileEntityChest.zCoord);
                i = par1TileEntityChest.getBlockMetadata();
            }

            par1TileEntityChest.checkForAdjacentChests();
        }

        if (par1TileEntityChest.adjacentChestZNeg != null || par1TileEntityChest.adjacentChestXNeg != null)
        {
            return;
        }

        ModelChest modelchest;

        if (par1TileEntityChest.adjacentChestXPos != null || par1TileEntityChest.adjacentChestZPos != null)
        {
            modelchest = largeChestModel;
            bindTextureByName("/item/largechest.png");
        }
        else
        {
            modelchest = chestModel;
            bindTextureByName("/item/chest.png");
        }

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        int j = 0;

        if (i == 2)
        {
            j = 180;
        }

        if (i == 3)
        {
            j = 0;
        }

        if (i == 4)
        {
            j = 90;
        }

        if (i == 5)
        {
            j = -90;
        }

        if (i == 2 && par1TileEntityChest.adjacentChestXPos != null)
        {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
        }

        if (i == 5 && par1TileEntityChest.adjacentChestZPos != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, -1F);
        }

        GL11.glRotatef(j, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f = par1TileEntityChest.prevLidAngle + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle) * par8;

        if (par1TileEntityChest.adjacentChestZNeg != null)
        {
            float f1 = par1TileEntityChest.adjacentChestZNeg.prevLidAngle + (par1TileEntityChest.adjacentChestZNeg.lidAngle - par1TileEntityChest.adjacentChestZNeg.prevLidAngle) * par8;

            if (f1 > f)
            {
                f = f1;
            }
        }

        if (par1TileEntityChest.adjacentChestXNeg != null)
        {
            float f2 = par1TileEntityChest.adjacentChestXNeg.prevLidAngle + (par1TileEntityChest.adjacentChestXNeg.lidAngle - par1TileEntityChest.adjacentChestXNeg.prevLidAngle) * par8;

            if (f2 > f)
            {
                f = f2;
            }
        }

        f = 1.0F - f;
        f = 1.0F - f * f * f;
        modelchest.chestLid.rotateAngleX = -((f * (float)Math.PI) / 2.0F);
        modelchest.renderAll();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        renderTileEntityChestAt((TileEntityChest)par1TileEntity, par2, par4, par6, par8);
    }
}
