package net.techibuzz.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningStrikerEnchantment extends Enchantment {

    public LightningStrikerEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user.getWorld().isClient) {
            return;
        }
        ServerWorld serverWorld = (ServerWorld) user.getWorld();
        BlockPos position = target.getBlockPos();

        if (level == 1) {
            EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        }
        if (level == 2) {
            EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(serverWorld, position, SpawnReason.TRIGGERED);
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.CHANNELING;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
