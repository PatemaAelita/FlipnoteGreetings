package net.patema.flipnotegreetings.services;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.patema.flipnotegreetings.sound.ModSounds;

public class PlayerJoinSoundHandler {
    public static void register() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity instanceof ServerPlayerEntity player) {
                player.playSound(ModSounds.STARTUP_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.sendMessage(Text.literal("frog"));
            }
        });
    }
}