package net.nishihara.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nishihara.PhantomsBegone;

public class ModBlocks {

    // block and block item registration methods

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(PhantomsBegone.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PhantomsBegone.MOD_ID, name), block);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------

    // block registration list

    public static final Block NIGHT_CRYSTAL_ORE = registerBlock("night_crystal_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_NIGHT_CRYSTAL_ORE = registerBlock("deepslate_night_crystal_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
            AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    // -------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void registerModBlocks(){
        PhantomsBegone.LOGGER.info("Registering Blocks for " + PhantomsBegone.MOD_ID);
    }

}
