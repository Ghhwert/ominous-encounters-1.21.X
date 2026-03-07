package net.ghhwert.ominousencounters.item.custom;

import net.ghhwert.ominousencounters.util.EffectScheduler;
import net.ghhwert.ominousencounters.effect.FogEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.ArrayList;
import java.util.List;

public class BellItem extends Item{


    public BellItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient && world instanceof ServerWorld serverWorld){
            BlockPos fogCenter = user.getBlockPos().up();
            List<BlockPos> area = getFogArea(fogCenter);

            final int tickPerSec = 20;
            int duration = 15 * tickPerSec;
            EffectScheduler.addEffect(new FogEffect(serverWorld, area, duration));
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }


    public static List<BlockPos> getFogArea(BlockPos fogCenter){
        //Gets all positions the Old Bell effects.
        List<BlockPos> positions = new ArrayList<>();

        final int horizontalRadius = 15;
        final int verticalRadius = 7;
        for (int x = -horizontalRadius; x <= horizontalRadius; x++){
            for (int y = -verticalRadius; y <= verticalRadius; y++){
                for (int z = -horizontalRadius; z <= horizontalRadius; z++){
                    positions.add(fogCenter.add(x,y,z));
                }
            }
        }
        return positions;
    }


    public static void fillWithFog(List<BlockPos> area, ServerWorld serverWorld){
        double offsetX = (serverWorld.random.nextDouble() - 0.5) * 0.8;
        double offsetY = (serverWorld.random.nextDouble() - 0.5) * 0.6;
        double offsetZ = (serverWorld.random.nextDouble() - 0.5) * 0.8;

        for (BlockPos pos : area) {
            if (serverWorld.isAir(pos) && (serverWorld.random.nextFloat() > 0.8f)) {
                serverWorld.spawnParticles(ParticleTypes.POOF,
                        pos.getX()+0.5F+offsetX,
                        pos.getY()+0.5F+offsetY,
                        pos.getZ()+0.5F+offsetZ,
                        1, 0.0, 0.0, 0.0,0.01);
            }
        }
    }
}
