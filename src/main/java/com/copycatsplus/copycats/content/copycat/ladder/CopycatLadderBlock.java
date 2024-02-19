package com.copycatsplus.copycats.content.copycat.ladder;

import com.copycatsplus.copycats.content.copycat.ICopycatWithWrappedBlock;
import com.simibubi.create.content.decoration.copycat.CopycatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.block.LadderBlock.FACING;
import static net.minecraft.world.level.block.LadderBlock.WATERLOGGED;

public class CopycatLadderBlock extends CopycatBlock implements ICopycatWithWrappedBlock<WrappedLadderBlock> {

    public static WrappedLadderBlock ladder;
    public CopycatLadderBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public WrappedLadderBlock getWrappedBlock() {
        return ladder;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder.add(FACING).add(WATERLOGGED));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        BlockState stateForPlacement = super.getStateForPlacement(pContext);
        assert stateForPlacement != null;
        return stateForPlacement.setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public boolean canConnectTexturesToward(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockPos blockPos1, BlockState blockState) {
        return false;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return ladder.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return ladder.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public @NotNull BlockState rotate(BlockState pState, Rotation pRotation) {
        return ladder.rotate(pState, pRotation);
    }

    @Override
    public @NotNull BlockState mirror(BlockState pState, Mirror pMirror) {
        return ladder.mirror(pState, pMirror);
    }

    public BlockState copyState(BlockState from, BlockState to) {
        return to.setValue(LadderBlock.FACING, from.getValue(LadderBlock.FACING));
    }

}
