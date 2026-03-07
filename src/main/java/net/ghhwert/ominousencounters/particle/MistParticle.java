package net.ghhwert.ominousencounters.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MistParticle extends SpriteBillboardParticle {
    public MistParticle(ClientWorld clientWorld, double x, double y, double z,
                        SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.maxAge = 40;
        this.collidesWithWorld = true;
        this.alpha = 0.5f;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType>{
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider){
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z,
                                      double velocityX, double velocityY, double velocityZ){
            return new MistParticle(world,x,y,z,this.spriteProvider,velocityX,velocityY,velocityY);
        }
    }
}
