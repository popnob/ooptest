// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            NetHandler, MapStorage, NetworkManager, PlayerControllerMP, 
//            StatList, StatFileWriter, WorldClient, WorldSettings, 
//            Packet1Login, EntityPlayerSP, GuiDownloadTerrain, Packet21PickupSpawn, 
//            EntityItem, ItemStack, Packet23VehicleSpawn, EntityMinecart, 
//            EntityFishHook, EntityArrow, EntitySnowball, EntityEnderPearl, 
//            EntityEnderEye, EntityFireball, EntitySmallFireball, EntityEgg, 
//            EntityPotion, EntityExpBottle, EntityBoat, EntityTNTPrimed, 
//            EntityEnderCrystal, EntityFallingSand, Block, Entity, 
//            EntityLiving, EntityXPOrb, Packet26EntityExpOrb, Packet71Weather, 
//            EntityLightningBolt, EntityPainting, Packet25EntityPainting, Packet28EntityVelocity, 
//            Packet40EntityMetadata, DataWatcher, Packet20NamedEntitySpawn, EntityOtherPlayerMP, 
//            InventoryPlayer, Packet34EntityTeleport, Packet30Entity, Packet35EntityHeadRotation, 
//            Packet29DestroyEntity, EntityPlayer, Packet10Flying, AxisAlignedBB, 
//            Packet50PreChunk, Packet52MultiBlockChange, Packet51MapChunk, Chunk, 
//            WorldProviderSurface, Packet53BlockChange, GuiDisconnected, Packet255KickDisconnect, 
//            Packet22Collect, EntityPickupFX, EffectRenderer, Packet3Chat, 
//            GuiIngame, Packet18Animation, EntityCrit2FX, Packet17Sleep, 
//            Packet2Handshake, Session, Packet24MobSpawn, EntityList, 
//            Packet4UpdateTime, World, ChunkCoordinates, Packet6SpawnPosition, 
//            WorldInfo, Packet39AttachEntity, Packet38EntityStatus, Packet8UpdateHealth, 
//            FoodStats, Packet43Experience, Packet9Respawn, Explosion, 
//            Packet60Explosion, Packet100OpenWindow, InventoryBasic, Container, 
//            TileEntityFurnace, TileEntityBrewingStand, TileEntityDispenser, MathHelper, 
//            Packet103SetSlot, Slot, Packet106Transaction, Packet104WindowItems, 
//            Packet130UpdateSign, TileEntitySign, Packet132TileEntityData, TileEntityMobSpawner, 
//            Packet105UpdateProgressbar, Packet5PlayerInventory, Packet54PlayNoteBlock, Packet70Bed, 
//            GuiWinGame, Packet131MapData, Item, ItemMap, 
//            MapData, Packet61DoorChange, EntityClientPlayerMP, Packet200Statistic, 
//            Packet41EntityEffect, PotionEffect, Packet42RemoveEntityEffect, Packet201PlayerInfo, 
//            GuiPlayerInfo, Packet0KeepAlive, Packet202PlayerAbilities, PlayerCapabilities, 
//            Packet, Packet101CloseWindow

public class NetClientHandler extends NetHandler
{

    private boolean field_1214_c;
    private NetworkManager field_1213_d;
    public String field_1209_a;
    private Minecraft field_1212_e;
    private WorldClient field_1211_f;
    private boolean field_1210_g;
    public MapStorage field_28118_b;
    private Map field_35787_k;
    public List field_35786_c;
    public int field_35785_d;
    Random field_1208_b;

    public NetClientHandler(Minecraft p_i42_1_, String p_i42_2_, int p_i42_3_)
        throws UnknownHostException, IOException
    {
        field_1214_c = false;
        field_1210_g = false;
        field_28118_b = new MapStorage(null);
        field_35787_k = new HashMap();
        field_35786_c = new ArrayList();
        field_35785_d = 20;
        field_1208_b = new Random();
        field_1212_e = p_i42_1_;
        Socket socket = new Socket(InetAddress.getByName(p_i42_2_), p_i42_3_);
        field_1213_d = new NetworkManager(socket, "Client", this);
    }

    public void func_848_a()
    {
        if(!field_1214_c)
        {
            field_1213_d.func_967_a();
        }
        field_1213_d.func_28139_a();
    }

    public void func_4115_a(Packet1Login p_4115_1_)
    {
        field_1212_e.field_6327_b = new PlayerControllerMP(field_1212_e, this);
        field_1212_e.field_25001_G.func_25100_a(StatList.field_25181_h, 1);
        field_1211_f = new WorldClient(this, new WorldSettings(0L, p_4115_1_.field_35249_d, false, false, p_4115_1_.field_46032_d), p_4115_1_.field_48170_e, p_4115_1_.field_35247_f);
        field_1211_f.field_1026_y = true;
        field_1212_e.func_6261_a(field_1211_f);
        field_1212_e.field_6322_g.field_4129_m = p_4115_1_.field_48170_e;
        field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        field_1212_e.field_6322_g.field_620_ab = p_4115_1_.field_519_a;
        field_35785_d = p_4115_1_.field_35251_h;
        ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(p_4115_1_.field_35249_d == 1);
    }

