package com.turtywurty.tutorialmod.objects.blocks;

import com.turtywurty.tutorialmod.init.ModTileEntityTypes;
import com.turtywurty.tutorialmod.tileentity.ExampleChestTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.stream.Stream;

public class ExampleChestBlock extends Block {

	private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(1, 9, 1, 15, 14, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
			Block.makeCuboidShape(7, 7, 0, 9, 11, 1)
	).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(1, 9, 1, 15, 14, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
			Block.makeCuboidShape(15, 7, 7, 16, 11, 9)
	).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(1, 9, 1, 15, 14, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
			Block.makeCuboidShape(7, 7, 15, 9, 11, 16)
	).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(1, 9, 1, 15, 14, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 9, 15),
			Block.makeCuboidShape(0, 7, 7, 1, 11, 9)
	).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public ExampleChestBlock(Properties properties) {
		super(Properties.create(Material.WOOD)
				.hardnessAndResistance(4.0f, 6.0f)
				.sound(SoundType.WOOD)
				.harvestLevel(0)
				.harvestTool(ToolType.AXE));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
			case NORTH:
				return SHAPE_N;
			case EAST:
				return SHAPE_E;
			case SOUTH:
				return SHAPE_S;
			case WEST:
				return SHAPE_W;
			default:
				return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0.6f;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.EXAMPLE_CHEST.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof ExampleChestTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (ExampleChestTileEntity) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof ExampleChestTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((ExampleChestTileEntity) te).getItems());
			}
		}
	}
}
