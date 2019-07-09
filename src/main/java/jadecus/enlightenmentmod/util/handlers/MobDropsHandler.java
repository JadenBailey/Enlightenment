package jadecus.enlightenmentmod.util.handlers;

import jadecus.enlightenmentmod.init.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropsHandler 
{
	/**
	* Custom Mob Drops
	*/
	
	@SubscribeEvent
	public void customMobDrops(LivingDropsEvent event)
	{
		if(event.getEntity() instanceof EntityLiving)
		{
			ItemStack stack = new ItemStack(ModItems.MANA_ORB);
			EntityItem drop = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			
			event.getDrops().add(drop);
		}
	}
}
