package net.minecraft.src;

import java.util.List;

public class WorldInfo
{
    /** Holds the seed of the currently world. */
    private long randomSeed;
    private WorldType terrainType;

    /** The player spawn X coordinate. */
    private int spawnX;

    /** The player spawn Y coordinate. */
    private int spawnY;

    /** The player spawn Z coordinate. */
    private int spawnZ;

    /** The current world time in range from 0 to 23999. */
    private long worldTime;

    /** The last time the player was in this world. */
    private long lastTimePlayed;

    /** The size of entire save of current world on the disk, isn't exactly. */
    private long sizeOnDisk;
    private NBTTagCompound playerTag;
    private int dimension;

    /** The name of the save defined at world creation. */
    private String levelName;

    /** Introduced in beta 1.3, is the save version for future control. */
    private int saveVersion;

    /** Is current raining? */
    private boolean raining;

    /** Number of ticks until next rain. */
    private int rainTime;

    /** Is thunderbolts failing now? */
    private boolean thundering;

    /** Number of ticks untils next thunderbolt. */
    private int thunderTime;

    /** Indicates the type of the game. 0 for survival, 1 for creative. */
    private int gameType;

    /** are map structures going to be generated (e.g. strongholds) */
    private boolean mapFeaturesEnabled;

    /** Hardcore mode flag */
    private boolean hardcore;

    public WorldInfo(NBTTagCompound par1NBTTagCompound)
    {
        terrainType = WorldType.DEFAULT;
        hardcore = false;
        randomSeed = par1NBTTagCompound.getLong("RandomSeed");

        if (par1NBTTagCompound.hasKey("generatorName"))
        {
            String s = par1NBTTagCompound.getString("generatorName");
            terrainType = WorldType.parseWorldType(s);

            if (terrainType == null)
            {
                terrainType = WorldType.DEFAULT;
            }
            else if (terrainType.func_48626_e())
            {
                int i = 0;

                if (par1NBTTagCompound.hasKey("generatorVersion"))
                {
                    i = par1NBTTagCompound.getInteger("generatorVersion");
                }

                terrainType = terrainType.func_48629_a(i);
            }
        }

        gameType = par1NBTTagCompound.getInteger("GameType");

        if (par1NBTTagCompound.hasKey("MapFeatures"))
        {
            mapFeaturesEnabled = par1NBTTagCompound.getBoolean("MapFeatures");
        }
        else
        {
            mapFeaturesEnabled = true;
        }

        spawnX = par1NBTTagCompound.getInteger("SpawnX");
        spawnY = par1NBTTagCompound.getInteger("SpawnY");
        spawnZ = par1NBTTagCompound.getInteger("SpawnZ");
        worldTime = par1NBTTagCompound.getLong("Time");
        lastTimePlayed = par1NBTTagCompound.getLong("LastPlayed");
        sizeOnDisk = par1NBTTagCompound.getLong("SizeOnDisk");
        levelName = par1NBTTagCompound.getString("LevelName");
        saveVersion = par1NBTTagCompound.getInteger("version");
        rainTime = par1NBTTagCompound.getInteger("rainTime");
        raining = par1NBTTagCompound.getBoolean("raining");
        thunderTime = par1NBTTagCompound.getInteger("thunderTime");
        thundering = par1NBTTagCompound.getBoolean("thundering");
        hardcore = par1NBTTagCompound.getBoolean("hardcore");

        if (par1NBTTagCompound.hasKey("Player"))
        {
            playerTag = par1NBTTagCompound.getCompoundTag("Player");
            dimension = playerTag.getInteger("Dimension");
        }
    }

    public WorldInfo(WorldSettings par1WorldSettings, String par2Str)
    {
        terrainType = WorldType.DEFAULT;
        hardcore = false;
        randomSeed = par1WorldSettings.getSeed();
        gameType = par1WorldSettings.getGameType();
        mapFeaturesEnabled = par1WorldSettings.isMapFeaturesEnabled();
        levelName = par2Str;
        hardcore = par1WorldSettings.getHardcoreEnabled();
        terrainType = par1WorldSettings.getTerrainType();
    }

