package com.saracen.lolcraft.items.weapons;

import com.saracen.lolcraft.util.RegistryHandler;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;

public class PruthviPickaxe extends PickaxeItem  {
    public PruthviPickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TextComponent("Legendary pickaxe, forged by Pruthvi Patel himself."));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        BlockPos pPos = new BlockPos(player.getX(),player.getY(),player.getZ());
        if(!world.isClientSide()) {
            if(hand==InteractionHand.MAIN_HAND) {
                if (!player.getCooldowns().isOnCooldown(this))
                    world.setSkyFlashTime(10);
                world.playSound(null, pPos, RegistryHandler.SHEESH_SOUND.get(), SoundSource.PLAYERS, 1, 1);
                    player.sendMessage(new TextComponent("I heckin love Tenz"), Util.NIL_UUID);
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 700, 5));
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 700, 5));
                    player.getCooldowns().addCooldown(this, 1500);
            }
            }
        return super.use(world, player, hand);
    }
}
