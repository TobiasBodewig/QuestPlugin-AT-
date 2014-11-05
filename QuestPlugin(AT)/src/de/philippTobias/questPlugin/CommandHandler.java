package de.philippTobias.questPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("basic")) {

			return true;
		}
		return false;
	}

}
