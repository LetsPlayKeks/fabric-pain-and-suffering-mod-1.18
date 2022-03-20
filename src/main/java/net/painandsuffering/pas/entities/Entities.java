package net.painandsuffering.pas.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.painandsuffering.pas.PaSMainMod;

public class Entities {
	
	//public static final EntityType<CubeEntity> CUBE = registerEntity("cube", CubeEntity::new, 0.75f, 0.75f);
	public static final EntityType<CubeEntity> CUBEE = Registry.register(Registry.ENTITY_TYPE, new Identifier(PaSMainMod.MOD_ID, "cube"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

			
			
			
		/*private static Item registerEntity(String name, EntityType entityType) {
			return Registry.register(Registry.ENTITY_TYPE, new Identifier(PaSMainMod.MOD_ID, name), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, entityType::new));
	}*/
		
		/*private static EntityType registerEntity(String name, EntityType<Entity> entity, float dimension1, float dimension2) {
			return Registry.register(Registry.ENTITY_TYPE, new Identifier(PaSMainMod.MOD_ID, name),
					FabricEntityTypeBuilder.create(SpawnGroup.CREATURE).dimensions(EntityDimensions.fixed(dimension1, dimension2)).build());
		}
		private static EntityType registerEntityy(EntityType<? extends LivingEntity> type, DefaultAttributeContainer.Builder builder) {
			FabricDefaultAttributeRegistry.register(type, builder);
		}*/
	
		public static void registerModEntities() {
			PaSMainMod.LOGGER.info("Registering entities for Pain and Suffering...");
	}
}
