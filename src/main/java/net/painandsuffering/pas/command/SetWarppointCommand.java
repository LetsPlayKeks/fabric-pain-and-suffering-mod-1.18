package net.painandsuffering.pas.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.painandsuffering.pas.PaSMainMod;
import net.painandsuffering.pas.util.IEntityDataSaver;

public class SetWarppointCommand {
	
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
		dispatcher.register(CommandManager.literal("warppoint")
			.then(CommandManager.literal("set")
			.executes(SetWarppointCommand::run)));
	}
	
	public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
		BlockPos playerPos = context.getSource().getPlayer().getBlockPos();
		String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";
		
			player.getPersistentData().putIntArray(PaSMainMod.MOD_ID + ".warppointpos", new int[] {playerPos.getX(), playerPos.getY(), playerPos.getZ() });
			context.getSource().sendFeedback(new LiteralText("Set Warppoint at " + pos), true);
		
		return 1;
	}

}
