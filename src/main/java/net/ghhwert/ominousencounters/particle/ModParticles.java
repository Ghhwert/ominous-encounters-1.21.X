package net.ghhwert.ominousencounters.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.ghhwert.ominousencounters.OminousEncounters;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType MIST_PARTICLE =
            registerParticle("mist_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType){
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(OminousEncounters.MOD_ID, name), particleType);
    }

    public static void registerParticles(){
        OminousEncounters.LOGGER.info("Registering Particles for " + OminousEncounters.MOD_ID);
    }
}
