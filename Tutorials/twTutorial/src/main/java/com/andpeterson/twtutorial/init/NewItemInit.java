package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.TWtutorial.TWtutorialItemGroup;
import com.andpeterson.twtutorial.objects.items.SpecialItem;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NewItemInit {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TWtutorial.MOD_ID);
	
//	//Define Items
//		public static final Item itemOne = null;
//		public static final Item itemTwo = null;
//		public static final Item AndpetersonTablet = null;
//		public static final Item NewItemEight = null;
//		public static final Item ExampleFood = null;
//		public static final Item SpecialItem = null;
//		
//		//Tools
//		public static final Item ExampleSword = null;
//		public static final Item ExamplePickax = null;
//		public static final Item ExampleShavel = null;
//		public static final Item ExampleAx = null;
//		public static final Item ExampleHoe = null;
//		public static final Item NewToolName = null;
//		//@@Define
	
	public static final RegistryObject<SpecialItem> DEF_ITEMS = ITEMS.register("def_item", () -> new SpecialItem(new Item.Properties().group(TWtutorialItemGroup.instance)));
}
