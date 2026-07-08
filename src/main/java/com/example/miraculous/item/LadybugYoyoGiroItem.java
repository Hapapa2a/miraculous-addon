package com.example.miraculous.item;

import com.example.miraculous.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;


public class LadybugYoyoGiroItem extends SwordItem {


    public LadybugYoyoGiroItem(
            Tier tier,
            int damage,
            float speed,
            Properties properties
    ) {

        super(tier, damage, speed, properties);

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
                    new ItemStack(ModItems.LADYBUG_YOYO.get())
            );


        }


        return InteractionResultHolder.success(stack);
    }

}