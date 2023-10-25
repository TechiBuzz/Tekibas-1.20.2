package net.techibuzz.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.techibuzz.Tekibas;
import net.techibuzz.block.ModBlocks;
import net.techibuzz.item.custom.*;

public class ModItems {

    public static final Item PINK_GARNET = regiserItem("pink_garnet",
            new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = regiserItem("raw_pink_garnet",
            new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = regiserItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxCount(1).maxDamage(256)));
    public static final Item CATCH_ME_IF_YOU_CAN = regiserItem("cmiuc",
            new CatchMeIfYouCanItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item CAULIFLOWER = regiserItem("cauliflower",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item PEAT_BRICK = regiserItem("peat_brick",
            new Item(new FabricItemSettings()));

    public static final Item PINK_GARNET_SWORD = regiserItem("pink_garnet_sword",
            new ModPosionSwordItem(ModToolMaterial.PINK_GARNET, 5, 3f, new FabricItemSettings()));
    public static final Item PINK_GARNET_PICKAXE = regiserItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterial.PINK_GARNET, 1, 1f, new FabricItemSettings()));
    public static final Item PINK_GARNET_AXE = regiserItem("pink_garnet_axe",
            new AxeItem(ModToolMaterial.PINK_GARNET, 7, -2f, new FabricItemSettings()));
    public static final Item PINK_GARNET_SHOVEL = regiserItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterial.PINK_GARNET, 0, 0f, new FabricItemSettings()));
    public static final Item PINK_GARNET_HOE = regiserItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterial.PINK_GARNET, 0, 0f, new FabricItemSettings()));
    public static final Item PINK_GARNET_PAXEL = regiserItem("pink_garnet_paxel",
            new PaxelItem(ModToolMaterial.PINK_GARNET, 0, 0f, new FabricItemSettings()));

    public static final Item PINK_GARNET_HELMET = regiserItem("pink_garnet_helmet",
                new ModArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PINK_GARNET_CHESTPLATE = regiserItem("pink_garnet_chestplate",
                new ArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PINK_GARNET_LEGGINGS = regiserItem("pink_garnet_leggings",
                new ArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PINK_GARNET_BOOTS = regiserItem("pink_garnet_boots",
                new ArmorItem(ModArmorMaterial.PINK_GARNET, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item PINK_GARNET_HORSE_ARMOR = regiserItem("pink_garnet_horse_armor",
            new HorseArmorItem(16 ,"pink_garnet",new FabricItemSettings()));

    public static final Item DATA_TABLET = regiserItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().maxCount(1)));

    public static final Item WEATHER_TABLET = regiserItem("weather_tablet",
            new WeatherTabletItem(new FabricItemSettings().maxCount(1)));

    private static Item regiserItem(String name, Item item) {
        return  Registry.register(Registries.ITEM, new Identifier(Tekibas.MOD_ID, name), item);
    }

    private static void ItemGroupIngredients(FabricItemGroupEntries entries) {
        entries.addAfter(Items.GOLD_INGOT, PINK_GARNET);
        entries.addAfter(Items.RAW_GOLD, RAW_PINK_GARNET);

        entries.add(ModBlocks.PINK_GARNET_BLOCK);
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
    }

    private static void ItemGroupFoodAndDrink(FabricItemGroupEntries entries) {
        entries.add(CAULIFLOWER);
    }

    public static void registerModItems() {
        Tekibas.LOGGER.info("Registering Mod Items For ---- " + Tekibas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::ItemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::ItemGroupFoodAndDrink);
    }

}
