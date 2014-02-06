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
			if(plugin.aurachoice.containsKey(p.getName())) {
				Location playermiddle = new Location(l.getWorld(), l.getX(), (l.getY() + 1), l.getZ());
				ParticleEffect.fromName(plugin.aurachoice.get(p.getName())).display(playermiddle, (float) .25, (float) 1, (float) .25, ((plugin.auraspeed.containsKey(p.getName()) ? plugin.auraspeed.get(p.getName()) : 0)), ((plugin.auraamount.containsKey(p.getName()) ? plugin.auraamount.get(p.getName()) : 3)));
			}
			if(((System.currentTimeMillis() % 3) == 0) && plugin.halochoice.containsKey(p.getName())) {
				Location halocenter = l;
				halocenter.setY(halocenter.getY() + 2);
				Location h1 = new Location(halocenter.getWorld(), (halocenter.getX() + .5), halocenter.getY(), (halocenter.getZ()));
				Location h2 = new Location(halocenter.getWorld(), (halocenter.getX() + .43), halocenter.getY(), (halocenter.getZ() + .25));
				Location h3 = new Location(halocenter.getWorld(), (halocenter.getX() + .25), halocenter.getY(), (halocenter.getZ() + .43));
				Location h4 = new Location(halocenter.getWorld(), (halocenter.getX()), halocenter.getY(), (halocenter.getZ() + .5));
				Location h5 = new Location(halocenter.getWorld(), (halocenter.getX() - .25), halocenter.getY(), (halocenter.getZ() + .43));
				Location h6 = new Location(halocenter.getWorld(), (halocenter.getX() - .43), halocenter.getY(), (halocenter.getZ() + .25));
				Location h7 = new Location(halocenter.getWorld(), (halocenter.getX() - .5), halocenter.getY(), (halocenter.getZ()));
				Location h8 = new Location(halocenter.getWorld(), (halocenter.getX() - .43), halocenter.getY(), (halocenter.getZ() - .25));
				Location h9 = new Location(halocenter.getWorld(), (halocenter.getX() - .25), halocenter.getY(), (halocenter.getZ() - .43));
				Location h10 = new Location(halocenter.getWorld(), (halocenter.getX()), halocenter.getY(), (halocenter.getZ() - .5));
				Location h11 = new Location(halocenter.getWorld(), (halocenter.getX() + .25), halocenter.getY(), (halocenter.getZ() - .43));
				Location h12 = new Location(halocenter.getWorld(), (halocenter.getX() + .43), halocenter.getY(), (halocenter.getZ() - .25));
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h1, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h2, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h3, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h4, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h5, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h6, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h7, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h8, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h9, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h10, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h11, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h12, 0, 0, 0, ((plugin.halospeed.containsKey(p.getName()) ? plugin.halospeed.get(p.getName()) : 0)), 1);
			}
		}
	}
}
