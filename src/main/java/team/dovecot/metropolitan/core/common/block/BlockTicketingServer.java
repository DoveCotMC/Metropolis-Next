package team.dovecot.metropolitan.core.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.dovecot.metropolitan.core.common.init.MetroBlocks;

public class BlockTicketingServer extends BaseEntityBlock {
    public static final DirectionProperty FACING = DirectionProperty.create("facing");
    public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

    public BlockTicketingServer(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (blockState.getValue(HALF).equals(DoubleBlockHalf.UPPER)) {
            return this.use(level.getBlockState(blockPos.below()), level, blockPos.below(), player, interactionHand, blockHitResult);
        }

        System.out.println(114514);

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos2 = pos.below();
        BlockState blockState2 = level.getBlockState(blockPos2);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockState2.isFaceSturdy(level, blockPos2, Direction.UP) : blockState2.is(this);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        level.setBlock(blockPos.above(), blockState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF).add(FACING);
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state) {
        super.destroy(world, pos, state);
        if (state.getValue(HALF).equals(DoubleBlockHalf.UPPER)) {
            if (world.getBlockState(pos.below()).getValue(HALF).equals(DoubleBlockHalf.LOWER)) {
                world.destroyBlock(pos.below(), false);
            }
        } else if (state.getValue(HALF).equals(DoubleBlockHalf.LOWER)) {
            if (world.getBlockState(pos.above()).getValue(HALF).equals(DoubleBlockHalf.UPPER)) {
                world.destroyBlock(pos.above(), false);
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(HALF).equals(DoubleBlockHalf.UPPER))
            return null;
        return MetroBlocks.MetroBlockEntities.TICKETING_SERVER.create(blockPos, blockState);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }
}