    public WorldInfo(WorldInfo par1WorldInfo)
    {
        terrainType = WorldType.DEFAULT;
        hardcore = false;
        randomSeed = par1WorldInfo.randomSeed;
        terrainType = par1WorldInfo.terrainType;
        gameType = par1WorldInfo.gameType;
        mapFeaturesEnabled = par1WorldInfo.mapFeaturesEnabled;
        spawnX = par1WorldInfo.spawnX;
        spawnY = par1WorldInfo.spawnY;
        spawnZ = par1WorldInfo.spawnZ;
        worldTime = par1WorldInfo.worldTime;
        lastTimePlayed = par1WorldInfo.lastTimePlayed;
        sizeOnDisk = par1WorldInfo.sizeOnDisk;
        playerTag = par1WorldInfo.playerTag;
        dimension = par1WorldInfo.dimension;
        levelName = par1WorldInfo.levelName;
        saveVersion = par1WorldInfo.saveVersion;
        rainTime = par1WorldInfo.rainTime;
        raining = par1WorldInfo.raining;
        thunderTime = par1WorldInfo.thunderTime;
        thundering = par1WorldInfo.thundering;
        hardcore = par1WorldInfo.hardcore;
    }

    /**
     * Gets the NBTTagCompound for the worldInfo
     */
    public NBTTagCompound getNBTTagCompound()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        updateTagCompound(nbttagcompound, playerTag);
        return nbttagcompound;
    }

    /**
     * Generates the NBTTagCompound for the world info plus the provided entity list. Arg: entityList
     */
    public NBTTagCompound getNBTTagCompoundWithPlayers(List par1List)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        EntityPlayer entityplayer = null;
        NBTTagCompound nbttagcompound1 = null;

        if (par1List.size() > 0)
        {
            entityplayer = (EntityPlayer)par1List.get(0);
        }

        if (entityplayer != null)
        {
            nbttagcompound1 = new NBTTagCompound();
            entityplayer.writeToNBT(nbttagcompound1);
        }

        updateTagCompound(nbttagcompound, nbttagcompound1);
        return nbttagcompound;
    }

    private void updateTagCompound(NBTTagCompound par1NBTTagCompound, NBTTagCompound par2NBTTagCompound)
    {
        par1NBTTagCompound.setLong("RandomSeed", randomSeed);
        par1NBTTagCompound.setString("generatorName", terrainType.func_48628_a());
        par1NBTTagCompound.setInteger("generatorVersion", terrainType.getGeneratorVersion());
        par1NBTTagCompound.setInteger("GameType", gameType);
        par1NBTTagCompound.setBoolean("MapFeatures", mapFeaturesEnabled);
        par1NBTTagCompound.setInteger("SpawnX", spawnX);
        par1NBTTagCompound.setInteger("SpawnY", spawnY);
        par1NBTTagCompound.setInteger("SpawnZ", spawnZ);
        par1NBTTagCompound.setLong("Time", worldTime);
        par1NBTTagCompound.setLong("SizeOnDisk", sizeOnDisk);
        par1NBTTagCompound.setLong("LastPlayed", System.currentTimeMillis());
        par1NBTTagCompound.setString("LevelName", levelName);
        par1NBTTagCompound.setInteger("version", saveVersion);
        par1NBTTagCompound.setInteger("rainTime", rainTime);
        par1NBTTagCompound.setBoolean("raining", raining);
        par1NBTTagCompound.setInteger("thunderTime", thunderTime);
        par1NBTTagCompound.setBoolean("thundering", thundering);
        par1NBTTagCompound.setBoolean("hardcore", hardcore);

        if (par2NBTTagCompound != null)
        {
            par1NBTTagCompound.setCompoundTag("Player", par2NBTTagCompound);
        }
    }

    /**
     * Returns the seed of current world.
     */
    public long getSeed()
    {
        return randomSeed;
    }

    /**
     * Returns the x spawn position
     */
    public int getSpawnX()
    {
        return spawnX;
    }

    /**
     * Return the Y axis spawning point of the player.
     */
    public int getSpawnY()
    {
        return spawnY;
    }

    /**
     * Returns the z spawn position
     */
    public int getSpawnZ()
    {
        return spawnZ;
    }

    /**
     * Get current world time
     */
    public long getWorldTime()
    {
        return worldTime;
    }

    public long getSizeOnDisk()
    {
        return sizeOnDisk;
    }

    /**
     * Returns the player's NBTTagCompound to be loaded
     */
    public NBTTagCompound getPlayerNBTTagCompound()
    {
        return playerTag;
    }

    public int getDimension()
    {
        return dimension;
    }

    /**
     * Set the x spawn position to the passed in value
     */
    public void setSpawnX(int par1)
    {
        spawnX = par1;
    }

    /**
     * Sets the y spawn position
     */
    public void setSpawnY(int par1)
    {
        spawnY = par1;
    }

    /**
     * Set the z spawn position to the passed in value
     */
    public void setSpawnZ(int par1)
    {
        spawnZ = par1;
    }

    /**
     * Set current world time
     */
    public void setWorldTime(long par1)
    {
        worldTime = par1;
    }

    /**
     * Sets the player's NBTTagCompound to be loaded.
     */
    public void setPlayerNBTTagCompound(NBTTagCompound par1NBTTagCompound)
    {
        playerTag = par1NBTTagCompound;
    }

    /**
     * Sets the spawn position Args: x, y, z
     */
    public void setSpawnPosition(int par1, int par2, int par3)
    {
        spawnX = par1;
        spawnY = par2;
        spawnZ = par3;
    }

    /**
     * Get current world name
     */
    public String getWorldName()
    {
        return levelName;
    }

    public void setWorldName(String par1Str)
    {
        levelName = par1Str;
    }

    /**
     * Returns the save version of this world
     */
    public int getSaveVersion()
    {
        return saveVersion;
    }

    /**
     * Sets the save version of the world
     */
    public void setSaveVersion(int par1)
    {
        saveVersion = par1;
    }

    /**
     * Return the last time the player was in this world.
     */
    public long getLastTimePlayed()
    {
        return lastTimePlayed;
    }

    /**
     * Returns the current state of thunderbolts.
     */
    public boolean isThundering()
    {
        return thundering;
    }

    /**
     * Defines if is thundering now.
     */
    public void setThundering(boolean par1)
    {
        thundering = par1;
    }

    /**
     * Returns the number of ticks until next thunderbolt.
     */
    public int getThunderTime()
    {
        return thunderTime;
    }

    /**
     * Defines the number of ticks until next thunderbolt.
     */
    public void setThunderTime(int par1)
    {
        thunderTime = par1;
    }

    /**
     * Gets the current state of raining.
     */
    public boolean isRaining()
    {
        return raining;
    }

    /**
     * Sets the current state of raining.
     */
    public void setRaining(boolean par1)
    {
        raining = par1;
    }

    /**
     * Return the number of ticks until rain.
     */
    public int getRainTime()
    {
        return rainTime;
    }

    /**
     * Sets the number of ticks until rain.
     */
    public void setRainTime(int par1)
    {
        rainTime = par1;
    }

    /**
     * Get the game type, 0 for survival, 1 for creative.
     */
    public int getGameType()
    {
        return gameType;
    }

    /**
     * are map structures going to be generated (e.g. strongholds)
     */
    public boolean isMapFeaturesEnabled()
    {
        return mapFeaturesEnabled;
    }

    /**
     * Returns true if hardcore mode is enabled, otherwise false
     */
    public boolean isHardcoreModeEnabled()
    {
        return hardcore;
    }

    public WorldType getTerrainType()
    {
        return terrainType;
    }

    public void setTerrainType(WorldType par1WorldType)
    {
        terrainType = par1WorldType;
    }
}
