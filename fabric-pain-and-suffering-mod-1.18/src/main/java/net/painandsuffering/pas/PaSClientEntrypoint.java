package net.painandsuffering.pas;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.LiteralText;

public class PaSClientEntrypoint implements ClientModInitializer{

	private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(
					new KeyBinding(
					"key.pas.spook",
					InputUtil.Type.KEYSYM,
					GLFW.GLFW_KEY_R,
					"category.pas.test"));
	
	@Override
	public void onInitializeClient() {
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
				//client.player.addStatusEffect(new StatusEffectInstance(StatusEffectInstance.));
			}
		});
		
	}
	



}
