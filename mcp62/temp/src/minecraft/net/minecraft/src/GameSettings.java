// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            KeyBinding, StringTranslate, StatCollector, EnumOptions, 
//            SoundManager, RenderGlobal, RenderEngine, EnumOptionsMappingHelper

public class GameSettings
{

    private static final String field_20105_z[] = {
        "options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"
    };
    private static final String field_20106_A[] = {
        "options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"
    };
    private static final String field_25147_K[] = {
        "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"
    };
    private static final String field_41086_T[] = {
        "options.particles.all", "options.particles.decreased", "options.particles.minimal"
    };
    private static final String field_30006_M[] = {
        "performance.max", "performance.balanced", "performance.powersaver"
    };
    public float field_1584_a;
    public float field_1583_b;
    public float field_1582_c;
    public boolean field_1581_d;
    public int field_1580_e;
    public boolean field_1579_f;
    public boolean field_1578_g;
    public boolean field_27342_h;
    public int field_1577_h;
    public boolean field_1576_i;
    public boolean field_22278_j;
    public boolean field_40445_l;
    public String field_6524_j;
    public KeyBinding field_1575_j;
    public KeyBinding field_1574_k;
    public KeyBinding field_1573_l;
    public KeyBinding field_1572_m;
    public KeyBinding field_1571_n;
    public KeyBinding field_1570_o;
    public KeyBinding field_6523_q;
    public KeyBinding field_6521_r;
    public KeyBinding field_1565_s;
    public KeyBinding field_35382_v;
    public KeyBinding field_35381_w;
    public KeyBinding field_35384_x;
    public KeyBinding field_35383_y;
    public KeyBinding field_1564_t[];
    protected Minecraft field_1563_u;
    private File field_6522_B;
    public int field_1561_w;
    public boolean field_22277_y;
    public int field_1560_x;
    public boolean field_22276_A;
    public boolean field_50119_G;
    public String field_12259_z;
    public boolean field_22275_C;
    public boolean field_22274_D;
    public boolean field_22273_E;
    public float field_22272_F;
    public float field_22271_G;
    public float field_35379_L;
    public float field_35380_M;
    public int field_25148_H;
    public int field_41087_P;
    public String field_44018_Q;

    public GameSettings(Minecraft p_i365_1_, File p_i365_2_)
    {
        field_1584_a = 1.0F;
        field_1583_b = 1.0F;
        field_1582_c = 0.5F;
        field_1581_d = false;
        field_1580_e = 0;
        field_1579_f = true;
        field_1578_g = false;
        field_27342_h = false;
        field_1577_h = 1;
        field_1576_i = true;
        field_22278_j = true;
        field_40445_l = true;
        field_6524_j = "Default";
        field_1575_j = new KeyBinding("key.forward", 17);
        field_1574_k = new KeyBinding("key.left", 30);
        field_1573_l = new KeyBinding("key.back", 31);
        field_1572_m = new KeyBinding("key.right", 32);
        field_1571_n = new KeyBinding("key.jump", 57);
        field_1570_o = new KeyBinding("key.inventory", 18);
        field_6523_q = new KeyBinding("key.drop", 16);
        field_6521_r = new KeyBinding("key.chat", 20);
        field_1565_s = new KeyBinding("key.sneak", 42);
        field_35382_v = new KeyBinding("key.attack", -100);
        field_35381_w = new KeyBinding("key.use", -99);
        field_35384_x = new KeyBinding("key.playerlist", 15);
        field_35383_y = new KeyBinding("key.pickItem", -98);
        field_1564_t = (new KeyBinding[] {
            field_35382_v, field_35381_w, field_1575_j, field_1574_k, field_1573_l, field_1572_m, field_1571_n, field_1565_s, field_6523_q, field_1570_o, 
            field_6521_r, field_35384_x, field_35383_y
        });
        field_1561_w = 2;
        field_22277_y = false;
        field_1560_x = 0;
        field_22276_A = false;
        field_50119_G = false;
        field_12259_z = "";
        field_22275_C = false;
        field_22274_D = false;
        field_22273_E = false;
        field_22272_F = 1.0F;
        field_22271_G = 1.0F;
        field_35379_L = 0.0F;
        field_35380_M = 0.0F;
        field_25148_H = 0;
        field_41087_P = 0;
        field_44018_Q = "en_US";
        field_1563_u = p_i365_1_;
        field_6522_B = new File(p_i365_2_, "options.txt");
        func_6519_a();
    }

