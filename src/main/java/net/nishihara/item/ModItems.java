package net.nishihara.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.nishihara.ModGroups;
import net.nishihara.PhantomsBegone;
import net.nishihara.custom.PhantomRepellentItem;

public class ModItems {

    // Item registration method

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(PhantomsBegone.MOD_ID, name), item);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------

    // Item registration list

    public static final Item PHANTOM_REPELLENT = registerItem("phantom_repellent",
            new PhantomRepellentItem(new Item.Settings().maxCount(1)));

    public static final Item PROCESSED_PHANTOM_MEMBRANE = registerItem("processed_phantom_membrane", new Item(new Item.Settings()));

    public static final Item RAW_NIGHT_CRYSTAL = registerItem("raw_night_crystal", new Item(new Item.Settings()));

    public static final Item NIGHT_CRYSTAL = registerItem("night_crystal", new Item(new Item.Settings()));

    // -------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void registerModItems(){
        PhantomsBegone.LOGGER.info("Registering Items for " + PhantomsBegone.MOD_ID);
    }
}
