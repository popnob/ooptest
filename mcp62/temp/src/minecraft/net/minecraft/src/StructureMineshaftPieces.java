// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentMineshaftCross, ComponentMineshaftStairs, ComponentMineshaftCorridor, StructureComponent, 
//            StructureBoundingBox, StructurePieceTreasure, Item, Block

public class StructureMineshaftPieces
{

    private static final StructurePieceTreasure field_35589_a[];

    public StructureMineshaftPieces()
    {
    }

    private static StructureComponent func_35586_a(List p_35586_0_, Random p_35586_1_, int p_35586_2_, int p_35586_3_, int p_35586_4_, int p_35586_5_, int p_35586_6_)
    {
        int i = p_35586_1_.nextInt(100);
        if(i >= 80)
        {
            StructureBoundingBox structureboundingbox = ComponentMineshaftCross.func_35071_a(p_35586_0_, p_35586_1_, p_35586_2_, p_35586_3_, p_35586_4_, p_35586_5_);
            if(structureboundingbox != null)
            {
                return new ComponentMineshaftCross(p_35586_6_, p_35586_1_, structureboundingbox, p_35586_5_);
            }
        } else
        if(i >= 70)
        {
            StructureBoundingBox structureboundingbox1 = ComponentMineshaftStairs.func_35027_a(p_35586_0_, p_35586_1_, p_35586_2_, p_35586_3_, p_35586_4_, p_35586_5_);
            if(structureboundingbox1 != null)
            {
                return new ComponentMineshaftStairs(p_35586_6_, p_35586_1_, structureboundingbox1, p_35586_5_);
            }
        } else
        {
            StructureBoundingBox structureboundingbox2 = ComponentMineshaftCorridor.func_35066_a(p_35586_0_, p_35586_1_, p_35586_2_, p_35586_3_, p_35586_4_, p_35586_5_);
            if(structureboundingbox2 != null)
            {
                return new ComponentMineshaftCorridor(p_35586_6_, p_35586_1_, structureboundingbox2, p_35586_5_);
            }
        }
        return null;
    }

    private static StructureComponent func_35587_b(StructureComponent p_35587_0_, List p_35587_1_, Random p_35587_2_, int p_35587_3_, int p_35587_4_, int p_35587_5_, int p_35587_6_, int p_35587_7_)
    {
        if(p_35587_7_ > 8)
        {
            return null;
        }
        if(Math.abs(p_35587_3_ - p_35587_0_.func_35021_b().field_35753_a) > 80 || Math.abs(p_35587_5_ - p_35587_0_.func_35021_b().field_35752_c) > 80)
        {
            return null;
        }
        StructureComponent structurecomponent = func_35586_a(p_35587_1_, p_35587_2_, p_35587_3_, p_35587_4_, p_35587_5_, p_35587_6_, p_35587_7_ + 1);
        if(structurecomponent != null)
        {
            p_35587_1_.add(structurecomponent);
            structurecomponent.func_35004_a(p_35587_0_, p_35587_1_, p_35587_2_);
        }
        return structurecomponent;
    }

    static StructureComponent func_35585_a(StructureComponent p_35585_0_, List p_35585_1_, Random p_35585_2_, int p_35585_3_, int p_35585_4_, int p_35585_5_, int p_35585_6_, int p_35585_7_)
    {
        return func_35587_b(p_35585_0_, p_35585_1_, p_35585_2_, p_35585_3_, p_35585_4_, p_35585_5_, p_35585_6_, p_35585_7_);
    }

    static StructurePieceTreasure[] func_35588_a()
    {
        return field_35589_a;
    }

    static 
    {
        field_35589_a = (new StructurePieceTreasure[] {
            new StructurePieceTreasure(Item.field_223_m.field_291_aS, 0, 1, 5, 10), new StructurePieceTreasure(Item.field_222_n.field_291_aS, 0, 1, 3, 5), new StructurePieceTreasure(Item.field_309_aA.field_291_aS, 0, 4, 9, 5), new StructurePieceTreasure(Item.field_21021_aU.field_291_aS, 4, 4, 9, 5), new StructurePieceTreasure(Item.field_224_l.field_291_aS, 0, 1, 2, 3), new StructurePieceTreasure(Item.field_225_k.field_291_aS, 0, 3, 8, 10), new StructurePieceTreasure(Item.field_242_S.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_231_e.field_291_aS, 0, 1, 1, 1), new StructurePieceTreasure(Block.field_440_aH.field_376_bc, 0, 4, 8, 1), new StructurePieceTreasure(Item.field_35423_bi.field_291_aS, 0, 2, 4, 10), 
            new StructurePieceTreasure(Item.field_35422_bh.field_291_aS, 0, 2, 4, 10)
        });
    }
}
