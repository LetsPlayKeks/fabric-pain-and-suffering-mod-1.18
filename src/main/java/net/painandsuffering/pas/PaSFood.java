package net.painandsuffering.pas;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PaSFood {
	
	public static final Item COOKIE_DOUGH = registerItem("cookie_dough", new Item(new FabricItemSettings()
			.maxCount(16)
			.group(PaSMainMod.PAS_FOOD_GROUP)
			.food(new FoodComponent.Builder()
					.alwaysEdible()
					.hunger(2)
					.saturationModifier(1f)
					.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*4, 3), .6f)
					.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10, 1), 1f)
					.build())
			));
	
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(PaSMainMod.MOD_ID, name), item);
	}
	
	public static void registerModFood() {
		PaSMainMod.LOGGER.info("Registering food for Pain and Suffering...");
	}
	

}
