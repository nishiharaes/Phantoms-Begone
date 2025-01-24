package net.nishihara;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.nishihara.block.ModBlocks;
import net.nishihara.custom.PhantomRepellentItem;
import net.nishihara.item.ModItems;
import net.nishihara.world.gen.ModWorldGeneration;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PhantomsBegone implements ModInitializer {
	public static final String MOD_ID = "phantoms-begone";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModGroups.registerModGroups();
        ModWorldGeneration.generateModWorldGen();

		ServerTickEvents.END_WORLD_TICK.register(PhantomRepellentItem::checkPlayerInventory);


	}
}