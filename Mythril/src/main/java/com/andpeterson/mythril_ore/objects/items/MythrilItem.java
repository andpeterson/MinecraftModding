package com.andpeterson.mythril_ore.objects.items;

import com.andpeterson.mythril_ore.MythrilOre;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class MythrilItem extends Item {
	// 2 minutes
	private int lifetimeTicks = 120;
	public MythrilItem(Properties properties) {
		super(properties);
	}
	
	/**
	* Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	* update it's contents.
	*/
	@Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
	   --this.lifetimeTicks;
	   if(this.lifetimeTicks <= 0) {
		   stack.shrink(1);
	   }
	   MythrilOre.LOGGER.debug("Mythril Timer: " + lifetimeTicks);
    }
    
	/*@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(keyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("Test Information"));
		} else {
			tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more info"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		//entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.example_block.getDefaultState());
		stack.
		return super.onEntityItemUpdate(stack, entity);
	}
	
	
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 600;
	}*/
	
}
