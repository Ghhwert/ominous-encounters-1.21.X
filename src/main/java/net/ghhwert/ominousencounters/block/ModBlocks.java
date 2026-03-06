package net.ghhwert.ominousencounters.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ghhwert.ominousencounters.OminousEncounters;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block EXAMPLE_BLOCK = registerBlock("example_block",
            new Block(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(state -> 15)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(OminousEncounters.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(OminousEncounters.MOD_ID, name),
                    new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        OminousEncounters.LOGGER.info("Registering Mod Blocks for " + OminousEncounters.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.EXAMPLE_BLOCK);
        });
    }
}