    public void func_832_a(Packet21PickupSpawn p_832_1_)
    {
        double d = (double)p_832_1_.field_530_b / 32D;
        double d1 = (double)p_832_1_.field_529_c / 32D;
        double d2 = (double)p_832_1_.field_528_d / 32D;
        EntityItem entityitem = new EntityItem(field_1211_f, d, d1, d2, new ItemStack(p_832_1_.field_524_h, p_832_1_.field_523_i, p_832_1_.field_21052_l));
        entityitem.field_608_an = (double)p_832_1_.field_527_e / 128D;
        entityitem.field_607_ao = (double)p_832_1_.field_526_f / 128D;
        entityitem.field_606_ap = (double)p_832_1_.field_525_g / 128D;
        entityitem.field_9303_br = p_832_1_.field_530_b;
        entityitem.field_9302_bs = p_832_1_.field_529_c;
        entityitem.field_9301_bt = p_832_1_.field_528_d;
        field_1211_f.func_712_a(p_832_1_.field_531_a, entityitem);
    }

    public void func_835_a(Packet23VehicleSpawn p_835_1_)
    {
        double d = (double)p_835_1_.field_499_b / 32D;
        double d1 = (double)p_835_1_.field_503_c / 32D;
        double d2 = (double)p_835_1_.field_502_d / 32D;
        Object obj = null;
        if(p_835_1_.field_501_e == 10)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 0);
        } else
        if(p_835_1_.field_501_e == 11)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 1);
        } else
        if(p_835_1_.field_501_e == 12)
        {
            obj = new EntityMinecart(field_1211_f, d, d1, d2, 2);
        } else
        if(p_835_1_.field_501_e == 90)
        {
            obj = new EntityFishHook(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 60)
        {
            obj = new EntityArrow(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 61)
        {
            obj = new EntitySnowball(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 65)
        {
            obj = new EntityEnderPearl(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 72)
        {
            obj = new EntityEnderEye(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 63)
        {
            obj = new EntityFireball(field_1211_f, d, d1, d2, (double)p_835_1_.field_28047_e / 8000D, (double)p_835_1_.field_28046_f / 8000D, (double)p_835_1_.field_28045_g / 8000D);
            p_835_1_.field_28044_i = 0;
        } else
        if(p_835_1_.field_501_e == 64)
        {
            obj = new EntitySmallFireball(field_1211_f, d, d1, d2, (double)p_835_1_.field_28047_e / 8000D, (double)p_835_1_.field_28046_f / 8000D, (double)p_835_1_.field_28045_g / 8000D);
            p_835_1_.field_28044_i = 0;
        } else
        if(p_835_1_.field_501_e == 62)
        {
            obj = new EntityEgg(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 73)
        {
            obj = new EntityPotion(field_1211_f, d, d1, d2, p_835_1_.field_28044_i);
            p_835_1_.field_28044_i = 0;
        } else
        if(p_835_1_.field_501_e == 75)
        {
            obj = new EntityExpBottle(field_1211_f, d, d1, d2);
            p_835_1_.field_28044_i = 0;
        } else
        if(p_835_1_.field_501_e == 1)
        {
            obj = new EntityBoat(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 50)
        {
            obj = new EntityTNTPrimed(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 51)
        {
            obj = new EntityEnderCrystal(field_1211_f, d, d1, d2);
        } else
        if(p_835_1_.field_501_e == 70)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_393_F.field_376_bc);
        } else
        if(p_835_1_.field_501_e == 71)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_392_G.field_376_bc);
        } else
        if(p_835_1_.field_501_e == 74)
        {
            obj = new EntityFallingSand(field_1211_f, d, d1, d2, Block.field_41050_bK.field_376_bc);
        }
        if(obj != null)
        {
            obj.field_9303_br = p_835_1_.field_499_b;
            obj.field_9302_bs = p_835_1_.field_503_c;
            obj.field_9301_bt = p_835_1_.field_502_d;
            obj.field_605_aq = 0.0F;
            obj.field_604_ar = 0.0F;
            Entity aentity[] = ((Entity) (obj)).func_40048_X();
            if(aentity != null)
            {
                int i = p_835_1_.field_500_a - ((Entity) (obj)).field_620_ab;
                for(int j = 0; j < aentity.length; j++)
                {
                    aentity[j].field_620_ab += i;
                }

            }
            obj.field_620_ab = p_835_1_.field_500_a;
            field_1211_f.func_712_a(p_835_1_.field_500_a, ((Entity) (obj)));
            if(p_835_1_.field_28044_i > 0)
            {
                if(p_835_1_.field_501_e == 60)
                {
                    Entity entity = func_12246_a(p_835_1_.field_28044_i);
                    if(entity instanceof EntityLiving)
                    {
                        ((EntityArrow)obj).field_682_g = (EntityLiving)entity;
                    }
                }
                ((Entity) (obj)).func_6375_a((double)p_835_1_.field_28047_e / 8000D, (double)p_835_1_.field_28046_f / 8000D, (double)p_835_1_.field_28045_g / 8000D);
            }
        }
    }

    public void func_35778_a(Packet26EntityExpOrb p_35778_1_)
    {
        EntityXPOrb entityxporb = new EntityXPOrb(field_1211_f, p_35778_1_.field_35239_b, p_35778_1_.field_35240_c, p_35778_1_.field_35237_d, p_35778_1_.field_35238_e);
        entityxporb.field_9303_br = p_35778_1_.field_35239_b;
        entityxporb.field_9302_bs = p_35778_1_.field_35240_c;
        entityxporb.field_9301_bt = p_35778_1_.field_35237_d;
        entityxporb.field_605_aq = 0.0F;
        entityxporb.field_604_ar = 0.0F;
        entityxporb.field_620_ab = p_35778_1_.field_35241_a;
        field_1211_f.func_712_a(p_35778_1_.field_35241_a, entityxporb);
    }

    public void func_27246_a(Packet71Weather p_27246_1_)
    {
        double d = (double)p_27246_1_.field_27053_b / 32D;
        double d1 = (double)p_27246_1_.field_27057_c / 32D;
        double d2 = (double)p_27246_1_.field_27056_d / 32D;
        EntityLightningBolt entitylightningbolt = null;
        if(p_27246_1_.field_27055_e == 1)
        {
            entitylightningbolt = new EntityLightningBolt(field_1211_f, d, d1, d2);
        }
        if(entitylightningbolt != null)
        {
            entitylightningbolt.field_9303_br = p_27246_1_.field_27053_b;
            entitylightningbolt.field_9302_bs = p_27246_1_.field_27057_c;
            entitylightningbolt.field_9301_bt = p_27246_1_.field_27056_d;
            entitylightningbolt.field_605_aq = 0.0F;
            entitylightningbolt.field_604_ar = 0.0F;
            entitylightningbolt.field_620_ab = p_27246_1_.field_27054_a;
            field_1211_f.func_27159_a(entitylightningbolt);
        }
    }

    public void func_21146_a(Packet25EntityPainting p_21146_1_)
    {
        EntityPainting entitypainting = new EntityPainting(field_1211_f, p_21146_1_.field_21041_b, p_21146_1_.field_21046_c, p_21146_1_.field_21045_d, p_21146_1_.field_21044_e, p_21146_1_.field_21043_f);
        field_1211_f.func_712_a(p_21146_1_.field_21042_a, entitypainting);
    }

    public void func_6498_a(Packet28EntityVelocity p_6498_1_)
    {
        Entity entity = func_12246_a(p_6498_1_.field_6367_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.func_6375_a((double)p_6498_1_.field_6366_b / 8000D, (double)p_6498_1_.field_6369_c / 8000D, (double)p_6498_1_.field_6368_d / 8000D);
            return;
        }
    }

    public void func_21148_a(Packet40EntityMetadata p_21148_1_)
    {
        Entity entity = func_12246_a(p_21148_1_.field_21049_a);
        if(entity != null && p_21148_1_.func_21047_b() != null)
        {
            entity.func_21061_O().func_21126_a(p_21148_1_.func_21047_b());
        }
    }

    public void func_820_a(Packet20NamedEntitySpawn p_820_1_)
    {
        double d = (double)p_820_1_.field_540_c / 32D;
        double d1 = (double)p_820_1_.field_539_d / 32D;
        double d2 = (double)p_820_1_.field_538_e / 32D;
        float f = (float)(p_820_1_.field_537_f * 360) / 256F;
        float f1 = (float)(p_820_1_.field_536_g * 360) / 256F;
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(field_1212_e.field_6324_e, p_820_1_.field_533_b);
        entityotherplayermp.field_9285_at = entityotherplayermp.field_638_aI = entityotherplayermp.field_9303_br = p_820_1_.field_540_c;
        entityotherplayermp.field_9284_au = entityotherplayermp.field_637_aJ = entityotherplayermp.field_9302_bs = p_820_1_.field_539_d;
        entityotherplayermp.field_9283_av = entityotherplayermp.field_636_aK = entityotherplayermp.field_9301_bt = p_820_1_.field_538_e;
        int i = p_820_1_.field_535_h;
        if(i == 0)
        {
            entityotherplayermp.field_778_b.field_843_a[entityotherplayermp.field_778_b.field_847_d] = null;
        } else
        {
            entityotherplayermp.field_778_b.field_843_a[entityotherplayermp.field_778_b.field_847_d] = new ItemStack(i, 1, 0);
        }
        entityotherplayermp.func_399_b(d, d1, d2, f, f1);
        field_1211_f.func_712_a(p_820_1_.field_534_a, entityotherplayermp);
    }

    public void func_829_a(Packet34EntityTeleport p_829_1_)
    {
        Entity entity = func_12246_a(p_829_1_.field_509_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.field_9303_br = p_829_1_.field_508_b;
            entity.field_9302_bs = p_829_1_.field_513_c;
            entity.field_9301_bt = p_829_1_.field_512_d;
            double d = (double)entity.field_9303_br / 32D;
            double d1 = (double)entity.field_9302_bs / 32D + 0.015625D;
            double d2 = (double)entity.field_9301_bt / 32D;
            float f = (float)(p_829_1_.field_511_e * 360) / 256F;
            float f1 = (float)(p_829_1_.field_510_f * 360) / 256F;
            entity.func_378_a(d, d1, d2, f, f1, 3);
            return;
        }
    }

    public void func_827_a(Packet30Entity p_827_1_)
    {
        Entity entity = func_12246_a(p_827_1_.field_485_a);
        if(entity == null)
        {
            return;
        } else
        {
            entity.field_9303_br += p_827_1_.field_484_b;
            entity.field_9302_bs += p_827_1_.field_490_c;
            entity.field_9301_bt += p_827_1_.field_489_d;
            double d = (double)entity.field_9303_br / 32D;
            double d1 = (double)entity.field_9302_bs / 32D;
            double d2 = (double)entity.field_9301_bt / 32D;
            float f = p_827_1_.field_486_g ? (float)(p_827_1_.field_488_e * 360) / 256F : entity.field_605_aq;
            float f1 = p_827_1_.field_486_g ? (float)(p_827_1_.field_487_f * 360) / 256F : entity.field_604_ar;
            entity.func_378_a(d, d1, d2, f, f1, 3);
            return;
        }
    }

    public void func_48488_a(Packet35EntityHeadRotation p_48488_1_)
    {
        Entity entity = func_12246_a(p_48488_1_.field_48160_a);
        if(entity == null)
        {
            return;
        } else
        {
            float f = (float)(p_48488_1_.field_48159_b * 360) / 256F;
            entity.func_48079_f(f);
            return;
        }
    }

    public void func_839_a(Packet29DestroyEntity p_839_1_)
    {
        field_1211_f.func_710_c(p_839_1_.field_507_a);
    }

    public void func_837_a(Packet10Flying p_837_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        double d = ((EntityPlayer) (entityplayersp)).field_611_ak;
        double d1 = ((EntityPlayer) (entityplayersp)).field_610_al;
        double d2 = ((EntityPlayer) (entityplayersp)).field_609_am;
        float f = ((EntityPlayer) (entityplayersp)).field_605_aq;
        float f1 = ((EntityPlayer) (entityplayersp)).field_604_ar;
        if(p_837_1_.field_554_h)
        {
            d = p_837_1_.field_561_a;
            d1 = p_837_1_.field_560_b;
            d2 = p_837_1_.field_559_c;
        }
        if(p_837_1_.field_553_i)
        {
            f = p_837_1_.field_557_e;
            f1 = p_837_1_.field_556_f;
        }
        entityplayersp.field_9287_aY = 0.0F;
        entityplayersp.field_608_an = entityplayersp.field_607_ao = entityplayersp.field_606_ap = 0.0D;
        entityplayersp.func_399_b(d, d1, d2, f, f1);
        p_837_1_.field_561_a = ((EntityPlayer) (entityplayersp)).field_611_ak;
        p_837_1_.field_560_b = ((EntityPlayer) (entityplayersp)).field_601_au.field_1697_b;
        p_837_1_.field_559_c = ((EntityPlayer) (entityplayersp)).field_609_am;
        p_837_1_.field_558_d = ((EntityPlayer) (entityplayersp)).field_610_al;
        field_1213_d.func_972_a(p_837_1_);
        if(!field_1210_g)
        {
            field_1212_e.field_6322_g.field_9285_at = field_1212_e.field_6322_g.field_611_ak;
            field_1212_e.field_6322_g.field_9284_au = field_1212_e.field_6322_g.field_610_al;
            field_1212_e.field_6322_g.field_9283_av = field_1212_e.field_6322_g.field_609_am;
            field_1210_g = true;
            field_1212_e.func_6272_a(null);
        }
    }

    public void func_826_a(Packet50PreChunk p_826_1_)
    {
        field_1211_f.func_713_a(p_826_1_.field_505_a, p_826_1_.field_504_b, p_826_1_.field_506_c);
    }

    public void func_824_a(Packet52MultiBlockChange p_824_1_)
    {
        int i = p_824_1_.field_479_a * 16;
        int j = p_824_1_.field_478_b * 16;
        if(p_824_1_.field_481_e == null)
        {
            return;
        }
        DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_824_1_.field_481_e));
        try
        {
            for(int k = 0; k < p_824_1_.field_480_f; k++)
            {
                short word0 = datainputstream.readShort();
                short word1 = datainputstream.readShort();
                int l = (word1 & 0xfff) >> 4;
                int i1 = word1 & 0xf;
                int j1 = word0 >> 12 & 0xf;
                int k1 = word0 >> 8 & 0xf;
                int l1 = word0 & 0xff;
                field_1211_f.func_714_c(j1 + i, l1, k1 + j, l, i1);
            }

        }
        catch(IOException ioexception) { }
    }

    public void func_48487_a(Packet51MapChunk p_48487_1_)
    {
        field_1211_f.func_711_c(p_48487_1_.field_48177_a << 4, 0, p_48487_1_.field_48175_b << 4, (p_48487_1_.field_48177_a << 4) + 15, 256, (p_48487_1_.field_48175_b << 4) + 15);
        Chunk chunk = field_1211_f.func_704_b(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b);
        if(p_48487_1_.field_48171_f && chunk == null)
        {
            field_1211_f.func_713_a(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b, true);
            chunk = field_1211_f.func_704_b(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b);
        }
        if(chunk != null)
        {
            chunk.func_48494_a(p_48487_1_.field_48174_e, p_48487_1_.field_48176_c, p_48487_1_.field_48173_d, p_48487_1_.field_48171_f);
            field_1211_f.func_701_b(p_48487_1_.field_48177_a << 4, 0, p_48487_1_.field_48175_b << 4, (p_48487_1_.field_48177_a << 4) + 15, 256, (p_48487_1_.field_48175_b << 4) + 15);
            if(!p_48487_1_.field_48171_f || !(field_1211_f.field_4209_q instanceof WorldProviderSurface))
            {
                chunk.func_48496_n();
            }
        }
    }

    public void func_822_a(Packet53BlockChange p_822_1_)
    {
        field_1211_f.func_714_c(p_822_1_.field_492_a, p_822_1_.field_491_b, p_822_1_.field_495_c, p_822_1_.field_494_d, p_822_1_.field_493_e);
    }

    public void func_844_a(Packet255KickDisconnect p_844_1_)
    {
        field_1213_d.func_974_a("disconnect.kicked", new Object[0]);
        field_1214_c = true;
        field_1212_e.func_6261_a(null);
        field_1212_e.func_6272_a(new GuiDisconnected("disconnect.disconnected", "disconnect.genericReason", new Object[] {
            p_844_1_.field_582_a
        }));
    }

    public void func_823_a(String p_823_1_, Object p_823_2_[])
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1214_c = true;
            field_1212_e.func_6261_a(null);
            field_1212_e.func_6272_a(new GuiDisconnected("disconnect.lost", p_823_1_, p_823_2_));
            return;
        }
    }

    public void func_28117_a(Packet p_28117_1_)
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1213_d.func_972_a(p_28117_1_);
            field_1213_d.func_28142_c();
            return;
        }
    }

    public void func_847_a(Packet p_847_1_)
    {
        if(field_1214_c)
        {
            return;
        } else
        {
            field_1213_d.func_972_a(p_847_1_);
            return;
        }
    }

    public void func_834_a(Packet22Collect p_834_1_)
    {
        Entity entity = func_12246_a(p_834_1_.field_581_a);
        Object obj = (EntityLiving)func_12246_a(p_834_1_.field_580_b);
        if(obj == null)
        {
            obj = field_1212_e.field_6322_g;
        }
        if(entity != null)
        {
            if(entity instanceof EntityXPOrb)
            {
                field_1211_f.func_623_a(entity, "random.orb", 0.2F, ((field_1208_b.nextFloat() - field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            } else
            {
                field_1211_f.func_623_a(entity, "random.pop", 0.2F, ((field_1208_b.nextFloat() - field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }
            field_1212_e.field_6321_h.func_1192_a(new EntityPickupFX(field_1212_e.field_6324_e, entity, ((Entity) (obj)), -0.5F));
            field_1211_f.func_710_c(p_834_1_.field_581_a);
        }
    }

    public void func_4113_a(Packet3Chat p_4113_1_)
    {
        field_1212_e.field_6308_u.func_552_a(p_4113_1_.field_517_a);
    }

    public void func_825_a(Packet18Animation p_825_1_)
    {
        Entity entity = func_12246_a(p_825_1_.field_522_a);
        if(entity == null)
        {
            return;
        }
        if(p_825_1_.field_521_b == 1)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_457_w();
        } else
        if(p_825_1_.field_521_b == 2)
        {
            entity.func_9280_g();
        } else
        if(p_825_1_.field_521_b == 3)
        {
            EntityPlayer entityplayer1 = (EntityPlayer)entity;
            entityplayer1.func_22056_a(false, false, false);
        } else
        if(p_825_1_.field_521_b == 4)
        {
            EntityPlayer entityplayer2 = (EntityPlayer)entity;
            entityplayer2.func_6420_o();
        } else
        if(p_825_1_.field_521_b == 6)
        {
            field_1212_e.field_6321_h.func_1192_a(new EntityCrit2FX(field_1212_e.field_6324_e, entity));
        } else
        if(p_825_1_.field_521_b == 7)
        {
            EntityCrit2FX entitycrit2fx = new EntityCrit2FX(field_1212_e.field_6324_e, entity, "magicCrit");
            field_1212_e.field_6321_h.func_1192_a(entitycrit2fx);
        } else
        if(p_825_1_.field_521_b == 5)
        {
            if(!(entity instanceof EntityOtherPlayerMP));
        }
    }

    public void func_22186_a(Packet17Sleep p_22186_1_)
    {
        Entity entity = func_12246_a(p_22186_1_.field_22045_a);
        if(entity == null)
        {
            return;
        }
        if(p_22186_1_.field_22046_e == 0)
        {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_22053_b(p_22186_1_.field_22044_b, p_22186_1_.field_22048_c, p_22186_1_.field_22047_d);
        }
    }

    public void func_838_a(Packet2Handshake p_838_1_)
    {
        boolean flag = true;
        String s = p_838_1_.field_532_a;
        if(s == null || s.trim().length() == 0)
        {
            flag = false;
        } else
        if(!s.equals("-"))
        {
            try
            {
                Long.parseLong(s, 16);
            }
            catch(NumberFormatException numberformatexception)
            {
                flag = false;
            }
        }
        if(!flag)
        {
            field_1213_d.func_974_a("disconnect.genericReason", new Object[] {
                "The server responded with an invalid server key"
            });
        } else
        if(p_838_1_.field_532_a.equals("-"))
        {
            func_847_a(new Packet1Login(field_1212_e.field_6320_i.field_1666_b, 29));
        } else
        {
            try
            {
                URL url = new URL((new StringBuilder()).append("http://session.minecraft.net/game/joinserver.jsp?user=").append(field_1212_e.field_6320_i.field_1666_b).append("&sessionId=").append(field_1212_e.field_6320_i.field_6543_c).append("&serverId=").append(p_838_1_.field_532_a).toString());
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
                String s1 = bufferedreader.readLine();
                bufferedreader.close();
                if(s1.equalsIgnoreCase("ok"))
                {
                    func_847_a(new Packet1Login(field_1212_e.field_6320_i.field_1666_b, 29));
                } else
                {
                    field_1213_d.func_974_a("disconnect.loginFailedInfo", new Object[] {
                        s1
                    });
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
                field_1213_d.func_974_a("disconnect.genericReason", new Object[] {
                    (new StringBuilder()).append("Internal client error: ").append(exception.toString()).toString()
                });
            }
        }
    }

    public void func_849_b()
    {
        field_1214_c = true;
        field_1213_d.func_28139_a();
        field_1213_d.func_974_a("disconnect.closed", new Object[0]);
    }

    public void func_828_a(Packet24MobSpawn p_828_1_)
    {
        double d = (double)p_828_1_.field_552_c / 32D;
        double d1 = (double)p_828_1_.field_551_d / 32D;
        double d2 = (double)p_828_1_.field_550_e / 32D;
        float f = (float)(p_828_1_.field_549_f * 360) / 256F;
        float f1 = (float)(p_828_1_.field_548_g * 360) / 256F;
        EntityLiving entityliving = (EntityLiving)EntityList.func_1084_a(p_828_1_.field_546_b, field_1212_e.field_6324_e);
        entityliving.field_9303_br = p_828_1_.field_552_c;
        entityliving.field_9302_bs = p_828_1_.field_551_d;
        entityliving.field_9301_bt = p_828_1_.field_550_e;
        entityliving.field_46015_bf = (float)(p_828_1_.field_48169_h * 360) / 256F;
        Entity aentity[] = entityliving.func_40048_X();
        if(aentity != null)
        {
            int i = p_828_1_.field_547_a - entityliving.field_620_ab;
            for(int j = 0; j < aentity.length; j++)
            {
                aentity[j].field_620_ab += i;
            }

        }
        entityliving.field_620_ab = p_828_1_.field_547_a;
        entityliving.func_399_b(d, d1, d2, f, f1);
        field_1211_f.func_712_a(p_828_1_.field_547_a, entityliving);
        List list = p_828_1_.func_21053_b();
        if(list != null)
        {
            entityliving.func_21061_O().func_21126_a(list);
        }
    }

    public void func_846_a(Packet4UpdateTime p_846_1_)
    {
        field_1212_e.field_6324_e.func_648_a(p_846_1_.field_564_a);
    }

    public void func_845_a(Packet6SpawnPosition p_845_1_)
    {
        field_1212_e.field_6322_g.func_25061_a(new ChunkCoordinates(p_845_1_.field_515_a, p_845_1_.field_514_b, p_845_1_.field_516_c));
        field_1212_e.field_6324_e.func_22144_v().func_22292_a(p_845_1_.field_515_a, p_845_1_.field_514_b, p_845_1_.field_516_c);
    }

    public void func_6497_a(Packet39AttachEntity p_6497_1_)
    {
        Object obj = func_12246_a(p_6497_1_.field_6365_a);
        Entity entity = func_12246_a(p_6497_1_.field_6364_b);
        if(p_6497_1_.field_6365_a == field_1212_e.field_6322_g.field_620_ab)
        {
            obj = field_1212_e.field_6322_g;
        }
        if(obj == null)
        {
            return;
        } else
        {
            ((Entity) (obj)).func_6377_h(entity);
            return;
        }
    }

    public void func_9447_a(Packet38EntityStatus p_9447_1_)
    {
        Entity entity = func_12246_a(p_9447_1_.field_9274_a);
        if(entity != null)
        {
            entity.func_9282_a(p_9447_1_.field_9273_b);
        }
    }

    private Entity func_12246_a(int p_12246_1_)
    {
        if(p_12246_1_ == field_1212_e.field_6322_g.field_620_ab)
        {
            return field_1212_e.field_6322_g;
        } else
        {
            return field_1211_f.func_709_b(p_12246_1_);
        }
    }

    public void func_9446_a(Packet8UpdateHealth p_9446_1_)
    {
        field_1212_e.field_6322_g.func_9372_a_(p_9446_1_.field_9275_a);
        field_1212_e.field_6322_g.func_35191_at().func_35764_a(p_9446_1_.field_35231_b);
        field_1212_e.field_6322_g.func_35191_at().func_35767_b(p_9446_1_.field_35232_c);
    }

    public void func_35777_a(Packet43Experience p_35777_1_)
    {
        field_1212_e.field_6322_g.func_35219_c(p_35777_1_.field_35230_a, p_35777_1_.field_35228_b, p_35777_1_.field_35229_c);
    }

    public void func_9448_a(Packet9Respawn p_9448_1_)
    {
        if(p_9448_1_.field_35244_b != field_1212_e.field_6322_g.field_4129_m)
        {
            field_1210_g = false;
            field_1211_f = new WorldClient(this, new WorldSettings(0L, p_9448_1_.field_35243_e, false, false, p_9448_1_.field_46031_f), p_9448_1_.field_35244_b, p_9448_1_.field_35245_c);
            field_1211_f.field_1026_y = true;
            field_1212_e.func_6261_a(field_1211_f);
            field_1212_e.field_6322_g.field_4129_m = p_9448_1_.field_35244_b;
            field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
        }
        field_1212_e.func_6239_p(true, p_9448_1_.field_35244_b, false);
        ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(p_9448_1_.field_35243_e == 1);
    }

    public void func_12245_a(Packet60Explosion p_12245_1_)
    {
        Explosion explosion = new Explosion(field_1212_e.field_6324_e, null, p_12245_1_.field_12236_a, p_12245_1_.field_12235_b, p_12245_1_.field_12239_c, p_12245_1_.field_12238_d);
        explosion.field_12251_g = p_12245_1_.field_12237_e;
        explosion.func_12247_b(true);
    }

    public void func_20087_a(Packet100OpenWindow p_20087_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        switch(p_20087_1_.field_20037_b)
        {
        case 0: // '\0'
            entityplayersp.func_452_a(new InventoryBasic(p_20087_1_.field_20040_c, p_20087_1_.field_20039_d));
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;

        case 2: // '\002'
            entityplayersp.func_453_a(new TileEntityFurnace());
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;

        case 5: // '\005'
            entityplayersp.func_40180_a(new TileEntityBrewingStand());
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;

        case 3: // '\003'
            entityplayersp.func_21092_a(new TileEntityDispenser());
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;

        case 1: // '\001'
            entityplayersp.func_445_l(MathHelper.func_1108_b(entityplayersp.field_611_ak), MathHelper.func_1108_b(entityplayersp.field_610_al), MathHelper.func_1108_b(entityplayersp.field_609_am));
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;

        case 4: // '\004'
            entityplayersp.func_40181_c(MathHelper.func_1108_b(entityplayersp.field_611_ak), MathHelper.func_1108_b(entityplayersp.field_610_al), MathHelper.func_1108_b(entityplayersp.field_609_am));
            entityplayersp.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
            break;
        }
    }

    public void func_20088_a(Packet103SetSlot p_20088_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        if(p_20088_1_.field_20042_a == -1)
        {
            ((EntityPlayer) (entityplayersp)).field_778_b.func_20076_b(p_20088_1_.field_20043_c);
        } else
        if(p_20088_1_.field_20042_a == 0 && p_20088_1_.field_20041_b >= 36 && p_20088_1_.field_20041_b < 45)
        {
            ItemStack itemstack = ((EntityPlayer) (entityplayersp)).field_20069_g.func_20118_a(p_20088_1_.field_20041_b).func_777_b();
            if(p_20088_1_.field_20043_c != null && (itemstack == null || itemstack.field_1615_a < p_20088_1_.field_20043_c.field_1615_a))
            {
                p_20088_1_.field_20043_c.field_1614_b = 5;
            }
            ((EntityPlayer) (entityplayersp)).field_20069_g.func_20119_a(p_20088_1_.field_20041_b, p_20088_1_.field_20043_c);
        } else
        if(p_20088_1_.field_20042_a == ((EntityPlayer) (entityplayersp)).field_20068_h.field_1618_c)
        {
            ((EntityPlayer) (entityplayersp)).field_20068_h.func_20119_a(p_20088_1_.field_20041_b, p_20088_1_.field_20043_c);
        }
    }

    public void func_20089_a(Packet106Transaction p_20089_1_)
    {
        Container container = null;
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        if(p_20089_1_.field_20029_a == 0)
        {
            container = ((EntityPlayer) (entityplayersp)).field_20069_g;
        } else
        if(p_20089_1_.field_20029_a == ((EntityPlayer) (entityplayersp)).field_20068_h.field_1618_c)
        {
            container = ((EntityPlayer) (entityplayersp)).field_20068_h;
        }
        if(container != null)
        {
            if(p_20089_1_.field_20030_c)
            {
                container.func_20113_a(p_20089_1_.field_20028_b);
            } else
            {
                container.func_20110_b(p_20089_1_.field_20028_b);
                func_847_a(new Packet106Transaction(p_20089_1_.field_20029_a, p_20089_1_.field_20028_b, true));
            }
        }
    }

    public void func_20094_a(Packet104WindowItems p_20094_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        if(p_20094_1_.field_20036_a == 0)
        {
            ((EntityPlayer) (entityplayersp)).field_20069_g.func_20115_a(p_20094_1_.field_20035_b);
        } else
        if(p_20094_1_.field_20036_a == ((EntityPlayer) (entityplayersp)).field_20068_h.field_1618_c)
        {
            ((EntityPlayer) (entityplayersp)).field_20068_h.func_20115_a(p_20094_1_.field_20035_b);
        }
    }

    public void func_20093_a(Packet130UpdateSign p_20093_1_)
    {
        if(field_1212_e.field_6324_e.func_630_d(p_20093_1_.field_20020_a, p_20093_1_.field_20019_b, p_20093_1_.field_20022_c))
        {
            TileEntity tileentity = field_1212_e.field_6324_e.func_603_b(p_20093_1_.field_20020_a, p_20093_1_.field_20019_b, p_20093_1_.field_20022_c);
            if(tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;
                if(tileentitysign.func_50007_a())
                {
                    for(int i = 0; i < 4; i++)
                    {
                        tileentitysign.field_826_a[i] = p_20093_1_.field_20021_d[i];
                    }

                    tileentitysign.func_474_j_();
                }
            }
        }
    }

    public void func_48489_a(Packet132TileEntityData p_48489_1_)
    {
        if(field_1212_e.field_6324_e.func_630_d(p_48489_1_.field_48167_a, p_48489_1_.field_48165_b, p_48489_1_.field_48166_c))
        {
            TileEntity tileentity = field_1212_e.field_6324_e.func_603_b(p_48489_1_.field_48167_a, p_48489_1_.field_48165_b, p_48489_1_.field_48166_c);
            if(tileentity != null && p_48489_1_.field_48163_d == 1 && (tileentity instanceof TileEntityMobSpawner))
            {
                ((TileEntityMobSpawner)tileentity).func_21098_a(EntityList.func_44040_a(p_48489_1_.field_48164_e));
            }
        }
    }

    public void func_20090_a(Packet105UpdateProgressbar p_20090_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        func_4114_b(p_20090_1_);
        if(((EntityPlayer) (entityplayersp)).field_20068_h != null && ((EntityPlayer) (entityplayersp)).field_20068_h.field_1618_c == p_20090_1_.field_20032_a)
        {
            ((EntityPlayer) (entityplayersp)).field_20068_h.func_20112_a(p_20090_1_.field_20031_b, p_20090_1_.field_20033_c);
        }
    }

    public void func_843_a(Packet5PlayerInventory p_843_1_)
    {
        Entity entity = func_12246_a(p_843_1_.field_571_a);
        if(entity != null)
        {
            entity.func_20045_c(p_843_1_.field_21056_b, p_843_1_.field_570_b, p_843_1_.field_20044_c);
        }
    }

    public void func_20092_a(Packet101CloseWindow p_20092_1_)
    {
        field_1212_e.field_6322_g.func_20059_m();
    }

    public void func_21145_a(Packet54PlayNoteBlock p_21145_1_)
    {
        field_1212_e.field_6324_e.func_21116_c(p_21145_1_.field_21037_a, p_21145_1_.field_21036_b, p_21145_1_.field_21040_c, p_21145_1_.field_21039_d, p_21145_1_.field_21038_e);
    }

    public void func_25118_a(Packet70Bed p_25118_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        int i = p_25118_1_.field_25019_b;
        if(i >= 0 && i < Packet70Bed.field_25020_a.length && Packet70Bed.field_25020_a[i] != null)
        {
            entityplayersp.func_22055_b(Packet70Bed.field_25020_a[i]);
        }
        if(i == 1)
        {
            field_1211_f.func_22144_v().func_27394_b(true);
            field_1211_f.func_27158_h(1.0F);
        } else
        if(i == 2)
        {
            field_1211_f.func_22144_v().func_27394_b(false);
            field_1211_f.func_27158_h(0.0F);
        } else
        if(i == 3)
        {
            ((PlayerControllerMP)field_1212_e.field_6327_b).func_35648_a(p_25118_1_.field_35262_c == 1);
        } else
        if(i == 4)
        {
            field_1212_e.func_6272_a(new GuiWinGame());
        }
    }

    public void func_28116_a(Packet131MapData p_28116_1_)
    {
        if(p_28116_1_.field_28055_a == Item.field_28010_bb.field_291_aS)
        {
            ItemMap.func_28013_a(p_28116_1_.field_28054_b, field_1212_e.field_6324_e).func_28171_a(p_28116_1_.field_28056_c);
        } else
        {
            System.out.println((new StringBuilder()).append("Unknown itemid: ").append(p_28116_1_.field_28054_b).toString());
        }
    }

    public void func_28115_a(Packet61DoorChange p_28115_1_)
    {
        field_1212_e.field_6324_e.func_28106_e(p_28115_1_.field_28050_a, p_28115_1_.field_28053_c, p_28115_1_.field_28052_d, p_28115_1_.field_28051_e, p_28115_1_.field_28049_b);
    }

    public void func_27245_a(Packet200Statistic p_27245_1_)
    {
        ((EntityClientPlayerMP)field_1212_e.field_6322_g).func_27027_b(StatList.func_27361_a(p_27245_1_.field_27052_a), p_27245_1_.field_27051_b);
    }

    public void func_35780_a(Packet41EntityEffect p_35780_1_)
    {
        Entity entity = func_12246_a(p_35780_1_.field_35261_a);
        if(entity == null || !(entity instanceof EntityLiving))
        {
            return;
        } else
        {
            ((EntityLiving)entity).func_35165_a(new PotionEffect(p_35780_1_.field_35259_b, p_35780_1_.field_35258_d, p_35780_1_.field_35260_c));
            return;
        }
    }

    public void func_35783_a(Packet42RemoveEntityEffect p_35783_1_)
    {
        Entity entity = func_12246_a(p_35783_1_.field_35253_a);
        if(entity == null || !(entity instanceof EntityLiving))
        {
            return;
        } else
        {
            ((EntityLiving)entity).func_36002_f(p_35783_1_.field_35252_b);
            return;
        }
    }

    public boolean func_27247_c()
    {
        return false;
    }

    public void func_35779_a(Packet201PlayerInfo p_35779_1_)
    {
        GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)field_35787_k.get(p_35779_1_.field_35257_a);
        if(guiplayerinfo == null && p_35779_1_.field_35255_b)
        {
            guiplayerinfo = new GuiPlayerInfo(p_35779_1_.field_35257_a);
            field_35787_k.put(p_35779_1_.field_35257_a, guiplayerinfo);
            field_35786_c.add(guiplayerinfo);
        }
        if(guiplayerinfo != null && !p_35779_1_.field_35255_b)
        {
            field_35787_k.remove(p_35779_1_.field_35257_a);
            field_35786_c.remove(guiplayerinfo);
        }
        if(p_35779_1_.field_35255_b && guiplayerinfo != null)
        {
            guiplayerinfo.field_35623_b = p_35779_1_.field_35256_c;
        }
    }

    public void func_35784_a(Packet0KeepAlive p_35784_1_)
    {
        func_847_a(new Packet0KeepAlive(p_35784_1_.field_35254_a));
    }

    public void func_50100_a(Packet202PlayerAbilities p_50100_1_)
    {
        EntityPlayerSP entityplayersp = field_1212_e.field_6322_g;
        ((EntityPlayer) (entityplayersp)).field_35212_aW.field_35757_b = p_50100_1_.field_50070_b;
        ((EntityPlayer) (entityplayersp)).field_35212_aW.field_35756_d = p_50100_1_.field_50069_d;
        ((EntityPlayer) (entityplayersp)).field_35212_aW.field_35759_a = p_50100_1_.field_50072_a;
        ((EntityPlayer) (entityplayersp)).field_35212_aW.field_35758_c = p_50100_1_.field_50071_c;
    }
}
