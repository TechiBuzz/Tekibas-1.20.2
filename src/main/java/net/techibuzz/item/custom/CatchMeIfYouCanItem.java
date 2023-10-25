package net.techibuzz.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import java.util.Random;

public class CatchMeIfYouCanItem extends Item {

    public CatchMeIfYouCanItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int  slot, boolean selected) {
        if (world.isClient && entity instanceof PlayerEntity player) {
            if (selected) {
                player.getInventory().removeOne(stack);
                Random random = new Random();
                while (true) {
                    int fSlot = random.nextInt(9);
                    if (fSlot != slot) {
                        if (player.getInventory().getStack(fSlot) == null || player.getInventory().getStack(fSlot).isOf(Items.AIR)) {
                            player.getInventory().insertStack(fSlot, stack);
                        }
                        break;
                    }
                }
            }
        }
    }

}

