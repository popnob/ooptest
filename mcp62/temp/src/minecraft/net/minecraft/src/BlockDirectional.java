// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Block, Material

public abstract class BlockDirectional extends Block
{

    protected BlockDirectional(int p_i1083_1_, int p_i1083_2_, Material p_i1083_3_)
    {
        super(p_i1083_1_, p_i1083_2_, p_i1083_3_);
    }

    protected BlockDirectional(int p_i1084_1_, Material p_i1084_2_)
    {
        super(p_i1084_1_, p_i1084_2_);
    }

    public static int func_48216_a(int p_48216_0_)
    {
        return p_48216_0_ & 3;
    }
}
