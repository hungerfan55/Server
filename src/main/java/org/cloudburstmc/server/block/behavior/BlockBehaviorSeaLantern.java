package org.cloudburstmc.server.block.behavior;

import org.cloudburstmc.server.block.Block;
import org.cloudburstmc.server.item.Item;
import org.cloudburstmc.server.item.ItemIds;
import org.cloudburstmc.server.utils.BlockColor;

import java.util.concurrent.ThreadLocalRandom;


public class BlockBehaviorSeaLantern extends BlockBehaviorTransparent {

    @Override
    public float getResistance() {
        return 1.5f;
    }

    @Override
    public float getHardness() {
        return 0.3f;
    }

    @Override
    public int getLightLevel(Block block) {
        return 15;
    }

    @Override
    public Item[] getDrops(Block block, Item hand) {
        return new Item[]{
                Item.get(ItemIds.PRISMARINE_CRYSTALS, 0, ThreadLocalRandom.current().nextInt(2, 4))
        };
    }

    @Override
    public BlockColor getColor(Block block) {
        return BlockColor.QUARTZ_BLOCK_COLOR;
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }
}
