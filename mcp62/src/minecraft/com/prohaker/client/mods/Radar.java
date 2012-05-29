package com.prohaker.client.mods;

import java.util.ArrayList;

import org.lwjgl.util.Color;

import com.prohaker.client.core.Haker;
import com.prohaker.client.utils.Tickable;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityOtherPlayerMP;

public class Radar extends Mod implements Tickable{

    public Radar(Haker rc, Minecraft mc) {
        super(Mods.RADAR);
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
        ArrayList players = new ArrayList(minecraft.theWorld.playerEntities);
        
        int pos = 1;
        
        for(Object player : players) {
            if(player instanceof EntityOtherPlayerMP) {
                EntityOtherPlayerMP otherPlayer = (EntityOtherPlayerMP) player;
                String toDisplay = otherPlayer.username + " [" + Math.round(haker.getUtils().getPlayerDistanceFromEntity(otherPlayer)) + "]";
                minecraft.fontRenderer.drawString(toDisplay, 2, 8 * pos, Color.RED.getRed());
                pos++;
            }
        }
    }
    
    private Haker haker;
    private Minecraft minecraft;

}