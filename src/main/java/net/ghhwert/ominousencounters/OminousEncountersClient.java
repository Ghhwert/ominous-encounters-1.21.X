package net.ghhwert.ominousencounters;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.ghhwert.ominousencounters.particle.MistParticle;
import net.ghhwert.ominousencounters.particle.ModParticles;
import net.minecraft.client.particle.CloudParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;

public class OminousEncountersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.MIST_PARTICLE, MistParticle.Factory::new);
    }
}
