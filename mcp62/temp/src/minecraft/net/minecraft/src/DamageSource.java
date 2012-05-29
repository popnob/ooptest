// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, EntityDamageSourceIndirect, EntityLiving, EntityPlayer, 
//            EntityArrow, Entity, EntityFireball

public class DamageSource
{

    public static DamageSource field_35542_a = (new DamageSource("inFire")).func_40546_j();
    public static DamageSource field_35540_b = (new DamageSource("onFire")).func_35528_f().func_40546_j();
    public static DamageSource field_35541_c = (new DamageSource("lava")).func_40546_j();
    public static DamageSource field_35538_d = (new DamageSource("inWall")).func_35528_f();
    public static DamageSource field_35539_e = (new DamageSource("drown")).func_35528_f();
    public static DamageSource field_35536_f = (new DamageSource("starve")).func_35528_f();
    public static DamageSource field_35537_g = new DamageSource("cactus");
    public static DamageSource field_35549_h = (new DamageSource("fall")).func_35528_f();
    public static DamageSource field_35550_i = (new DamageSource("outOfWorld")).func_35528_f().func_35531_g();
    public static DamageSource field_35547_j = (new DamageSource("generic")).func_35528_f();
    public static DamageSource field_35548_k = new DamageSource("explosion");
    public static DamageSource field_35545_l = (new DamageSource("magic")).func_35528_f();
    private boolean field_35543_n;
    private boolean field_35544_o;
    private float field_35551_p;
    private boolean field_40549_q;
    private boolean field_40548_r;
    public String field_35546_m;

    public static DamageSource func_35525_a(EntityLiving p_35525_0_)
    {
        return new EntityDamageSource("mob", p_35525_0_);
    }

    public static DamageSource func_35527_a(EntityPlayer p_35527_0_)
    {
        return new EntityDamageSource("player", p_35527_0_);
    }

    public static DamageSource func_35535_a(EntityArrow p_35535_0_, Entity p_35535_1_)
    {
        return (new EntityDamageSourceIndirect("arrow", p_35535_0_, p_35535_1_)).func_40544_c();
    }

    public static DamageSource func_35530_a(EntityFireball p_35530_0_, Entity p_35530_1_)
    {
        return (new EntityDamageSourceIndirect("fireball", p_35530_0_, p_35530_1_)).func_40546_j().func_40544_c();
    }

    public static DamageSource func_35524_a(Entity p_35524_0_, Entity p_35524_1_)
    {
        return (new EntityDamageSourceIndirect("thrown", p_35524_0_, p_35524_1_)).func_40544_c();
    }

    public static DamageSource func_40542_b(Entity p_40542_0_, Entity p_40542_1_)
    {
        return (new EntityDamageSourceIndirect("indirectMagic", p_40542_0_, p_40542_1_)).func_35528_f();
    }

    public boolean func_40547_b()
    {
        return field_40548_r;
    }

    public DamageSource func_40544_c()
    {
        field_40548_r = true;
        return this;
    }

    public boolean func_35534_b()
    {
        return field_35543_n;
    }

    public float func_35533_c()
    {
        return field_35551_p;
    }

    public boolean func_35529_d()
    {
        return field_35544_o;
    }

    protected DamageSource(String p_i447_1_)
    {
        field_35543_n = false;
        field_35544_o = false;
        field_35551_p = 0.3F;
        field_35546_m = p_i447_1_;
    }

    public Entity func_35526_e()
    {
        return func_35532_a();
    }

    public Entity func_35532_a()
    {
        return null;
    }

    protected DamageSource func_35528_f()
    {
        field_35543_n = true;
        field_35551_p = 0.0F;
        return this;
    }

    protected DamageSource func_35531_g()
    {
        field_35544_o = true;
        return this;
    }

    protected DamageSource func_40546_j()
    {
        field_40549_q = true;
        return this;
    }

    public boolean func_40543_k()
    {
        return field_40549_q;
    }

    public String func_40545_l()
    {
        return field_35546_m;
    }

}
