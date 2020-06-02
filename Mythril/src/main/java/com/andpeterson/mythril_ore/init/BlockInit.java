package com.andpeterson.mythril_ore.init;

import com.andpeterson.mythril_ore.MythrilOre;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MythrilOre.MOD_ID)
@Mod.EventBusSubscriber(modid = MythrilOre.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	
	// Define Blocks
	public static final Block mythril_ore = null;
	//@@Define
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)).setRegistryName("mythril_ore"));
		//@@RegisterBlock
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(mythril_ore, new Item.Properties().maxStackSize(64).group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mythril_ore"));
		//@@RegisterItem
	}
}
