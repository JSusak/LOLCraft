package com.saracen.lolcraft.util;

import com.saracen.lolcraft.LolCraft;
import com.saracen.lolcraft.blocks.BlockItemBase;
import com.saracen.lolcraft.blocks.DenzoBlock;
import com.saracen.lolcraft.blocks.TrollBlock;
import com.saracen.lolcraft.blocks.YeagerBlock;
import com.saracen.lolcraft.items.weapons.*;
import com.saracen.lolcraft.tools.ModArmorMaterial;
import com.saracen.lolcraft.tools.ModItemTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//All items, blocks, entities
public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LolCraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LolCraft.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LolCraft.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_LIST = DeferredRegister.create(ForgeRegistries.ENTITIES, LolCraft.MOD_ID);


    public static void init() {

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_LIST.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    // Items (All items use the ItemBase Class)
    public static final RegistryObject<Item> KSWORD = ITEMS.register("keanu_sword", () -> new KeanuSword(ModItemTier.KEANUTIER, 12, 12f, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> P_PICKAXE = ITEMS.register("pruthvi_pickaxe", () -> new PruthviPickaxe(ModItemTier.PRUTHVITIER, 10, 10f, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> L_BATTLEAXE = ITEMS.register("leo_axe", () -> new LeoAxe(ModItemTier.LEOTIER, 11, 11f, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> J_SHOVEL = ITEMS.register("josh_shovel", () -> new JoshShovel(ModItemTier.JOSHTIER,1,1f,new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> D_SCYTHE = ITEMS.register("deniz_scythe", () -> new DenizScythe(ModItemTier.DENIZTIER, 7, 1f,new Item.Properties().tab(LolCraft.TAB)));

    // Blocks (Make a new class for every new block)
    public static final RegistryObject<Block> KYEAGER_BLOCK = BLOCKS.register("grandpa_yeager", YeagerBlock::new);
    public static final RegistryObject<Block> DENZO_BLOCK = BLOCKS.register("denzo_block", DenzoBlock::new);
    public static final RegistryObject<Block> TROLL_BLOCK = BLOCKS.register("troll_block", TrollBlock::new);

    // Block Items
    public static final RegistryObject<Item> KYEAGER_BLOCK_ITEM = ITEMS.register("grandpa_yeager", () -> new BlockItemBase(KYEAGER_BLOCK.get()));
    public static final RegistryObject<Item> DENZO_BLOCK_ITEM = ITEMS.register("denzo_block", () -> new BlockItemBase(DENZO_BLOCK.get()));
    public static final RegistryObject<Item> TROLL_BLOCK_ITEM = ITEMS.register("troll_block", () -> new BlockItemBase(TROLL_BLOCK.get()));

    //Armor
    public static final RegistryObject<Item> WILLY_HELMET = ITEMS.register("willy_head", () -> new ArmorItem(ModArmorMaterial.WILLY, EquipmentSlot.HEAD, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> WILLY_CHEST = ITEMS.register("willy_chest", () -> new ArmorItem(ModArmorMaterial.WILLY, EquipmentSlot.CHEST, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> WILLY_LEGGINGS = ITEMS.register("willy_leggings", () -> new ArmorItem(ModArmorMaterial.WILLY, EquipmentSlot.LEGS, new Item.Properties().tab(LolCraft.TAB)));
    public static final RegistryObject<Item> WILLY_BOOTS = ITEMS.register("willy_boots", () -> new ArmorItem(ModArmorMaterial.WILLY, EquipmentSlot.FEET, new Item.Properties().tab(LolCraft.TAB)));

   public static final RegistryObject<SoundEvent> DENZO_SOUND = SOUND_EVENTS.register("denzo_laugh", () -> new SoundEvent(new ResourceLocation(LolCraft.MOD_ID,"denzo_laugh")));
    public static final RegistryObject<SoundEvent> SMOREZ_SOUND = SOUND_EVENTS.register("smorez", () -> new SoundEvent(new ResourceLocation(LolCraft.MOD_ID,"smorez")));
    public static final RegistryObject<SoundEvent> SHEESH_SOUND = SOUND_EVENTS.register("sheesh",() -> new SoundEvent(new ResourceLocation(LolCraft.MOD_ID,"sheesh")));
    public static final RegistryObject<SoundEvent> BURP_SOUND = SOUND_EVENTS.register("burp",() -> new SoundEvent(new ResourceLocation(LolCraft.MOD_ID,"burp")));





}
