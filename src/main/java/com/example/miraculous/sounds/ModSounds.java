package com.example.miraculous.sounds;

import com.example.miraculous.MiraculousMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(
                    Registries.SOUND_EVENT,
                    MiraculousMod.MODID
            );


    public static final RegistryObject<SoundEvent> JOANINHA_TRANSFORMATION =
            SOUNDS.register(
                    "joaninha_transformation",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(
                                    MiraculousMod.MODID,
                                    "joaninha_transformation"
                            )
                    )
            );

}