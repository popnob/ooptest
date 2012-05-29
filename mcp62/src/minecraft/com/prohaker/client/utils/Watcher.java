package com.prohaker.client.utils;

import net.minecraft.src.Entity;

public class Watcher {

    public Watcher(Entity entity, long time) {
  this.entity = entity;
  this.time = time;
    }

    public boolean matches(Entity other, long now) {
  return other.entityId == entity.entityId
    && time > now - 200
    && other.getClass() == entity.getClass();
    }

    private Entity entity;
    private long time;
}