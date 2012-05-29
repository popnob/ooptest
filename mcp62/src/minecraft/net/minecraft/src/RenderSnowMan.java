package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSnowMan extends RenderLiving
{
    /** A reference to the Snowman model in RenderSnowMan. */
    private ModelSnowMan snowmanModel;

    public RenderSnowMan()
    {
        super(new ModelSnowMan(), 0.5F);
        snowmanModel = (ModelSnowMan)super.mainModel;
        setRenderPassModel(snowmanModel);
    }

    protected void func_40288_a(EntitySnowman par1EntitySnowman, float par2)
    {
        super.renderEquippedItems(par1EntitySnowman, par2);
        ItemStack itemstack = new ItemStack(Block.pumpkin, 1);

        if (itemstack != null && itemstack.getItem().shiftedIndex < 256)
        {
            GL11.glPushMatrix();
            snowmanModel.field_40305_c.postRender(0.0625F);

            if (RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
            {
                float f = 0.625F;
                GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f, -f, f);
            }

            renderManager.itemRenderer.renderItem(par1EntitySnowman, itemstack, 0);
            GL11.glPopMatrix();
        }
    }

    protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
    {
        func_40288_a((EntitySnowman)par1EntityLiving, par2);
    }
}
