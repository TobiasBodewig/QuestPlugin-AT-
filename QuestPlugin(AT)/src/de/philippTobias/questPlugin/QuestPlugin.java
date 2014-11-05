package de.philippTobias.questPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestPlugin extends JavaPlugin {

	private CommandHandler commandHandler;

	public void onEnable() {
		commandHandler = new CommandHandler();
		this.getLogger().info("Questplugin has been enabled.");
	}

	public void onDisable() {
		this.getLogger().info("Questplugin has been disabled.");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		return commandHandler.onCommand(sender, cmd, commandLabel, args);
	}
}
