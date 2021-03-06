package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.tileentity.ExampleChestTileEntity;
import com.andpeterson.twtutorial.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, TWtutorial.MOD_ID);
	
	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry", () -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.QUARRY_BLOCK.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ExampleChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITY_TYPES.register("example_chest", () -> TileEntityType.Builder.create(ExampleChestTileEntity::new, BlockInit.EXAMPLE_CHEST.get()).build(null));
}
