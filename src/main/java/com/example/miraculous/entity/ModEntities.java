package com.example.miraculous.entity;

import com.example.miraculous.MiraculousMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MiraculousMod.MODID);

    public static final RegistryObject<EntityType<TikkiEntity>> TIKKI =
            ENTITIES.register("tikki",
                    () -> EntityType.Builder.of(TikkiEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(8)
                            .updateInterval(1)
                            .build("tikki"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}