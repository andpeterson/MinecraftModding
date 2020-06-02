package com.andpeterson.mythril_ore.init;

import com.andpeterson.mythril_ore.MythrilOre;
import com.andpeterson.mythril_ore.objects.blocks.MythrilTorchBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitDeferred {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MythrilOre.MOD_ID);

	public static final RegistryObject<Block> MYTHRIL_TORCH = BLOCKS.register("mythril_torch", () -> new MythrilTorchBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.0F,0.0F).lightValue(40).sound(SoundType.WOOD)));
}
