package com.prohaker.client.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

import com.prohaker.client.core.Haker;
import com.prohaker.client.utils.Tickable;

public class Xray extends Mod implements Tickable{

    public Xray(Haker rc, Minecraft mc) {
        super(Mods.XRAY);
        minecraft = mc;
        haker = rc;
    }

    @Override
    public void onEnable() {
        haker.addToTick(this);
        haker.getUtils().addChatMessage(getActive());    
    }

    @Override
    public void onDisable() {
        haker.removeFromTick(this);
        haker.getUtils().addChatMessage(getActive());
    }

    @Override
    public void tick() {
        //wat do
    	
    	
    }


private Haker haker;
private Minecraft minecraft;
}