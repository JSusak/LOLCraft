package com.saracen.lolcraft.blocks;

import com.saracen.lolcraft.LolCraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().tab(LolCraft.TAB));
    }
}
