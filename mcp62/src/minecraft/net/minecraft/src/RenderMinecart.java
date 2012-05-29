package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderMinecart extends Render
{
    /** instance of ModelMinecart for rendering */
    protected ModelBase modelMinecart;

    public RenderMinecart()
    {
        shadowSize = 0.5F;
        modelMinecart = new ModelMinecart();
    }

    public void func_152_a(EntityMinecart par1EntityMinecart, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        long l = (long)par1EntityMinecart.entityId * 0x1d66f537L;
        l = l * l * 0x105cb26d1L + l * 0x181c9L;
        float f = (((float)(l >> 16 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f1 = (((float)(l >> 20 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f2 = (((float)(l >> 24 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        GL11.glTranslatef(f, f1, f2);
        double d = par1EntityMinecart.lastTickPosX + (par1EntityMinecart.posX - par1EntityMinecart.lastTickPosX) * (double)par9;
        double d1 = par1EntityMinecart.lastTickPosY + (par1EntityMinecart.posY - par1EntityMinecart.lastTickPosY) * (double)par9;
        double d2 = par1EntityMinecart.lastTickPosZ + (par1EntityMinecart.posZ - par1EntityMinecart.lastTickPosZ) * (double)par9;
        double d3 = 0.30000001192092896D;
        Vec3D vec3d = par1EntityMinecart.func_514_g(d, d1, d2);
        float f3 = par1EntityMinecart.prevRotationPitch + (par1EntityMinecart.rotationPitch - par1EntityMinecart.prevRotationPitch) * par9;

        if (vec3d != null)
        {
            Vec3D vec3d1 = par1EntityMinecart.func_515_a(d, d1, d2, d3);
            Vec3D vec3d2 = par1EntityMinecart.func_515_a(d, d1, d2, -d3);

            if (vec3d1 == null)
            {
                vec3d1 = vec3d;
            }

            if (vec3d2 == null)
            {
                vec3d2 = vec3d;
            }

            par2 += vec3d.xCoord - d;
            par4 += (vec3d1.yCoord + vec3d2.yCoord) / 2D - d1;
            par6 += vec3d.zCoord - d2;
            Vec3D vec3d3 = vec3d2.addVector(-vec3d1.xCoord, -vec3d1.yCoord, -vec3d1.zCoord);

            if (vec3d3.lengthVector() != 0.0D)
            {
                vec3d3 = vec3d3.normalize();
                par8 = (float)((Math.atan2(vec3d3.zCoord, vec3d3.xCoord) * 180D) / Math.PI);
                f3 = (float)(Math.atan(vec3d3.yCoord) * 73D);
            }
        }

        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180F - par8, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f3, 0.0F, 0.0F, 1.0F);
        float f4 = (float)par1EntityMinecart.func_41023_l() - par9;
        float f5 = (float)par1EntityMinecart.func_41025_i() - par9;

        if (f5 < 0.0F)
        {
            f5 = 0.0F;
        }

        if (f4 > 0.0F)
        {
            GL11.glRotatef(((MathHelper.sin(f4) * f4 * f5) / 10F) * (float)par1EntityMinecart.func_41030_m(), 1.0F, 0.0F, 0.0F);
        }

        if (par1EntityMinecart.minecartType != 0)
        {
            loadTexture("/terrain.png");
            float f6 = 0.75F;
            GL11.glScalef(f6, f6, f6);

            if (par1EntityMinecart.minecartType == 1)
            {
                GL11.glTranslatef(-0.5F, 0.0F, 0.5F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                (new RenderBlocks()).renderBlockAsItem(Block.chest, 0, par1EntityMinecart.getBrightness(par9));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.5F, 0.0F, -0.5F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
            else if (par1EntityMinecart.minecartType == 2)
            {
                GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                (new RenderBlocks()).renderBlockAsItem(Block.stoneOvenIdle, 0, par1EntityMinecart.getBrightness(par9));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        }

        loadTexture("/item/cart.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        modelMinecart.render(par1EntityMinecart, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        func_152_a((EntityMinecart)par1Entity, par2, par4, par6, par8, par9);
    }
}
