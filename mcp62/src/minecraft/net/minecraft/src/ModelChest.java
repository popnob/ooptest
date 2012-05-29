package net.minecraft.src;

public class ModelChest extends ModelBase
{
    /** The chest lid in the chest's model. */
    public ModelRenderer chestLid;

    /** The model of the bottom of the chest. */
    public ModelRenderer chestBelow;

    /** The chest's knob in the chest model. */
    public ModelRenderer chestKnob;

    public ModelChest()
    {
        chestLid = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        chestLid.addBox(0.0F, -5F, -14F, 14, 5, 14, 0.0F);
        chestLid.rotationPointX = 1.0F;
        chestLid.rotationPointY = 7F;
        chestLid.rotationPointZ = 15F;
        chestKnob = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        chestKnob.addBox(-1F, -2F, -15F, 2, 4, 1, 0.0F);
        chestKnob.rotationPointX = 8F;
        chestKnob.rotationPointY = 7F;
        chestKnob.rotationPointZ = 15F;
        chestBelow = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
        chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        chestBelow.rotationPointX = 1.0F;
        chestBelow.rotationPointY = 6F;
        chestBelow.rotationPointZ = 1.0F;
    }

    /**
     * This method renders out all parts of the chest model.
     */
    public void renderAll()
    {
        chestKnob.rotateAngleX = chestLid.rotateAngleX;
        chestLid.render(0.0625F);
        chestKnob.render(0.0625F);
        chestBelow.render(0.0625F);
    }
}
