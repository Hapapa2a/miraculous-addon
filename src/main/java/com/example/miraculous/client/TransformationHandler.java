package com.example.miraculous.client;

import com.example.miraculous.MiraculousMod;
import com.example.miraculous.item.ModItems;
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
public class TransformationHandler {


    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {


        if(KeyBindings.TRANSFORM_KEY.consumeClick()) {


            Minecraft minecraft = Minecraft.getInstance();

            Player player = minecraft.player;


            if(player == null)
                return;


            ItemStack item = player.getMainHandItem();


            if(item.is(ModItems.MIRACULOUS_JOANINHA_ATIVADO.get())) {

                System.out.println("🐞 SPOTS ON!");

            } else {

                System.out.println("Segure o Miraculous da Joaninha!");

            }

        }

    }
}