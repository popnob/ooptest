package com.prohaker.client.mods;

import com.prohaker.client.core.Haker;

import net.minecraft.client.Minecraft;

public class Fullbright extends Mod {

    public Fullbright(Haker rc, Minecraft mc) {
        super(Mods.FULLBRIGHT);
        haker = rc;
        minecraft = mc;
        oldGamma = minecraft.gameSettings.gammaSetting;
    }

    @Override
    public void onEnable() {
        haker.getUtils().addChatMessage(getActive());
        oldGamma = minecraft.gameSettings.gammaSetting;
        minecraft.gameSettings.gammaSetting = 1000000;
    }

    @Override
    public void onDisable() {
        haker.getUtils().addChatMessage(getActive());
        minecraft.gameSettings.gammaSetting = oldGamma;
    }
    
    private float oldGamma;
    private Haker haker;
    private Minecraft minecraft;
    
}