// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Block, BlockRail, BlockDragonEgg, BlockFence, 
//            BlockPane, BlockFenceGate, BlockCauldron, BlockBrewingStand, 
//            IBlockAccess, BlockEndPortalFrame, Tessellator, BlockBed, 
//            Direction, EntityRenderer, BlockRedstoneRepeater, BlockPistonBase, 
//            BlockPistonExtension, Vec3D, BlockFire, BlockRedstoneWire, 
//            BlockStem, BlockFluid, MathHelper, Material, 
//            BlockDirectional, BlockDoor, BlockGrass, ChestItemRenderHelper, 
//            World

public class RenderBlocks
{

    public IBlockAccess field_1772_a;
    private int field_1771_b;
    private boolean field_1774_c;
    private boolean field_1773_d;
    public static boolean field_27406_a = true;
    public boolean field_31088_b;
    private int field_31087_g;
    private int field_31086_h;
    private int field_31085_i;
    private int field_31084_j;
    private int field_31083_k;
    private int field_31082_l;
    private boolean field_22385_e;
    private float field_22384_f;
    private float field_22383_g;
    private float field_22382_h;
    private float field_22381_i;
    private float field_22380_j;
    private float field_22379_k;
    private float field_22378_l;
    private float field_22377_m;
    private float field_22376_n;
    private float field_22375_o;
    private float field_22374_p;
    private float field_22373_q;
    private float field_22372_r;
    private float field_22371_s;
    private float field_22370_t;
    private float field_22369_u;
    private float field_22368_v;
    private float field_22367_w;
    private float field_22366_x;
    private float field_22365_y;
    private float field_22364_z;
    private float field_22362_A;
    private float field_22360_B;
    private float field_22358_C;
    private float field_22356_D;
    private float field_22354_E;
    private float field_22353_F;
    private int field_35936_P;
    private int field_35935_Q;
    private int field_35938_R;
    private int field_35937_S;
    private int field_35932_T;
    private int field_35931_U;
    private int field_35934_V;
    private int field_35933_W;
    private int field_35940_X;
    private int field_35939_Y;
    private int field_35941_Z;
    private int field_35951_aa;
    private int field_35952_ab;
    private int field_35949_ac;
    private int field_35950_ad;
    private int field_35955_ae;
    private int field_35956_af;
    private int field_35953_ag;
    private int field_35954_ah;
    private int field_35945_ai;
    private int field_35946_aj;
    private int field_35943_ak;
    private int field_35944_al;
    private int field_35947_am;
    private int field_35948_an;
    private float field_22351_H;
    private float field_22350_I;
    private float field_22349_J;
    private float field_22348_K;
    private float field_22347_L;
    private float field_22346_M;
    private float field_22345_N;
    private float field_22344_O;
    private float field_22343_P;
    private float field_22342_Q;
    private float field_22341_R;
    private float field_22340_S;
    private boolean field_22339_T;
    private boolean field_22338_U;
    private boolean field_22337_V;
    private boolean field_22336_W;
    private boolean field_22335_X;
    private boolean field_22334_Y;
    private boolean field_22333_Z;
    private boolean field_22363_aa;
    private boolean field_22361_ab;
    private boolean field_22359_ac;
    private boolean field_22357_ad;
    private boolean field_22355_ae;

    public RenderBlocks(IBlockAccess p_i647_1_)
    {
        field_1771_b = -1;
        field_1774_c = false;
        field_1773_d = false;
        field_31088_b = true;
        field_31087_g = 0;
        field_31086_h = 0;
        field_31085_i = 0;
        field_31084_j = 0;
        field_31083_k = 0;
        field_31082_l = 0;
        field_35946_aj = 1;
        field_1772_a = p_i647_1_;
    }

    public RenderBlocks()
    {
        field_1771_b = -1;
        field_1774_c = false;
        field_1773_d = false;
        field_31088_b = true;
        field_31087_g = 0;
        field_31086_h = 0;
        field_31085_i = 0;
        field_31084_j = 0;
        field_31083_k = 0;
        field_31082_l = 0;
        field_35946_aj = 1;
    }

    public void func_40727_a()
    {
        field_1771_b = -1;
    }

    public void func_1223_a(Block p_1223_1_, int p_1223_2_, int p_1223_3_, int p_1223_4_, int p_1223_5_)
    {
        field_1771_b = p_1223_5_;
        func_1234_a(p_1223_1_, p_1223_2_, p_1223_3_, p_1223_4_);
        field_1771_b = -1;
    }

    public void func_31075_a(Block p_31075_1_, int p_31075_2_, int p_31075_3_, int p_31075_4_)
    {
        field_1773_d = true;
        func_1234_a(p_31075_1_, p_31075_2_, p_31075_3_, p_31075_4_);
        field_1773_d = false;
    }

