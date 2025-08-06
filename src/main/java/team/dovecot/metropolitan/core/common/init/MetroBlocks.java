package team.dovecot.metropolitan.core.common.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import team.dovecot.metropolitan.Constants;
import team.dovecot.metropolitan.core.common.block.BlockTicketingServer;

public class MetroBlocks {
    public static final Block TICKETING_SERVER = register("ticketing_server", new BlockTicketingServer(BlockBehaviour.Properties.of(Material.METAL)));

    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(Constants.MOD_ID, id), block);
    }

    public static void initialize() {}
}
