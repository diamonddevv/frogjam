package net.diamonddev.frogjam;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrogJam implements ModInitializer {

	public static final String modid = "frogjam";
	public static final Logger LOGGER = LoggerFactory.getLogger("FrogJam");

	private static final Identifier frogjamSoundId = new Identifier(modid, "entity.frog.frogjam");
	public static SoundEvent FROGJAM = new SoundEvent(frogjamSoundId);
	public static double frogjamLengthInSeconds = 7.436;

	@Override
	public void onInitialize() {
		long start = System.currentTimeMillis();
		//
		Registry.register(Registry.SOUND_EVENT, frogjamSoundId, FROGJAM); // Register Sound
		//
		long initTime = System.currentTimeMillis() - start;
		LOGGER.info("Mod " + modid + " initialized in " + initTime + " millisecond(s)!");
	}
}
