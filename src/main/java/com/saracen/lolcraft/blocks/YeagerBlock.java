package com.saracen.lolcraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class YeagerBlock extends Block {
    public YeagerBlock() {
        super(Block.Properties.of(Material.GLASS)
                .strength(2.0f, 5.0f)
                .sound(SoundType.GLASS)
                .requiresCorrectToolForDrops()




        );
    }
}
