package net.minecraft.src;

import java.util.Random;

public class EntityCreeper extends EntityMob
{
    /**
     * The amount of time since the creeper was close enough to the player to ignite
     */
    int timeSinceIgnited;

    /**
     * Time when this creeper was last in an active state (Messed up code here, probably causes creeper animation to go
     * weird)
     */
    int lastActiveTime;

    public EntityCreeper(World par1World)
    {
        super(par1World);
        texture = "/mob/creeper.png";
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAICreeperSwell(this));
        tasks.addTask(3, new EntityAIAvoidEntity(this, net.minecraft.src.EntityOcelot.class, 6F, 0.25F, 0.3F));
        tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.25F, false));
        tasks.addTask(5, new EntityAIWander(this, 0.2F));
        tasks.addTask(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        tasks.addTask(6, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
        targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, Byte.valueOf((byte) - 1));
        dataWatcher.addObject(17, Byte.valueOf((byte)0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);

        if (dataWatcher.getWatchableObjectByte(17) == 1)
        {
            par1NBTTagCompound.setBoolean("powered", true);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        dataWatcher.updateObject(17, Byte.valueOf((byte)(par1NBTTagCompound.getBoolean("powered") ? 1 : 0)));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (isEntityAlive())
        {
            lastActiveTime = timeSinceIgnited;
            int i = getCreeperState();

            if (i > 0 && timeSinceIgnited == 0)
            {
                worldObj.playSoundAtEntity(this, "random.fuse", 1.0F, 0.5F);
            }

            timeSinceIgnited += i;

            if (timeSinceIgnited < 0)
            {
                timeSinceIgnited = 0;
            }

            if (timeSinceIgnited >= 30)
            {
                timeSinceIgnited = 30;

                if (!worldObj.isRemote)
                {
                    if (getPowered())
                    {
                        worldObj.createExplosion(this, posX, posY, posZ, 6F);
                    }
                    else
                    {
                        worldObj.createExplosion(this, posX, posY, posZ, 3F);
                    }

                    setDead();
                }
            }
        }

        super.onUpdate();
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.creeper";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.creeperdeath";
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (par1DamageSource.getEntity() instanceof EntitySkeleton)
        {
            dropItem(Item.record13.shiftedIndex + rand.nextInt(10), 1);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        return true;
    }

    /**
     * Returns true if the creeper is powered by a lightning bolt.
     */
    public boolean getPowered()
    {
        return dataWatcher.getWatchableObjectByte(17) == 1;
    }

    /**
     * Connects the the creeper flashes to the creeper's color multiplier
     */
    public float setCreeperFlashTime(float par1)
    {
        return ((float)lastActiveTime + (float)(timeSinceIgnited - lastActiveTime) * par1) / 28F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.gunpowder.shiftedIndex;
    }

    /**
     * Returns the current state of creeper, -1 is idle, 1 is 'in fuse'
     */
    public int getCreeperState()
    {
        return dataWatcher.getWatchableObjectByte(16);
    }

    /**
     * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
     */
    public void setCreeperState(int par1)
    {
        dataWatcher.updateObject(16, Byte.valueOf((byte)par1));
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
    {
        super.onStruckByLightning(par1EntityLightningBolt);
        dataWatcher.updateObject(17, Byte.valueOf((byte)1));
    }
}
