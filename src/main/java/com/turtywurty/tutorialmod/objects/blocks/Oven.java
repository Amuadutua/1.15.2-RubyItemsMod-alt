package com.turtywurty.tutorialmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(3, 9, 0, 6, 16, 3),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 1, 1),
            Block.makeCuboidShape(0, 1, 0, 2, 2, 1),
            Block.makeCuboidShape(15, 0, 0, 16, 1, 1),
            Block.makeCuboidShape(14, 1, 0, 16, 2, 1),
            Block.makeCuboidShape(1, 1, 1, 15, 8, 15),
            Block.makeCuboidShape(0, 0, 15, 1, 1, 16),
            Block.makeCuboidShape(0, 1, 15, 2, 2, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 1, 16),
            Block.makeCuboidShape(14, 1, 15, 16, 2, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(13, 9, 3, 16, 16, 6),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 1, 1),
            Block.makeCuboidShape(15, 1, 0, 16, 2, 2),
            Block.makeCuboidShape(15, 0, 15, 16, 1, 16),
            Block.makeCuboidShape(15, 1, 14, 16, 2, 16),
            Block.makeCuboidShape(1, 1, 1, 15, 8, 15),
            Block.makeCuboidShape(0, 0, 0, 1, 1, 1),
            Block.makeCuboidShape(0, 1, 0, 1, 2, 2),
            Block.makeCuboidShape(0, 0, 15, 1, 1, 16),
            Block.makeCuboidShape(0, 1, 14, 1, 2, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(10, 9, 13, 13, 16, 16),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(15, 0, 15, 16, 1, 16),
            Block.makeCuboidShape(14, 1, 15, 16, 2, 16),
            Block.makeCuboidShape(0, 0, 15, 1, 1, 16),
            Block.makeCuboidShape(0, 1, 15, 2, 2, 16),
            Block.makeCuboidShape(1, 1, 1, 15, 8, 15),
            Block.makeCuboidShape(15, 0, 0, 16, 1, 1),
            Block.makeCuboidShape(14, 1, 0, 16, 2, 1),
            Block.makeCuboidShape(0, 0, 0, 1, 1, 1),
            Block.makeCuboidShape(0, 1, 0, 2, 2, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
            Block.makeCuboidShape(0, 9, 10, 3, 16, 13),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(0, 0, 15, 1, 1, 16),
            Block.makeCuboidShape(0, 1, 14, 1, 2, 16),
            Block.makeCuboidShape(0, 0, 0, 1, 1, 1),
            Block.makeCuboidShape(0, 1, 0, 1, 2, 2),
            Block.makeCuboidShape(1, 1, 1, 15, 8, 15),
            Block.makeCuboidShape(15, 0, 15, 16, 1, 16),
            Block.makeCuboidShape(15, 1, 14, 16, 2, 16),
            Block.makeCuboidShape(15, 0, 0, 16, 1, 1),
            Block.makeCuboidShape(15, 1, 0, 16, 2, 2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Oven() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(7.0f, 9.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
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
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
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
}
