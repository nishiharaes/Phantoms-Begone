package net.nishihara.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.nishihara.world.ModPlacedFeatures;

public class ModOreGeneration {

    public static void generateOres(){

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NIGHT_CRYSTAL_ORE_PLACED_KEY);

    }
}
