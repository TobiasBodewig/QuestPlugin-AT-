package de.philippTobias.questPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class QuestPlugin extends JavaPlugin {

	private QuestPluginCommangExecutor commandExecutor;

	private PlayerListener playerListener;

	public void onEnable() {
		commandExecutor = new QuestPluginCommangExecutor(this);
		// getCommand("basic").setExecutor(commandExecutor);
		playerListener = new PlayerListener();
		getServer().getPluginManager().registerEvents(playerListener, this);
		this.getLogger().info("Questplugin has been enabled.");
	}

	public void onDisable() {
		this.getLogger().info("Questplugin has been disabled.");
	}
}
