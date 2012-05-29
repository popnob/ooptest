// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, EnumOptions, GuiSmallButton, 
//            GameSettings, GuiSlider, GuiButton, ScaledResolution, 
//            StatCollector

public class GuiVideoSettings extends GuiScreen
{

    private GuiScreen field_22110_h;
    protected String field_22107_a;
    private GameSettings field_22109_i;
    private boolean field_40231_d;
    private static EnumOptions field_22108_k[];

    public GuiVideoSettings(GuiScreen p_i404_1_, GameSettings p_i404_2_)
    {
        field_22107_a = "Video Settings";
        field_40231_d = false;
        field_22110_h = p_i404_1_;
        field_22109_i = p_i404_2_;
    }

    public void func_6448_a()
    {
        StringTranslate stringtranslate = StringTranslate.func_20162_a();
        field_22107_a = stringtranslate.func_20163_a("options.videoTitle");
        int i = 0;
        Object aobj[] = field_22108_k;
        int j = aobj.length;
        for(int k = 0; k < j; k++)
        {
            EnumOptions enumoptions = aobj[k];
            if(!enumoptions.func_20136_a())
            {
                field_949_e.add(new GuiSmallButton(enumoptions.func_20135_c(), (field_951_c / 2 - 155) + (i % 2) * 160, field_950_d / 6 + 24 * (i >> 1), enumoptions, field_22109_i.func_1043_a(enumoptions)));
            } else
            {
                field_949_e.add(new GuiSlider(enumoptions.func_20135_c(), (field_951_c / 2 - 155) + (i % 2) * 160, field_950_d / 6 + 24 * (i >> 1), enumoptions, field_22109_i.func_1043_a(enumoptions), field_22109_i.func_20104_a(enumoptions)));
            }
            i++;
        }

        field_949_e.add(new GuiButton(200, field_951_c / 2 - 100, field_950_d / 6 + 168, stringtranslate.func_20163_a("gui.done")));
        field_40231_d = false;
        aobj = (new String[] {
            "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"
        });
        String as[] = ((String []) (aobj));
        int l = as.length;
        int i1 = 0;
        do
        {
            if(i1 >= l)
            {
                break;
            }
            String s = as[i1];
            String s1 = System.getProperty(s);
            if(s1 != null && s1.indexOf("64") >= 0)
            {
                field_40231_d = true;
                break;
            }
            i1++;
        } while(true);
    }

    protected void func_572_a(GuiButton p_572_1_)
    {
        if(!p_572_1_.field_937_g)
        {
            return;
        }
        int i = field_22109_i.field_25148_H;
        if(p_572_1_.field_938_f < 100 && (p_572_1_ instanceof GuiSmallButton))
        {
            field_22109_i.func_1045_b(((GuiSmallButton)p_572_1_).func_20078_a(), 1);
            p_572_1_.field_939_e = field_22109_i.func_1043_a(EnumOptions.func_20137_a(p_572_1_.field_938_f));
        }
        if(p_572_1_.field_938_f == 200)
        {
            field_945_b.field_6304_y.func_1041_b();
            field_945_b.func_6272_a(field_22110_h);
        }
        if(field_22109_i.field_25148_H != i)
        {
            ScaledResolution scaledresolution = new ScaledResolution(field_945_b.field_6304_y, field_945_b.field_6326_c, field_945_b.field_6325_d);
            int j = scaledresolution.func_903_a();
            int k = scaledresolution.func_902_b();
            func_6447_a(field_945_b, j, k);
        }
    }

    public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_)
    {
        func_578_i();
        func_548_a(field_6451_g, field_22107_a, field_951_c / 2, 20, 0xffffff);
        if(!field_40231_d && field_22109_i.field_1580_e == 0)
        {
            func_548_a(field_6451_g, StatCollector.func_25200_a("options.farWarning1"), field_951_c / 2, field_950_d / 6 + 144, 0xaf0000);
            func_548_a(field_6451_g, StatCollector.func_25200_a("options.farWarning2"), field_951_c / 2, field_950_d / 6 + 144 + 12, 0xaf0000);
        }
        super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
    }

    static 
    {
        field_22108_k = (new EnumOptions[] {
            EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL, EnumOptions.GAMMA, EnumOptions.RENDER_CLOUDS, 
            EnumOptions.PARTICLES
        });
    }
}
