// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockSand, 
//            EntityFallingSand, EntityPlayer

public class BlockDragonEgg extends Block
{

    public BlockDragonEgg(int p_i281_1_, int p_i281_2_)
    {
        super(p_i281_1_, p_i281_2_, Material.field_41056_z);
    }

    public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_)
    {
        p_235_1_.func_22136_c(p_235_2_, p_235_3_, p_235_4_, field_376_bc, func_4025_d());
    }

    public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_)
    {
        p_226_1_.func_22136_c(p_226_2_, p_226_3_, p_226_4_, field_376_bc, func_4025_d());
    }

    public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_)
    {
        func_41055_g(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
    }

    private void func_41055_g(World p_41055_1_, int p_41055_2_, int p_41055_3_, int p_41055_4_)
    {
        int i = p_41055_2_;
        int j = p_41055_3_;
        int k = p_41055_4_;
        if(BlockSand.func_316_a_(p_41055_1_, i, j - 1, k) && j >= 0)
        {
            byte byte0 = 32;
            if(BlockSand.field_466_a || !p_41055_1_.func_640_a(p_41055_2_ - byte0, p_41055_3_ - byte0, p_41055_4_ - byte0, p_41055_2_ + byte0, p_41055_3_ + byte0, p_41055_4_ + byte0))
            {
                p_41055_1_.func_690_d(p_41055_2_, p_41055_3_, p_41055_4_, 0);
                for(; BlockSand.func_316_a_(p_41055_1_, p_41055_2_, p_41055_3_ - 1, p_41055_4_) && p_41055_3_ > 0; p_41055_3_--) { }
                if(p_41055_3_ > 0)
                {
                    p_41055_1_.func_690_d(p_41055_2_, p_41055_3_, p_41055_4_, field_376_bc);
                }
            } else
            {
                EntityFallingSand entityfallingsand = new EntityFallingSand(p_41055_1_, (float)p_41055_2_ + 0.5F, (float)p_41055_3_ + 0.5F, (float)p_41055_4_ + 0.5F, field_376_bc);
                p_41055_1_.func_674_a(entityfallingsand);
            }
        }
    }

    public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_)
    {
        func_41054_h(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
        return true;
    }

    public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_)
    {
        func_41054_h(p_233_1_, p_233_2_, p_233_3_, p_233_4_);
    }

    private void func_41054_h(World p_41054_1_, int p_41054_2_, int p_41054_3_, int p_41054_4_)
    {
        if(p_41054_1_.func_600_a(p_41054_2_, p_41054_3_, p_41054_4_) != field_376_bc)
        {
            return;
        }
        if(p_41054_1_.field_1026_y)
        {
            return;
        }
        for(int i = 0; i < 1000; i++)
        {
            int j = (p_41054_2_ + p_41054_1_.field_1037_n.nextInt(16)) - p_41054_1_.field_1037_n.nextInt(16);
            int k = (p_41054_3_ + p_41054_1_.field_1037_n.nextInt(8)) - p_41054_1_.field_1037_n.nextInt(8);
            int l = (p_41054_4_ + p_41054_1_.field_1037_n.nextInt(16)) - p_41054_1_.field_1037_n.nextInt(16);
            if(p_41054_1_.func_600_a(j, k, l) == 0)
            {
                p_41054_1_.func_688_b(j, k, l, field_376_bc, p_41054_1_.func_602_e(p_41054_2_, p_41054_3_, p_41054_4_));
                p_41054_1_.func_690_d(p_41054_2_, p_41054_3_, p_41054_4_, 0);
                char c = '\200';
                for(int i1 = 0; i1 < c; i1++)
                {
                    double d = p_41054_1_.field_1037_n.nextDouble();
                    float f = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    float f1 = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    float f2 = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                    double d1 = (double)j + (double)(p_41054_2_ - j) * d + (p_41054_1_.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    double d2 = ((double)k + (double)(p_41054_3_ - k) * d + p_41054_1_.field_1037_n.nextDouble() * 1.0D) - 0.5D;
                    double d3 = (double)l + (double)(p_41054_4_ - l) * d + (p_41054_1_.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    p_41054_1_.func_694_a("portal", d1, d2, d3, f, f1, f2);
                }

                return;
            }
        }

    }

    public int func_4025_d()
    {
        return 3;
    }

    public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_)
    {
        return super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_242_c()
    {
        return false;
    }

    public int func_210_f()
    {
        return 27;
    }
}