    public GameSettings()
    {
        field_1584_a = 1.0F;
        field_1583_b = 1.0F;
        field_1582_c = 0.5F;
        field_1581_d = false;
        field_1580_e = 0;
        field_1579_f = true;
        field_1578_g = false;
        field_27342_h = false;
        field_1577_h = 1;
        field_1576_i = true;
        field_22278_j = true;
        field_40445_l = true;
        field_6524_j = "Default";
        field_1575_j = new KeyBinding("key.forward", 17);
        field_1574_k = new KeyBinding("key.left", 30);
        field_1573_l = new KeyBinding("key.back", 31);
        field_1572_m = new KeyBinding("key.right", 32);
        field_1571_n = new KeyBinding("key.jump", 57);
        field_1570_o = new KeyBinding("key.inventory", 18);
        field_6523_q = new KeyBinding("key.drop", 16);
        field_6521_r = new KeyBinding("key.chat", 20);
        field_1565_s = new KeyBinding("key.sneak", 42);
        field_35382_v = new KeyBinding("key.attack", -100);
        field_35381_w = new KeyBinding("key.use", -99);
        field_35384_x = new KeyBinding("key.playerlist", 15);
        field_35383_y = new KeyBinding("key.pickItem", -98);
        field_1564_t = (new KeyBinding[] {
            field_35382_v, field_35381_w, field_1575_j, field_1574_k, field_1573_l, field_1572_m, field_1571_n, field_1565_s, field_6523_q, field_1570_o, 
            field_6521_r, field_35384_x, field_35383_y
        });
        field_1561_w = 2;
        field_22277_y = false;
        field_1560_x = 0;
        field_22276_A = false;
        field_50119_G = false;
        field_12259_z = "";
        field_22275_C = false;
        field_22274_D = false;
        field_22273_E = false;
        field_22272_F = 1.0F;
        field_22271_G = 1.0F;
        field_35379_L = 0.0F;
        field_35380_M = 0.0F;
        field_25148_H = 0;
        field_41087_P = 0;
        field_44018_Q = "en_US";
    }

    public String func_20102_a(int p_20102_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        return stringtranslate.func_20163_a(field_1564_t[p_20102_1_].field_1371_a);
    }

    public String func_1047_d(int p_1047_1_)
    {
        int i = field_1564_t[p_1047_1_].field_1370_b;
        return func_41085_c(i);
    }

    public static String func_41085_c(int p_41085_0_)
    {
        if(p_41085_0_ < 0)
        {
            return StatCollector.func_25199_a("key.mouseButton", new Object[] {
                Integer.valueOf(p_41085_0_ + 101)
            });
        } else
        {
            return Keyboard.getKeyName(p_41085_0_);
        }
    }

    public void func_1042_a(int p_1042_1_, int p_1042_2_)
    {
        field_1564_t[p_1042_1_].field_1370_b = p_1042_2_;
        func_1041_b();
    }

    public void func_1048_a(EnumOptions p_1048_1_, float p_1048_2_)
    {
        if(p_1048_1_ == EnumOptions.MUSIC)
        {
            field_1584_a = p_1048_2_;
            field_1563_u.field_6301_A.func_335_a();
        }
        if(p_1048_1_ == EnumOptions.SOUND)
        {
            field_1583_b = p_1048_2_;
            field_1563_u.field_6301_A.func_335_a();
        }
        if(p_1048_1_ == EnumOptions.SENSITIVITY)
        {
            field_1582_c = p_1048_2_;
        }
        if(p_1048_1_ == EnumOptions.FOV)
        {
            field_35379_L = p_1048_2_;
        }
        if(p_1048_1_ == EnumOptions.GAMMA)
        {
            field_35380_M = p_1048_2_;
        }
    }

    public void func_1045_b(EnumOptions p_1045_1_, int p_1045_2_)
    {
        if(p_1045_1_ == EnumOptions.INVERT_MOUSE)
        {
            field_1581_d = !field_1581_d;
        }
        if(p_1045_1_ == EnumOptions.RENDER_DISTANCE)
        {
            field_1580_e = field_1580_e + p_1045_2_ & 3;
        }
        if(p_1045_1_ == EnumOptions.GUI_SCALE)
        {
            field_25148_H = field_25148_H + p_1045_2_ & 3;
        }
        if(p_1045_1_ == EnumOptions.PARTICLES)
        {
            field_41087_P = (field_41087_P + p_1045_2_) % 3;
        }
        if(p_1045_1_ == EnumOptions.VIEW_BOBBING)
        {
            field_1579_f = !field_1579_f;
        }
        if(p_1045_1_ == EnumOptions.RENDER_CLOUDS)
        {
            field_40445_l = !field_40445_l;
        }
        if(p_1045_1_ == EnumOptions.ADVANCED_OPENGL)
        {
            field_27342_h = !field_27342_h;
            field_1563_u.field_6323_f.func_958_a();
        }
        if(p_1045_1_ == EnumOptions.ANAGLYPH)
        {
            field_1578_g = !field_1578_g;
            field_1563_u.field_6315_n.func_1065_b();
        }
        if(p_1045_1_ == EnumOptions.FRAMERATE_LIMIT)
        {
            field_1577_h = (field_1577_h + p_1045_2_ + 3) % 3;
        }
        if(p_1045_1_ == EnumOptions.DIFFICULTY)
        {
            field_1561_w = field_1561_w + p_1045_2_ & 3;
        }
        if(p_1045_1_ == EnumOptions.GRAPHICS)
        {
            field_1576_i = !field_1576_i;
            field_1563_u.field_6323_f.func_958_a();
        }
        if(p_1045_1_ == EnumOptions.AMBIENT_OCCLUSION)
        {
            field_22278_j = !field_22278_j;
            field_1563_u.field_6323_f.func_958_a();
        }
        func_1041_b();
    }

