// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            StructurePieceTreasure, Item, World

public class ComponentVillageHouse2 extends ComponentVillage
{

    private static final StructurePieceTreasure field_46002_a[];
    private int field_35086_a;
    private boolean field_46001_c;

    public ComponentVillageHouse2(int p_i268_1_, Random p_i268_2_, StructureBoundingBox p_i268_3_, int p_i268_4_)
    {
        super(p_i268_1_);
        field_35086_a = -1;
        field_35025_h = p_i268_4_;
        field_35024_g = p_i268_3_;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageHouse2 func_35085_a(List p_35085_0_, Random p_35085_1_, int p_35085_2_, int p_35085_3_, int p_35085_4_, int p_35085_5_, int p_35085_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(p_35085_2_, p_35085_3_, p_35085_4_, 0, 0, 0, 10, 6, 7, p_35085_5_);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(p_35085_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse2(p_35085_6_, p_35085_1_, structureboundingbox, p_35085_5_);
        }
    }

    public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_)
    {
        if(field_35086_a < 0)
        {
            field_35086_a = func_35075_b(p_35023_1_, p_35023_3_);
            if(field_35086_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35086_a - field_35024_g.field_35750_e) + 6) - 1, 0);
        }
        func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 0, 9, 4, 6, 0, 0, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 9, 0, 6, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 4, 0, 9, 4, 6, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 9, 5, 6, Block.field_410_al.field_376_bc, Block.field_410_al.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 1, 8, 5, 5, 0, 0, false);
        func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 0, 2, 3, 0, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 0, 0, 4, 0, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 3, 1, 0, 3, 4, 0, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 6, 0, 4, 6, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
        func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 3, 3, 1, p_35023_3_);
        func_35011_a(p_35023_1_, p_35023_3_, 3, 1, 2, 3, 3, 2, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 3, 5, 3, 3, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 1, 0, 3, 5, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 6, 5, 3, 6, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 5, 1, 0, 5, 3, 0, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 9, 1, 0, 9, 3, 0, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 6, 1, 4, 9, 4, 6, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
        func_35018_a(p_35023_1_, Block.field_397_D.field_376_bc, 0, 7, 1, 5, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_397_D.field_376_bc, 0, 8, 1, 5, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35288_bq.field_376_bc, 0, 9, 2, 5, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35288_bq.field_376_bc, 0, 9, 2, 4, p_35023_3_);
        func_35011_a(p_35023_1_, p_35023_3_, 7, 2, 4, 8, 2, 5, 0, 0, false);
        func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 6, 1, 3, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_445_aC.field_376_bc, 0, 6, 2, 3, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_445_aC.field_376_bc, 0, 6, 3, 3, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_411_ak.field_376_bc, 0, 8, 1, 1, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 2, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 4, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 2, 6, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 2, 6, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 2, 1, 4, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_4065_aN.field_376_bc, 0, 2, 2, 4, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 1, 1, 5, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, func_35009_c(Block.field_4059_au.field_376_bc, 3), 2, 1, 5, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, func_35009_c(Block.field_4059_au.field_376_bc, 1), 1, 1, 4, p_35023_3_);
        if(!field_46001_c)
        {
            int i = func_35008_a(1);
            int l = func_35017_a(5, 5);
            int j1 = func_35006_b(5, 5);
            if(p_35023_3_.func_35742_b(l, i, j1))
            {
                field_46001_c = true;
                func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 5, 1, 5, field_46002_a, 3 + p_35023_2_.nextInt(6));
            }
        }
        for(int j = 6; j <= 8; j++)
        {
            if(func_35007_a(p_35023_1_, j, 0, -1, p_35023_3_) == 0 && func_35007_a(p_35023_1_, j, -1, -1, p_35023_3_) != 0)
            {
                func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, func_35009_c(Block.field_4069_aI.field_376_bc, 3), j, 0, -1, p_35023_3_);
            }
        }

        for(int k = 0; k < 7; k++)
        {
            for(int i1 = 0; i1 < 10; i1++)
            {
                func_35016_b(p_35023_1_, i1, 6, k, p_35023_3_);
                func_35005_b(p_35023_1_, Block.field_335_x.field_376_bc, 0, i1, -1, k, p_35023_3_);
            }

        }

        func_40044_a(p_35023_1_, p_35023_3_, 7, 1, 1, 1);
        return true;
    }

    protected int func_40043_a(int p_40043_1_)
    {
        return 3;
    }

    static 
    {
        field_46002_a = (new StructurePieceTreasure[] {
            new StructurePieceTreasure(Item.field_224_l.field_291_aS, 0, 1, 3, 3), new StructurePieceTreasure(Item.field_223_m.field_291_aS, 0, 1, 5, 10), new StructurePieceTreasure(Item.field_222_n.field_291_aS, 0, 1, 3, 5), new StructurePieceTreasure(Item.field_242_S.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_228_h.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_231_e.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_221_o.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_284_ac.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_285_ab.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Item.field_283_ad.field_291_aS, 0, 1, 1, 5), 
            new StructurePieceTreasure(Item.field_282_ae.field_291_aS, 0, 1, 1, 5), new StructurePieceTreasure(Block.field_405_aq.field_376_bc, 0, 3, 7, 5), new StructurePieceTreasure(Block.field_333_z.field_376_bc, 0, 3, 7, 5)
        });
    }
}
