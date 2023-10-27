package net.techibuzz.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.techibuzz.Tekibas;

public class ModSounds {

    public static final SoundEvent METAl_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    public static final SoundEvent PINK_GARNET_LAMP_BREAK = registerSoundEvent("metal_detector_found_break");
    public static final SoundEvent PINK_GARNET_LAMP_PLACE = registerSoundEvent("metal_detector_found_place");
    public static final SoundEvent PINK_GARNET_LAMP_STEP = registerSoundEvent("metal_detector_found_step");
    public static final SoundEvent PINK_GARNET_LAMP_HIT = registerSoundEvent("metal_detector_found_hit");
    public static final SoundEvent PINK_GARNET_LAMP_FALL = registerSoundEvent("metal_detector_found_fall");

    public static final BlockSoundGroup PINK_GARNET_LAMP_SOUNDS = new BlockSoundGroup(1f, 1f, PINK_GARNET_LAMP_BREAK, PINK_GARNET_LAMP_STEP, PINK_GARNET_LAMP_PLACE, PINK_GARNET_LAMP_HIT, PINK_GARNET_LAMP_FALL);

    public static final SoundEvent BAR_BRAWL_MUSIC_DISC = registerSoundEvent("bar_brawl");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Tekibas.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier,SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Tekibas.LOGGER.info("Registering Mod Sounds For ---- " + Tekibas.MOD_ID);
    }
}
