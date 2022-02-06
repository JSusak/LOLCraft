package com.saracen.lolcraft.tools;

import com.saracen.lolcraft.util.RegistryHandler;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PruthviArmorItem extends ArmorItem {
    public PruthviArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()){
            boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.PRUTHVI_HELMET.get()
                    && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == RegistryHandler.PRUTHVI_CHEST.get()
                    && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == RegistryHandler.PRUTHVI_LEGGINGS.get()
                    && player.getItemBySlot(EquipmentSlot.FEET).getItem() == RegistryHandler.PRUTHVI_BOOTS.get();
            if(fullSet) {
                player.addEffect(new MobEffectInstance(MobEffects.LUCK, 200));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200));
            }
        }
    }
}
