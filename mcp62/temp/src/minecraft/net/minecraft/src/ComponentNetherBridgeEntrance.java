// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeEntrance extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeEntrance(int p_i514_1_, Random p_i514_2_, StructureBoundingBox p_i514_3_, int p_i514_4_)
    {
        super(p_i514_1_);
        field_35025_h = p_i514_4_;
        field_35024_g = p_i514_3_;
    }

    public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_)
    {
        func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 5, 3, true);
    }

    public static ComponentNetherBridgeEntrance func_40030_a(List p_40030_0_, Random p_40030_1_, int p_40030_2_, int p_40030_3_, int p_40030_4_, int p_40030_5_, int p_40030_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(p_40030_2_, p_40030_3_, p_40030_4_, -5, -3, 0, 13, 14, 13, p_40030_5_);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(p_40030_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeEntrance(p_40030_6_, p_40030_1_, structureboundingbox, p_40030_5_);
        }
    }

    public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_)
    {
        func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 0, 12, 4, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 12, 13, 12, 0, 0, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 1, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 0, 12, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 11, 4, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 11, 10, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 5, 9, 11, 7, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 0, 4, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 0, 10, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 5, 9, 0, 7, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 2, 11, 2, 10, 12, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 5, 8, 0, 7, 8, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        for(int i = 1; i <= 11; i += 2)
        {
            func_35011_a(p_35023_1_, p_35023_3_, i, 10, 0, i, 11, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(p_35023_1_, p_35023_3_, i, 10, 12, i, 11, 12, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(p_35023_1_, p_35023_3_, 0, 10, i, 0, 11, i, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(p_35023_1_, p_35023_3_, 12, 10, i, 12, 11, i, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, i, 13, 0, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, i, 13, 12, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 0, 13, i, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 12, 13, i, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, i + 1, 13, 0, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, i + 1, 13, 12, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, i + 1, p_35023_3_);
            func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 12, 13, i + 1, p_35023_3_);
        }

        func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 12, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 12, 13, 0, p_35023_3_);
        for(int j = 3; j <= 9; j += 2)
        {
            func_35011_a(p_35023_1_, p_35023_3_, 1, 7, j, 1, 8, j, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            func_35011_a(p_35023_1_, p_35023_3_, 11, 7, j, 11, 8, j, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        }

        func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 0, 8, 2, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 4, 12, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 0, 8, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 9, 8, 1, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 4, 3, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 9, 0, 4, 12, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        for(int k = 4; k <= 8; k++)
        {
            for(int j1 = 0; j1 <= 2; j1++)
            {
                func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, k, -1, j1, p_35023_3_);
                func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, k, -1, 12 - j1, p_35023_3_);
            }

        }

        for(int l = 0; l <= 2; l++)
        {
            for(int k1 = 4; k1 <= 8; k1++)
            {
                func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, l, -1, k1, p_35023_3_);
                func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 12 - l, -1, k1, p_35023_3_);
            }

        }

        func_35011_a(p_35023_1_, p_35023_3_, 5, 5, 5, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(p_35023_1_, p_35023_3_, 6, 1, 6, 6, 4, 6, 0, 0, false);
        func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 6, 0, 6, p_35023_3_);
        func_35018_a(p_35023_1_, Block.field_397_D.field_376_bc, 0, 6, 5, 6, p_35023_3_);
        int i1 = func_35017_a(6, 6);
        int l1 = func_35008_a(5);
        int i2 = func_35006_b(6, 6);
        if(p_35023_3_.func_35742_b(i1, l1, i2))
        {
            p_35023_1_.field_4214_a = true;
            Block.field_345_n[Block.field_397_D.field_376_bc].func_208_a(p_35023_1_, i1, l1, i2, p_35023_2_);
            p_35023_1_.field_4214_a = false;
        }
        return true;
    }
}
