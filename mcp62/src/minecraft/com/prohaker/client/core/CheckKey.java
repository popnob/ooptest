package com.prohaker.client.core;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class CheckKey {

    public CheckKey(Minecraft minecraft) {
        mc = minecraft;
    }
    
    public boolean checkKey(int i) {
        if (mc.currentScreen != null) {
            return false;
        }
        if (Keyboard.isKeyDown(i) != keyStates[i]) {
            return keyStates[i] = !keyStates[i];
        } else {
            return false;
        }
    }

    private Minecraft mc;
    private boolean keyStates[] = new boolean[256];
}