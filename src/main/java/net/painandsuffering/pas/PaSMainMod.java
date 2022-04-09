package net.painandsuffering.pas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.painandsuffering.pas.entities.CubeEntity;
//import net.painandsuffering.pas.util.ModCommandRegister;
//import net.painandsuffering.pas.util.ModEventsRegister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("deprecation")
public class PaSMainMod implements ModInitializer {
	
	public static String MOD_ID = "pas";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	public static final ItemGroup PAS_FOOD_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "food"))
			.icon(() -> new ItemStack(PaSFood.COOKIE_DOUGH))
			.build();
	
	public static final ItemGroup PAS_BLOCK_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "block"))
			.icon(() -> new ItemStack(Items.COBBLED_DEEPSLATE))
			.build();
	public static final ItemGroup PAS_MISC_GROUP = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "misc"))
			.icon(() -> new ItemStack(PaSItemsMisc.DEV_LETSPLAYKEKS))
			.build();
	
	public static final Block CURSE = new Block(FabricBlockSettings.of(Material.SOIL).build());
	
	public static final EntityType<CubeEntity> CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier(PaSMainMod.MOD_ID, "cube"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
	
	
	@Override
	public void onInitialize() {
		PaSItems.registerModItems();
		PaSFood.registerModFood();
		PaSItemsMisc.registerModItems();
		
		FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());
		
		//ModCommandRegister.registerCommands();
		//ModEventsRegister.registerEvents();
		
		Registry.register(Registry.BLOCK, new Identifier("the_curse", "test_item"), CURSE);
		Registry.register(Registry.ITEM, new Identifier("the_curse", "test_item"), new BlockItem(CURSE, new FabricItemSettings().group(PaSMainMod.PAS_FOOD_GROUP)));
		
				
		LOGGER.info("Hello Fabric world!");
	}
	
}
