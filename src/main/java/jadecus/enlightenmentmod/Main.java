package jadecus.enlightenmentmod;

import jadecus.enlightenmentmod.proxy.CommonProxy;
import jadecus.enlightenmentmod.util.Reference;
import jadecus.enlightenmentmod.util.handlers.MobDropsHandler;
import jadecus.enlightenmentmod.util.handlers.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
		MinecraftForge.EVENT_BUS.register(new MobDropsHandler());
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event){}
}
