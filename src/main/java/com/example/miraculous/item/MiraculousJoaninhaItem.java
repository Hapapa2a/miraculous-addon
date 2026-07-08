package com.example.miraculous.item;

import com.example.miraculous.entity.ModEntities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MiraculousJoaninhaItem extends Item {

    public MiraculousJoaninhaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {

            // Spawn da Tikki
            var tikki = ModEntities.TIKKI.get().create(level);

            if (tikki != null) {

                tikki.moveTo(
                        player.getX() + 1,
                        player.getY() + 1,
                        player.getZ()
                );

                tikki.setOwner(player);
                level.addFreshEntity(tikki);
            }

            // Troca o item para a versão ativada
            ItemStack activated = new ItemStack(ModItems.MIRACULOUS_JOANINHA_ATIVADO.get());
            player.setItemInHand(hand, activated);

            return InteractionResultHolder.success(activated);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}