    public float func_20104_a(EnumOptions p_20104_1_)
    {
        if(p_20104_1_ == EnumOptions.FOV)
        {
            return field_35379_L;
        }
        if(p_20104_1_ == EnumOptions.GAMMA)
        {
            return field_35380_M;
        }
        if(p_20104_1_ == EnumOptions.MUSIC)
        {
            return field_1584_a;
        }
        if(p_20104_1_ == EnumOptions.SOUND)
        {
            return field_1583_b;
        }
        if(p_20104_1_ == EnumOptions.SENSITIVITY)
        {
            return field_1582_c;
        } else
        {
            return 0.0F;
        }
    }

    public boolean func_20103_b(EnumOptions p_20103_1_)
    {
        switch(EnumOptionsMappingHelper.field_20155_a[p_20103_1_.ordinal()])
        {
        case 1: // '\001'
            return field_1581_d;

        case 2: // '\002'
            return field_1579_f;

        case 3: // '\003'
            return field_1578_g;

        case 4: // '\004'
            return field_27342_h;

        case 5: // '\005'
            return field_22278_j;

        case 6: // '\006'
            return field_40445_l;
        }
        return false;
    }

    private static String func_48571_a(String p_48571_0_[], int p_48571_1_)
    {
        if(p_48571_1_ < 0 || p_48571_1_ >= p_48571_0_.length)
        {
            p_48571_1_ = 0;
        }
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        return stringtranslate.func_20163_a(p_48571_0_[p_48571_1_]);
    }

