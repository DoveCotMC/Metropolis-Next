package team.dovecot.metropolitan.core.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import team.dovecot.metropolitan.core.common.init.MetroBlocks;

public class BlockEntityTicketingServer extends BlockEntity {
    public BlockEntityTicketingServer(BlockPos blockPos, BlockState blockState) {
        super(MetroBlocks.MetroBlockEntities.TICKETING_SERVER, blockPos, blockState);
    }
}
