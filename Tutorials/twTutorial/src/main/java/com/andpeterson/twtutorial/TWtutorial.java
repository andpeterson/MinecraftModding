package com.andpeterson.twtutorial;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.andpeterson.twtutorial.init.BiomeInit;
import com.andpeterson.twtutorial.init.BlockInit;
import com.andpeterson.twtutorial.init.DimensionInit;
import com.andpeterson.twtutorial.init.ItemInit;
import com.andpeterson.twtutorial.init.ModContainerTypes;
import com.andpeterson.twtutorial.init.ModTileEntityTypes;
import com.andpeterson.twtutorial.init.NewBlockInit;
import com.andpeterson.twtutorial.init.NewItemInit;
import com.andpeterson.twtutorial.world.gen.TutorialOreGen;

@Mod("twtutorial")
@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.MOD)
public class TWtutorial
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "twtutorial";
    public static TWtutorial instance;
    public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(MOD_ID, "example");

    public TWtutorial() {
    	final IEventBus modEventBus =  FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	
    	NewItemInit.ITEMS.register(modEventBus);
    	NewBlockInit.BLOCKS.register(modEventBus);
    	ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    	
    	
    	BiomeInit.BIOMES.register(modEventBus);
    	DimensionInit.MOD_DIMENSIONS.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	NewBlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(TWtutorialItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems!");
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	TutorialOreGen.generateOre();
    }
    


    public static class TWtutorialItemGroup extends ItemGroup {
    	
    	public static final TWtutorialItemGroup instance = new TWtutorialItemGroup(ItemGroup.GROUPS.length, "twtutorialtab");
    	
    	private TWtutorialItemGroup(int index, String label) {
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(ItemInit.AndpetersonTablet);
    	}
    }
    //@@DefineItemGroup
}
