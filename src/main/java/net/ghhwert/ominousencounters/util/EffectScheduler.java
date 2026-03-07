package net.ghhwert.ominousencounters.util;

import java.util.ArrayList;
import java.util.List;

public class EffectScheduler {
    private static final List<ScheduledEffect> effects = new ArrayList<>();

    public static void addEffect(ScheduledEffect effect){
        effects.add(effect);
    }

    public static void tick(){
        List<ScheduledEffect> finished = new ArrayList<>();

        for (ScheduledEffect effect : effects){
            effect.tick();

            if (effect.isFinished()){
                finished.add(effect);
            }
        }
        effects.removeAll(finished);
    }

    public interface ScheduledEffect{
        void tick();
        boolean isFinished();
    }
}
