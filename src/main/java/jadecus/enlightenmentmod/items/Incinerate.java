package jadecus.enlightenmentmod.items;

import jadecus.enlightenmentmod.Main;
import jadecus.enlightenmentmod.init.ModItems;
import jadecus.enlightenmentmod.util.IHasModel;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Incinerate extends Item implements IHasModel 
{
	public Incinerate(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	// Firing Fireball
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack item = playerIn.getHeldItem(handIn);
		if(playerIn.experienceLevel >= 1) 
		{
			playerIn.addExperienceLevel(-1);
			
			playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 1200, 10)); // Fire Resistance
			
			if(!worldIn.isRemote) 
			{
				worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				Vec3d aim = playerIn.getLookVec();
				EntityLargeFireball fireball = new EntityLargeFireball(worldIn, playerIn, 1, 1, 1);
				
				fireball.setPosition(playerIn.posX + aim.x * 1.5, playerIn.posY + aim.y * 1.5 + 2, playerIn.posZ + aim.z * 1.5);
				fireball.accelerationX = aim.x * 0.1; fireball.accelerationY = aim.y * 0.1; fireball.accelerationZ = aim.z * 0.1;
				
				worldIn.spawnEntity(fireball);
				
			}
			
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
		}
		else 
		{
			return new ActionResult<ItemStack>(EnumActionResult.PASS, item);
		}
	}
	
	// Right click on ground to make fire
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 1200, 10)); // Fire Resistance
		
		pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            if (worldIn.isAirBlock(pos))
            {
                worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 11);
            }

            if (player instanceof EntityPlayerMP)
            {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
            }

            return EnumActionResult.SUCCESS;
        }
	}
	
	// Sets entity on fire on left click
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		target.setFire(10);
		return true;
	}
	
	// For the looks
	@Override
	public EnumRarity getRarity(ItemStack stack) 
	{
		return EnumRarity.RARE;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
}
