package com.saracen.lolcraft.items;

import com.saracen.lolcraft.LolCraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().tab(LolCraft.TAB));
    }
}
