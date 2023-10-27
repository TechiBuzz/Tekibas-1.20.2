package net.techibuzz;

import net.fabricmc.api.ModInitializer;
import net.techibuzz.block.ModBlocks;
import net.techibuzz.enchantment.ModEnchantments;
import net.techibuzz.item.ModItemGroups;
import net.techibuzz.item.ModItems;
import net.techibuzz.sound.ModSounds;
import net.techibuzz.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tekibas implements ModInitializer {

	public static final String MOD_ID = "tekibas";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
		ModEnchantments.registerModEnchantments();

		ModSounds.registerSounds();
	}

}