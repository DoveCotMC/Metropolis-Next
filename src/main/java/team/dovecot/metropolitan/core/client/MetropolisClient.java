package team.dovecot.metropolitan.core.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import team.dovecot.metropolitan.core.common.init.MetroBlocks;

public class MetropolisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MetroBlocks.TICKETING_SERVER, RenderType.cutoutMipped());
    }
}
