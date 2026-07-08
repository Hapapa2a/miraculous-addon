package com.example.miraculous.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MiraculousJoaninhaAtivadoItem extends Item {

    public MiraculousJoaninhaAtivadoItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {

            player.setItemInHand(
                    hand,
                    new ItemStack(ModItems.MIRACULOUS_JOANINHA.get())
            );
        }

        return InteractionResultHolder.sidedSuccess(
                player.getItemInHand(hand),
                level.isClientSide()
        );
    }
}