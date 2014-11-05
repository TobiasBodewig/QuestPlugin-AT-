package de.philippTobias.questPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class QuestPlugin extends JavaPlugin {

	private QuestPluginCommangExecutor commandExecutor;

	public void onEnable() {
		commandExecutor = new QuestPluginCommangExecutor(this);
		// getCommand("basic").setExecutor(commandExecutor);
		this.getLogger().info("Questplugin has been enabled.");
	}

	public void onDisable() {
		this.getLogger().info("Questplugin has been disabled.");
	}
}
