package net.minecraft.src;

import java.util.Random;

public class EntityFX extends Entity
{
    private int particleTextureIndex;
    protected float particleTextureJitterX;
    protected float particleTextureJitterY;
    protected int particleAge;
    protected int particleMaxAge;
    protected float particleScale;
    protected float particleGravity;

    /** The red amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0. */
    protected float particleRed;

    /**
     * The green amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0.
     */
    protected float particleGreen;

    /**
     * The blue amount of color. Used as a percentage, 1.0 = 255 and 0.0 = 0.
     */
    protected float particleBlue;
    public static double interpPosX;
    public static double interpPosY;
    public static double interpPosZ;

    public EntityFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World);
        particleAge = 0;
        particleMaxAge = 0;
        setSize(0.2F, 0.2F);
        yOffset = height / 2.0F;
        setPosition(par2, par4, par6);
        particleRed = particleGreen = particleBlue = 1.0F;
        motionX = par8 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        motionY = par10 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        motionZ = par12 + (double)((float)(Math.random() * 2D - 1.0D) * 0.4F);
        float f = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float f1 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
        motionX = (motionX / (double)f1) * (double)f * 0.40000000596046448D;
        motionY = (motionY / (double)f1) * (double)f * 0.40000000596046448D + 0.10000000149011612D;
        motionZ = (motionZ / (double)f1) * (double)f * 0.40000000596046448D;
        particleTextureJitterX = rand.nextFloat() * 3F;
        particleTextureJitterY = rand.nextFloat() * 3F;
        particleScale = (rand.nextFloat() * 0.5F + 0.5F) * 2.0F;
        particleMaxAge = (int)(4F / (rand.nextFloat() * 0.9F + 0.1F));
        particleAge = 0;
    }

    public EntityFX multiplyVelocity(float par1)
    {
        motionX *= par1;
        motionY = (motionY - 0.10000000149011612D) * (double)par1 + 0.10000000149011612D;
        motionZ *= par1;
        return this;
    }

    public EntityFX func_405_d(float par1)
    {
        setSize(0.2F * par1, 0.2F * par1);
        particleScale *= par1;
        return this;
    }

    public void func_40097_b(float par1, float par2, float par3)
    {
        particleRed = par1;
        particleGreen = par2;
        particleBlue = par3;
    }

    public float func_40098_n()
    {
        return particleRed;
    }

    public float func_40101_o()
    {
        return particleGreen;
    }

    public float func_40102_p()
    {
        return particleBlue;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void entityInit()
    {
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;

        if (particleAge++ >= particleMaxAge)
        {
            setDead();
        }

        motionY -= 0.040000000000000001D * (double)particleGravity;
        moveEntity(motionX, motionY, motionZ);
        motionX *= 0.98000001907348633D;
        motionY *= 0.98000001907348633D;
        motionZ *= 0.98000001907348633D;

        if (onGround)
        {
            motionX *= 0.69999998807907104D;
            motionZ *= 0.69999998807907104D;
        }
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f = (float)(particleTextureIndex % 16) / 16F;
        float f1 = f + 0.0624375F;
        float f2 = (float)(particleTextureIndex / 16) / 16F;
        float f3 = f2 + 0.0624375F;
        float f4 = 0.1F * particleScale;
        float f5 = (float)((prevPosX + (posX - prevPosX) * (double)par2) - interpPosX);
        float f6 = (float)((prevPosY + (posY - prevPosY) * (double)par2) - interpPosY);
        float f7 = (float)((prevPosZ + (posZ - prevPosZ) * (double)par2) - interpPosZ);
        float f8 = 1.0F;
        par1Tessellator.setColorOpaque_F(particleRed * f8, particleGreen * f8, particleBlue * f8);
        par1Tessellator.addVertexWithUV(f5 - par3 * f4 - par6 * f4, f6 - par4 * f4, f7 - par5 * f4 - par7 * f4, f1, f3);
        par1Tessellator.addVertexWithUV((f5 - par3 * f4) + par6 * f4, f6 + par4 * f4, (f7 - par5 * f4) + par7 * f4, f1, f2);
        par1Tessellator.addVertexWithUV(f5 + par3 * f4 + par6 * f4, f6 + par4 * f4, f7 + par5 * f4 + par7 * f4, f, f2);
        par1Tessellator.addVertexWithUV((f5 + par3 * f4) - par6 * f4, f6 - par4 * f4, (f7 + par5 * f4) - par7 * f4, f, f3);
    }

    public int getFXLayer()
    {
        return 0;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    /**
     * Public method to set private field particleTextureIndex.
     */
    public void setParticleTextureIndex(int par1)
    {
        particleTextureIndex = par1;
    }

    public int getParticleTextureIndex()
    {
        return particleTextureIndex;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    public boolean canAttackWithItem()
    {
        return false;
    }
}
