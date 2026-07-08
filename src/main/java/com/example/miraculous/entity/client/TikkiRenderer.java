package com.example.miraculous.entity.client;

import com.example.miraculous.MiraculousMod;
import com.example.miraculous.entity.TikkiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TikkiRenderer extends MobRenderer<TikkiEntity, TikkiModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(MiraculousMod.MODID,
                    "textures/entity/tikki.png");

    public TikkiRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new TikkiModel(context.bakeLayer(TikkiModel.LAYER_LOCATION)),
                0.15F
        );
    }

    @Override
    public ResourceLocation getTextureLocation(TikkiEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(TikkiEntity entity, PoseStack poseStack, float partialTick) {

        // deixa a Tikki pequenininha
        poseStack.scale(0.35F, 0.35F, 0.35F);

        super.scale(entity, poseStack, partialTick);
    }
}