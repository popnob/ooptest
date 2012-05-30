package com.prohaker.client.mods;

import java.util.ArrayList;

import org.lwjgl.util.Color;

import com.prohaker.client.core.Haker;
import com.prohaker.client.gui.InGame;
import com.prohaker.client.utils.Tickable;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityOtherPlayerMP;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ScaledResolution;

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
                int dis = (int) haker.getUtils().getPlayerDistanceFromEntity(otherPlayer);
                
                if (dis <= 20 && dis > 0) {
                	minecraft.fontRenderer.drawStringWithShadow(toDisplay, InGame.sc.getScaledWidth() - InGame.fr.getStringWidth(toDisplay) - 2, 12 * pos, 0xFF0000); }
                else if (dis <= 50 && dis > 20) {
                	minecraft.fontRenderer.drawStringWithShadow(toDisplay, InGame.sc.getScaledWidth() - InGame.fr.getStringWidth(toDisplay) - 2, 12 * pos, 0xFF6600);
                }
                else if ( dis > 50) {
                	minecraft.fontRenderer.drawStringWithShadow(toDisplay, InGame.sc.getScaledWidth() - InGame.fr.getStringWidth(toDisplay) - 2, 12 * pos, 0x33FF00);
                
                }
                
                
                pos++;
            }
        }
    }
    
    private Haker haker;
    private Minecraft minecraft;

}