package net.techibuzz.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.techibuzz.block.ModBlocks;
import net.techibuzz.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        // PICKAXE
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)               // # Stone Pickaxe
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)           // # Stone Pickaxe

                .add(ModBlocks.PINK_GARNET_ORE)                 // # Iron Pickaxe
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE)       // # Diamond Pickaxe
                .add(ModBlocks.NETHER_PINK_GARNET_ORE)          // # Netherite Pickaxe

                .add(ModBlocks.END_STONE_PINK_GARNET_ORE)       // # Pink Garnet Pickaxe

                .add(ModBlocks.PINK_GARNET_STAIRS)              // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_SLAB)                // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_PRESSURE_PLATE)      // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_FENCE)               // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_FENCE_GATE)          // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_WALL)                // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_DOOR)                // # Stone Pickaxe
                .add(ModBlocks.PINK_GARNET_TRAPDOOR);           // # Stone Pickaxe

        // AXE
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.WEATHER_BLOCK);

        // TIER - STONE
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)

                .add(ModBlocks.PINK_GARNET_STAIRS)
                .add(ModBlocks.PINK_GARNET_SLAB)

                .add(ModBlocks.PINK_GARNET_PRESSURE_PLATE)

                .add(ModBlocks.PINK_GARNET_FENCE)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE)
                .add(ModBlocks.PINK_GARNET_WALL)

                .add(ModBlocks.PINK_GARNET_DOOR)
                .add(ModBlocks.PINK_GARNET_TRAPDOOR)

                .add(ModBlocks.WEATHER_BLOCK);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.PETUNIA);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_PETUNIA);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.PETUNIA);

        // TIER - IRON
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.NETHER_PINK_GARNET_ORE);

        // TIER - DIAMOND
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        // TIER - NETHERITE
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.NETHER_PINK_GARNET_ORE);

        // TIER - CUSTOM: PINK GARNET (5)
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(ModBlocks.END_STONE_PINK_GARNET_ORE);

        // CUSTOM TAGS
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES);

        // PaxelMineable
        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE);

        // VANILLA TAGS
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.PINK_GARNET_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.PINK_GARNET_WALL);


    }

}
