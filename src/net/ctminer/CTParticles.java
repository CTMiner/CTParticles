package net.ctminer;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class CTParticles extends JavaPlugin {
	
	public File trailsdir;
	
	@Override
	public void onEnable() {
		trailsdir = new File(getDataFolder().getPath() + File.pathSeparator + "trails");
		if(trailsdir.exists() && trailsdir.isDirectory()) {
			getLogger().log(Level.INFO, "[CTParticles] Successfully loaded the trails directory");
		} else {
			if(trailsdir.mkdirs()) {
				getLogger().log(Level.INFO, "[CTParticles] Successfully created the trails directory");
			} else {
				getLogger().log(Level.SEVERE, "[CTParticles] ERROR: UNABLE TO EITHER LOAD OR CREATE THE TRAILS DIRECTORY");
			}
		}
	}
	
}
