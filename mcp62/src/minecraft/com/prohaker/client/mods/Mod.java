package com.prohaker.client.mods;

import com.prohaker.client.utils.ChatColour;

public abstract class Mod {
    
    public Mod(Mods mod) {
        this.mod = mod;
        name = mod.getName();
    }
    
    public final void turnOn() {
        active = true;
        onEnable();
    }
    
    public final void turnOff() {
        active = false;
        onDisable();
    }
    
    public final void toggle() {
        active = !active;
        if(active) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public final boolean isActive() {
        return active;
    }
    
    public final String getActive() {
        if(active) {
            return ChatColour.WHITE + name + ChatColour.GREEN + " Active";
        } else {
            return ChatColour.WHITE + name + ChatColour.RED + " Inactive";
        }
    }
    
    public abstract void onEnable();
    public abstract void onDisable();
    
    private Mods mod;
    private String name;
    private boolean active = false;
}