    public String func_1043_a(EnumOptions p_1043_1_)
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        String s = (new StringBuilder()).append(stringtranslate.func_20163_a(p_1043_1_.func_20138_d())).append(": ").toString();
        if(p_1043_1_.func_20136_a())
        {
            float f = func_20104_a(p_1043_1_);
            if(p_1043_1_ == EnumOptions.SENSITIVITY)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.sensitivity.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.sensitivity.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(f * 200F)).append("%").toString();
                }
            }
            if(p_1043_1_ == EnumOptions.FOV)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.fov.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.fov.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(70F + f * 40F)).toString();
                }
            }
            if(p_1043_1_ == EnumOptions.GAMMA)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.gamma.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.gamma.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append("+").append((int)(f * 100F)).append("%").toString();
                }
            }
            if(f == 0.0F)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.off")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append((int)(f * 100F)).append("%").toString();
            }
        }
        if(p_1043_1_.func_20140_b())
        {
            boolean flag = func_20103_b(p_1043_1_);
            if(flag)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.on")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.off")).toString();
            }
        }
        if(p_1043_1_ == EnumOptions.RENDER_DISTANCE)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_20105_z, field_1580_e)).toString();
        }
        if(p_1043_1_ == EnumOptions.DIFFICULTY)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_20106_A, field_1561_w)).toString();
        }
        if(p_1043_1_ == EnumOptions.GUI_SCALE)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_25147_K, field_25148_H)).toString();
        }
        if(p_1043_1_ == EnumOptions.PARTICLES)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_41086_T, field_41087_P)).toString();
        }
        if(p_1043_1_ == EnumOptions.FRAMERATE_LIMIT)
        {
            return (new StringBuilder()).append(s).append(func_48571_a(field_30006_M, field_1577_h)).toString();
        }
        if(p_1043_1_ == EnumOptions.GRAPHICS)
        {
            if(field_1576_i)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.graphics.fancy")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.func_20163_a("options.graphics.fast")).toString();
            }
        } else
        {
            return s;
        }
    }

    public void func_6519_a()
    {
        try
        {
            if(!field_6522_B.exists())
            {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_6522_B));
            for(String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                try
                {
                    String as[] = s.split(":");
                    if(as[0].equals("music"))
                    {
                        field_1584_a = func_1050_a(as[1]);
                    }
                    if(as[0].equals("sound"))
                    {
                        field_1583_b = func_1050_a(as[1]);
                    }
                    if(as[0].equals("mouseSensitivity"))
                    {
                        field_1582_c = func_1050_a(as[1]);
                    }
                    if(as[0].equals("fov"))
                    {
                        field_35379_L = func_1050_a(as[1]);
                    }
                    if(as[0].equals("gamma"))
                    {
                        field_35380_M = func_1050_a(as[1]);
                    }
                    if(as[0].equals("invertYMouse"))
                    {
                        field_1581_d = as[1].equals("true");
                    }
                    if(as[0].equals("viewDistance"))
                    {
                        field_1580_e = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("guiScale"))
                    {
                        field_25148_H = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("particles"))
                    {
                        field_41087_P = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("bobView"))
                    {
                        field_1579_f = as[1].equals("true");
                    }
                    if(as[0].equals("anaglyph3d"))
                    {
                        field_1578_g = as[1].equals("true");
                    }
                    if(as[0].equals("advancedOpengl"))
                    {
                        field_27342_h = as[1].equals("true");
                    }
                    if(as[0].equals("fpsLimit"))
                    {
                        field_1577_h = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("difficulty"))
                    {
                        field_1561_w = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("fancyGraphics"))
                    {
                        field_1576_i = as[1].equals("true");
                    }
                    if(as[0].equals("ao"))
                    {
                        field_22278_j = as[1].equals("true");
                    }
                    if(as[0].equals("clouds"))
                    {
                        field_40445_l = as[1].equals("true");
                    }
                    if(as[0].equals("skin"))
                    {
                        field_6524_j = as[1];
                    }
                    if(as[0].equals("lastServer") && as.length >= 2)
                    {
                        field_12259_z = as[1];
                    }
                    if(as[0].equals("lang") && as.length >= 2)
                    {
                        field_44018_Q = as[1];
                    }
                    int i = 0;
                    while(i < field_1564_t.length) 
                    {
                        if(as[0].equals((new StringBuilder()).append("key_").append(field_1564_t[i].field_1371_a).toString()))
                        {
                            field_1564_t[i].field_1370_b = Integer.parseInt(as[1]);
                        }
                        i++;
                    }
                }
                catch(Exception exception1)
                {
                    System.out.println((new StringBuilder()).append("Skipping bad option: ").append(s).toString());
                }
            }

            KeyBinding.func_35961_b();
            bufferedreader.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    private float func_1050_a(String p_1050_1_)
    {
        if(p_1050_1_.equals("true"))
        {
            return 1.0F;
        }
        if(p_1050_1_.equals("false"))
        {
            return 0.0F;
        } else
        {
            return Float.parseFloat(p_1050_1_);
        }
    }

    public void func_1041_b()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_6522_B));
            printwriter.println((new StringBuilder()).append("music:").append(field_1584_a).toString());
            printwriter.println((new StringBuilder()).append("sound:").append(field_1583_b).toString());
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(field_1581_d).toString());
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(field_1582_c).toString());
            printwriter.println((new StringBuilder()).append("fov:").append(field_35379_L).toString());
            printwriter.println((new StringBuilder()).append("gamma:").append(field_35380_M).toString());
            printwriter.println((new StringBuilder()).append("viewDistance:").append(field_1580_e).toString());
            printwriter.println((new StringBuilder()).append("guiScale:").append(field_25148_H).toString());
            printwriter.println((new StringBuilder()).append("particles:").append(field_41087_P).toString());
            printwriter.println((new StringBuilder()).append("bobView:").append(field_1579_f).toString());
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(field_1578_g).toString());
            printwriter.println((new StringBuilder()).append("advancedOpengl:").append(field_27342_h).toString());
            printwriter.println((new StringBuilder()).append("fpsLimit:").append(field_1577_h).toString());
            printwriter.println((new StringBuilder()).append("difficulty:").append(field_1561_w).toString());
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(field_1576_i).toString());
            printwriter.println((new StringBuilder()).append("ao:").append(field_22278_j).toString());
            printwriter.println((new StringBuilder()).append("clouds:").append(field_40445_l).toString());
            printwriter.println((new StringBuilder()).append("skin:").append(field_6524_j).toString());
            printwriter.println((new StringBuilder()).append("lastServer:").append(field_12259_z).toString());
            printwriter.println((new StringBuilder()).append("lang:").append(field_44018_Q).toString());
            for(int i = 0; i < field_1564_t.length; i++)
            {
                printwriter.println((new StringBuilder()).append("key_").append(field_1564_t[i].field_1371_a).append(":").append(field_1564_t[i].field_1370_b).toString());
            }

            printwriter.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }

    public boolean func_40444_c()
    {
        return field_1580_e < 2 && field_40445_l;
    }

}
