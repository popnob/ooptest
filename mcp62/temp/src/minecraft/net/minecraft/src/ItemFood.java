// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, FoodStats, 
//            World, PotionEffect, EnumAction

public class ItemFood extends Item
{

    public final int field_35430_a = 32;
    private final int field_20921_a;
    private final float field_35428_c;
    private final boolean field_25013_bi;
    private boolean field_35431_bw;
    private int field_35433_bx;
    private int field_35432_by;
    private int field_35427_bz;
    private float field_35429_bA;

    public ItemFood(int p_i224_1_, int p_i224_2_, float p_i224_3_, boolean p_i224_4_)
    {
        super(p_i224_1_);
        field_20921_a = p_i224_2_;
        field_25013_bi = p_i224_4_;
        field_35428_c = p_i224_3_;
    }

    public ItemFood(int p_i225_1_, int p_i225_2_, boolean p_i225_3_)
    {
        this(p_i225_1_, p_i225_2_, 0.6F, p_i225_3_);
    }

    public ItemStack func_35413_b(ItemStack p_35413_1_, World p_35413_2_, EntityPlayer p_35413_3_)
    {
        p_35413_1_.field_1615_a--;
        p_35413_3_.func_35191_at().func_35761_a(this);
        p_35413_2_.func_623_a(p_35413_3_, "random.burp", 0.5F, p_35413_2_.field_1037_n.nextFloat() * 0.1F + 0.9F);
        if(!p_35413_2_.field_1026_y && field_35433_bx > 0 && p_35413_2_.field_1037_n.nextFloat() < field_35429_bA)
        {
            p_35413_3_.func_35165_a(new PotionEffect(field_35433_bx, field_35432_by * 20, field_35427_bz));
        }
        return p_35413_1_;
    }

    public int func_35411_c(ItemStack p_35411_1_)
    {
        return 32;
    }

    public EnumAction func_35412_b(ItemStack p_35412_1_)
    {
        return EnumAction.eat;
    }

    public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_)
    {
        if(p_193_3_.func_35197_b(field_35431_bw))
        {
            p_193_3_.func_35199_b(p_193_1_, func_35411_c(p_193_1_));
        }
        return p_193_1_;
    }

    public int func_25011_l()
    {
        return field_20921_a;
    }

    public float func_35426_m()
    {
        return field_35428_c;
    }

    public boolean func_25012_m()
    {
        return field_25013_bi;
    }

    public ItemFood func_35425_a(int p_35425_1_, int p_35425_2_, int p_35425_3_, float p_35425_4_)
    {
        field_35433_bx = p_35425_1_;
        field_35432_by = p_35425_2_;
        field_35427_bz = p_35425_3_;
        field_35429_bA = p_35425_4_;
        return this;
    }

    public ItemFood func_35424_o()
    {
        field_35431_bw = true;
        return this;
    }

    public Item func_20011_a(String p_20011_1_)
    {
        return super.func_20011_a(p_20011_1_);
    }
}
