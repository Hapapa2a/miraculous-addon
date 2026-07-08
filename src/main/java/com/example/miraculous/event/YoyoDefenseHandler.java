package com.example.miraculous.event;


import com.example.miraculous.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class YoyoDefenseHandler {


    @SubscribeEvent
    public static void blockDamage(LivingAttackEvent event){


        if(event.getEntity() instanceof Player player){


            if(player.getMainHandItem()
                    .is(ModItems.LADYBUG_YOYO_GIRO.get())){


                event.setCanceled(true);


            }

        }

    }

}