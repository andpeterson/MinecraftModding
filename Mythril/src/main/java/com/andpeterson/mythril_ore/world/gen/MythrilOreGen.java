package com.andpeterson.mythril_ore.world.gen;

import com.andpeterson.mythril_ore.MythrilOre;
import com.andpeterson.mythril_ore.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

//count = how common (20 = really common)
//bottomOffset = offset from the bottom of the world
//topOffset = offset from the top of the world
//maximum = max height that ore generates in (max - height)
// biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
public class MythrilOreGen {
	public static void generateOre() {
		MythrilOre.LOGGER.info("Generating Mythril Ores");
		for(Biome biome : ForgeRegistries.BIOMES) {
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE
					// .configure(new CountRangeConfig(1,0,0,8))
					.configure(new CountRangeConfig(20, 0, 0, 128));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.mythril_ore.getDefaultState(), 10))
					.withPlacement(customConfig));
		}
	}
}