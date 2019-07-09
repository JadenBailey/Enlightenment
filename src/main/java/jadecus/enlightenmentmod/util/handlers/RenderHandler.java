package jadecus.enlightenmentmod.util.handlers;

import jadecus.enlightenmentmod.entity.EntityHuman;
import jadecus.enlightenmentmod.entity.EntityIgnis;
import jadecus.enlightenmentmod.entity.render.RenderHuman;
import jadecus.enlightenmentmod.entity.render.RenderIgnis;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new IRenderFactory<EntityHuman>()
		{
			@Override
			public Render<? super EntityHuman> createRenderFor(RenderManager manager)
			{
				return new RenderHuman(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityIgnis.class, new IRenderFactory<EntityIgnis>()
		{
			@Override
			public Render<? super EntityIgnis> createRenderFor(RenderManager manager)
			{
				return new RenderIgnis(manager);
			}
		});
	}
}
