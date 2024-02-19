package com.copycatsplus.copycats.mixin.copycat.ladder;

import com.copycatsplus.copycats.CCBlocks;
import com.copycatsplus.copycats.content.copycat.ladder.WrappedLadderBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LadderBlock.class)
public class LadderBlockMixin {

    @ModifyArg(method = "getStateForPlacement", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private Block copycats$stateForPlacement(Block original) {
        if (original instanceof WrappedLadderBlock) {
            return CCBlocks.COPYCAT_LADDER.get();
        }
        return original;
    }
}
