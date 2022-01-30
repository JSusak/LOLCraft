package com.saracen.lolcraft.blocks;


import com.saracen.lolcraft.util.RegistryHandler;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;


public class DenzoBlock extends TntBlock {
    public DenzoBlock() {
        super(Block.Properties.of(Material.EXPLOSIVE)

                .color(MaterialColor.COLOR_CYAN)
                .strength(2.0f, 3.0f)
                .sound(SoundType.CHAIN)
                .dynamicShape()
                .jumpFactor(90f)


        );
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            if(pHand==InteractionHand.MAIN_HAND) {
                pPlayer.sendMessage(new TextComponent("No shot dude"), Util.NIL_UUID);
                pLevel.playSound(null, pPos, RegistryHandler.DENZO_SOUND.get(), SoundSource.BLOCKS , 1, 1);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if(!pLevel.isClientSide()) {
            if(pEntity instanceof LivingEntity entity) {
                entity.addEffect((new MobEffectInstance(MobEffects.POISON, 200)));
                entity.addEffect((new MobEffectInstance(MobEffects.CONFUSION, 200)));
                pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 100.0F, true, Explosion.BlockInteraction.DESTROY);
                entity.sendMessage(new TextComponent("Sheeeesh fam no origin vandal again"), Util.NIL_UUID);
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}