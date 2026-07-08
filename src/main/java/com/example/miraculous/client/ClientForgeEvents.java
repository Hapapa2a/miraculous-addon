package com.example.miraculous.client;

import com.example.miraculous.MiraculousMod;
import com.example.miraculous.item.ModItems;
import com.example.miraculous.sounds.ModSounds;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(
        modid = MiraculousMod.MODID,
        value = Dist.CLIENT
)
public class ClientForgeEvents {


    @SubscribeEvent
    public static void keyInput(InputEvent.Key event) {


        // Tecla X
        if(event.getKey() == 88) {


            Minecraft minecraft = Minecraft.getInstance();

            Player player = minecraft.player;


            if(player == null)
                return;


            ItemStack item = player.getMainHandItem();


            if(item.is(ModItems.MIRACULOUS_JOANINHA_ATIVADO.get())) {


                System.out.println("🐞 SPOTS ON!");


                // 🔊 Som da transformação

                player.playSound(
                        ModSounds.JOANINHA_TRANSFORMATION.get(),
                        1.0F,
                        1.0F
                );


                // 🐞 Equipa traje Ladybug

                player.getInventory().armor.set(
                        2,
                        new ItemStack(ModItems.LADYBUG_CHESTPLATE.get())
                );


                player.getInventory().armor.set(
                        1,
                        new ItemStack(ModItems.LADYBUG_LEGGINGS.get())
                );


                // 🪀 Dá o Yo-Yo

                player.getInventory().add(
                        new ItemStack(ModItems.LADYBUG_YOYO.get())
                );


            } else {


                System.out.println("Segure o Miraculous da Joaninha ativado!");

            }

        }

    }

}