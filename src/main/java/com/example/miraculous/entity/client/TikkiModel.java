package com.example.miraculous.entity.client;

import com.example.miraculous.entity.TikkiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class TikkiModel extends EntityModel<TikkiEntity> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("miraculous","tikki"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public TikkiModel(ModelPart root){
        this.root = root;
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leftWing = body.getChild("leftWing");
        this.rightWing = body.getChild("rightWing");
    }

    public static LayerDefinition createBodyLayer(){
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("head",
            CubeListBuilder.create().texOffs(0,0)
                .addBox(-3F,-6F,-3F,6F,6F,6F),
            PartPose.offset(0F,16F,0F));

        PartDefinition body = root.addOrReplaceChild("body",
            CubeListBuilder.create().texOffs(0,12)
                .addBox(-2F,0F,-1.5F,4F,5F,3F),
            PartPose.offset(0F,16F,0F));

        body.addOrReplaceChild("leftWing",
            CubeListBuilder.create().texOffs(20,0)
                .addBox(0F,-1F,0F,4F,6F,0F),
            PartPose.offset(2F,1F,1F));

        body.addOrReplaceChild("rightWing",
            CubeListBuilder.create().texOffs(20,0).mirror()
                .addBox(-4F,-1F,0F,4F,6F,0F),
            PartPose.offset(-2F,1F,1F));

        return LayerDefinition.create(mesh,64,64);
    }

    @Override
    public void setupAnim(TikkiEntity entity,float limbSwing,float limbSwingAmount,float ageInTicks,float netHeadYaw,float headPitch){
        head.yRot = netHeadYaw * ((float)Math.PI/180F);
        head.xRot = headPitch * ((float)Math.PI/180F);

        float flap = (float)Math.sin(ageInTicks*1.2F)*0.6F;
        leftWing.zRot = flap;
        rightWing.zRot = -flap;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int light, int overlay,
                               float red,float green,float blue,float alpha){
        root.render(poseStack,buffer,light,overlay,red,green,blue,alpha);
    }
}
