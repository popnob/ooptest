package com.prohaker.client.utils;

import java.util.HashMap;

import net.minecraft.src.Entity;

public class EntityUtils {

    public static Watcher getLastAffected(Integer id) {
        Watcher entity = events.get(id);

        if(entity != null) {
            return entity;
        }

        return null;
    }

    public static void setLastAffected(Integer id, Entity entity) {

        long now = System.currentTimeMillis();

        Watcher eventWatcher = new Watcher(entity, now);

        events.put(id, eventWatcher);
    }

    private static HashMap<Integer, Watcher> events = new HashMap<Integer, Watcher>();

}