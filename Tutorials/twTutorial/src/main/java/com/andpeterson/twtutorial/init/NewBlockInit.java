package com.andpeterson.twtutorial.init;

import com.andpeterson.twtutorial.TWtutorial;
import com.andpeterson.twtutorial.objects.blocks.BlockQuarry;
import com.andpeterson.twtutorial.objects.blocks.ModPressurePlateBlock;
import com.andpeterson.twtutorial.objects.blocks.ModWoodButtonBlock;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NewBlockInit {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TWtutorial.MOD_ID);
	
//	// Define Blocks
//		public static final Block example_block = null;
//		// https://www.youtube.com/watch?v=taUfaVwDiyI - Custom Block Models
//		public static final Block special_block = null;
//		//@@Define
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<BlockQuarry> QUARRY_BLOCK = BLOCKS.register("quarry", () -> new BlockQuarry(Block.Properties.create(Material.IRON)));
	public static final RegistryObject<Block> EXAMPLE_STAIRS = BLOCKS.register("example_stairs", () -> new StairsBlock(()-> NewBlockInit.EXAMPLE_BLOCK.get().getDefaultState(), Block.Properties.create(Material.SAND)));
	public static final RegistryObject<Block> EXAMPLE_FENCE = BLOCKS.register("example_fence", () -> new FenceBlock(Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> EXAMPLE_BUTTON = BLOCKS.register("example_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
	public static final RegistryObject<Block> EXAMPLE_PRESSURE_PLATE = BLOCKS.register("example_pressure_plate", () -> new ModPressurePlateBlock(Sensitivity.EVERYTHING, Block.Properties.create(Material.SAND, MaterialColor.GOLD)));
}
