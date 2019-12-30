package net.blay09.mods.waystones.core;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

import java.util.UUID;

public class WaystoneProxy implements IWaystone {

    private final UUID waystoneUid;
    private IWaystone backingWaystone;

    public WaystoneProxy(UUID waystoneUid) {
        this.waystoneUid = waystoneUid;
    }

    @Override
    public boolean isValid() {
        return WaystoneManager.getWaystoneById(waystoneUid).isPresent();
    }

    private IWaystone getBackingWaystone() {
        if (backingWaystone == null) {
            backingWaystone = WaystoneManager.getWaystoneById(waystoneUid).orElseThrow(() -> new IllegalStateException("Waystone with id " + waystoneUid + " does not exist"));
        }

        return backingWaystone;
    }

    @Override
    public UUID getWaystoneUid() {
        return waystoneUid;
    }

    @Override
    public String getName() {
        return getBackingWaystone().getName();
    }

    @Override
    public DimensionType getDimensionType() {
        return getBackingWaystone().getDimensionType();
    }

    @Override
    public boolean wasGenerated() {
        return getBackingWaystone().wasGenerated();
    }

    @Override
    public boolean isGlobal() {
        return getBackingWaystone().isGlobal();
    }

    @Override
    public boolean isOwner(PlayerEntity player) {
        return getBackingWaystone().isOwner(player);
    }

    @Override
    public Direction getFacing() {
        return getBackingWaystone().getFacing();
    }

    @Override
    public BlockPos getPos() {
        return getBackingWaystone().getPos();
    }
}