// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IWorldAccess, GLAllocation, RenderList, OpenGlCapsChecker, 
//            Tessellator, World, RenderManager, RenderBlocks, 
//            Block, GameSettings, BlockLeaves, WorldRenderer, 
//            Entity, MathHelper, EntitySorter, Profiler, 
//            TileEntityRenderer, EntityRenderer, ICamera, EntityLiving, 
//            RenderHelper, TileEntity, WorldProvider, RenderEngine, 
//            Vec3D, EntityPlayerSP, RenderSorter, MovingObjectPosition, 
//            EntityPlayer, EnumMovingObjectType, AxisAlignedBB, GuiIngame, 
//            SoundManager, EntityHugeExplodeFX, EffectRenderer, EntityLargeExplodeFX, 
//            EntityBubbleFX, EntitySuspendFX, EntityAuraFX, EntityCritFX, 
//            EntityFX, EntitySmokeFX, EntitySpellParticleFX, EntityNoteFX, 
//            EntityPortalFX, EntityEnchantmentTableParticleFX, EntityExplodeFX, EntityFlameFX, 
//            EntityLavaFX, EntityFootStepFX, EntitySplashFX, EntityCloudFX, 
//            EntityReddustFX, EntityBreakingFX, Item, EntityDropParticleFX, 
//            Material, EntitySnowShovelFX, EntityHeartFX, EntityDiggingFX, 
//            ImageBufferDownload, ItemPotion, StepSound, ItemRecord, 
//            ItemStack

