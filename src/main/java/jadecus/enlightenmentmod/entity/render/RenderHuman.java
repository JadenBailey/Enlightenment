package jadecus.enlightenmentmod.entity.render;

import jadecus.enlightenmentmod.entity.EntityHuman;
import jadecus.enlightenmentmod.entity.model.ModelHuman;
import jadecus.enlightenmentmod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHuman extends RenderLiving<EntityHuman> 
{
	public RenderHuman(RenderManager manager) 
	{
		super(manager, new ModelHuman(), 0.5f);
	}
	
	private static final ResourceLocation[] textures = new ResourceLocation[2];
	static
	{
		for(int i = 0; i < 2; i++)
		{
			textures[i] = new ResourceLocation(Reference.MOD_ID + ":textures/entity/human_" + i + ".png");
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHuman entity) 
	{
		int index = entity.getTextureIndex();
		return textures[index];
	}
	
	@Override
	protected void applyRotations(EntityHuman entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
