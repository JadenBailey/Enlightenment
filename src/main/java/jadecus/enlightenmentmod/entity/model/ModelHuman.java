package jadecus.enlightenmentmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelHuman extends ModelBase 
{
    public ModelRenderer LeftArmOuter;
    public ModelRenderer RightLegOuter;
    public ModelRenderer RightArmOuter;
    public ModelRenderer HeadOuter;
    public ModelRenderer LeftLegOuter;
    public ModelRenderer RightArm;
    public ModelRenderer RightLeg;
    public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer BodyOuter;
    public ModelRenderer Head;

    public ModelHuman() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftArmOuter = new ModelRenderer(this, 48, 48);
        this.LeftArmOuter.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArmOuter.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.HeadOuter = new ModelRenderer(this, 32, 0);
        this.HeadOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HeadOuter.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.RightArm = new ModelRenderer(this, 40, 16);
        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.BodyOuter = new ModelRenderer(this, 16, 32);
        this.BodyOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyOuter.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F);
        this.RightLeg = new ModelRenderer(this, 0, 16);
        this.RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LeftLegOuter = new ModelRenderer(this, 0, 48);
        this.LeftLegOuter.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LeftLegOuter.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.LeftLeg = new ModelRenderer(this, 16, 48);
        this.LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightLegOuter = new ModelRenderer(this, 0, 32);
        this.RightLegOuter.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.RightLegOuter.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F);
        this.RightArmOuter = new ModelRenderer(this, 40, 32);
        this.RightArmOuter.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArmOuter.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F);
        this.LeftArm = new ModelRenderer(this, 32, 48);
        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.LeftArmOuter.render(f5);
        this.HeadOuter.render(f5);
        this.RightArm.render(f5);
        this.Body.render(f5);
        this.BodyOuter.render(f5);
        this.RightLeg.render(f5);
        this.LeftLegOuter.render(f5);
        this.LeftLeg.render(f5);
        this.RightLegOuter.render(f5);
        this.RightArmOuter.render(f5);
        this.LeftArm.render(f5);
        this.Head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
    	this.LeftArmOuter.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount;
    	
    	this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;
    	this.RightArmOuter.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount;
    	
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LeftLegOuter.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RightLegOuter.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    	this.HeadOuter.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.HeadOuter.rotateAngleX = headPitch * 0.017453292F;
    }
}
