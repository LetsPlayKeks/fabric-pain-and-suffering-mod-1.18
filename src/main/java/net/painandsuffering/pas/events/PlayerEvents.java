package net.painandsuffering.pas.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.painandsuffering.pas.PaSMainMod;
import net.painandsuffering.pas.util.IEntityDataSaver;

public class PlayerEvents implements ServerPlayerEvents.CopyFrom {

	@Override
	public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
		IEntityDataSaver original = ((IEntityDataSaver) oldPlayer);
		IEntityDataSaver player = ((IEntityDataSaver) newPlayer);
		
		player.getPersistentData().putIntArray(PaSMainMod.MOD_ID + ".warppoint", original.getPersistentData().getIntArray(PaSMainMod.MOD_ID + ".warppoint"));
	}

}
