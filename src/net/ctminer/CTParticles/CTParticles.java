package net.ctminer.CTParticles;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// This uses @DarkBlade12's particle library
// Thread: http://forums.bukkit.org/threads/lib-1-7-particleeffect-v1-3.154406/
// This also uses codename_B's FireworkEffectPlayer class
// Thread: https://forums.bukkit.org/threads/util-fireworkeffectplayer-v1-0.119424/

public class CTParticles extends JavaPlugin {
	
	public File trailsdir;
	public HashMap<UUID, String> aurachoice = new HashMap<UUID, String>();
	public HashMap<UUID, Integer> auraspeed = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> auraamount = new HashMap<UUID, Integer>();
	public HashMap<UUID, String> halochoice = new HashMap<UUID, String>();
	public HashMap<UUID, String> trailchoice = new HashMap<UUID, String>();
	public HashMap<UUID, Integer> halospeed = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> particlerange = new HashMap<UUID, Integer>();
	
	@Override
	public void onEnable() {
		trailsdir = new File(getDataFolder().getPath() + File.separator + "trails");
		if(trailsdir.exists() && trailsdir.isDirectory()) {
			getLogger().log(Level.INFO, "[CTParticles] Successfully loaded the trails directory");
		} else {
			if(trailsdir.mkdirs()) {
				getLogger().log(Level.INFO, "[CTParticles] Successfully created the trails directory");
			} else {
				getLogger().log(Level.SEVERE, "[CTParticles] ERROR: UNABLE TO EITHER LOAD OR CREATE THE TRAILS DIRECTORY");
			}
		}
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Ticker(this), 0, 1);
		getCommand("ctp").setExecutor(new CTPCMD(this));
		getCommand("aura").setExecutor(new AuraCmd(this));
		getCommand("halo").setExecutor(new HaloCmd(this));
		getCommand("trail").setExecutor(new TrailCmd(this));
		getCommand("firework").setExecutor(new FireworkCmd(this));
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
	}

	void loadPlayer(UUID uuid) {
		getLogger().log(Level.INFO, "Loading settings for player " + Bukkit.getPlayer(uuid).getName());
		YamlConfiguration config;
		File rawconfig = new File(this.getDataFolder(), "/players/" + uuid.toString() + ".yml");
		if(rawconfig.exists()) {
			getLogger().log(Level.INFO, "Settings found");
			config = YamlConfiguration.loadConfiguration(rawconfig);
		} else {
			getLogger().log(Level.INFO, "Settings not found - attempting to create file");
			config = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource("pconf.yml")));
			try {
				config.save(rawconfig);
			} catch (IOException e) {
				getLogger().log(Level.INFO, "Could not create file - here's an error");
				e.printStackTrace();
				return;
			}
			getLogger().log(Level.INFO, "Settings file generated");
		}
		getLogger().log(Level.INFO, "Clearing old settings");
		if(particlerange.containsKey(uuid)) {
			particlerange.remove(uuid);
		}
		if(aurachoice.containsKey(uuid)) {
			aurachoice.remove(uuid);
		}
		if(auraspeed.containsKey(uuid)) {
			auraspeed.remove(uuid);
		}
		if(auraamount.containsKey(uuid)) {
			auraamount.remove(uuid);
		}
		if(halochoice.containsKey(uuid)) {
			halochoice.remove(uuid);
		}
		if(halospeed.containsKey(uuid)) {
			halospeed.remove(uuid);
		}
		getLogger().log(Level.INFO, "Loading settings");
		if(config.getInt("global.range") != -1) {
			particlerange.put(uuid, config.getInt("global.range"));
		}
		if(!config.getString("aura.choice").equalsIgnoreCase("")) {
			aurachoice.put(uuid, config.getString("aura.choice"));
		}
		if(config.getInt("aura.speed") != -1) {
			auraspeed.put(uuid, config.getInt("aura.speed"));
		}
		if(config.getInt("aura.amount") != -1) {
			auraamount.put(uuid, config.getInt("aura.amount"));
		}
		if(!config.getString("halo.choice").equalsIgnoreCase("")) {
			halochoice.put(uuid, config.getString("halo.choice"));
		}
		if(config.getInt("halo.speed") != -1) {
			halospeed.put(uuid, config.getInt("halo.speed"));
		}
	}
	
	void savePlayer(UUID uuid) {
		getLogger().log(Level.INFO, "Loading settings for player " + Bukkit.getPlayer(uuid).getName());
		YamlConfiguration config;
		File rawconfig = new File(this.getDataFolder(), "/players/" + uuid.toString() + ".yml");
		if(rawconfig.exists()) {
			getLogger().log(Level.INFO, "Settings found");
			config = YamlConfiguration.loadConfiguration(rawconfig);
		} else {
			getLogger().log(Level.INFO, "Settings not found - attempting to create file");
			config = YamlConfiguration.loadConfiguration(new InputStreamReader(getResource("pconf.yml")));
			try {
				config.save(rawconfig);
			} catch (IOException e) {
				getLogger().log(Level.INFO, "Could not create file - here's an error:");
				e.printStackTrace();
				return;
			}
			getLogger().log(Level.INFO, "Settings file generated");
		}
		if(particlerange.containsKey(uuid)) {
			config.set("global.range", particlerange.get(uuid));
		} else {
			config.set("global.range", -1);
		}
		if(aurachoice.containsKey(uuid)) {
			config.set("aura.choice", aurachoice.get(uuid));
		} else {
			config.set("aura.choice", "none");
		}
		if(auraspeed.containsKey(uuid)) {
			config.set("aura.speed", auraspeed.get(uuid));
		} else {
			config.set("aura.speed", -1);
		}
		if(auraamount.containsKey(uuid)) {
			config.set("aura.amount", auraamount.get(uuid));
		} else {
			config.set("aura.amount", -1);
		}
		if(halochoice.containsKey(uuid)) {
			config.set("halo.choice", halochoice.get(uuid));
		} else {
			config.set("halo.choice", "none");
		}
		if(halospeed.containsKey(uuid)) {
			config.set("halo.speed", halospeed.get(uuid));
		} else {
			config.set("halo.speed", -1);
		}
		getLogger().log(Level.INFO, "Attempting file save");
		try {
			config.save(rawconfig);
			getLogger().log(Level.INFO, "Settings saved");
		} catch (IOException e) {
			getLogger().log(Level.INFO, "Could not save file - here's an error:");
			e.printStackTrace();
		}
	}
	
}