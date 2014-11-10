package de.philippTobias.questPlugin;

import net.citizensnpcs.api.event.NPCRightClickEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {

	}

	@EventHandler
	public void onNPCRightClick(NPCRightClickEvent event) {
		event.getClicker().sendMessage("NPCRightClickEvent");
	}
}
