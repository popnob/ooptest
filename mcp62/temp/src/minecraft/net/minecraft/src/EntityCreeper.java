// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, EntityAISwimming, EntityAITasks, EntityAICreeperSwell, 
//            EntityAIAvoidEntity, EntityOcelot, EntityAIAttackOnCollide, EntityAIWander, 
//            EntityAIWatchClosest, EntityPlayer, EntityAILookIdle, EntityAINearestAttackableTarget, 
//            EntityAIHurtByTarget, DataWatcher, NBTTagCompound, World, 
//            DamageSource, EntitySkeleton, Item, Entity, 
//            EntityLightningBolt

public class EntityCreeper extends EntityMob
{

    int field_764_a;
    int field_763_b;

    public EntityCreeper(World p_i693_1_)
    {
        super(p_i693_1_);
        field_9357_z = "/mob/creeper.png";
        field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
        field_46019_bU.func_46118_a(2, new EntityAICreeperSwell(this));
        field_46019_bU.func_46118_a(3, new EntityAIAvoidEntity(this, net.minecraft.src.EntityOcelot.class, 6F, 0.25F, 0.3F));
        field_46019_bU.func_46118_a(4, new EntityAIAttackOnCollide(this, 0.25F, false));
        field_46019_bU.func_46118_a(5, new EntityAIWander(this, 0.2F));
        field_46019_bU.func_46118_a(6, new EntityAIWatchClosest(this, net.minecraft.src.EntityPlayer.class, 8F));
        field_46019_bU.func_46118_a(6, new EntityAILookIdle(this));
        field_48105_bU.func_46118_a(1, new EntityAINearestAttackableTarget(this, net.minecraft.src.EntityPlayer.class, 16F, 0, true));
        field_48105_bU.func_46118_a(2, new EntityAIHurtByTarget(this, false));
    }

    public boolean func_46006_aR()
    {
        return true;
    }

    public int func_40117_c()
    {
        return 20;
    }

    protected void func_21057_b()
    {
        super.func_21057_b();
        field_21064_bx.func_21124_a(16, Byte.valueOf((byte)-1));
        field_21064_bx.func_21124_a(17, Byte.valueOf((byte)0));
    }

    public void func_352_a(NBTTagCompound p_352_1_)
    {
        super.func_352_a(p_352_1_);
        if(field_21064_bx.func_21130_a(17) == 1)
        {
            p_352_1_.func_748_a("powered", true);
        }
    }

    public void func_357_b(NBTTagCompound p_357_1_)
    {
        super.func_357_b(p_357_1_);
        field_21064_bx.func_21129_b(17, Byte.valueOf((byte)(p_357_1_.func_760_m("powered") ? 1 : 0)));
    }

    public void func_370_e_()
    {
        if(func_354_B())
        {
            field_763_b = field_764_a;
            int i = func_21091_q();
            if(i > 0 && field_764_a == 0)
            {
                field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
            }
            field_764_a += i;
            if(field_764_a < 0)
            {
                field_764_a = 0;
            }
            if(field_764_a >= 30)
            {
                field_764_a = 30;
                if(!field_615_ag.field_1026_y)
                {
                    if(func_27022_s())
                    {
                        field_615_ag.func_12243_a(this, field_611_ak, field_610_al, field_609_am, 6F);
                    } else
                    {
                        field_615_ag.func_12243_a(this, field_611_ak, field_610_al, field_609_am, 3F);
                    }
                    func_395_F();
                }
            }
        }
        super.func_370_e_();
    }

    protected String func_6394_f_()
    {
        return "mob.creeper";
    }

    protected String func_6390_f()
    {
        return "mob.creeperdeath";
    }

    public void func_419_b(DamageSource p_419_1_)
    {
        super.func_419_b(p_419_1_);
        if(p_419_1_.func_35532_a() instanceof EntitySkeleton)
        {
            func_367_b(Item.field_293_aQ.field_291_aS + field_9312_bd.nextInt(10), 1);
        }
    }

    public boolean func_35175_b(Entity p_35175_1_)
    {
        return true;
    }

    public boolean func_27022_s()
    {
        return field_21064_bx.func_21130_a(17) == 1;
    }

    public float func_440_b(float p_440_1_)
    {
        return ((float)field_763_b + (float)(field_764_a - field_763_b) * p_440_1_) / 28F;
    }

    protected int func_422_g()
    {
        return Item.field_250_K.field_291_aS;
    }

    public int func_21091_q()
    {
        return field_21064_bx.func_21130_a(16);
    }

    public void func_21090_e(int p_21090_1_)
    {
        field_21064_bx.func_21129_b(16, Byte.valueOf((byte)p_21090_1_));
    }

    public void func_27014_a(EntityLightningBolt p_27014_1_)
    {
        super.func_27014_a(p_27014_1_);
        field_21064_bx.func_21129_b(17, Byte.valueOf((byte)1));
    }
}
