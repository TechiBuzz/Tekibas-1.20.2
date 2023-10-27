package net.techibuzz.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.techibuzz.Tekibas;
import net.techibuzz.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tekibas.MOD_ID, "pink_garnet_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.pink_garnet_group"))
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.PINK_GARNET);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.PINK_GARNET_PAXEL);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);

                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);
                        entries.add(ModItems.DATA_TABLET);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
                        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
                        entries.add(ModBlocks.END_STONE_PINK_GARNET_ORE);

                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_SLAB);
                        entries.add(ModBlocks.PINK_GARNET_STAIRS);

                        entries.add(ModBlocks.PINK_GARNET_FENCE);
                        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.add(ModBlocks.PINK_GARNET_WALL);

                        entries.add(ModBlocks.PINK_GARNET_DOOR);
                        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);

                        entries.add(ModBlocks.PINK_GARNET_LAMP_BLOCK);

                        entries.add(ModBlocks.PETUNIA);
                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);

                        entries.add(ModBlocks.GEM_EMPOWERING_STATION);
                    })
                    .build());

    public static final ItemGroup OTHER_THINGS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tekibas.MOD_ID, "other_things_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.other_things_group"))
                    .icon(() -> new ItemStack(ModItems.METAL_DETECTOR))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.CATCH_ME_IF_YOU_CAN);

                        entries.add(ModItems.PEAT_BRICK);

                        entries.add(ModItems.WEATHER_TABLET);
                        entries.add(ModBlocks.WEATHER_BLOCK);

                    })
                    .build());

    public static final ItemGroup FOOD_AND_RELATED = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Tekibas.MOD_ID, "food_and_related"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.food_and_related"))
                    .icon(() -> new ItemStack(ModItems.CAULIFLOWER))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);

                    })
                    .build());

    public static void registerModItemGroups() {

    }

}
