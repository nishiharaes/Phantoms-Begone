package net.nishihara;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nishihara.block.ModBlocks;
import net.nishihara.item.ModItems;

public class ModGroups {

    public static void registerModGroups(){
        PhantomsBegone.LOGGER.info("Registering Groups for " + PhantomsBegone.MOD_ID);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------

    public static final ItemGroup PHANTOMS_BEGONE = Registry.register(Registries.ITEM_GROUP, Identifier.of(PhantomsBegone.MOD_ID, "phantoms_begone"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.PHANTOM_MEMBRANE))
                    .displayName(Text.translatable("itemgroup.phantoms_begone.phantoms_begone"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PROCESSED_PHANTOM_MEMBRANE);
                        entries.add(ModItems.PHANTOM_REPELLENT);
                        entries.add(ModItems.RAW_NIGHT_CRYSTAL);
                        entries.add(ModItems.NIGHT_CRYSTAL);
                        entries.add(ModBlocks.DEEPSLATE_NIGHT_CRYSTAL_ORE);
                        entries.add(ModBlocks.NIGHT_CRYSTAL_ORE);
                    })
                    .build());
}
