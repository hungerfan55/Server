package org.cloudburstmc.server.item;

import org.cloudburstmc.server.utils.Identifier;

public class ItemHorseArmorLeather extends Item {

    public ItemHorseArmorLeather(Identifier id) {
        super(id);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
