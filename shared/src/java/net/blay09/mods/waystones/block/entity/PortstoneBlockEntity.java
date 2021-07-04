package net.blay09.mods.waystones.block.entity;

import net.blay09.mods.forbic.block.entity.ForbicBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class PortstoneBlockEntity extends ForbicBlockEntity {

    public PortstoneBlockEntity(BlockPos worldPosition, BlockState state) {
        super(ModBlockEntities.portstone.get(), worldPosition, state);
    }

    @Override
    public AABB forbicGetRenderBoundingBox() {
        return new AABB(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), worldPosition.getX() + 1, worldPosition.getY() + 2, worldPosition.getZ() + 1);
    }

}
