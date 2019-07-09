package jadecus.enlightenmentmod.init;

import jadecus.enlightenmentmod.Main;
import jadecus.enlightenmentmod.entity.EntityHuman;
import jadecus.enlightenmentmod.entity.EntityIgnis;
import jadecus.enlightenmentmod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit extends EntityLiving
{
	public EntityInit(World worldIn) 
	{
		super(worldIn);
	}

	public static void registerEntities() 
	{
		registerEntity("human", EntityHuman.class, Reference.ENTITY_HUMAN, 50, 4299501, 15497697);
		registerEntity("ignis", EntityIgnis.class, Reference.ENTITY_IGNIS, 50, 5242880, 16723456);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) 
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(1));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(2));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(3));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(4));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(5));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(6));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(14));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(17));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(18));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(19));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(20));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(21));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(22));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(27));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(28));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(29));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(30));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(31));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(32));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(33));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(34));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(35));
		EntityRegistry.addSpawn(EntityHuman.class, 10, 1, 5, EnumCreatureType.CREATURE, Biome.getBiomeForId(37));
		
		EntityRegistry.addSpawn(EntityIgnis.class, 1, 0, 1, EnumCreatureType.CREATURE, Biome.getBiomeForId(8));
	}
}
