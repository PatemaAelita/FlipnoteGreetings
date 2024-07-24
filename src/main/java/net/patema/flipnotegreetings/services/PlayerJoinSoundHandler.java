package net.patema.flipnotegreetings.services;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.patema.flipnotegreetings.sound.ModSounds;


public class PlayerJoinSoundHandler {
    private static boolean gameLoaded = false;

    public static void register() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            gameLoaded = false;
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            //Check if the client has properly loaded before playing the sound (including longer loading screen due to mods)
            if (!gameLoaded && client.world != null && client.player != null && client.currentScreen == null) {
                gameLoaded = true;
                client.player.playSound(ModSounds.STARTUP_SOUND, 1.0F, 1.0F);
                client.player.sendMessage(Text.literal("The Flipnote frog greets you !!!"), false);
            }
        });
    }
}