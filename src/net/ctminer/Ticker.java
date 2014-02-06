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
				Location playermiddle = l;
				playermiddle.setY(playermiddle.getY() + 1);
				ParticleEffect.fromName(plugin.aurachoice.get(p.getName())).display(playermiddle, (float) .5, (float) 1, (float) .5, ((plugin.auraspeed.containsKey(p.getName()) ? plugin.auraspeed.get(p.getName()) : 0)), ((plugin.auraamount.containsKey(p.getName()) ? plugin.auraamount.get(p.getName()) : 3)));
			}
			if(plugin.halochoice.containsKey(p.getName())) {
				Location halocenter = l;
				halocenter.setY(halocenter.getY() + 2);
				Location h1 = halocenter;
				Location h2 = halocenter;
				Location h3 = halocenter;
				Location h4 = halocenter;
				Location h5 = halocenter;
				Location h6 = halocenter;
				Location h7 = halocenter;
				Location h8 = halocenter;
				Location h9 = halocenter;
				Location h10 = halocenter;
				Location h11 = halocenter;
				Location h12 = halocenter;
				h1.setX(h1.getX() + .5);
				h2.setX(h2.getX() + .87);
				h2.setZ(h2.getZ() + .5);
				h3.setX(h3.getX() + .5);
				h3.setZ(h3.getZ() + .87);
				h4.setZ(h4.getZ() + .5);
				h5.setX(h5.getX() - .5);
				h5.setZ(h5.getZ() + .87);
				h6.setX(h6.getX() - .87);
				h6.setZ(h6.getZ() + .5);
				h7.setX(h7.getX() - .5);
				h8.setX(h8.getX() - .87);
				h8.setZ(h8.getZ() - .5);
				h9.setX(h9.getX() - .5);
				h9.setZ(h9.getZ() - .87);
				h10.setZ(h10.getZ() - .5);
				h11.setX(h11.getX() + .5);
				h11.setZ(h11.getZ() - .87);
				h12.setX(h12.getX() + .87);
				h12.setZ(h12.getZ() - .5);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h1, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h2, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h3, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h4, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h5, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h6, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h7, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h8, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h9, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h10, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h11, 0, 0, 0, 0, 1);
				ParticleEffect.fromName(plugin.halochoice.get(p.getName())).display(h12, 0, 0, 0, 0, 1);
			}
		}
	}
}
