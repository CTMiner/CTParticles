package net.ctminer.CTParticles;

import java.util.ArrayList;

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
			if(plugin.aurachoice.containsKey(p.getUniqueId())) {
				Location playermiddle = new Location(l.getWorld(), l.getX(), (l.getY() + 1), l.getZ());
				ParticleEffect.fromName(plugin.aurachoice.get(p.getUniqueId())).display((float) .25, (float) 1, (float) .25, ((plugin.auraspeed.containsKey(p.getUniqueId()) ? plugin.auraspeed.get(p.getUniqueId()) : 0)), ((plugin.auraamount.containsKey(p.getUniqueId()) ? plugin.auraamount.get(p.getUniqueId()) : 3)), playermiddle, ((plugin.particlerange.containsKey(p.getUniqueId()) ? plugin.particlerange.get(p.getUniqueId()) : 20)));
			}
			if(((System.currentTimeMillis() % 3) == 0) && plugin.halochoice.containsKey(p.getUniqueId())) {
				Location halocenter = l.clone();
				halocenter.setY(halocenter.getY() + 2);
				ArrayList<Location> halopts = new ArrayList<Location>();
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() + .5), halocenter.getY(), (halocenter.getZ())));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() + .43), halocenter.getY(), (halocenter.getZ() + .25)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() + .25), halocenter.getY(), (halocenter.getZ() + .43)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX()), halocenter.getY(), (halocenter.getZ() + .5)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() - .25), halocenter.getY(), (halocenter.getZ() + .43)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() - .43), halocenter.getY(), (halocenter.getZ() + .25)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() - .5), halocenter.getY(), (halocenter.getZ())));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() - .43), halocenter.getY(), (halocenter.getZ() - .25)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() - .25), halocenter.getY(), (halocenter.getZ() - .43)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX()), halocenter.getY(), (halocenter.getZ() - .5)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() + .25), halocenter.getY(), (halocenter.getZ() - .43)));
				halopts.add(new Location(halocenter.getWorld(), (halocenter.getX() + .43), halocenter.getY(), (halocenter.getZ() - .25)));
				for(Location pt : halopts) {
					ParticleEffect.fromName(plugin.halochoice.get(p.getUniqueId())).display(0, 0, 0, ((plugin.halospeed.containsKey(p.getUniqueId()) ? plugin.halospeed.get(p.getUniqueId()) : 0)), 1, pt, ((plugin.particlerange.containsKey(p.getUniqueId()) ? plugin.particlerange.get(p.getUniqueId()) : 20)));
				}
			}
		}
	}
}