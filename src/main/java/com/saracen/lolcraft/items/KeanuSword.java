package com.saracen.lolcraft.items;

import com.saracen.lolcraft.util.RegistryHandler;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.sound.SoundEvent;

import javax.annotation.Nullable;
import java.util.List;

public class KeanuSword extends SwordItem {
    public KeanuSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("I smurf your peak - Keanu Le"));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        BlockPos pPos = new BlockPos(player.getX(),player.getY(),player.getZ());

        if(!world.isClientSide()) {
            if(hand==InteractionHand.MAIN_HAND) {
                if(!player.getCooldowns().isOnCooldown(this)) {
                    world.playSound(null, pPos, RegistryHandler.SMOREZ_SOUND.get(), SoundSource.PLAYERS, 1, 1);
                    player.sendMessage(new TextComponent("I heckin love Tenz"), Util.NIL_UUID);
                    //First parameter is duration, second is strength.
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 700, 5));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 700, 5));
                    player.addEffect((new MobEffectInstance((MobEffects.SLOW_FALLING), 700, 5)));
                    //Second parameter is cooldown length.
                    player.getCooldowns().addCooldown(this, 1500);
                }
            }
        }
        return super.use(world, player, hand);
    }
}
