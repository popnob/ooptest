// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TextureFX, Block, BlockPortal, MathHelper

public class TexturePortalFX extends TextureFX
{

    private int field_4227_g;
    private byte field_4226_h[][];

    public TexturePortalFX()
    {
        super(Block.field_4047_bf.field_378_bb);
        field_4227_g = 0;
        field_4226_h = new byte[32][1024];
        Random random = new Random(100L);
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                for(int k = 0; k < 16; k++)
                {
                    float f = 0.0F;
                    for(int l = 0; l < 2; l++)
                    {
                        float f1 = (float)(l * 16) * 0.5F;
                        float f2 = (float)(l * 16) * 0.5F;
                        float f3 = (((float)j - f1) / 16F) * 2.0F;
                        float f4 = (((float)k - f2) / 16F) * 2.0F;
                        if(f3 < -1F)
                        {
                            f3 += 2.0F;
                        }
                        if(f3 >= 1.0F)
                        {
                            f3 -= 2.0F;
                        }
                        if(f4 < -1F)
                        {
                            f4 += 2.0F;
                        }
                        if(f4 >= 1.0F)
                        {
                            f4 -= 2.0F;
                        }
                        float f5 = f3 * f3 + f4 * f4;
                        float f6 = (float)Math.atan2(f4, f3) + ((((float)i / 32F) * 3.141593F * 2.0F - f5 * 10F) + (float)(l * 2)) * (float)(l * 2 - 1);
                        f6 = (MathHelper.func_1106_a(f6) + 1.0F) / 2.0F;
                        f6 /= f5 + 1.0F;
                        f += f6 * 0.5F;
                    }

                    f += random.nextFloat() * 0.1F;
                    int i1 = (int)(f * 100F + 155F);
                    int j1 = (int)(f * f * 200F + 55F);
                    int k1 = (int)(f * f * f * f * 255F);
                    int l1 = (int)(f * 100F + 155F);
                    int i2 = k * 16 + j;
                    field_4226_h[i][i2 * 4 + 0] = (byte)j1;
                    field_4226_h[i][i2 * 4 + 1] = (byte)k1;
                    field_4226_h[i][i2 * 4 + 2] = (byte)i1;
                    field_4226_h[i][i2 * 4 + 3] = (byte)l1;
                }

            }

        }

    }

    public void func_783_a()
    {
        field_4227_g++;
        byte abyte0[] = field_4226_h[field_4227_g & 0x1f];
        for(int i = 0; i < 256; i++)
        {
            int j = abyte0[i * 4 + 0] & 0xff;
            int k = abyte0[i * 4 + 1] & 0xff;
            int l = abyte0[i * 4 + 2] & 0xff;
            int i1 = abyte0[i * 4 + 3] & 0xff;
            if(field_1131_c)
            {
                int j1 = (j * 30 + k * 59 + l * 11) / 100;
                int k1 = (j * 30 + k * 70) / 100;
                int l1 = (j * 30 + l * 70) / 100;
                j = j1;
                k = k1;
                l = l1;
            }
            field_1127_a[i * 4 + 0] = (byte)j;
            field_1127_a[i * 4 + 1] = (byte)k;
            field_1127_a[i * 4 + 2] = (byte)l;
            field_1127_a[i * 4 + 3] = (byte)i1;
        }

    }
}
