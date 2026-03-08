package net.ghhwert.ominousencounters.effect;

import net.ghhwert.ominousencounters.item.custom.BellItem;
import net.ghhwert.ominousencounters.util.EffectScheduler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class FogEffect implements EffectScheduler.ScheduledEffect {

    private int ticksLeft;
    private final List<BlockPos> area;
    private final ServerWorld world;

    public FogEffect(ServerWorld world, List<BlockPos> area, int duration) {
        this.world = world;
        this.area = area;
        this.ticksLeft = duration;
    }

    @Override
    public void tick() {
        if (ticksLeft % 20 == 0) {
            BellItem.fillWithFog(area, world);
        }
        ticksLeft--;
    }

    @Override
    public boolean isFinished() {
        return ticksLeft <= 0;
    }
}
