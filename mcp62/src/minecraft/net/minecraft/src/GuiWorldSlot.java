package net.minecraft.src;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

class GuiWorldSlot extends GuiSlot
{
    final GuiSelectWorld parentWorldGui;

    public GuiWorldSlot(GuiSelectWorld par1GuiSelectWorld)
    {
        super(par1GuiSelectWorld.mc, par1GuiSelectWorld.width, par1GuiSelectWorld.height, 32, par1GuiSelectWorld.height - 64, 36);
        parentWorldGui = par1GuiSelectWorld;
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return GuiSelectWorld.getSize(parentWorldGui).size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int par1, boolean par2)
    {
        GuiSelectWorld.onElementSelected(parentWorldGui, par1);
        boolean flag = GuiSelectWorld.getSelectedWorld(parentWorldGui) >= 0 && GuiSelectWorld.getSelectedWorld(parentWorldGui) < getSize();
        GuiSelectWorld.getSelectButton(parentWorldGui).enabled = flag;
        GuiSelectWorld.getRenameButton(parentWorldGui).enabled = flag;
        GuiSelectWorld.getDeleteButton(parentWorldGui).enabled = flag;

        if (par2 && flag)
        {
            parentWorldGui.selectWorld(par1);
        }
    }

    /**
     * returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int par1)
    {
        return par1 == GuiSelectWorld.getSelectedWorld(parentWorldGui);
    }

    /**
     * return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return GuiSelectWorld.getSize(parentWorldGui).size() * 36;
    }

    protected void drawBackground()
    {
        parentWorldGui.drawDefaultBackground();
    }

    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator par5Tessellator)
    {
        SaveFormatComparator saveformatcomparator = (SaveFormatComparator)GuiSelectWorld.getSize(parentWorldGui).get(par1);
        String s = saveformatcomparator.getDisplayName();

        if (s == null || MathHelper.stringNullOrLengthZero(s))
        {
            s = (new StringBuilder()).append(GuiSelectWorld.getLocalizedWorldName(parentWorldGui)).append(" ").append(par1 + 1).toString();
        }

        String s1 = saveformatcomparator.getFileName();
        s1 = (new StringBuilder()).append(s1).append(" (").append(GuiSelectWorld.getDateFormatter(parentWorldGui).format(new Date(saveformatcomparator.getLastTimePlayed()))).toString();
        s1 = (new StringBuilder()).append(s1).append(")").toString();
        String s2 = "";

        if (saveformatcomparator.requiresConversion())
        {
            s2 = (new StringBuilder()).append(GuiSelectWorld.getLocalizedMustConvert(parentWorldGui)).append(" ").append(s2).toString();
        }
        else
        {
            s2 = GuiSelectWorld.getLocalizedGameMode(parentWorldGui)[saveformatcomparator.getGameType()];

            if (saveformatcomparator.isHardcoreModeEnabled())
            {
                s2 = (new StringBuilder()).append("\2474").append(StatCollector.translateToLocal("gameMode.hardcore")).append("\2478").toString();
            }
        }

        parentWorldGui.drawString(parentWorldGui.fontRenderer, s, par2 + 2, par3 + 1, 0xffffff);
        parentWorldGui.drawString(parentWorldGui.fontRenderer, s1, par2 + 2, par3 + 12, 0x808080);
        parentWorldGui.drawString(parentWorldGui.fontRenderer, s2, par2 + 2, par3 + 12 + 10, 0x808080);
    }
}
