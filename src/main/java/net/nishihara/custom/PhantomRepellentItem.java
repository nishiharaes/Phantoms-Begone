package net.nishihara.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nishihara.PhantomsBegone;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PhantomRepellentItem extends Item {
    private static final Set<UUID> playersPreventingPhantomSpawns = new HashSet<>();

    public PhantomRepellentItem(Settings settings) {
        super(settings);
    }

    public static void checkPlayerInventory(ServerWorld world){
        for(PlayerEntity player : world.getPlayers()){
            boolean hasItem = player.getInventory().main.stream()
                    .anyMatch(stack -> stack.getItem() instanceof PhantomRepellentItem);

            if(hasItem){
                world.getEntitiesByType(EntityType.PHANTOM, player.getBoundingBox().expand(50), phantom -> true).forEach(Entity::kill);
            }

            if(hasItem){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 210, 1, true, false));
            }

        }
    }

}
