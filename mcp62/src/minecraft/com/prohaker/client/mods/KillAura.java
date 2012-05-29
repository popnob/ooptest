package com.prohaker.client.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;
import net.minecraft.src.*;
import net.minecraft.src.Packet7UseEntity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;

import com.prohaker.client.core.Haker;
import com.prohaker.client.utils.EntityUtils;
import com.prohaker.client.utils.Tickable;
import com.prohaker.client.utils.Watcher;

public class KillAura extends Mod implements Tickable {

    public KillAura(Haker rc, Minecraft mc) {
        super(Mods.KILLAURA);
        haker = rc;
        minecraft = mc;
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
        for(int i6 = 0; i6 < minecraft.theWorld.loadedEntityList.size(); i6++)
    	{
    	Entity e = (Entity) minecraft.theWorld.getLoadedEntityList().get(i6);
    	if((e != minecraft.thePlayer) && !e.isDead && minecraft.thePlayer.getDistanceSqToEntity(e) < 20D && e instanceof EntityLiving)
    	{
    		
    	    double d = e.posX - minecraft.thePlayer.posX;
    	    double d2 = e.posZ - minecraft.thePlayer.posZ;
    	    double d1 = e.posY - minecraft.thePlayer.posY;
    	    double d3 = MathHelper.sqrt_double(d * d + d2 * d2);
    	    float f = (float)((Math.atan2(d2, d) * 180D) / Math.PI) - 0F;
    	    float f1 = (float)(-((Math.atan2(d1, d3) * 180D) / Math.PI));
    	    
    	    minecraft.getSendQueue().addToSendQueue(new Packet12PlayerLook(f, f1, true));
    	    minecraft.getSendQueue().addToSendQueue(new Packet7UseEntity(0, e.entityId, 1));
    	    minecraft.getSendQueue().addToSendQueue(new Packet18Animation(minecraft.thePlayer, 1));
    	    

    	
            }
    	}
   
    }

    private Haker haker;
    private Minecraft minecraft;

}