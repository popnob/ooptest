// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;

// Referenced classes of package net.minecraft.src:
//            World

public class IsoImageBuffer
{

    public BufferedImage field_1348_a;
    public World field_1347_b;
    public int field_1354_c;
    public int field_1353_d;
    public boolean field_1352_e;
    public boolean field_1351_f;
    public int field_1350_g;
    public boolean field_1349_h;

    public IsoImageBuffer(World p_i462_1_, int p_i462_2_, int p_i462_3_)
    {
        field_1352_e = false;
        field_1351_f = false;
        field_1350_g = 0;
        field_1349_h = false;
        field_1347_b = p_i462_1_;
        func_889_a(p_i462_2_, p_i462_3_);
    }

    public void func_889_a(int p_889_1_, int p_889_2_)
    {
        field_1352_e = false;
        field_1354_c = p_889_1_;
        field_1353_d = p_889_2_;
        field_1350_g = 0;
        field_1349_h = false;
    }

    public void func_888_a(World p_888_1_, int p_888_2_, int p_888_3_)
    {
        field_1347_b = p_888_1_;
        func_889_a(p_888_2_, p_888_3_);
    }
}
