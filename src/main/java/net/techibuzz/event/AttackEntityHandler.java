package net.techibuzz.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.techibuzz.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {

        if (entity instanceof SheepEntity && !world.isClient && !player.isSpectator()) {
            if (player.getStackInHand(hand).getItem().equals(ModItems.PINK_GARNET_SWORD)) {
                player.sendMessage(Text.literal(player.getName().getString() + " just smashed a sheep with our custom sword!"));
            } else {
                player.sendMessage(Text.literal(player.getName().getString() + " just smashed a sheep!"));
            }
        }

        return ActionResult.PASS;
    }
}