public class RenderGlobal
    implements IWorldAccess
{

    public List field_1458_a;
    private World field_1448_k;
    private RenderEngine field_1447_l;
    private List field_1446_m;
    private WorldRenderer field_1445_n[];
    private WorldRenderer field_1444_o[];
    private int field_1443_p;
    private int field_1442_q;
    private int field_1441_r;
    private int field_1440_s;
    private Minecraft field_1439_t;
    private RenderBlocks field_1438_u;
    private IntBuffer field_1437_v;
    private boolean field_1436_w;
    private int field_1435_x;
    private int field_1434_y;
    private int field_1433_z;
    private int field_1432_A;
    private int field_1431_B;
    private int field_1430_C;
    private int field_1429_D;
    private int field_1428_E;
    private int field_1427_F;
    private int field_1426_G;
    private int field_1425_H;
    private int field_1424_I;
    private int field_1423_J;
    private int field_1422_K;
    private int field_1421_L;
    int field_1457_b[];
    IntBuffer field_1456_c;
    private int field_1420_M;
    private int field_1419_N;
    private int field_1418_O;
    private int field_1417_P;
    private int field_1416_Q;
    private int field_40194_P;
    private int field_21156_R;
    private List field_1415_R;
    private RenderList field_1414_S[] = {
        new RenderList(), new RenderList(), new RenderList(), new RenderList()
    };
    double field_1453_f;
    double field_1452_g;
    double field_1451_h;
    public float field_1450_i;
    int field_1449_j;

    public RenderGlobal(Minecraft p_i437_1_, RenderEngine p_i437_2_)
    {
        field_1458_a = new ArrayList();
        field_1446_m = new ArrayList();
        field_1436_w = false;
        field_1435_x = 0;
        field_1425_H = -1;
        field_1424_I = 2;
        field_1457_b = new int[50000];
        field_1456_c = GLAllocation.func_1125_c(64);
        field_1415_R = new ArrayList();
        field_1453_f = -9999D;
        field_1452_g = -9999D;
        field_1451_h = -9999D;
        field_1449_j = 0;
        field_1439_t = p_i437_1_;
        field_1447_l = p_i437_2_;
        byte byte0 = 34;
        byte byte1 = 32;
        field_1440_s = GLAllocation.func_1124_a(byte0 * byte0 * byte1 * 3);
        field_1436_w = OpenGlCapsChecker.func_1213_a();
        if(field_1436_w)
        {
            field_1456_c.clear();
            field_1437_v = GLAllocation.func_1125_c(byte0 * byte0 * byte1);
            field_1437_v.clear();
            field_1437_v.position(0);
            field_1437_v.limit(byte0 * byte0 * byte1);
            ARBOcclusionQuery.glGenQueriesARB(field_1437_v);
        }
        field_1434_y = GLAllocation.func_1124_a(3);
        GL11.glPushMatrix();
        GL11.glNewList(field_1434_y, 4864);
        func_950_f();
        GL11.glEndList();
        GL11.glPopMatrix();
        Tessellator tessellator = Tessellator.field_1512_a;
        field_1433_z = field_1434_y + 1;
        GL11.glNewList(field_1433_z, 4864);
        byte byte2 = 64;
        int i = 256 / byte2 + 2;
        float f = 16F;
        for(int j = -byte2 * i; j <= byte2 * i; j += byte2)
        {
            for(int l = -byte2 * i; l <= byte2 * i; l += byte2)
            {
                tessellator.func_977_b();
                tessellator.func_991_a(j + 0, f, l + 0);
                tessellator.func_991_a(j + byte2, f, l + 0);
                tessellator.func_991_a(j + byte2, f, l + byte2);
                tessellator.func_991_a(j + 0, f, l + byte2);
                tessellator.func_982_a();
            }

        }

        GL11.glEndList();
        field_1432_A = field_1434_y + 2;
        GL11.glNewList(field_1432_A, 4864);
        f = -16F;
        tessellator.func_977_b();
        for(int k = -byte2 * i; k <= byte2 * i; k += byte2)
        {
            for(int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
            {
                tessellator.func_991_a(k + byte2, f, i1 + 0);
                tessellator.func_991_a(k + 0, f, i1 + 0);
                tessellator.func_991_a(k + 0, f, i1 + byte2);
                tessellator.func_991_a(k + byte2, f, i1 + byte2);
            }

        }

        tessellator.func_982_a();
        GL11.glEndList();
    }

    private void func_950_f()
    {
        Random random = new Random(10842L);
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_977_b();
        for(int i = 0; i < 1500; i++)
        {
            double d = random.nextFloat() * 2.0F - 1.0F;
            double d1 = random.nextFloat() * 2.0F - 1.0F;
            double d2 = random.nextFloat() * 2.0F - 1.0F;
            double d3 = 0.25F + random.nextFloat() * 0.25F;
            double d4 = d * d + d1 * d1 + d2 * d2;
            if(d4 >= 1.0D || d4 <= 0.01D)
            {
                continue;
            }
            d4 = 1.0D / Math.sqrt(d4);
            d *= d4;
            d1 *= d4;
            d2 *= d4;
            double d5 = d * 100D;
            double d6 = d1 * 100D;
            double d7 = d2 * 100D;
            double d8 = Math.atan2(d, d2);
            double d9 = Math.sin(d8);
            double d10 = Math.cos(d8);
            double d11 = Math.atan2(Math.sqrt(d * d + d2 * d2), d1);
            double d12 = Math.sin(d11);
            double d13 = Math.cos(d11);
            double d14 = random.nextDouble() * 3.1415926535897931D * 2D;
            double d15 = Math.sin(d14);
            double d16 = Math.cos(d14);
            for(int j = 0; j < 4; j++)
            {
                double d17 = 0.0D;
                double d18 = (double)((j & 2) - 1) * d3;
                double d19 = (double)((j + 1 & 2) - 1) * d3;
                double d20 = d17;
                double d21 = d18 * d16 - d19 * d15;
                double d22 = d19 * d16 + d18 * d15;
                double d23 = d22;
                double d24 = d21 * d12 + d20 * d13;
                double d25 = d20 * d12 - d21 * d13;
                double d26 = d25 * d9 - d23 * d10;
                double d27 = d24;
                double d28 = d23 * d9 + d25 * d10;
                tessellator.func_991_a(d5 + d26, d6 + d27, d7 + d28);
            }

        }

        tessellator.func_982_a();
    }

    public void func_946_a(World p_946_1_)
    {
        if(field_1448_k != null)
        {
            field_1448_k.func_672_b(this);
        }
        field_1453_f = -9999D;
        field_1452_g = -9999D;
        field_1451_h = -9999D;
        RenderManager.field_1233_a.func_852_a(p_946_1_);
        field_1448_k = p_946_1_;
        field_1438_u = new RenderBlocks(p_946_1_);
        if(p_946_1_ != null)
        {
            p_946_1_.func_613_a(this);
            func_958_a();
        }
    }

    public void func_958_a()
    {
        if(field_1448_k == null)
        {
            return;
        }
        Block.field_384_L.func_310_a(field_1439_t.field_6304_y.field_1576_i);
        field_1425_H = field_1439_t.field_6304_y.field_1580_e;
        if(field_1444_o != null)
        {
            for(int i = 0; i < field_1444_o.length; i++)
            {
                field_1444_o[i].func_1204_c();
            }

        }
        int j = 64 << 3 - field_1425_H;
        if(j > 400)
        {
            j = 400;
        }
        field_1443_p = j / 16 + 1;
        field_1442_q = 16;
        field_1441_r = j / 16 + 1;
        field_1444_o = new WorldRenderer[field_1443_p * field_1442_q * field_1441_r];
        field_1445_n = new WorldRenderer[field_1443_p * field_1442_q * field_1441_r];
        int k = 0;
        int l = 0;
        field_1431_B = 0;
        field_1430_C = 0;
        field_1429_D = 0;
        field_1428_E = field_1443_p;
        field_1427_F = field_1442_q;
        field_1426_G = field_1441_r;
        for(int i1 = 0; i1 < field_1446_m.size(); i1++)
        {
            ((WorldRenderer)field_1446_m.get(i1)).field_1738_u = false;
        }

        field_1446_m.clear();
        field_1458_a.clear();
        for(int j1 = 0; j1 < field_1443_p; j1++)
        {
            for(int k1 = 0; k1 < field_1442_q; k1++)
            {
                for(int l1 = 0; l1 < field_1441_r; l1++)
                {
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1] = new WorldRenderer(field_1448_k, field_1458_a, j1 * 16, k1 * 16, l1 * 16, field_1440_s + k);
                    if(field_1436_w)
                    {
                        field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].field_1732_z = field_1437_v.get(l);
                    }
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].field_1733_y = false;
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].field_1734_x = true;
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].field_1749_o = true;
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].field_1735_w = l++;
                    field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1].func_1194_f();
                    field_1445_n[(l1 * field_1442_q + k1) * field_1443_p + j1] = field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1];
                    field_1446_m.add(field_1444_o[(l1 * field_1442_q + k1) * field_1443_p + j1]);
                    k += 3;
                }

            }

        }

        if(field_1448_k != null)
        {
            EntityLiving entityliving = field_1439_t.field_22009_h;
            if(entityliving != null)
            {
                func_956_b(MathHelper.func_1108_b(((Entity) (entityliving)).field_611_ak), MathHelper.func_1108_b(((Entity) (entityliving)).field_610_al), MathHelper.func_1108_b(((Entity) (entityliving)).field_609_am));
                Arrays.sort(field_1445_n, new EntitySorter(entityliving));
            }
        }
        field_1424_I = 2;
    }

    public void func_951_a(Vec3D p_951_1_, ICamera p_951_2_, float p_951_3_)
    {
        if(field_1424_I > 0)
        {
            field_1424_I--;
            return;
        }
        Profiler.func_40663_a("prepare");
        TileEntityRenderer.field_1554_a.func_22267_a(field_1448_k, field_1447_l, field_1439_t.field_6314_o, field_1439_t.field_22009_h, p_951_3_);
        RenderManager.field_1233_a.func_22187_a(field_1448_k, field_1447_l, field_1439_t.field_6314_o, field_1439_t.field_22009_h, field_1439_t.field_6304_y, p_951_3_);
        TileEntityRenderer.field_1554_a.func_40742_a();
        field_1423_J = 0;
        field_1422_K = 0;
        field_1421_L = 0;
        EntityLiving entityliving = field_1439_t.field_22009_h;
        RenderManager.field_1232_b = ((Entity) (entityliving)).field_638_aI + (((Entity) (entityliving)).field_611_ak - ((Entity) (entityliving)).field_638_aI) * (double)p_951_3_;
        RenderManager.field_1231_c = ((Entity) (entityliving)).field_637_aJ + (((Entity) (entityliving)).field_610_al - ((Entity) (entityliving)).field_637_aJ) * (double)p_951_3_;
        RenderManager.field_1230_d = ((Entity) (entityliving)).field_636_aK + (((Entity) (entityliving)).field_609_am - ((Entity) (entityliving)).field_636_aK) * (double)p_951_3_;
        TileEntityRenderer.field_1553_b = ((Entity) (entityliving)).field_638_aI + (((Entity) (entityliving)).field_611_ak - ((Entity) (entityliving)).field_638_aI) * (double)p_951_3_;
        TileEntityRenderer.field_1552_c = ((Entity) (entityliving)).field_637_aJ + (((Entity) (entityliving)).field_610_al - ((Entity) (entityliving)).field_637_aJ) * (double)p_951_3_;
        TileEntityRenderer.field_1551_d = ((Entity) (entityliving)).field_636_aK + (((Entity) (entityliving)).field_609_am - ((Entity) (entityliving)).field_636_aK) * (double)p_951_3_;
        field_1439_t.field_9243_r.func_35806_b(p_951_3_);
        Profiler.func_40661_c("global");
        List list = field_1448_k.func_658_i();
        field_1423_J = list.size();
        for(int i = 0; i < field_1448_k.field_27173_e.size(); i++)
        {
            Entity entity = (Entity)field_1448_k.field_27173_e.get(i);
            field_1422_K++;
            if(entity.func_390_a(p_951_1_))
            {
                RenderManager.field_1233_a.func_854_a(entity, p_951_3_);
            }
        }

        Profiler.func_40661_c("entities");
        for(int j = 0; j < list.size(); j++)
        {
            Entity entity1 = (Entity)list.get(j);
            if(entity1.func_390_a(p_951_1_) && (entity1.field_28016_bK || p_951_2_.func_342_a(entity1.field_601_au)) && (entity1 != field_1439_t.field_22009_h || field_1439_t.field_6304_y.field_1560_x != 0 || field_1439_t.field_22009_h.func_22051_K()) && field_1448_k.func_630_d(MathHelper.func_1108_b(entity1.field_611_ak), 0, MathHelper.func_1108_b(entity1.field_609_am)))
            {
                field_1422_K++;
                RenderManager.field_1233_a.func_854_a(entity1, p_951_3_);
            }
        }

        Profiler.func_40661_c("tileentities");
        RenderHelper.func_1158_b();
        for(int k = 0; k < field_1458_a.size(); k++)
        {
            TileEntityRenderer.field_1554_a.func_1030_a((TileEntity)field_1458_a.get(k), p_951_3_);
        }

        field_1439_t.field_9243_r.func_35810_a(p_951_3_);
        Profiler.func_40662_b();
    }

    public String func_953_b()
    {
        return (new StringBuilder()).append("C: ").append(field_1417_P).append("/").append(field_1420_M).append(". F: ").append(field_1419_N).append(", O: ").append(field_1418_O).append(", E: ").append(field_1416_Q).toString();
    }

    public String func_957_c()
    {
        return (new StringBuilder()).append("E: ").append(field_1422_K).append("/").append(field_1423_J).append(". B: ").append(field_1421_L).append(", I: ").append(field_1423_J - field_1421_L - field_1422_K).toString();
    }

    private void func_956_b(int p_956_1_, int p_956_2_, int p_956_3_)
    {
        p_956_1_ -= 8;
        p_956_2_ -= 8;
        p_956_3_ -= 8;
        field_1431_B = 0x7fffffff;
        field_1430_C = 0x7fffffff;
        field_1429_D = 0x7fffffff;
        field_1428_E = 0x80000000;
        field_1427_F = 0x80000000;
        field_1426_G = 0x80000000;
        int i = field_1443_p * 16;
        int j = i / 2;
        for(int k = 0; k < field_1443_p; k++)
        {
            int l = k * 16;
            int i1 = (l + j) - p_956_1_;
            if(i1 < 0)
            {
                i1 -= i - 1;
            }
            i1 /= i;
            l -= i1 * i;
            if(l < field_1431_B)
            {
                field_1431_B = l;
            }
            if(l > field_1428_E)
            {
                field_1428_E = l;
            }
            for(int j1 = 0; j1 < field_1441_r; j1++)
            {
                int k1 = j1 * 16;
                int l1 = (k1 + j) - p_956_3_;
                if(l1 < 0)
                {
                    l1 -= i - 1;
                }
                l1 /= i;
                k1 -= l1 * i;
                if(k1 < field_1429_D)
                {
                    field_1429_D = k1;
                }
                if(k1 > field_1426_G)
                {
                    field_1426_G = k1;
                }
                for(int i2 = 0; i2 < field_1442_q; i2++)
                {
                    int j2 = i2 * 16;
                    if(j2 < field_1430_C)
                    {
                        field_1430_C = j2;
                    }
                    if(j2 > field_1427_F)
                    {
                        field_1427_F = j2;
                    }
                    WorldRenderer worldrenderer = field_1444_o[(j1 * field_1442_q + i2) * field_1443_p + k];
                    boolean flag = worldrenderer.field_1738_u;
                    worldrenderer.func_1197_a(l, j2, k1);
                    if(!flag && worldrenderer.field_1738_u)
                    {
                        field_1446_m.add(worldrenderer);
                    }
                }

            }

        }

    }

    public int func_943_a(EntityLiving p_943_1_, int p_943_2_, double p_943_3_)
    {
        Profiler.func_40663_a("sortchunks");
        for(int i = 0; i < 10; i++)
        {
            field_21156_R = (field_21156_R + 1) % field_1444_o.length;
            WorldRenderer worldrenderer = field_1444_o[field_21156_R];
            if(worldrenderer.field_1738_u && !field_1446_m.contains(worldrenderer))
            {
                field_1446_m.add(worldrenderer);
            }
        }

        if(field_1439_t.field_6304_y.field_1580_e != field_1425_H)
        {
            func_958_a();
        }
        if(p_943_2_ == 0)
        {
            field_1420_M = 0;
            field_40194_P = 0;
            field_1419_N = 0;
            field_1418_O = 0;
            field_1417_P = 0;
            field_1416_Q = 0;
        }
        double d = p_943_1_.field_638_aI + (p_943_1_.field_611_ak - p_943_1_.field_638_aI) * p_943_3_;
        double d1 = p_943_1_.field_637_aJ + (p_943_1_.field_610_al - p_943_1_.field_637_aJ) * p_943_3_;
        double d2 = p_943_1_.field_636_aK + (p_943_1_.field_609_am - p_943_1_.field_636_aK) * p_943_3_;
        double d3 = p_943_1_.field_611_ak - field_1453_f;
        double d4 = p_943_1_.field_610_al - field_1452_g;
        double d5 = p_943_1_.field_609_am - field_1451_h;
        if(d3 * d3 + d4 * d4 + d5 * d5 > 16D)
        {
            field_1453_f = p_943_1_.field_611_ak;
            field_1452_g = p_943_1_.field_610_al;
            field_1451_h = p_943_1_.field_609_am;
            func_956_b(MathHelper.func_1108_b(p_943_1_.field_611_ak), MathHelper.func_1108_b(p_943_1_.field_610_al), MathHelper.func_1108_b(p_943_1_.field_609_am));
            Arrays.sort(field_1445_n, new EntitySorter(p_943_1_));
        }
        RenderHelper.func_1159_a();
        int j = 0;
        if(field_1436_w && field_1439_t.field_6304_y.field_27342_h && !field_1439_t.field_6304_y.field_1578_g && p_943_2_ == 0)
        {
            int k = 0;
            int l = 16;
            func_962_a(k, l);
            for(int i1 = k; i1 < l; i1++)
            {
                field_1445_n[i1].field_1734_x = true;
            }

            Profiler.func_40661_c("render");
            j += func_952_a(k, l, p_943_2_, p_943_3_);
            do
            {
                Profiler.func_40661_c("occ");
                byte byte0 = l;
                l *= 2;
                if(l > field_1445_n.length)
                {
                    l = field_1445_n.length;
                }
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                Profiler.func_40663_a("check");
                func_962_a(byte0, l);
                Profiler.func_40662_b();
                GL11.glPushMatrix();
                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                for(int j1 = byte0; j1 < l; j1++)
                {
                    if(field_1445_n[j1].func_1196_e())
                    {
                        field_1445_n[j1].field_1749_o = false;
                        continue;
                    }
                    if(!field_1445_n[j1].field_1749_o)
                    {
                        field_1445_n[j1].field_1734_x = true;
                    }
                    if(!field_1445_n[j1].field_1749_o || field_1445_n[j1].field_1733_y)
                    {
                        continue;
                    }
                    float f3 = MathHelper.func_1113_c(field_1445_n[j1].func_1202_a(p_943_1_));
                    int k1 = (int)(1.0F + f3 / 128F);
                    if(field_1435_x % k1 != j1 % k1)
                    {
                        continue;
                    }
                    WorldRenderer worldrenderer1 = field_1445_n[j1];
                    float f4 = (float)((double)worldrenderer1.field_1755_i - d);
                    float f5 = (float)((double)worldrenderer1.field_1754_j - d1);
                    float f6 = (float)((double)worldrenderer1.field_1753_k - d2);
                    float f7 = f4 - f;
                    float f8 = f5 - f1;
                    float f9 = f6 - f2;
                    if(f7 != 0.0F || f8 != 0.0F || f9 != 0.0F)
                    {
                        GL11.glTranslatef(f7, f8, f9);
                        f += f7;
                        f1 += f8;
                        f2 += f9;
                    }
                    Profiler.func_40663_a("bb");
                    ARBOcclusionQuery.glBeginQueryARB(35092, field_1445_n[j1].field_1732_z);
                    field_1445_n[j1].func_1201_d();
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    Profiler.func_40662_b();
                    field_1445_n[j1].field_1733_y = true;
                }

                GL11.glPopMatrix();
                if(field_1439_t.field_6304_y.field_1578_g)
                {
                    if(EntityRenderer.field_28134_b == 0)
                    {
                        GL11.glColorMask(false, true, true, true);
                    } else
                    {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else
                {
                    GL11.glColorMask(true, true, true, true);
                }
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                Profiler.func_40661_c("render");
                j += func_952_a(byte0, l, p_943_2_, p_943_3_);
            } while(l < field_1445_n.length);
        } else
        {
            Profiler.func_40661_c("render");
            j += func_952_a(0, field_1445_n.length, p_943_2_, p_943_3_);
        }
        Profiler.func_40662_b();
        return j;
    }

    private void func_962_a(int p_962_1_, int p_962_2_)
    {
        for(int i = p_962_1_; i < p_962_2_; i++)
        {
            if(!field_1445_n[i].field_1733_y)
            {
                continue;
            }
            field_1456_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(field_1445_n[i].field_1732_z, 34919, field_1456_c);
            if(field_1456_c.get(0) != 0)
            {
                field_1445_n[i].field_1733_y = false;
                field_1456_c.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB(field_1445_n[i].field_1732_z, 34918, field_1456_c);
                field_1445_n[i].field_1734_x = field_1456_c.get(0) != 0;
            }
        }

    }

    private int func_952_a(int p_952_1_, int p_952_2_, int p_952_3_, double p_952_4_)
    {
        field_1415_R.clear();
        int i = 0;
        for(int j = p_952_1_; j < p_952_2_; j++)
        {
            if(p_952_3_ == 0)
            {
                field_1420_M++;
                if(field_1445_n[j].field_1748_p[p_952_3_])
                {
                    field_1416_Q++;
                } else
                if(!field_1445_n[j].field_1749_o)
                {
                    field_1419_N++;
                } else
                if(field_1436_w && !field_1445_n[j].field_1734_x)
                {
                    field_1418_O++;
                } else
                {
                    field_1417_P++;
                }
            }
            if(field_1445_n[j].field_1748_p[p_952_3_] || !field_1445_n[j].field_1749_o || field_1436_w && !field_1445_n[j].field_1734_x)
            {
                continue;
            }
            int k = field_1445_n[j].func_1200_a(p_952_3_);
            if(k >= 0)
            {
                field_1415_R.add(field_1445_n[j]);
                i++;
            }
        }

        EntityLiving entityliving = field_1439_t.field_22009_h;
        double d = entityliving.field_638_aI + (entityliving.field_611_ak - entityliving.field_638_aI) * p_952_4_;
        double d1 = entityliving.field_637_aJ + (entityliving.field_610_al - entityliving.field_637_aJ) * p_952_4_;
        double d2 = entityliving.field_636_aK + (entityliving.field_609_am - entityliving.field_636_aK) * p_952_4_;
        int l = 0;
        for(int i1 = 0; i1 < field_1414_S.length; i1++)
        {
            field_1414_S[i1].func_859_b();
        }

        for(int j1 = 0; j1 < field_1415_R.size(); j1++)
        {
            WorldRenderer worldrenderer = (WorldRenderer)field_1415_R.get(j1);
            int k1 = -1;
            for(int l1 = 0; l1 < l; l1++)
            {
                if(field_1414_S[l1].func_862_a(worldrenderer.field_1755_i, worldrenderer.field_1754_j, worldrenderer.field_1753_k))
                {
                    k1 = l1;
                }
            }

            if(k1 < 0)
            {
                k1 = l++;
                field_1414_S[k1].func_861_a(worldrenderer.field_1755_i, worldrenderer.field_1754_j, worldrenderer.field_1753_k, d, d1, d2);
            }
            field_1414_S[k1].func_858_a(worldrenderer.func_1200_a(p_952_3_));
        }

        func_944_a(p_952_3_, p_952_4_);
        return i;
    }

    public void func_944_a(int p_944_1_, double p_944_2_)
    {
        field_1439_t.field_9243_r.func_35806_b(p_944_2_);
        for(int i = 0; i < field_1414_S.length; i++)
        {
            field_1414_S[i].func_860_a();
        }

        field_1439_t.field_9243_r.func_35810_a(p_944_2_);
    }

    public void func_945_d()
    {
        field_1435_x++;
    }

    public void func_4142_a(float p_4142_1_)
    {
        if(field_1439_t.field_6324_e.field_4209_q.field_4218_e == 1)
        {
            GL11.glDisable(2912);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            RenderHelper.func_1159_a();
            GL11.glDepthMask(false);
            field_1447_l.func_1076_b(field_1447_l.func_1070_a("/misc/tunnel.png"));
            Tessellator tessellator = Tessellator.field_1512_a;
            for(int i = 0; i < 6; i++)
            {
                GL11.glPushMatrix();
                if(i == 1)
                {
                    GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 2)
                {
                    GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 3)
                {
                    GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
                }
                if(i == 4)
                {
                    GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
                }
                if(i == 5)
                {
                    GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
                }
                tessellator.func_977_b();
                tessellator.func_990_b(0x181818);
                tessellator.func_983_a(-100D, -100D, -100D, 0.0D, 0.0D);
                tessellator.func_983_a(-100D, -100D, 100D, 0.0D, 16D);
                tessellator.func_983_a(100D, -100D, 100D, 16D, 16D);
                tessellator.func_983_a(100D, -100D, -100D, 16D, 0.0D);
                tessellator.func_982_a();
                GL11.glPopMatrix();
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            return;
        }
        if(!field_1439_t.field_6324_e.field_4209_q.func_48217_e())
        {
            return;
        }
        GL11.glDisable(3553);
        Vec3D vec3d = field_1448_k.func_4079_a(field_1439_t.field_22009_h, p_4142_1_);
        float f = (float)vec3d.field_1776_a;
        float f1 = (float)vec3d.field_1775_b;
        float f2 = (float)vec3d.field_1779_c;
        if(field_1439_t.field_6304_y.field_1578_g)
        {
            float f3 = (f * 30F + f1 * 59F + f2 * 11F) / 100F;
            float f4 = (f * 30F + f1 * 70F) / 100F;
            float f5 = (f * 30F + f2 * 70F) / 100F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }
        GL11.glColor3f(f, f1, f2);
        Tessellator tessellator1 = Tessellator.field_1512_a;
        GL11.glDepthMask(false);
        GL11.glEnable(2912);
        GL11.glColor3f(f, f1, f2);
        GL11.glCallList(field_1433_z);
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderHelper.func_1159_a();
        float af[] = field_1448_k.field_4209_q.func_4097_b(field_1448_k.func_619_c(p_4142_1_), p_4142_1_);
        if(af != null)
        {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.func_1106_a(field_1448_k.func_35456_d(p_4142_1_)) >= 0.0F ? 0.0F : 180F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
            float f6 = af[0];
            float f8 = af[1];
            float f11 = af[2];
            if(field_1439_t.field_6304_y.field_1578_g)
            {
                float f14 = (f6 * 30F + f8 * 59F + f11 * 11F) / 100F;
                float f17 = (f6 * 30F + f8 * 70F) / 100F;
                float f20 = (f6 * 30F + f11 * 70F) / 100F;
                f6 = f14;
                f8 = f17;
                f11 = f20;
            }
            tessellator1.func_992_a(6);
            tessellator1.func_986_a(f6, f8, f11, af[3]);
            tessellator1.func_991_a(0.0D, 100D, 0.0D);
            int j = 16;
            tessellator1.func_986_a(af[0], af[1], af[2], 0.0F);
            for(int k = 0; k <= j; k++)
            {
                float f21 = ((float)k * 3.141593F * 2.0F) / (float)j;
                float f22 = MathHelper.func_1106_a(f21);
                float f23 = MathHelper.func_1114_b(f21);
                tessellator1.func_991_a(f22 * 120F, f23 * 120F, -f23 * 40F * af[3]);
            }

            tessellator1.func_982_a();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
        }
        GL11.glEnable(3553);
        GL11.glBlendFunc(770, 1);
        GL11.glPushMatrix();
        double d = 1.0F - field_1448_k.func_27162_g(p_4142_1_);
        float f7 = 0.0F;
        float f9 = 0.0F;
        float f12 = 0.0F;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, d);
        GL11.glTranslatef(f7, f9, f12);
        GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(field_1448_k.func_619_c(p_4142_1_) * 360F, 1.0F, 0.0F, 0.0F);
        float f15 = 30F;
        GL11.glBindTexture(3553, field_1447_l.func_1070_a("/terrain/sun.png"));
        tessellator1.func_977_b();
        tessellator1.func_983_a(-f15, 100D, -f15, 0.0D, 0.0D);
        tessellator1.func_983_a(f15, 100D, -f15, 1.0D, 0.0D);
        tessellator1.func_983_a(f15, 100D, f15, 1.0D, 1.0D);
        tessellator1.func_983_a(-f15, 100D, f15, 0.0D, 1.0D);
        tessellator1.func_982_a();
        f15 = 20F;
        GL11.glBindTexture(3553, field_1447_l.func_1070_a("/terrain/moon_phases.png"));
        float f18 = field_1448_k.func_40475_d(p_4142_1_);
        int l = f18 % 4;
        int i1 = (f18 / 4) % 2;
        float f24 = (float)(l + 0) / 4F;
        float f25 = (float)(i1 + 0) / 2.0F;
        float f26 = (float)(l + 1) / 4F;
        float f27 = (float)(i1 + 1) / 2.0F;
        tessellator1.func_977_b();
        tessellator1.func_983_a(-f15, -100D, f15, f26, f27);
        tessellator1.func_983_a(f15, -100D, f15, f24, f27);
        tessellator1.func_983_a(f15, -100D, -f15, f24, f25);
        tessellator1.func_983_a(-f15, -100D, -f15, f26, f25);
        tessellator1.func_982_a();
        GL11.glDisable(3553);
        f18 = field_1448_k.func_679_f(p_4142_1_) * d;
        if(f18 > 0.0F)
        {
            GL11.glColor4f(f18, f18, f18, f18);
            GL11.glCallList(field_1434_y);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glDisable(3553);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);
        d = field_1439_t.field_6322_g.func_427_e(p_4142_1_).field_1775_b - field_1448_k.func_46068_G();
        if(d < 0.0D)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12F, 0.0F);
            GL11.glCallList(field_1432_A);
            GL11.glPopMatrix();
            float f10 = 1.0F;
            float f13 = -(float)(d + 65D);
            float f16 = -f10;
            float f19 = f13;
            tessellator1.func_977_b();
            tessellator1.func_6513_a(0, 255);
            tessellator1.func_991_a(-f10, f19, f10);
            tessellator1.func_991_a(f10, f19, f10);
            tessellator1.func_991_a(f10, f16, f10);
            tessellator1.func_991_a(-f10, f16, f10);
            tessellator1.func_991_a(-f10, f16, -f10);
            tessellator1.func_991_a(f10, f16, -f10);
            tessellator1.func_991_a(f10, f19, -f10);
            tessellator1.func_991_a(-f10, f19, -f10);
            tessellator1.func_991_a(f10, f16, -f10);
            tessellator1.func_991_a(f10, f16, f10);
            tessellator1.func_991_a(f10, f19, f10);
            tessellator1.func_991_a(f10, f19, -f10);
            tessellator1.func_991_a(-f10, f19, -f10);
            tessellator1.func_991_a(-f10, f19, f10);
            tessellator1.func_991_a(-f10, f16, f10);
            tessellator1.func_991_a(-f10, f16, -f10);
            tessellator1.func_991_a(-f10, f16, -f10);
            tessellator1.func_991_a(-f10, f16, f10);
            tessellator1.func_991_a(f10, f16, f10);
            tessellator1.func_991_a(f10, f16, -f10);
            tessellator1.func_982_a();
        }
        if(field_1448_k.field_4209_q.func_28112_c())
        {
            GL11.glColor3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
        } else
        {
            GL11.glColor3f(f, f1, f2);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -(float)(d - 16D), 0.0F);
        GL11.glCallList(field_1432_A);
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
    }

    public void func_4141_b(float p_4141_1_)
    {
        if(!field_1439_t.field_6324_e.field_4209_q.func_48217_e())
        {
            return;
        }
        if(field_1439_t.field_6304_y.field_1576_i)
        {
            func_6510_c(p_4141_1_);
            return;
        }
        GL11.glDisable(2884);
        float f = (float)(field_1439_t.field_22009_h.field_637_aJ + (field_1439_t.field_22009_h.field_610_al - field_1439_t.field_22009_h.field_637_aJ) * (double)p_4141_1_);
        byte byte0 = 32;
        int i = 256 / byte0;
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, field_1447_l.func_1070_a("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3D vec3d = field_1448_k.func_628_d(p_4141_1_);
        float f1 = (float)vec3d.field_1776_a;
        float f2 = (float)vec3d.field_1775_b;
        float f3 = (float)vec3d.field_1779_c;
        if(field_1439_t.field_6304_y.field_1578_g)
        {
            float f4 = (f1 * 30F + f2 * 59F + f3 * 11F) / 100F;
            float f6 = (f1 * 30F + f2 * 70F) / 100F;
            float f7 = (f1 * 30F + f3 * 70F) / 100F;
            f1 = f4;
            f2 = f6;
            f3 = f7;
        }
        float f5 = 0.0004882813F;
        double d = (float)field_1435_x + p_4141_1_;
        double d1 = field_1439_t.field_22009_h.field_9285_at + (field_1439_t.field_22009_h.field_611_ak - field_1439_t.field_22009_h.field_9285_at) * (double)p_4141_1_ + d * 0.029999999329447746D;
        double d2 = field_1439_t.field_22009_h.field_9283_av + (field_1439_t.field_22009_h.field_609_am - field_1439_t.field_22009_h.field_9283_av) * (double)p_4141_1_;
        int j = MathHelper.func_1108_b(d1 / 2048D);
        int k = MathHelper.func_1108_b(d2 / 2048D);
        d1 -= j * 2048;
        d2 -= k * 2048;
        float f8 = (field_1448_k.field_4209_q.func_28111_d() - f) + 0.33F;
        float f9 = (float)(d1 * (double)f5);
        float f10 = (float)(d2 * (double)f5);
        tessellator.func_977_b();
        tessellator.func_986_a(f1, f2, f3, 0.8F);
        for(int l = -byte0 * i; l < byte0 * i; l += byte0)
        {
            for(int i1 = -byte0 * i; i1 < byte0 * i; i1 += byte0)
            {
                tessellator.func_983_a(l + 0, f8, i1 + byte0, (float)(l + 0) * f5 + f9, (float)(i1 + byte0) * f5 + f10);
                tessellator.func_983_a(l + byte0, f8, i1 + byte0, (float)(l + byte0) * f5 + f9, (float)(i1 + byte0) * f5 + f10);
                tessellator.func_983_a(l + byte0, f8, i1 + 0, (float)(l + byte0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
                tessellator.func_983_a(l + 0, f8, i1 + 0, (float)(l + 0) * f5 + f9, (float)(i1 + 0) * f5 + f10);
            }

        }

        tessellator.func_982_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_27307_a(double p_27307_1_, double p_27307_3_, double d, float f)
    {
        return false;
    }

    public void func_6510_c(float p_6510_1_)
    {
        GL11.glDisable(2884);
        float f = (float)(field_1439_t.field_22009_h.field_637_aJ + (field_1439_t.field_22009_h.field_610_al - field_1439_t.field_22009_h.field_637_aJ) * (double)p_6510_1_);
        Tessellator tessellator = Tessellator.field_1512_a;
        float f1 = 12F;
        float f2 = 4F;
        double d = (float)field_1435_x + p_6510_1_;
        double d1 = (field_1439_t.field_22009_h.field_9285_at + (field_1439_t.field_22009_h.field_611_ak - field_1439_t.field_22009_h.field_9285_at) * (double)p_6510_1_ + d * 0.029999999329447746D) / (double)f1;
        double d2 = (field_1439_t.field_22009_h.field_9283_av + (field_1439_t.field_22009_h.field_609_am - field_1439_t.field_22009_h.field_9283_av) * (double)p_6510_1_) / (double)f1 + 0.33000001311302185D;
        float f3 = (field_1448_k.field_4209_q.func_28111_d() - f) + 0.33F;
        int i = MathHelper.func_1108_b(d1 / 2048D);
        int j = MathHelper.func_1108_b(d2 / 2048D);
        d1 -= i * 2048;
        d2 -= j * 2048;
        GL11.glBindTexture(3553, field_1447_l.func_1070_a("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3D vec3d = field_1448_k.func_628_d(p_6510_1_);
        float f4 = (float)vec3d.field_1776_a;
        float f5 = (float)vec3d.field_1775_b;
        float f6 = (float)vec3d.field_1779_c;
        if(field_1439_t.field_6304_y.field_1578_g)
        {
            float f7 = (f4 * 30F + f5 * 59F + f6 * 11F) / 100F;
            float f9 = (f4 * 30F + f5 * 70F) / 100F;
            float f11 = (f4 * 30F + f6 * 70F) / 100F;
            f4 = f7;
            f5 = f9;
            f6 = f11;
        }
        float f8 = (float)(d1 * 0.0D);
        float f10 = (float)(d2 * 0.0D);
        float f12 = 0.00390625F;
        f8 = (float)MathHelper.func_1108_b(d1) * f12;
        f10 = (float)MathHelper.func_1108_b(d2) * f12;
        float f13 = (float)(d1 - (double)MathHelper.func_1108_b(d1));
        float f14 = (float)(d2 - (double)MathHelper.func_1108_b(d2));
        int k = 8;
        byte byte0 = 4;
        float f15 = 0.0009765625F;
        GL11.glScalef(f1, 1.0F, f1);
        for(int l = 0; l < 2; l++)
        {
            if(l == 0)
            {
                GL11.glColorMask(false, false, false, false);
            } else
            if(field_1439_t.field_6304_y.field_1578_g)
            {
                if(EntityRenderer.field_28134_b == 0)
                {
                    GL11.glColorMask(false, true, true, true);
                } else
                {
                    GL11.glColorMask(true, false, false, true);
                }
            } else
            {
                GL11.glColorMask(true, true, true, true);
            }
            for(int i1 = -byte0 + 1; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0 + 1; j1 <= byte0; j1++)
                {
                    tessellator.func_977_b();
                    float f16 = i1 * k;
                    float f17 = j1 * k;
                    float f18 = f16 - f13;
                    float f19 = f17 - f14;
                    if(f3 > -f2 - 1.0F)
                    {
                        tessellator.func_986_a(f4 * 0.7F, f5 * 0.7F, f6 * 0.7F, 0.8F);
                        tessellator.func_980_b(0.0F, -1F, 0.0F);
                        tessellator.func_983_a(f18 + 0.0F, f3 + 0.0F, f19 + (float)k, (f16 + 0.0F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_983_a(f18 + (float)k, f3 + 0.0F, f19 + (float)k, (f16 + (float)k) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_983_a(f18 + (float)k, f3 + 0.0F, f19 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        tessellator.func_983_a(f18 + 0.0F, f3 + 0.0F, f19 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                    }
                    if(f3 <= f2 + 1.0F)
                    {
                        tessellator.func_986_a(f4, f5, f6, 0.8F);
                        tessellator.func_980_b(0.0F, 1.0F, 0.0F);
                        tessellator.func_983_a(f18 + 0.0F, (f3 + f2) - f15, f19 + (float)k, (f16 + 0.0F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_983_a(f18 + (float)k, (f3 + f2) - f15, f19 + (float)k, (f16 + (float)k) * f12 + f8, (f17 + (float)k) * f12 + f10);
                        tessellator.func_983_a(f18 + (float)k, (f3 + f2) - f15, f19 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        tessellator.func_983_a(f18 + 0.0F, (f3 + f2) - f15, f19 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                    }
                    tessellator.func_986_a(f4 * 0.9F, f5 * 0.9F, f6 * 0.9F, 0.8F);
                    if(i1 > -1)
                    {
                        tessellator.func_980_b(-1F, 0.0F, 0.0F);
                        for(int k1 = 0; k1 < k; k1++)
                        {
                            tessellator.func_983_a(f18 + (float)k1 + 0.0F, f3 + 0.0F, f19 + (float)k, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k1 + 0.0F, f3 + f2, f19 + (float)k, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k1 + 0.0F, f3 + f2, f19 + 0.0F, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k1 + 0.0F, f3 + 0.0F, f19 + 0.0F, (f16 + (float)k1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        }

                    }
                    if(i1 <= 1)
                    {
                        tessellator.func_980_b(1.0F, 0.0F, 0.0F);
                        for(int l1 = 0; l1 < k; l1++)
                        {
                            tessellator.func_983_a((f18 + (float)l1 + 1.0F) - f15, f3 + 0.0F, f19 + (float)k, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_983_a((f18 + (float)l1 + 1.0F) - f15, f3 + f2, f19 + (float)k, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + (float)k) * f12 + f10);
                            tessellator.func_983_a((f18 + (float)l1 + 1.0F) - f15, f3 + f2, f19 + 0.0F, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                            tessellator.func_983_a((f18 + (float)l1 + 1.0F) - f15, f3 + 0.0F, f19 + 0.0F, (f16 + (float)l1 + 0.5F) * f12 + f8, (f17 + 0.0F) * f12 + f10);
                        }

                    }
                    tessellator.func_986_a(f4 * 0.8F, f5 * 0.8F, f6 * 0.8F, 0.8F);
                    if(j1 > -1)
                    {
                        tessellator.func_980_b(0.0F, 0.0F, -1F);
                        for(int i2 = 0; i2 < k; i2++)
                        {
                            tessellator.func_983_a(f18 + 0.0F, f3 + f2, f19 + (float)i2 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k, f3 + f2, f19 + (float)i2 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k, f3 + 0.0F, f19 + (float)i2 + 0.0F, (f16 + (float)k) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + 0.0F, f3 + 0.0F, f19 + (float)i2 + 0.0F, (f16 + 0.0F) * f12 + f8, (f17 + (float)i2 + 0.5F) * f12 + f10);
                        }

                    }
                    if(j1 <= 1)
                    {
                        tessellator.func_980_b(0.0F, 0.0F, 1.0F);
                        for(int j2 = 0; j2 < k; j2++)
                        {
                            tessellator.func_983_a(f18 + 0.0F, f3 + f2, (f19 + (float)j2 + 1.0F) - f15, (f16 + 0.0F) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k, f3 + f2, (f19 + (float)j2 + 1.0F) - f15, (f16 + (float)k) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + (float)k, f3 + 0.0F, (f19 + (float)j2 + 1.0F) - f15, (f16 + (float)k) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                            tessellator.func_983_a(f18 + 0.0F, f3 + 0.0F, (f19 + (float)j2 + 1.0F) - f15, (f16 + 0.0F) * f12 + f8, (f17 + (float)j2 + 0.5F) * f12 + f10);
                        }

                    }
                    tessellator.func_982_a();
                }

            }

        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_948_a(EntityLiving p_948_1_, boolean p_948_2_)
    {
        boolean flag = false;
        if(flag)
        {
            Collections.sort(field_1446_m, new RenderSorter(p_948_1_));
            int i = field_1446_m.size() - 1;
            int j = field_1446_m.size();
            for(int k = 0; k < j; k++)
            {
                WorldRenderer worldrenderer = (WorldRenderer)field_1446_m.get(i - k);
                if(!p_948_2_)
                {
                    if(worldrenderer.func_1202_a(p_948_1_) > 256F)
                    {
                        if(worldrenderer.field_1749_o)
                        {
                            if(k >= 30)
                            {
                                return false;
                            }
                        } else
                        if(k >= 1)
                        {
                            return false;
                        }
                    }
                } else
                if(!worldrenderer.field_1749_o)
                {
                    continue;
                }
                worldrenderer.func_1198_a();
                field_1446_m.remove(worldrenderer);
                worldrenderer.field_1738_u = false;
            }

            return field_1446_m.size() == 0;
        }
        byte byte0 = 2;
        RenderSorter rendersorter = new RenderSorter(p_948_1_);
        WorldRenderer aworldrenderer[] = new WorldRenderer[byte0];
        ArrayList arraylist = null;
        int l = field_1446_m.size();
        int i1 = 0;
        for(int j1 = 0; j1 < l; j1++)
        {
            WorldRenderer worldrenderer1 = (WorldRenderer)field_1446_m.get(j1);
            if(!p_948_2_)
            {
                if(worldrenderer1.func_1202_a(p_948_1_) > 256F)
                {
                    int k2;
                    for(k2 = 0; k2 < byte0 && (aworldrenderer[k2] == null || rendersorter.func_993_a(aworldrenderer[k2], worldrenderer1) <= 0); k2++) { }
                    if(--k2 <= 0)
                    {
                        continue;
                    }
                    for(int i3 = k2; --i3 != 0;)
                    {
                        aworldrenderer[i3 - 1] = aworldrenderer[i3];
                    }

                    aworldrenderer[k2] = worldrenderer1;
                    continue;
                }
            } else
            if(!worldrenderer1.field_1749_o)
            {
                continue;
            }
            if(arraylist == null)
            {
                arraylist = new ArrayList();
            }
            i1++;
            arraylist.add(worldrenderer1);
            field_1446_m.set(j1, null);
        }

        if(arraylist != null)
        {
            if(arraylist.size() > 1)
            {
                Collections.sort(arraylist, rendersorter);
            }
            for(int k1 = arraylist.size() - 1; k1 >= 0; k1--)
            {
                WorldRenderer worldrenderer2 = (WorldRenderer)arraylist.get(k1);
                worldrenderer2.func_1198_a();
                worldrenderer2.field_1738_u = false;
            }

        }
        int l1 = 0;
        for(int i2 = byte0 - 1; i2 >= 0; i2--)
        {
            WorldRenderer worldrenderer3 = aworldrenderer[i2];
            if(worldrenderer3 == null)
            {
                continue;
            }
            if(!worldrenderer3.field_1749_o && i2 != byte0 - 1)
            {
                aworldrenderer[i2] = null;
                aworldrenderer[0] = null;
                break;
            }
            aworldrenderer[i2].func_1198_a();
            aworldrenderer[i2].field_1738_u = false;
            l1++;
        }

        int j2 = 0;
        int l2 = 0;
        for(int j3 = field_1446_m.size(); j2 != j3; j2++)
        {
            WorldRenderer worldrenderer4 = (WorldRenderer)field_1446_m.get(j2);
            if(worldrenderer4 == null)
            {
                continue;
            }
            boolean flag1 = false;
            for(int k3 = 0; k3 < byte0 && !flag1; k3++)
            {
                if(worldrenderer4 == aworldrenderer[k3])
                {
                    flag1 = true;
                }
            }

            if(flag1)
            {
                continue;
            }
            if(l2 != j2)
            {
                field_1446_m.set(l2, worldrenderer4);
            }
            l2++;
        }

        while(--j2 >= l2) 
        {
            field_1446_m.remove(j2);
        }
        return l == i1 + l1;
    }

    public void func_959_a(EntityPlayer p_959_1_, MovingObjectPosition p_959_2_, int p_959_3_, ItemStack p_959_4_, float p_959_5_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, (MathHelper.func_1106_a((float)System.currentTimeMillis() / 100F) * 0.2F + 0.4F) * 0.5F);
        if(p_959_3_ == 0)
        {
            if(field_1450_i > 0.0F)
            {
                GL11.glBlendFunc(774, 768);
                int i = field_1447_l.func_1070_a("/terrain.png");
                GL11.glBindTexture(3553, i);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
                GL11.glPushMatrix();
                int j = field_1448_k.func_600_a(p_959_2_.field_1166_b, p_959_2_.field_1172_c, p_959_2_.field_1171_d);
                Block block = j <= 0 ? null : Block.field_345_n[j];
                GL11.glDisable(3008);
                GL11.glPolygonOffset(-3F, -3F);
                GL11.glEnable(32823);
                double d = p_959_1_.field_638_aI + (p_959_1_.field_611_ak - p_959_1_.field_638_aI) * (double)p_959_5_;
                double d1 = p_959_1_.field_637_aJ + (p_959_1_.field_610_al - p_959_1_.field_637_aJ) * (double)p_959_5_;
                double d2 = p_959_1_.field_636_aK + (p_959_1_.field_609_am - p_959_1_.field_636_aK) * (double)p_959_5_;
                if(block == null)
                {
                    block = Block.field_338_u;
                }
                GL11.glEnable(3008);
                tessellator.func_977_b();
                tessellator.func_984_b(-d, -d1, -d2);
                tessellator.func_989_c();
                field_1438_u.func_1223_a(block, p_959_2_.field_1166_b, p_959_2_.field_1172_c, p_959_2_.field_1171_d, 240 + (int)(field_1450_i * 10F));
                tessellator.func_982_a();
                tessellator.func_984_b(0.0D, 0.0D, 0.0D);
                GL11.glDisable(3008);
                GL11.glPolygonOffset(0.0F, 0.0F);
                GL11.glDisable(32823);
                GL11.glEnable(3008);
                GL11.glDepthMask(true);
                GL11.glPopMatrix();
            }
        } else
        if(p_959_4_ != null)
        {
            GL11.glBlendFunc(770, 771);
            float f = MathHelper.func_1106_a((float)System.currentTimeMillis() / 100F) * 0.2F + 0.8F;
            GL11.glColor4f(f, f, f, MathHelper.func_1106_a((float)System.currentTimeMillis() / 200F) * 0.2F + 0.5F);
            int k = field_1447_l.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, k);
            int l = p_959_2_.field_1166_b;
            int i1 = p_959_2_.field_1172_c;
            int j1 = p_959_2_.field_1171_d;
            if(p_959_2_.field_1170_e == 0)
            {
                i1--;
            }
            if(p_959_2_.field_1170_e == 1)
            {
                i1++;
            }
            if(p_959_2_.field_1170_e == 2)
            {
                j1--;
            }
            if(p_959_2_.field_1170_e == 3)
            {
                j1++;
            }
            if(p_959_2_.field_1170_e == 4)
            {
                l--;
            }
            if(p_959_2_.field_1170_e == 5)
            {
                l++;
            }
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void func_955_b(EntityPlayer p_955_1_, MovingObjectPosition p_955_2_, int p_955_3_, ItemStack p_955_4_, float p_955_5_)
    {
        if(p_955_3_ == 0 && p_955_2_.field_1167_a == EnumMovingObjectType.TILE)
        {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f = 0.002F;
            int i = field_1448_k.func_600_a(p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d);
            if(i > 0)
            {
                Block.field_345_n[i].func_238_a(field_1448_k, p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d);
                double d = p_955_1_.field_638_aI + (p_955_1_.field_611_ak - p_955_1_.field_638_aI) * (double)p_955_5_;
                double d1 = p_955_1_.field_637_aJ + (p_955_1_.field_610_al - p_955_1_.field_637_aJ) * (double)p_955_5_;
                double d2 = p_955_1_.field_636_aK + (p_955_1_.field_609_am - p_955_1_.field_636_aK) * (double)p_955_5_;
                func_942_a(Block.field_345_n[i].func_246_f(field_1448_k, p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d).func_1177_b(f, f, f).func_1166_c(-d, -d1, -d2));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    private void func_942_a(AxisAlignedBB p_942_1_)
    {
        Tessellator tessellator = Tessellator.field_1512_a;
        tessellator.func_992_a(3);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
        tessellator.func_982_a();
        tessellator.func_992_a(3);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
        tessellator.func_982_a();
        tessellator.func_992_a(1);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
        tessellator.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
        tessellator.func_982_a();
    }

    public void func_949_a(int p_949_1_, int p_949_2_, int p_949_3_, int p_949_4_, int p_949_5_, int p_949_6_)
    {
        int i = MathHelper.func_1111_a(p_949_1_, 16);
        int j = MathHelper.func_1111_a(p_949_2_, 16);
        int k = MathHelper.func_1111_a(p_949_3_, 16);
        int l = MathHelper.func_1111_a(p_949_4_, 16);
        int i1 = MathHelper.func_1111_a(p_949_5_, 16);
        int j1 = MathHelper.func_1111_a(p_949_6_, 16);
        for(int k1 = i; k1 <= l; k1++)
        {
            int l1 = k1 % field_1443_p;
            if(l1 < 0)
            {
                l1 += field_1443_p;
            }
            for(int i2 = j; i2 <= i1; i2++)
            {
                int j2 = i2 % field_1442_q;
                if(j2 < 0)
                {
                    j2 += field_1442_q;
                }
                for(int k2 = k; k2 <= j1; k2++)
                {
                    int l2 = k2 % field_1441_r;
                    if(l2 < 0)
                    {
                        l2 += field_1441_r;
                    }
                    int i3 = (l2 * field_1442_q + j2) * field_1443_p + l1;
                    WorldRenderer worldrenderer = field_1444_o[i3];
                    if(!worldrenderer.field_1738_u)
                    {
                        field_1446_m.add(worldrenderer);
                        worldrenderer.func_1194_f();
                    }
                }

            }

        }

    }

    public void func_934_a(int p_934_1_, int p_934_2_, int p_934_3_)
    {
        func_949_a(p_934_1_ - 1, p_934_2_ - 1, p_934_3_ - 1, p_934_1_ + 1, p_934_2_ + 1, p_934_3_ + 1);
    }

    public void func_48180_b(int p_48180_1_, int p_48180_2_, int p_48180_3_)
    {
        func_949_a(p_48180_1_ - 1, p_48180_2_ - 1, p_48180_3_ - 1, p_48180_1_ + 1, p_48180_2_ + 1, p_48180_3_ + 1);
    }

    public void func_937_b(int p_937_1_, int p_937_2_, int p_937_3_, int p_937_4_, int p_937_5_, int p_937_6_)
    {
        func_949_a(p_937_1_ - 1, p_937_2_ - 1, p_937_3_ - 1, p_937_4_ + 1, p_937_5_ + 1, p_937_6_ + 1);
    }

    public void func_960_a(ICamera p_960_1_, float p_960_2_)
    {
        for(int i = 0; i < field_1444_o.length; i++)
        {
            if(!field_1444_o[i].func_1196_e() && (!field_1444_o[i].field_1749_o || (i + field_1449_j & 0xf) == 0))
            {
                field_1444_o[i].func_1199_a(p_960_1_);
            }
        }

        field_1449_j++;
    }

    public void func_933_a(String p_933_1_, int p_933_2_, int p_933_3_, int p_933_4_)
    {
        if(p_933_1_ != null)
        {
            field_1439_t.field_6308_u.func_553_b((new StringBuilder()).append("C418 - ").append(p_933_1_).toString());
        }
        field_1439_t.field_6301_A.func_331_a(p_933_1_, p_933_2_, p_933_3_, p_933_4_, 1.0F, 1.0F);
    }

    public void func_940_a(String p_940_1_, double p_940_2_, double p_940_4_, double p_940_6_, 
            float p_940_8_, float p_940_9_)
    {
        float f = 16F;
        if(p_940_8_ > 1.0F)
        {
            f *= p_940_8_;
        }
        if(field_1439_t.field_22009_h.func_360_d(p_940_2_, p_940_4_, p_940_6_) < (double)(f * f))
        {
            field_1439_t.field_6301_A.func_336_b(p_940_1_, (float)p_940_2_, (float)p_940_4_, (float)p_940_6_, p_940_8_, p_940_9_);
        }
    }

    public void func_939_a(String p_939_1_, double p_939_2_, double p_939_4_, double p_939_6_, 
            double p_939_8_, double p_939_10_, double p_939_12_)
    {
        func_40193_b(p_939_1_, p_939_2_, p_939_4_, p_939_6_, p_939_8_, p_939_10_, p_939_12_);
    }

    public EntityFX func_40193_b(String p_40193_1_, double p_40193_2_, double p_40193_4_, double p_40193_6_, 
            double p_40193_8_, double p_40193_10_, double p_40193_12_)
    {
        if(field_1439_t == null || field_1439_t.field_22009_h == null || field_1439_t.field_6321_h == null)
        {
            return null;
        }
        int i = field_1439_t.field_6304_y.field_41087_P;
        if(i == 1 && field_1448_k.field_1037_n.nextInt(3) == 0)
        {
            i = 2;
        }
        double d = field_1439_t.field_22009_h.field_611_ak - p_40193_2_;
        double d1 = field_1439_t.field_22009_h.field_610_al - p_40193_4_;
        double d2 = field_1439_t.field_22009_h.field_609_am - p_40193_6_;
        Object obj = null;
        if(p_40193_1_.equals("hugeexplosion"))
        {
            field_1439_t.field_6321_h.func_1192_a(((EntityFX) (obj = new EntityHugeExplodeFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_))));
        } else
        if(p_40193_1_.equals("largeexplode"))
        {
            field_1439_t.field_6321_h.func_1192_a(((EntityFX) (obj = new EntityLargeExplodeFX(field_1447_l, field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_))));
        }
        if(obj != null)
        {
            return ((EntityFX) (obj));
        }
        double d3 = 16D;
        if(d * d + d1 * d1 + d2 * d2 > d3 * d3)
        {
            return null;
        }
        if(i > 1)
        {
            return null;
        }
        if(p_40193_1_.equals("bubble"))
        {
            obj = new EntityBubbleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("suspended"))
        {
            obj = new EntitySuspendFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("depthsuspend"))
        {
            obj = new EntityAuraFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("townaura"))
        {
            obj = new EntityAuraFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("crit"))
        {
            obj = new EntityCritFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("magicCrit"))
        {
            obj = new EntityCritFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
            ((EntityFX) (obj)).func_40097_b(((EntityFX) (obj)).func_40098_n() * 0.3F, ((EntityFX) (obj)).func_40101_o() * 0.8F, ((EntityFX) (obj)).func_40102_p());
            ((EntityFX) (obj)).func_40099_c(((EntityFX) (obj)).func_40100_q() + 1);
        } else
        if(p_40193_1_.equals("smoke"))
        {
            obj = new EntitySmokeFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("mobSpell"))
        {
            obj = new EntitySpellParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, 0.0D, 0.0D, 0.0D);
            ((EntityFX) (obj)).func_40097_b((float)p_40193_8_, (float)p_40193_10_, (float)p_40193_12_);
        } else
        if(p_40193_1_.equals("spell"))
        {
            obj = new EntitySpellParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("instantSpell"))
        {
            obj = new EntitySpellParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
            ((EntitySpellParticleFX)obj).func_40110_b(144);
        } else
        if(p_40193_1_.equals("note"))
        {
            obj = new EntityNoteFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("portal"))
        {
            obj = new EntityPortalFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("enchantmenttable"))
        {
            obj = new EntityEnchantmentTableParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("explode"))
        {
            obj = new EntityExplodeFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("flame"))
        {
            obj = new EntityFlameFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("lava"))
        {
            obj = new EntityLavaFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_);
        } else
        if(p_40193_1_.equals("footstep"))
        {
            obj = new EntityFootStepFX(field_1447_l, field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_);
        } else
        if(p_40193_1_.equals("splash"))
        {
            obj = new EntitySplashFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("largesmoke"))
        {
            obj = new EntitySmokeFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, 2.5F);
        } else
        if(p_40193_1_.equals("cloud"))
        {
            obj = new EntityCloudFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("reddust"))
        {
            obj = new EntityReddustFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, (float)p_40193_8_, (float)p_40193_10_, (float)p_40193_12_);
        } else
        if(p_40193_1_.equals("snowballpoof"))
        {
            obj = new EntityBreakingFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Item.field_308_aB);
        } else
        if(p_40193_1_.equals("dripWater"))
        {
            obj = new EntityDropParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Material.field_1332_f);
        } else
        if(p_40193_1_.equals("dripLava"))
        {
            obj = new EntityDropParticleFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Material.field_1331_g);
        } else
        if(p_40193_1_.equals("snowshovel"))
        {
            obj = new EntitySnowShovelFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.equals("slime"))
        {
            obj = new EntityBreakingFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Item.field_299_aK);
        } else
        if(p_40193_1_.equals("heart"))
        {
            obj = new EntityHeartFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
        } else
        if(p_40193_1_.startsWith("iconcrack_"))
        {
            int j = Integer.parseInt(p_40193_1_.substring(p_40193_1_.indexOf("_") + 1));
            obj = new EntityBreakingFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, Item.field_233_c[j]);
        } else
        if(p_40193_1_.startsWith("tilecrack_"))
        {
            int k = Integer.parseInt(p_40193_1_.substring(p_40193_1_.indexOf("_") + 1));
            obj = new EntityDiggingFX(field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, Block.field_345_n[k], 0, 0);
        }
        if(obj != null)
        {
            field_1439_t.field_6321_h.func_1192_a(((EntityFX) (obj)));
        }
        return ((EntityFX) (obj));
    }

    public void func_941_a(Entity p_941_1_)
    {
        p_941_1_.func_20046_s();
        if(p_941_1_.field_20047_bv != null)
        {
            field_1447_l.func_1075_a(p_941_1_.field_20047_bv, new ImageBufferDownload());
        }
        if(p_941_1_.field_622_aY != null)
        {
            field_1447_l.func_1075_a(p_941_1_.field_622_aY, new ImageBufferDownload());
        }
    }

    public void func_938_b(Entity p_938_1_)
    {
        if(p_938_1_.field_20047_bv != null)
        {
            field_1447_l.func_1073_b(p_938_1_.field_20047_bv);
        }
        if(p_938_1_.field_622_aY != null)
        {
            field_1447_l.func_1073_b(p_938_1_.field_622_aY);
        }
    }

    public void func_935_a(int i, int j, int k, TileEntity tileentity)
    {
    }

    public void func_28137_f()
    {
        GLAllocation.func_28194_b(field_1440_s);
    }

    public void func_28136_a(EntityPlayer p_28136_1_, int p_28136_2_, int p_28136_3_, int p_28136_4_, int p_28136_5_, int p_28136_6_)
    {
        Random random = field_1448_k.field_1037_n;
        switch(p_28136_2_)
        {
        default:
            break;

        case 1001: 
            field_1448_k.func_684_a(p_28136_3_, p_28136_4_, p_28136_5_, "random.click", 1.0F, 1.2F);
            break;

        case 1000: 
            field_1448_k.func_684_a(p_28136_3_, p_28136_4_, p_28136_5_, "random.click", 1.0F, 1.0F);
            break;

        case 1002: 
            field_1448_k.func_684_a(p_28136_3_, p_28136_4_, p_28136_5_, "random.bow", 1.0F, 1.2F);
            break;

        case 2000: 
            int i = p_28136_6_ % 3 - 1;
            int l = (p_28136_6_ / 3) % 3 - 1;
            double d3 = (double)p_28136_3_ + (double)i * 0.59999999999999998D + 0.5D;
            double d7 = (double)p_28136_4_ + 0.5D;
            double d11 = (double)p_28136_5_ + (double)l * 0.59999999999999998D + 0.5D;
            for(int l1 = 0; l1 < 10; l1++)
            {
                double d13 = random.nextDouble() * 0.20000000000000001D + 0.01D;
                double d14 = d3 + (double)i * 0.01D + (random.nextDouble() - 0.5D) * (double)l * 0.5D;
                double d15 = d7 + (random.nextDouble() - 0.5D) * 0.5D;
                double d17 = d11 + (double)l * 0.01D + (random.nextDouble() - 0.5D) * (double)i * 0.5D;
                double d19 = (double)i * d13 + random.nextGaussian() * 0.01D;
                double d21 = -0.029999999999999999D + random.nextGaussian() * 0.01D;
                double d23 = (double)l * d13 + random.nextGaussian() * 0.01D;
                func_939_a("smoke", d14, d15, d17, d19, d21, d23);
            }

            break;

        case 2003: 
            double d = (double)p_28136_3_ + 0.5D;
            double d4 = p_28136_4_;
            double d8 = (double)p_28136_5_ + 0.5D;
            String s = (new StringBuilder()).append("iconcrack_").append(Item.field_40420_bA.field_291_aS).toString();
            for(int i1 = 0; i1 < 8; i1++)
            {
                func_939_a(s, d, d4, d8, random.nextGaussian() * 0.14999999999999999D, random.nextDouble() * 0.20000000000000001D, random.nextGaussian() * 0.14999999999999999D);
            }

            for(double d12 = 0.0D; d12 < 6.2831853071795862D; d12 += 0.15707963267948966D)
            {
                func_939_a("portal", d + Math.cos(d12) * 5D, d4 - 0.40000000000000002D, d8 + Math.sin(d12) * 5D, Math.cos(d12) * -5D, 0.0D, Math.sin(d12) * -5D);
                func_939_a("portal", d + Math.cos(d12) * 5D, d4 - 0.40000000000000002D, d8 + Math.sin(d12) * 5D, Math.cos(d12) * -7D, 0.0D, Math.sin(d12) * -7D);
            }

            break;

        case 2002: 
            double d1 = p_28136_3_;
            double d5 = p_28136_4_;
            double d9 = p_28136_5_;
            String s1 = (new StringBuilder()).append("iconcrack_").append(Item.field_40413_bs.field_291_aS).toString();
            for(int j1 = 0; j1 < 8; j1++)
            {
                func_939_a(s1, d1, d5, d9, random.nextGaussian() * 0.14999999999999999D, random.nextDouble() * 0.20000000000000001D, random.nextGaussian() * 0.14999999999999999D);
            }

            int k1 = Item.field_40413_bs.func_27010_f(p_28136_6_, 0);
            float f = (float)(k1 >> 16 & 0xff) / 255F;
            float f1 = (float)(k1 >> 8 & 0xff) / 255F;
            float f2 = (float)(k1 >> 0 & 0xff) / 255F;
            String s2 = "spell";
            if(Item.field_40413_bs.func_40432_e(p_28136_6_))
            {
                s2 = "instantSpell";
            }
            for(int i2 = 0; i2 < 100; i2++)
            {
                double d16 = random.nextDouble() * 4D;
                double d18 = random.nextDouble() * 3.1415926535897931D * 2D;
                double d20 = Math.cos(d18) * d16;
                double d22 = 0.01D + random.nextDouble() * 0.5D;
                double d24 = Math.sin(d18) * d16;
                EntityFX entityfx = func_40193_b(s2, d1 + d20 * 0.10000000000000001D, d5 + 0.29999999999999999D, d9 + d24 * 0.10000000000000001D, d20, d22, d24);
                if(entityfx != null)
                {
                    float f3 = 0.75F + random.nextFloat() * 0.25F;
                    entityfx.func_40097_b(f * f3, f1 * f3, f2 * f3);
                    entityfx.func_407_b((float)d16);
                }
            }

            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.glass", 1.0F, field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
            break;

        case 2001: 
            int j = p_28136_6_ & 0xfff;
            if(j > 0)
            {
                Block block = Block.field_345_n[j];
                field_1439_t.field_6301_A.func_336_b(block.field_358_bl.func_1146_a(), (float)p_28136_3_ + 0.5F, (float)p_28136_4_ + 0.5F, (float)p_28136_5_ + 0.5F, (block.field_358_bl.func_1147_b() + 1.0F) / 2.0F, block.field_358_bl.func_1144_c() * 0.8F);
            }
            field_1439_t.field_6321_h.func_1186_a(p_28136_3_, p_28136_4_, p_28136_5_, p_28136_6_ & 0xfff, p_28136_6_ >> 12 & 0xff);
            break;

        case 2004: 
            for(int k = 0; k < 20; k++)
            {
                double d2 = (double)p_28136_3_ + 0.5D + ((double)field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2D;
                double d6 = (double)p_28136_4_ + 0.5D + ((double)field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2D;
                double d10 = (double)p_28136_5_ + 0.5D + ((double)field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2D;
                field_1448_k.func_694_a("smoke", d2, d6, d10, 0.0D, 0.0D, 0.0D);
                field_1448_k.func_694_a("flame", d2, d6, d10, 0.0D, 0.0D, 0.0D);
            }

            break;

        case 1003: 
            if(Math.random() < 0.5D)
            {
                field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.door_open", 1.0F, field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
            } else
            {
                field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.door_close", 1.0F, field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
            }
            break;

        case 1004: 
            field_1448_k.func_684_a((float)p_28136_3_ + 0.5F, (float)p_28136_4_ + 0.5F, (float)p_28136_5_ + 0.5F, "random.fizz", 0.5F, 2.6F + (random.nextFloat() - random.nextFloat()) * 0.8F);
            break;

        case 1005: 
            if(Item.field_233_c[p_28136_6_] instanceof ItemRecord)
            {
                field_1448_k.func_670_a(((ItemRecord)Item.field_233_c[p_28136_6_]).field_316_a, p_28136_3_, p_28136_4_, p_28136_5_);
            } else
            {
                field_1448_k.func_670_a(null, p_28136_3_, p_28136_4_, p_28136_5_);
            }
            break;

        case 1007: 
            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.ghast.charge", 10F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1008: 
            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.ghast.fireball", 10F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1010: 
            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.wood", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1012: 
            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.woodbreak", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;

        case 1011: 
            field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.metal", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
        }
    }
}
