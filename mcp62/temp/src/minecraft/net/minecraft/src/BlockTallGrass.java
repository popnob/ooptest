// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Material, ColorizerGrass, ColorizerFoliage, 
//            IBlockAccess, BiomeGenBase, Item, World, 
//            EntityPlayer, ItemStack, ItemShears, StatList, 
//            Block

public class BlockTallGrass extends BlockFlower
{

    protected BlockTallGrass(int p_i470_1_, int p_i470_2_)
    {
        super(p_i470_1_, p_i470_2_, Material.field_35495_k);
        float f = 0.4F;
        func_213_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public int func_232_a(int p_232_1_, int p_232_2_)
    {
        if(p_232_2_ == 1)
        {
            return field_378_bb;
        }
        if(p_232_2_ == 2)
        {
            return field_378_bb + 16 + 1;
        }
        if(p_232_2_ == 0)
        {
            return field_378_bb + 16;
        } else
        {
            return field_378_bb;
        }
    }

    public int func_35274_i()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.func_4147_a(d, d1);
    }

    public int func_31030_b(int p_31030_1_)
    {
        if(p_31030_1_ == 0)
        {
            return 0xffffff;
        } else
        {
            return ColorizerFoliage.func_31073_c();
        }
    }

    public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_)
    {
        int i = p_207_1_.func_602_e(p_207_2_, p_207_3_, p_207_4_);
        if(i == 0)
        {
            return 0xffffff;
        } else
        {
            return p_207_1_.func_48454_a(p_207_2_, p_207_4_).func_48415_j();
        }
    }

    public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_)
    {
        if(p_240_2_.nextInt(8) == 0)
        {
            return Item.field_244_Q.field_291_aS;
        } else
        {
            return -1;
        }
    }

    public int func_40198_a(int p_40198_1_, Random p_40198_2_)
    {
        return 1 + p_40198_2_.nextInt(p_40198_1_ * 2 + 1);
    }

    public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_)
    {
        if(!p_220_1_.field_1026_y && p_220_2_.func_6416_v() != null && p_220_2_.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS)
        {
            p_220_2_.func_25058_a(StatList.field_25159_y[field_376_bc], 1);
            func_31027_a(p_220_1_, p_220_3_, p_220_4_, p_220_5_, new ItemStack(Block.field_9257_X, 1, p_220_6_));
        } else
        {
            super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
        }
    }
}
