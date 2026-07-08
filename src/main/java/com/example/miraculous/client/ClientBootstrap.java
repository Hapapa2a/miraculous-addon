package com.example.miraculous.client;

import com.example.miraculous.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "miraculous", value = Dist.CLIENT)
public class ClientBootstrap {

    public static void init() {

        ItemProperties.register(
                ModItems.MIRACULOUS_JOANINHA.get(),
                new ResourceLocation("miraculous", "state"),
                (stack, level, entity, seed) -> {
                    CompoundTag tag = stack.getTag();
                    return tag != null && tag.getInt("TransformationState") == 1 ? 1.0F : 0.0F;
                }
        );
    }
}