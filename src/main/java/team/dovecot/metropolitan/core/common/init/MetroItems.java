package team.dovecot.metropolitan.core.common.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import team.dovecot.metropolitan.Constants;

public class MetroItems {
    public static final Item TICKETING_SERVER = register("ticketing_server", new BlockItem(MetroBlocks.TICKETING_SERVER, new Item.Properties()));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(Constants.MOD_ID, id), item);
    }

    public static void initialize() {}
}
