// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ClippingHelper
{

    public float field_1688_a[][];
    public float field_1687_b[];
    public float field_1690_c[];
    public float field_1689_d[];

    public ClippingHelper()
    {
        field_1688_a = new float[16][16];
        field_1687_b = new float[16];
        field_1690_c = new float[16];
        field_1689_d = new float[16];
    }

    public boolean func_1152_a(double p_1152_1_, double p_1152_3_, double p_1152_5_, double p_1152_7_, double p_1152_9_, double p_1152_11_)
    {
        for(int i = 0; i < 6; i++)
        {
            if((double)field_1688_a[i][0] * p_1152_1_ + (double)field_1688_a[i][1] * p_1152_3_ + (double)field_1688_a[i][2] * p_1152_5_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_7_ + (double)field_1688_a[i][1] * p_1152_3_ + (double)field_1688_a[i][2] * p_1152_5_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_1_ + (double)field_1688_a[i][1] * p_1152_9_ + (double)field_1688_a[i][2] * p_1152_5_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_7_ + (double)field_1688_a[i][1] * p_1152_9_ + (double)field_1688_a[i][2] * p_1152_5_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_1_ + (double)field_1688_a[i][1] * p_1152_3_ + (double)field_1688_a[i][2] * p_1152_11_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_7_ + (double)field_1688_a[i][1] * p_1152_3_ + (double)field_1688_a[i][2] * p_1152_11_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_1_ + (double)field_1688_a[i][1] * p_1152_9_ + (double)field_1688_a[i][2] * p_1152_11_ + (double)field_1688_a[i][3] <= 0.0D && (double)field_1688_a[i][0] * p_1152_7_ + (double)field_1688_a[i][1] * p_1152_9_ + (double)field_1688_a[i][2] * p_1152_11_ + (double)field_1688_a[i][3] <= 0.0D)
            {
                return false;
            }
        }

        return true;
    }
}
