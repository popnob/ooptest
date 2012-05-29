package net.minecraft.src;

public class TextureWaterFlowFX extends TextureFX
{
    protected float field_1138_g[];
    protected float field_1137_h[];
    protected float field_1136_i[];
    protected float field_1135_j[];
    private int tickCounter;

    public TextureWaterFlowFX()
    {
        super(Block.waterMoving.blockIndexInTexture + 1);
        field_1138_g = new float[256];
        field_1137_h = new float[256];
        field_1136_i = new float[256];
        field_1135_j = new float[256];
        tickCounter = 0;
        tileSize = 2;
    }

    public void onTick()
    {
        tickCounter++;

        for (int i = 0; i < 16; i++)
        {
            for (int k = 0; k < 16; k++)
            {
                float f = 0.0F;

                for (int j1 = k - 2; j1 <= k; j1++)
                {
                    int k1 = i & 0xf;
                    int i2 = j1 & 0xf;
                    f += field_1138_g[k1 + i2 * 16];
                }

                field_1137_h[i + k * 16] = f / 3.2F + field_1136_i[i + k * 16] * 0.8F;
            }
        }

        for (int j = 0; j < 16; j++)
        {
            for (int l = 0; l < 16; l++)
            {
                field_1136_i[j + l * 16] += field_1135_j[j + l * 16] * 0.05F;

                if (field_1136_i[j + l * 16] < 0.0F)
                {
                    field_1136_i[j + l * 16] = 0.0F;
                }

                field_1135_j[j + l * 16] -= 0.3F;

                if (Math.random() < 0.20000000000000001D)
                {
                    field_1135_j[j + l * 16] = 0.5F;
                }
            }
        }

        float af[] = field_1137_h;
        field_1137_h = field_1138_g;
        field_1138_g = af;

        for (int i1 = 0; i1 < 256; i1++)
        {
            float f1 = field_1138_g[i1 - tickCounter * 16 & 0xff];

            if (f1 > 1.0F)
            {
                f1 = 1.0F;
            }

            if (f1 < 0.0F)
            {
                f1 = 0.0F;
            }

            float f2 = f1 * f1;
            int l1 = (int)(32F + f2 * 32F);
            int j2 = (int)(50F + f2 * 64F);
            int k2 = 255;
            int l2 = (int)(146F + f2 * 50F);

            if (anaglyphEnabled)
            {
                int i3 = (l1 * 30 + j2 * 59 + k2 * 11) / 100;
                int j3 = (l1 * 30 + j2 * 70) / 100;
                int k3 = (l1 * 30 + k2 * 70) / 100;
                l1 = i3;
                j2 = j3;
                k2 = k3;
            }

            imageData[i1 * 4 + 0] = (byte)l1;
            imageData[i1 * 4 + 1] = (byte)j2;
            imageData[i1 * 4 + 2] = (byte)k2;
            imageData[i1 * 4 + 3] = (byte)l2;
        }
    }
}
