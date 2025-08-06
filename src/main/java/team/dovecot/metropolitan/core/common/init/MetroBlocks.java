package team.dovecot.metropolitan.core.common.init;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import team.dovecot.metropolitan.Constants;
import team.dovecot.metropolitan.core.common.block.BlockTicketingServer;
import team.dovecot.metropolitan.core.common.block.entity.BlockEntityTicketingServer;

public final class MetroBlocks {
    public static final Block TICKETING_SERVER = register("ticketing_server", new BlockTicketingServer(BlockBehaviour.Properties.of(Material.METAL).strength(8.0f, 3600000.0F)));

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(Constants.MOD_ID, id), block);
    }

    public static void initialize() {
        MetroBlockEntities.initialize();
    }

    public static final class MetroBlockEntities {
        public static final BlockEntityType<BlockEntityTicketingServer> TICKETING_SERVER = register("ticketing_server", FabricBlockEntityTypeBuilder.create(BlockEntityTicketingServer::new, MetroBlocks.TICKETING_SERVER).build());

        private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> blockEntityType) {
            return Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(Constants.MOD_ID, id), blockEntityType);
        }

        public static void initialize() {}
    }
}
