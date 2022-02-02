package com.saracen.lolcraft.items.weapons;

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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class LeoAxe extends AxeItem  {
    public LeoAxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("BUUUUUUUURRRRRRRRRRPPPPPPPP"));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        BlockPos pPos = new BlockPos(player.getX(),player.getY(),player.getZ());

        if(!world.isClientSide()) {
            if(hand==InteractionHand.MAIN_HAND) {
                if(!player.getCooldowns().isOnCooldown(this)) {
                    world.setSkyFlashTime(30);
                    world.playSound(null, pPos, RegistryHandler.BURP_SOUND.get(), SoundSource.PLAYERS, 1, 1);
                    player.sendMessage(new TextComponent("BUUURRRPRPPPPPP"), Util.NIL_UUID);
                    //First parameter is duration, second is strength.
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 700, 5));
                    player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 700, 5));
                    player.addEffect((new MobEffectInstance((MobEffects.REGENERATION), 700, 5)));
                    //Second parameter is cooldown length.
                    player.getCooldowns().addCooldown(this, 1500);
                }
            }
        }
        return super.use(world, player, hand);
    }
}
