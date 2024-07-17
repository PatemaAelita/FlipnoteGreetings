package net.patema.flipnotegreetings;

import net.fabricmc.api.ModInitializer;

import net.patema.flipnotegreetings.services.PlayerJoinSoundHandler;
import net.patema.flipnotegreetings.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlipnoteGreetings implements ModInitializer {
	public static final String MOD_ID = "flipnotegreetings";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.registerSounds();
		PlayerJoinSoundHandler.register();
	}
}