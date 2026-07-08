package com.example.miraculous.item;

import com.example.miraculous.MiraculousMod;
import com.example.miraculous.armor.ModArmorMaterials;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem.Type;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(
                    ForgeRegistries.ITEMS,
                    MiraculousMod.MODID
            );


    // Miraculous da Joaninha
    public static final RegistryObject<Item> MIRACULOUS_JOANINHA =
            ITEMS.register("miraculous_joaninha",
                    () -> new MiraculousJoaninhaItem(
                            new Item.Properties().stacksTo(1)
                    ));


    // Miraculous ativado
    public static final RegistryObject<Item> MIRACULOUS_JOANINHA_ATIVADO =
            ITEMS.register("miraculous_joaninha_ativado",
                    () -> new MiraculousJoaninhaAtivadoItem(
                            new Item.Properties().stacksTo(1)
                    ));



    // Peitoral da Ladybug
    public static final RegistryObject<Item> LADYBUG_CHESTPLATE =
            ITEMS.register("ladybug_chestplate",
                    () -> new ArmorItem(
                            ModArmorMaterials.LADYBUG,
                            Type.CHESTPLATE,
                            new Item.Properties()
                    ));



    // Calça da Ladybug
    public static final RegistryObject<Item> LADYBUG_LEGGINGS =
            ITEMS.register("ladybug_leggings",
                    () -> new ArmorItem(
                            ModArmorMaterials.LADYBUG,
                            Type.LEGGINGS,
                            new Item.Properties()
                    ));


    public static final RegistryObject<Item> LADYBUG_YOYO =
            ITEMS.register(
                    "ladybug_yoyo",
                    () -> new LadybugYoyoItem(
                            new Item.Properties()
                                    .stacksTo(1)
                    )
            );


    public static final RegistryObject<Item> LADYBUG_YOYO_GIRO =
            ITEMS.register(
                    "joaninha_yoyo_giro",
                    () -> new LadybugYoyoGiroItem(
                            ModToolTiers.YOYO,
                            5,
                            -2.4F,
                            new Item.Properties()
                                    .stacksTo(1)
                    )
            );




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}