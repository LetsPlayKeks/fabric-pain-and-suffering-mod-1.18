package net.painandsuffering.pas;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PaSItems {
	
	public static final Item DEV_LETSPLAYKEKS_ITEM = registerItem("dev_letsplaykeks", new Item(new FabricItemSettings()
			.maxCount(1)
			.group(PaSMainMod.PAS_MISC_GROUP)
			));
	
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(PaSMainMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		PaSMainMod.LOGGER.info("Registering items for Pain and Suffering...");
	}
	

}
