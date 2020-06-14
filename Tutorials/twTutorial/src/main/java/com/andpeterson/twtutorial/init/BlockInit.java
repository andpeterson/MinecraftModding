package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.TWtutorial.TWtutorialItemGroup;
import com.andpeterson.twtutorial.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TWtutorial.MOD_ID)
@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	
	// Define Blocks
	//public static final Block example_block = null;
	// https://www.youtube.com/watch?v=taUfaVwDiyI - Custom Block Models
	public static final Block special_block = null;
	//@@Define
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		//event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)).setRegistryName("example_block"));
		event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(4).slipperiness(1.2f).speedFactor(0.7f).noDrops()).setRegistryName("special_block"));
		//@@RegisterBlock
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
		//event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(16).group(TWtutorialItemGroup.instance)).setRegistryName("example_block"));
		event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(TWtutorialItemGroup.instance)).setRegistryName("special_block"));
		//@@RegisterItem
	}
}
