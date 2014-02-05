package net.ctminer;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Ticker implements Runnable {
	
	CTParticles plugin;
	
	public Ticker(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			Location l = p.getLocation();
			l.setY(l.getY() + .5);
			if(plugin.aurachoice.containsKey(p.getName())) {
				ParticleEffect.fromName(plugin.aurachoice.get(p.getName())).display(l, (float) .5, (float) 1, (float) .5, ((plugin.auraspeed.containsKey(p.getName()) ? plugin.auraspeed.get(p.getName()) : 0)), ((plugin.auraamount.containsKey(p.getName()) ? plugin.auraamount.get(p.getName()) : 3)));
			}
		}
	}
}
