package org.cloudburstmc.server.block.behavior;

import com.nukkitx.math.vector.Vector3f;
import org.cloudburstmc.server.block.Block;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.block.BlockTraits;
import org.cloudburstmc.server.item.Item;
import org.cloudburstmc.server.item.ItemTool;
import org.cloudburstmc.server.math.Direction;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.BlockColor;
import org.cloudburstmc.server.utils.data.TreeSpecies;

//Block state information: https://hastebin.com/emuvawasoj.js
public class BlockBehaviorWood extends BlockBehaviorSolid {
    public static final int OAK = 0;
    public static final int SPRUCE = 1;
    public static final int BIRCH = 2;
    public static final int JUNGLE = 3;
    public static final int ACACIA = 4;
    public static final int DARK_OAK = 5;
    private static final int STRIPPED_BIT = 0b1000;
    private static final int AXIS_Y = 0;
    private static final int AXIS_X = 1 << 4;
    private static final int AXIS_Z = 2 << 4;

    @Override
    public float getHardness() {
        return 2;
    }

    @Override
    public float getResistance() {
        return 15;
    }

    @Override
    public int getBurnChance() {
        return 5;
    }

    @Override
    public int getBurnAbility() {
        return 20;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public Item toItem(Block block) {
        return Item.get(block.getState().resetTrait(BlockTraits.AXIS));
    }


    @Override
    public boolean canBeActivated(Block block) {
        return !isStripped(block.getState());
    }

    @Override
    public boolean onActivate(Block block, Item item, Player player) {
        if (!item.isAxe() || !player.isCreative() && !item.useOn(block)) {
            return false;
        }

        block.set(block.getState().withTrait(BlockTraits.IS_STRIPPED, true), true);
        return true;
    }

    public boolean isStripped(BlockState state) {
        return state.ensureTrait(BlockTraits.IS_STRIPPED);
    }

    public Direction.Axis getAxis(BlockState state) {
        return state.ensureTrait(BlockTraits.AXIS);
    }

    @Override
    public boolean place(Item item, Block block, Block target, Direction face, Vector3f clickPos, Player player) {
        return placeBlock(block, item.getBlock().withTrait(BlockTraits.AXIS, face.getAxis()));
    }

    public TreeSpecies getWoodType(BlockState state) {
        return state.ensureTrait(BlockTraits.TREE_SPECIES);
    }

    @Override
    public BlockColor getColor(Block block) {
        switch (getWoodType(block.getState())) {
            default:
            case OAK:
                return BlockColor.WOOD_BLOCK_COLOR;
            case SPRUCE:
                return BlockColor.SPRUCE_BLOCK_COLOR;
            case BIRCH:
                return BlockColor.SAND_BLOCK_COLOR;
            case JUNGLE:
                return BlockColor.DIRT_BLOCK_COLOR;
            case ACACIA:
                return BlockColor.ORANGE_BLOCK_COLOR;
            case DARK_OAK: //DARK OAK
                return BlockColor.BROWN_BLOCK_COLOR;
        }
    }
}
