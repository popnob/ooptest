// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Vec3D

public class PositionTextureVertex
{

    public Vec3D field_1655_a;
    public float field_1654_b;
    public float field_1656_c;

    public PositionTextureVertex(float p_i725_1_, float p_i725_2_, float p_i725_3_, float p_i725_4_, float p_i725_5_)
    {
        this(Vec3D.func_1260_a(p_i725_1_, p_i725_2_, p_i725_3_), p_i725_4_, p_i725_5_);
    }

    public PositionTextureVertex func_1115_a(float p_1115_1_, float p_1115_2_)
    {
        return new PositionTextureVertex(this, p_1115_1_, p_1115_2_);
    }

    public PositionTextureVertex(PositionTextureVertex p_i726_1_, float p_i726_2_, float p_i726_3_)
    {
        field_1655_a = p_i726_1_.field_1655_a;
        field_1654_b = p_i726_2_;
        field_1656_c = p_i726_3_;
    }

    public PositionTextureVertex(Vec3D p_i727_1_, float p_i727_2_, float p_i727_3_)
    {
        field_1655_a = p_i727_1_;
        field_1654_b = p_i727_2_;
        field_1656_c = p_i727_3_;
    }
}
