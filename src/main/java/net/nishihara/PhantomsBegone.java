package net.nishihara;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.nishihara.block.ModBlocks;
import net.nishihara.custom.PhantomRepellentItem;
import net.nishihara.item.ModItems;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhantomsBegone implements ModInitializer {
	public static final String MOD_ID = "phantoms-begone";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModGroups.registerModGroups();

		ServerTickEvents.END_WORLD_TICK.register(PhantomRepellentItem::checkPlayerInventory);

	}
}