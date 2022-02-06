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

public class WilliamArmorItem extends ArmorItem {
    public WilliamArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()){
            boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.WILLY_HELMET.get()
                    && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == RegistryHandler.WILLY_CHEST.get()
                    && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == RegistryHandler.WILLY_LEGGINGS.get()
                    && player.getItemBySlot(EquipmentSlot.FEET).getItem() == RegistryHandler.WILLY_BOOTS.get();

            if(fullSet){
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200));
            }
        }
    }
}
