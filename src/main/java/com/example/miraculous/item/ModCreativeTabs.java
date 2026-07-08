package com.example.miraculous.item;

import com.example.miraculous.MiraculousMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeTabs {


    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(
                    Registries.CREATIVE_MODE_TAB,
                    MiraculousMod.MODID
            );


    static {
        System.out.println("🔥 CREATIVE TAB MIRACULOUS CARREGOU");
    }



    public static final RegistryObject<CreativeModeTab> MIRACULOUS_TAB =
            TABS.register("miraculous_tab",
                    () -> CreativeModeTab.builder()

                            .title(Component.literal("Miraculous"))

                            .icon(() -> new ItemStack(
                                    ModItems.MIRACULOUS_JOANINHA.get()
                            ))


                            .displayItems((params, output) -> {


                                // Miraculous
                                output.accept(
                                        ModItems.MIRACULOUS_JOANINHA.get()
                                );


                                output.accept(
                                        ModItems.MIRACULOUS_JOANINHA_ATIVADO.get()
                                );


                                // Traje Ladybug 🐞
                                output.accept(
                                        ModItems.LADYBUG_CHESTPLATE.get()
                                );

                                output.accept(ModItems.LADYBUG_YOYO.get());


                                output.accept(
                                        ModItems.LADYBUG_LEGGINGS.get()
                                );


                            })

                            .build()
            );



    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

}