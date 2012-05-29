package net.minecraft.src;

public enum EnumCreatureType
{
    monster(net.minecraft.src.IMob.class, 70, Material.air, false),
    creature(net.minecraft.src.EntityAnimal.class, 15, Material.air, true),
    waterCreature(net.minecraft.src.EntityWaterMob.class, 5, Material.water, true);

    /**
     * The root class of creatures associated with this EnumCreatureType (IMobs for aggressive creatures, EntityAnimals
     * for friendly ones)
     */
    private final Class creatureClass;
    private final int maxNumberOfCreature;
    private final Material creatureMaterial;

    /** A flag indicating whether this creature type is peaceful. */
    private final boolean isPeacefulCreature;

    private EnumCreatureType(Class par3Class, int par4, Material par5Material, boolean par6)
    {
        creatureClass = par3Class;
        maxNumberOfCreature = par4;
        creatureMaterial = par5Material;
        isPeacefulCreature = par6;
    }

    public Class getCreatureClass()
    {
        return creatureClass;
    }

    public int getMaxNumberOfCreature()
    {
        return maxNumberOfCreature;
    }

    public Material getCreatureMaterial()
    {
        return creatureMaterial;
    }

    /**
     * Gets whether or not this creature type is peaceful.
     */
    public boolean getPeacefulCreature()
    {
        return isPeacefulCreature;
    }
}
