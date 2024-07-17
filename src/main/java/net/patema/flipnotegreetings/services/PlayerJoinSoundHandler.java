package net.patema.flipnotegreetings.services;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.patema.flipnotegreetings.sound.ModSounds;

public class PlayerJoinSoundHandler {
    public static void register() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            playSoundAndMessage(client);
        });

        ClientTickEvents.END_CLIENT_TICK.register(PlayerJoinSoundHandler::playSoundAndMessage);
    }

    private static void playSoundAndMessage(MinecraftClient client) {
        client.execute(() -> {
            if (client.player != null && client.player.age == 0) {
                client.player.playSound(ModSounds.STARTUP_SOUND, SoundCategory.PLAYERS, 1.0F, 1.0F);
                client.player.sendMessage(Text.literal("frog!!!"), false);
            }
        });
    }
}