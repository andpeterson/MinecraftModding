package com.andpeterson.twtutorial.objects.items;

import java.util.List;

import com.andpeterson.twtutorial.init.BlockInit;
import com.andpeterson.twtutorial.world.dimension.ExampleDimension;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class TeleportItem extends Item{
	public TeleportItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Teleports Player"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.changeDimension(ExampleDimension.dimensionType);
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
