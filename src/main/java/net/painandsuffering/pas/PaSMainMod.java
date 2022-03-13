package net.painandsuffering.pas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class PaSMainMod implements ModInitializer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("pas");
	
	public static final ItemGroup PAS_FOOD_GROUP = FabricItemGroupBuilder.create(
			new Identifier("pas", "food"))
			.icon(() -> new ItemStack(Items.AIR))
			.build();
	
	public static final ItemGroup PAS_BLOCK_GROUP = FabricItemGroupBuilder.create(
			new Identifier("pas", "block"))
			.icon(() -> new ItemStack(Items.COBBLED_DEEPSLATE))
			.build();
	
	public static final Item COOKIE_DOUGH = new Item(new FabricItemSettings().group(PaSMainMod.PAS_FOOD_GROUP).maxCount(16));
	public static final Block CURSE = new Block(FabricBlockSettings.of(Material.SOIL).build());
	

	
	@Override
	public void onInitialize() {
		
		Registry.register(Registry.BLOCK, new Identifier("the_curse", "test_item"), CURSE);
		Registry.register(Registry.ITEM, new Identifier("the_curse", "test_item"), new BlockItem(CURSE, new FabricItemSettings().group(PaSMainMod.PAS_FOOD_GROUP)));
		Registry.register(Registry.ITEM, new Identifier("pas", "cookie_dough"), new Item(new FabricItemSettings().group(PaSMainMod.PAS_FOOD_GROUP)));
		
				
		LOGGER.info("Hello Fabric world!");
	}
	
}
