package org.cloudburstmc.server.item;

import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.block.BlockTypes;
import org.cloudburstmc.server.utils.Identifier;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class ItemCarrot extends ItemEdible {

    public ItemCarrot(Identifier id) {
        super(id);
    }

    @Override
    public BlockState getBlock() {
        return BlockState.get(BlockTypes.CARROTS);
    }
}
