// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            StatCollector, EnchantmentProtection, EnchantmentOxygen, EnchantmentWaterWorker, 
//            EnchantmentDamage, EnchantmentKnockback, EnchantmentFireAspect, EnchantmentLootBonus, 
//            EnumEnchantmentType, EnchantmentDigging, EnchantmentUntouching, EnchantmentDurability, 
//            EnchantmentArrowDamage, EnchantmentArrowKnockback, EnchantmentArrowFire, EnchantmentArrowInfinite, 
//            DamageSource, EntityLiving

public abstract class Enchantment
{

    public static final Enchantment field_40504_a[] = new Enchantment[256];
    public static final Enchantment field_40502_b = new EnchantmentProtection(0, 10, 0);
    public static final Enchantment field_40503_c = new EnchantmentProtection(1, 5, 1);
    public static final Enchantment field_40500_d = new EnchantmentProtection(2, 5, 2);
    public static final Enchantment field_40501_e = new EnchantmentProtection(3, 2, 3);
    public static final Enchantment field_40498_f = new EnchantmentProtection(4, 5, 4);
    public static final Enchantment field_40499_g = new EnchantmentOxygen(5, 2);
    public static final Enchantment field_40511_h = new EnchantmentWaterWorker(6, 2);
    public static final Enchantment field_40512_i = new EnchantmentDamage(16, 10, 0);
    public static final Enchantment field_40509_j = new EnchantmentDamage(17, 5, 1);
    public static final Enchantment field_40510_k = new EnchantmentDamage(18, 5, 2);
    public static final Enchantment field_40507_l = new EnchantmentKnockback(19, 5);
    public static final Enchantment field_40508_m = new EnchantmentFireAspect(20, 2);
    public static final Enchantment field_40505_n;
    public static final Enchantment field_40506_o = new EnchantmentDigging(32, 10);
    public static final Enchantment field_40519_p = new EnchantmentUntouching(33, 1);
    public static final Enchantment field_40518_q = new EnchantmentDurability(34, 5);
    public static final Enchantment field_40517_r;
    public static final Enchantment field_46045_s = new EnchantmentArrowDamage(48, 10);
    public static final Enchantment field_46044_t = new EnchantmentArrowKnockback(49, 2);
    public static final Enchantment field_46043_u = new EnchantmentArrowFire(50, 2);
    public static final Enchantment field_46042_v = new EnchantmentArrowInfinite(51, 1);
    public final int field_40516_s;
    private final int field_40513_v;
    public EnumEnchantmentType field_40515_t;
    protected String field_40514_u;

    protected Enchantment(int p_i400_1_, int p_i400_2_, EnumEnchantmentType p_i400_3_)
    {
        field_40516_s = p_i400_1_;
        field_40513_v = p_i400_2_;
        field_40515_t = p_i400_3_;
        if(field_40504_a[p_i400_1_] != null)
        {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        } else
        {
            field_40504_a[p_i400_1_] = this;
            return;
        }
    }

    public int func_40495_b()
    {
        return field_40513_v;
    }

    public int func_40493_c()
    {
        return 1;
    }

    public int func_40491_a()
    {
        return 1;
    }

    public int func_40492_a(int p_40492_1_)
    {
        return 1 + p_40492_1_ * 10;
    }

    public int func_40489_b(int p_40489_1_)
    {
        return func_40492_a(p_40489_1_) + 5;
    }

    public int func_40497_a(int p_40497_1_, DamageSource p_40497_2_)
    {
        return 0;
    }

    public int func_40490_a(int p_40490_1_, EntityLiving p_40490_2_)
    {
        return 0;
    }

    public boolean func_40496_a(Enchantment p_40496_1_)
    {
        return this != p_40496_1_;
    }

    public Enchantment func_40494_a(String p_40494_1_)
    {
        field_40514_u = p_40494_1_;
        return this;
    }

    public String func_40488_d()
    {
        return (new StringBuilder()).append("enchantment.").append(field_40514_u).toString();
    }

    public String func_40487_c(int p_40487_1_)
    {
        String s = StatCollector.func_25200_a(func_40488_d());
        return (new StringBuilder()).append(s).append(" ").append(StatCollector.func_25200_a((new StringBuilder()).append("enchantment.level.").append(p_40487_1_).toString())).toString();
    }

    static 
    {
        field_40505_n = new EnchantmentLootBonus(21, 2, EnumEnchantmentType.weapon);
        field_40517_r = new EnchantmentLootBonus(35, 2, EnumEnchantmentType.digger);
    }
}
