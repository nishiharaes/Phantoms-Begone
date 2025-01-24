package net.nishihara.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import java.util.HashSet;
import java.util.List;
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

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.phantoms-begone.phantom_repellent.tooltip1"));
            tooltip.add(Text.translatable("tooltip.phantoms-begone.phantom_repellent.tooltip2"));
        }
        else{
            tooltip.add(Text.translatable("tooltip.phantoms-begone.phantom_repellent.tooltip3"));
        }


        super.appendTooltip(stack, context, tooltip, type);
    }
}
