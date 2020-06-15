package com.andpeterson.twtutorial.objects.items;

import java.util.List;

import com.andpeterson.twtutorial.init.BlockInit;
import com.andpeterson.twtutorial.util.helpers.keyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item{
	public SpecialItem(Properties properties) {
		super(properties);
	}
	
	@Override
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
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 500, 255));
		worldIn.setRainStrength(1.0f);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		//entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.example_block.getDefaultState());
		entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.EXAMPLE_BLOCK.get().getDefaultState());
		return super.onEntityItemUpdate(stack, entity);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 600;
	}
}
