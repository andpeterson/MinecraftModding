package com.andpeterson.mythril_ore.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MythrilTorchBlock extends Block{
	private static final VoxelShape SHAPE = Stream.of(
		Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
		Block.makeCuboidShape(6, 6, 6, 10, 7, 10),
		Block.makeCuboidShape(5, 7, 5, 7, 8, 7),
		Block.makeCuboidShape(4, 8, 4, 6, 9, 6),
		Block.makeCuboidShape(4, 9, 4, 5, 10, 5),
		Block.makeCuboidShape(3, 10, 3, 4, 11, 4),
		Block.makeCuboidShape(12, 10, 3, 13, 11, 4),
		Block.makeCuboidShape(11, 9, 4, 12, 10, 5),
		Block.makeCuboidShape(10, 8, 4, 12, 9, 6),
		Block.makeCuboidShape(9, 7, 5, 11, 8, 7),
		Block.makeCuboidShape(12, 10, 12, 13, 11, 13),
		Block.makeCuboidShape(11, 9, 11, 12, 10, 12),
		Block.makeCuboidShape(10, 8, 10, 12, 9, 12),
		Block.makeCuboidShape(9, 7, 9, 11, 8, 11),
		Block.makeCuboidShape(5, 7, 9, 7, 8, 11),
		Block.makeCuboidShape(4, 8, 10, 6, 9, 12),
		Block.makeCuboidShape(4, 9, 11, 5, 10, 12),
		Block.makeCuboidShape(3, 10, 12, 4, 11, 13),
		Block.makeCuboidShape(6, 10, 6, 10, 14, 10)
	).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

   public MythrilTorchBlock(Block.Properties properties) {
      super(properties);
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      return facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      return hasEnoughSolidSide(worldIn, pos.down(), Direction.UP);
   }

   /**
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      double d0 = (double)pos.getX() + 0.5D;
      double d1 = (double)pos.getY() + 0.7D;
      double d2 = (double)pos.getZ() + 0.5D;
      worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
      worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
   }
}
