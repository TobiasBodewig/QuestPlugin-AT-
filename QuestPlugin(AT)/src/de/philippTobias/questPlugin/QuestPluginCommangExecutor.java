package de.philippTobias.questPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class QuestPluginCommangExecutor implements CommandExecutor {

	private QuestPlugin plugin;

	public QuestPluginCommangExecutor(QuestPlugin plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("basic")) {

			return true;
		}
		return false;
	}

}
