// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderEngine, GameSettings, ChatAllowedCharacters, Tessellator

public class FontRenderer
{

    private static final Pattern field_52015_r = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    private int field_1307_b[];
    public int field_1308_a;
    public int field_41063_b;
    public Random field_41064_c;
    private byte field_44036_e[];
    private final int field_44034_f[];
    private int field_44035_g[];
    private int field_44038_h;
    private final RenderEngine field_44039_i;
    private float field_46126_j;
    private float field_46127_k;
    private boolean field_44037_j;
    private boolean field_46125_m;
    private float field_50115_n;
    private float field_50116_o;
    private float field_50118_p;
    private float field_50117_q;

    FontRenderer()
    {
        field_1307_b = new int[256];
        field_1308_a = 0;
        field_41063_b = 8;
        field_41064_c = new Random();
        field_44036_e = new byte[0x10000];
        field_44034_f = new int[256];
        field_44035_g = new int[32];
        field_44039_i = null;
    }

    public FontRenderer(GameSettings p_i476_1_, String p_i476_2_, RenderEngine p_i476_3_, boolean p_i476_4_)
    {
        field_1307_b = new int[256];
        field_1308_a = 0;
        field_41063_b = 8;
        field_41064_c = new Random();
        field_44036_e = new byte[0x10000];
        field_44034_f = new int[256];
        field_44035_g = new int[32];
        field_44039_i = p_i476_3_;
        field_44037_j = p_i476_4_;
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = ImageIO.read((net.minecraft.src.RenderEngine.class).getResourceAsStream(p_i476_2_));
            InputStream inputstream = (net.minecraft.src.RenderEngine.class).getResourceAsStream("/font/glyph_sizes.bin");
            inputstream.read(field_44036_e);
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int ai[] = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
        for(int k = 0; k < 256; k++)
        {
            int i1 = k % 16;
            int k1 = k / 16;
            int i2 = 7;
            do
            {
                if(i2 < 0)
                {
                    break;
                }
                int k2 = i1 * 8 + i2;
                boolean flag = true;
                for(int j3 = 0; j3 < 8 && flag; j3++)
                {
                    int l3 = (k1 * 8 + j3) * i;
                    int j4 = ai[k2 + l3] & 0xff;
                    if(j4 > 0)
                    {
                        flag = false;
                    }
                }

                if(!flag)
                {
                    break;
                }
                i2--;
            } while(true);
            if(k == 32)
            {
                i2 = 2;
            }
            field_1307_b[k] = i2 + 2;
        }

        field_1308_a = p_i476_3_.func_1074_a(bufferedimage);
        for(int l = 0; l < 32; l++)
        {
            int j1 = (l >> 3 & 1) * 85;
            int l1 = (l >> 2 & 1) * 170 + j1;
            int j2 = (l >> 1 & 1) * 170 + j1;
            int l2 = (l >> 0 & 1) * 170 + j1;
            if(l == 6)
            {
                l1 += 85;
            }
            if(p_i476_1_.field_1578_g)
            {
                int i3 = (l1 * 30 + j2 * 59 + l2 * 11) / 100;
                int k3 = (l1 * 30 + j2 * 70) / 100;
                int i4 = (l1 * 30 + l2 * 70) / 100;
                l1 = i3;
                j2 = k3;
                l2 = i4;
            }
            if(l >= 16)
            {
                l1 /= 4;
                j2 /= 4;
                l2 /= 4;
            }
            field_44035_g[l] = (l1 & 0xff) << 16 | (j2 & 0xff) << 8 | l2 & 0xff;
        }

    }

    private float func_50112_a(int p_50112_1_, char p_50112_2_, boolean p_50112_3_)
    {
        if(p_50112_2_ == ' ')
        {
            return 4F;
        }
        if(p_50112_1_ > 0 && !field_44037_j)
        {
            return func_50106_a(p_50112_1_ + 32, p_50112_3_);
        } else
        {
            return func_50111_a(p_50112_2_, p_50112_3_);
        }
    }

