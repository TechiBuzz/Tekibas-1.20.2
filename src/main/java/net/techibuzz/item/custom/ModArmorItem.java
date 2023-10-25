package net.techibuzz.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.techibuzz.item.ModArmorMaterial;

import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP = new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
            .put(ModArmorMaterial.PINK_GARNET, new StatusEffectInstance(StatusEffects.HASTE, 400, 1)).build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            if (hasFullSuitArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
                break;
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffect) {
        boolean playerAlreadyHasEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());
        if (!playerAlreadyHasEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(), mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }
    /*
     * Checks that every armor slot is occupied by an ArmorItem
     * Each ArmorItem must be also equal to same mapMaterial
     */
    private boolean hasCorrectArmorOn(ArmorMaterial mapMaterial, PlayerEntity player) {
        for (ItemStack armorStack : player.getArmorItems()) {
            // Return false even if one of them is not ArmorItem
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return helmet.getMaterial() == mapMaterial && chestplate.getMaterial() == mapMaterial && leggings.getMaterial() == mapMaterial && boots.getMaterial() == mapMaterial;
    }

    private boolean hasFullSuitArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
