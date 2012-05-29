package com.prohaker.client.core;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.prohaker.client.mods.Fullbright;
import com.prohaker.client.mods.KillAura;
import com.prohaker.client.mods.Radar;
import com.prohaker.client.utils.Tickable;
import com.prohaker.client.utils.Utils;
import com.prohaker.client.utils.Vars;
import com.prohaker.client.gui.*;
import com.prohaker.commands.GuiConsole;

import net.minecraft.client.Minecraft;

public class Haker {

    public Haker(Minecraft mc) {
        minecraft = mc;
        vars = new Vars();
        ingame = new InGame(mc);
        ck = new CheckKey(mc);
        
        init();
    }

    public void init() {
        utils = new Utils(minecraft);
        radar = new Radar(this, minecraft);
        fullbright = new Fullbright(this, minecraft);
        killaura = new KillAura(this, minecraft);
    }

    public void tick() {
        for (Tickable tick : tickables) {
            tick.tick();
        }
        checkForKeyPress();
    }

    public Utils getUtils() {
        return utils;
    }

    public void addToTick(Tickable tickable) {
        if (!tickables.contains(tickable)) {
            tickables.add(tickable);
        }
    }

    public void removeFromTick(Tickable tickable) {
        if (tickables.contains(tickable)) {
            tickables.remove(tickable);
        }
    }

    private void checkForKeyPress() {
        if (ck.checkKey(Keyboard.KEY_R)) {
            radar.toggle();
        }
        if (ck.checkKey(Keyboard.KEY_C)) {
            fullbright.toggle();
        }
        if(ck.checkKey(Keyboard.KEY_K)) {
            killaura.toggle();
        }
    }

    private KillAura killaura;
    private Radar radar;
    public static Vars vars;
    private Fullbright fullbright;
    private CheckKey ck;
    public static InGame ingame;
    private Utils utils;
    private Minecraft minecraft;
    private ArrayList<Tickable> tickables = new ArrayList<Tickable>();

}