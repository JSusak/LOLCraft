package com.saracen.lolcraft.tools;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModItemTier {
    public static final ForgeTier KEANUTIER = new ForgeTier(4,400,20f,10f, 15, Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.EMPTY);
    public static final ForgeTier PRUTHVITIER = new ForgeTier(4,999,60f,1f, 15, Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.EMPTY);
    public static final ForgeTier LEOTIER = new ForgeTier(4,500,10f,1f, 15, Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.EMPTY);
}
