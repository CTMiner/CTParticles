package net.ctminer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
	
	CTParticles plugin;
	
	public Listeners(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent evt) {
		if(plugin.aurachoice.containsKey(evt.getPlayer().getName())) {
			plugin.aurachoice.remove(evt.getPlayer().getName());
		}
		if(plugin.auraspeed.containsKey(evt.getPlayer().getName())) {
			plugin.auraspeed.remove(evt.getPlayer().getName());
		}
		if(plugin.auraamount.containsKey(evt.getPlayer().getName())) {
			plugin.auraamount.remove(evt.getPlayer().getName());
		}
		if(plugin.halochoice.containsKey(evt.getPlayer().getName())) {
			plugin.halochoice.remove(evt.getPlayer().getName());
		}
		if(plugin.halospeed.containsKey(evt.getPlayer().getName())) {
			plugin.halospeed.remove(evt.getPlayer().getName());
		}
	}
	
}
