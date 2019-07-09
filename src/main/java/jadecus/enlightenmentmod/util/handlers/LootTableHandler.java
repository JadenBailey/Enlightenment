package jadecus.enlightenmentmod.util.handlers;

import jadecus.enlightenmentmod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation HUMAN = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "human"));
	public static final ResourceLocation IGNIS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "ignis"));
}