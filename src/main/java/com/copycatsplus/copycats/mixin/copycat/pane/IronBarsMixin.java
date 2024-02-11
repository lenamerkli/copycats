package com.copycatsplus.copycats.mixin.copycat.pane;

import com.copycatsplus.copycats.content.copycat.ICopycatWithWrappedBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//Glass panes are just iron bars
@Mixin(IronBarsBlock.class)
public abstract class IronBarsMixin {

    @Inject(
            at = @At("HEAD"),
            method = "attachsTo",
            cancellable = true
    )
    private void connectsToCopycat(BlockState pState, boolean pSolidSide, CallbackInfoReturnable<Boolean> cir) {
        if (ICopycatWithWrappedBlock.unwrap(pState.getBlock()) instanceof IronBarsBlock || pState.is(Tags.Blocks.GLASS_PANES))
            cir.setReturnValue(true);
    }
}
