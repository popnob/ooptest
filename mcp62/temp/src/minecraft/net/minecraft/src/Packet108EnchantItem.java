// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet108EnchantItem extends Packet
{

    public int field_40192_a;
    public int field_40191_b;

    public Packet108EnchantItem()
    {
    }

    public Packet108EnchantItem(int p_i431_1_, int p_i431_2_)
    {
        field_40192_a = p_i431_1_;
        field_40191_b = p_i431_2_;
    }

    public void func_323_a(NetHandler p_323_1_)
    {
        p_323_1_.func_40599_a(this);
    }

    public void func_327_a(DataInputStream p_327_1_)
        throws IOException
    {
        field_40192_a = p_327_1_.readByte();
        field_40191_b = p_327_1_.readByte();
    }

    public void func_322_a(DataOutputStream p_322_1_)
        throws IOException
    {
        p_322_1_.writeByte(field_40192_a);
        p_322_1_.writeByte(field_40191_b);
    }

    public int func_329_a()
    {
        return 2;
    }
}
