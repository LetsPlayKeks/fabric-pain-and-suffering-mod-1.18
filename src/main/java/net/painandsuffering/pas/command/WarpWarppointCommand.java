package net.painandsuffering.pas.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.painandsuffering.pas.PaSMainMod;
import net.painandsuffering.pas.util.IEntityDataSaver;

public class WarpWarppointCommand {
	
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
		dispatcher.register(CommandManager.literal("warppoint")
			.then(CommandManager.literal("warp")
			.executes(WarpWarppointCommand::run)));
	}
	
	
	public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
		
			if(player.getPersistentData().contains(PaSMainMod.MOD_ID + ".warppointpos") && 
				player.getPersistentData().getIntArray(PaSMainMod.MOD_ID + ".warppointpos").length != 0) {
				int[] playerPos = player.getPersistentData().getIntArray(PaSMainMod.MOD_ID + ".warppointpos");
		
				context.getSource().getPlayer().requestTeleport(playerPos[0]+.5, playerPos[1], playerPos[2]+.5);
			} else {context.getSource().sendError(new LiteralText("Warppoint doesn't exists.")); return -1;}
		
		return 1;
	}
	
}
