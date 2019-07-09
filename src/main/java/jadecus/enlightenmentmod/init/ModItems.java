package jadecus.enlightenmentmod.init;

import java.util.ArrayList;
import java.util.List;

import jadecus.enlightenmentmod.items.Incinerate;
import jadecus.enlightenmentmod.items.ItemBase;
import net.minecraft.item.Item;

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item MANA_ORB = new ItemBase("mana_orb");
	public static final Item INCINERATE = new Incinerate("incinerate");
}
