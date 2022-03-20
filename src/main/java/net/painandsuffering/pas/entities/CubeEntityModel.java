package net.painandsuffering.pas.entities;

import org.spongepowered.include.com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class CubeEntityModel extends EntityModel<CubeEntity>{

	private final ModelPart base;
	
	public CubeEntityModel(ModelPart modelPart) {
		//this.textureHeight = 64;
		//this.textureWidth = 64;
		this.base = modelPart.getChild(EntityModelPartNames.CUBE);
		
		//base = new ModelPart(this, 0, 0);
		
		//base.addCuboid(-6, -6, -6, 12, 12, 12);
	}
	
	public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
    	ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0, 0).cuboid(-6F, -6F, -6F, 12F, 12F, 12F), ModelTransform.pivot(0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

	@Override
	public void setAngles(CubeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue,
			float alpha) {
		ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
		//base.render(matrices, vertices, light, overlay);
	}


}
