package net.ghhwert.ominousencounters;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.ghhwert.ominousencounters.block.ModBlocks;
import net.ghhwert.ominousencounters.item.ModItems;
import net.ghhwert.ominousencounters.particle.ModParticles;
import net.ghhwert.ominousencounters.util.EffectScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OminousEncounters implements ModInitializer {
	public static final String MOD_ID = "ominousencounters";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModParticles.registerParticles();
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            EffectScheduler.tick();
        });

    }
}