package net.techibuzz.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.techibuzz.Tekibas;

public class ModEnchantments {

    public static final Enchantment LIGHTNING_STRIKER = registerEnchantment("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.VERY_RARE,
                                                                    EnchantmentTarget.WEAPON,
                                                                        EquipmentSlot.MAINHAND));

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
       return Registry.register(Registries.ENCHANTMENT, new Identifier(Tekibas.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        Tekibas.LOGGER.info("Registering Mod Enchantments For ---- " + Tekibas.MOD_ID);
    }
}
