// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, GLAllocation, TexturePackList, TexturePackBase, 
//            GameSettings, ThreadDownloadImageData, TextureFX, ImageBuffer

public class RenderEngine
{

    public static boolean field_1609_a = false;
    private HashMap field_6528_b;
    private HashMap field_28151_c;
    private IntHashMap field_1607_c;
    private IntBuffer field_1606_d;
    private ByteBuffer field_1605_e;
    private java.util.List field_1604_f;
    private Map field_1603_g;
    private GameSettings field_1602_h;
    public boolean field_4281_i;
    public boolean field_4280_j;
    private TexturePackList field_6527_k;
    private BufferedImage field_25189_l;
    private int field_48512_n;

    public RenderEngine(TexturePackList p_i754_1_, GameSettings p_i754_2_)
    {
        field_6528_b = new HashMap();
        field_28151_c = new HashMap();
        field_1607_c = new IntHashMap();
        field_1606_d = GLAllocation.func_1125_c(1);
        field_1605_e = GLAllocation.func_1127_b(0x1000000);
        field_1604_f = new ArrayList();
        field_1603_g = new HashMap();
        field_4281_i = false;
        field_4280_j = false;
        field_25189_l = new BufferedImage(64, 64, 2);
        field_48512_n = 16;
        field_6527_k = p_i754_1_;
        field_1602_h = p_i754_2_;
        Graphics g = field_25189_l.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 64, 64);
        g.setColor(Color.BLACK);
        g.drawString("missingtex", 1, 10);
        g.dispose();
    }

    public int[] func_28149_a(String p_28149_1_)
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        int ai[] = (int[])field_28151_c.get(p_28149_1_);
        if(ai != null)
        {
            return ai;
        }
        try
        {
            int ai1[] = null;
            if(p_28149_1_.startsWith("##"))
            {
                ai1 = func_28148_b(func_1069_b(func_6526_a(texturepackbase.func_6481_a(p_28149_1_.substring(2)))));
            } else
            if(p_28149_1_.startsWith("%clamp%"))
            {
                field_4281_i = true;
                ai1 = func_28148_b(func_6526_a(texturepackbase.func_6481_a(p_28149_1_.substring(7))));
                field_4281_i = false;
            } else
            if(p_28149_1_.startsWith("%blur%"))
            {
                field_4280_j = true;
                field_4281_i = true;
                ai1 = func_28148_b(func_6526_a(texturepackbase.func_6481_a(p_28149_1_.substring(6))));
                field_4281_i = false;
                field_4280_j = false;
            } else
            {
                InputStream inputstream = texturepackbase.func_6481_a(p_28149_1_);
                if(inputstream == null)
                {
                    ai1 = func_28148_b(field_25189_l);
                } else
                {
                    ai1 = func_28148_b(func_6526_a(inputstream));
                }
            }
            field_28151_c.put(p_28149_1_, ai1);
            return ai1;
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        int ai2[] = func_28148_b(field_25189_l);
        field_28151_c.put(p_28149_1_, ai2);
        return ai2;
    }

    private int[] func_28148_b(BufferedImage p_28148_1_)
    {
        int i = p_28148_1_.getWidth();
        int j = p_28148_1_.getHeight();
        int ai[] = new int[i * j];
        p_28148_1_.getRGB(0, 0, i, j, ai, 0, i);
        return ai;
    }

    private int[] func_28147_a(BufferedImage p_28147_1_, int p_28147_2_[])
    {
        int i = p_28147_1_.getWidth();
        int j = p_28147_1_.getHeight();
        p_28147_1_.getRGB(0, 0, i, j, p_28147_2_, 0, i);
        return p_28147_2_;
    }

    public int func_1070_a(String p_1070_1_)
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        Integer integer = (Integer)field_6528_b.get(p_1070_1_);
        if(integer != null)
        {
            return integer.intValue();
        }
        try
        {
            field_1606_d.clear();
            GLAllocation.func_1128_a(field_1606_d);
            int i = field_1606_d.get(0);
            if(p_1070_1_.startsWith("##"))
            {
                func_1068_a(func_1069_b(func_6526_a(texturepackbase.func_6481_a(p_1070_1_.substring(2)))), i);
            } else
            if(p_1070_1_.startsWith("%clamp%"))
            {
                field_4281_i = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(p_1070_1_.substring(7))), i);
                field_4281_i = false;
            } else
            if(p_1070_1_.startsWith("%blur%"))
            {
                field_4280_j = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(p_1070_1_.substring(6))), i);
                field_4280_j = false;
            } else
            if(p_1070_1_.startsWith("%blurclamp%"))
            {
                field_4280_j = true;
                field_4281_i = true;
                func_1068_a(func_6526_a(texturepackbase.func_6481_a(p_1070_1_.substring(11))), i);
                field_4280_j = false;
                field_4281_i = false;
            } else
            {
                InputStream inputstream = texturepackbase.func_6481_a(p_1070_1_);
                if(inputstream == null)
                {
                    func_1068_a(field_25189_l, i);
                } else
                {
                    func_1068_a(func_6526_a(inputstream), i);
                }
            }
            field_6528_b.put(p_1070_1_, Integer.valueOf(i));
            return i;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GLAllocation.func_1128_a(field_1606_d);
        int j = field_1606_d.get(0);
        func_1068_a(field_25189_l, j);
        field_6528_b.put(p_1070_1_, Integer.valueOf(j));
        return j;
    }

    private BufferedImage func_1069_b(BufferedImage p_1069_1_)
    {
        int i = p_1069_1_.getWidth() / 16;
        BufferedImage bufferedimage = new BufferedImage(16, p_1069_1_.getHeight() * i, 2);
        Graphics g = bufferedimage.getGraphics();
        for(int j = 0; j < i; j++)
        {
            g.drawImage(p_1069_1_, -j * 16, j * p_1069_1_.getHeight(), null);
        }

        g.dispose();
        return bufferedimage;
    }

    public int func_1074_a(BufferedImage p_1074_1_)
    {
        field_1606_d.clear();
        GLAllocation.func_1128_a(field_1606_d);
        int i = field_1606_d.get(0);
        func_1068_a(p_1074_1_, i);
        field_1607_c.func_1061_a(i, p_1074_1_);
        return i;
    }

    public void func_1068_a(BufferedImage p_1068_1_, int p_1068_2_)
    {
        GL11.glBindTexture(3553, p_1068_2_);
        if(field_1609_a)
        {
            GL11.glTexParameteri(3553, 10241, 9986);
            GL11.glTexParameteri(3553, 10240, 9728);
        } else
        {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
        if(field_4280_j)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_4281_i)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        int i = p_1068_1_.getWidth();
        int j = p_1068_1_.getHeight();
        int ai[] = new int[i * j];
        byte abyte0[] = new byte[i * j * 4];
        p_1068_1_.getRGB(0, 0, i, j, ai, 0, i);
        for(int k = 0; k < ai.length; k++)
        {
            int i1 = ai[k] >> 24 & 0xff;
            int k1 = ai[k] >> 16 & 0xff;
            int i2 = ai[k] >> 8 & 0xff;
            int k2 = ai[k] & 0xff;
            if(field_1602_h != null && field_1602_h.field_1578_g)
            {
                int i3 = (k1 * 30 + i2 * 59 + k2 * 11) / 100;
                int k3 = (k1 * 30 + i2 * 70) / 100;
                int i4 = (k1 * 30 + k2 * 70) / 100;
                k1 = i3;
                i2 = k3;
                k2 = i4;
            }
            abyte0[k * 4 + 0] = (byte)k1;
            abyte0[k * 4 + 1] = (byte)i2;
            abyte0[k * 4 + 2] = (byte)k2;
            abyte0[k * 4 + 3] = (byte)i1;
        }

        field_1605_e.clear();
        field_1605_e.put(abyte0);
        field_1605_e.position(0).limit(abyte0.length);
        GL11.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, field_1605_e);
        if(field_1609_a)
        {
            for(int l = 1; l <= 4; l++)
            {
                int j1 = i >> l - 1;
                int l1 = i >> l;
                int j2 = j >> l;
                for(int l2 = 0; l2 < l1; l2++)
                {
                    for(int j3 = 0; j3 < j2; j3++)
                    {
                        int l3 = field_1605_e.getInt((l2 * 2 + 0 + (j3 * 2 + 0) * j1) * 4);
                        int j4 = field_1605_e.getInt((l2 * 2 + 1 + (j3 * 2 + 0) * j1) * 4);
                        int k4 = field_1605_e.getInt((l2 * 2 + 1 + (j3 * 2 + 1) * j1) * 4);
                        int l4 = field_1605_e.getInt((l2 * 2 + 0 + (j3 * 2 + 1) * j1) * 4);
                        int i5 = func_1077_b(func_1077_b(l3, j4), func_1077_b(k4, l4));
                        field_1605_e.putInt((l2 + j3 * l1) * 4, i5);
                    }

                }

                GL11.glTexImage2D(3553, l, 6408, l1, j2, 0, 6408, 5121, field_1605_e);
            }

        }
    }

    public void func_28150_a(int p_28150_1_[], int p_28150_2_, int p_28150_3_, int p_28150_4_)
    {
        GL11.glBindTexture(3553, p_28150_4_);
        if(field_1609_a)
        {
            GL11.glTexParameteri(3553, 10241, 9986);
            GL11.glTexParameteri(3553, 10240, 9728);
        } else
        {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
        if(field_4280_j)
        {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if(field_4281_i)
        {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else
        {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        byte abyte0[] = new byte[p_28150_2_ * p_28150_3_ * 4];
        for(int i = 0; i < p_28150_1_.length; i++)
        {
            int j = p_28150_1_[i] >> 24 & 0xff;
            int k = p_28150_1_[i] >> 16 & 0xff;
            int l = p_28150_1_[i] >> 8 & 0xff;
            int i1 = p_28150_1_[i] & 0xff;
            if(field_1602_h != null && field_1602_h.field_1578_g)
            {
                int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
                int k1 = (k * 30 + l * 70) / 100;
                int l1 = (k * 30 + i1 * 70) / 100;
                k = j1;
                l = k1;
                i1 = l1;
            }
            abyte0[i * 4 + 0] = (byte)k;
            abyte0[i * 4 + 1] = (byte)l;
            abyte0[i * 4 + 2] = (byte)i1;
            abyte0[i * 4 + 3] = (byte)j;
        }

        field_1605_e.clear();
        field_1605_e.put(abyte0);
        field_1605_e.position(0).limit(abyte0.length);
        GL11.glTexSubImage2D(3553, 0, 0, 0, p_28150_2_, p_28150_3_, 6408, 5121, field_1605_e);
    }

    public void func_1078_a(int p_1078_1_)
    {
        field_1607_c.func_1052_b(p_1078_1_);
        field_1606_d.clear();
        field_1606_d.put(p_1078_1_);
        field_1606_d.flip();
        GL11.glDeleteTextures(field_1606_d);
    }

    public int func_1071_a(String p_1071_1_, String p_1071_2_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(p_1071_1_);
        if(threaddownloadimagedata != null && threaddownloadimagedata.field_1706_a != null && !threaddownloadimagedata.field_1707_d)
        {
            if(threaddownloadimagedata.field_1708_c < 0)
            {
                threaddownloadimagedata.field_1708_c = func_1074_a(threaddownloadimagedata.field_1706_a);
            } else
            {
                func_1068_a(threaddownloadimagedata.field_1706_a, threaddownloadimagedata.field_1708_c);
            }
            threaddownloadimagedata.field_1707_d = true;
        }
        if(threaddownloadimagedata == null || threaddownloadimagedata.field_1708_c < 0)
        {
            if(p_1071_2_ == null)
            {
                return -1;
            } else
            {
                return func_1070_a(p_1071_2_);
            }
        } else
        {
            return threaddownloadimagedata.field_1708_c;
        }
    }

    public ThreadDownloadImageData func_1075_a(String p_1075_1_, ImageBuffer p_1075_2_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(p_1075_1_);
        if(threaddownloadimagedata == null)
        {
            field_1603_g.put(p_1075_1_, new ThreadDownloadImageData(p_1075_1_, p_1075_2_));
        } else
        {
            threaddownloadimagedata.field_1705_b++;
        }
        return threaddownloadimagedata;
    }

    public void func_1073_b(String p_1073_1_)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)field_1603_g.get(p_1073_1_);
        if(threaddownloadimagedata != null)
        {
            threaddownloadimagedata.field_1705_b--;
            if(threaddownloadimagedata.field_1705_b == 0)
            {
                if(threaddownloadimagedata.field_1708_c >= 0)
                {
                    func_1078_a(threaddownloadimagedata.field_1708_c);
                }
                field_1603_g.remove(p_1073_1_);
            }
        }
    }

    public void func_1066_a(TextureFX p_1066_1_)
    {
        field_1604_f.add(p_1066_1_);
        p_1066_1_.func_783_a();
    }

    public void func_1067_a()
    {
        int i = -1;
        for(int j = 0; j < field_1604_f.size(); j++)
        {
            TextureFX texturefx = (TextureFX)field_1604_f.get(j);
            texturefx.field_1131_c = field_1602_h.field_1578_g;
            texturefx.func_783_a();
            field_1605_e.clear();
            field_1605_e.put(texturefx.field_1127_a);
            field_1605_e.position(0).limit(texturefx.field_1127_a.length);
            if(texturefx.field_1126_b != i)
            {
                texturefx.func_782_a(this);
                i = texturefx.field_1126_b;
            }
            for(int k = 0; k < texturefx.field_1129_e; k++)
            {
                for(int l = 0; l < texturefx.field_1129_e; l++)
                {
                    GL11.glTexSubImage2D(3553, 0, (texturefx.field_1126_b % 16) * 16 + k * 16, (texturefx.field_1126_b / 16) * 16 + l * 16, 16, 16, 6408, 5121, field_1605_e);
                }

            }

        }

    }

    private int func_1077_b(int p_1077_1_, int p_1077_2_)
    {
        int i = (p_1077_1_ & 0xff000000) >> 24 & 0xff;
        int j = (p_1077_2_ & 0xff000000) >> 24 & 0xff;
        char c = '\377';
        if(i + j < 255)
        {
            c = '\0';
            i = 1;
            j = 1;
        } else
        if(i > j)
        {
            i = 255;
            j = 1;
        } else
        {
            i = 1;
            j = 255;
        }
        int k = (p_1077_1_ >> 16 & 0xff) * i;
        int l = (p_1077_1_ >> 8 & 0xff) * i;
        int i1 = (p_1077_1_ & 0xff) * i;
        int j1 = (p_1077_2_ >> 16 & 0xff) * j;
        int k1 = (p_1077_2_ >> 8 & 0xff) * j;
        int l1 = (p_1077_2_ & 0xff) * j;
        int i2 = (k + j1) / (i + j);
        int j2 = (l + k1) / (i + j);
        int k2 = (i1 + l1) / (i + j);
        return c << 24 | i2 << 16 | j2 << 8 | k2;
    }

    public void func_1065_b()
    {
        TexturePackBase texturepackbase = field_6527_k.field_6534_a;
        int i;
        BufferedImage bufferedimage;
        for(Iterator iterator = field_1607_c.func_35860_b().iterator(); iterator.hasNext(); func_1068_a(bufferedimage, i))
        {
            i = ((Integer)iterator.next()).intValue();
            bufferedimage = (BufferedImage)field_1607_c.func_1057_a(i);
        }

        for(Iterator iterator1 = field_1603_g.values().iterator(); iterator1.hasNext();)
        {
            ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)iterator1.next();
            threaddownloadimagedata.field_1707_d = false;
        }

        for(Iterator iterator2 = field_6528_b.keySet().iterator(); iterator2.hasNext();)
        {
            String s = (String)iterator2.next();
            try
            {
                BufferedImage bufferedimage1;
                if(s.startsWith("##"))
                {
                    bufferedimage1 = func_1069_b(func_6526_a(texturepackbase.func_6481_a(s.substring(2))));
                } else
                if(s.startsWith("%clamp%"))
                {
                    field_4281_i = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(7)));
                } else
                if(s.startsWith("%blur%"))
                {
                    field_4280_j = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(6)));
                } else
                if(s.startsWith("%blurclamp%"))
                {
                    field_4280_j = true;
                    field_4281_i = true;
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s.substring(11)));
                } else
                {
                    bufferedimage1 = func_6526_a(texturepackbase.func_6481_a(s));
                }
                int j = ((Integer)field_6528_b.get(s)).intValue();
                func_1068_a(bufferedimage1, j);
                field_4280_j = false;
                field_4281_i = false;
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        for(Iterator iterator3 = field_28151_c.keySet().iterator(); iterator3.hasNext();)
        {
            String s1 = (String)iterator3.next();
            try
            {
                BufferedImage bufferedimage2;
                if(s1.startsWith("##"))
                {
                    bufferedimage2 = func_1069_b(func_6526_a(texturepackbase.func_6481_a(s1.substring(2))));
                } else
                if(s1.startsWith("%clamp%"))
                {
                    field_4281_i = true;
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1.substring(7)));
                } else
                if(s1.startsWith("%blur%"))
                {
                    field_4280_j = true;
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1.substring(6)));
                } else
                {
                    bufferedimage2 = func_6526_a(texturepackbase.func_6481_a(s1));
                }
                func_28147_a(bufferedimage2, (int[])field_28151_c.get(s1));
                field_4280_j = false;
                field_4281_i = false;
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }

    }

    private BufferedImage func_6526_a(InputStream p_6526_1_)
        throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(p_6526_1_);
        p_6526_1_.close();
        return bufferedimage;
    }

    public void func_1076_b(int p_1076_1_)
    {
        if(p_1076_1_ < 0)
        {
            return;
        } else
        {
            GL11.glBindTexture(3553, p_1076_1_);
            return;
        }
    }

}
