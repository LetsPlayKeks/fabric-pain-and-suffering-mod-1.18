package net.painandsuffering.pas;

//import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PaSItems {
	
	/*public static final Item COOKIE_DOUGH = registerItem("cookie_dough", new Item(new FabricItemSettings()
			.maxCount(16)
			.group(PaSMainMod.PAS_FOOD_GROUP)
			));*/
	
	
	@SuppressWarnings("unused")
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(PaSMainMod.MOD_ID, name), item);
	}
	
	public static void registerModItems() {
		PaSMainMod.LOGGER.info("Registering items for Pain and Suffering...");
	}
	

}
