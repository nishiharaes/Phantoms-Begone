package net.nishihara.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.nishihara.PhantomsBegone;
import net.nishihara.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){

        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(PhantomsBegone.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static final RegistryKey<ConfiguredFeature<?, ?>> NIGHT_CRYSTAL_ORE_KEY = registryKey("night_crystal_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldNightCrystalOres = List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.NIGHT_CRYSTAL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE.getDefaultState()));

        register(context, NIGHT_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldNightCrystalOres, 1));
    }

}
