package com.prohaker.client.utils;


import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;

public class Utils {

    public Utils(Minecraft mc) {
        minecraft = mc;
    }
    
        // Another Convenience method
    public double getPlayerDistanceFromEntity(Entity ent) {
        Entity player = minecraft.thePlayer;
        Location playerLoc = new Location(player);
        return playerLoc.getDistance(ent);
    }
    
        // Used to append the [RzaCraft] to the chat message
    public void addChatMessage(String message) {
        String toSend = ChatColour.DARK_RED + "[ProHaker] " + message;
        minecraft.thePlayer.addChatMessage(toSend);
    }
    
    private Minecraft minecraft;
    
}