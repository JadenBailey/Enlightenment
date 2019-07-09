package jadecus.enlightenmentmod.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import io.netty.buffer.ByteBuf;
import jadecus.enlightenmentmod.util.handlers.LootTableHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityHuman extends EntityWolf implements IEntityAdditionalSpawnData
{
	private int texture_index;
	
	public EntityHuman(World worldIn) 
	{
		super(worldIn);
		this.setSize(0.6F, 1.95F);
		this.setTamed(false);
		this.texture_index = rand.nextInt(2);
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIBeg(this, 8.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAnimal.class, false, new Predicate<Entity>()
        {
            public boolean apply(@Nullable Entity p_apply_1_)
            {
                return p_apply_1_ instanceof EntitySheep || p_apply_1_ instanceof EntityRabbit;
            }
        }));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
		
		if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		
	}
	
	@Override
	public float getEyeHeight() 
	{
		return 1.75F;
	}
	
	public int getTextureIndex()
	{
		return this.texture_index;
	}
	
	@Override
	public EntityWolf createChild(EntityAgeable ageable)
	{
		EntityHuman entityhuman = new EntityHuman(this.world);
        UUID uuid = this.getOwnerId();

        if (uuid != null)
        {
            entityhuman.setOwnerId(uuid);
            entityhuman.setTamed(true);
        }

        return entityhuman;
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.HUMAN;
	}
	
	@Override
	protected SoundEvent getAmbientSound()
	{
		if (this.isAngry())
        {
            return SoundEvents.ENTITY_WOLF_GROWL;
        }
        else if (this.rand.nextInt(3) == 0)
        {
            return SoundEvents.ENTITY_WOLF_PANT;
        }
        else
        {
        	return SoundEvents.ENTITY_ILLUSION_ILLAGER_AMBIENT;
        }
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) 
	{
		return SoundEvents.ENTITY_PLAYER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return SoundEvents.ENTITY_PLAYER_DEATH;
	}
	
	@Override
	public void setTamed(boolean tamed)
    {
        super.setTamed(tamed);

        if (tamed)
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }

        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed())
        {
        	float f = (float)this.getEntityBoundingBox().minY;
			float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
			float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((EntityLivingBase)null);
            }

    		if(this.isSitting())
        	{
        		this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
        	}
        	else
        	{
        		this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
        	}
        	
        }
        else if (itemstack.getItem() == Items.BONE && !this.isAngry())
        {
            return false;
        }
        else if (itemstack.getItem() == Items.IRON_INGOT && !this.isAngry())
        {
            if (!player.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player))
                {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    player.sendMessage(new TextComponentString("Your follower is waiting."));
                    this.setHealth(40.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

	@Override
	public void writeSpawnData(ByteBuf buffer) 
	{
		buffer.writeInt(this.texture_index);
	}

	@Override
	public void readSpawnData(ByteBuf buffer) 
	{
		this.texture_index = buffer.readInt();
	}
}
