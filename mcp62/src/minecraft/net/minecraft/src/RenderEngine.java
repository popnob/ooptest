package net.minecraft.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;

public class RenderEngine
{
    /** Use mipmaps for all bound textures (unused at present) */
    public static boolean useMipmaps = true;
    private HashMap textureMap;

    /** Texture contents map (key: texture name, value: int[] contents) */
    private HashMap textureContentsMap;

    /** A mapping from GL texture names (integers) to BufferedImage instances */
    private IntHashMap textureNameToImageMap;

    /** An IntBuffer storing 1 int used as scratch space in RenderEngine */
    private IntBuffer singleIntBuffer;

    /** Stores the image data for the texture. */
    private ByteBuffer imageData;
    private java.util.List textureList;

    /** A mapping from image URLs to ThreadDownloadImageData instances */
    private Map urlToImageDataMap;

    /** Reference to the GameSettings object */
    private GameSettings options;

    /** Flag set when a texture should not be repeated */
    public boolean clampTexture;

    /** Flag set when a texture should use blurry resizing */
    public boolean blurTexture;

    /** Texture pack */
    public TexturePackList texturePack;

    /** Missing texture image */
    private BufferedImage missingTextureImage;
    private int field_48512_n;
    private int terrainTextureId;
    private int guiItemsTextureId;
    private int ctmTextureId;
    private boolean hdTexturesInstalled;
    private Map textureDimensionsMap;
    private Map textureDataMap;
    private int tickCounter;
    private ByteBuffer mipImageDatas[];
    private boolean dynamicTexturesUpdated;
    private Map textureFxMap;
    private Map mipDataBufsMap;
    private boolean singleTileTexture;

