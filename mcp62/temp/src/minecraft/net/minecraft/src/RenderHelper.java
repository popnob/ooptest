// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Vec3D, GLAllocation

public class RenderHelper
{

    private static FloatBuffer field_1695_a = GLAllocation.func_1123_d(16);

    public RenderHelper()
    {
    }

    public static void func_1159_a()
    {
        GL11.glDisable(2896);
        GL11.glDisable(16384);
        GL11.glDisable(16385);
        GL11.glDisable(2903);
    }

    public static void func_1158_b()
    {
        GL11.glEnable(2896);
        GL11.glEnable(16384);
        GL11.glEnable(16385);
        GL11.glEnable(2903);
        GL11.glColorMaterial(1032, 5634);
        float f = 0.4F;
        float f1 = 0.6F;
        float f2 = 0.0F;
        Vec3D vec3d = Vec3D.func_1248_b(0.20000000298023224D, 1.0D, -0.69999998807907104D).func_1252_b();
        GL11.glLight(16384, 4611, func_1157_a(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c, 0.0D));
        GL11.glLight(16384, 4609, func_1156_a(f1, f1, f1, 1.0F));
        GL11.glLight(16384, 4608, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16384, 4610, func_1156_a(f2, f2, f2, 1.0F));
        vec3d = Vec3D.func_1248_b(-0.20000000298023224D, 1.0D, 0.69999998807907104D).func_1252_b();
        GL11.glLight(16385, 4611, func_1157_a(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c, 0.0D));
        GL11.glLight(16385, 4609, func_1156_a(f1, f1, f1, 1.0F));
        GL11.glLight(16385, 4608, func_1156_a(0.0F, 0.0F, 0.0F, 1.0F));
        GL11.glLight(16385, 4610, func_1156_a(f2, f2, f2, 1.0F));
        GL11.glShadeModel(7424);
        GL11.glLightModel(2899, func_1156_a(f, f, f, 1.0F));
    }

    private static FloatBuffer func_1157_a(double p_1157_0_, double p_1157_2_, double p_1157_4_, double p_1157_6_)
    {
        return func_1156_a((float)p_1157_0_, (float)p_1157_2_, (float)p_1157_4_, (float)p_1157_6_);
    }

    private static FloatBuffer func_1156_a(float p_1156_0_, float p_1156_1_, float p_1156_2_, float p_1156_3_)
    {
        field_1695_a.clear();
        field_1695_a.put(p_1156_0_).put(p_1156_1_).put(p_1156_2_).put(p_1156_3_);
        field_1695_a.flip();
        return field_1695_a;
    }

    public static void func_41089_c()
    {
        GL11.glPushMatrix();
        GL11.glRotatef(-30F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(165F, 1.0F, 0.0F, 0.0F);
        func_1158_b();
        GL11.glPopMatrix();
    }

}
