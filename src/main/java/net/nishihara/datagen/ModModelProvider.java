package net.nishihara.datagen;

import com.ibm.icu.text.Normalizer2;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.nishihara.block.ModBlocks;
import net.nishihara.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NIGHT_CRYSTAL_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.PHANTOM_REPELLENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROCESSED_PHANTOM_MEMBRANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NIGHT_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NIGHT_CRYSTAL, Models.GENERATED);

    }
}
