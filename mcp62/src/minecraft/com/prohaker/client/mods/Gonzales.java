package com.prohaker.client.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

import com.prohaker.client.core.Haker;
import com.prohaker.client.utils.Tickable;

public class Gonzales extends Mod implements Tickable{

    public Gonzales(Haker rc, Minecraft mc) {
        super(Mods.GONZALES);
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
    	//Wat do
    	//curBlockDamageMP += block.blockStrength(minecraft.thePlayer) * 1.6F;
        ///blockHitDelay = 0;
    	
    	
    }


private Haker haker;
private Minecraft minecraft;
}