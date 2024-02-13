package com.copycatsplus.copycats.content.copycat.pane;

import com.copycatsplus.copycats.content.copycat.SimpleCopycatModel;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

import static com.copycatsplus.copycats.content.copycat.ISimpleCopycatModel.MutableCullFace.*;
import static com.copycatsplus.copycats.content.copycat.ISimpleCopycatModel.MutableCullFace.NORTH;

public class CopycatHorizontalPaneModel extends SimpleCopycatModel {

    public CopycatHorizontalPaneModel(BakedModel originalModel) {
        super(originalModel);
    }

    @Override
    protected void emitCopycatQuads(BlockState state, CopycatRenderContext context, BlockState material) {
        List<Direction> present = new ArrayList<>();
        //middle
        assemblePiece(context, 0, false,
                vec3(0, 7, 0),
                aabb(16, 1, 16),
                cull(UP));
        assemblePiece(context, 0, false,
                vec3(0, 8, 0),
                aabb(16, 1, 16),
                cull(DOWN));
    }
}
