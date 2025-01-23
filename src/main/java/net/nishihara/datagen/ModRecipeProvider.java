package net.nishihara.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nishihara.block.ModBlocks;
import net.nishihara.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> NIGHT_CRYSTAL_SMELTABLES = List.of(ModItems.RAW_NIGHT_CRYSTAL, ModBlocks.NIGHT_CRYSTAL_ORE, ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE);

        offerSmelting(exporter, NIGHT_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHT_CRYSTAL, 0.25f, 200, "night_crystal");
        offerBlasting(exporter, NIGHT_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.NIGHT_CRYSTAL, 0.25f, 100, "night_crystal");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHANTOM_REPELLENT)
                .pattern(" N ")
                .pattern("NPN")
                .pattern(" N ")
                .input('N', ModItems.NIGHT_CRYSTAL)
                .input('P', ModItems.PROCESSED_PHANTOM_MEMBRANE)
                .criterion(hasItem(ModItems.NIGHT_CRYSTAL), conditionsFromItem(ModItems.NIGHT_CRYSTAL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROCESSED_PHANTOM_MEMBRANE).input(Items.PHANTOM_MEMBRANE)
                .criterion(hasItem(Items.PHANTOM_MEMBRANE), conditionsFromItem(Items.PHANTOM_MEMBRANE))
                .offerTo(exporter);



    }
}
