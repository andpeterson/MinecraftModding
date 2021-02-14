package com.andpeterson.twtutorial16.core.init;

import com.andpeterson.twtutorial16.TwTutorial;
import com.andpeterson.twtutorial16.common.items.SpecialItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TwTutorial.MOD_ID);
	
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC))
	);
	
	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item", 
			() -> new SpecialItem(new Item.Properties()
					.group(ItemGroup.MISC)
					.addToolType(ToolType.SHOVEL, 5)
					.maxDamage(200)
					.rarity(Rarity.EPIC)
					.isImmuneToFire()
			)
	);
	
	// Block Items (https://pastebin.com/AXTLGqmq)
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block", 
			() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> CUSTOM_BLOCK = ITEMS.register("custom_block", 
			() -> new BlockItem(BlockInit.CUSTOM_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
}
