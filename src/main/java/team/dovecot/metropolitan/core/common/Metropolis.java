package team.dovecot.metropolitan.core.common;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.dovecot.metropolitan.core.common.init.MetroBlocks;
import team.dovecot.metropolitan.core.common.init.MetroItems;

public class Metropolis implements ModInitializer {
	@Override
	public void onInitialize() {
		MetroBlocks.initialize();
		MetroItems.initialize();
	}
}