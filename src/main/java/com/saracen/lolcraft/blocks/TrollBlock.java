package com.saracen.lolcraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TrollBlock extends Block {

    public TrollBlock() {
        super(Block.Properties.of(Material.CLAY)
                .strength(6.0f, 10.0f)
                .sound(SoundType.METAL)
                .color(MaterialColor.COLOR_BLACK)
                .lightLevel(BlockState -> 10)
                .requiresCorrectToolForDrops()


        );
    }
}