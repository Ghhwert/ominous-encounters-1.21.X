package net.ghhwert.ominousencounters.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ghhwert.ominousencounters.OminousEncounters;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item OLD_BELL = registerItem("old_bell", new Item(new Item.Settings()));
    public static final Item OLD_GIFT = registerItem("old_gift", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(OminousEncounters.MOD_ID, name), item);
    }

    public static void registerModItems(){
        OminousEncounters.LOGGER.info("Registering Mod Items for " + OminousEncounters.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(OLD_BELL);
            entries.add(OLD_GIFT);
        });
    }
}
