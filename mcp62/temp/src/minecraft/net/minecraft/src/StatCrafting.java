// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            StatBase

public class StatCrafting extends StatBase
{

    private final int field_25073_a;

    public StatCrafting(int p_i143_1_, String p_i143_2_, int p_i143_3_)
    {
        super(p_i143_1_, p_i143_2_);
        field_25073_a = p_i143_3_;
    }

    public int func_25072_b()
    {
        return field_25073_a;
    }
}
