// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, World, EntityPlayer

public class TileEntityEnchantmentTable extends TileEntity
{

    public int field_40068_a;
    public float field_40063_b;
    public float field_40065_c;
    public float field_40061_d;
    public float field_40062_e;
    public float field_40059_f;
    public float field_40060_g;
    public float field_40069_h;
    public float field_40067_p;
    public float field_40066_q;
    private static Random field_40064_r = new Random();

    public TileEntityEnchantmentTable()
    {
    }

    public void func_475_b()
    {
        super.func_475_b();
        field_40060_g = field_40059_f;
        field_40067_p = field_40069_h;
        EntityPlayer entityplayer = field_824_e.func_683_a((float)field_823_f + 0.5F, (float)field_822_g + 0.5F, (float)field_821_h + 0.5F, 3D);
        if(entityplayer != null)
        {
            double d = entityplayer.field_611_ak - (double)((float)field_823_f + 0.5F);
            double d1 = entityplayer.field_609_am - (double)((float)field_821_h + 0.5F);
            field_40066_q = (float)Math.atan2(d1, d);
            field_40059_f += 0.1F;
            if(field_40059_f < 0.5F || field_40064_r.nextInt(40) == 0)
            {
                float f3 = field_40061_d;
                do
                {
                    field_40061_d += field_40064_r.nextInt(4) - field_40064_r.nextInt(4);
                } while(f3 == field_40061_d);
            }
        } else
        {
            field_40066_q += 0.02F;
            field_40059_f -= 0.1F;
        }
        for(; field_40069_h >= 3.141593F; field_40069_h -= 6.283185F) { }
        for(; field_40069_h < -3.141593F; field_40069_h += 6.283185F) { }
        for(; field_40066_q >= 3.141593F; field_40066_q -= 6.283185F) { }
        for(; field_40066_q < -3.141593F; field_40066_q += 6.283185F) { }
        float f;
        for(f = field_40066_q - field_40069_h; f >= 3.141593F; f -= 6.283185F) { }
        for(; f < -3.141593F; f += 6.283185F) { }
        field_40069_h += f * 0.4F;
        if(field_40059_f < 0.0F)
        {
            field_40059_f = 0.0F;
        }
        if(field_40059_f > 1.0F)
        {
            field_40059_f = 1.0F;
        }
        field_40068_a++;
        field_40065_c = field_40063_b;
        float f1 = (field_40061_d - field_40063_b) * 0.4F;
        float f2 = 0.2F;
        if(f1 < -f2)
        {
            f1 = -f2;
        }
        if(f1 > f2)
        {
            f1 = f2;
        }
        field_40062_e += (f1 - field_40062_e) * 0.9F;
        field_40063_b = field_40063_b + field_40062_e;
    }

}
