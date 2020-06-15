package com.andpeterson.twtutorial.util.helpers;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.client.gui.ExampleChestScreen;
import com.andpeterson.twtutorial.init.ModContainerTypes;
import com.andpeterson.twtutorial.init.NewBlockInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TWtutorial.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.EXAMPLE_CHEST.get(), ExampleChestScreen::new);
		RenderTypeLookup.setRenderLayer(NewBlockInit.JAZZ_SAPLING.get(), RenderType.getCutout());
	}
}
