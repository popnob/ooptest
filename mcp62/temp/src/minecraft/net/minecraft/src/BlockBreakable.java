// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, IBlockAccess, Material

public class BlockBreakable extends Block
{

    private boolean field_6363_a;

    protected BlockBreakable(int p_i350_1_, int p_i350_2_, Material p_i350_3_, boolean p_i350_4_)
    {
        super(p_i350_1_, p_i350_2_, p_i350_3_);
        field_6363_a = p_i350_4_;
    }

    public boolean func_217_b()
    {
        return false;
    }

    public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_)
    {
        int i = p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_);
        if(!field_6363_a && i == field_376_bc)
        {
            return false;
        } else
        {
            return super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
        }
    }
}
