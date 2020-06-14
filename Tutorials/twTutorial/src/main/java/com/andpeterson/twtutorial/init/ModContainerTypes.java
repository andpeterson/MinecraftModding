package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.container.ExampleChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, TWtutorial.MOD_ID);
	
	public static final RegistryObject<ContainerType<ExampleChestContainer>> EXAMPLE_CHEST = CONTAINER_TYPES
			.register("example_chest", () -> IForgeContainerType.create(ExampleChestContainer::new));
}
