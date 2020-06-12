package com.andpeterson.twtutorial.util;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {
	
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if(DimensionType.byName(TWtutorial.EXAMPLE_DIM_TYPE) == null) {
			DimensionManager.registerDimension(TWtutorial.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null, true);
		}
		
		TWtutorial.LOGGER.info("Dimensions Registered!");
	}
}
