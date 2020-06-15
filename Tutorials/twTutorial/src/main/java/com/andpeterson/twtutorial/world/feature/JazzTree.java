package com.andpeterson.twtutorial.world.feature;

import java.util.Random;

import com.andpeterson.twtutorial.init.NewBlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class JazzTree extends Tree {
	
	public static final TreeFeatureConfig JAZZ_TREE_CONFIG = (
			new TreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(NewBlockInit.JAZZ_LOG.get().getDefaultState()),
					new SimpleBlockStateProvider(NewBlockInit.JAZZ_LEAVES.get().getDefaultState()),
					new BlobFoliagePlacer(3, 0))
			).baseHeight(5)
			.heightRandA(7)
			.foliageHeight(3)
			.ignoreVines()
			.setSapling((IPlantable) NewBlockInit.JAZZ_SAPLING.get())
			.build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(JAZZ_TREE_CONFIG);
	}
}
