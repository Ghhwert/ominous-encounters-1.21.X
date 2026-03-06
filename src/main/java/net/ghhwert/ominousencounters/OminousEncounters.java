package net.ghhwert.ominousencounters;

import net.fabricmc.api.ModInitializer;

import net.ghhwert.ominousencounters.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OminousEncounters implements ModInitializer {
	public static final String MOD_ID = "ominousencounters";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
	}
}