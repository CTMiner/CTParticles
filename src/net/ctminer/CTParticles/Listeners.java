package net.ctminer.CTParticles;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
	
	CTParticles plugin;
	
	public Listeners(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent evt) {
		plugin.loadPlayer(evt.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent evt) {
		if(plugin.aurachoice.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.aurachoice.remove(evt.getPlayer().getUniqueId());
		}
		if(plugin.auraspeed.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.auraspeed.remove(evt.getPlayer().getUniqueId());
		}
		if(plugin.auraamount.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.auraamount.remove(evt.getPlayer().getUniqueId());
		}
		if(plugin.halochoice.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.halochoice.remove(evt.getPlayer().getUniqueId());
		}
		if(plugin.halospeed.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.halospeed.remove(evt.getPlayer().getUniqueId());
		}
		if(plugin.particlerange.containsKey(evt.getPlayer().getUniqueId())) {
			plugin.particlerange.remove(evt.getPlayer().getUniqueId());
		}
	}
	
}