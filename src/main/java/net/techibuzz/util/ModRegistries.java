package net.techibuzz.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.techibuzz.item.ModItems;

public class ModRegistries {

    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
        fuelRegistry.add(ModItems.PEAT_BRICK, 200);
    }

}
