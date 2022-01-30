package com.saracen.lolcraft.tools;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModItemTier {
    public static final ForgeTier KEANUTIER = new ForgeTier(4,999,999f,999f, 99, Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.EMPTY);
    public static final ForgeTier PRUTHVITIER = new ForgeTier(4,2000,9000f,999f, 99, Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.EMPTY);
}