    public boolean func_1234_a(Block p_1234_1_, int p_1234_2_, int p_1234_3_, int p_1234_4_)
    {
        int i = p_1234_1_.func_210_f();
        p_1234_1_.func_238_a(field_1772_a, p_1234_2_, p_1234_3_, p_1234_4_);
        if(i == 0)
        {
            return func_1228_k(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 4)
        {
            return func_1222_j(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 13)
        {
            return func_1233_l(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 1)
        {
            return func_1226_h(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 19)
        {
            return func_1232_i(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 23)
        {
            return func_40726_m(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 6)
        {
            return func_35930_l(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 2)
        {
            return func_1241_b(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 3)
        {
            return func_1235_d(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 5)
        {
            return func_1242_e(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 8)
        {
            return func_1221_g(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 7)
        {
            return func_1218_o(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 9)
        {
            return func_1216_f((BlockRail)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 10)
        {
            return func_1214_n(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 27)
        {
            return func_41088_a((BlockDragonEgg)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 11)
        {
            return func_35925_a((BlockFence)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 12)
        {
            return func_1229_c(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 14)
        {
            return func_22331_p(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 15)
        {
            return func_22332_q(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 16)
        {
            return func_31074_b(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_, false);
        }
        if(i == 17)
        {
            return func_31080_c(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_, true);
        }
        if(i == 18)
        {
            return func_35922_a((BlockPane)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 20)
        {
            return func_35929_i(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 21)
        {
            return func_35923_a((BlockFenceGate)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 24)
        {
            return func_40728_a((BlockCauldron)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 25)
        {
            return func_40730_a((BlockBrewingStand)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        }
        if(i == 26)
        {
            return func_40729_s(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_);
        } else
        {
            return false;
        }
    }

    private boolean func_40729_s(Block p_40729_1_, int p_40729_2_, int p_40729_3_, int p_40729_4_)
    {
        int i = field_1772_a.func_602_e(p_40729_2_, p_40729_3_, p_40729_4_);
        int j = i & 3;
        if(j == 0)
        {
            field_31083_k = 3;
        } else
        if(j == 3)
        {
            field_31083_k = 1;
        } else
        if(j == 1)
        {
            field_31083_k = 2;
        }
        if(!BlockEndPortalFrame.func_40212_d(i))
        {
            p_40729_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
            func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
            p_40729_1_.func_237_e();
            field_31083_k = 0;
            return true;
        } else
        {
            p_40729_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
            func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
            field_1771_b = 174;
            p_40729_1_.func_213_a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
            func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
            func_40727_a();
            p_40729_1_.func_237_e();
            field_31083_k = 0;
            return true;
        }
    }

    private boolean func_22331_p(Block p_22331_1_, int p_22331_2_, int p_22331_3_, int p_22331_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = field_1772_a.func_602_e(p_22331_2_, p_22331_3_, p_22331_4_);
        int j = BlockBed.func_48216_a(i);
        boolean flag = BlockBed.func_22032_d(i);
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f1;
        float f5 = f1;
        float f6 = f1;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f;
        float f14 = f2;
        float f15 = f3;
        int k = p_22331_1_.func_35275_c(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_);
        tessellator.func_35835_b(k);
        tessellator.func_987_a(f7, f10, f13);
        int l = p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 0);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d = (float)i1 / 256F;
        double d1 = ((double)(i1 + 16) - 0.01D) / 256D;
        double d2 = (float)j1 / 256F;
        double d3 = ((double)(j1 + 16) - 0.01D) / 256D;
        double d4 = (double)p_22331_2_ + p_22331_1_.field_370_bf;
        double d5 = (double)p_22331_2_ + p_22331_1_.field_364_bi;
        double d6 = (double)p_22331_3_ + p_22331_1_.field_368_bg + 0.1875D;
        double d7 = (double)p_22331_4_ + p_22331_1_.field_366_bh;
        double d8 = (double)p_22331_4_ + p_22331_1_.field_360_bk;
        tessellator.func_983_a(d4, d6, d8, d, d3);
        tessellator.func_983_a(d4, d6, d7, d, d2);
        tessellator.func_983_a(d5, d6, d7, d1, d2);
        tessellator.func_983_a(d5, d6, d8, d1, d3);
        tessellator.func_35835_b(p_22331_1_.func_35275_c(field_1772_a, p_22331_2_, p_22331_3_ + 1, p_22331_4_));
        tessellator.func_987_a(f4, f5, f6);
        l = p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 1);
        i1 = (l & 0xf) << 4;
        j1 = l & 0xf0;
        d = (float)i1 / 256F;
        d1 = ((double)(i1 + 16) - 0.01D) / 256D;
        d2 = (float)j1 / 256F;
        d3 = ((double)(j1 + 16) - 0.01D) / 256D;
        d4 = d;
        d5 = d1;
        d6 = d2;
        d7 = d2;
        d8 = d;
        double d9 = d1;
        double d10 = d3;
        double d11 = d3;
        if(j == 0)
        {
            d5 = d;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        } else
        if(j == 2)
        {
            d4 = d1;
            d7 = d3;
            d9 = d;
            d10 = d2;
        } else
        if(j == 3)
        {
            d4 = d1;
            d7 = d3;
            d9 = d;
            d10 = d2;
            d5 = d;
            d6 = d3;
            d8 = d1;
            d11 = d2;
        }
        double d12 = (double)p_22331_2_ + p_22331_1_.field_370_bf;
        double d13 = (double)p_22331_2_ + p_22331_1_.field_364_bi;
        double d14 = (double)p_22331_3_ + p_22331_1_.field_362_bj;
        double d15 = (double)p_22331_4_ + p_22331_1_.field_366_bh;
        double d16 = (double)p_22331_4_ + p_22331_1_.field_360_bk;
        tessellator.func_983_a(d13, d14, d16, d8, d10);
        tessellator.func_983_a(d13, d14, d15, d4, d6);
        tessellator.func_983_a(d12, d14, d15, d5, d7);
        tessellator.func_983_a(d12, d14, d16, d9, d11);
        l = Direction.field_22280_a[j];
        if(flag)
        {
            l = Direction.field_22280_a[Direction.field_22279_b[j]];
        }
        i1 = 4;
        switch(j)
        {
        case 0: // '\0'
            i1 = 5;
            break;

        case 3: // '\003'
            i1 = 2;
            break;

        case 1: // '\001'
            i1 = 3;
            break;
        }
        if(l != 2 && (field_1773_d || p_22331_1_.func_260_c(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ - 1, 2)))
        {
            tessellator.func_35835_b(p_22331_1_.field_366_bh <= 0.0D ? p_22331_1_.func_35275_c(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ - 1) : k);
            tessellator.func_987_a(f8, f11, f14);
            field_1774_c = i1 == 2;
            func_1220_c(p_22331_1_, p_22331_2_, p_22331_3_, p_22331_4_, p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 2));
        }
        if(l != 3 && (field_1773_d || p_22331_1_.func_260_c(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ + 1, 3)))
        {
            tessellator.func_35835_b(p_22331_1_.field_360_bk >= 1.0D ? p_22331_1_.func_35275_c(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ + 1) : k);
            tessellator.func_987_a(f8, f11, f14);
            field_1774_c = i1 == 3;
            func_1225_d(p_22331_1_, p_22331_2_, p_22331_3_, p_22331_4_, p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 3));
        }
        if(l != 4 && (field_1773_d || p_22331_1_.func_260_c(field_1772_a, p_22331_2_ - 1, p_22331_3_, p_22331_4_, 4)))
        {
            tessellator.func_35835_b(p_22331_1_.field_366_bh <= 0.0D ? p_22331_1_.func_35275_c(field_1772_a, p_22331_2_ - 1, p_22331_3_, p_22331_4_) : k);
            tessellator.func_987_a(f9, f12, f15);
            field_1774_c = i1 == 4;
            func_1231_e(p_22331_1_, p_22331_2_, p_22331_3_, p_22331_4_, p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 4));
        }
        if(l != 5 && (field_1773_d || p_22331_1_.func_260_c(field_1772_a, p_22331_2_ + 1, p_22331_3_, p_22331_4_, 5)))
        {
            tessellator.func_35835_b(p_22331_1_.field_360_bk >= 1.0D ? p_22331_1_.func_35275_c(field_1772_a, p_22331_2_ + 1, p_22331_3_, p_22331_4_) : k);
            tessellator.func_987_a(f9, f12, f15);
            field_1774_c = i1 == 5;
            func_1236_f(p_22331_1_, p_22331_2_, p_22331_3_, p_22331_4_, p_22331_1_.func_211_a(field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 5));
        }
        field_1774_c = false;
        return true;
    }

    private boolean func_40730_a(BlockBrewingStand p_40730_1_, int p_40730_2_, int p_40730_3_, int p_40730_4_)
    {
        p_40730_1_.func_213_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
        func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
        field_1771_b = 156;
        p_40730_1_.func_213_a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
        func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
        p_40730_1_.func_213_a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
        func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
        p_40730_1_.func_213_a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
        func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
        func_40727_a();
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_40730_1_.func_35275_c(field_1772_a, p_40730_2_, p_40730_3_, p_40730_4_));
        float f = 1.0F;
        int i = p_40730_1_.func_207_d(field_1772_a, p_40730_2_, p_40730_3_, p_40730_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_987_a(f * f1, f * f2, f * f3);
        int j = p_40730_1_.func_232_a(0, 0);
        if(field_1771_b >= 0)
        {
            j = field_1771_b;
        }
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)l / 256F;
        double d1 = ((float)l + 15.99F) / 256F;
        int i1 = field_1772_a.func_602_e(p_40730_2_, p_40730_3_, p_40730_4_);
        for(int j1 = 0; j1 < 3; j1++)
        {
            double d2 = ((double)j1 * 3.1415926535897931D * 2D) / 3D + 1.5707963267948966D;
            double d3 = ((float)k + 8F) / 256F;
            double d4 = ((float)k + 15.99F) / 256F;
            if((i1 & 1 << j1) != 0)
            {
                d3 = ((float)k + 7.99F) / 256F;
                d4 = ((float)k + 0.0F) / 256F;
            }
            double d5 = (double)p_40730_2_ + 0.5D;
            double d6 = (double)p_40730_2_ + 0.5D + (Math.sin(d2) * 8D) / 16D;
            double d7 = (double)p_40730_4_ + 0.5D;
            double d8 = (double)p_40730_4_ + 0.5D + (Math.cos(d2) * 8D) / 16D;
            tessellator.func_983_a(d5, p_40730_3_ + 1, d7, d3, d);
            tessellator.func_983_a(d5, p_40730_3_ + 0, d7, d3, d1);
            tessellator.func_983_a(d6, p_40730_3_ + 0, d8, d4, d1);
            tessellator.func_983_a(d6, p_40730_3_ + 1, d8, d4, d);
            tessellator.func_983_a(d6, p_40730_3_ + 1, d8, d4, d);
            tessellator.func_983_a(d6, p_40730_3_ + 0, d8, d4, d1);
            tessellator.func_983_a(d5, p_40730_3_ + 0, d7, d3, d1);
            tessellator.func_983_a(d5, p_40730_3_ + 1, d7, d3, d);
        }

        p_40730_1_.func_237_e();
        return true;
    }

    private boolean func_40728_a(BlockCauldron p_40728_1_, int p_40728_2_, int p_40728_3_, int p_40728_4_)
    {
        func_1228_k(p_40728_1_, p_40728_2_, p_40728_3_, p_40728_4_);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_40728_1_.func_35275_c(field_1772_a, p_40728_2_, p_40728_3_, p_40728_4_));
        float f = 1.0F;
        int i = p_40728_1_.func_207_d(field_1772_a, p_40728_2_, p_40728_3_, p_40728_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f7 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f7;
        }
        tessellator.func_987_a(f * f1, f * f2, f * f3);
        char c = '\232';
        float f6 = 0.125F;
        func_1236_f(p_40728_1_, ((float)p_40728_2_ - 1.0F) + f6, p_40728_3_, p_40728_4_, c);
        func_1231_e(p_40728_1_, ((float)p_40728_2_ + 1.0F) - f6, p_40728_3_, p_40728_4_, c);
        func_1225_d(p_40728_1_, p_40728_2_, p_40728_3_, ((float)p_40728_4_ - 1.0F) + f6, c);
        func_1220_c(p_40728_1_, p_40728_2_, p_40728_3_, ((float)p_40728_4_ + 1.0F) - f6, c);
        char c1 = '\213';
        func_1217_b(p_40728_1_, p_40728_2_, ((float)p_40728_3_ - 1.0F) + 0.25F, p_40728_4_, c1);
        func_1244_a(p_40728_1_, p_40728_2_, ((float)p_40728_3_ + 1.0F) - 0.75F, p_40728_4_, c1);
        int j = field_1772_a.func_602_e(p_40728_2_, p_40728_3_, p_40728_4_);
        if(j > 0)
        {
            char c2 = '\315';
            if(j > 3)
            {
                j = 3;
            }
            func_1217_b(p_40728_1_, p_40728_2_, ((float)p_40728_3_ - 1.0F) + (6F + (float)j * 3F) / 16F, p_40728_4_, c2);
        }
        return true;
    }

    public boolean func_1241_b(Block p_1241_1_, int p_1241_2_, int p_1241_3_, int p_1241_4_)
    {
        int i = field_1772_a.func_602_e(p_1241_2_, p_1241_3_, p_1241_4_);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_1241_1_.func_35275_c(field_1772_a, p_1241_2_, p_1241_3_, p_1241_4_));
        tessellator.func_987_a(1.0F, 1.0F, 1.0F);
        double d = 0.40000000596046448D;
        double d1 = 0.5D - d;
        double d2 = 0.20000000298023224D;
        if(i == 1)
        {
            func_1237_a(p_1241_1_, (double)p_1241_2_ - d1, (double)p_1241_3_ + d2, p_1241_4_, -d, 0.0D);
        } else
        if(i == 2)
        {
            func_1237_a(p_1241_1_, (double)p_1241_2_ + d1, (double)p_1241_3_ + d2, p_1241_4_, d, 0.0D);
        } else
        if(i == 3)
        {
            func_1237_a(p_1241_1_, p_1241_2_, (double)p_1241_3_ + d2, (double)p_1241_4_ - d1, 0.0D, -d);
        } else
        if(i == 4)
        {
            func_1237_a(p_1241_1_, p_1241_2_, (double)p_1241_3_ + d2, (double)p_1241_4_ + d1, 0.0D, d);
        } else
        {
            func_1237_a(p_1241_1_, p_1241_2_, p_1241_3_, p_1241_4_, 0.0D, 0.0D);
        }
        return true;
    }

    private boolean func_22332_q(Block p_22332_1_, int p_22332_2_, int p_22332_3_, int p_22332_4_)
    {
        int i = field_1772_a.func_602_e(p_22332_2_, p_22332_3_, p_22332_4_);
        int j = i & 3;
        int k = (i & 0xc) >> 2;
        func_1228_k(p_22332_1_, p_22332_2_, p_22332_3_, p_22332_4_);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_22332_1_.func_35275_c(field_1772_a, p_22332_2_, p_22332_3_, p_22332_4_));
        tessellator.func_987_a(1.0F, 1.0F, 1.0F);
        double d = -0.1875D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        switch(j)
        {
        case 0: // '\0'
            d4 = -0.3125D;
            d2 = BlockRedstoneRepeater.field_22024_a[k];
            break;

        case 2: // '\002'
            d4 = 0.3125D;
            d2 = -BlockRedstoneRepeater.field_22024_a[k];
            break;

        case 3: // '\003'
            d3 = -0.3125D;
            d1 = BlockRedstoneRepeater.field_22024_a[k];
            break;

        case 1: // '\001'
            d3 = 0.3125D;
            d1 = -BlockRedstoneRepeater.field_22024_a[k];
            break;
        }
        func_1237_a(p_22332_1_, (double)p_22332_2_ + d1, (double)p_22332_3_ + d, (double)p_22332_4_ + d2, 0.0D, 0.0D);
        func_1237_a(p_22332_1_, (double)p_22332_2_ + d3, (double)p_22332_3_ + d, (double)p_22332_4_ + d4, 0.0D, 0.0D);
        int l = p_22332_1_.func_218_a(1);
        int i1 = (l & 0xf) << 4;
        int j1 = l & 0xf0;
        double d5 = (float)i1 / 256F;
        double d6 = ((float)i1 + 15.99F) / 256F;
        double d7 = (float)j1 / 256F;
        double d8 = ((float)j1 + 15.99F) / 256F;
        double d9 = 0.125D;
        double d10 = p_22332_2_ + 1;
        double d11 = p_22332_2_ + 1;
        double d12 = p_22332_2_ + 0;
        double d13 = p_22332_2_ + 0;
        double d14 = p_22332_4_ + 0;
        double d15 = p_22332_4_ + 1;
        double d16 = p_22332_4_ + 1;
        double d17 = p_22332_4_ + 0;
        double d18 = (double)p_22332_3_ + d9;
        if(j == 2)
        {
            d10 = d11 = p_22332_2_ + 0;
            d12 = d13 = p_22332_2_ + 1;
            d14 = d17 = p_22332_4_ + 1;
            d15 = d16 = p_22332_4_ + 0;
        } else
        if(j == 3)
        {
            d10 = d13 = p_22332_2_ + 0;
            d11 = d12 = p_22332_2_ + 1;
            d14 = d15 = p_22332_4_ + 0;
            d16 = d17 = p_22332_4_ + 1;
        } else
        if(j == 1)
        {
            d10 = d13 = p_22332_2_ + 1;
            d11 = d12 = p_22332_2_ + 0;
            d14 = d15 = p_22332_4_ + 1;
            d16 = d17 = p_22332_4_ + 0;
        }
        tessellator.func_983_a(d13, d18, d17, d5, d7);
        tessellator.func_983_a(d12, d18, d16, d5, d8);
        tessellator.func_983_a(d11, d18, d15, d6, d8);
        tessellator.func_983_a(d10, d18, d14, d6, d7);
        return true;
    }

    public void func_31078_d(Block p_31078_1_, int p_31078_2_, int p_31078_3_, int p_31078_4_)
    {
        field_1773_d = true;
        func_31074_b(p_31078_1_, p_31078_2_, p_31078_3_, p_31078_4_, true);
        field_1773_d = false;
    }

    private boolean func_31074_b(Block p_31074_1_, int p_31074_2_, int p_31074_3_, int p_31074_4_, boolean p_31074_5_)
    {
        int i = field_1772_a.func_602_e(p_31074_2_, p_31074_3_, p_31074_4_);
        boolean flag = p_31074_5_ || (i & 8) != 0;
        int j = BlockPistonBase.func_31044_d(i);
        if(flag)
        {
            switch(j)
            {
            case 0: // '\0'
                field_31087_g = 3;
                field_31086_h = 3;
                field_31085_i = 3;
                field_31084_j = 3;
                p_31074_1_.func_213_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 1: // '\001'
                p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
                break;

            case 2: // '\002'
                field_31085_i = 1;
                field_31084_j = 2;
                p_31074_1_.func_213_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
                break;

            case 3: // '\003'
                field_31085_i = 2;
                field_31084_j = 1;
                field_31083_k = 3;
                field_31082_l = 3;
                p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
                break;

            case 4: // '\004'
                field_31087_g = 1;
                field_31086_h = 2;
                field_31083_k = 2;
                field_31082_l = 1;
                p_31074_1_.func_213_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 5: // '\005'
                field_31087_g = 2;
                field_31086_h = 1;
                field_31083_k = 1;
                field_31082_l = 2;
                p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
                break;
            }
            func_1228_k(p_31074_1_, p_31074_2_, p_31074_3_, p_31074_4_);
            field_31087_g = 0;
            field_31086_h = 0;
            field_31085_i = 0;
            field_31084_j = 0;
            field_31083_k = 0;
            field_31082_l = 0;
            p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        {
            switch(j)
            {
            case 0: // '\0'
                field_31087_g = 3;
                field_31086_h = 3;
                field_31085_i = 3;
                field_31084_j = 3;
                break;

            case 2: // '\002'
                field_31085_i = 1;
                field_31084_j = 2;
                break;

            case 3: // '\003'
                field_31085_i = 2;
                field_31084_j = 1;
                field_31083_k = 3;
                field_31082_l = 3;
                break;

            case 4: // '\004'
                field_31087_g = 1;
                field_31086_h = 2;
                field_31083_k = 2;
                field_31082_l = 1;
                break;

            case 5: // '\005'
                field_31087_g = 2;
                field_31086_h = 1;
                field_31083_k = 1;
                field_31082_l = 2;
                break;
            }
            func_1228_k(p_31074_1_, p_31074_2_, p_31074_3_, p_31074_4_);
            field_31087_g = 0;
            field_31086_h = 0;
            field_31085_i = 0;
            field_31084_j = 0;
            field_31083_k = 0;
            field_31082_l = 0;
        }
        return true;
    }

    private void func_31076_a(double p_31076_1_, double p_31076_3_, double p_31076_5_, double p_31076_7_, double p_31076_9_, double p_31076_11_, float p_31076_13_, double p_31076_14_)
    {
        int i = 108;
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_1512_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_31076_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_987_a(p_31076_13_, p_31076_13_, p_31076_13_);
        tessellator.func_983_a(p_31076_1_, p_31076_7_, p_31076_9_, d2, d1);
        tessellator.func_983_a(p_31076_1_, p_31076_5_, p_31076_9_, d, d1);
        tessellator.func_983_a(p_31076_3_, p_31076_5_, p_31076_11_, d, d3);
        tessellator.func_983_a(p_31076_3_, p_31076_7_, p_31076_11_, d2, d3);
    }

    private void func_31081_b(double p_31081_1_, double p_31081_3_, double p_31081_5_, double p_31081_7_, double p_31081_9_, double p_31081_11_, float p_31081_13_, double p_31081_14_)
    {
        int i = 108;
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_1512_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_31081_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_987_a(p_31081_13_, p_31081_13_, p_31081_13_);
        tessellator.func_983_a(p_31081_1_, p_31081_5_, p_31081_11_, d2, d1);
        tessellator.func_983_a(p_31081_1_, p_31081_5_, p_31081_9_, d, d1);
        tessellator.func_983_a(p_31081_3_, p_31081_7_, p_31081_9_, d, d3);
        tessellator.func_983_a(p_31081_3_, p_31081_7_, p_31081_11_, d2, d3);
    }

    private void func_31077_c(double p_31077_1_, double p_31077_3_, double p_31077_5_, double p_31077_7_, double p_31077_9_, double p_31077_11_, float p_31077_13_, double p_31077_14_)
    {
        int i = 108;
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        Tessellator tessellator = Tessellator.field_1512_a;
        double d = (float)(j + 0) / 256F;
        double d1 = (float)(k + 0) / 256F;
        double d2 = (((double)j + p_31077_14_) - 0.01D) / 256D;
        double d3 = ((double)((float)k + 4F) - 0.01D) / 256D;
        tessellator.func_987_a(p_31077_13_, p_31077_13_, p_31077_13_);
        tessellator.func_983_a(p_31077_3_, p_31077_5_, p_31077_9_, d2, d1);
        tessellator.func_983_a(p_31077_1_, p_31077_5_, p_31077_9_, d, d1);
        tessellator.func_983_a(p_31077_1_, p_31077_7_, p_31077_11_, d, d3);
        tessellator.func_983_a(p_31077_3_, p_31077_7_, p_31077_11_, d2, d3);
    }

    public void func_31079_a(Block p_31079_1_, int p_31079_2_, int p_31079_3_, int p_31079_4_, boolean p_31079_5_)
    {
        field_1773_d = true;
        func_31080_c(p_31079_1_, p_31079_2_, p_31079_3_, p_31079_4_, p_31079_5_);
        field_1773_d = false;
    }

    private boolean func_31080_c(Block p_31080_1_, int p_31080_2_, int p_31080_3_, int p_31080_4_, boolean p_31080_5_)
    {
        int i = field_1772_a.func_602_e(p_31080_2_, p_31080_3_, p_31080_4_);
        int j = BlockPistonExtension.func_31050_c(i);
        float f = p_31080_1_.func_241_c(field_1772_a, p_31080_2_, p_31080_3_, p_31080_4_);
        float f1 = p_31080_5_ ? 1.0F : 0.5F;
        double d = p_31080_5_ ? 16D : 8D;
        switch(j)
        {
        case 0: // '\0'
            field_31087_g = 3;
            field_31086_h = 3;
            field_31085_i = 3;
            field_31084_j = 3;
            p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31076_a((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.25F, (float)p_31080_3_ + 0.25F + f1, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.625F, f * 0.8F, d);
            func_31076_a((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.25F, (float)p_31080_3_ + 0.25F + f1, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.375F, f * 0.8F, d);
            func_31076_a((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.25F, (float)p_31080_3_ + 0.25F + f1, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.625F, f * 0.6F, d);
            func_31076_a((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.25F, (float)p_31080_3_ + 0.25F + f1, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.375F, f * 0.6F, d);
            break;

        case 1: // '\001'
            p_31080_1_.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31076_a((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.625F, (((float)p_31080_3_ - 0.25F) + 1.0F) - f1, ((float)p_31080_3_ - 0.25F) + 1.0F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.625F, f * 0.8F, d);
            func_31076_a((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.375F, (((float)p_31080_3_ - 0.25F) + 1.0F) - f1, ((float)p_31080_3_ - 0.25F) + 1.0F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.375F, f * 0.8F, d);
            func_31076_a((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.375F, (((float)p_31080_3_ - 0.25F) + 1.0F) - f1, ((float)p_31080_3_ - 0.25F) + 1.0F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.625F, f * 0.6F, d);
            func_31076_a((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.625F, (((float)p_31080_3_ - 0.25F) + 1.0F) - f1, ((float)p_31080_3_ - 0.25F) + 1.0F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.375F, f * 0.6F, d);
            break;

        case 2: // '\002'
            field_31085_i = 1;
            field_31084_j = 2;
            p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31081_b((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.25F, (float)p_31080_4_ + 0.25F + f1, f * 0.6F, d);
            func_31081_b((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.25F, (float)p_31080_4_ + 0.25F + f1, f * 0.6F, d);
            func_31081_b((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.25F, (float)p_31080_4_ + 0.25F + f1, f * 0.5F, d);
            func_31081_b((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.25F, (float)p_31080_4_ + 0.25F + f1, f, d);
            break;

        case 3: // '\003'
            field_31085_i = 2;
            field_31084_j = 1;
            field_31083_k = 3;
            field_31082_l = 3;
            p_31080_1_.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31081_b((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.375F, (((float)p_31080_4_ - 0.25F) + 1.0F) - f1, ((float)p_31080_4_ - 0.25F) + 1.0F, f * 0.6F, d);
            func_31081_b((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.625F, (((float)p_31080_4_ - 0.25F) + 1.0F) - f1, ((float)p_31080_4_ - 0.25F) + 1.0F, f * 0.6F, d);
            func_31081_b((float)p_31080_2_ + 0.375F, (float)p_31080_2_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.375F, (((float)p_31080_4_ - 0.25F) + 1.0F) - f1, ((float)p_31080_4_ - 0.25F) + 1.0F, f * 0.5F, d);
            func_31081_b((float)p_31080_2_ + 0.625F, (float)p_31080_2_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.625F, (((float)p_31080_4_ - 0.25F) + 1.0F) - f1, ((float)p_31080_4_ - 0.25F) + 1.0F, f, d);
            break;

        case 4: // '\004'
            field_31087_g = 1;
            field_31086_h = 2;
            field_31083_k = 2;
            field_31082_l = 1;
            p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31077_c((float)p_31080_2_ + 0.25F, (float)p_31080_2_ + 0.25F + f1, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.375F, f * 0.5F, d);
            func_31077_c((float)p_31080_2_ + 0.25F, (float)p_31080_2_ + 0.25F + f1, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.625F, f, d);
            func_31077_c((float)p_31080_2_ + 0.25F, (float)p_31080_2_ + 0.25F + f1, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.375F, f * 0.6F, d);
            func_31077_c((float)p_31080_2_ + 0.25F, (float)p_31080_2_ + 0.25F + f1, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.625F, f * 0.6F, d);
            break;

        case 5: // '\005'
            field_31087_g = 2;
            field_31086_h = 1;
            field_31083_k = 1;
            field_31082_l = 2;
            p_31080_1_.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
            func_31077_c((((float)p_31080_2_ - 0.25F) + 1.0F) - f1, ((float)p_31080_2_ - 0.25F) + 1.0F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.375F, f * 0.5F, d);
            func_31077_c((((float)p_31080_2_ - 0.25F) + 1.0F) - f1, ((float)p_31080_2_ - 0.25F) + 1.0F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.625F, f, d);
            func_31077_c((((float)p_31080_2_ - 0.25F) + 1.0F) - f1, ((float)p_31080_2_ - 0.25F) + 1.0F, (float)p_31080_3_ + 0.375F, (float)p_31080_3_ + 0.625F, (float)p_31080_4_ + 0.375F, (float)p_31080_4_ + 0.375F, f * 0.6F, d);
            func_31077_c((((float)p_31080_2_ - 0.25F) + 1.0F) - f1, ((float)p_31080_2_ - 0.25F) + 1.0F, (float)p_31080_3_ + 0.625F, (float)p_31080_3_ + 0.375F, (float)p_31080_4_ + 0.625F, (float)p_31080_4_ + 0.625F, f * 0.6F, d);
            break;
        }
        field_31087_g = 0;
        field_31086_h = 0;
        field_31085_i = 0;
        field_31084_j = 0;
        field_31083_k = 0;
        field_31082_l = 0;
        p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean func_1229_c(Block p_1229_1_, int p_1229_2_, int p_1229_3_, int p_1229_4_)
    {
        int i = field_1772_a.func_602_e(p_1229_2_, p_1229_3_, p_1229_4_);
        int j = i & 7;
        boolean flag = (i & 8) > 0;
        Tessellator tessellator = Tessellator.field_1512_a;
        boolean flag1 = field_1771_b >= 0;
        if(!flag1)
        {
            field_1771_b = Block.field_335_x.field_378_bb;
        }
        float f = 0.25F;
        float f1 = 0.1875F;
        float f2 = 0.1875F;
        if(j == 5)
        {
            p_1229_1_.func_213_a(0.5F - f1, 0.0F, 0.5F - f, 0.5F + f1, f2, 0.5F + f);
        } else
        if(j == 6)
        {
            p_1229_1_.func_213_a(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, f2, 0.5F + f1);
        } else
        if(j == 4)
        {
            p_1229_1_.func_213_a(0.5F - f1, 0.5F - f, 1.0F - f2, 0.5F + f1, 0.5F + f, 1.0F);
        } else
        if(j == 3)
        {
            p_1229_1_.func_213_a(0.5F - f1, 0.5F - f, 0.0F, 0.5F + f1, 0.5F + f, f2);
        } else
        if(j == 2)
        {
            p_1229_1_.func_213_a(1.0F - f2, 0.5F - f, 0.5F - f1, 1.0F, 0.5F + f, 0.5F + f1);
        } else
        if(j == 1)
        {
            p_1229_1_.func_213_a(0.0F, 0.5F - f, 0.5F - f1, f2, 0.5F + f, 0.5F + f1);
        }
        func_1228_k(p_1229_1_, p_1229_2_, p_1229_3_, p_1229_4_);
        if(!flag1)
        {
            field_1771_b = -1;
        }
        tessellator.func_35835_b(p_1229_1_.func_35275_c(field_1772_a, p_1229_2_, p_1229_3_, p_1229_4_));
        float f3 = 1.0F;
        if(Block.field_339_t[p_1229_1_.field_376_bc] > 0)
        {
            f3 = 1.0F;
        }
        tessellator.func_987_a(f3, f3, f3);
        int k = p_1229_1_.func_218_a(0);
        if(field_1771_b >= 0)
        {
            k = field_1771_b;
        }
        int l = (k & 0xf) << 4;
        int i1 = k & 0xf0;
        float f4 = (float)l / 256F;
        float f5 = ((float)l + 15.99F) / 256F;
        float f6 = (float)i1 / 256F;
        float f7 = ((float)i1 + 15.99F) / 256F;
        Vec3D avec3d[] = new Vec3D[8];
        float f8 = 0.0625F;
        float f9 = 0.0625F;
        float f10 = 0.625F;
        avec3d[0] = Vec3D.func_1248_b(-f8, 0.0D, -f9);
        avec3d[1] = Vec3D.func_1248_b(f8, 0.0D, -f9);
        avec3d[2] = Vec3D.func_1248_b(f8, 0.0D, f9);
        avec3d[3] = Vec3D.func_1248_b(-f8, 0.0D, f9);
        avec3d[4] = Vec3D.func_1248_b(-f8, f10, -f9);
        avec3d[5] = Vec3D.func_1248_b(f8, f10, -f9);
        avec3d[6] = Vec3D.func_1248_b(f8, f10, f9);
        avec3d[7] = Vec3D.func_1248_b(-f8, f10, f9);
        for(int j1 = 0; j1 < 8; j1++)
        {
            if(flag)
            {
                avec3d[j1].field_1779_c -= 0.0625D;
                avec3d[j1].func_1258_a(0.6981317F);
            } else
            {
                avec3d[j1].field_1779_c += 0.0625D;
                avec3d[j1].func_1258_a(-0.6981317F);
            }
            if(j == 6)
            {
                avec3d[j1].func_1249_b(1.570796F);
            }
            if(j < 5)
            {
                avec3d[j1].field_1775_b -= 0.375D;
                avec3d[j1].func_1258_a(1.570796F);
                if(j == 4)
                {
                    avec3d[j1].func_1249_b(0.0F);
                }
                if(j == 3)
                {
                    avec3d[j1].func_1249_b(3.141593F);
                }
                if(j == 2)
                {
                    avec3d[j1].func_1249_b(1.570796F);
                }
                if(j == 1)
                {
                    avec3d[j1].func_1249_b(-1.570796F);
                }
                avec3d[j1].field_1776_a += (double)p_1229_2_ + 0.5D;
                avec3d[j1].field_1775_b += (float)p_1229_3_ + 0.5F;
                avec3d[j1].field_1779_c += (double)p_1229_4_ + 0.5D;
            } else
            {
                avec3d[j1].field_1776_a += (double)p_1229_2_ + 0.5D;
                avec3d[j1].field_1775_b += (float)p_1229_3_ + 0.125F;
                avec3d[j1].field_1779_c += (double)p_1229_4_ + 0.5D;
            }
        }

        Vec3D vec3d = null;
        Vec3D vec3d1 = null;
        Vec3D vec3d2 = null;
        Vec3D vec3d3 = null;
        for(int k1 = 0; k1 < 6; k1++)
        {
            if(k1 == 0)
            {
                f4 = (float)(l + 7) / 256F;
                f5 = ((float)(l + 9) - 0.01F) / 256F;
                f6 = (float)(i1 + 6) / 256F;
                f7 = ((float)(i1 + 8) - 0.01F) / 256F;
            } else
            if(k1 == 2)
            {
                f4 = (float)(l + 7) / 256F;
                f5 = ((float)(l + 9) - 0.01F) / 256F;
                f6 = (float)(i1 + 6) / 256F;
                f7 = ((float)(i1 + 16) - 0.01F) / 256F;
            }
            if(k1 == 0)
            {
                vec3d = avec3d[0];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[2];
                vec3d3 = avec3d[3];
            } else
            if(k1 == 1)
            {
                vec3d = avec3d[7];
                vec3d1 = avec3d[6];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[4];
            } else
            if(k1 == 2)
            {
                vec3d = avec3d[1];
                vec3d1 = avec3d[0];
                vec3d2 = avec3d[4];
                vec3d3 = avec3d[5];
            } else
            if(k1 == 3)
            {
                vec3d = avec3d[2];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[6];
            } else
            if(k1 == 4)
            {
                vec3d = avec3d[3];
                vec3d1 = avec3d[2];
                vec3d2 = avec3d[6];
                vec3d3 = avec3d[7];
            } else
            if(k1 == 5)
            {
                vec3d = avec3d[0];
                vec3d1 = avec3d[3];
                vec3d2 = avec3d[7];
                vec3d3 = avec3d[4];
            }
            tessellator.func_983_a(vec3d.field_1776_a, vec3d.field_1775_b, vec3d.field_1779_c, f4, f7);
            tessellator.func_983_a(vec3d1.field_1776_a, vec3d1.field_1775_b, vec3d1.field_1779_c, f5, f7);
            tessellator.func_983_a(vec3d2.field_1776_a, vec3d2.field_1775_b, vec3d2.field_1779_c, f5, f6);
            tessellator.func_983_a(vec3d3.field_1776_a, vec3d3.field_1775_b, vec3d3.field_1779_c, f4, f6);
        }

        return true;
    }

    public boolean func_1235_d(Block p_1235_1_, int p_1235_2_, int p_1235_3_, int p_1235_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1235_1_.func_218_a(0);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        tessellator.func_987_a(1.0F, 1.0F, 1.0F);
        tessellator.func_35835_b(p_1235_1_.func_35275_c(field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_));
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d2 = ((float)j + 15.99F) / 256F;
        double d4 = (float)k / 256F;
        double d6 = ((float)k + 15.99F) / 256F;
        float f = 1.4F;
        if(field_1772_a.func_28100_h(p_1235_2_, p_1235_3_ - 1, p_1235_4_) || Block.field_402_as.func_261_b(field_1772_a, p_1235_2_, p_1235_3_ - 1, p_1235_4_))
        {
            double d8 = (double)p_1235_2_ + 0.5D + 0.20000000000000001D;
            double d9 = ((double)p_1235_2_ + 0.5D) - 0.20000000000000001D;
            double d12 = (double)p_1235_4_ + 0.5D + 0.20000000000000001D;
            double d14 = ((double)p_1235_4_ + 0.5D) - 0.20000000000000001D;
            double d16 = ((double)p_1235_2_ + 0.5D) - 0.29999999999999999D;
            double d18 = (double)p_1235_2_ + 0.5D + 0.29999999999999999D;
            double d20 = ((double)p_1235_4_ + 0.5D) - 0.29999999999999999D;
            double d22 = (double)p_1235_4_ + 0.5D + 0.29999999999999999D;
            tessellator.func_983_a(d16, (float)p_1235_3_ + f, p_1235_4_ + 1, d2, d4);
            tessellator.func_983_a(d8, p_1235_3_ + 0, p_1235_4_ + 1, d2, d6);
            tessellator.func_983_a(d8, p_1235_3_ + 0, p_1235_4_ + 0, d, d6);
            tessellator.func_983_a(d16, (float)p_1235_3_ + f, p_1235_4_ + 0, d, d4);
            tessellator.func_983_a(d18, (float)p_1235_3_ + f, p_1235_4_ + 0, d2, d4);
            tessellator.func_983_a(d9, p_1235_3_ + 0, p_1235_4_ + 0, d2, d6);
            tessellator.func_983_a(d9, p_1235_3_ + 0, p_1235_4_ + 1, d, d6);
            tessellator.func_983_a(d18, (float)p_1235_3_ + f, p_1235_4_ + 1, d, d4);
            d = (float)j / 256F;
            d2 = ((float)j + 15.99F) / 256F;
            d4 = (float)(k + 16) / 256F;
            d6 = ((float)k + 15.99F + 16F) / 256F;
            tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f, d22, d2, d4);
            tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d14, d2, d6);
            tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d14, d, d6);
            tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f, d22, d, d4);
            tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f, d20, d2, d4);
            tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d12, d2, d6);
            tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d12, d, d6);
            tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f, d20, d, d4);
            d8 = ((double)p_1235_2_ + 0.5D) - 0.5D;
            d9 = (double)p_1235_2_ + 0.5D + 0.5D;
            d12 = ((double)p_1235_4_ + 0.5D) - 0.5D;
            d14 = (double)p_1235_4_ + 0.5D + 0.5D;
            d16 = ((double)p_1235_2_ + 0.5D) - 0.40000000000000002D;
            d18 = (double)p_1235_2_ + 0.5D + 0.40000000000000002D;
            d20 = ((double)p_1235_4_ + 0.5D) - 0.40000000000000002D;
            d22 = (double)p_1235_4_ + 0.5D + 0.40000000000000002D;
            tessellator.func_983_a(d16, (float)p_1235_3_ + f, p_1235_4_ + 0, d, d4);
            tessellator.func_983_a(d8, p_1235_3_ + 0, p_1235_4_ + 0, d, d6);
            tessellator.func_983_a(d8, p_1235_3_ + 0, p_1235_4_ + 1, d2, d6);
            tessellator.func_983_a(d16, (float)p_1235_3_ + f, p_1235_4_ + 1, d2, d4);
            tessellator.func_983_a(d18, (float)p_1235_3_ + f, p_1235_4_ + 1, d, d4);
            tessellator.func_983_a(d9, p_1235_3_ + 0, p_1235_4_ + 1, d, d6);
            tessellator.func_983_a(d9, p_1235_3_ + 0, p_1235_4_ + 0, d2, d6);
            tessellator.func_983_a(d18, (float)p_1235_3_ + f, p_1235_4_ + 0, d2, d4);
            d = (float)j / 256F;
            d2 = ((float)j + 15.99F) / 256F;
            d4 = (float)k / 256F;
            d6 = ((float)k + 15.99F) / 256F;
            tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f, d22, d, d4);
            tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d14, d, d6);
            tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d14, d2, d6);
            tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f, d22, d2, d4);
            tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f, d20, d, d4);
            tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d12, d, d6);
            tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d12, d2, d6);
            tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f, d20, d2, d4);
        } else
        {
            float f2 = 0.2F;
            float f3 = 0.0625F;
            if((p_1235_2_ + p_1235_3_ + p_1235_4_ & 1) == 1)
            {
                d = (float)j / 256F;
                d2 = ((float)j + 15.99F) / 256F;
                d4 = (float)(k + 16) / 256F;
                d6 = ((float)k + 15.99F + 16F) / 256F;
            }
            if((p_1235_2_ / 2 + p_1235_3_ / 2 + p_1235_4_ / 2 & 1) == 1)
            {
                double d10 = d2;
                d2 = d;
                d = d10;
            }
            if(Block.field_402_as.func_261_b(field_1772_a, p_1235_2_ - 1, p_1235_3_, p_1235_4_))
            {
                tessellator.func_983_a((float)p_1235_2_ + f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 1, d2, d4);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 1, d2, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a((float)p_1235_2_ + f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 0, d, d4);
                tessellator.func_983_a((float)p_1235_2_ + f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 0, d, d4);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 1, d2, d6);
                tessellator.func_983_a((float)p_1235_2_ + f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 1, d2, d4);
            }
            if(Block.field_402_as.func_261_b(field_1772_a, p_1235_2_ + 1, p_1235_3_, p_1235_4_))
            {
                tessellator.func_983_a((float)(p_1235_2_ + 1) - f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 0, d, d4);
                tessellator.func_983_a((p_1235_2_ + 1) - 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a((p_1235_2_ + 1) - 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 1, d2, d6);
                tessellator.func_983_a((float)(p_1235_2_ + 1) - f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 1, d2, d4);
                tessellator.func_983_a((float)(p_1235_2_ + 1) - f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 1, d2, d4);
                tessellator.func_983_a((p_1235_2_ + 1) - 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 1, d2, d6);
                tessellator.func_983_a((p_1235_2_ + 1) - 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a((float)(p_1235_2_ + 1) - f2, (float)p_1235_3_ + f + f3, p_1235_4_ + 0, d, d4);
            }
            if(Block.field_402_as.func_261_b(field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_ - 1))
            {
                tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f + f3, (float)p_1235_4_ + f2, d2, d4);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d2, d6);
                tessellator.func_983_a(p_1235_2_ + 1, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f + f3, (float)p_1235_4_ + f2, d, d4);
                tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f + f3, (float)p_1235_4_ + f2, d, d4);
                tessellator.func_983_a(p_1235_2_ + 1, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, p_1235_4_ + 0, d2, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f + f3, (float)p_1235_4_ + f2, d2, d4);
            }
            if(Block.field_402_as.func_261_b(field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_ + 1))
            {
                tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f + f3, (float)(p_1235_4_ + 1) - f2, d, d4);
                tessellator.func_983_a(p_1235_2_ + 1, (float)(p_1235_3_ + 0) + f3, (p_1235_4_ + 1) - 0, d, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, (p_1235_4_ + 1) - 0, d2, d6);
                tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f + f3, (float)(p_1235_4_ + 1) - f2, d2, d4);
                tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f + f3, (float)(p_1235_4_ + 1) - f2, d2, d4);
                tessellator.func_983_a(p_1235_2_ + 0, (float)(p_1235_3_ + 0) + f3, (p_1235_4_ + 1) - 0, d2, d6);
                tessellator.func_983_a(p_1235_2_ + 1, (float)(p_1235_3_ + 0) + f3, (p_1235_4_ + 1) - 0, d, d6);
                tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f + f3, (float)(p_1235_4_ + 1) - f2, d, d4);
            }
            if(Block.field_402_as.func_261_b(field_1772_a, p_1235_2_, p_1235_3_ + 1, p_1235_4_))
            {
                double d11 = (double)p_1235_2_ + 0.5D + 0.5D;
                double d13 = ((double)p_1235_2_ + 0.5D) - 0.5D;
                double d15 = (double)p_1235_4_ + 0.5D + 0.5D;
                double d17 = ((double)p_1235_4_ + 0.5D) - 0.5D;
                double d19 = ((double)p_1235_2_ + 0.5D) - 0.5D;
                double d21 = (double)p_1235_2_ + 0.5D + 0.5D;
                double d23 = ((double)p_1235_4_ + 0.5D) - 0.5D;
                double d24 = (double)p_1235_4_ + 0.5D + 0.5D;
                double d1 = (float)j / 256F;
                double d3 = ((float)j + 15.99F) / 256F;
                double d5 = (float)k / 256F;
                double d7 = ((float)k + 15.99F) / 256F;
                p_1235_3_++;
                float f1 = -0.2F;
                if((p_1235_2_ + p_1235_3_ + p_1235_4_ & 1) == 0)
                {
                    tessellator.func_983_a(d19, (float)p_1235_3_ + f1, p_1235_4_ + 0, d3, d5);
                    tessellator.func_983_a(d11, p_1235_3_ + 0, p_1235_4_ + 0, d3, d7);
                    tessellator.func_983_a(d11, p_1235_3_ + 0, p_1235_4_ + 1, d1, d7);
                    tessellator.func_983_a(d19, (float)p_1235_3_ + f1, p_1235_4_ + 1, d1, d5);
                    d1 = (float)j / 256F;
                    d3 = ((float)j + 15.99F) / 256F;
                    d5 = (float)(k + 16) / 256F;
                    d7 = ((float)k + 15.99F + 16F) / 256F;
                    tessellator.func_983_a(d21, (float)p_1235_3_ + f1, p_1235_4_ + 1, d3, d5);
                    tessellator.func_983_a(d13, p_1235_3_ + 0, p_1235_4_ + 1, d3, d7);
                    tessellator.func_983_a(d13, p_1235_3_ + 0, p_1235_4_ + 0, d1, d7);
                    tessellator.func_983_a(d21, (float)p_1235_3_ + f1, p_1235_4_ + 0, d1, d5);
                } else
                {
                    tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f1, d24, d3, d5);
                    tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d17, d3, d7);
                    tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d17, d1, d7);
                    tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f1, d24, d1, d5);
                    d1 = (float)j / 256F;
                    d3 = ((float)j + 15.99F) / 256F;
                    d5 = (float)(k + 16) / 256F;
                    d7 = ((float)k + 15.99F + 16F) / 256F;
                    tessellator.func_983_a(p_1235_2_ + 1, (float)p_1235_3_ + f1, d23, d3, d5);
                    tessellator.func_983_a(p_1235_2_ + 1, p_1235_3_ + 0, d15, d3, d7);
                    tessellator.func_983_a(p_1235_2_ + 0, p_1235_3_ + 0, d15, d1, d7);
                    tessellator.func_983_a(p_1235_2_ + 0, (float)p_1235_3_ + f1, d23, d1, d5);
                }
            }
        }
        return true;
    }

    public boolean func_1242_e(Block p_1242_1_, int p_1242_2_, int p_1242_3_, int p_1242_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = field_1772_a.func_602_e(p_1242_2_, p_1242_3_, p_1242_4_);
        int j = p_1242_1_.func_232_a(1, i);
        if(field_1771_b >= 0)
        {
            j = field_1771_b;
        }
        tessellator.func_35835_b(p_1242_1_.func_35275_c(field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_));
        float f = 1.0F;
        float f1 = (float)i / 15F;
        float f2 = f1 * 0.6F + 0.4F;
        if(i == 0)
        {
            f2 = 0.3F;
        }
        float f3 = f1 * f1 * 0.7F - 0.5F;
        float f4 = f1 * f1 * 0.6F - 0.7F;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f4 < 0.0F)
        {
            f4 = 0.0F;
        }
        tessellator.func_987_a(f2, f3, f4);
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)k / 256F;
        double d2 = ((float)k + 15.99F) / 256F;
        double d4 = (float)l / 256F;
        double d6 = ((float)l + 15.99F) / 256F;
        boolean flag = BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ - 1, p_1242_3_, p_1242_4_, 1) || !field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ - 1, p_1242_3_ - 1, p_1242_4_, -1);
        boolean flag1 = BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ + 1, p_1242_3_, p_1242_4_, 3) || !field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ + 1, p_1242_3_ - 1, p_1242_4_, -1);
        boolean flag2 = BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_ - 1, 2) || !field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_ - 1, p_1242_4_ - 1, -1);
        boolean flag3 = BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_ + 1, 0) || !field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_ - 1, p_1242_4_ + 1, -1);
        if(!field_1772_a.func_28100_h(p_1242_2_, p_1242_3_ + 1, p_1242_4_))
        {
            if(field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ - 1, p_1242_3_ + 1, p_1242_4_, -1))
            {
                flag = true;
            }
            if(field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_ + 1, p_1242_3_ + 1, p_1242_4_, -1))
            {
                flag1 = true;
            }
            if(field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_ + 1, p_1242_4_ - 1, -1))
            {
                flag2 = true;
            }
            if(field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && BlockRedstoneWire.func_279_b(field_1772_a, p_1242_2_, p_1242_3_ + 1, p_1242_4_ + 1, -1))
            {
                flag3 = true;
            }
        }
        float f5 = p_1242_2_ + 0;
        float f6 = p_1242_2_ + 1;
        float f7 = p_1242_4_ + 0;
        float f8 = p_1242_4_ + 1;
        byte byte0 = 0;
        if((flag || flag1) && !flag2 && !flag3)
        {
            byte0 = 1;
        }
        if((flag2 || flag3) && !flag1 && !flag)
        {
            byte0 = 2;
        }
        if(byte0 != 0)
        {
            d = (float)(k + 16) / 256F;
            d2 = ((float)(k + 16) + 15.99F) / 256F;
            d4 = (float)l / 256F;
            d6 = ((float)l + 15.99F) / 256F;
        }
        if(byte0 == 0)
        {
            if(!flag)
            {
                f5 += 0.3125F;
            }
            if(!flag)
            {
                d += 0.01953125D;
            }
            if(!flag1)
            {
                f6 -= 0.3125F;
            }
            if(!flag1)
            {
                d2 -= 0.01953125D;
            }
            if(!flag2)
            {
                f7 += 0.3125F;
            }
            if(!flag2)
            {
                d4 += 0.01953125D;
            }
            if(!flag3)
            {
                f8 -= 0.3125F;
            }
            if(!flag3)
            {
                d6 -= 0.01953125D;
            }
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d2, d4);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d, d6);
            tessellator.func_987_a(f, f, f);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6 + 0.0625D);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d2, d4 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d, d6 + 0.0625D);
        } else
        if(byte0 == 1)
        {
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d2, d4);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d, d6);
            tessellator.func_987_a(f, f, f);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6 + 0.0625D);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d2, d4 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d, d6 + 0.0625D);
        } else
        if(byte0 == 2)
        {
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d, d6);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d2, d4);
            tessellator.func_987_a(f, f, f);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f8, d2, d6 + 0.0625D);
            tessellator.func_983_a(f6, (double)p_1242_3_ + 0.015625D, f7, d, d6 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f7, d, d4 + 0.0625D);
            tessellator.func_983_a(f5, (double)p_1242_3_ + 0.015625D, f8, d2, d4 + 0.0625D);
        }
        if(!field_1772_a.func_28100_h(p_1242_2_, p_1242_3_ + 1, p_1242_4_))
        {
            double d1 = (float)(k + 16) / 256F;
            double d3 = ((float)(k + 16) + 15.99F) / 256F;
            double d5 = (float)l / 256F;
            double d7 = ((float)l + 15.99F) / 256F;
            if(field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && field_1772_a.func_600_a(p_1242_2_ - 1, p_1242_3_ + 1, p_1242_4_) == Block.field_394_aw.field_376_bc)
            {
                tessellator.func_987_a(f * f2, f * f3, f * f4);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 1, d3, d5);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, p_1242_3_ + 0, p_1242_4_ + 1, d1, d5);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, p_1242_3_ + 0, p_1242_4_ + 0, d1, d7);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 0, d3, d7);
                tessellator.func_987_a(f, f, f);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 1, d3, d5 + 0.0625D);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, p_1242_3_ + 0, p_1242_4_ + 1, d1, d5 + 0.0625D);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, p_1242_3_ + 0, p_1242_4_ + 0, d1, d7 + 0.0625D);
                tessellator.func_983_a((double)p_1242_2_ + 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 0, d3, d7 + 0.0625D);
            }
            if(field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && field_1772_a.func_600_a(p_1242_2_ + 1, p_1242_3_ + 1, p_1242_4_) == Block.field_394_aw.field_376_bc)
            {
                tessellator.func_987_a(f * f2, f * f3, f * f4);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, p_1242_3_ + 0, p_1242_4_ + 1, d1, d7);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 1, d3, d7);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 0, d3, d5);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, p_1242_3_ + 0, p_1242_4_ + 0, d1, d5);
                tessellator.func_987_a(f, f, f);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, p_1242_3_ + 0, p_1242_4_ + 1, d1, d7 + 0.0625D);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 1, d3, d7 + 0.0625D);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (float)(p_1242_3_ + 1) + 0.021875F, p_1242_4_ + 0, d3, d5 + 0.0625D);
                tessellator.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, p_1242_3_ + 0, p_1242_4_ + 0, d1, d5 + 0.0625D);
            }
            if(field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && field_1772_a.func_600_a(p_1242_2_, p_1242_3_ + 1, p_1242_4_ - 1) == Block.field_394_aw.field_376_bc)
            {
                tessellator.func_987_a(f * f2, f * f3, f * f4);
                tessellator.func_983_a(p_1242_2_ + 1, p_1242_3_ + 0, (double)p_1242_4_ + 0.015625D, d1, d7);
                tessellator.func_983_a(p_1242_2_ + 1, (float)(p_1242_3_ + 1) + 0.021875F, (double)p_1242_4_ + 0.015625D, d3, d7);
                tessellator.func_983_a(p_1242_2_ + 0, (float)(p_1242_3_ + 1) + 0.021875F, (double)p_1242_4_ + 0.015625D, d3, d5);
                tessellator.func_983_a(p_1242_2_ + 0, p_1242_3_ + 0, (double)p_1242_4_ + 0.015625D, d1, d5);
                tessellator.func_987_a(f, f, f);
                tessellator.func_983_a(p_1242_2_ + 1, p_1242_3_ + 0, (double)p_1242_4_ + 0.015625D, d1, d7 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 1, (float)(p_1242_3_ + 1) + 0.021875F, (double)p_1242_4_ + 0.015625D, d3, d7 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 0, (float)(p_1242_3_ + 1) + 0.021875F, (double)p_1242_4_ + 0.015625D, d3, d5 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 0, p_1242_3_ + 0, (double)p_1242_4_ + 0.015625D, d1, d5 + 0.0625D);
            }
            if(field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && field_1772_a.func_600_a(p_1242_2_, p_1242_3_ + 1, p_1242_4_ + 1) == Block.field_394_aw.field_376_bc)
            {
                tessellator.func_987_a(f * f2, f * f3, f * f4);
                tessellator.func_983_a(p_1242_2_ + 1, (float)(p_1242_3_ + 1) + 0.021875F, (double)(p_1242_4_ + 1) - 0.015625D, d3, d5);
                tessellator.func_983_a(p_1242_2_ + 1, p_1242_3_ + 0, (double)(p_1242_4_ + 1) - 0.015625D, d1, d5);
                tessellator.func_983_a(p_1242_2_ + 0, p_1242_3_ + 0, (double)(p_1242_4_ + 1) - 0.015625D, d1, d7);
                tessellator.func_983_a(p_1242_2_ + 0, (float)(p_1242_3_ + 1) + 0.021875F, (double)(p_1242_4_ + 1) - 0.015625D, d3, d7);
                tessellator.func_987_a(f, f, f);
                tessellator.func_983_a(p_1242_2_ + 1, (float)(p_1242_3_ + 1) + 0.021875F, (double)(p_1242_4_ + 1) - 0.015625D, d3, d5 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 1, p_1242_3_ + 0, (double)(p_1242_4_ + 1) - 0.015625D, d1, d5 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 0, p_1242_3_ + 0, (double)(p_1242_4_ + 1) - 0.015625D, d1, d7 + 0.0625D);
                tessellator.func_983_a(p_1242_2_ + 0, (float)(p_1242_3_ + 1) + 0.021875F, (double)(p_1242_4_ + 1) - 0.015625D, d3, d7 + 0.0625D);
            }
        }
        return true;
    }

    public boolean func_1216_f(BlockRail p_1216_1_, int p_1216_2_, int p_1216_3_, int p_1216_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = field_1772_a.func_602_e(p_1216_2_, p_1216_3_, p_1216_4_);
        int j = p_1216_1_.func_232_a(0, i);
        if(field_1771_b >= 0)
        {
            j = field_1771_b;
        }
        if(p_1216_1_.func_27042_h())
        {
            i &= 7;
        }
        tessellator.func_35835_b(p_1216_1_.func_35275_c(field_1772_a, p_1216_2_, p_1216_3_, p_1216_4_));
        tessellator.func_987_a(1.0F, 1.0F, 1.0F);
        int k = (j & 0xf) << 4;
        int l = j & 0xf0;
        double d = (float)k / 256F;
        double d1 = ((float)k + 15.99F) / 256F;
        double d2 = (float)l / 256F;
        double d3 = ((float)l + 15.99F) / 256F;
        double d4 = 0.0625D;
        double d5 = p_1216_2_ + 1;
        double d6 = p_1216_2_ + 1;
        double d7 = p_1216_2_ + 0;
        double d8 = p_1216_2_ + 0;
        double d9 = p_1216_4_ + 0;
        double d10 = p_1216_4_ + 1;
        double d11 = p_1216_4_ + 1;
        double d12 = p_1216_4_ + 0;
        double d13 = (double)p_1216_3_ + d4;
        double d14 = (double)p_1216_3_ + d4;
        double d15 = (double)p_1216_3_ + d4;
        double d16 = (double)p_1216_3_ + d4;
        if(i == 1 || i == 2 || i == 3 || i == 7)
        {
            d5 = d8 = p_1216_2_ + 1;
            d6 = d7 = p_1216_2_ + 0;
            d9 = d10 = p_1216_4_ + 1;
            d11 = d12 = p_1216_4_ + 0;
        } else
        if(i == 8)
        {
            d5 = d6 = p_1216_2_ + 0;
            d7 = d8 = p_1216_2_ + 1;
            d9 = d12 = p_1216_4_ + 1;
            d10 = d11 = p_1216_4_ + 0;
        } else
        if(i == 9)
        {
            d5 = d8 = p_1216_2_ + 0;
            d6 = d7 = p_1216_2_ + 1;
            d9 = d10 = p_1216_4_ + 0;
            d11 = d12 = p_1216_4_ + 1;
        }
        if(i == 2 || i == 4)
        {
            d13++;
            d16++;
        } else
        if(i == 3 || i == 5)
        {
            d14++;
            d15++;
        }
        tessellator.func_983_a(d5, d13, d9, d1, d2);
        tessellator.func_983_a(d6, d14, d10, d1, d3);
        tessellator.func_983_a(d7, d15, d11, d, d3);
        tessellator.func_983_a(d8, d16, d12, d, d2);
        tessellator.func_983_a(d8, d16, d12, d, d2);
        tessellator.func_983_a(d7, d15, d11, d, d3);
        tessellator.func_983_a(d6, d14, d10, d1, d3);
        tessellator.func_983_a(d5, d13, d9, d1, d2);
        return true;
    }

    public boolean func_1221_g(Block p_1221_1_, int p_1221_2_, int p_1221_3_, int p_1221_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1221_1_.func_218_a(0);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        tessellator.func_35835_b(p_1221_1_.func_35275_c(field_1772_a, p_1221_2_, p_1221_3_, p_1221_4_));
        float f = 1.0F;
        tessellator.func_987_a(f, f, f);
        f = (i & 0xf) << 4;
        int j = i & 0xf0;
        double d = (float)f / 256F;
        double d1 = ((float)f + 15.99F) / 256F;
        double d2 = (float)j / 256F;
        double d3 = ((float)j + 15.99F) / 256F;
        int k = field_1772_a.func_602_e(p_1221_2_, p_1221_3_, p_1221_4_);
        double d4 = 0.0D;
        double d5 = 0.05000000074505806D;
        if(k == 5)
        {
            tessellator.func_983_a((double)p_1221_2_ + d5, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 1) + d4, d, d2);
            tessellator.func_983_a((double)p_1221_2_ + d5, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 1) + d4, d, d3);
            tessellator.func_983_a((double)p_1221_2_ + d5, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 0) - d4, d1, d3);
            tessellator.func_983_a((double)p_1221_2_ + d5, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 0) - d4, d1, d2);
        }
        if(k == 4)
        {
            tessellator.func_983_a((double)(p_1221_2_ + 1) - d5, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 1) + d4, d1, d3);
            tessellator.func_983_a((double)(p_1221_2_ + 1) - d5, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 1) + d4, d1, d2);
            tessellator.func_983_a((double)(p_1221_2_ + 1) - d5, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 0) - d4, d, d2);
            tessellator.func_983_a((double)(p_1221_2_ + 1) - d5, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 0) - d4, d, d3);
        }
        if(k == 3)
        {
            tessellator.func_983_a((double)(p_1221_2_ + 1) + d4, (double)(p_1221_3_ + 0) - d4, (double)p_1221_4_ + d5, d1, d3);
            tessellator.func_983_a((double)(p_1221_2_ + 1) + d4, (double)(p_1221_3_ + 1) + d4, (double)p_1221_4_ + d5, d1, d2);
            tessellator.func_983_a((double)(p_1221_2_ + 0) - d4, (double)(p_1221_3_ + 1) + d4, (double)p_1221_4_ + d5, d, d2);
            tessellator.func_983_a((double)(p_1221_2_ + 0) - d4, (double)(p_1221_3_ + 0) - d4, (double)p_1221_4_ + d5, d, d3);
        }
        if(k == 2)
        {
            tessellator.func_983_a((double)(p_1221_2_ + 1) + d4, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 1) - d5, d, d2);
            tessellator.func_983_a((double)(p_1221_2_ + 1) + d4, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 1) - d5, d, d3);
            tessellator.func_983_a((double)(p_1221_2_ + 0) - d4, (double)(p_1221_3_ + 0) - d4, (double)(p_1221_4_ + 1) - d5, d1, d3);
            tessellator.func_983_a((double)(p_1221_2_ + 0) - d4, (double)(p_1221_3_ + 1) + d4, (double)(p_1221_4_ + 1) - d5, d1, d2);
        }
        return true;
    }

    public boolean func_35929_i(Block p_35929_1_, int p_35929_2_, int p_35929_3_, int p_35929_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_35929_1_.func_218_a(0);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        float f = 1.0F;
        tessellator.func_35835_b(p_35929_1_.func_35275_c(field_1772_a, p_35929_2_, p_35929_3_, p_35929_4_));
        int j = p_35929_1_.func_207_d(field_1772_a, p_35929_2_, p_35929_3_, p_35929_4_);
        float f1 = (float)(j >> 16 & 0xff) / 255F;
        double d = (float)(j >> 8 & 0xff) / 255F;
        float f2 = (float)(j & 0xff) / 255F;
        tessellator.func_987_a(f * f1, f * d, f * f2);
        j = (i & 0xf) << 4;
        f1 = i & 0xf0;
        d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)f1 / 256F;
        double d3 = ((float)f1 + 15.99F) / 256F;
        double d4 = 0.05000000074505806D;
        int k = field_1772_a.func_602_e(p_35929_2_, p_35929_3_, p_35929_4_);
        if((k & 2) != 0)
        {
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 1, p_35929_4_ + 1, d, d2);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 0, p_35929_4_ + 1, d, d3);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 0, p_35929_4_ + 0, d1, d3);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 1, p_35929_4_ + 0, d1, d2);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 1, p_35929_4_ + 0, d1, d2);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 0, p_35929_4_ + 0, d1, d3);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 0, p_35929_4_ + 1, d, d3);
            tessellator.func_983_a((double)p_35929_2_ + d4, p_35929_3_ + 1, p_35929_4_ + 1, d, d2);
        }
        if((k & 8) != 0)
        {
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 0, p_35929_4_ + 1, d1, d3);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 1, p_35929_4_ + 1, d1, d2);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 1, p_35929_4_ + 0, d, d2);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 0, p_35929_4_ + 0, d, d3);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 0, p_35929_4_ + 0, d, d3);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 1, p_35929_4_ + 0, d, d2);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 1, p_35929_4_ + 1, d1, d2);
            tessellator.func_983_a((double)(p_35929_2_ + 1) - d4, p_35929_3_ + 0, p_35929_4_ + 1, d1, d3);
        }
        if((k & 4) != 0)
        {
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 0, (double)p_35929_4_ + d4, d1, d3);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 1, (double)p_35929_4_ + d4, d1, d2);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 1, (double)p_35929_4_ + d4, d, d2);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 0, (double)p_35929_4_ + d4, d, d3);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 0, (double)p_35929_4_ + d4, d, d3);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 1, (double)p_35929_4_ + d4, d, d2);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 1, (double)p_35929_4_ + d4, d1, d2);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 0, (double)p_35929_4_ + d4, d1, d3);
        }
        if((k & 1) != 0)
        {
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 1, (double)(p_35929_4_ + 1) - d4, d, d2);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 0, (double)(p_35929_4_ + 1) - d4, d, d3);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 0, (double)(p_35929_4_ + 1) - d4, d1, d3);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 1, (double)(p_35929_4_ + 1) - d4, d1, d2);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 1, (double)(p_35929_4_ + 1) - d4, d1, d2);
            tessellator.func_983_a(p_35929_2_ + 0, p_35929_3_ + 0, (double)(p_35929_4_ + 1) - d4, d1, d3);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 0, (double)(p_35929_4_ + 1) - d4, d, d3);
            tessellator.func_983_a(p_35929_2_ + 1, p_35929_3_ + 1, (double)(p_35929_4_ + 1) - d4, d, d2);
        }
        if(field_1772_a.func_28100_h(p_35929_2_, p_35929_3_ + 1, p_35929_4_))
        {
            tessellator.func_983_a(p_35929_2_ + 1, (double)(p_35929_3_ + 1) - d4, p_35929_4_ + 0, d, d2);
            tessellator.func_983_a(p_35929_2_ + 1, (double)(p_35929_3_ + 1) - d4, p_35929_4_ + 1, d, d3);
            tessellator.func_983_a(p_35929_2_ + 0, (double)(p_35929_3_ + 1) - d4, p_35929_4_ + 1, d1, d3);
            tessellator.func_983_a(p_35929_2_ + 0, (double)(p_35929_3_ + 1) - d4, p_35929_4_ + 0, d1, d2);
        }
        return true;
    }

    public boolean func_35922_a(BlockPane p_35922_1_, int p_35922_2_, int p_35922_3_, int p_35922_4_)
    {
        int i = field_1772_a.func_48453_b();
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_35922_1_.func_35275_c(field_1772_a, p_35922_2_, p_35922_3_, p_35922_4_));
        float f = 1.0F;
        int j = p_35922_1_.func_207_d(field_1772_a, p_35922_2_, p_35922_3_, p_35922_4_);
        float f1 = (float)(j >> 16 & 0xff) / 255F;
        float f2 = (float)(j >> 8 & 0xff) / 255F;
        float f3 = (float)(j & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_987_a(f * f1, f * f2, f * f3);
        int k = 0;
        int l = 0;
        if(field_1771_b >= 0)
        {
            k = field_1771_b;
            l = field_1771_b;
        } else
        {
            int i1 = field_1772_a.func_602_e(p_35922_2_, p_35922_3_, p_35922_4_);
            k = p_35922_1_.func_232_a(0, i1);
            l = p_35922_1_.func_35299_s();
        }
        int j1 = (k & 0xf) << 4;
        int k1 = k & 0xf0;
        double d = (float)j1 / 256F;
        double d1 = ((float)j1 + 7.99F) / 256F;
        double d2 = ((float)j1 + 15.99F) / 256F;
        double d3 = (float)k1 / 256F;
        double d4 = ((float)k1 + 15.99F) / 256F;
        int l1 = (l & 0xf) << 4;
        int i2 = l & 0xf0;
        double d5 = (float)(l1 + 7) / 256F;
        double d6 = ((float)l1 + 8.99F) / 256F;
        double d7 = (float)i2 / 256F;
        double d8 = (float)(i2 + 8) / 256F;
        double d9 = ((float)i2 + 15.99F) / 256F;
        double d10 = p_35922_2_;
        double d11 = (double)p_35922_2_ + 0.5D;
        double d12 = p_35922_2_ + 1;
        double d13 = p_35922_4_;
        double d14 = (double)p_35922_4_ + 0.5D;
        double d15 = p_35922_4_ + 1;
        double d16 = ((double)p_35922_2_ + 0.5D) - 0.0625D;
        double d17 = (double)p_35922_2_ + 0.5D + 0.0625D;
        double d18 = ((double)p_35922_4_ + 0.5D) - 0.0625D;
        double d19 = (double)p_35922_4_ + 0.5D + 0.0625D;
        boolean flag = p_35922_1_.func_35298_d(field_1772_a.func_600_a(p_35922_2_, p_35922_3_, p_35922_4_ - 1));
        boolean flag1 = p_35922_1_.func_35298_d(field_1772_a.func_600_a(p_35922_2_, p_35922_3_, p_35922_4_ + 1));
        boolean flag2 = p_35922_1_.func_35298_d(field_1772_a.func_600_a(p_35922_2_ - 1, p_35922_3_, p_35922_4_));
        boolean flag3 = p_35922_1_.func_35298_d(field_1772_a.func_600_a(p_35922_2_ + 1, p_35922_3_, p_35922_4_));
        boolean flag4 = p_35922_1_.func_260_c(field_1772_a, p_35922_2_, p_35922_3_ + 1, p_35922_4_, 1);
        boolean flag5 = p_35922_1_.func_260_c(field_1772_a, p_35922_2_, p_35922_3_ - 1, p_35922_4_, 0);
        if(flag2 && flag3 || !flag2 && !flag3 && !flag && !flag1)
        {
            tessellator.func_983_a(d10, p_35922_3_ + 1, d14, d, d3);
            tessellator.func_983_a(d10, p_35922_3_ + 0, d14, d, d4);
            tessellator.func_983_a(d12, p_35922_3_ + 0, d14, d2, d4);
            tessellator.func_983_a(d12, p_35922_3_ + 1, d14, d2, d3);
            tessellator.func_983_a(d12, p_35922_3_ + 1, d14, d, d3);
            tessellator.func_983_a(d12, p_35922_3_ + 0, d14, d, d4);
            tessellator.func_983_a(d10, p_35922_3_ + 0, d14, d2, d4);
            tessellator.func_983_a(d10, p_35922_3_ + 1, d14, d2, d3);
            if(flag4)
            {
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
            } else
            {
                if(p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ + 1, p_35922_4_))
                {
                    tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                    tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                }
                if(p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ + 1, p_35922_4_))
                {
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
                    tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
                }
            }
            if(flag5)
            {
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d7);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d9);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d7);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d9);
            } else
            {
                if(p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ - 1, p_35922_4_))
                {
                    tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                    tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d9);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                }
                if(p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ - 1, p_35922_4_))
                {
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d7);
                    tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                    tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                    tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d7);
                }
            }
        } else
        if(flag2 && !flag3)
        {
            tessellator.func_983_a(d10, p_35922_3_ + 1, d14, d, d3);
            tessellator.func_983_a(d10, p_35922_3_ + 0, d14, d, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d1, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d, d4);
            tessellator.func_983_a(d10, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d10, p_35922_3_ + 1, d14, d1, d3);
            if(!flag1 && !flag)
            {
                tessellator.func_983_a(d11, p_35922_3_ + 1, d19, d5, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d19, d5, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d18, d6, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d18, d6, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d18, d5, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d18, d5, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d19, d6, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d19, d6, d7);
            }
            if(flag4 || p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ + 1, p_35922_4_))
            {
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d9);
                tessellator.func_983_a(d10, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d9);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
            }
            if(flag5 || p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ - 1, p_35922_4_))
            {
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d9);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d19, d6, d9);
                tessellator.func_983_a(d10, (double)p_35922_3_ - 0.01D, d18, d5, d9);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d8);
            }
        } else
        if(!flag2 && flag3)
        {
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d1, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d12, p_35922_3_ + 0, d14, d2, d4);
            tessellator.func_983_a(d12, p_35922_3_ + 1, d14, d2, d3);
            tessellator.func_983_a(d12, p_35922_3_ + 1, d14, d1, d3);
            tessellator.func_983_a(d12, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d2, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d2, d3);
            if(!flag1 && !flag)
            {
                tessellator.func_983_a(d11, p_35922_3_ + 1, d18, d5, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d18, d5, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d19, d6, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d19, d6, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d19, d5, d7);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d19, d5, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 0, d18, d6, d9);
                tessellator.func_983_a(d11, p_35922_3_ + 1, d18, d6, d7);
            }
            if(flag4 || p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ + 1, p_35922_4_))
            {
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d7);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d19, d6, d8);
                tessellator.func_983_a(d11, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d8);
                tessellator.func_983_a(d12, (double)(p_35922_3_ + 1) + 0.01D, d18, d5, d7);
            }
            if(flag5 || p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ - 1, p_35922_4_))
            {
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d7);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d19, d6, d7);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d19, d6, d8);
                tessellator.func_983_a(d11, (double)p_35922_3_ - 0.01D, d18, d5, d8);
                tessellator.func_983_a(d12, (double)p_35922_3_ - 0.01D, d18, d5, d7);
            }
        }
        if(flag && flag1 || !flag2 && !flag3 && !flag && !flag1)
        {
            tessellator.func_983_a(d11, p_35922_3_ + 1, d15, d, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d15, d, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d13, d2, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d13, d2, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d13, d, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d13, d, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d15, d2, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d15, d2, d3);
            if(flag4)
            {
                tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d5, d9);
            } else
            {
                if(p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ - 1))
                {
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d6, d7);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d8);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d8);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d5, d7);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d7);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d6, d8);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d5, d8);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d7);
                }
                if(p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ + 1))
                {
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d8);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d9);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d9);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d8);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d8);
                    tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d9);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d9);
                    tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d8);
                }
            }
            if(flag5)
            {
                tessellator.func_983_a(d17, p_35922_3_, d15, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_, d13, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_, d13, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_, d15, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_, d13, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_, d15, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_, d15, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_, d13, d5, d9);
            } else
            {
                if(p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ - 1))
                {
                    tessellator.func_983_a(d16, p_35922_3_, d13, d6, d7);
                    tessellator.func_983_a(d16, p_35922_3_, d14, d6, d8);
                    tessellator.func_983_a(d17, p_35922_3_, d14, d5, d8);
                    tessellator.func_983_a(d17, p_35922_3_, d13, d5, d7);
                    tessellator.func_983_a(d16, p_35922_3_, d14, d6, d7);
                    tessellator.func_983_a(d16, p_35922_3_, d13, d6, d8);
                    tessellator.func_983_a(d17, p_35922_3_, d13, d5, d8);
                    tessellator.func_983_a(d17, p_35922_3_, d14, d5, d7);
                }
                if(p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ + 1))
                {
                    tessellator.func_983_a(d16, p_35922_3_, d14, d5, d8);
                    tessellator.func_983_a(d16, p_35922_3_, d15, d5, d9);
                    tessellator.func_983_a(d17, p_35922_3_, d15, d6, d9);
                    tessellator.func_983_a(d17, p_35922_3_, d14, d6, d8);
                    tessellator.func_983_a(d16, p_35922_3_, d15, d5, d8);
                    tessellator.func_983_a(d16, p_35922_3_, d14, d5, d9);
                    tessellator.func_983_a(d17, p_35922_3_, d14, d6, d9);
                    tessellator.func_983_a(d17, p_35922_3_, d15, d6, d8);
                }
            }
        } else
        if(flag && !flag1)
        {
            tessellator.func_983_a(d11, p_35922_3_ + 1, d13, d, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d13, d, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d1, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d13, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d13, d1, d3);
            if(!flag3 && !flag2)
            {
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 0, d14, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 0, d14, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d7);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d7);
                tessellator.func_983_a(d17, p_35922_3_ + 0, d14, d5, d9);
                tessellator.func_983_a(d16, p_35922_3_ + 0, d14, d6, d9);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d7);
            }
            if(flag4 || p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ - 1))
            {
                tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d8);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d8);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d13, d6, d8);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d13, d5, d8);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d7);
            }
            if(flag5 || p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ - 1))
            {
                tessellator.func_983_a(d16, p_35922_3_, d13, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_, d14, d6, d8);
                tessellator.func_983_a(d17, p_35922_3_, d14, d5, d8);
                tessellator.func_983_a(d17, p_35922_3_, d13, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_, d14, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_, d13, d6, d8);
                tessellator.func_983_a(d17, p_35922_3_, d13, d5, d8);
                tessellator.func_983_a(d17, p_35922_3_, d14, d5, d7);
            }
        } else
        if(!flag && flag1)
        {
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d1, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d15, d2, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d15, d2, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d15, d1, d3);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d15, d1, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 0, d14, d2, d4);
            tessellator.func_983_a(d11, p_35922_3_ + 1, d14, d2, d3);
            if(!flag3 && !flag2)
            {
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d5, d7);
                tessellator.func_983_a(d17, p_35922_3_ + 0, d14, d5, d9);
                tessellator.func_983_a(d16, p_35922_3_ + 0, d14, d6, d9);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d6, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d7);
                tessellator.func_983_a(d16, p_35922_3_ + 0, d14, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 0, d14, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d7);
            }
            if(flag4 || p_35922_3_ < i - 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ + 1))
            {
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d8);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d8);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d15, d5, d8);
                tessellator.func_983_a(d16, p_35922_3_ + 1, d14, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d14, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_ + 1, d15, d6, d8);
            }
            if(flag5 || p_35922_3_ > 1 && field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ + 1))
            {
                tessellator.func_983_a(d16, p_35922_3_, d14, d5, d8);
                tessellator.func_983_a(d16, p_35922_3_, d15, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_, d15, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_, d14, d6, d8);
                tessellator.func_983_a(d16, p_35922_3_, d15, d5, d8);
                tessellator.func_983_a(d16, p_35922_3_, d14, d5, d9);
                tessellator.func_983_a(d17, p_35922_3_, d14, d6, d9);
                tessellator.func_983_a(d17, p_35922_3_, d15, d6, d8);
            }
        }
        return true;
    }

    public boolean func_1226_h(Block p_1226_1_, int p_1226_2_, int p_1226_3_, int p_1226_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_1226_1_.func_35275_c(field_1772_a, p_1226_2_, p_1226_3_, p_1226_4_));
        float f = 1.0F;
        int i = p_1226_1_.func_207_d(field_1772_a, p_1226_2_, p_1226_3_, p_1226_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_987_a(f * f1, f * f2, f * f3);
        double d = p_1226_2_;
        double d1 = p_1226_3_;
        double d2 = p_1226_4_;
        if(p_1226_1_ == Block.field_9257_X)
        {
            long l = (long)(p_1226_2_ * 0x2fc20f) ^ (long)p_1226_4_ * 0x6ebfff5L ^ (long)p_1226_3_;
            l = l * l * 0x285b825L + l * 11L;
            d += ((double)((float)(l >> 16 & 15L) / 15F) - 0.5D) * 0.5D;
            d1 += ((double)((float)(l >> 20 & 15L) / 15F) - 1.0D) * 0.20000000000000001D;
            d2 += ((double)((float)(l >> 24 & 15L) / 15F) - 0.5D) * 0.5D;
        }
        func_1239_a(p_1226_1_, field_1772_a.func_602_e(p_1226_2_, p_1226_3_, p_1226_4_), d, d1, d2);
        return true;
    }

    public boolean func_1232_i(Block p_1232_1_, int p_1232_2_, int p_1232_3_, int p_1232_4_)
    {
        BlockStem blockstem = (BlockStem)p_1232_1_;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(blockstem.func_35275_c(field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_));
        float f = 1.0F;
        int i = blockstem.func_207_d(field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
        float f1 = (float)(i >> 16 & 0xff) / 255F;
        float f2 = (float)(i >> 8 & 0xff) / 255F;
        float f3 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f5 = (f1 * 30F + f2 * 70F) / 100F;
            float f6 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.func_987_a(f * f1, f * f2, f * f3);
        blockstem.func_238_a(field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
        int j = blockstem.func_35296_f(field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
        if(j < 0)
        {
            func_35928_a(blockstem, field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), blockstem.field_362_bj, p_1232_2_, p_1232_3_, p_1232_4_);
        } else
        {
            func_35928_a(blockstem, field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), 0.5D, p_1232_2_, p_1232_3_, p_1232_4_);
            func_35926_a(blockstem, field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), j, blockstem.field_362_bj, p_1232_2_, p_1232_3_, p_1232_4_);
        }
        return true;
    }

    public boolean func_35930_l(Block p_35930_1_, int p_35930_2_, int p_35930_3_, int p_35930_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(p_35930_1_.func_35275_c(field_1772_a, p_35930_2_, p_35930_3_, p_35930_4_));
        tessellator.func_987_a(1.0F, 1.0F, 1.0F);
        func_1245_b(p_35930_1_, field_1772_a.func_602_e(p_35930_2_, p_35930_3_, p_35930_4_), p_35930_2_, (float)p_35930_3_ - 0.0625F, p_35930_4_);
        return true;
    }

    public void func_1237_a(Block p_1237_1_, double p_1237_2_, double p_1237_4_, double p_1237_6_, 
            double p_1237_8_, double p_1237_10_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1237_1_.func_218_a(0);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = (float)j / 256F;
        float f1 = ((float)j + 15.99F) / 256F;
        float f2 = (float)k / 256F;
        float f3 = ((float)k + 15.99F) / 256F;
        double d = (double)f + 0.02734375D;
        double d1 = (double)f2 + 0.0234375D;
        double d2 = (double)f + 0.03515625D;
        double d3 = (double)f2 + 0.03125D;
        p_1237_2_ += 0.5D;
        p_1237_6_ += 0.5D;
        double d4 = p_1237_2_ - 0.5D;
        double d5 = p_1237_2_ + 0.5D;
        double d6 = p_1237_6_ - 0.5D;
        double d7 = p_1237_6_ + 0.5D;
        double d8 = 0.0625D;
        double d9 = 0.625D;
        tessellator.func_983_a((p_1237_2_ + p_1237_8_ * (1.0D - d9)) - d8, p_1237_4_ + d9, (p_1237_6_ + p_1237_10_ * (1.0D - d9)) - d8, d, d1);
        tessellator.func_983_a((p_1237_2_ + p_1237_8_ * (1.0D - d9)) - d8, p_1237_4_ + d9, p_1237_6_ + p_1237_10_ * (1.0D - d9) + d8, d, d3);
        tessellator.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - d9) + d8, p_1237_4_ + d9, p_1237_6_ + p_1237_10_ * (1.0D - d9) + d8, d2, d3);
        tessellator.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - d9) + d8, p_1237_4_ + d9, (p_1237_6_ + p_1237_10_ * (1.0D - d9)) - d8, d2, d1);
        tessellator.func_983_a(p_1237_2_ - d8, p_1237_4_ + 1.0D, d6, f, f2);
        tessellator.func_983_a((p_1237_2_ - d8) + p_1237_8_, p_1237_4_ + 0.0D, d6 + p_1237_10_, f, f3);
        tessellator.func_983_a((p_1237_2_ - d8) + p_1237_8_, p_1237_4_ + 0.0D, d7 + p_1237_10_, f1, f3);
        tessellator.func_983_a(p_1237_2_ - d8, p_1237_4_ + 1.0D, d7, f1, f2);
        tessellator.func_983_a(p_1237_2_ + d8, p_1237_4_ + 1.0D, d7, f, f2);
        tessellator.func_983_a(p_1237_2_ + p_1237_8_ + d8, p_1237_4_ + 0.0D, d7 + p_1237_10_, f, f3);
        tessellator.func_983_a(p_1237_2_ + p_1237_8_ + d8, p_1237_4_ + 0.0D, d6 + p_1237_10_, f1, f3);
        tessellator.func_983_a(p_1237_2_ + d8, p_1237_4_ + 1.0D, d6, f1, f2);
        tessellator.func_983_a(d4, p_1237_4_ + 1.0D, p_1237_6_ + d8, f, f2);
        tessellator.func_983_a(d4 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ + d8 + p_1237_10_, f, f3);
        tessellator.func_983_a(d5 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ + d8 + p_1237_10_, f1, f3);
        tessellator.func_983_a(d5, p_1237_4_ + 1.0D, p_1237_6_ + d8, f1, f2);
        tessellator.func_983_a(d5, p_1237_4_ + 1.0D, p_1237_6_ - d8, f, f2);
        tessellator.func_983_a(d5 + p_1237_8_, p_1237_4_ + 0.0D, (p_1237_6_ - d8) + p_1237_10_, f, f3);
        tessellator.func_983_a(d4 + p_1237_8_, p_1237_4_ + 0.0D, (p_1237_6_ - d8) + p_1237_10_, f1, f3);
        tessellator.func_983_a(d4, p_1237_4_ + 1.0D, p_1237_6_ - d8, f1, f2);
    }

    public void func_1239_a(Block p_1239_1_, int p_1239_2_, double p_1239_3_, double p_1239_5_, double p_1239_7_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1239_1_.func_232_a(0, p_1239_2_);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        double d4 = (p_1239_3_ + 0.5D) - 0.45000000000000001D;
        double d5 = p_1239_3_ + 0.5D + 0.45000000000000001D;
        double d6 = (p_1239_7_ + 0.5D) - 0.45000000000000001D;
        double d7 = p_1239_7_ + 0.5D + 0.45000000000000001D;
        tessellator.func_983_a(d4, p_1239_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d4, p_1239_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d5, p_1239_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d5, p_1239_5_ + 1.0D, d7, d1, d2);
        tessellator.func_983_a(d5, p_1239_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d5, p_1239_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d4, p_1239_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d4, p_1239_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d4, p_1239_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d4, p_1239_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d5, p_1239_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d5, p_1239_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d5, p_1239_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d5, p_1239_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d4, p_1239_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d4, p_1239_5_ + 1.0D, d7, d1, d2);
    }

    public void func_35928_a(Block p_35928_1_, int p_35928_2_, double p_35928_3_, double p_35928_5_, double p_35928_7_, double p_35928_9_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_35928_1_.func_232_a(0, p_35928_2_);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((double)k + 15.989999771118164D * p_35928_3_) / 256D;
        double d4 = (p_35928_5_ + 0.5D) - 0.44999998807907104D;
        double d5 = p_35928_5_ + 0.5D + 0.44999998807907104D;
        double d6 = (p_35928_9_ + 0.5D) - 0.44999998807907104D;
        double d7 = p_35928_9_ + 0.5D + 0.44999998807907104D;
        tessellator.func_983_a(d4, p_35928_7_ + p_35928_3_, d6, d, d2);
        tessellator.func_983_a(d4, p_35928_7_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d5, p_35928_7_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d5, p_35928_7_ + p_35928_3_, d7, d1, d2);
        tessellator.func_983_a(d5, p_35928_7_ + p_35928_3_, d7, d, d2);
        tessellator.func_983_a(d5, p_35928_7_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d4, p_35928_7_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d4, p_35928_7_ + p_35928_3_, d6, d1, d2);
        tessellator.func_983_a(d4, p_35928_7_ + p_35928_3_, d7, d, d2);
        tessellator.func_983_a(d4, p_35928_7_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d5, p_35928_7_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d5, p_35928_7_ + p_35928_3_, d6, d1, d2);
        tessellator.func_983_a(d5, p_35928_7_ + p_35928_3_, d6, d, d2);
        tessellator.func_983_a(d5, p_35928_7_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d4, p_35928_7_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d4, p_35928_7_ + p_35928_3_, d7, d1, d2);
    }

    public boolean func_40726_m(Block p_40726_1_, int p_40726_2_, int p_40726_3_, int p_40726_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_40726_1_.field_378_bb;
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = 0.015625F;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        long l = (long)(p_40726_2_ * 0x2fc20f) ^ (long)p_40726_4_ * 0x6ebfff5L ^ (long)p_40726_3_;
        l = l * l * 0x285b825L + l * 11L;
        int i1 = (int)(l >> 16 & 3L);
        tessellator.func_35835_b(p_40726_1_.func_35275_c(field_1772_a, p_40726_2_, p_40726_3_, p_40726_4_));
        float f1 = (float)p_40726_2_ + 0.5F;
        float f2 = (float)p_40726_4_ + 0.5F;
        float f3 = (float)(i1 & 1) * 0.5F * (float)(1 - ((i1 / 2) % 2) * 2);
        float f4 = (float)(i1 + 1 & 1) * 0.5F * (float)(1 - (((i1 + 1) / 2) % 2) * 2);
        tessellator.func_990_b(p_40726_1_.func_35274_i());
        tessellator.func_983_a((f1 + f3) - f4, (float)p_40726_3_ + f, f2 + f3 + f4, d, d2);
        tessellator.func_983_a(f1 + f3 + f4, (float)p_40726_3_ + f, (f2 - f3) + f4, d1, d2);
        tessellator.func_983_a((f1 - f3) + f4, (float)p_40726_3_ + f, f2 - f3 - f4, d1, d3);
        tessellator.func_983_a(f1 - f3 - f4, (float)p_40726_3_ + f, (f2 + f3) - f4, d, d3);
        tessellator.func_990_b((p_40726_1_.func_35274_i() & 0xfefefe) >> 1);
        tessellator.func_983_a(f1 - f3 - f4, (float)p_40726_3_ + f, (f2 + f3) - f4, d, d3);
        tessellator.func_983_a((f1 - f3) + f4, (float)p_40726_3_ + f, f2 - f3 - f4, d1, d3);
        tessellator.func_983_a(f1 + f3 + f4, (float)p_40726_3_ + f, (f2 - f3) + f4, d1, d2);
        tessellator.func_983_a((f1 + f3) - f4, (float)p_40726_3_ + f, f2 + f3 + f4, d, d2);
        return true;
    }

    public void func_35926_a(Block p_35926_1_, int p_35926_2_, int p_35926_3_, double p_35926_4_, double p_35926_6_, 
            double p_35926_8_, double p_35926_10_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_35926_1_.func_232_a(0, p_35926_2_) + 16;
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((double)k + 15.989999771118164D * p_35926_4_) / 256D;
        double d4 = (p_35926_6_ + 0.5D) - 0.5D;
        double d5 = p_35926_6_ + 0.5D + 0.5D;
        double d6 = (p_35926_10_ + 0.5D) - 0.5D;
        double d7 = p_35926_10_ + 0.5D + 0.5D;
        double d8 = p_35926_6_ + 0.5D;
        double d9 = p_35926_10_ + 0.5D;
        if(((p_35926_3_ + 1) / 2) % 2 == 1)
        {
            double d10 = d1;
            d1 = d;
            d = d10;
        }
        if(p_35926_3_ < 2)
        {
            tessellator.func_983_a(d4, p_35926_8_ + p_35926_4_, d9, d, d2);
            tessellator.func_983_a(d4, p_35926_8_ + 0.0D, d9, d, d3);
            tessellator.func_983_a(d5, p_35926_8_ + 0.0D, d9, d1, d3);
            tessellator.func_983_a(d5, p_35926_8_ + p_35926_4_, d9, d1, d2);
            tessellator.func_983_a(d5, p_35926_8_ + p_35926_4_, d9, d1, d2);
            tessellator.func_983_a(d5, p_35926_8_ + 0.0D, d9, d1, d3);
            tessellator.func_983_a(d4, p_35926_8_ + 0.0D, d9, d, d3);
            tessellator.func_983_a(d4, p_35926_8_ + p_35926_4_, d9, d, d2);
        } else
        {
            tessellator.func_983_a(d8, p_35926_8_ + p_35926_4_, d7, d, d2);
            tessellator.func_983_a(d8, p_35926_8_ + 0.0D, d7, d, d3);
            tessellator.func_983_a(d8, p_35926_8_ + 0.0D, d6, d1, d3);
            tessellator.func_983_a(d8, p_35926_8_ + p_35926_4_, d6, d1, d2);
            tessellator.func_983_a(d8, p_35926_8_ + p_35926_4_, d6, d1, d2);
            tessellator.func_983_a(d8, p_35926_8_ + 0.0D, d6, d1, d3);
            tessellator.func_983_a(d8, p_35926_8_ + 0.0D, d7, d, d3);
            tessellator.func_983_a(d8, p_35926_8_ + p_35926_4_, d7, d, d2);
        }
    }

    public void func_1245_b(Block p_1245_1_, int p_1245_2_, double p_1245_3_, double p_1245_5_, double p_1245_7_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1245_1_.func_232_a(0, p_1245_2_);
        if(field_1771_b >= 0)
        {
            i = field_1771_b;
        }
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        double d = (float)j / 256F;
        double d1 = ((float)j + 15.99F) / 256F;
        double d2 = (float)k / 256F;
        double d3 = ((float)k + 15.99F) / 256F;
        double d4 = (p_1245_3_ + 0.5D) - 0.25D;
        double d5 = p_1245_3_ + 0.5D + 0.25D;
        double d6 = (p_1245_7_ + 0.5D) - 0.5D;
        double d7 = p_1245_7_ + 0.5D + 0.5D;
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d7, d1, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d7, d1, d2);
        d4 = (p_1245_3_ + 0.5D) - 0.5D;
        d5 = p_1245_3_ + 0.5D + 0.5D;
        d6 = (p_1245_7_ + 0.5D) - 0.25D;
        d7 = p_1245_7_ + 0.5D + 0.25D;
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d6, d, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d6, d, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d6, d1, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d6, d1, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d7, d1, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 1.0D, d7, d, d2);
        tessellator.func_983_a(d4, p_1245_5_ + 0.0D, d7, d, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 0.0D, d7, d1, d3);
        tessellator.func_983_a(d5, p_1245_5_ + 1.0D, d7, d1, d2);
    }

    public boolean func_1222_j(Block p_1222_1_, int p_1222_2_, int p_1222_3_, int p_1222_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        int i = p_1222_1_.func_207_d(field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        boolean flag = p_1222_1_.func_260_c(field_1772_a, p_1222_2_, p_1222_3_ + 1, p_1222_4_, 1);
        boolean flag1 = p_1222_1_.func_260_c(field_1772_a, p_1222_2_, p_1222_3_ - 1, p_1222_4_, 0);
        boolean aflag[] = new boolean[4];
        aflag[0] = p_1222_1_.func_260_c(field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_ - 1, 2);
        aflag[1] = p_1222_1_.func_260_c(field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_ + 1, 3);
        aflag[2] = p_1222_1_.func_260_c(field_1772_a, p_1222_2_ - 1, p_1222_3_, p_1222_4_, 4);
        aflag[3] = p_1222_1_.func_260_c(field_1772_a, p_1222_2_ + 1, p_1222_3_, p_1222_4_, 5);
        if(!flag && !flag1 && !aflag[0] && !aflag[1] && !aflag[2] && !aflag[3])
        {
            return false;
        }
        boolean flag2 = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        double d = 0.0D;
        double d1 = 1.0D;
        Material material = p_1222_1_.field_356_bn;
        int j = field_1772_a.func_602_e(p_1222_2_, p_1222_3_, p_1222_4_);
        double d2 = func_1224_a(p_1222_2_, p_1222_3_, p_1222_4_, material);
        double d3 = func_1224_a(p_1222_2_, p_1222_3_, p_1222_4_ + 1, material);
        double d4 = func_1224_a(p_1222_2_ + 1, p_1222_3_, p_1222_4_ + 1, material);
        double d5 = func_1224_a(p_1222_2_ + 1, p_1222_3_, p_1222_4_, material);
        double d6 = 0.0010000000474974513D;
        if(field_1773_d || flag)
        {
            flag2 = true;
            int k = p_1222_1_.func_232_a(1, j);
            float f8 = (float)BlockFluid.func_293_a(field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_, material);
            if(f8 > -999F)
            {
                k = p_1222_1_.func_232_a(2, j);
            }
            d2 -= d6;
            d3 -= d6;
            d4 -= d6;
            d5 -= d6;
            int j1 = (k & 0xf) << 4;
            int l1 = k & 0xf0;
            double d7 = ((double)j1 + 8D) / 256D;
            double d8 = ((double)l1 + 8D) / 256D;
            if(f8 < -999F)
            {
                f8 = 0.0F;
            } else
            {
                d7 = (float)(j1 + 16) / 256F;
                d8 = (float)(l1 + 16) / 256F;
            }
            double d10 = (double)(MathHelper.func_1106_a(f8) * 8F) / 256D;
            double d12 = (double)(MathHelper.func_1114_b(f8) * 8F) / 256D;
            tessellator.func_35835_b(p_1222_1_.func_35275_c(field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_));
            float f9 = 1.0F;
            tessellator.func_987_a(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
            tessellator.func_983_a(p_1222_2_ + 0, (double)p_1222_3_ + d2, p_1222_4_ + 0, d7 - d12 - d10, (d8 - d12) + d10);
            tessellator.func_983_a(p_1222_2_ + 0, (double)p_1222_3_ + d3, p_1222_4_ + 1, (d7 - d12) + d10, d8 + d12 + d10);
            tessellator.func_983_a(p_1222_2_ + 1, (double)p_1222_3_ + d4, p_1222_4_ + 1, d7 + d12 + d10, (d8 + d12) - d10);
            tessellator.func_983_a(p_1222_2_ + 1, (double)p_1222_3_ + d5, p_1222_4_ + 0, (d7 + d12) - d10, d8 - d12 - d10);
        }
        if(field_1773_d || flag1)
        {
            tessellator.func_35835_b(p_1222_1_.func_35275_c(field_1772_a, p_1222_2_, p_1222_3_ - 1, p_1222_4_));
            float f7 = 1.0F;
            tessellator.func_987_a(f3 * f7, f3 * f7, f3 * f7);
            func_1244_a(p_1222_1_, p_1222_2_, (double)p_1222_3_ + d6, p_1222_4_, p_1222_1_.func_218_a(0));
            flag2 = true;
        }
        for(int l = 0; l < 4; l++)
        {
            int i1 = p_1222_2_;
            int k1 = p_1222_3_;
            int i2 = p_1222_4_;
            if(l == 0)
            {
                i2--;
            }
            if(l == 1)
            {
                i2++;
            }
            if(l == 2)
            {
                i1--;
            }
            if(l == 3)
            {
                i1++;
            }
            int j2 = p_1222_1_.func_232_a(l + 2, j);
            int k2 = (j2 & 0xf) << 4;
            int l2 = j2 & 0xf0;
            if(!field_1773_d && !aflag[l])
            {
                continue;
            }
            double d9;
            double d11;
            double d13;
            double d14;
            double d15;
            double d16;
            if(l == 0)
            {
                d9 = d2;
                d11 = d5;
                d13 = p_1222_2_;
                d15 = p_1222_2_ + 1;
                d14 = (double)p_1222_4_ + d6;
                d16 = (double)p_1222_4_ + d6;
            } else
            if(l == 1)
            {
                d9 = d4;
                d11 = d3;
                d13 = p_1222_2_ + 1;
                d15 = p_1222_2_;
                d14 = (double)(p_1222_4_ + 1) - d6;
                d16 = (double)(p_1222_4_ + 1) - d6;
            } else
            if(l == 2)
            {
                d9 = d3;
                d11 = d2;
                d13 = (double)p_1222_2_ + d6;
                d15 = (double)p_1222_2_ + d6;
                d14 = p_1222_4_ + 1;
                d16 = p_1222_4_;
            } else
            {
                d9 = d5;
                d11 = d4;
                d13 = (double)(p_1222_2_ + 1) - d6;
                d15 = (double)(p_1222_2_ + 1) - d6;
                d14 = p_1222_4_;
                d16 = p_1222_4_ + 1;
            }
            flag2 = true;
            double d17 = (float)(k2 + 0) / 256F;
            double d18 = ((double)(k2 + 16) - 0.01D) / 256D;
            double d19 = ((double)l2 + (1.0D - d9) * 16D) / 256D;
            double d20 = ((double)l2 + (1.0D - d11) * 16D) / 256D;
            double d21 = ((double)(l2 + 16) - 0.01D) / 256D;
            tessellator.func_35835_b(p_1222_1_.func_35275_c(field_1772_a, i1, k1, i2));
            float f10 = 1.0F;
            if(l < 2)
            {
                f10 *= f5;
            } else
            {
                f10 *= f6;
            }
            tessellator.func_987_a(f4 * f10 * f, f4 * f10 * f1, f4 * f10 * f2);
            tessellator.func_983_a(d13, (double)p_1222_3_ + d9, d14, d17, d19);
            tessellator.func_983_a(d15, (double)p_1222_3_ + d11, d16, d18, d20);
            tessellator.func_983_a(d15, p_1222_3_ + 0, d16, d18, d21);
            tessellator.func_983_a(d13, p_1222_3_ + 0, d14, d17, d21);
        }

        p_1222_1_.field_368_bg = d;
        p_1222_1_.field_362_bj = d1;
        return flag2;
    }

    private float func_1224_a(int p_1224_1_, int p_1224_2_, int p_1224_3_, Material p_1224_4_)
    {
        int i = 0;
        float f = 0.0F;
        for(int j = 0; j < 4; j++)
        {
            int k = p_1224_1_ - (j & 1);
            int l = p_1224_2_;
            int i1 = p_1224_3_ - (j >> 1 & 1);
            if(field_1772_a.func_599_f(k, l + 1, i1) == p_1224_4_)
            {
                return 1.0F;
            }
            Material material = field_1772_a.func_599_f(k, l, i1);
            if(material == p_1224_4_)
            {
                int j1 = field_1772_a.func_602_e(k, l, i1);
                if(j1 >= 8 || j1 == 0)
                {
                    f += BlockFluid.func_288_b(j1) * 10F;
                    i += 10;
                }
                f += BlockFluid.func_288_b(j1);
                i++;
                continue;
            }
            if(!material.func_878_a())
            {
                f++;
                i++;
            }
        }

        return 1.0F - f / (float)i;
    }

    public void func_1243_a(Block p_1243_1_, World p_1243_2_, int p_1243_3_, int p_1243_4_, int p_1243_5_)
    {
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        tessellator.func_35835_b(p_1243_1_.func_35275_c(p_1243_2_, p_1243_3_, p_1243_4_, p_1243_5_));
        float f4 = 1.0F;
        float f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f * f5, f * f5, f * f5);
        func_1244_a(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(0));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f1 * f5, f1 * f5, f1 * f5);
        func_1217_b(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(1));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f2 * f5, f2 * f5, f2 * f5);
        func_1220_c(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(2));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f2 * f5, f2 * f5, f2 * f5);
        func_1225_d(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(3));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f3 * f5, f3 * f5, f3 * f5);
        func_1231_e(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(4));
        f5 = 1.0F;
        if(f5 < f4)
        {
            f5 = f4;
        }
        tessellator.func_987_a(f3 * f5, f3 * f5, f3 * f5);
        func_1236_f(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(5));
        tessellator.func_982_a();
    }

    public boolean func_1228_k(Block p_1228_1_, int p_1228_2_, int p_1228_3_, int p_1228_4_)
    {
        int i = p_1228_1_.func_207_d(field_1772_a, p_1228_2_, p_1228_3_, p_1228_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        if(Minecraft.func_22005_v() && Block.field_339_t[p_1228_1_.field_376_bc] == 0)
        {
            return func_22330_a(p_1228_1_, p_1228_2_, p_1228_3_, p_1228_4_, f, f1, f2);
        } else
        {
            return func_4152_a(p_1228_1_, p_1228_2_, p_1228_3_, p_1228_4_, f, f1, f2);
        }
    }

    public boolean func_22330_a(Block p_22330_1_, int p_22330_2_, int p_22330_3_, int p_22330_4_, float p_22330_5_, float p_22330_6_, float p_22330_7_)
    {
        field_22385_e = true;
        boolean flag = false;
        float f = field_22384_f;
        float f7 = field_22384_f;
        float f14 = field_22384_f;
        float f21 = field_22384_f;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        field_22384_f = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_);
        field_22383_g = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
        field_22382_h = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
        field_22381_i = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
        field_22380_j = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
        field_22379_k = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
        field_22378_l = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
        int i = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_);
        int j = i;
        int k = i;
        int l = i;
        int i1 = i;
        int j1 = i;
        int k1 = i;
        if(p_22330_1_.field_368_bg <= 0.0D)
        {
            k = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
        }
        if(p_22330_1_.field_362_bj >= 1.0D)
        {
            j1 = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
        }
        if(p_22330_1_.field_370_bf <= 0.0D)
        {
            j = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
        }
        if(p_22330_1_.field_364_bi >= 1.0D)
        {
            i1 = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
        }
        if(p_22330_1_.field_366_bh <= 0.0D)
        {
            l = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
        }
        if(p_22330_1_.field_360_bk >= 1.0D)
        {
            k1 = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
        }
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_35835_b(0xf000f);
        field_22338_U = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_)];
        field_22359_ac = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_)];
        field_22334_Y = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1)];
        field_22363_aa = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1)];
        field_22337_V = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_)];
        field_22357_ad = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_)];
        field_22335_X = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1)];
        field_22333_Z = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1)];
        field_22336_W = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1)];
        field_22339_T = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1)];
        field_22355_ae = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1)];
        field_22361_ab = Block.field_340_s[field_1772_a.func_600_a(p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1)];
        if(p_22330_1_.field_378_bb == 3)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(field_1771_b >= 0)
        {
            flag1 = flag3 = flag4 = flag5 = flag6 = false;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_, 0))
        {
            float f1;
            float f8;
            float f15;
            float f22;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_368_bg <= 0.0D)
                {
                    p_22330_3_--;
                }
                field_35935_Q = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_35937_S = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_35932_T = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_35934_V = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_22376_n = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_22374_p = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_22373_q = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_22371_s = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                if(field_22361_ab || field_22357_ad)
                {
                    field_22377_m = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
                    field_35936_P = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
                } else
                {
                    field_22377_m = field_22376_n;
                    field_35936_P = field_35935_Q;
                }
                if(field_22355_ae || field_22357_ad)
                {
                    field_22375_o = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
                    field_35938_R = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
                } else
                {
                    field_22375_o = field_22376_n;
                    field_35938_R = field_35935_Q;
                }
                if(field_22361_ab || field_22359_ac)
                {
                    field_22372_r = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
                    field_35931_U = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
                } else
                {
                    field_22372_r = field_22371_s;
                    field_35931_U = field_35934_V;
                }
                if(field_22355_ae || field_22359_ac)
                {
                    field_22370_t = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
                    field_35933_W = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
                } else
                {
                    field_22370_t = field_22371_s;
                    field_35933_W = field_35934_V;
                }
                if(p_22330_1_.field_368_bg <= 0.0D)
                {
                    p_22330_3_++;
                }
                f1 = (field_22375_o + field_22376_n + field_22373_q + field_22382_h) / 4F;
                f22 = (field_22373_q + field_22382_h + field_22370_t + field_22371_s) / 4F;
                f15 = (field_22382_h + field_22374_p + field_22371_s + field_22372_r) / 4F;
                f8 = (field_22376_n + field_22377_m + field_22382_h + field_22374_p) / 4F;
                field_35943_ak = func_35924_c(field_35938_R, field_35935_Q, field_35932_T, k);
                field_35948_an = func_35924_c(field_35932_T, field_35933_W, field_35934_V, k);
                field_35947_am = func_35924_c(field_35937_S, field_35934_V, field_35931_U, k);
                field_35944_al = func_35924_c(field_35935_Q, field_35936_P, field_35937_S, k);
            } else
            {
                f1 = f8 = f15 = f22 = field_22382_h;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = field_35935_Q;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = (flag1 ? p_22330_5_ : 1.0F) * 0.5F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = (flag1 ? p_22330_6_ : 1.0F) * 0.5F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = (flag1 ? p_22330_7_ : 1.0F) * 0.5F;
            field_22351_H *= f1;
            field_22347_L *= f1;
            field_22343_P *= f1;
            field_22350_I *= f8;
            field_22346_M *= f8;
            field_22342_Q *= f8;
            field_22349_J *= f15;
            field_22345_N *= f15;
            field_22341_R *= f15;
            field_22348_K *= f22;
            field_22344_O *= f22;
            field_22340_S *= f22;
            func_1244_a(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 0));
            flag = true;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_, 1))
        {
            float f2;
            float f9;
            float f16;
            float f23;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_362_bj >= 1.0D)
                {
                    p_22330_3_++;
                }
                field_35939_Y = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_35949_ac = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_35951_aa = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_35950_ad = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_22368_v = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_22364_z = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_22366_x = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_22362_A = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                if(field_22339_T || field_22337_V)
                {
                    field_22369_u = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
                    field_35940_X = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
                } else
                {
                    field_22369_u = field_22368_v;
                    field_35940_X = field_35939_Y;
                }
                if(field_22339_T || field_22338_U)
                {
                    field_22365_y = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
                    field_35952_ab = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
                } else
                {
                    field_22365_y = field_22364_z;
                    field_35952_ab = field_35949_ac;
                }
                if(field_22336_W || field_22337_V)
                {
                    field_22367_w = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
                    field_35941_Z = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
                } else
                {
                    field_22367_w = field_22368_v;
                    field_35941_Z = field_35939_Y;
                }
                if(field_22336_W || field_22338_U)
                {
                    field_22360_B = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
                    field_35955_ae = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
                } else
                {
                    field_22360_B = field_22364_z;
                    field_35955_ae = field_35949_ac;
                }
                if(p_22330_1_.field_362_bj >= 1.0D)
                {
                    p_22330_3_--;
                }
                f23 = (field_22367_w + field_22368_v + field_22362_A + field_22379_k) / 4F;
                f2 = (field_22362_A + field_22379_k + field_22360_B + field_22364_z) / 4F;
                f9 = (field_22379_k + field_22366_x + field_22364_z + field_22365_y) / 4F;
                f16 = (field_22368_v + field_22369_u + field_22379_k + field_22366_x) / 4F;
                field_35948_an = func_35924_c(field_35941_Z, field_35939_Y, field_35950_ad, j1);
                field_35943_ak = func_35924_c(field_35950_ad, field_35955_ae, field_35949_ac, j1);
                field_35944_al = func_35924_c(field_35951_aa, field_35949_ac, field_35952_ab, j1);
                field_35947_am = func_35924_c(field_35939_Y, field_35940_X, field_35951_aa, j1);
            } else
            {
                f2 = f9 = f16 = f23 = field_22379_k;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = j1;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = flag2 ? p_22330_5_ : 1.0F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = flag2 ? p_22330_6_ : 1.0F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = flag2 ? p_22330_7_ : 1.0F;
            field_22351_H *= f2;
            field_22347_L *= f2;
            field_22343_P *= f2;
            field_22350_I *= f9;
            field_22346_M *= f9;
            field_22342_Q *= f9;
            field_22349_J *= f16;
            field_22345_N *= f16;
            field_22341_R *= f16;
            field_22348_K *= f23;
            field_22344_O *= f23;
            field_22340_S *= f23;
            func_1217_b(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 1));
            flag = true;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1, 2))
        {
            float f3;
            float f10;
            float f17;
            float f24;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_366_bh <= 0.0D)
                {
                    p_22330_4_--;
                }
                field_22358_C = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_22374_p = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_22366_x = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                field_22356_D = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_35956_af = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_35937_S = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_35951_aa = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                field_35953_ag = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                if(field_22335_X || field_22361_ab)
                {
                    field_22377_m = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
                    field_35936_P = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
                } else
                {
                    field_22377_m = field_22358_C;
                    field_35936_P = field_35956_af;
                }
                if(field_22335_X || field_22339_T)
                {
                    field_22369_u = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
                    field_35940_X = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
                } else
                {
                    field_22369_u = field_22358_C;
                    field_35940_X = field_35956_af;
                }
                if(field_22363_aa || field_22361_ab)
                {
                    field_22372_r = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
                    field_35931_U = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
                } else
                {
                    field_22372_r = field_22356_D;
                    field_35931_U = field_35953_ag;
                }
                if(field_22363_aa || field_22339_T)
                {
                    field_22365_y = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
                    field_35952_ab = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
                } else
                {
                    field_22365_y = field_22356_D;
                    field_35952_ab = field_35953_ag;
                }
                if(p_22330_1_.field_366_bh <= 0.0D)
                {
                    p_22330_4_++;
                }
                f3 = (field_22358_C + field_22369_u + field_22381_i + field_22366_x) / 4F;
                f10 = (field_22381_i + field_22366_x + field_22356_D + field_22365_y) / 4F;
                f17 = (field_22374_p + field_22381_i + field_22372_r + field_22356_D) / 4F;
                f24 = (field_22377_m + field_22358_C + field_22374_p + field_22381_i) / 4F;
                field_35943_ak = func_35924_c(field_35956_af, field_35940_X, field_35951_aa, l);
                field_35944_al = func_35924_c(field_35951_aa, field_35953_ag, field_35952_ab, l);
                field_35947_am = func_35924_c(field_35937_S, field_35931_U, field_35953_ag, l);
                field_35948_an = func_35924_c(field_35936_P, field_35956_af, field_35937_S, l);
            } else
            {
                f3 = f10 = f17 = f24 = field_22381_i;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = l;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = (flag3 ? p_22330_5_ : 1.0F) * 0.8F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = (flag3 ? p_22330_6_ : 1.0F) * 0.8F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = (flag3 ? p_22330_7_ : 1.0F) * 0.8F;
            field_22351_H *= f3;
            field_22347_L *= f3;
            field_22343_P *= f3;
            field_22350_I *= f10;
            field_22346_M *= f10;
            field_22342_Q *= f10;
            field_22349_J *= f17;
            field_22345_N *= f17;
            field_22341_R *= f17;
            field_22348_K *= f24;
            field_22344_O *= f24;
            field_22340_S *= f24;
            int l1 = p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 2);
            func_1220_c(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, l1);
            if(field_27406_a && l1 == 3 && field_1771_b < 0)
            {
                field_22351_H *= p_22330_5_;
                field_22350_I *= p_22330_5_;
                field_22349_J *= p_22330_5_;
                field_22348_K *= p_22330_5_;
                field_22347_L *= p_22330_6_;
                field_22346_M *= p_22330_6_;
                field_22345_N *= p_22330_6_;
                field_22344_O *= p_22330_6_;
                field_22343_P *= p_22330_7_;
                field_22342_Q *= p_22330_7_;
                field_22341_R *= p_22330_7_;
                field_22340_S *= p_22330_7_;
                func_1220_c(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1, 3))
        {
            float f4;
            float f11;
            float f18;
            float f25;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_360_bk >= 1.0D)
                {
                    p_22330_4_++;
                }
                field_22354_E = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_22353_F = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_22373_q = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_22362_A = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                field_35954_ah = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
                field_35945_ai = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
                field_35932_T = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_35950_ad = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                if(field_22333_Z || field_22355_ae)
                {
                    field_22375_o = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
                    field_35938_R = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
                } else
                {
                    field_22375_o = field_22354_E;
                    field_35938_R = field_35954_ah;
                }
                if(field_22333_Z || field_22336_W)
                {
                    field_22367_w = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
                    field_35941_Z = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
                } else
                {
                    field_22367_w = field_22354_E;
                    field_35941_Z = field_35954_ah;
                }
                if(field_22334_Y || field_22355_ae)
                {
                    field_22370_t = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
                    field_35933_W = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
                } else
                {
                    field_22370_t = field_22353_F;
                    field_35933_W = field_35945_ai;
                }
                if(field_22334_Y || field_22336_W)
                {
                    field_22360_B = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
                    field_35955_ae = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
                } else
                {
                    field_22360_B = field_22353_F;
                    field_35955_ae = field_35945_ai;
                }
                if(p_22330_1_.field_360_bk >= 1.0D)
                {
                    p_22330_4_--;
                }
                f4 = (field_22354_E + field_22367_w + field_22378_l + field_22362_A) / 4F;
                f25 = (field_22378_l + field_22362_A + field_22353_F + field_22360_B) / 4F;
                f18 = (field_22373_q + field_22378_l + field_22370_t + field_22353_F) / 4F;
                f11 = (field_22375_o + field_22354_E + field_22373_q + field_22378_l) / 4F;
                field_35943_ak = func_35924_c(field_35954_ah, field_35941_Z, field_35950_ad, k1);
                field_35948_an = func_35924_c(field_35950_ad, field_35945_ai, field_35955_ae, k1);
                field_35947_am = func_35924_c(field_35932_T, field_35933_W, field_35945_ai, k1);
                field_35944_al = func_35924_c(field_35938_R, field_35954_ah, field_35932_T, k1);
            } else
            {
                f4 = f11 = f18 = f25 = field_22378_l;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = k1;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = (flag4 ? p_22330_5_ : 1.0F) * 0.8F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = (flag4 ? p_22330_6_ : 1.0F) * 0.8F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = (flag4 ? p_22330_7_ : 1.0F) * 0.8F;
            field_22351_H *= f4;
            field_22347_L *= f4;
            field_22343_P *= f4;
            field_22350_I *= f11;
            field_22346_M *= f11;
            field_22342_Q *= f11;
            field_22349_J *= f18;
            field_22345_N *= f18;
            field_22341_R *= f18;
            field_22348_K *= f25;
            field_22344_O *= f25;
            field_22340_S *= f25;
            int i2 = p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 3);
            func_1225_d(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 3));
            if(field_27406_a && i2 == 3 && field_1771_b < 0)
            {
                field_22351_H *= p_22330_5_;
                field_22350_I *= p_22330_5_;
                field_22349_J *= p_22330_5_;
                field_22348_K *= p_22330_5_;
                field_22347_L *= p_22330_6_;
                field_22346_M *= p_22330_6_;
                field_22345_N *= p_22330_6_;
                field_22344_O *= p_22330_6_;
                field_22343_P *= p_22330_7_;
                field_22342_Q *= p_22330_7_;
                field_22341_R *= p_22330_7_;
                field_22340_S *= p_22330_7_;
                func_1225_d(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_, 4))
        {
            float f5;
            float f12;
            float f19;
            float f26;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_370_bf <= 0.0D)
                {
                    p_22330_2_--;
                }
                field_22376_n = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_22358_C = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_22354_E = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_22368_v = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                field_35935_Q = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_35956_af = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_35954_ah = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_35939_Y = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                if(field_22335_X || field_22357_ad)
                {
                    field_22377_m = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
                    field_35936_P = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
                } else
                {
                    field_22377_m = field_22358_C;
                    field_35936_P = field_35956_af;
                }
                if(field_22333_Z || field_22357_ad)
                {
                    field_22375_o = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
                    field_35938_R = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
                } else
                {
                    field_22375_o = field_22354_E;
                    field_35938_R = field_35954_ah;
                }
                if(field_22335_X || field_22337_V)
                {
                    field_22369_u = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
                    field_35940_X = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
                } else
                {
                    field_22369_u = field_22358_C;
                    field_35940_X = field_35956_af;
                }
                if(field_22333_Z || field_22337_V)
                {
                    field_22367_w = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
                    field_35941_Z = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
                } else
                {
                    field_22367_w = field_22354_E;
                    field_35941_Z = field_35954_ah;
                }
                if(p_22330_1_.field_370_bf <= 0.0D)
                {
                    p_22330_2_++;
                }
                f26 = (field_22376_n + field_22375_o + field_22383_g + field_22354_E) / 4F;
                f5 = (field_22383_g + field_22354_E + field_22368_v + field_22367_w) / 4F;
                f12 = (field_22358_C + field_22383_g + field_22369_u + field_22368_v) / 4F;
                f19 = (field_22377_m + field_22376_n + field_22358_C + field_22383_g) / 4F;
                field_35948_an = func_35924_c(field_35935_Q, field_35938_R, field_35954_ah, j);
                field_35943_ak = func_35924_c(field_35954_ah, field_35939_Y, field_35941_Z, j);
                field_35944_al = func_35924_c(field_35956_af, field_35940_X, field_35939_Y, j);
                field_35947_am = func_35924_c(field_35936_P, field_35935_Q, field_35956_af, j);
            } else
            {
                f5 = f12 = f19 = f26 = field_22383_g;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = j;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = (flag5 ? p_22330_5_ : 1.0F) * 0.6F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = (flag5 ? p_22330_6_ : 1.0F) * 0.6F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = (flag5 ? p_22330_7_ : 1.0F) * 0.6F;
            field_22351_H *= f5;
            field_22347_L *= f5;
            field_22343_P *= f5;
            field_22350_I *= f12;
            field_22346_M *= f12;
            field_22342_Q *= f12;
            field_22349_J *= f19;
            field_22345_N *= f19;
            field_22341_R *= f19;
            field_22348_K *= f26;
            field_22344_O *= f26;
            field_22340_S *= f26;
            int j2 = p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 4);
            func_1231_e(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, j2);
            if(field_27406_a && j2 == 3 && field_1771_b < 0)
            {
                field_22351_H *= p_22330_5_;
                field_22350_I *= p_22330_5_;
                field_22349_J *= p_22330_5_;
                field_22348_K *= p_22330_5_;
                field_22347_L *= p_22330_6_;
                field_22346_M *= p_22330_6_;
                field_22345_N *= p_22330_6_;
                field_22344_O *= p_22330_6_;
                field_22343_P *= p_22330_7_;
                field_22342_Q *= p_22330_7_;
                field_22341_R *= p_22330_7_;
                field_22340_S *= p_22330_7_;
                func_1231_e(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_22330_1_.func_260_c(field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_, 5))
        {
            float f6;
            float f13;
            float f20;
            float f27;
            if(field_35946_aj > 0)
            {
                if(p_22330_1_.field_364_bi >= 1.0D)
                {
                    p_22330_2_++;
                }
                field_22371_s = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_22356_D = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_22353_F = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_22364_z = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                field_35934_V = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
                field_35953_ag = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
                field_35945_ai = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
                field_35949_ac = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
                if(field_22359_ac || field_22363_aa)
                {
                    field_22372_r = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
                    field_35931_U = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
                } else
                {
                    field_22372_r = field_22356_D;
                    field_35931_U = field_35953_ag;
                }
                if(field_22359_ac || field_22334_Y)
                {
                    field_22370_t = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
                    field_35933_W = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
                } else
                {
                    field_22370_t = field_22353_F;
                    field_35933_W = field_35945_ai;
                }
                if(field_22338_U || field_22363_aa)
                {
                    field_22365_y = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
                    field_35952_ab = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
                } else
                {
                    field_22365_y = field_22356_D;
                    field_35952_ab = field_35953_ag;
                }
                if(field_22338_U || field_22334_Y)
                {
                    field_22360_B = p_22330_1_.func_35276_e(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
                    field_35955_ae = p_22330_1_.func_35275_c(field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
                } else
                {
                    field_22360_B = field_22353_F;
                    field_35955_ae = field_35945_ai;
                }
                if(p_22330_1_.field_364_bi >= 1.0D)
                {
                    p_22330_2_--;
                }
                f6 = (field_22371_s + field_22370_t + field_22380_j + field_22353_F) / 4F;
                f27 = (field_22380_j + field_22353_F + field_22364_z + field_22360_B) / 4F;
                f20 = (field_22356_D + field_22380_j + field_22365_y + field_22364_z) / 4F;
                f13 = (field_22372_r + field_22371_s + field_22356_D + field_22380_j) / 4F;
                field_35943_ak = func_35924_c(field_35934_V, field_35933_W, field_35945_ai, i1);
                field_35948_an = func_35924_c(field_35945_ai, field_35949_ac, field_35955_ae, i1);
                field_35947_am = func_35924_c(field_35953_ag, field_35952_ab, field_35949_ac, i1);
                field_35944_al = func_35924_c(field_35931_U, field_35934_V, field_35953_ag, i1);
            } else
            {
                f6 = f13 = f20 = f27 = field_22380_j;
                field_35943_ak = field_35944_al = field_35947_am = field_35948_an = i1;
            }
            field_22351_H = field_22350_I = field_22349_J = field_22348_K = (flag6 ? p_22330_5_ : 1.0F) * 0.6F;
            field_22347_L = field_22346_M = field_22345_N = field_22344_O = (flag6 ? p_22330_6_ : 1.0F) * 0.6F;
            field_22343_P = field_22342_Q = field_22341_R = field_22340_S = (flag6 ? p_22330_7_ : 1.0F) * 0.6F;
            field_22351_H *= f6;
            field_22347_L *= f6;
            field_22343_P *= f6;
            field_22350_I *= f13;
            field_22346_M *= f13;
            field_22342_Q *= f13;
            field_22349_J *= f20;
            field_22345_N *= f20;
            field_22341_R *= f20;
            field_22348_K *= f27;
            field_22344_O *= f27;
            field_22340_S *= f27;
            int k2 = p_22330_1_.func_211_a(field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 5);
            func_1236_f(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, k2);
            if(field_27406_a && k2 == 3 && field_1771_b < 0)
            {
                field_22351_H *= p_22330_5_;
                field_22350_I *= p_22330_5_;
                field_22349_J *= p_22330_5_;
                field_22348_K *= p_22330_5_;
                field_22347_L *= p_22330_6_;
                field_22346_M *= p_22330_6_;
                field_22345_N *= p_22330_6_;
                field_22344_O *= p_22330_6_;
                field_22343_P *= p_22330_7_;
                field_22342_Q *= p_22330_7_;
                field_22341_R *= p_22330_7_;
                field_22340_S *= p_22330_7_;
                func_1236_f(p_22330_1_, p_22330_2_, p_22330_3_, p_22330_4_, 38);
            }
            flag = true;
        }
        field_22385_e = false;
        return flag;
    }

    private int func_35924_c(int p_35924_1_, int p_35924_2_, int p_35924_3_, int p_35924_4_)
    {
        if(p_35924_1_ == 0)
        {
            p_35924_1_ = p_35924_4_;
        }
        if(p_35924_2_ == 0)
        {
            p_35924_2_ = p_35924_4_;
        }
        if(p_35924_3_ == 0)
        {
            p_35924_3_ = p_35924_4_;
        }
        return p_35924_1_ + p_35924_2_ + p_35924_3_ + p_35924_4_ >> 2 & 0xff00ff;
    }

    public boolean func_4152_a(Block p_4152_1_, int p_4152_2_, int p_4152_3_, int p_4152_4_, float p_4152_5_, float p_4152_6_, float p_4152_7_)
    {
        field_22385_e = false;
        Tessellator tessellator = Tessellator.field_1512_a;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f1 * p_4152_5_;
        float f5 = f1 * p_4152_6_;
        float f6 = f1 * p_4152_7_;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f;
        float f14 = f2;
        float f15 = f3;
        if(p_4152_1_ != Block.field_337_v)
        {
            f7 *= p_4152_5_;
            f8 *= p_4152_5_;
            f9 *= p_4152_5_;
            f10 *= p_4152_6_;
            f11 *= p_4152_6_;
            f12 *= p_4152_6_;
            f13 *= p_4152_7_;
            f14 *= p_4152_7_;
            f15 *= p_4152_7_;
        }
        int i = p_4152_1_.func_35275_c(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_);
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_, p_4152_3_ - 1, p_4152_4_, 0))
        {
            tessellator.func_35835_b(p_4152_1_.field_368_bg <= 0.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_, p_4152_3_ - 1, p_4152_4_) : i);
            tessellator.func_987_a(f7, f10, f13);
            func_1244_a(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 0));
            flag = true;
        }
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_, p_4152_3_ + 1, p_4152_4_, 1))
        {
            tessellator.func_35835_b(p_4152_1_.field_362_bj >= 1.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_, p_4152_3_ + 1, p_4152_4_) : i);
            tessellator.func_987_a(f4, f5, f6);
            func_1217_b(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 1));
            flag = true;
        }
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ - 1, 2))
        {
            tessellator.func_35835_b(p_4152_1_.field_366_bh <= 0.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ - 1) : i);
            tessellator.func_987_a(f8, f11, f14);
            int j = p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 2);
            func_1220_c(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, j);
            if(field_27406_a && j == 3 && field_1771_b < 0)
            {
                tessellator.func_987_a(f8 * p_4152_5_, f11 * p_4152_6_, f14 * p_4152_7_);
                func_1220_c(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ + 1, 3))
        {
            tessellator.func_35835_b(p_4152_1_.field_360_bk >= 1.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ + 1) : i);
            tessellator.func_987_a(f8, f11, f14);
            int k = p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 3);
            func_1225_d(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, k);
            if(field_27406_a && k == 3 && field_1771_b < 0)
            {
                tessellator.func_987_a(f8 * p_4152_5_, f11 * p_4152_6_, f14 * p_4152_7_);
                func_1225_d(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_ - 1, p_4152_3_, p_4152_4_, 4))
        {
            tessellator.func_35835_b(p_4152_1_.field_370_bf <= 0.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_ - 1, p_4152_3_, p_4152_4_) : i);
            tessellator.func_987_a(f9, f12, f15);
            int l = p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 4);
            func_1231_e(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, l);
            if(field_27406_a && l == 3 && field_1771_b < 0)
            {
                tessellator.func_987_a(f9 * p_4152_5_, f12 * p_4152_6_, f15 * p_4152_7_);
                func_1231_e(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, 38);
            }
            flag = true;
        }
        if(field_1773_d || p_4152_1_.func_260_c(field_1772_a, p_4152_2_ + 1, p_4152_3_, p_4152_4_, 5))
        {
            tessellator.func_35835_b(p_4152_1_.field_364_bi >= 1.0D ? p_4152_1_.func_35275_c(field_1772_a, p_4152_2_ + 1, p_4152_3_, p_4152_4_) : i);
            tessellator.func_987_a(f9, f12, f15);
            int i1 = p_4152_1_.func_211_a(field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 5);
            func_1236_f(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, i1);
            if(field_27406_a && i1 == 3 && field_1771_b < 0)
            {
                tessellator.func_987_a(f9 * p_4152_5_, f12 * p_4152_6_, f15 * p_4152_7_);
                func_1236_f(p_4152_1_, p_4152_2_, p_4152_3_, p_4152_4_, 38);
            }
            flag = true;
        }
        return flag;
    }

    public boolean func_1233_l(Block p_1233_1_, int p_1233_2_, int p_1233_3_, int p_1233_4_)
    {
        int i = p_1233_1_.func_207_d(field_1772_a, p_1233_2_, p_1233_3_, p_1233_4_);
        float f = (float)(i >> 16 & 0xff) / 255F;
        float f1 = (float)(i >> 8 & 0xff) / 255F;
        float f2 = (float)(i & 0xff) / 255F;
        if(EntityRenderer.field_28135_a)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        return func_1230_b(p_1233_1_, p_1233_2_, p_1233_3_, p_1233_4_, f, f1, f2);
    }

    public boolean func_1230_b(Block p_1230_1_, int p_1230_2_, int p_1230_3_, int p_1230_4_, float p_1230_5_, float p_1230_6_, float p_1230_7_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        float f4 = f * p_1230_5_;
        float f5 = f1 * p_1230_5_;
        float f6 = f2 * p_1230_5_;
        float f7 = f3 * p_1230_5_;
        float f8 = f * p_1230_6_;
        float f9 = f1 * p_1230_6_;
        float f10 = f2 * p_1230_6_;
        float f11 = f3 * p_1230_6_;
        float f12 = f * p_1230_7_;
        float f13 = f1 * p_1230_7_;
        float f14 = f2 * p_1230_7_;
        float f15 = f3 * p_1230_7_;
        float f16 = 0.0625F;
        int i = p_1230_1_.func_35275_c(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_);
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_, p_1230_3_ - 1, p_1230_4_, 0))
        {
            tessellator.func_35835_b(p_1230_1_.field_368_bg <= 0.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_, p_1230_3_ - 1, p_1230_4_) : i);
            tessellator.func_987_a(f4, f8, f12);
            func_1244_a(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 0));
            flag = true;
        }
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_, p_1230_3_ + 1, p_1230_4_, 1))
        {
            tessellator.func_35835_b(p_1230_1_.field_362_bj >= 1.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_, p_1230_3_ + 1, p_1230_4_) : i);
            tessellator.func_987_a(f5, f9, f13);
            func_1217_b(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 1));
            flag = true;
        }
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ - 1, 2))
        {
            tessellator.func_35835_b(p_1230_1_.field_366_bh <= 0.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ - 1) : i);
            tessellator.func_987_a(f6, f10, f14);
            tessellator.func_988_c(0.0F, 0.0F, f16);
            func_1220_c(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 2));
            tessellator.func_988_c(0.0F, 0.0F, -f16);
            flag = true;
        }
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ + 1, 3))
        {
            tessellator.func_35835_b(p_1230_1_.field_360_bk >= 1.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ + 1) : i);
            tessellator.func_987_a(f6, f10, f14);
            tessellator.func_988_c(0.0F, 0.0F, -f16);
            func_1225_d(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 3));
            tessellator.func_988_c(0.0F, 0.0F, f16);
            flag = true;
        }
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_ - 1, p_1230_3_, p_1230_4_, 4))
        {
            tessellator.func_35835_b(p_1230_1_.field_370_bf <= 0.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_ - 1, p_1230_3_, p_1230_4_) : i);
            tessellator.func_987_a(f7, f11, f15);
            tessellator.func_988_c(f16, 0.0F, 0.0F);
            func_1231_e(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 4));
            tessellator.func_988_c(-f16, 0.0F, 0.0F);
            flag = true;
        }
        if(field_1773_d || p_1230_1_.func_260_c(field_1772_a, p_1230_2_ + 1, p_1230_3_, p_1230_4_, 5))
        {
            tessellator.func_35835_b(p_1230_1_.field_364_bi >= 1.0D ? p_1230_1_.func_35275_c(field_1772_a, p_1230_2_ + 1, p_1230_3_, p_1230_4_) : i);
            tessellator.func_987_a(f7, f11, f15);
            tessellator.func_988_c(-f16, 0.0F, 0.0F);
            func_1236_f(p_1230_1_, p_1230_2_, p_1230_3_, p_1230_4_, p_1230_1_.func_211_a(field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 5));
            tessellator.func_988_c(f16, 0.0F, 0.0F);
            flag = true;
        }
        return flag;
    }

    public boolean func_35925_a(BlockFence p_35925_1_, int p_35925_2_, int p_35925_3_, int p_35925_4_)
    {
        boolean flag = false;
        float f = 0.375F;
        float f1 = 0.625F;
        p_35925_1_.func_213_a(f, 0.0F, f, f1, 1.0F, f1);
        func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
        flag = true;
        boolean flag1 = false;
        boolean flag2 = false;
        if(p_35925_1_.func_35303_f(field_1772_a, p_35925_2_ - 1, p_35925_3_, p_35925_4_) || p_35925_1_.func_35303_f(field_1772_a, p_35925_2_ + 1, p_35925_3_, p_35925_4_))
        {
            flag1 = true;
        }
        if(p_35925_1_.func_35303_f(field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ - 1) || p_35925_1_.func_35303_f(field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ + 1))
        {
            flag2 = true;
        }
        boolean flag3 = p_35925_1_.func_35303_f(field_1772_a, p_35925_2_ - 1, p_35925_3_, p_35925_4_);
        boolean flag4 = p_35925_1_.func_35303_f(field_1772_a, p_35925_2_ + 1, p_35925_3_, p_35925_4_);
        boolean flag5 = p_35925_1_.func_35303_f(field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ - 1);
        boolean flag6 = p_35925_1_.func_35303_f(field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ + 1);
        if(!flag1 && !flag2)
        {
            flag1 = true;
        }
        f = 0.4375F;
        f1 = 0.5625F;
        float f2 = 0.75F;
        float f3 = 0.9375F;
        float f4 = flag3 ? 0.0F : f;
        float f5 = flag4 ? 1.0F : f1;
        float f6 = flag5 ? 0.0F : f;
        float f7 = flag6 ? 1.0F : f1;
        if(flag1)
        {
            p_35925_1_.func_213_a(f4, f2, f, f5, f3, f1);
            func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
            flag = true;
        }
        if(flag2)
        {
            p_35925_1_.func_213_a(f, f2, f6, f1, f3, f7);
            func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
            flag = true;
        }
        f2 = 0.375F;
        f3 = 0.5625F;
        if(flag1)
        {
            p_35925_1_.func_213_a(f4, f2, f, f5, f3, f1);
            func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
            flag = true;
        }
        if(flag2)
        {
            p_35925_1_.func_213_a(f, f2, f6, f1, f3, f7);
            func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
            flag = true;
        }
        p_35925_1_.func_238_a(field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_);
        return flag;
    }

    public boolean func_41088_a(BlockDragonEgg p_41088_1_, int p_41088_2_, int p_41088_3_, int p_41088_4_)
    {
        boolean flag = false;
        int i = 0;
        for(int j = 0; j < 8; j++)
        {
            int k = 0;
            byte byte0 = 1;
            if(j == 0)
            {
                k = 2;
            }
            if(j == 1)
            {
                k = 3;
            }
            if(j == 2)
            {
                k = 4;
            }
            if(j == 3)
            {
                k = 5;
                byte0 = 2;
            }
            if(j == 4)
            {
                k = 6;
                byte0 = 3;
            }
            if(j == 5)
            {
                k = 7;
                byte0 = 5;
            }
            if(j == 6)
            {
                k = 6;
                byte0 = 2;
            }
            if(j == 7)
            {
                k = 3;
            }
            float f = (float)k / 16F;
            float f1 = 1.0F - (float)i / 16F;
            float f2 = 1.0F - (float)(i + byte0) / 16F;
            i += byte0;
            p_41088_1_.func_213_a(0.5F - f, f2, 0.5F - f, 0.5F + f, f1, 0.5F + f);
            func_1228_k(p_41088_1_, p_41088_2_, p_41088_3_, p_41088_4_);
        }

        flag = true;
        p_41088_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean func_35923_a(BlockFenceGate p_35923_1_, int p_35923_2_, int p_35923_3_, int p_35923_4_)
    {
        boolean flag = true;
        int i = field_1772_a.func_602_e(p_35923_2_, p_35923_3_, p_35923_4_);
        boolean flag1 = BlockFenceGate.func_35291_d(i);
        int j = BlockDirectional.func_48216_a(i);
        if(j == 3 || j == 1)
        {
            float f = 0.4375F;
            float f4 = 0.5625F;
            float f8 = 0.0F;
            float f12 = 0.125F;
            p_35923_1_.func_213_a(f, 0.3125F, f8, f4, 1.0F, f12);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            f8 = 0.875F;
            f12 = 1.0F;
            p_35923_1_.func_213_a(f, 0.3125F, f8, f4, 1.0F, f12);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        } else
        {
            float f1 = 0.0F;
            float f5 = 0.125F;
            float f9 = 0.4375F;
            float f13 = 0.5625F;
            p_35923_1_.func_213_a(f1, 0.3125F, f9, f5, 1.0F, f13);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            f1 = 0.875F;
            f5 = 1.0F;
            p_35923_1_.func_213_a(f1, 0.3125F, f9, f5, 1.0F, f13);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        }
        if(!flag1)
        {
            if(j == 3 || j == 1)
            {
                float f2 = 0.4375F;
                float f6 = 0.5625F;
                float f10 = 0.375F;
                float f14 = 0.5F;
                p_35923_1_.func_213_a(f2, 0.375F, f10, f6, 0.9375F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f10 = 0.5F;
                f14 = 0.625F;
                p_35923_1_.func_213_a(f2, 0.375F, f10, f6, 0.9375F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f10 = 0.625F;
                f14 = 0.875F;
                p_35923_1_.func_213_a(f2, 0.375F, f10, f6, 0.5625F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                p_35923_1_.func_213_a(f2, 0.75F, f10, f6, 0.9375F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f10 = 0.125F;
                f14 = 0.375F;
                p_35923_1_.func_213_a(f2, 0.375F, f10, f6, 0.5625F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                p_35923_1_.func_213_a(f2, 0.75F, f10, f6, 0.9375F, f14);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            } else
            {
                float f3 = 0.375F;
                float f7 = 0.5F;
                float f11 = 0.4375F;
                float f15 = 0.5625F;
                p_35923_1_.func_213_a(f3, 0.375F, f11, f7, 0.9375F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f3 = 0.5F;
                f7 = 0.625F;
                p_35923_1_.func_213_a(f3, 0.375F, f11, f7, 0.9375F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f3 = 0.625F;
                f7 = 0.875F;
                p_35923_1_.func_213_a(f3, 0.375F, f11, f7, 0.5625F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                p_35923_1_.func_213_a(f3, 0.75F, f11, f7, 0.9375F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                f3 = 0.125F;
                f7 = 0.375F;
                p_35923_1_.func_213_a(f3, 0.375F, f11, f7, 0.5625F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
                p_35923_1_.func_213_a(f3, 0.75F, f11, f7, 0.9375F, f15);
                func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            }
        } else
        if(j == 3)
        {
            p_35923_1_.func_213_a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        } else
        if(j == 1)
        {
            p_35923_1_.func_213_a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        } else
        if(j == 0)
        {
            p_35923_1_.func_213_a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        } else
        if(j == 2)
        {
            p_35923_1_.func_213_a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
            func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
        }
        p_35923_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return flag;
    }

    public boolean func_1214_n(Block p_1214_1_, int p_1214_2_, int p_1214_3_, int p_1214_4_)
    {
        int i = field_1772_a.func_602_e(p_1214_2_, p_1214_3_, p_1214_4_);
        int j = i & 3;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = 0.5F;
        float f3 = 1.0F;
        if((i & 4) != 0)
        {
            f = 0.5F;
            f1 = 1.0F;
            f2 = 0.0F;
            f3 = 0.5F;
        }
        p_1214_1_.func_213_a(0.0F, f, 0.0F, 1.0F, f1, 1.0F);
        func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
        if(j == 0)
        {
            p_1214_1_.func_213_a(0.5F, f2, 0.0F, 1.0F, f3, 1.0F);
            func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
        } else
        if(j == 1)
        {
            p_1214_1_.func_213_a(0.0F, f2, 0.0F, 0.5F, f3, 1.0F);
            func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
        } else
        if(j == 2)
        {
            p_1214_1_.func_213_a(0.0F, f2, 0.5F, 1.0F, f3, 1.0F);
            func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
        } else
        if(j == 3)
        {
            p_1214_1_.func_213_a(0.0F, f2, 0.0F, 1.0F, f3, 0.5F);
            func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
        }
        p_1214_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean func_1218_o(Block p_1218_1_, int p_1218_2_, int p_1218_3_, int p_1218_4_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        BlockDoor blockdoor = (BlockDoor)p_1218_1_;
        boolean flag = false;
        float f = 0.5F;
        float f1 = 1.0F;
        float f2 = 0.8F;
        float f3 = 0.6F;
        int i = p_1218_1_.func_35275_c(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_);
        tessellator.func_35835_b(p_1218_1_.field_368_bg <= 0.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_, p_1218_3_ - 1, p_1218_4_) : i);
        tessellator.func_987_a(f, f, f);
        func_1244_a(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 0));
        flag = true;
        tessellator.func_35835_b(p_1218_1_.field_362_bj >= 1.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_, p_1218_3_ + 1, p_1218_4_) : i);
        tessellator.func_987_a(f1, f1, f1);
        func_1217_b(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 1));
        flag = true;
        tessellator.func_35835_b(p_1218_1_.field_366_bh <= 0.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_ - 1) : i);
        tessellator.func_987_a(f2, f2, f2);
        int j = p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 2);
        if(j < 0)
        {
            field_1774_c = true;
            j = -j;
        }
        func_1220_c(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, j);
        flag = true;
        field_1774_c = false;
        tessellator.func_35835_b(p_1218_1_.field_360_bk >= 1.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_ + 1) : i);
        tessellator.func_987_a(f2, f2, f2);
        j = p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 3);
        if(j < 0)
        {
            field_1774_c = true;
            j = -j;
        }
        func_1225_d(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, j);
        flag = true;
        field_1774_c = false;
        tessellator.func_35835_b(p_1218_1_.field_370_bf <= 0.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_ - 1, p_1218_3_, p_1218_4_) : i);
        tessellator.func_987_a(f3, f3, f3);
        j = p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 4);
        if(j < 0)
        {
            field_1774_c = true;
            j = -j;
        }
        func_1231_e(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, j);
        flag = true;
        field_1774_c = false;
        tessellator.func_35835_b(p_1218_1_.field_364_bi >= 1.0D ? p_1218_1_.func_35275_c(field_1772_a, p_1218_2_ + 1, p_1218_3_, p_1218_4_) : i);
        tessellator.func_987_a(f3, f3, f3);
        j = p_1218_1_.func_211_a(field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 5);
        if(j < 0)
        {
            field_1774_c = true;
            j = -j;
        }
        func_1236_f(p_1218_1_, p_1218_2_, p_1218_3_, p_1218_4_, j);
        flag = true;
        field_1774_c = false;
        return flag;
    }

    public void func_1244_a(Block p_1244_1_, double p_1244_2_, double p_1244_4_, double p_1244_6_, 
            int p_1244_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1244_8_ = field_1771_b;
        }
        int i = (p_1244_8_ & 0xf) << 4;
        int j = p_1244_8_ & 0xf0;
        double d = ((double)i + p_1244_1_.field_370_bf * 16D) / 256D;
        double d1 = (((double)i + p_1244_1_.field_364_bi * 16D) - 0.01D) / 256D;
        double d2 = ((double)j + p_1244_1_.field_366_bh * 16D) / 256D;
        double d3 = (((double)j + p_1244_1_.field_360_bk * 16D) - 0.01D) / 256D;
        if(p_1244_1_.field_370_bf < 0.0D || p_1244_1_.field_364_bi > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1244_1_.field_366_bh < 0.0D || p_1244_1_.field_360_bk > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d4 = d1;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        if(field_31082_l == 2)
        {
            d = ((double)i + p_1244_1_.field_366_bh * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1244_1_.field_364_bi * 16D) / 256D;
            d1 = ((double)i + p_1244_1_.field_360_bk * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1244_1_.field_370_bf * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d4 = d;
            d5 = d1;
            d2 = d3;
            d3 = d6;
        } else
        if(field_31082_l == 1)
        {
            d = ((double)(i + 16) - p_1244_1_.field_360_bk * 16D) / 256D;
            d2 = ((double)j + p_1244_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1244_1_.field_366_bh * 16D) / 256D;
            d3 = ((double)j + p_1244_1_.field_364_bi * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d = d4;
            d1 = d5;
            d6 = d3;
            d7 = d2;
        } else
        if(field_31082_l == 3)
        {
            d = ((double)(i + 16) - p_1244_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1244_1_.field_364_bi * 16D - 0.01D) / 256D;
            d2 = ((double)(j + 16) - p_1244_1_.field_366_bh * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1244_1_.field_360_bk * 16D - 0.01D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
        }
        double d8 = p_1244_2_ + p_1244_1_.field_370_bf;
        double d9 = p_1244_2_ + p_1244_1_.field_364_bi;
        double d10 = p_1244_4_ + p_1244_1_.field_368_bg;
        double d11 = p_1244_6_ + p_1244_1_.field_366_bh;
        double d12 = p_1244_6_ + p_1244_1_.field_360_bk;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d8, d10, d12, d5, d7);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d8, d10, d11, d, d2);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d9, d10, d11, d4, d6);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d9, d10, d12, d1, d3);
        } else
        {
            tessellator.func_983_a(d8, d10, d12, d5, d7);
            tessellator.func_983_a(d8, d10, d11, d, d2);
            tessellator.func_983_a(d9, d10, d11, d4, d6);
            tessellator.func_983_a(d9, d10, d12, d1, d3);
        }
    }

    public void func_1217_b(Block p_1217_1_, double p_1217_2_, double p_1217_4_, double p_1217_6_, 
            int p_1217_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1217_8_ = field_1771_b;
        }
        int i = (p_1217_8_ & 0xf) << 4;
        int j = p_1217_8_ & 0xf0;
        double d = ((double)i + p_1217_1_.field_370_bf * 16D) / 256D;
        double d1 = (((double)i + p_1217_1_.field_364_bi * 16D) - 0.01D) / 256D;
        double d2 = ((double)j + p_1217_1_.field_366_bh * 16D) / 256D;
        double d3 = (((double)j + p_1217_1_.field_360_bk * 16D) - 0.01D) / 256D;
        if(p_1217_1_.field_370_bf < 0.0D || p_1217_1_.field_364_bi > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1217_1_.field_366_bh < 0.0D || p_1217_1_.field_360_bk > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d4 = d1;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        if(field_31083_k == 1)
        {
            d = ((double)i + p_1217_1_.field_366_bh * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1217_1_.field_364_bi * 16D) / 256D;
            d1 = ((double)i + p_1217_1_.field_360_bk * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1217_1_.field_370_bf * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d4 = d;
            d5 = d1;
            d2 = d3;
            d3 = d6;
        } else
        if(field_31083_k == 2)
        {
            d = ((double)(i + 16) - p_1217_1_.field_360_bk * 16D) / 256D;
            d2 = ((double)j + p_1217_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1217_1_.field_366_bh * 16D) / 256D;
            d3 = ((double)j + p_1217_1_.field_364_bi * 16D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
            d = d4;
            d1 = d5;
            d6 = d3;
            d7 = d2;
        } else
        if(field_31083_k == 3)
        {
            d = ((double)(i + 16) - p_1217_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1217_1_.field_364_bi * 16D - 0.01D) / 256D;
            d2 = ((double)(j + 16) - p_1217_1_.field_366_bh * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1217_1_.field_360_bk * 16D - 0.01D) / 256D;
            d4 = d1;
            d5 = d;
            d6 = d2;
            d7 = d3;
        }
        double d8 = p_1217_2_ + p_1217_1_.field_370_bf;
        double d9 = p_1217_2_ + p_1217_1_.field_364_bi;
        double d10 = p_1217_4_ + p_1217_1_.field_362_bj;
        double d11 = p_1217_6_ + p_1217_1_.field_366_bh;
        double d12 = p_1217_6_ + p_1217_1_.field_360_bk;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d9, d10, d12, d1, d3);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d9, d10, d11, d4, d6);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d8, d10, d11, d, d2);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d8, d10, d12, d5, d7);
        } else
        {
            tessellator.func_983_a(d9, d10, d12, d1, d3);
            tessellator.func_983_a(d9, d10, d11, d4, d6);
            tessellator.func_983_a(d8, d10, d11, d, d2);
            tessellator.func_983_a(d8, d10, d12, d5, d7);
        }
    }

    public void func_1220_c(Block p_1220_1_, double p_1220_2_, double p_1220_4_, double p_1220_6_, 
            int p_1220_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1220_8_ = field_1771_b;
        }
        int i = (p_1220_8_ & 0xf) << 4;
        int j = p_1220_8_ & 0xf0;
        double d = ((double)i + p_1220_1_.field_370_bf * 16D) / 256D;
        double d1 = (((double)i + p_1220_1_.field_364_bi * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_1220_1_.field_362_bj * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_1220_1_.field_368_bg * 16D - 0.01D) / 256D;
        if(field_1774_c)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_1220_1_.field_370_bf < 0.0D || p_1220_1_.field_364_bi > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1220_1_.field_368_bg < 0.0D || p_1220_1_.field_362_bj > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_31087_g == 2)
        {
            d = ((double)i + p_1220_1_.field_368_bg * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1220_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)i + p_1220_1_.field_362_bj * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1220_1_.field_364_bi * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_31087_g == 1)
        {
            d = ((double)(i + 16) - p_1220_1_.field_362_bj * 16D) / 256D;
            d2 = ((double)j + p_1220_1_.field_364_bi * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1220_1_.field_368_bg * 16D) / 256D;
            d3 = ((double)j + p_1220_1_.field_370_bf * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_31087_g == 3)
        {
            d = ((double)(i + 16) - p_1220_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1220_1_.field_364_bi * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_1220_1_.field_362_bj * 16D) / 256D;
            d3 = (((double)j + p_1220_1_.field_368_bg * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_1220_2_ + p_1220_1_.field_370_bf;
        double d10 = p_1220_2_ + p_1220_1_.field_364_bi;
        double d11 = p_1220_4_ + p_1220_1_.field_368_bg;
        double d12 = p_1220_4_ + p_1220_1_.field_362_bj;
        double d13 = p_1220_6_ + p_1220_1_.field_366_bh;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d9, d12, d13, d5, d7);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d10, d12, d13, d, d2);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d10, d11, d13, d6, d8);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d9, d11, d13, d1, d3);
        } else
        {
            tessellator.func_983_a(d9, d12, d13, d5, d7);
            tessellator.func_983_a(d10, d12, d13, d, d2);
            tessellator.func_983_a(d10, d11, d13, d6, d8);
            tessellator.func_983_a(d9, d11, d13, d1, d3);
        }
    }

    public void func_1225_d(Block p_1225_1_, double p_1225_2_, double p_1225_4_, double p_1225_6_, 
            int p_1225_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1225_8_ = field_1771_b;
        }
        int i = (p_1225_8_ & 0xf) << 4;
        int j = p_1225_8_ & 0xf0;
        double d = ((double)i + p_1225_1_.field_370_bf * 16D) / 256D;
        double d1 = (((double)i + p_1225_1_.field_364_bi * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_1225_1_.field_362_bj * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_1225_1_.field_368_bg * 16D - 0.01D) / 256D;
        if(field_1774_c)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_1225_1_.field_370_bf < 0.0D || p_1225_1_.field_364_bi > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1225_1_.field_368_bg < 0.0D || p_1225_1_.field_362_bj > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_31086_h == 1)
        {
            d = ((double)i + p_1225_1_.field_368_bg * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1225_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)i + p_1225_1_.field_362_bj * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1225_1_.field_364_bi * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_31086_h == 2)
        {
            d = ((double)(i + 16) - p_1225_1_.field_362_bj * 16D) / 256D;
            d2 = ((double)j + p_1225_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1225_1_.field_368_bg * 16D) / 256D;
            d3 = ((double)j + p_1225_1_.field_364_bi * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_31086_h == 3)
        {
            d = ((double)(i + 16) - p_1225_1_.field_370_bf * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1225_1_.field_364_bi * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_1225_1_.field_362_bj * 16D) / 256D;
            d3 = (((double)j + p_1225_1_.field_368_bg * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_1225_2_ + p_1225_1_.field_370_bf;
        double d10 = p_1225_2_ + p_1225_1_.field_364_bi;
        double d11 = p_1225_4_ + p_1225_1_.field_368_bg;
        double d12 = p_1225_4_ + p_1225_1_.field_362_bj;
        double d13 = p_1225_6_ + p_1225_1_.field_360_bk;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d9, d12, d13, d, d2);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d9, d11, d13, d6, d8);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d10, d11, d13, d1, d3);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d10, d12, d13, d5, d7);
        } else
        {
            tessellator.func_983_a(d9, d12, d13, d, d2);
            tessellator.func_983_a(d9, d11, d13, d6, d8);
            tessellator.func_983_a(d10, d11, d13, d1, d3);
            tessellator.func_983_a(d10, d12, d13, d5, d7);
        }
    }

    public void func_1231_e(Block p_1231_1_, double p_1231_2_, double p_1231_4_, double p_1231_6_, 
            int p_1231_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1231_8_ = field_1771_b;
        }
        int i = (p_1231_8_ & 0xf) << 4;
        int j = p_1231_8_ & 0xf0;
        double d = ((double)i + p_1231_1_.field_366_bh * 16D) / 256D;
        double d1 = (((double)i + p_1231_1_.field_360_bk * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_1231_1_.field_362_bj * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_1231_1_.field_368_bg * 16D - 0.01D) / 256D;
        if(field_1774_c)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_1231_1_.field_366_bh < 0.0D || p_1231_1_.field_360_bk > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1231_1_.field_368_bg < 0.0D || p_1231_1_.field_362_bj > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_31084_j == 1)
        {
            d = ((double)i + p_1231_1_.field_368_bg * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1231_1_.field_360_bk * 16D) / 256D;
            d1 = ((double)i + p_1231_1_.field_362_bj * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1231_1_.field_366_bh * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_31084_j == 2)
        {
            d = ((double)(i + 16) - p_1231_1_.field_362_bj * 16D) / 256D;
            d2 = ((double)j + p_1231_1_.field_366_bh * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1231_1_.field_368_bg * 16D) / 256D;
            d3 = ((double)j + p_1231_1_.field_360_bk * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_31084_j == 3)
        {
            d = ((double)(i + 16) - p_1231_1_.field_366_bh * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1231_1_.field_360_bk * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_1231_1_.field_362_bj * 16D) / 256D;
            d3 = (((double)j + p_1231_1_.field_368_bg * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_1231_2_ + p_1231_1_.field_370_bf;
        double d10 = p_1231_4_ + p_1231_1_.field_368_bg;
        double d11 = p_1231_4_ + p_1231_1_.field_362_bj;
        double d12 = p_1231_6_ + p_1231_1_.field_366_bh;
        double d13 = p_1231_6_ + p_1231_1_.field_360_bk;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d9, d11, d13, d5, d7);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d9, d11, d12, d, d2);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d9, d10, d12, d6, d8);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d9, d10, d13, d1, d3);
        } else
        {
            tessellator.func_983_a(d9, d11, d13, d5, d7);
            tessellator.func_983_a(d9, d11, d12, d, d2);
            tessellator.func_983_a(d9, d10, d12, d6, d8);
            tessellator.func_983_a(d9, d10, d13, d1, d3);
        }
    }

    public void func_1236_f(Block p_1236_1_, double p_1236_2_, double p_1236_4_, double p_1236_6_, 
            int p_1236_8_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        if(field_1771_b >= 0)
        {
            p_1236_8_ = field_1771_b;
        }
        int i = (p_1236_8_ & 0xf) << 4;
        int j = p_1236_8_ & 0xf0;
        double d = ((double)i + p_1236_1_.field_366_bh * 16D) / 256D;
        double d1 = (((double)i + p_1236_1_.field_360_bk * 16D) - 0.01D) / 256D;
        double d2 = ((double)(j + 16) - p_1236_1_.field_362_bj * 16D) / 256D;
        double d3 = ((double)(j + 16) - p_1236_1_.field_368_bg * 16D - 0.01D) / 256D;
        if(field_1774_c)
        {
            double d4 = d;
            d = d1;
            d1 = d4;
        }
        if(p_1236_1_.field_366_bh < 0.0D || p_1236_1_.field_360_bk > 1.0D)
        {
            d = ((float)i + 0.0F) / 256F;
            d1 = ((float)i + 15.99F) / 256F;
        }
        if(p_1236_1_.field_368_bg < 0.0D || p_1236_1_.field_362_bj > 1.0D)
        {
            d2 = ((float)j + 0.0F) / 256F;
            d3 = ((float)j + 15.99F) / 256F;
        }
        double d5 = d1;
        double d6 = d;
        double d7 = d2;
        double d8 = d3;
        if(field_31085_i == 2)
        {
            d = ((double)i + p_1236_1_.field_368_bg * 16D) / 256D;
            d2 = ((double)(j + 16) - p_1236_1_.field_366_bh * 16D) / 256D;
            d1 = ((double)i + p_1236_1_.field_362_bj * 16D) / 256D;
            d3 = ((double)(j + 16) - p_1236_1_.field_360_bk * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d5 = d;
            d6 = d1;
            d2 = d3;
            d3 = d7;
        } else
        if(field_31085_i == 1)
        {
            d = ((double)(i + 16) - p_1236_1_.field_362_bj * 16D) / 256D;
            d2 = ((double)j + p_1236_1_.field_360_bk * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1236_1_.field_368_bg * 16D) / 256D;
            d3 = ((double)j + p_1236_1_.field_366_bh * 16D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
            d = d5;
            d1 = d6;
            d7 = d3;
            d8 = d2;
        } else
        if(field_31085_i == 3)
        {
            d = ((double)(i + 16) - p_1236_1_.field_366_bh * 16D) / 256D;
            d1 = ((double)(i + 16) - p_1236_1_.field_360_bk * 16D - 0.01D) / 256D;
            d2 = ((double)j + p_1236_1_.field_362_bj * 16D) / 256D;
            d3 = (((double)j + p_1236_1_.field_368_bg * 16D) - 0.01D) / 256D;
            d5 = d1;
            d6 = d;
            d7 = d2;
            d8 = d3;
        }
        double d9 = p_1236_2_ + p_1236_1_.field_364_bi;
        double d10 = p_1236_4_ + p_1236_1_.field_368_bg;
        double d11 = p_1236_4_ + p_1236_1_.field_362_bj;
        double d12 = p_1236_6_ + p_1236_1_.field_366_bh;
        double d13 = p_1236_6_ + p_1236_1_.field_360_bk;
        if(field_22385_e)
        {
            tessellator.func_987_a(field_22351_H, field_22347_L, field_22343_P);
            tessellator.func_35835_b(field_35943_ak);
            tessellator.func_983_a(d9, d10, d13, d6, d8);
            tessellator.func_987_a(field_22350_I, field_22346_M, field_22342_Q);
            tessellator.func_35835_b(field_35944_al);
            tessellator.func_983_a(d9, d10, d12, d1, d3);
            tessellator.func_987_a(field_22349_J, field_22345_N, field_22341_R);
            tessellator.func_35835_b(field_35947_am);
            tessellator.func_983_a(d9, d11, d12, d5, d7);
            tessellator.func_987_a(field_22348_K, field_22344_O, field_22340_S);
            tessellator.func_35835_b(field_35948_an);
            tessellator.func_983_a(d9, d11, d13, d, d2);
        } else
        {
            tessellator.func_983_a(d9, d10, d13, d6, d8);
            tessellator.func_983_a(d9, d10, d12, d1, d3);
            tessellator.func_983_a(d9, d11, d12, d5, d7);
            tessellator.func_983_a(d9, d11, d13, d, d2);
        }
    }

    public void func_1227_a(Block p_1227_1_, int p_1227_2_, float p_1227_3_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        boolean flag = p_1227_1_.field_376_bc == Block.field_337_v.field_376_bc;
        if(field_31088_b)
        {
            int i = p_1227_1_.func_31030_b(p_1227_2_);
            if(flag)
            {
                i = 0xffffff;
            }
            float f = (float)(i >> 16 & 0xff) / 255F;
            float f2 = (float)(i >> 8 & 0xff) / 255F;
            float f6 = (float)(i & 0xff) / 255F;
            GL11.glColor4f(f * p_1227_3_, f2 * p_1227_3_, f6 * p_1227_3_, 1.0F);
        }
        int j = p_1227_1_.func_210_f();
        if(j == 0 || j == 16)
        {
            if(j == 16)
            {
                p_1227_2_ = 1;
            }
            p_1227_1_.func_237_e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(0, p_1227_2_));
            tessellator.func_982_a();
            if(flag && field_31088_b)
            {
                int k = p_1227_1_.func_31030_b(p_1227_2_);
                float f3 = (float)(k >> 16 & 0xff) / 255F;
                float f7 = (float)(k >> 8 & 0xff) / 255F;
                float f8 = (float)(k & 0xff) / 255F;
                GL11.glColor4f(f3 * p_1227_3_, f7 * p_1227_3_, f8 * p_1227_3_, 1.0F);
            }
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 1.0F, 0.0F);
            func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(1, p_1227_2_));
            tessellator.func_982_a();
            if(flag && field_31088_b)
            {
                GL11.glColor4f(p_1227_3_, p_1227_3_, p_1227_3_, 1.0F);
            }
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 0.0F, -1F);
            func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(2, p_1227_2_));
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 0.0F, 1.0F);
            func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(3, p_1227_2_));
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(-1F, 0.0F, 0.0F);
            func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(4, p_1227_2_));
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(1.0F, 0.0F, 0.0F);
            func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(5, p_1227_2_));
            tessellator.func_982_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(j == 1)
        {
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            func_1239_a(p_1227_1_, p_1227_2_, -0.5D, -0.5D, -0.5D);
            tessellator.func_982_a();
        } else
        if(j == 19)
        {
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            p_1227_1_.func_237_e();
            func_35928_a(p_1227_1_, p_1227_2_, p_1227_1_.field_362_bj, -0.5D, -0.5D, -0.5D);
            tessellator.func_982_a();
        } else
        if(j == 23)
        {
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            p_1227_1_.func_237_e();
            tessellator.func_982_a();
        } else
        if(j == 13)
        {
            p_1227_1_.func_237_e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = 0.0625F;
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 1.0F, 0.0F);
            func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 0.0F, -1F);
            tessellator.func_988_c(0.0F, 0.0F, f1);
            func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
            tessellator.func_988_c(0.0F, 0.0F, -f1);
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, 0.0F, 1.0F);
            tessellator.func_988_c(0.0F, 0.0F, -f1);
            func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
            tessellator.func_988_c(0.0F, 0.0F, f1);
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(-1F, 0.0F, 0.0F);
            tessellator.func_988_c(f1, 0.0F, 0.0F);
            func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
            tessellator.func_988_c(-f1, 0.0F, 0.0F);
            tessellator.func_982_a();
            tessellator.func_977_b();
            tessellator.func_980_b(1.0F, 0.0F, 0.0F);
            tessellator.func_988_c(-f1, 0.0F, 0.0F);
            func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
            tessellator.func_988_c(f1, 0.0F, 0.0F);
            tessellator.func_982_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        } else
        if(j == 22)
        {
            ChestItemRenderHelper.field_35611_a.func_35609_a(p_1227_1_, p_1227_2_, p_1227_3_);
            GL11.glEnable(32826);
        } else
        if(j == 6)
        {
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            func_1245_b(p_1227_1_, p_1227_2_, -0.5D, -0.5D, -0.5D);
            tessellator.func_982_a();
        } else
        if(j == 2)
        {
            tessellator.func_977_b();
            tessellator.func_980_b(0.0F, -1F, 0.0F);
            func_1237_a(p_1227_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
            tessellator.func_982_a();
        } else
        if(j == 10)
        {
            for(int l = 0; l < 2; l++)
            {
                if(l == 0)
                {
                    p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
                }
                if(l == 1)
                {
                    p_1227_1_.func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, -1F, 0.0F);
                func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, -1F);
                func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(-1F, 0.0F, 0.0F);
                func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
                tessellator.func_982_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

        } else
        if(j == 27)
        {
            int i1 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            tessellator.func_977_b();
            for(int l1 = 0; l1 < 8; l1++)
            {
                int i2 = 0;
                byte byte0 = 1;
                if(l1 == 0)
                {
                    i2 = 2;
                }
                if(l1 == 1)
                {
                    i2 = 3;
                }
                if(l1 == 2)
                {
                    i2 = 4;
                }
                if(l1 == 3)
                {
                    i2 = 5;
                    byte0 = 2;
                }
                if(l1 == 4)
                {
                    i2 = 6;
                    byte0 = 3;
                }
                if(l1 == 5)
                {
                    i2 = 7;
                    byte0 = 5;
                }
                if(l1 == 6)
                {
                    i2 = 6;
                    byte0 = 2;
                }
                if(l1 == 7)
                {
                    i2 = 3;
                }
                float f9 = (float)i2 / 16F;
                float f10 = 1.0F - (float)i1 / 16F;
                float f11 = 1.0F - (float)(i1 + byte0) / 16F;
                i1 += byte0;
                p_1227_1_.func_213_a(0.5F - f9, f11, 0.5F - f9, 0.5F + f9, f10, 0.5F + f9);
                tessellator.func_980_b(0.0F, -1F, 0.0F);
                func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
                tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
                tessellator.func_980_b(0.0F, 0.0F, -1F);
                func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
                tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
                tessellator.func_980_b(-1F, 0.0F, 0.0F);
                func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
                tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
            }

            tessellator.func_982_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        if(j == 11)
        {
            for(int j1 = 0; j1 < 4; j1++)
            {
                float f4 = 0.125F;
                if(j1 == 0)
                {
                    p_1227_1_.func_213_a(0.5F - f4, 0.0F, 0.0F, 0.5F + f4, 1.0F, f4 * 2.0F);
                }
                if(j1 == 1)
                {
                    p_1227_1_.func_213_a(0.5F - f4, 0.0F, 1.0F - f4 * 2.0F, 0.5F + f4, 1.0F, 1.0F);
                }
                f4 = 0.0625F;
                if(j1 == 2)
                {
                    p_1227_1_.func_213_a(0.5F - f4, 1.0F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 1.0F - f4, 1.0F + f4 * 2.0F);
                }
                if(j1 == 3)
                {
                    p_1227_1_.func_213_a(0.5F - f4, 0.5F - f4 * 3F, -f4 * 2.0F, 0.5F + f4, 0.5F - f4, 1.0F + f4 * 2.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, -1F, 0.0F);
                func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, -1F);
                func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(-1F, 0.0F, 0.0F);
                func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
                tessellator.func_982_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else
        if(j == 21)
        {
            for(int k1 = 0; k1 < 3; k1++)
            {
                float f5 = 0.0625F;
                if(k1 == 0)
                {
                    p_1227_1_.func_213_a(0.5F - f5, 0.3F, 0.0F, 0.5F + f5, 1.0F, f5 * 2.0F);
                }
                if(k1 == 1)
                {
                    p_1227_1_.func_213_a(0.5F - f5, 0.3F, 1.0F - f5 * 2.0F, 0.5F + f5, 1.0F, 1.0F);
                }
                f5 = 0.0625F;
                if(k1 == 2)
                {
                    p_1227_1_.func_213_a(0.5F - f5, 0.5F, 0.0F, 0.5F + f5, 1.0F - f5, 1.0F);
                }
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, -1F, 0.0F);
                func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, -1F);
                func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(-1F, 0.0F, 0.0F);
                func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
                tessellator.func_982_a();
                tessellator.func_977_b();
                tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
                tessellator.func_982_a();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public static boolean func_1219_a(int p_1219_0_)
    {
        if(p_1219_0_ == 0)
        {
            return true;
        }
        if(p_1219_0_ == 13)
        {
            return true;
        }
        if(p_1219_0_ == 10)
        {
            return true;
        }
        if(p_1219_0_ == 11)
        {
            return true;
        }
        if(p_1219_0_ == 27)
        {
            return true;
        }
        if(p_1219_0_ == 22)
        {
            return true;
        }
        if(p_1219_0_ == 21)
        {
            return true;
        }
        return p_1219_0_ == 16;
    }

}
