package net.painandsuffering.pas;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PaSItemsMisc {
	
	public static final Item DEV_LETSPLAYKEKS = registerItem("dev_letsplaykeks", new Item(new FabricItemSettings()
			.maxCount(1)
			.group(PaSMainMod.PAS_MISC_GROUP)
			.food(new FoodComponent.Builder()
					.alwaysEdible()
					.snack()
					.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 2), 1f)
					.build())
			));
	public static final Item DEV_UWUIZLOST = registerItem("dev_uwuizlost", new Item(new FabricItemSettings()
			.maxCount(1)
			.group(PaSMainMod.PAS_MISC_GROUP)
			));
	public static final Item DEV_FLYINGFOXX = registerItem("dev_flyingfoxx", new Item(new FabricItemSettings()
			.maxCount(1)
			.group(PaSMainMod.PAS_MISC_GROUP)
			));
	public static final Item DEV_ANNIKEN = registerItem("dev_anniken", new Item(new FabricItemSettings()
			.maxCount(1)
			.group(PaSMainMod.PAS_MISC_GROUP)
			));
	
	
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(PaSMainMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		PaSMainMod.LOGGER.info("Registering miscellaneous items for Pain and Suffering...");
	}
	

}
