// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, EntityPlayer

public class InventoryLargeChest
    implements IInventory
{

    private String field_837_a;
    private IInventory field_836_b;
    private IInventory field_838_c;

    public InventoryLargeChest(String p_i413_1_, IInventory p_i413_2_, IInventory p_i413_3_)
    {
        field_837_a = p_i413_1_;
        if(p_i413_2_ == null)
        {
            p_i413_2_ = p_i413_3_;
        }
        if(p_i413_3_ == null)
        {
            p_i413_3_ = p_i413_2_;
        }
        field_836_b = p_i413_2_;
        field_838_c = p_i413_3_;
    }

    public int func_469_c()
    {
        return field_836_b.func_469_c() + field_838_c.func_469_c();
    }

    public String func_471_d()
    {
        return field_837_a;
    }

    public ItemStack func_468_c(int p_468_1_)
    {
        if(p_468_1_ >= field_836_b.func_469_c())
        {
            return field_838_c.func_468_c(p_468_1_ - field_836_b.func_469_c());
        } else
        {
            return field_836_b.func_468_c(p_468_1_);
        }
    }

    public ItemStack func_473_a(int p_473_1_, int p_473_2_)
    {
        if(p_473_1_ >= field_836_b.func_469_c())
        {
            return field_838_c.func_473_a(p_473_1_ - field_836_b.func_469_c(), p_473_2_);
        } else
        {
            return field_836_b.func_473_a(p_473_1_, p_473_2_);
        }
    }

    public ItemStack func_48081_b(int p_48081_1_)
    {
        if(p_48081_1_ >= field_836_b.func_469_c())
        {
            return field_838_c.func_48081_b(p_48081_1_ - field_836_b.func_469_c());
        } else
        {
            return field_836_b.func_48081_b(p_48081_1_);
        }
    }

    public void func_472_a(int p_472_1_, ItemStack p_472_2_)
    {
        if(p_472_1_ >= field_836_b.func_469_c())
        {
            field_838_c.func_472_a(p_472_1_ - field_836_b.func_469_c(), p_472_2_);
        } else
        {
            field_836_b.func_472_a(p_472_1_, p_472_2_);
        }
    }

    public int func_470_e()
    {
        return field_836_b.func_470_e();
    }

    public void func_474_j_()
    {
        field_836_b.func_474_j_();
        field_838_c.func_474_j_();
    }

    public boolean func_20070_a_(EntityPlayer p_20070_1_)
    {
        return field_836_b.func_20070_a_(p_20070_1_) && field_838_c.func_20070_a_(p_20070_1_);
    }

    public void func_35142_x_()
    {
        field_836_b.func_35142_x_();
        field_838_c.func_35142_x_();
    }

    public void func_35141_y_()
    {
        field_836_b.func_35141_y_();
        field_838_c.func_35141_y_();
    }
}
