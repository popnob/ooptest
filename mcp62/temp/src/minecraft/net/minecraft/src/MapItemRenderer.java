// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderEngine, MapData, MapColor, GameSettings, 
//            Tessellator, MapCoord, FontRenderer, EntityPlayer

public class MapItemRenderer
{

    private int field_28159_a[];
    private int field_28158_b;
    private GameSettings field_28161_c;
    private FontRenderer field_28160_d;

    public MapItemRenderer(FontRenderer p_i741_1_, GameSettings p_i741_2_, RenderEngine p_i741_3_)
    {
        field_28159_a = new int[16384];
        field_28161_c = p_i741_2_;
        field_28160_d = p_i741_1_;
        field_28158_b = p_i741_3_.func_1074_a(new BufferedImage(128, 128, 2));
        for(int i = 0; i < 16384; i++)
        {
            field_28159_a[i] = 0;
        }

    }

    public void func_28157_a(EntityPlayer p_28157_1_, RenderEngine p_28157_2_, MapData p_28157_3_)
    {
        for(int i = 0; i < 16384; i++)
        {
            byte byte0 = p_28157_3_.field_28176_f[i];
            if(byte0 / 4 == 0)
            {
                field_28159_a[i] = (i + i / 128 & 1) * 8 + 16 << 24;
                continue;
            }
            int l = MapColor.field_28213_a[byte0 / 4].field_28198_p;
            int i1 = byte0 & 3;
            char c = '\334';
            if(i1 == 2)
            {
                c = '\377';
            }
            if(i1 == 0)
            {
                c = '\264';
            }
            int j1 = ((l >> 16 & 0xff) * c) / 255;
            int k1 = ((l >> 8 & 0xff) * c) / 255;
            int l1 = ((l & 0xff) * c) / 255;
            if(field_28161_c.field_1578_g)
            {
                int i2 = (j1 * 30 + k1 * 59 + l1 * 11) / 100;
                int j2 = (j1 * 30 + k1 * 70) / 100;
                int k2 = (j1 * 30 + l1 * 70) / 100;
                j1 = i2;
                k1 = j2;
                l1 = k2;
            }
            field_28159_a[i] = 0xff000000 | j1 << 16 | k1 << 8 | l1;
        }

        p_28157_2_.func_28150_a(field_28159_a, 128, 128, field_28158_b);
        int j = 0;
        int k = 0;
        Tessellator tessellator = Tessellator.field_1512_a;
        float f = 0.0F;
        GL11.glBindTexture(3553, field_28158_b);
        GL11.glEnable(3042);
        GL11.glBlendFunc(1, 771);
        GL11.glDisable(3008);
        tessellator.func_977_b();
        tessellator.func_983_a((float)(j + 0) + f, (float)(k + 128) - f, -0.0099999997764825821D, 0.0D, 1.0D);
        tessellator.func_983_a((float)(j + 128) - f, (float)(k + 128) - f, -0.0099999997764825821D, 1.0D, 1.0D);
        tessellator.func_983_a((float)(j + 128) - f, (float)(k + 0) + f, -0.0099999997764825821D, 1.0D, 0.0D);
        tessellator.func_983_a((float)(j + 0) + f, (float)(k + 0) + f, -0.0099999997764825821D, 0.0D, 0.0D);
        tessellator.func_982_a();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        p_28157_2_.func_1076_b(p_28157_2_.func_1070_a("/misc/mapicons.png"));
        for(Iterator iterator = p_28157_3_.field_28173_i.iterator(); iterator.hasNext(); GL11.glPopMatrix())
        {
            MapCoord mapcoord = (MapCoord)iterator.next();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)j + (float)mapcoord.field_28216_b / 2.0F + 64F, (float)k + (float)mapcoord.field_28220_c / 2.0F + 64F, -0.02F);
            GL11.glRotatef((float)(mapcoord.field_28219_d * 360) / 16F, 0.0F, 0.0F, 1.0F);
            GL11.glScalef(4F, 4F, 3F);
            GL11.glTranslatef(-0.125F, 0.125F, 0.0F);
            float f1 = (float)(mapcoord.field_28217_a % 4 + 0) / 4F;
            float f2 = (float)(mapcoord.field_28217_a / 4 + 0) / 4F;
            float f3 = (float)(mapcoord.field_28217_a % 4 + 1) / 4F;
            float f4 = (float)(mapcoord.field_28217_a / 4 + 1) / 4F;
            tessellator.func_977_b();
            tessellator.func_983_a(-1D, 1.0D, 0.0D, f1, f2);
            tessellator.func_983_a(1.0D, 1.0D, 0.0D, f3, f2);
            tessellator.func_983_a(1.0D, -1D, 0.0D, f3, f4);
            tessellator.func_983_a(-1D, -1D, 0.0D, f1, f4);
            tessellator.func_982_a();
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -0.04F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        field_28160_d.func_873_b(p_28157_3_.field_28168_a, j, k, 0xff000000);
        GL11.glPopMatrix();
    }
}
