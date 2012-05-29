// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumOptions extends Enum
{

    public static final EnumOptions MUSIC;
    public static final EnumOptions SOUND;
    public static final EnumOptions INVERT_MOUSE;
    public static final EnumOptions SENSITIVITY;
    public static final EnumOptions FOV;
    public static final EnumOptions GAMMA;
    public static final EnumOptions RENDER_DISTANCE;
    public static final EnumOptions VIEW_BOBBING;
    public static final EnumOptions ANAGLYPH;
    public static final EnumOptions ADVANCED_OPENGL;
    public static final EnumOptions FRAMERATE_LIMIT;
    public static final EnumOptions DIFFICULTY;
    public static final EnumOptions GRAPHICS;
    public static final EnumOptions AMBIENT_OCCLUSION;
    public static final EnumOptions GUI_SCALE;
    public static final EnumOptions RENDER_CLOUDS;
    public static final EnumOptions PARTICLES;
    private final boolean field_20144_k;
    private final boolean field_20143_l;
    private final String field_20142_m;
    private static final EnumOptions $VALUES[]; /* synthetic field */

    public static EnumOptions[] values()
    {
        return (EnumOptions[])$VALUES.clone();
    }

    public static EnumOptions valueOf(String p_valueOf_0_)
    {
        return (EnumOptions)Enum.valueOf(net.minecraft.src.EnumOptions.class, p_valueOf_0_);
    }

    public static EnumOptions func_20137_a(int p_20137_0_)
    {
        EnumOptions aenumoptions[] = values();
        int i = aenumoptions.length;
        for(int j = 0; j < i; j++)
        {
            EnumOptions enumoptions = aenumoptions[j];
            if(enumoptions.func_20135_c() == p_20137_0_)
            {
                return enumoptions;
            }
        }

        return null;
    }

    private EnumOptions(String p_i722_1_, int p_i722_2_, String p_i722_3_, boolean p_i722_4_, boolean p_i722_5_)
    {
        super(p_i722_1_, p_i722_2_);
        field_20142_m = p_i722_3_;
        field_20144_k = p_i722_4_;
        field_20143_l = p_i722_5_;
    }

    public boolean func_20136_a()
    {
        return field_20144_k;
    }

    public boolean func_20140_b()
    {
        return field_20143_l;
    }

    public int func_20135_c()
    {
        return ordinal();
    }

    public String func_20138_d()
    {
        return field_20142_m;
    }

    static 
    {
        MUSIC = new EnumOptions("MUSIC", 0, "options.music", true, false);
        SOUND = new EnumOptions("SOUND", 1, "options.sound", true, false);
        INVERT_MOUSE = new EnumOptions("INVERT_MOUSE", 2, "options.invertMouse", false, true);
        SENSITIVITY = new EnumOptions("SENSITIVITY", 3, "options.sensitivity", true, false);
        FOV = new EnumOptions("FOV", 4, "options.fov", true, false);
        GAMMA = new EnumOptions("GAMMA", 5, "options.gamma", true, false);
        RENDER_DISTANCE = new EnumOptions("RENDER_DISTANCE", 6, "options.renderDistance", false, false);
        VIEW_BOBBING = new EnumOptions("VIEW_BOBBING", 7, "options.viewBobbing", false, true);
        ANAGLYPH = new EnumOptions("ANAGLYPH", 8, "options.anaglyph", false, true);
        ADVANCED_OPENGL = new EnumOptions("ADVANCED_OPENGL", 9, "options.advancedOpengl", false, true);
        FRAMERATE_LIMIT = new EnumOptions("FRAMERATE_LIMIT", 10, "options.framerateLimit", false, false);
        DIFFICULTY = new EnumOptions("DIFFICULTY", 11, "options.difficulty", false, false);
        GRAPHICS = new EnumOptions("GRAPHICS", 12, "options.graphics", false, false);
        AMBIENT_OCCLUSION = new EnumOptions("AMBIENT_OCCLUSION", 13, "options.ao", false, true);
        GUI_SCALE = new EnumOptions("GUI_SCALE", 14, "options.guiScale", false, false);
        RENDER_CLOUDS = new EnumOptions("RENDER_CLOUDS", 15, "options.renderClouds", false, true);
        PARTICLES = new EnumOptions("PARTICLES", 16, "options.particles", false, false);
        $VALUES = (new EnumOptions[] {
            MUSIC, SOUND, INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, ADVANCED_OPENGL, 
            FRAMERATE_LIMIT, DIFFICULTY, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, RENDER_CLOUDS, PARTICLES
        });
    }
}
