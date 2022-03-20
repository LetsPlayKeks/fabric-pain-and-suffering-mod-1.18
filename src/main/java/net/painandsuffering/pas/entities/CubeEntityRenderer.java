package net.painandsuffering.pas.entities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.painandsuffering.pas.PaSClientEntrypoint;
import net.painandsuffering.pas.PaSMainMod;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel>{

	public CubeEntityRenderer(EntityRendererFactory.Context entityRenderDispatcher) {
		super(entityRenderDispatcher, new CubeEntityModel(entityRenderDispatcher.getPart(PaSClientEntrypoint.MODEL_CUBE_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(CubeEntity var1) {
		return new Identifier(PaSMainMod.MOD_ID, "textures/entity/cube/cube.png");
	}
	
}
