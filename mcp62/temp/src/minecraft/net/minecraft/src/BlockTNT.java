// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, EntityTNTPrimed, 
//            ItemStack, EntityPlayer, Item

public class BlockTNT extends Block
{

    public BlockTNT(int p_i54_1_, int p_i54_2_)
    {
        super(p_i54_1_, p_i54_2_, Material.field_1322_p);
    }

    public int func_218_a(int p_218_1_)
    {
        if(p_218_1_ == 0)
        {
            return field_378_bb + 2;
        }
        if(p_218_1_ == 1)
        {
            return field_378_bb + 1;
        } else
        {
            return field_378_bb;
        }
    }

    public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_)
    {
        super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
        if(p_235_1_.func_625_o(p_235_2_, p_235_3_, p_235_4_))
        {
            func_252_b(p_235_1_, p_235_2_, p_235_3_, p_235_4_, 1);
            p_235_1_.func_690_d(p_235_2_, p_235_3_, p_235_4_, 0);
        }
    }

    public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_)
    {
        if(p_226_5_ > 0 && Block.field_345_n[p_226_5_].func_209_d() && p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_))
        {
            func_252_b(p_226_1_, p_226_2_, p_226_3_, p_226_4_, 1);
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
        }
    }

    public int func_229_a(Random p_229_1_)
    {
        return 0;
    }

    public void func_4027_c(World p_4027_1_, int p_4027_2_, int p_4027_3_, int p_4027_4_)
    {
        if(p_4027_1_.field_1026_y)
        {
            return;
        } else
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_4027_1_, (float)p_4027_2_ + 0.5F, (float)p_4027_3_ + 0.5F, (float)p_4027_4_ + 0.5F);
            entitytntprimed.field_689_a = p_4027_1_.field_1037_n.nextInt(entitytntprimed.field_689_a / 4) + entitytntprimed.field_689_a / 8;
            p_4027_1_.func_674_a(entitytntprimed);
            return;
        }
    }

    public void func_252_b(World p_252_1_, int p_252_2_, int p_252_3_, int p_252_4_, int p_252_5_)
    {
        if(p_252_1_.field_1026_y)
        {
            return;
        }
        if((p_252_5_ & 1) == 0)
        {
            func_31027_a(p_252_1_, p_252_2_, p_252_3_, p_252_4_, new ItemStack(Block.field_408_an.field_376_bc, 1, 0));
        } else
        {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(p_252_1_, (float)p_252_2_ + 0.5F, (float)p_252_3_ + 0.5F, (float)p_252_4_ + 0.5F);
            p_252_1_.func_674_a(entitytntprimed);
            p_252_1_.func_623_a(entitytntprimed, "random.fuse", 1.0F, 1.0F);
        }
    }

    public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_)
    {
        super.func_233_b(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
    }

    public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_)
    {
        if(p_250_5_.func_6416_v() != null && p_250_5_.func_6416_v().field_1617_c == Item.field_4014_g.field_291_aS)
        {
            func_252_b(p_250_1_, p_250_2_, p_250_3_, p_250_4_, 1);
            p_250_1_.func_690_d(p_250_2_, p_250_3_, p_250_4_, 0);
            return true;
        } else
        {
            return super.func_250_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_, p_250_5_);
        }
    }

    protected ItemStack func_41049_c_(int p_41049_1_)
    {
        return null;
    }
}
