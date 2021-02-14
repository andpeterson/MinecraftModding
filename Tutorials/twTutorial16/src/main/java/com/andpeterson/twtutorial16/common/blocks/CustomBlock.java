package com.andpeterson.twtutorial16.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class CustomBlock extends BaseHorizontalBlock {
	
	private static final VoxelShape SHAPE = Stream.of(
			Block.makeCuboidShape(6, 0, 0, 16, 1, 6),
			Block.makeCuboidShape(0, 1, 2, 10, 2, 8),
			Block.makeCuboidShape(6, 2, 4, 16, 3, 10),
			Block.makeCuboidShape(0, 3, 6, 10, 4, 12),
			Block.makeCuboidShape(6, 4, 8, 16, 5, 16),
			Block.makeCuboidShape(0, 5, 10, 10, 6, 16),
			Block.makeCuboidShape(0, 5, 10, 10, 6, 16),
			Block.makeCuboidShape(1, 0, 3, 2, 1, 7),
			Block.makeCuboidShape(1, 0, 8, 2, 3, 11),
			Block.makeCuboidShape(1, 0, 12, 2, 5, 15),
			Block.makeCuboidShape(14, 0, 6, 15, 2, 9),
			Block.makeCuboidShape(14, 0, 10, 15, 4, 15),
			Block.makeCuboidShape(7, 0, 6, 9, 1, 7),
			Block.makeCuboidShape(7, 0, 8, 9, 2, 9),
			Block.makeCuboidShape(7, 0, 10, 9, 3, 11),
			Block.makeCuboidShape(7, 0, 12, 9, 4, 13),
			Block.makeCuboidShape(7, 0, 14, 9, 5, 15)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public CustomBlock(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));
	}
	
}
