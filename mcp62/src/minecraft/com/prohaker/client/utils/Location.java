package com.prohaker.client.utils;

import java.io.Serializable;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class Location implements Serializable {

    public Location(double x, double y, double z, Float pitch, Float yaw, World world) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.world = world;
    }

    public Location(Entity entity) {
        this(entity.posX, entity.posY, entity.posZ, entity.rotationPitch, entity.rotationYaw, entity.worldObj);
    }

    public Location(int x, int y, int z, World world) {
        this(x, y, z, null, null, world);
    }

    public Location(int x, int y, int z) {
        this(x, y, z, null, null, null);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getPitch() {
        return pitch;
    }

    public double getYaw() {
        return yaw;
    }

    public World getWorld() {
        return world;
    }

    public boolean compare(Location location) {
        if (x == location.x && y == location.y && z == location.z && pitch == location.pitch && yaw == location.yaw && world == location.world) {
            return true;
        }
        return false;
    }

    private final double x;
    private final double y;
    private final double z;
    private final Float pitch;
    private final Float yaw;
    private final World world;
    private static final long serialVersionUID = -4113933627848193372L;
    
    public float getDistance(Entity par1Entity)
    {
        float f = (float)(x - par1Entity.posX);
        float f1 = (float)(y - par1Entity.posY);
        float f2 = (float)(z - par1Entity.posZ);
        return MathHelper.sqrt_float(f * f + f1 * f1 + f2 * f2);
    }

}