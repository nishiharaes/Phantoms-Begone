package net.nishihara.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nishihara.PhantomsBegone;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NIGHT_CRYSTAL_ORES = createTag("night_crystal_ores");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PhantomsBegone.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> NIGHT_CRYSTAL_ORES = createTag("night_crystal_ores");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PhantomsBegone.MOD_ID, name));
        }

    }
}
