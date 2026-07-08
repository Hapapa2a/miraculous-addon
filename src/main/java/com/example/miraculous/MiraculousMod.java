package com.example.miraculous;

import com.example.miraculous.entity.ModEntities;
import com.example.miraculous.item.ModCreativeTabs;
import com.example.miraculous.item.ModItems;
import com.example.miraculous.sounds.ModSounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(MiraculousMod.MODID)
public class MiraculousMod {


    public static final String MODID = "miraculous";


    public MiraculousMod() {


        IEventBus eventBus =
                FMLJavaModLoadingContext
                        .get()
                        .getModEventBus();


        ModItems.register(eventBus);

        ModEntities.register(eventBus);

        ModCreativeTabs.register(eventBus);

        // 🔊 Sons do Miraculous
        ModSounds.SOUNDS.register(eventBus);

    }

}