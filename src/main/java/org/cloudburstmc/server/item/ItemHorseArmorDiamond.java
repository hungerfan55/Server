package org.cloudburstmc.server.item;

import org.cloudburstmc.server.utils.Identifier;

public class ItemHorseArmorDiamond extends Item {

    public ItemHorseArmorDiamond(Identifier id) {
        super(id);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