    private float func_50106_a(int p_50106_1_, boolean p_50106_2_)
    {
        float f = (p_50106_1_ % 16) * 8;
        float f1 = (p_50106_1_ / 16) * 8;
        float f2 = p_50106_2_ ? 1.0F : 0.0F;
        if(field_44038_h != field_1308_a)
        {
            GL11.glBindTexture(3553, field_1308_a);
            field_44038_h = field_1308_a;
        }
        float f3 = (float)field_1307_b[p_50106_1_] - 0.01F;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f / 128F, f1 / 128F);
        GL11.glVertex3f(field_46126_j + f2, field_46127_k, 0.0F);
        GL11.glTexCoord2f(f / 128F, (f1 + 7.99F) / 128F);
        GL11.glVertex3f(field_46126_j - f2, field_46127_k + 7.99F, 0.0F);
        GL11.glTexCoord2f((f + f3) / 128F, f1 / 128F);
        GL11.glVertex3f(field_46126_j + f3 + f2, field_46127_k, 0.0F);
        GL11.glTexCoord2f((f + f3) / 128F, (f1 + 7.99F) / 128F);
        GL11.glVertex3f((field_46126_j + f3) - f2, field_46127_k + 7.99F, 0.0F);
        GL11.glEnd();
        return (float)field_1307_b[p_50106_1_];
    }

    private void func_44030_b(int p_44030_1_)
    {
        String s = String.format("/font/glyph_%02X.png", new Object[] {
            Integer.valueOf(p_44030_1_)
        });
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = ImageIO.read((net.minecraft.src.RenderEngine.class).getResourceAsStream(s));
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        field_44034_f[p_44030_1_] = field_44039_i.func_1074_a(bufferedimage);
        field_44038_h = field_44034_f[p_44030_1_];
    }

    private float func_50111_a(char p_50111_1_, boolean p_50111_2_)
    {
        if(field_44036_e[p_50111_1_] == 0)
        {
            return 0.0F;
        }
        int i = p_50111_1_ / 256;
        if(field_44034_f[i] == 0)
        {
            func_44030_b(i);
        }
        if(field_44038_h != field_44034_f[i])
        {
            GL11.glBindTexture(3553, field_44034_f[i]);
            field_44038_h = field_44034_f[i];
        }
        int j = field_44036_e[p_50111_1_] >>> 4;
        int k = field_44036_e[p_50111_1_] & 0xf;
        float f = j;
        float f1 = k + 1;
        float f2 = (float)((p_50111_1_ % 16) * 16) + f;
        float f3 = ((p_50111_1_ & 0xff) / 16) * 16;
        float f4 = f1 - f - 0.02F;
        float f5 = p_50111_2_ ? 1.0F : 0.0F;
        GL11.glBegin(5);
        GL11.glTexCoord2f(f2 / 256F, f3 / 256F);
        GL11.glVertex3f(field_46126_j + f5, field_46127_k, 0.0F);
        GL11.glTexCoord2f(f2 / 256F, (f3 + 15.98F) / 256F);
        GL11.glVertex3f(field_46126_j - f5, field_46127_k + 7.99F, 0.0F);
        GL11.glTexCoord2f((f2 + f4) / 256F, f3 / 256F);
        GL11.glVertex3f(field_46126_j + f4 / 2.0F + f5, field_46127_k, 0.0F);
        GL11.glTexCoord2f((f2 + f4) / 256F, (f3 + 15.98F) / 256F);
        GL11.glVertex3f((field_46126_j + f4 / 2.0F) - f5, field_46127_k + 7.99F, 0.0F);
        GL11.glEnd();
        return (f1 - f) / 2.0F + 1.0F;
    }

    public int func_50103_a(String p_50103_1_, int p_50103_2_, int p_50103_3_, int p_50103_4_)
    {
        if(field_46125_m)
        {
            p_50103_1_ = func_46121_b(p_50103_1_);
        }
        int i = func_50101_a(p_50103_1_, p_50103_2_ + 1, p_50103_3_ + 1, p_50103_4_, true);
        i = Math.max(i, func_50101_a(p_50103_1_, p_50103_2_, p_50103_3_, p_50103_4_, false));
        return i;
    }

    public void func_873_b(String p_873_1_, int p_873_2_, int p_873_3_, int p_873_4_)
    {
        if(field_46125_m)
        {
            p_873_1_ = func_46121_b(p_873_1_);
        }
        func_50101_a(p_873_1_, p_873_2_, p_873_3_, p_873_4_, false);
    }

    private String func_46121_b(String p_46121_1_)
    {
        if(p_46121_1_ == null || !Bidi.requiresBidi(p_46121_1_.toCharArray(), 0, p_46121_1_.length()))
        {
            return p_46121_1_;
        }
        Bidi bidi = new Bidi(p_46121_1_, -2);
        byte abyte0[] = new byte[bidi.getRunCount()];
        String as[] = new String[abyte0.length];
        for(int i = 0; i < abyte0.length; i++)
        {
            int j = bidi.getRunStart(i);
            int k = bidi.getRunLimit(i);
            int i1 = bidi.getRunLevel(i);
            String s = p_46121_1_.substring(j, k);
            abyte0[i] = (byte)i1;
            as[i] = s;
        }

        String as1[] = (String[])as.clone();
        Bidi.reorderVisually(abyte0, 0, as, 0, abyte0.length);
        StringBuilder stringbuilder = new StringBuilder();
label0:
        for(int l = 0; l < as.length; l++)
        {
            byte byte0 = abyte0[l];
            int j1 = 0;
            do
            {
                if(j1 >= as1.length)
                {
                    break;
                }
                if(as1[j1].equals(as[l]))
                {
                    byte0 = abyte0[j1];
                    break;
                }
                j1++;
            } while(true);
            if((byte0 & 1) == 0)
            {
                stringbuilder.append(as[l]);
                continue;
            }
            j1 = as[l].length() - 1;
            do
            {
                if(j1 < 0)
                {
                    continue label0;
                }
                char c = as[l].charAt(j1);
                if(c == '(')
                {
                    c = ')';
                } else
                if(c == ')')
                {
                    c = '(';
                }
                stringbuilder.append(c);
                j1--;
            } while(true);
        }

        return stringbuilder.toString();
    }

    private void func_44029_a(String p_44029_1_, boolean p_44029_2_)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        for(int i = 0; i < p_44029_1_.length(); i++)
        {
            char c = p_44029_1_.charAt(i);
            if(c == '\247' && i + 1 < p_44029_1_.length())
            {
                int j = "0123456789abcdefklmnor".indexOf(p_44029_1_.toLowerCase().charAt(i + 1));
                if(j < 16)
                {
                    flag = false;
                    flag1 = false;
                    flag4 = false;
                    flag3 = false;
                    flag2 = false;
                    if(j < 0 || j > 15)
                    {
                        j = 15;
                    }
                    if(p_44029_2_)
                    {
                        j += 16;
                    }
                    int l = field_44035_g[j];
                    GL11.glColor3f((float)(l >> 16) / 255F, (float)(l >> 8 & 0xff) / 255F, (float)(l & 0xff) / 255F);
                } else
                if(j == 16)
                {
                    flag = true;
                } else
                if(j == 17)
                {
                    flag1 = true;
                } else
                if(j == 18)
                {
                    flag4 = true;
                } else
                if(j == 19)
                {
                    flag3 = true;
                } else
                if(j == 20)
                {
                    flag2 = true;
                } else
                if(j == 21)
                {
                    flag = false;
                    flag1 = false;
                    flag4 = false;
                    flag3 = false;
                    flag2 = false;
                    GL11.glColor4f(field_50115_n, field_50116_o, field_50118_p, field_50117_q);
                }
                i++;
                continue;
            }
            int k = ChatAllowedCharacters.field_20157_a.indexOf(c);
            if(flag && k > 0)
            {
                int i1;
                do
                {
                    i1 = field_41064_c.nextInt(ChatAllowedCharacters.field_20157_a.length());
                } while(field_1307_b[k + 32] != field_1307_b[i1 + 32]);
                k = i1;
            }
            float f = func_50112_a(k, c, flag2);
            if(flag1)
            {
                field_46126_j++;
                func_50112_a(k, c, flag2);
                field_46126_j--;
                f++;
            }
            if(flag4)
            {
                Tessellator tessellator = Tessellator.field_1512_a;
                GL11.glDisable(3553);
                tessellator.func_977_b();
                tessellator.func_991_a(field_46126_j, field_46127_k + (float)(field_41063_b / 2), 0.0D);
                tessellator.func_991_a(field_46126_j + f, field_46127_k + (float)(field_41063_b / 2), 0.0D);
                tessellator.func_991_a(field_46126_j + f, (field_46127_k + (float)(field_41063_b / 2)) - 1.0F, 0.0D);
                tessellator.func_991_a(field_46126_j, (field_46127_k + (float)(field_41063_b / 2)) - 1.0F, 0.0D);
                tessellator.func_982_a();
                GL11.glEnable(3553);
            }
            if(flag3)
            {
                Tessellator tessellator1 = Tessellator.field_1512_a;
                GL11.glDisable(3553);
                tessellator1.func_977_b();
                int j1 = flag3 ? -1 : 0;
                tessellator1.func_991_a(field_46126_j + (float)j1, field_46127_k + (float)field_41063_b, 0.0D);
                tessellator1.func_991_a(field_46126_j + f, field_46127_k + (float)field_41063_b, 0.0D);
                tessellator1.func_991_a(field_46126_j + f, (field_46127_k + (float)field_41063_b) - 1.0F, 0.0D);
                tessellator1.func_991_a(field_46126_j + (float)j1, (field_46127_k + (float)field_41063_b) - 1.0F, 0.0D);
                tessellator1.func_982_a();
                GL11.glEnable(3553);
            }
            field_46126_j += f;
        }

    }

    public int func_50101_a(String p_50101_1_, int p_50101_2_, int p_50101_3_, int p_50101_4_, boolean p_50101_5_)
    {
        if(p_50101_1_ != null)
        {
            field_44038_h = 0;
            if((p_50101_4_ & 0xfc000000) == 0)
            {
                p_50101_4_ |= 0xff000000;
            }
            if(p_50101_5_)
            {
                p_50101_4_ = (p_50101_4_ & 0xfcfcfc) >> 2 | p_50101_4_ & 0xff000000;
            }
            field_50115_n = (float)(p_50101_4_ >> 16 & 0xff) / 255F;
            field_50116_o = (float)(p_50101_4_ >> 8 & 0xff) / 255F;
            field_50118_p = (float)(p_50101_4_ & 0xff) / 255F;
            field_50117_q = (float)(p_50101_4_ >> 24 & 0xff) / 255F;
            GL11.glColor4f(field_50115_n, field_50116_o, field_50118_p, field_50117_q);
            field_46126_j = p_50101_2_;
            field_46127_k = p_50101_3_;
            func_44029_a(p_50101_1_, p_50101_5_);
            return (int)field_46126_j;
        } else
        {
            return 0;
        }
    }

    public int func_871_a(String p_871_1_)
    {
        if(p_871_1_ == null)
        {
            return 0;
        }
        int i = 0;
        boolean flag = false;
        for(int j = 0; j < p_871_1_.length(); j++)
        {
            char c = p_871_1_.charAt(j);
            int k = func_50105_a(c);
            if(k < 0 && j < p_871_1_.length() - 1)
            {
                char c1 = p_871_1_.charAt(++j);
                if(c1 == 'l' || c1 == 'L')
                {
                    flag = true;
                } else
                if(c1 == 'r' || c1 == 'R')
                {
                    flag = false;
                }
                k = func_50105_a(c1);
            }
            i += k;
            if(flag)
            {
                i++;
            }
        }

        return i;
    }

    public int func_50105_a(char p_50105_1_)
    {
        if(p_50105_1_ == '\247')
        {
            return -1;
        }
        int i = ChatAllowedCharacters.field_20157_a.indexOf(p_50105_1_);
        if(i >= 0 && !field_44037_j)
        {
            return field_1307_b[i + 32];
        }
        if(field_44036_e[p_50105_1_] != 0)
        {
            int j = field_44036_e[p_50105_1_] >> 4;
            int k = field_44036_e[p_50105_1_] & 0xf;
            if(k > 7)
            {
                k = 15;
                j = 0;
            }
            return (++k - j) / 2 + 1;
        } else
        {
            return 0;
        }
    }

    public String func_50107_a(String p_50107_1_, int p_50107_2_)
    {
        return func_50104_a(p_50107_1_, p_50107_2_, false);
    }

    public String func_50104_a(String p_50104_1_, int p_50104_2_, boolean p_50104_3_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        int j = p_50104_3_ ? p_50104_1_.length() - 1 : 0;
        byte byte0 = ((byte)(p_50104_3_ ? -1 : 1));
        boolean flag = false;
        boolean flag1 = false;
        for(int k = j; k >= 0 && k < p_50104_1_.length() && i < p_50104_2_; k += byte0)
        {
            char c = p_50104_1_.charAt(k);
            int l = func_50105_a(c);
            if(flag)
            {
                flag = false;
                if(c == 'l' || c == 'L')
                {
                    flag1 = true;
                } else
                if(c == 'r' || c == 'R')
                {
                    flag1 = false;
                }
            } else
            if(l < 0)
            {
                flag = true;
            } else
            {
                i += l;
                if(flag1)
                {
                    i++;
                }
            }
            if(i > p_50104_2_)
            {
                break;
            }
            if(p_50104_3_)
            {
                stringbuilder.insert(0, c);
            } else
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

    public void func_27278_a(String p_27278_1_, int p_27278_2_, int p_27278_3_, int p_27278_4_, int p_27278_5_)
    {
        if(field_46125_m)
        {
            p_27278_1_ = func_46121_b(p_27278_1_);
        }
        func_46124_b(p_27278_1_, p_27278_2_, p_27278_3_, p_27278_4_, p_27278_5_);
    }

    private void func_46124_b(String p_46124_1_, int p_46124_2_, int p_46124_3_, int p_46124_4_, int p_46124_5_)
    {
        func_46122_b(p_46124_1_, p_46124_2_, p_46124_3_, p_46124_4_, p_46124_5_, false);
    }

    private void func_46122_b(String p_46122_1_, int p_46122_2_, int p_46122_3_, int p_46122_4_, int p_46122_5_, boolean p_46122_6_)
    {
        String as[] = p_46122_1_.split("\n");
        if(as.length > 1)
        {
            for(int i = 0; i < as.length; i++)
            {
                func_46124_b(as[i], p_46122_2_, p_46122_3_, p_46122_4_, p_46122_5_);
                p_46122_3_ += func_27277_a(as[i], p_46122_4_);
            }

            return;
        }
        String as1[] = p_46122_1_.split(" ");
        int j = 0;
        String s = "";
        do
        {
            if(j >= as1.length)
            {
                break;
            }
            String s1;
            for(s1 = (new StringBuilder()).append(s).append(as1[j++]).append(" ").toString(); j < as1.length && func_871_a((new StringBuilder()).append(s1).append(as1[j]).toString()) < p_46122_4_; s1 = (new StringBuilder()).append(s1).append(as1[j++]).append(" ").toString()) { }
            int k;
            for(; func_871_a(s1) > p_46122_4_; s1 = (new StringBuilder()).append(s).append(s1.substring(k)).toString())
            {
                for(k = 0; func_871_a(s1.substring(0, k + 1)) <= p_46122_4_; k++) { }
                if(s1.substring(0, k).trim().length() <= 0)
                {
                    continue;
                }
                String s2 = s1.substring(0, k);
                if(s2.lastIndexOf("\247") >= 0)
                {
                    s = (new StringBuilder()).append("\247").append(s2.charAt(s2.lastIndexOf("\247") + 1)).toString();
                }
                func_50101_a(s2, p_46122_2_, p_46122_3_, p_46122_5_, p_46122_6_);
                p_46122_3_ += field_41063_b;
            }

            if(func_871_a(s1.trim()) > 0)
            {
                if(s1.lastIndexOf("\247") >= 0)
                {
                    s = (new StringBuilder()).append("\247").append(s1.charAt(s1.lastIndexOf("\247") + 1)).toString();
                }
                func_50101_a(s1, p_46122_2_, p_46122_3_, p_46122_5_, p_46122_6_);
                p_46122_3_ += field_41063_b;
            }
        } while(true);
    }

    public int func_27277_a(String p_27277_1_, int p_27277_2_)
    {
        String as[] = p_27277_1_.split("\n");
        if(as.length > 1)
        {
            int i = 0;
            for(int j = 0; j < as.length; j++)
            {
                i += func_27277_a(as[j], p_27277_2_);
            }

            return i;
        }
        String as1[] = p_27277_1_.split(" ");
        int k = 0;
        int l = 0;
        do
        {
            if(k >= as1.length)
            {
                break;
            }
            String s;
            for(s = (new StringBuilder()).append(as1[k++]).append(" ").toString(); k < as1.length && func_871_a((new StringBuilder()).append(s).append(as1[k]).toString()) < p_27277_2_; s = (new StringBuilder()).append(s).append(as1[k++]).append(" ").toString()) { }
            int i1;
            for(; func_871_a(s) > p_27277_2_; s = s.substring(i1))
            {
                for(i1 = 0; func_871_a(s.substring(0, i1 + 1)) <= p_27277_2_; i1++) { }
                if(s.substring(0, i1).trim().length() > 0)
                {
                    l += field_41063_b;
                }
            }

            if(s.trim().length() > 0)
            {
                l += field_41063_b;
            }
        } while(true);
        if(l < field_41063_b)
        {
            l += field_41063_b;
        }
        return l;
    }

    public void func_44032_a(boolean p_44032_1_)
    {
        field_44037_j = p_44032_1_;
    }

    public void func_46123_b(boolean p_46123_1_)
    {
        field_46125_m = p_46123_1_;
    }

    public java.util.List func_50108_c(String p_50108_1_, int p_50108_2_)
    {
        return Arrays.asList(func_50113_d(p_50108_1_, p_50108_2_).split("\n"));
    }

    String func_50113_d(String p_50113_1_, int p_50113_2_)
    {
        int i = func_50102_e(p_50113_1_, p_50113_2_);
        if(p_50113_1_.length() <= i)
        {
            return p_50113_1_;
        } else
        {
            String s = p_50113_1_.substring(0, i);
            String s1 = (new StringBuilder()).append(func_50114_c(s)).append(p_50113_1_.substring(i + (p_50113_1_.charAt(i) != ' ' ? 0 : 1))).toString();
            return (new StringBuilder()).append(s).append("\n").append(func_50113_d(s1, p_50113_2_)).toString();
        }
    }

    private int func_50102_e(String p_50102_1_, int p_50102_2_)
    {
        int i = p_50102_1_.length();
        int j = 0;
        int k = 0;
        int l = -1;
        boolean flag = false;
        do
        {
            if(k >= i)
            {
                break;
            }
            char c = p_50102_1_.charAt(k);
            switch(c)
            {
            case 167: 
                if(k != i)
                {
                    char c1 = p_50102_1_.charAt(++k);
                    if(c1 == 'l' || c1 == 'L')
                    {
                        flag = true;
                    } else
                    if(c1 == 'r' || c1 == 'R')
                    {
                        flag = false;
                    }
                }
                break;

            case 32: // ' '
                l = k;
                // fall through

            default:
                j += func_50105_a(c);
                if(flag)
                {
                    j++;
                }
                break;
            }
            if(c == '\n')
            {
                l = ++k;
                break;
            }
            if(j > p_50102_2_)
            {
                break;
            }
            k++;
        } while(true);
        if(k != i && l != -1 && l < k)
        {
            return l;
        } else
        {
            return k;
        }
    }

    private static boolean func_50110_b(char p_50110_0_)
    {
        return p_50110_0_ >= '0' && p_50110_0_ <= '9' || p_50110_0_ >= 'a' && p_50110_0_ <= 'f' || p_50110_0_ >= 'A' && p_50110_0_ <= 'F';
    }

    private static boolean func_50109_c(char p_50109_0_)
    {
        return p_50109_0_ >= 'k' && p_50109_0_ <= 'o' || p_50109_0_ >= 'K' && p_50109_0_ <= 'O' || p_50109_0_ == 'r' || p_50109_0_ == 'R';
    }

    private static String func_50114_c(String p_50114_0_)
    {
        String s = "";
        int i = -1;
        int j = p_50114_0_.length();
        do
        {
            if((i = p_50114_0_.indexOf('\247', i + 1)) == -1)
            {
                break;
            }
            if(i < j - 1)
            {
                char c = p_50114_0_.charAt(i + 1);
                if(func_50110_b(c))
                {
                    s = (new StringBuilder()).append("\247").append(c).toString();
                } else
                if(func_50109_c(c))
                {
                    s = (new StringBuilder()).append(s).append("\247").append(c).toString();
                }
            }
        } while(true);
        return s;
    }

    public static String func_52014_d(String p_52014_0_)
    {
        return field_52015_r.matcher(p_52014_0_).replaceAll("");
    }

}
