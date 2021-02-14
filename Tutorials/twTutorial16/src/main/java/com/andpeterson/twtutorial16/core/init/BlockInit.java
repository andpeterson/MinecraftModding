package com.andpeterson.twtutorial16.core.init;

import com.andpeterson.twtutorial16.TwTutorial;
import com.andpeterson.twtutorial16.common.blocks.CustomBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TwTutorial.MOD_ID);
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", 
			() -> new Block(AbstractBlock.Properties
					.create(Material.IRON, MaterialColor.PURPLE)
					.hardnessAndResistance(5.0f, 3.0f)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.sound(SoundType.ANVIL)
					.setRequiresTool()
			)
	);
	
	public static final RegistryObject<CustomBlock> CUSTOM_BLOCK = BLOCKS.register("custom_block", 
			() -> new CustomBlock(AbstractBlock.Properties.create(Material.WOOD). setRequiresTool()));
}
