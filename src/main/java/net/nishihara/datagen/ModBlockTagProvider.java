package net.nishihara.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nishihara.block.ModBlocks;
import net.nishihara.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE)
                .add(ModBlocks.NIGHT_CRYSTAL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE)
                .add(ModBlocks.NIGHT_CRYSTAL_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NIGHT_CRYSTAL_ORES)
                .add(ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE)
                .add(ModBlocks.NIGHT_CRYSTAL_ORE);
    }
}
