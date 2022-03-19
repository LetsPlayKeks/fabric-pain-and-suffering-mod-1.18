package net.painandsuffering.pas.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.painandsuffering.pas.command.SetWarppointCommand;
import net.painandsuffering.pas.command.WarpWarppointCommand;

public class ModCommandRegister {
	public static void registerCommands() {
		CommandRegistrationCallback.EVENT.register(WarpWarppointCommand::register);
		CommandRegistrationCallback.EVENT.register(SetWarppointCommand::register);
	}
}
