package jadecus.enlightenmentmod.entity.render;

import jadecus.enlightenmentmod.entity.EntityIgnis;
import jadecus.enlightenmentmod.entity.model.ModelHuman;
import jadecus.enlightenmentmod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIgnis extends RenderLiving<EntityIgnis> 
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ignis.png");
	
	public RenderIgnis(RenderManager manager) 
	{
		super(manager, new ModelHuman(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityIgnis entity) 
	{
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityIgnis entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
