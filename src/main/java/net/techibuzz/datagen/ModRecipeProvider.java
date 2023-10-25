package net.techibuzz.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.techibuzz.block.ModBlocks;
import net.techibuzz.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModBlocks.PINK_GARNET_ORE,ModBlocks.DEEPSLATE_PINK_GARNET_ORE,ModBlocks.NETHER_PINK_GARNET_ORE,ModBlocks.END_STONE_PINK_GARNET_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET,
                                                RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_PINK_GARNET,
                                                RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK);

        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.3f, 200, "raw_pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.35f, 100, "raw_pink_garnet");

        offerPressurePlateRecipe(exporter, ModBlocks.PINK_GARNET_PRESSURE_PLATE, ModBlocks.PINK_GARNET_BLOCK);

        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);


        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BUTTON, ModBlocks.PINK_GARNET_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_STAIRS, ModBlocks.PINK_GARNET_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK, 1);

        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter);

    }

}
