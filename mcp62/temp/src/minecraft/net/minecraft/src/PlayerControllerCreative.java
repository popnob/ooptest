// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerController, EntityPlayer, PlayerCapabilities, InventoryPlayer, 
//            ItemStack, Session, Block, World

public class PlayerControllerCreative extends PlayerController
{

    private int field_35647_c;

    public PlayerControllerCreative(Minecraft p_i83_1_)
    {
        super(p_i83_1_);
        field_1064_b = true;
    }

    public static void func_35646_d(EntityPlayer p_35646_0_)
    {
        p_35646_0_.field_35212_aW.field_35758_c = true;
        p_35646_0_.field_35212_aW.field_35756_d = true;
        p_35646_0_.field_35212_aW.field_35759_a = true;
    }

    public static void func_35645_e(EntityPlayer p_35645_0_)
    {
        p_35645_0_.field_35212_aW.field_35758_c = false;
        p_35645_0_.field_35212_aW.field_35757_b = false;
        p_35645_0_.field_35212_aW.field_35756_d = false;
        p_35645_0_.field_35212_aW.field_35759_a = false;
    }

    public void func_6473_b(EntityPlayer p_6473_1_)
    {
        func_35646_d(p_6473_1_);
        for(int i = 0; i < 9; i++)
        {
            if(p_6473_1_.field_778_b.field_843_a[i] == null)
            {
                p_6473_1_.field_778_b.field_843_a[i] = new ItemStack((Block)Session.field_1667_a.get(i));
            }
        }

    }

    public static void func_35644_a(Minecraft p_35644_0_, PlayerController p_35644_1_, int p_35644_2_, int p_35644_3_, int p_35644_4_, int p_35644_5_)
    {
        if(!p_35644_0_.field_6324_e.func_48457_a(p_35644_0_.field_6322_g, p_35644_2_, p_35644_3_, p_35644_4_, p_35644_5_))
        {
            p_35644_1_.func_729_b(p_35644_2_, p_35644_3_, p_35644_4_, p_35644_5_);
        }
    }

    public boolean func_722_a(EntityPlayer p_722_1_, World p_722_2_, ItemStack p_722_3_, int p_722_4_, int p_722_5_, int p_722_6_, int p_722_7_)
    {
        int i = p_722_2_.func_600_a(p_722_4_, p_722_5_, p_722_6_);
        if(i > 0 && Block.field_345_n[i].func_250_a(p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_1_))
        {
            return true;
        }
        if(p_722_3_ == null)
        {
            return false;
        } else
        {
            int j = p_722_3_.func_21181_i();
            int k = p_722_3_.field_1615_a;
            boolean flag = p_722_3_.func_1090_a(p_722_1_, p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_7_);
            p_722_3_.func_28156_b(j);
            p_722_3_.field_1615_a = k;
            return flag;
        }
    }

    public void func_719_a(int p_719_1_, int p_719_2_, int p_719_3_, int p_719_4_)
    {
        func_35644_a(field_1065_a, this, p_719_1_, p_719_2_, p_719_3_, p_719_4_);
        field_35647_c = 5;
    }

    public void func_6470_c(int p_6470_1_, int p_6470_2_, int p_6470_3_, int p_6470_4_)
    {
        field_35647_c--;
        if(field_35647_c <= 0)
        {
            field_35647_c = 5;
            func_35644_a(field_1065_a, this, p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_);
        }
    }

    public void func_6468_a()
    {
    }

    public boolean func_6469_d()
    {
        return false;
    }

    public void func_717_a(World p_717_1_)
    {
        super.func_717_a(p_717_1_);
    }

    public float func_727_b()
    {
        return 5F;
    }

    public boolean func_35641_g()
    {
        return false;
    }

    public boolean func_35640_h()
    {
        return true;
    }

    public boolean func_35636_i()
    {
        return true;
    }
}
