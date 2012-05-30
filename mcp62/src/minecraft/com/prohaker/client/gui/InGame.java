package com.prohaker.client.gui;

import com.prohaker.client.mods.Mods;
import com.prohaker.client.utils.Vars;

import net.minecraft.client.*;
import net.minecraft.src.*;

public class InGame extends Methods {
	
	public static Minecraft mc;
	public static FontRenderer fr;
	public static ScaledResolution sc;
	
	public static int W;
	public static int H;
	
	public InGame(Minecraft minecraft) {
		mc = minecraft;
		
		fr = mc.fontRenderer;
		sc = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		
		W = sc.getScaledWidth();
		H = sc.getScaledHeight();
	}
	
public static void renderGameOverlay(){
	fr.drawStringWithShadow("pro haker", 2, 2, 0xffff);

if(Vars.coords){
    int x = (int) mc.thePlayer.posX;
    int y = (int) mc.thePlayer.posY;
    int z = (int) mc.thePlayer.posZ;
    fr.drawStringWithShadow("X: " + x, 2, 12, 0xFF0000);
    fr.drawStringWithShadow("Y: " + y, 2, 22, 0xFF0000);
    fr.drawStringWithShadow("Z: " + z, 2, 32, 0xFF0000);
    	}
	
	

		int Gui = 1;
		int Colour = 0xFFFFFFFF;
		int Pos = 12 * Gui;
		int yy = 32;
		if(Vars.fullbright){fr.drawStringWithShadow("\2472Fullbright\247f", 2, yy += 10, 0xffffff);}
		if(Vars.radar){fr.drawStringWithShadow("\2472Radar\247f", 2, yy += 10, 0xffffff);}
		if(Vars.killaura){fr.drawStringWithShadow("\2472Aura\247f", 2, yy += 10, 0xffffff);}
	}
}

