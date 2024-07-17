package net.patema.flipnotegreetings.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.patema.flipnotegreetings.FlipnoteGreetings;

public class ModSounds {
    public static final SoundEvent STARTUP_SOUND = registerSoundEvent("startup_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FlipnoteGreetings.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        net.patema.flipnotegreetings.FlipnoteGreetings.LOGGER.info("Registering sounds for "+ FlipnoteGreetings.MOD_ID);
    }
}
