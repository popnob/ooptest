// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumArt extends Enum
{

    public static final EnumArt Kebab;
    public static final EnumArt Aztec;
    public static final EnumArt Alban;
    public static final EnumArt Aztec2;
    public static final EnumArt Bomb;
    public static final EnumArt Plant;
    public static final EnumArt Wasteland;
    public static final EnumArt Pool;
    public static final EnumArt Courbet;
    public static final EnumArt Sea;
    public static final EnumArt Sunset;
    public static final EnumArt Creebet;
    public static final EnumArt Wanderer;
    public static final EnumArt Graham;
    public static final EnumArt Match;
    public static final EnumArt Bust;
    public static final EnumArt Stage;
    public static final EnumArt Void;
    public static final EnumArt SkullAndRoses;
    public static final EnumArt Fighters;
    public static final EnumArt Pointer;
    public static final EnumArt Pigscene;
    public static final EnumArt BurningSkull;
    public static final EnumArt Skeleton;
    public static final EnumArt DonkeyKong;
    public static final int field_27365_z = "SkullAndRoses".length();
    public final String field_1624_y;
    public final int field_1623_z;
    public final int field_1636_A;
    public final int field_1634_B;
    public final int field_1632_C;
    private static final EnumArt $VALUES[]; /* synthetic field */

    public static EnumArt[] values()
    {
        return (EnumArt[])$VALUES.clone();
    }

    public static EnumArt valueOf(String p_valueOf_0_)
    {
        return (EnumArt)Enum.valueOf(net.minecraft.src.EnumArt.class, p_valueOf_0_);
    }

    private EnumArt(String p_i346_1_, int p_i346_2_, String p_i346_3_, int p_i346_4_, int p_i346_5_, int p_i346_6_, int p_i346_7_)
    {
        super(p_i346_1_, p_i346_2_);
        field_1624_y = p_i346_3_;
        field_1623_z = p_i346_4_;
        field_1636_A = p_i346_5_;
        field_1634_B = p_i346_6_;
        field_1632_C = p_i346_7_;
    }

    static 
    {
        Kebab = new EnumArt("Kebab", 0, "Kebab", 16, 16, 0, 0);
        Aztec = new EnumArt("Aztec", 1, "Aztec", 16, 16, 16, 0);
        Alban = new EnumArt("Alban", 2, "Alban", 16, 16, 32, 0);
        Aztec2 = new EnumArt("Aztec2", 3, "Aztec2", 16, 16, 48, 0);
        Bomb = new EnumArt("Bomb", 4, "Bomb", 16, 16, 64, 0);
        Plant = new EnumArt("Plant", 5, "Plant", 16, 16, 80, 0);
        Wasteland = new EnumArt("Wasteland", 6, "Wasteland", 16, 16, 96, 0);
        Pool = new EnumArt("Pool", 7, "Pool", 32, 16, 0, 32);
        Courbet = new EnumArt("Courbet", 8, "Courbet", 32, 16, 32, 32);
        Sea = new EnumArt("Sea", 9, "Sea", 32, 16, 64, 32);
        Sunset = new EnumArt("Sunset", 10, "Sunset", 32, 16, 96, 32);
        Creebet = new EnumArt("Creebet", 11, "Creebet", 32, 16, 128, 32);
        Wanderer = new EnumArt("Wanderer", 12, "Wanderer", 16, 32, 0, 64);
        Graham = new EnumArt("Graham", 13, "Graham", 16, 32, 16, 64);
        Match = new EnumArt("Match", 14, "Match", 32, 32, 0, 128);
        Bust = new EnumArt("Bust", 15, "Bust", 32, 32, 32, 128);
        Stage = new EnumArt("Stage", 16, "Stage", 32, 32, 64, 128);
        Void = new EnumArt("Void", 17, "Void", 32, 32, 96, 128);
        SkullAndRoses = new EnumArt("SkullAndRoses", 18, "SkullAndRoses", 32, 32, 128, 128);
        Fighters = new EnumArt("Fighters", 19, "Fighters", 64, 32, 0, 96);
        Pointer = new EnumArt("Pointer", 20, "Pointer", 64, 64, 0, 192);
        Pigscene = new EnumArt("Pigscene", 21, "Pigscene", 64, 64, 64, 192);
        BurningSkull = new EnumArt("BurningSkull", 22, "BurningSkull", 64, 64, 128, 192);
        Skeleton = new EnumArt("Skeleton", 23, "Skeleton", 64, 48, 192, 64);
        DonkeyKong = new EnumArt("DonkeyKong", 24, "DonkeyKong", 64, 48, 192, 112);
        $VALUES = (new EnumArt[] {
            Kebab, Aztec, Alban, Aztec2, Bomb, Plant, Wasteland, Pool, Courbet, Sea, 
            Sunset, Creebet, Wanderer, Graham, Match, Bust, Stage, Void, SkullAndRoses, Fighters, 
            Pointer, Pigscene, BurningSkull, Skeleton, DonkeyKong
        });
    }
}
