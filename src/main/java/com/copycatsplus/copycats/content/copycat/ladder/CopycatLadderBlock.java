package com.copycatsplus.copycats.content.copycat.ladder;

import com.copycatsplus.copycats.content.copycat.ICopycatWithWrappedBlock;
import com.simibubi.create.content.decoration.copycat.CopycatBlock;
import com.simibubi.create.content.equipment.extendoGrip.ExtendoGripItem;
import com.simibubi.create.foundation.placement.IPlacementHelper;
import com.simibubi.create.foundation.placement.PlacementHelpers;
import com.simibubi.create.foundation.placement.PlacementOffset;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeMod;

import java.util.function.Predicate;

import static net.minecraft.world.level.block.LadderBlock.FACING;

public class CopycatLadderBlock extends CopycatBlock implements ICopycatWithWrappedBlock<WrappedLadderBlock> {

    public static WrappedLadderBlock ladder;
    public CopycatLadderBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public WrappedLadderBlock getWrappedBlock() {
        return ladder;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder.add(FACING));
    }

    @Override
    public boolean canConnectTexturesToward(BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockPos blockPos1, BlockState blockState) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return ladder.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

}
