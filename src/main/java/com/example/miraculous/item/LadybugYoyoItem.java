package com.example.miraculous.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class LadybugYoyoItem extends Item {


    public LadybugYoyoItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {


        ItemStack stack = player.getItemInHand(hand);


        if(!level.isClientSide) {


            player.setItemInHand(
                    hand,
                    new ItemStack(ModItems.LADYBUG_YOYO_GIRO.get())
            );


        }


        return InteractionResultHolder.success(stack);
    }

}