    public RenderEngine(TexturePackList par1TexturePackList, GameSettings par2GameSettings)
    {
        terrainTextureId = -1;
        guiItemsTextureId = -1;
        ctmTextureId = -1;
        hdTexturesInstalled = false;
        textureDimensionsMap = new HashMap();
        textureDataMap = new HashMap();
        tickCounter = 0;
        dynamicTexturesUpdated = false;
        textureFxMap = new IdentityHashMap();
        mipDataBufsMap = new HashMap();
        singleTileTexture = false;

        if (Config.isMultiTexture())
        {
            int i = Config.getAntialiasingLevel();
            Config.dbg((new StringBuilder()).append("FSAA Samples: ").append(i).toString());

            try
            {
                Display.destroy();
                Display.create(new PixelFormat(0, 8, 0, i));
            }
            catch (LWJGLException lwjglexception)
            {
                Config.dbg((new StringBuilder()).append("Error setting FSAA: ").append(i).append("x").toString());
                lwjglexception.printStackTrace();

                try
                {
                    Display.create();
                }
                catch (LWJGLException lwjglexception1)
                {
                    lwjglexception1.printStackTrace();
                }
            }
        }

        textureMap = new HashMap();
        textureContentsMap = new HashMap();
        textureNameToImageMap = new IntHashMap();
        singleIntBuffer = GLAllocation.createDirectIntBuffer(1);
        allocateImageData(256);
        textureList = new ArrayList();
        urlToImageDataMap = new HashMap();
        clampTexture = false;
        blurTexture = false;
        missingTextureImage = new BufferedImage(64, 64, 2);
        field_48512_n = 16;
        texturePack = par1TexturePackList;
        options = par2GameSettings;
        Graphics g = missingTextureImage.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 64, 64);
        g.setColor(Color.BLACK);
        g.drawString("missingtex", 1, 10);
        g.dispose();
    }

    public int[] getTextureContents(String par1Str)
    {
        TexturePackBase texturepackbase = texturePack.selectedTexturePack;
        int ai[] = (int[])textureContentsMap.get(par1Str);

        if (ai != null)
        {
            return ai;
        }

        try
        {
            int ai1[] = null;

            if (par1Str.startsWith("##"))
            {
                ai1 = getImageContentsAndAllocate(unwrapImageByColumns(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(2)))));
            }
            else if (par1Str.startsWith("%clamp%"))
            {
                clampTexture = true;
                ai1 = getImageContentsAndAllocate(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(7))));
                clampTexture = false;
            }
            else if (par1Str.startsWith("%blur%"))
            {
                blurTexture = true;
                clampTexture = true;
                ai1 = getImageContentsAndAllocate(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(6))));
                clampTexture = false;
                blurTexture = false;
            }
            else
            {
                InputStream inputstream = texturepackbase.getResourceAsStream(par1Str);

                if (inputstream == null)
                {
                    ai1 = getImageContentsAndAllocate(missingTextureImage);
                }
                else
                {
                    ai1 = getImageContentsAndAllocate(readTextureImage(inputstream));
                }
            }

            textureContentsMap.put(par1Str, ai1);
            return ai1;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }

        int ai2[] = getImageContentsAndAllocate(missingTextureImage);
        textureContentsMap.put(par1Str, ai2);
        return ai2;
    }

    private int[] getImageContentsAndAllocate(BufferedImage par1BufferedImage)
    {
        int i = par1BufferedImage.getWidth();
        int j = par1BufferedImage.getHeight();
        int ai[] = new int[i * j];
        par1BufferedImage.getRGB(0, 0, i, j, ai, 0, i);
        return ai;
    }

    private int[] getImageContents(BufferedImage par1BufferedImage, int par2ArrayOfInteger[])
    {
        int i = par1BufferedImage.getWidth();
        int j = par1BufferedImage.getHeight();
        par1BufferedImage.getRGB(0, 0, i, j, par2ArrayOfInteger, 0, i);
        return par2ArrayOfInteger;
    }

    public int getTexture(String par1Str)
    {
        TexturePackBase texturepackbase = texturePack.selectedTexturePack;
        Integer integer = (Integer)textureMap.get(par1Str);

        if (integer != null)
        {
            return integer.intValue();
        }

        try
        {
            singleIntBuffer.clear();
            GLAllocation.generateTextureNames(singleIntBuffer);

            if (Tessellator.renderingWorldRenderer)
            {
                System.out.printf("Warning: Texture %s not preloaded, will cause render glitches!\n", new Object[]
                        {
                            par1Str
                        });
            }

            int i = singleIntBuffer.get(0);
            Config.dbg((new StringBuilder()).append("setupTexture: \"").append(par1Str).append("\", id: ").append(i).toString());

            if (par1Str.startsWith("##"))
            {
                setupTexture(unwrapImageByColumns(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(2)))), i);
            }
            else if (par1Str.startsWith("%clamp%"))
            {
                clampTexture = true;
                setupTexture(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(7))), i);
                clampTexture = false;
            }
            else if (par1Str.startsWith("%blur%"))
            {
                blurTexture = true;
                setupTexture(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(6))), i);
                blurTexture = false;
            }
            else if (par1Str.startsWith("%blurclamp%"))
            {
                blurTexture = true;
                clampTexture = true;
                setupTexture(readTextureImage(texturepackbase.getResourceAsStream(par1Str.substring(11))), i);
                blurTexture = false;
                clampTexture = false;
            }
            else
            {
                InputStream inputstream = texturepackbase.getResourceAsStream(par1Str);

                if (inputstream == null)
                {
                    setupTexture(missingTextureImage, i);
                }
                else
                {
                    if (par1Str.equals("/terrain.png"))
                    {
                        terrainTextureId = i;
                    }

                    if (par1Str.equals("/gui/items.png"))
                    {
                        guiItemsTextureId = i;
                    }

                    if (par1Str.equals("/ctm.png"))
                    {
                        ctmTextureId = i;
                    }

                    setupTexture(readTextureImage(inputstream), i);
                }
            }

            textureMap.put(par1Str, Integer.valueOf(i));

            if (Reflector.hasClass(1))
            {
                Reflector.callVoid(18, new Object[]
                        {
                            par1Str, Integer.valueOf(i)
                        });
            }

            return i;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        GLAllocation.generateTextureNames(singleIntBuffer);
        int j = singleIntBuffer.get(0);
        setupTexture(missingTextureImage, j);
        textureMap.put(par1Str, Integer.valueOf(j));
        return j;
    }

    /**
     * Takes an image with multiple 16-pixel-wide columns and creates a new 16-pixel-wide image where the columns are
     * stacked vertically
     */
    private BufferedImage unwrapImageByColumns(BufferedImage par1BufferedImage)
    {
        int i = par1BufferedImage.getWidth() / 16;
        BufferedImage bufferedimage = new BufferedImage(16, par1BufferedImage.getHeight() * i, 2);
        Graphics g = bufferedimage.getGraphics();

        for (int j = 0; j < i; j++)
        {
            g.drawImage(par1BufferedImage, -j * 16, j * par1BufferedImage.getHeight(), null);
        }

        g.dispose();
        return bufferedimage;
    }

    /**
     * Copy the supplied image onto a newly-allocated OpenGL texture, returning the allocated texture name
     */
    public int allocateAndSetupTexture(BufferedImage par1BufferedImage)
    {
        singleIntBuffer.clear();
        GLAllocation.generateTextureNames(singleIntBuffer);
        int i = singleIntBuffer.get(0);
        setupTexture(par1BufferedImage, i);
        textureNameToImageMap.addKey(i, par1BufferedImage);
        return i;
    }

    /**
     * Copy the supplied image onto the specified OpenGL texture
     */
    public void setupTexture(BufferedImage par1BufferedImage, int par2)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, par2);
        boolean flag = useMipmaps && Config.isUseMipmaps();

        if (flag && par2 != guiItemsTextureId)
        {
            int i = Config.getMipmapType();
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, i);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

            if (GLContext.getCapabilities().OpenGL12)
            {
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_BASE_LEVEL, 0);
                int k = Config.getMipmapLevel();

                if (k >= 4)
                {
                    int i1 = Math.min(par1BufferedImage.getWidth(), par1BufferedImage.getHeight());
                    k = getMaxMipmapLevel(i1);

                    if (!singleTileTexture)
                    {
                        k -= 4;
                    }

                    if (k < 0)
                    {
                        k = 0;
                    }
                }

                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL12.GL_TEXTURE_MAX_LEVEL, k);
            }

            if (GLContext.getCapabilities().GL_EXT_texture_filter_anisotropic)
            {
                FloatBuffer floatbuffer = BufferUtils.createFloatBuffer(16);
                floatbuffer.rewind();
                GL11.glGetFloat(34047, floatbuffer);
                float f = floatbuffer.get(0);
                float f1 = Config.getAnisotropicFilterLevel();
                f1 = Math.min(f1, f);
                GL11.glTexParameterf(GL11.GL_TEXTURE_2D, 34046, f1);
            }
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        }

        if (blurTexture)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        }

        if (clampTexture)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        }

        int j = par1BufferedImage.getWidth();
        int l = par1BufferedImage.getHeight();
        setTextureDimension(par2, new Dimension(j, l));
        int ai[] = new int[j * l];
        byte abyte0[] = new byte[j * l * 4];
        par1BufferedImage.getRGB(0, 0, j, l, ai, 0, j);
        int ai1[] = null;

        if (flag)
        {
            if (isTerrainTexture(par2))
            {
                ai1 = new int[256];

                for (int j1 = 0; j1 < 16; j1++)
                {
                    for (int l1 = 0; l1 < 16; l1++)
                    {
                        ai1[j1 * 16 + l1] = getAverageOpaqueColor(ai, l1, j1, j, l);
                    }
                }
            }

            if (singleTileTexture)
            {
                ai1 = new int[1];
                ai1[0] = getAverageOpaqueColor(ai);
            }
        }

        for (int k1 = 0; k1 < ai.length; k1++)
        {
            int i2 = ai[k1] >> 24 & 0xff;
            int k2 = ai[k1] >> 16 & 0xff;
            int i3 = ai[k1] >> 8 & 0xff;
            int k3 = ai[k1] & 0xff;

            if (options != null && options.anaglyph)
            {
                int i4 = (k2 * 30 + i3 * 59 + k3 * 11) / 100;
                int l4 = (k2 * 30 + i3 * 70) / 100;
                int k5 = (k2 * 30 + k3 * 70) / 100;
                k2 = i4;
                i3 = l4;
                k3 = k5;
            }

            if (i2 == 0)
            {
                k2 = 0;
                i3 = 0;
                k3 = 0;

                if (isTerrainTexture(par2) || singleTileTexture)
                {
                    k2 = 255;
                    i3 = 255;
                    k3 = 255;

                    if (flag)
                    {
                        int j4 = 0;

                        if (singleTileTexture)
                        {
                            j4 = ai1[0];
                        }
                        else
                        {
                            int i5 = k1 % j;
                            int l5 = k1 / j;
                            int i6 = i5 / (j / 16);
                            int k6 = l5 / (l / 16);
                            j4 = ai1[k6 * 16 + i6];
                        }

                        if (j4 != 0)
                        {
                            k2 = j4 >> 16 & 0xff;
                            i3 = j4 >> 8 & 0xff;
                            k3 = j4 & 0xff;
                        }
                    }
                }
            }

            abyte0[k1 * 4 + 0] = (byte)k2;
            abyte0[k1 * 4 + 1] = (byte)i3;
            abyte0[k1 * 4 + 2] = (byte)k3;
            abyte0[k1 * 4 + 3] = (byte)i2;
        }

        checkImageDataSize(j);
        imageData.clear();
        imageData.put(abyte0);
        imageData.position(0).limit(abyte0.length);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, j, l, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageData);

        if (useMipmaps)
        {
            generateMipMaps(imageData, j, l);
        }

        if (Config.isMultiTexture() && (par2 == terrainTextureId || par2 == guiItemsTextureId))
        {
            int ai2[] = null;

            if (par2 == terrainTextureId)
            {
                ai2 = Tessellator.terrainTextures;
            }

            if (par2 == guiItemsTextureId)
            {
                ai2 = Tessellator.itemTextures;
            }

            int j2 = j / 16;
            int l2 = l / 16;

            for (int j3 = 0; j3 < 16; j3++)
            {
                for (int l3 = 0; l3 < 16; l3++)
                {
                    int k4 = l3 * j2;
                    int j5 = j3 * l2;
                    BufferedImage bufferedimage = par1BufferedImage.getSubimage(k4, j5, j2, l2);
                    int j6 = j3 * 16 + l3;

                    if (ai2[j6] == 0)
                    {
                        singleIntBuffer.clear();
                        GLAllocation.generateTextureNames(singleIntBuffer);
                        ai2[j6] = singleIntBuffer.get(0);
                    }

                    if (par2 == guiItemsTextureId)
                    {
                        clampTexture = true;
                    }
                    else
                    {
                        clampTexture = Config.isTerrainIconClamped(j6);
                    }

                    singleTileTexture = true;
                    setupTexture(bufferedimage, ai2[j6]);
                    singleTileTexture = false;
                }
            }

            clampTexture = false;
        }
    }

    private int getAverageOpaqueIconColor(int ai[], int i, int j, int k, int l)
    {
        return -1;
    }

    private int getAverageOpaqueColor(int ai[])
    {
        long l = 0L;
        long l1 = 0L;
        long l2 = 0L;
        long l3 = 0L;

        for (int i = 0; i < ai.length; i++)
        {
            int j = ai[i];
            int i1 = j >> 24 & 0xff;

            if (i1 != 0)
            {
                int k1 = j >> 16 & 0xff;
                int j2 = j >> 8 & 0xff;
                int k2 = j & 0xff;
                l += k1;
                l1 += j2;
                l2 += k2;
                l3++;
            }
        }

        if (l3 <= 0L)
        {
            return -1;
        }
        else
        {
            char c = '\377';
            int k = (int)(l / l3);
            int j1 = (int)(l1 / l3);
            int i2 = (int)(l2 / l3);
            return c << 24 | k << 16 | j1 << 8 | i2;
        }
    }

    private void fixAlpha(BufferedImage bufferedimage)
    {
        long l = 0L;
        long l1 = 0L;
        long l2 = 0L;
        long l3 = 0L;
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();

        for (int k = 0; k < j; k++)
        {
            for (int j1 = 0; j1 < i; j1++)
            {
                int i2 = bufferedimage.getRGB(j1, k);
                int k2 = i2 >> 24 & 0xff;

                if (k2 != 0)
                {
                    int j3 = i2 >> 16 & 0xff;
                    int i4 = i2 >> 8 & 0xff;
                    int l4 = i2 & 0xff;
                    l += j3;
                    l1 += i4;
                    l2 += l4;
                    l3++;
                }
            }
        }

        if (l3 <= 0L)
        {
            return;
        }

        int i1 = (int)(l / l3);
        int k1 = (int)(l1 / l3);
        int j2 = (int)(l2 / l3);

        for (int i3 = 0; i3 < j; i3++)
        {
            for (int k3 = 0; k3 < i; k3++)
            {
                int j4 = bufferedimage.getRGB(k3, i3);
                int i5 = j4 >> 24 & 0xff;

                if (i5 == 0)
                {
                    int k4 = i5 << 24 | i1 << 16 | k1 << 8 | j2 << 0;
                    bufferedimage.setRGB(k3, i3, k4);
                }
            }
        }
    }

    private int getAverageOpaqueColor(int ai[], int i, int j, int k, int l)
    {
        int i1 = k / 16;
        int j1 = l / 16;
        int k1 = j * j1 * k + i * i1;
        long l1 = 0L;
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;

        for (int i2 = 0; i2 < j1; i2++)
        {
            for (int j2 = 0; j2 < i1; j2++)
            {
                int i3 = k1 + i2 * k + j2;
                int k3 = ai[i3] >> 24 & 0xff;

                if (k3 != 0)
                {
                    int j4 = ai[i3] >> 16 & 0xff;
                    int k4 = ai[i3] >> 8 & 0xff;
                    int i5 = ai[i3] & 0xff;
                    l1 += j4;
                    l2 += k4;
                    l3 += i5;
                    l4++;
                }
            }
        }

        if (l4 <= 0L)
        {
            return 0;
        }
        else
        {
            char c = '\377';
            int k2 = (int)(l1 / l4);
            int j3 = (int)(l2 / l4);
            int i4 = (int)(l3 / l4);
            return c << 24 | k2 << 16 | j3 << 8 | i4;
        }
    }

    private boolean isTerrainTexture(int i)
    {
        if (i == terrainTextureId)
        {
            return true;
        }

        return i == ctmTextureId;
    }

    private void generateMipMaps(ByteBuffer bytebuffer, int i, int j)
    {
        ByteBuffer bytebuffer1 = bytebuffer;
        int k = 1;

        do
        {
            if (k > 16)
            {
                break;
            }

            int l = i >> k - 1;
            int i1 = i >> k;
            int j1 = j >> k;

            if (i1 <= 0 || j1 <= 0)
            {
                break;
            }

            ByteBuffer bytebuffer2 = mipImageDatas[k - 1];
            bytebuffer2.limit(i1 * j1 * 4);

            for (int k1 = 0; k1 < i1; k1++)
            {
                for (int l1 = 0; l1 < j1; l1++)
                {
                    int i2 = bytebuffer1.getInt((k1 * 2 + 0 + (l1 * 2 + 0) * l) * 4);
                    int j2 = bytebuffer1.getInt((k1 * 2 + 1 + (l1 * 2 + 0) * l) * 4);
                    int k2 = bytebuffer1.getInt((k1 * 2 + 1 + (l1 * 2 + 1) * l) * 4);
                    int l2 = bytebuffer1.getInt((k1 * 2 + 0 + (l1 * 2 + 1) * l) * 4);
                    int i3 = alphaBlend(i2, j2, k2, l2);
                    bytebuffer2.putInt((k1 + l1 * i1) * 4, i3);
                }
            }

            bytebuffer2.rewind();
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, k, GL11.GL_RGBA, i1, j1, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, bytebuffer2);
            bytebuffer1 = bytebuffer2;
            k++;
        }
        while (true);
    }

    public void createTextureFromBytes(int par1ArrayOfInteger[], int par2, int par3, int par4)
    {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, par4);

        if (useMipmaps && Config.isUseMipmaps())
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST_MIPMAP_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        }

        if (blurTexture)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        }

        if (clampTexture)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        }

        byte abyte0[] = new byte[par2 * par3 * 4];

        for (int i = 0; i < par1ArrayOfInteger.length; i++)
        {
            int j = par1ArrayOfInteger[i] >> 24 & 0xff;
            int k = par1ArrayOfInteger[i] >> 16 & 0xff;
            int l = par1ArrayOfInteger[i] >> 8 & 0xff;
            int i1 = par1ArrayOfInteger[i] & 0xff;

            if (options != null && options.anaglyph)
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

        imageData.clear();
        imageData.put(abyte0);
        imageData.position(0).limit(abyte0.length);
        GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, par2, par3, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageData);
    }

    /**
     * Deletes a single GL texture
     */
    public void deleteTexture(int par1)
    {
        textureNameToImageMap.removeObject(par1);
        singleIntBuffer.clear();
        singleIntBuffer.put(par1);
        singleIntBuffer.flip();
        GL11.glDeleteTextures(singleIntBuffer);
    }

    /**
     * Takes a URL of a downloadable image and the name of the local image to be used as a fallback.  If the image has
     * been downloaded, returns the GL texture of the downloaded image, otherwise returns the GL texture of the fallback
     * image.
     */
    public int getTextureForDownloadableImage(String par1Str, String par2Str)
    {
        if (Config.isRandomMobs())
        {
            int i = RandomMobs.getTexture(par1Str, par2Str);

            if (i >= 0)
            {
                return i;
            }
        }

        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata != null && threaddownloadimagedata.image != null && !threaddownloadimagedata.textureSetupComplete)
        {
            if (threaddownloadimagedata.textureName < 0)
            {
                threaddownloadimagedata.textureName = allocateAndSetupTexture(threaddownloadimagedata.image);
            }
            else
            {
                setupTexture(threaddownloadimagedata.image, threaddownloadimagedata.textureName);
            }

            threaddownloadimagedata.textureSetupComplete = true;
        }

        if (threaddownloadimagedata == null || threaddownloadimagedata.textureName < 0)
        {
            if (par2Str == null)
            {
                return -1;
            }
            else
            {
                return getTexture(par2Str);
            }
        }
        else
        {
            return threaddownloadimagedata.textureName;
        }
    }

    /**
     * Return a ThreadDownloadImageData instance for the given URL.  If it does not already exist, it is created and
     * uses the passed ImageBuffer.  If it does, its reference count is incremented.
     */
    public ThreadDownloadImageData obtainImageData(String par1Str, ImageBuffer par2ImageBuffer)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata == null)
        {
            urlToImageDataMap.put(par1Str, new ThreadDownloadImageData(par1Str, par2ImageBuffer));
        }
        else
        {
            threaddownloadimagedata.referenceCount++;
        }

        return threaddownloadimagedata;
    }

    /**
     * Decrements the reference count for a given URL, deleting the image data if the reference count hits 0
     */
    public void releaseImageData(String par1Str)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata != null)
        {
            threaddownloadimagedata.referenceCount--;

            if (threaddownloadimagedata.referenceCount == 0)
            {
                if (threaddownloadimagedata.textureName >= 0)
                {
                    deleteTexture(threaddownloadimagedata.textureName);
                }

                urlToImageDataMap.remove(par1Str);
            }
        }
    }

    public void registerTextureFX(TextureFX par1TextureFX)
    {
        int i = getTextureId(par1TextureFX);

        for (int j = 0; j < textureList.size(); j++)
        {
            TextureFX texturefx = (TextureFX)textureList.get(j);
            int k = getTextureId(texturefx);

            if (k == i && texturefx.iconIndex == par1TextureFX.iconIndex)
            {
                textureList.remove(j);
                j--;
                Config.log((new StringBuilder()).append("TextureFX removed: ").append(texturefx).append(", texId: ").append(k).append(", index: ").append(texturefx.iconIndex).toString());
            }
        }

        if (par1TextureFX instanceof TextureHDFX)
        {
            TextureHDFX texturehdfx = (TextureHDFX)par1TextureFX;
            texturehdfx.setTexturePackBase(texturePack.selectedTexturePack);
            Dimension dimension = getTextureDimensions(i);

            if (dimension != null)
            {
                texturehdfx.setTileWidth(dimension.width / 16);
            }
        }

        textureList.add(par1TextureFX);
        par1TextureFX.onTick();
        Config.log((new StringBuilder()).append("TextureFX registered: ").append(par1TextureFX).append(", texId: ").append(i).append(", index: ").append(par1TextureFX.iconIndex).toString());
        dynamicTexturesUpdated = false;
    }

    private int getTextureId(TextureFX texturefx)
    {
        Integer integer = (Integer)textureFxMap.get(texturefx);

        if (integer != null)
        {
            return integer.intValue();
        }
        else
        {
            int i = getBoundTexture();
            texturefx.bindImage(this);
            int j = getBoundTexture();
            bindTexture(i);
            textureFxMap.put(texturefx, new Integer(j));
            return j;
        }
    }

    private int getBoundTexture()
    {
        int i = GL11.glGetInteger(GL11.GL_TEXTURE_BINDING_2D);
        return i;
    }

    private void generateMipMapsSub(int i, int j, int k, int l, ByteBuffer bytebuffer, int i1, boolean flag, int j1, int k1, String s)
    {
        ByteBuffer bytebuffer1 = bytebuffer;
        byte abyte0[][] = (byte[][])null;

        if (s.length() > 0)
        {
            abyte0 = (byte[][])mipDataBufsMap.get(s);

            if (abyte0 == null)
            {
                abyte0 = new byte[17][];
                mipDataBufsMap.put(s, abyte0);
            }
        }

        int l1 = 1;

        do
        {
            if (l1 > 16)
            {
                break;
            }

            int i2 = k >> l1 - 1;
            int j2 = k >> l1;
            int k2 = l >> l1;
            int l2 = i >> l1;
            int i3 = j >> l1;

            if (j2 <= 0 || k2 <= 0)
            {
                break;
            }

            ByteBuffer bytebuffer2 = mipImageDatas[l1 - 1];
            bytebuffer2.limit(j2 * k2 * 4);
            byte abyte1[] = null;

            if (abyte0 != null)
            {
                abyte1 = abyte0[l1];
            }

            if (abyte1 != null && abyte1.length != j2 * k2 * 4)
            {
                abyte1 = null;
            }

            if (abyte1 == null)
            {
                if (abyte0 != null)
                {
                    abyte1 = new byte[j2 * k2 * 4];
                }

                for (int j3 = 0; j3 < j2; j3++)
                {
                    for (int l3 = 0; l3 < k2; l3++)
                    {
                        int j4 = bytebuffer1.getInt((j3 * 2 + 0 + (l3 * 2 + 0) * i2) * 4);
                        int l4 = bytebuffer1.getInt((j3 * 2 + 1 + (l3 * 2 + 0) * i2) * 4);
                        int j5 = bytebuffer1.getInt((j3 * 2 + 1 + (l3 * 2 + 1) * i2) * 4);
                        int l5 = bytebuffer1.getInt((j3 * 2 + 0 + (l3 * 2 + 1) * i2) * 4);
                        int i6;

                        if (flag)
                        {
                            i6 = averageColor(averageColor(j4, l4), averageColor(j5, l5));
                        }
                        else
                        {
                            i6 = alphaBlend(j4, l4, j5, l5);
                        }

                        bytebuffer2.putInt((j3 + l3 * j2) * 4, i6);
                    }
                }

                if (abyte0 != null)
                {
                    bytebuffer2.rewind();
                    bytebuffer2.get(abyte1);
                    abyte0[l1] = abyte1;
                }
            }

            if (abyte1 != null)
            {
                bytebuffer2.rewind();
                bytebuffer2.put(abyte1);
            }

            bytebuffer2.rewind();

            for (int k3 = 0; k3 < i1; k3++)
            {
                for (int i4 = 0; i4 < i1; i4++)
                {
                    int k4 = k3 * j2;
                    int i5 = i4 * k2;

                    if (Config.isMultiTexture() && j1 == terrainTextureId)
                    {
                        int k5 = i4 * 16 + k3;
                        GL11.glBindTexture(GL11.GL_TEXTURE_2D, Tessellator.terrainTextures[k1 + k5]);
                        k4 = 0;
                        i5 = 0;
                    }

                    GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, l1, l2 + k4, i3 + i5, j2, k2, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, bytebuffer2);
                }
            }

            bytebuffer1 = bytebuffer2;
            l1++;
        }
        while (true);
    }

    public void updateDynamicTextures()
    {
        boolean flag = useMipmaps && Config.isUseMipmaps();
        checkHdTextures();
        tickCounter++;
        terrainTextureId = getTexture("/terrain.png");
        guiItemsTextureId = getTexture("/gui/items.png");
        ctmTextureId = getTexture("/ctm.png");
        StringBuffer stringbuffer = new StringBuffer();
        int i = -1;
        label0:

        for (int j = 0; j < textureList.size(); j++)
        {
            TextureFX texturefx = (TextureFX)textureList.get(j);
            texturefx.anaglyphEnabled = options.anaglyph;

            if (texturefx.getClass().getName().equals("ModTextureStatic") && dynamicTexturesUpdated)
            {
                continue;
            }

            int k = getTextureId(texturefx);
            Dimension dimension = getTextureDimensions(k);

            if (dimension == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unknown dimensions for texture id: ").append(k).toString());
            }

            int l = dimension.width / 16;
            int i1 = dimension.height / 16;
            checkImageDataSize(dimension.width);
            imageData.limit(0);
            stringbuffer.setLength(0);
            boolean flag1 = updateCustomTexture(texturefx, k, imageData, dimension.width / 16, stringbuffer);

            if (flag1 && imageData.limit() <= 0)
            {
                continue;
            }

            if (imageData.limit() <= 0)
            {
                boolean flag2 = updateDefaultTexture(texturefx, k, imageData, dimension.width / 16, stringbuffer);

                if (flag2 && imageData.limit() <= 0)
                {
                    continue;
                }
            }

            if (imageData.limit() <= 0)
            {
                texturefx.onTick();

                if (texturefx.imageData == null)
                {
                    continue;
                }

                int j1 = l * i1 * 4;

                if (texturefx.imageData.length == j1)
                {
                    imageData.clear();
                    imageData.put(texturefx.imageData);
                    imageData.position(0).limit(texturefx.imageData.length);
                }
                else
                {
                    copyScaled(texturefx.imageData, imageData, l);
                }
            }

            if (k != i)
            {
                texturefx.bindImage(this);
                i = k;
            }

            boolean flag3 = scalesWithFastColor(texturefx);

            for (int k1 = 0; k1 < texturefx.tileSize; k1++)
            {
                for (int i2 = 0; i2 < texturefx.tileSize; i2++)
                {
                    int k2 = (texturefx.iconIndex % 16) * l + k1 * l;
                    int i3 = (texturefx.iconIndex / 16) * i1 + i2 * i1;
                    GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, k2, i3, l, i1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageData);

                    if (!flag || k == guiItemsTextureId)
                    {
                        continue;
                    }

                    String s = stringbuffer.toString();

                    if (k1 == 0 && i2 == 0)
                    {
                        generateMipMapsSub(k2, i3, l, i1, imageData, texturefx.tileSize, flag3, 0, 0, s);
                    }
                }
            }

            if (!Config.isMultiTexture() || k != terrainTextureId)
            {
                continue;
            }

            int l1 = 0;

            do
            {
                if (l1 >= texturefx.tileSize)
                {
                    continue label0;
                }

                for (int j2 = 0; j2 < texturefx.tileSize; j2++)
                {
                    int l2 = 0;
                    int j3 = 0;
                    int k3 = j2 * 16 + l1;
                    int l3 = Tessellator.terrainTextures[texturefx.iconIndex + k3];
                    GL11.glBindTexture(GL11.GL_TEXTURE_2D, l3);
                    i = l3;
                    GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, l2, j3, l, i1, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageData);

                    if (!flag)
                    {
                        continue;
                    }

                    String s1 = stringbuffer.toString();

                    if (l1 == 0 && j2 == 0)
                    {
                        generateMipMapsSub(l2, j3, l, i1, imageData, texturefx.tileSize, flag3, k, texturefx.iconIndex, s1);
                    }
                }

                l1++;
            }
            while (true);
        }

        dynamicTexturesUpdated = true;
    }

    private int averageColor(int i, int j)
    {
        int k = (i & 0xff000000) >> 24 & 0xff;
        int l = (j & 0xff000000) >> 24 & 0xff;
        return ((k + l >> 1) << 24) + ((i & 0xfefefe) + (j & 0xfefefe) >> 1);
    }

    private int alphaBlend(int i, int j, int k, int l)
    {
        int i1 = alphaBlend(i, j);
        int j1 = alphaBlend(k, l);
        int k1 = alphaBlend(i1, j1);
        return k1;
    }

    /**
     * Uses the alpha of the two colors passed in to determine the contributions of each color.  If either of them has
     * an alpha greater than 0 then the returned alpha is 255 otherwise its zero if they are both zero. Args: color1,
     * color2
     */
    private int alphaBlend(int par1, int par2)
    {
        int i = (par1 & 0xff000000) >> 24 & 0xff;
        int j = (par2 & 0xff000000) >> 24 & 0xff;
        int k = (i + j) / 2;

        if (i == 0 && j == 0)
        {
            i = 1;
            j = 1;
        }
        else
        {
            if (i == 0)
            {
                par1 = par2;
                k /= 2;
            }

            if (j == 0)
            {
                par2 = par1;
                k /= 2;
            }
        }

        int l = (par1 >> 16 & 0xff) * i;
        int i1 = (par1 >> 8 & 0xff) * i;
        int j1 = (par1 & 0xff) * i;
        int k1 = (par2 >> 16 & 0xff) * j;
        int l1 = (par2 >> 8 & 0xff) * j;
        int i2 = (par2 & 0xff) * j;
        int j2 = (l + k1) / (i + j);
        int k2 = (i1 + l1) / (i + j);
        int l2 = (j1 + i2) / (i + j);
        return k << 24 | j2 << 16 | k2 << 8 | l2;
    }

    /**
     * Call setupTexture on all currently-loaded textures again to account for changes in rendering options
     */
    public void refreshTextures()
    {
        textureDataMap.clear();
        textureFxMap.clear();
        dynamicTexturesUpdated = false;
        Config.setTextureUpdateTime(System.currentTimeMillis());
        RandomMobs.resetTextures();
        mipDataBufsMap.clear();
        TexturePackBase texturepackbase = texturePack.selectedTexturePack;
        int i;
        BufferedImage bufferedimage;

        for (Iterator iterator = textureNameToImageMap.getKeySet().iterator(); iterator.hasNext(); setupTexture(bufferedimage, i))
        {
            i = ((Integer)iterator.next()).intValue();
            bufferedimage = (BufferedImage)textureNameToImageMap.lookup(i);
        }

        for (Iterator iterator1 = urlToImageDataMap.values().iterator(); iterator1.hasNext();)
        {
            ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)iterator1.next();
            threaddownloadimagedata.textureSetupComplete = false;
        }

        Iterator iterator2 = textureMap.keySet().iterator();

        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }

            String s = (String)iterator2.next();

            try
            {
                BufferedImage bufferedimage1;

                if (s.startsWith("##"))
                {
                    bufferedimage1 = unwrapImageByColumns(readTextureImage(texturepackbase.getResourceAsStream(s.substring(2))));
                }
                else if (s.startsWith("%clamp%"))
                {
                    clampTexture = true;
                    bufferedimage1 = readTextureImage(texturepackbase.getResourceAsStream(s.substring(7)));
                }
                else if (s.startsWith("%blur%"))
                {
                    blurTexture = true;
                    bufferedimage1 = readTextureImage(texturepackbase.getResourceAsStream(s.substring(6)));
                }
                else if (s.startsWith("%blurclamp%"))
                {
                    blurTexture = true;
                    clampTexture = true;
                    bufferedimage1 = readTextureImage(texturepackbase.getResourceAsStream(s.substring(11)));
                }
                else
                {
                    bufferedimage1 = readTextureImage(texturepackbase.getResourceAsStream(s));
                }

                int j = ((Integer)textureMap.get(s)).intValue();
                setupTexture(bufferedimage1, j);
                blurTexture = false;
                clampTexture = false;
            }
            catch (Exception exception)
            {
                if (!"input == null!".equals(exception.getMessage()))
                {
                    exception.printStackTrace();
                }
            }
        }
        while (true);

        iterator2 = textureContentsMap.keySet().iterator();

        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }

            String s1 = (String)iterator2.next();

            try
            {
                BufferedImage bufferedimage2;

                if (s1.startsWith("##"))
                {
                    bufferedimage2 = unwrapImageByColumns(readTextureImage(texturepackbase.getResourceAsStream(s1.substring(2))));
                }
                else if (s1.startsWith("%clamp%"))
                {
                    clampTexture = true;
                    bufferedimage2 = readTextureImage(texturepackbase.getResourceAsStream(s1.substring(7)));
                }
                else if (s1.startsWith("%blur%"))
                {
                    blurTexture = true;
                    bufferedimage2 = readTextureImage(texturepackbase.getResourceAsStream(s1.substring(6)));
                }
                else
                {
                    bufferedimage2 = readTextureImage(texturepackbase.getResourceAsStream(s1));
                }

                getImageContents(bufferedimage2, (int[])textureContentsMap.get(s1));
                blurTexture = false;
                clampTexture = false;
            }
            catch (Exception exception1)
            {
                if (!"input == null!".equals(exception1.getMessage()))
                {
                    exception1.printStackTrace();
                }
            }
        }
        while (true);

        registerCustomTexturesFX();
        CustomColorizer.update(this);
        updateDynamicTextures();
    }

    /**
     * Returns a BufferedImage read off the provided input stream.  Args: inputStream
     */
    private BufferedImage readTextureImage(InputStream par1InputStream) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(par1InputStream);
        par1InputStream.close();
        return bufferedimage;
    }

    public void bindTexture(int par1)
    {
        if (par1 < 0)
        {
            return;
        }
        else
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1);
            return;
        }
    }

    private void setTextureDimension(int i, Dimension dimension)
    {
        textureDimensionsMap.put(new Integer(i), dimension);

        if (i == terrainTextureId)
        {
            Config.setIconWidthTerrain(dimension.width / 16);
        }

        if (i == guiItemsTextureId)
        {
            Config.setIconWidthItems(dimension.width / 16);
        }

        updateDinamicTextures(i, dimension);
    }

    private Dimension getTextureDimensions(int i)
    {
        Dimension dimension = (Dimension)textureDimensionsMap.get(new Integer(i));
        return dimension;
    }

    private void updateDinamicTextures(int i, Dimension dimension)
    {
        for (int j = 0; j < textureList.size(); j++)
        {
            TextureFX texturefx = (TextureFX)textureList.get(j);
            int k = getTextureId(texturefx);

            if (k == i && (texturefx instanceof TextureHDFX))
            {
                TextureHDFX texturehdfx = (TextureHDFX)texturefx;
                texturehdfx.setTexturePackBase(texturePack.selectedTexturePack);
                texturehdfx.setTileWidth(dimension.width / 16);
                texturehdfx.onTick();
            }
        }
    }

    public boolean updateCustomTexture(TextureFX texturefx, int i, ByteBuffer bytebuffer, int j, StringBuffer stringbuffer)
    {
        if (i == terrainTextureId)
        {
            if (texturefx.iconIndex == Block.waterStill.blockIndexInTexture)
            {
                if (Config.isGeneratedWater())
                {
                    return false;
                }
                else
                {
                    return updateCustomTexture(texturefx, "/custom_water_still.png", bytebuffer, j, Config.isAnimatedWater(), 1, stringbuffer);
                }
            }

            if (texturefx.iconIndex == Block.waterStill.blockIndexInTexture + 1)
            {
                if (Config.isGeneratedWater())
                {
                    return false;
                }
                else
                {
                    return updateCustomTexture(texturefx, "/custom_water_flowing.png", bytebuffer, j, Config.isAnimatedWater(), 1, stringbuffer);
                }
            }

            if (texturefx.iconIndex == Block.lavaStill.blockIndexInTexture)
            {
                if (Config.isGeneratedLava())
                {
                    return false;
                }
                else
                {
                    return updateCustomTexture(texturefx, "/custom_lava_still.png", bytebuffer, j, Config.isAnimatedLava(), 1, stringbuffer);
                }
            }

            if (texturefx.iconIndex == Block.lavaStill.blockIndexInTexture + 1)
            {
                if (Config.isGeneratedLava())
                {
                    return false;
                }
                else
                {
                    return updateCustomTexture(texturefx, "/custom_lava_flowing.png", bytebuffer, j, Config.isAnimatedLava(), 1, stringbuffer);
                }
            }

            if (texturefx.iconIndex == Block.portal.blockIndexInTexture)
            {
                return updateCustomTexture(texturefx, "/custom_portal.png", bytebuffer, j, Config.isAnimatedPortal(), 1, stringbuffer);
            }

            if (texturefx.iconIndex == Block.fire.blockIndexInTexture)
            {
                return updateCustomTexture(texturefx, "/custom_fire_n_s.png", bytebuffer, j, Config.isAnimatedFire(), 1, stringbuffer);
            }

            if (texturefx.iconIndex == Block.fire.blockIndexInTexture + 16)
            {
                return updateCustomTexture(texturefx, "/custom_fire_e_w.png", bytebuffer, j, Config.isAnimatedFire(), 1, stringbuffer);
            }

            if (Config.isAnimatedTerrain())
            {
                return updateCustomTexture(texturefx, (new StringBuilder()).append("/custom_terrain_").append(texturefx.iconIndex).append(".png").toString(), bytebuffer, j, Config.isAnimatedTerrain(), 1, stringbuffer);
            }
        }

        if (i == guiItemsTextureId && Config.isAnimatedItems())
        {
            return updateCustomTexture(texturefx, (new StringBuilder()).append("/custom_item_").append(texturefx.iconIndex).append(".png").toString(), bytebuffer, j, Config.isAnimatedTerrain(), 1, stringbuffer);
        }
        else
        {
            return false;
        }
    }

    private boolean updateDefaultTexture(TextureFX texturefx, int i, ByteBuffer bytebuffer, int j, StringBuffer stringbuffer)
    {
        if (i != terrainTextureId)
        {
            return false;
        }

        if (texturePack.selectedTexturePack instanceof TexturePackDefault)
        {
            return false;
        }

        if (texturefx.iconIndex == Block.waterStill.blockIndexInTexture)
        {
            if (Config.isGeneratedWater())
            {
                return false;
            }
            else
            {
                return updateDefaultTexture(texturefx, bytebuffer, j, false, 1, stringbuffer);
            }
        }

        if (texturefx.iconIndex == Block.waterStill.blockIndexInTexture + 1)
        {
            if (Config.isGeneratedWater())
            {
                return false;
            }
            else
            {
                return updateDefaultTexture(texturefx, bytebuffer, j, Config.isAnimatedWater(), 1, stringbuffer);
            }
        }

        if (texturefx.iconIndex == Block.lavaStill.blockIndexInTexture)
        {
            if (Config.isGeneratedLava())
            {
                return false;
            }
            else
            {
                return updateDefaultTexture(texturefx, bytebuffer, j, false, 1, stringbuffer);
            }
        }

        if (texturefx.iconIndex == Block.lavaStill.blockIndexInTexture + 1)
        {
            if (Config.isGeneratedLava())
            {
                return false;
            }
            else
            {
                return updateDefaultTexture(texturefx, bytebuffer, j, Config.isAnimatedLava(), 3, stringbuffer);
            }
        }
        else
        {
            return false;
        }
    }

    private boolean updateDefaultTexture(TextureFX texturefx, ByteBuffer bytebuffer, int i, boolean flag, int j, StringBuffer stringbuffer)
    {
        int k = texturefx.iconIndex;

        if (!flag && dynamicTexturesUpdated)
        {
            return true;
        }

        byte abyte0[] = getTerrainIconData(k, i, stringbuffer);

        if (abyte0 == null)
        {
            return false;
        }

        bytebuffer.clear();
        int l = abyte0.length;

        if (flag)
        {
            int i1 = i - (tickCounter / j) % i;
            int j1 = i1 * i * 4;
            bytebuffer.put(abyte0, j1, l - j1);
            bytebuffer.put(abyte0, 0, j1);
            stringbuffer.append(":");
            stringbuffer.append(i1);
        }
        else
        {
            bytebuffer.put(abyte0, 0, l);
        }

        bytebuffer.position(0).limit(l);
        return true;
    }

    private boolean updateCustomTexture(TextureFX texturefx, String s, ByteBuffer bytebuffer, int i, boolean flag, int j, StringBuffer stringbuffer)
    {
        byte abyte0[] = getCustomTextureData(s, i);

        if (abyte0 == null)
        {
            return false;
        }

        if (!flag && dynamicTexturesUpdated)
        {
            return true;
        }

        int k = i * i * 4;

        if (abyte0.length < k)
        {
            return false;
        }

        int l = abyte0.length / k;
        int i1 = (tickCounter / j) % l;
        int j1 = 0;

        if (flag)
        {
            j1 = k * i1;
        }

        bytebuffer.clear();
        bytebuffer.put(abyte0, j1, k);
        bytebuffer.position(0).limit(k);
        stringbuffer.append(s);
        stringbuffer.append(":");
        stringbuffer.append(i1);
        return true;
    }

    private byte[] getTerrainIconData(int i, int j, StringBuffer stringbuffer)
    {
        String s = (new StringBuilder()).append("Tile-").append(i).toString();
        byte abyte0[] = getCustomTextureData(s, j);

        if (abyte0 != null)
        {
            stringbuffer.append(s);
            return abyte0;
        }

        byte abyte1[] = getCustomTextureData("/terrain.png", j * 16);

        if (abyte1 == null)
        {
            return null;
        }

        abyte0 = new byte[j * j * 4];
        int k = i % 16;
        int l = i / 16;
        int i1 = k * j;
        int j1 = l * j;
        int k1 = i1 + j;
        int l1 = j1 + j;

        for (int i2 = 0; i2 < j; i2++)
        {
            int j2 = j1 + i2;

            for (int k2 = 0; k2 < j; k2++)
            {
                int l2 = i1 + k2;
                int i3 = 4 * (l2 + j2 * j * 16);
                int j3 = 4 * (k2 + i2 * j);
                abyte0[j3 + 0] = abyte1[i3 + 0];
                abyte0[j3 + 1] = abyte1[i3 + 1];
                abyte0[j3 + 2] = abyte1[i3 + 2];
                abyte0[j3 + 3] = abyte1[i3 + 3];
            }
        }

        setCustomTextureData(s, abyte0);
        stringbuffer.append(s);
        return abyte0;
    }

    public byte[] getCustomTextureData(String s, int i)
    {
        byte abyte0[] = (byte[])textureDataMap.get(s);

        if (abyte0 == null)
        {
            if (textureDataMap.containsKey(s))
            {
                return null;
            }

            abyte0 = loadImage(s, i);

            if (abyte0 == null)
            {
                abyte0 = loadImage((new StringBuilder()).append("/anim").append(s).toString(), i);
            }

            textureDataMap.put(s, abyte0);
        }

        return abyte0;
    }

    private void setCustomTextureData(String s, byte abyte0[])
    {
        textureDataMap.put(s, abyte0);
    }

    private byte[] loadImage(String s, int i)
    {
        try
        {
            TexturePackBase texturepackbase = texturePack.selectedTexturePack;

            if (texturepackbase == null)
            {
                return null;
            }

            InputStream inputstream = texturepackbase.getResourceAsStream(s);

            if (inputstream == null)
            {
                return null;
            }

            BufferedImage bufferedimage = readTextureImage(inputstream);

            if (bufferedimage == null)
            {
                return null;
            }

            if (i > 0 && bufferedimage.getWidth() != i)
            {
                double d = bufferedimage.getHeight() / bufferedimage.getWidth();
                int l = (int)((double)i * d);
                bufferedimage = scaleBufferedImage(bufferedimage, i, l);
            }

            int j = bufferedimage.getWidth();
            int k = bufferedimage.getHeight();
            int ai[] = new int[j * k];
            byte abyte0[] = new byte[j * k * 4];
            bufferedimage.getRGB(0, 0, j, k, ai, 0, j);

            for (int i1 = 0; i1 < ai.length; i1++)
            {
                int j1 = ai[i1] >> 24 & 0xff;
                int k1 = ai[i1] >> 16 & 0xff;
                int l1 = ai[i1] >> 8 & 0xff;
                int i2 = ai[i1] & 0xff;

                if (options != null && options.anaglyph)
                {
                    int j2 = (k1 * 30 + l1 * 59 + i2 * 11) / 100;
                    int k2 = (k1 * 30 + l1 * 70) / 100;
                    int l2 = (k1 * 30 + i2 * 70) / 100;
                    k1 = j2;
                    l1 = k2;
                    i2 = l2;
                }

                abyte0[i1 * 4 + 0] = (byte)k1;
                abyte0[i1 * 4 + 1] = (byte)l1;
                abyte0[i1 * 4 + 2] = (byte)i2;
                abyte0[i1 * 4 + 3] = (byte)j1;
            }

            return abyte0;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }

    public static BufferedImage scaleBufferedImage(BufferedImage bufferedimage, int i, int j)
    {
        BufferedImage bufferedimage1 = new BufferedImage(i, j, 2);
        Graphics2D graphics2d = bufferedimage1.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.drawImage(bufferedimage, 0, 0, i, j, null);
        return bufferedimage1;
    }

    private void checkImageDataSize(int i)
    {
        if (imageData != null)
        {
            int j = i * i * 4;

            if (imageData.capacity() >= j)
            {
                return;
            }
        }

        allocateImageData(i);
    }

    private void allocateImageData(int i)
    {
        int j = i * i * 4;
        imageData = GLAllocation.createDirectByteBuffer(j);
        ArrayList arraylist = new ArrayList();

        for (int k = i / 2; k > 0; k /= 2)
        {
            int l = k * k * 4;
            ByteBuffer bytebuffer = GLAllocation.createDirectByteBuffer(l);
            arraylist.add(bytebuffer);
        }

        mipImageDatas = (ByteBuffer[])arraylist.toArray(new ByteBuffer[arraylist.size()]);
    }

    public void checkHdTextures()
    {
        if (hdTexturesInstalled)
        {
            return;
        }

        net.minecraft.client.Minecraft minecraft = Config.getMinecraft();

        if (minecraft == null)
        {
            return;
        }
        else
        {
            hdTexturesInstalled = true;
            registerTextureFX(new TextureHDLavaFX());
            registerTextureFX(new TextureHDWaterFX());
            registerTextureFX(new TextureHDPortalFX());
            registerTextureFX(new TextureHDWaterFlowFX());
            registerTextureFX(new TextureHDLavaFlowFX());
            registerTextureFX(new TextureHDFlamesFX(0));
            registerTextureFX(new TextureHDFlamesFX(1));
            registerTextureFX(new TextureHDCompassFX(minecraft));
            registerTextureFX(new TextureHDWatchFX(minecraft));
            registerCustomTexturesFX();
            CustomColorizer.update(this);
            return;
        }
    }

    private void registerCustomTexturesFX()
    {
        TextureFX atexturefx[] = getRegisteredTexturesFX(net.minecraft.src.TextureHDCustomFX.class);

        for (int i = 0; i < atexturefx.length; i++)
        {
            TextureFX texturefx = atexturefx[i];
            unregisterTextureFX(texturefx);
        }

        if (Config.isAnimatedTerrain())
        {
            for (int j = 0; j < 256; j++)
            {
                registerCustomTextureFX((new StringBuilder()).append("/custom_terrain_").append(j).append(".png").toString(), j, 0);
            }
        }

        if (Config.isAnimatedItems())
        {
            for (int k = 0; k < 256; k++)
            {
                registerCustomTextureFX((new StringBuilder()).append("/custom_item_").append(k).append(".png").toString(), k, 1);
            }
        }
    }

    private void unregisterTextureFX(TextureFX texturefx)
    {
        for (int i = 0; i < textureList.size(); i++)
        {
            TextureFX texturefx1 = (TextureFX)textureList.get(i);

            if (texturefx1 == texturefx)
            {
                textureList.remove(i);
                i--;
            }
        }
    }

    private TextureFX[] getRegisteredTexturesFX(Class class1)
    {
        ArrayList arraylist = new ArrayList();

        for (int i = 0; i < textureList.size(); i++)
        {
            TextureFX texturefx = (TextureFX)textureList.get(i);

            if (class1.isAssignableFrom(texturefx.getClass()))
            {
                arraylist.add(texturefx);
            }
        }

        TextureFX atexturefx[] = (TextureFX[])arraylist.toArray(new TextureFX[arraylist.size()]);
        return atexturefx;
    }

    private void registerCustomTextureFX(String s, int i, int j)
    {
        byte abyte0[] = null;

        if (j == 0)
        {
            abyte0 = getCustomTextureData(s, Config.getIconWidthTerrain());
        }
        else
        {
            abyte0 = getCustomTextureData(s, Config.getIconWidthItems());
        }

        if (abyte0 == null)
        {
            return;
        }
        else
        {
            registerTextureFX(new TextureHDCustomFX(i, j));
            return;
        }
    }

    private int getMaxMipmapLevel(int i)
    {
        int j;

        for (j = 0; i > 0; j++)
        {
            i /= 2;
        }

        return j - 1;
    }

    private void copyScaled(byte abyte0[], ByteBuffer bytebuffer, int i)
    {
        int j = (int)Math.sqrt(abyte0.length / 4);
        int k = i / j;
        byte abyte1[] = new byte[4];
        int l = i * i;
        bytebuffer.clear();

        if (k > 1)
        {
            for (int i1 = 0; i1 < j; i1++)
            {
                int j1 = i1 * j;
                int k1 = i1 * k;
                int l1 = k1 * i;

                for (int i2 = 0; i2 < j; i2++)
                {
                    int j2 = (i2 + j1) * 4;
                    abyte1[0] = abyte0[j2];
                    abyte1[1] = abyte0[j2 + 1];
                    abyte1[2] = abyte0[j2 + 2];
                    abyte1[3] = abyte0[j2 + 3];
                    int k2 = i2 * k;
                    int l2 = k2 + l1;

                    for (int i3 = 0; i3 < k; i3++)
                    {
                        int j3 = l2 + i3 * i;
                        bytebuffer.position(j3 * 4);

                        for (int k3 = 0; k3 < k; k3++)
                        {
                            bytebuffer.put(abyte1);
                        }
                    }
                }
            }
        }

        bytebuffer.position(0).limit(i * i * 4);
    }

    private boolean scalesWithFastColor(TextureFX texturefx)
    {
        return !texturefx.getClass().getName().equals("ModTextureStatic");
    }

    public TexturePackList getTexturePack()
    {
        return texturePack;
    }
}
