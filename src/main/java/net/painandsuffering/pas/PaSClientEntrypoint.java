package net.painandsuffering.pas;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.painandsuffering.pas.entities.CubeEntityRenderer;
import net.painandsuffering.pas.entities.CubeEntityModel;

@SuppressWarnings("deprecation")
public class PaSClientEntrypoint implements ClientModInitializer{
	
	public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier(PaSMainMod.MOD_ID, "cube"), "main");

	private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(
					new KeyBinding(
					"key.pas.speed",
					InputUtil.Type.KEYSYM,
					GLFW.GLFW_KEY_R,
					"category.pas.test"));
	
	@Override
	public void onInitializeClient() {
		
		EntityRendererRegistry.INSTANCE.register(PaSMainMod.CUBE, (context) -> {
            return new CubeEntityRenderer(context);
        });
		
		EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTexturedModelData);
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.isPressed() && client.player != null) {
				client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5, 5));
				//client.player.addStatusEffect(null)
			} while ((!keyBinding.isPressed()) && client.player != null) { client.player.removeStatusEffect(StatusEffects.SPEED);}
		});
		
	}
	



}
