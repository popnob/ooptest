package net.minecraft.src;

import java.util.Random;

public class EntityBlaze extends EntityMob
{
    /** Random offset used in floating behaviour */
    private float heightOffset;

    /** ticks until heightOffset is randomized */
    private int heightOffsetUpdateTime;
    private int field_40152_d;

    public EntityBlaze(World par1World)
    {
        super(par1World);
        heightOffset = 0.5F;
        texture = "/mob/fire.png";
        isImmuneToFire = true;
        attackStrength = 6;
        experienceValue = 10;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.blaze.breathe";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.blaze.death";
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);
    }

    public int getBrightnessForRender(float par1)
    {
        return 0xf000f0;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 1.0F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (!worldObj.isRemote)
        {
            if (isWet())
            {
                attackEntityFrom(DamageSource.drown, 1);
            }

            heightOffsetUpdateTime--;

            if (heightOffsetUpdateTime <= 0)
            {
                heightOffsetUpdateTime = 100;
                heightOffset = 0.5F + (float)rand.nextGaussian() * 3F;
            }

            if (getEntityToAttack() != null && getEntityToAttack().posY + (double)getEntityToAttack().getEyeHeight() > posY + (double)getEyeHeight() + (double)heightOffset)
            {
                motionY = motionY + (0.30000001192092896D - motionY) * 0.30000001192092896D;
            }
        }

        if (rand.nextInt(24) == 0)
        {
            worldObj.playSoundEffect(posX + 0.5D, posY + 0.5D, posZ + 0.5D, "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F);
        }

        if (!onGround && motionY < 0.0D)
        {
            motionY *= 0.59999999999999998D;
        }

        for (int i = 0; i < 2; i++)
        {
            worldObj.spawnParticle("largesmoke", posX + (rand.nextDouble() - 0.5D) * (double)width, posY + rand.nextDouble() * (double)height, posZ + (rand.nextDouble() - 0.5D) * (double)width, 0.0D, 0.0D, 0.0D);
        }

        super.onLivingUpdate();
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > boundingBox.minY && par1Entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
            attackEntityAsMob(par1Entity);
        }
        else if (par2 < 30F)
        {
            double d = par1Entity.posX - posX;
            double d1 = (par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F)) - (posY + (double)(height / 2.0F));
            double d2 = par1Entity.posZ - posZ;

            if (attackTime == 0)
            {
                field_40152_d++;

                if (field_40152_d == 1)
                {
                    attackTime = 60;
                    func_40150_a(true);
                }
                else if (field_40152_d <= 4)
                {
                    attackTime = 6;
                }
                else
                {
                    attackTime = 100;
                    field_40152_d = 0;
                    func_40150_a(false);
                }

                if (field_40152_d > 1)
                {
                    float f = MathHelper.sqrt_float(par2) * 0.5F;
                    worldObj.playAuxSFXAtEntity(null, 1009, (int)posX, (int)posY, (int)posZ, 0);

                    for (int i = 0; i < 1; i++)
                    {
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(worldObj, this, d + rand.nextGaussian() * (double)f, d1, d2 + rand.nextGaussian() * (double)f);
                        entitysmallfireball.posY = posY + (double)(height / 2.0F) + 0.5D;
                        worldObj.spawnEntityInWorld(entitysmallfireball);
                    }
                }
            }

            rotationYaw = (float)((Math.atan2(d2, d) * 180D) / Math.PI) - 90F;
            hasAttacked = true;
        }
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float f)
    {
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.blazeRod.shiftedIndex;
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning()
    {
        return func_40151_ac();
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        if (par1)
        {
            int i = rand.nextInt(2 + par2);

            for (int j = 0; j < i; j++)
            {
                dropItem(Item.blazeRod.shiftedIndex, 1);
            }
        }
    }

    public boolean func_40151_ac()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_40150_a(boolean par1)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            byte0 |= 1;
        }
        else
        {
            byte0 &= 0xfe;
        }

        dataWatcher.updateObject(16, Byte.valueOf(byte0));
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        return true;
    }
}
