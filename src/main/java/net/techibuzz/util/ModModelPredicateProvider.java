package net.techibuzz.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.techibuzz.Tekibas;
import net.techibuzz.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(Tekibas.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);

        ModelPredicateProviderRegistry.register(ModItems.WEATHER_TABLET, new Identifier(Tekibas.MOD_ID, "rainy"),
                (stack, world, entity, seed) -> (stack.getNbt().getInt("tekibas.weather_tablet.weather") == 2) ? 1f : 0f);
        ModelPredicateProviderRegistry.register(ModItems.WEATHER_TABLET, new Identifier(Tekibas.MOD_ID, "thunder"),
                (stack, world, entity, seed) -> (stack.getNbt().getInt("tekibas.weather_tablet.weather") == 3) ? 1f : 0f);
    }
}
