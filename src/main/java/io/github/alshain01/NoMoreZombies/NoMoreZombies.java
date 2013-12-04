package io.github.alshain01.NoMoreZombies;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

public class NoMoreZombies extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new SpawnListener(), this);
	}
	
	private class SpawnListener implements Listener {
		@EventHandler(priority = EventPriority.HIGHEST)
		private void onCreatureSpawn(CreatureSpawnEvent e) {
			if(e.getSpawnReason() != SpawnReason.REINFORCEMENTS) { return; }
			e.setCancelled(true);
		}
	}
}
