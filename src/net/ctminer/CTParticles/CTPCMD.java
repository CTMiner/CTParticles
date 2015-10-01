package net.ctminer.CTParticles;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CTPCMD implements CommandExecutor {
	
	CTParticles plugin;
	
	public CTPCMD(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ctp")) {
			if (!(sender instanceof Player)) {
				if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("CTParticles by CTMiner. (Console help)");
				} else if(args[0].equalsIgnoreCase("debug")) {
					sender.sendMessage("Particle range entries (" + plugin.particlerange.size() + "):");
					for(UUID u : plugin.particlerange.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.particlerange.get(u));
					}
					sender.sendMessage("Aura choice entries (" + plugin.aurachoice.size() + "):");
					for(UUID u : plugin.aurachoice.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.aurachoice.get(u));
					}
					sender.sendMessage("Aura speed entries (" + plugin.auraspeed.size() + "):");
					for(UUID u : plugin.auraspeed.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.auraspeed.get(u));
					}
					sender.sendMessage("Aura amount entries (" + plugin.auraamount.size() + "):");
					for(UUID u : plugin.auraamount.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.auraamount.get(u));
					}
					sender.sendMessage("Halo choice entries (" + plugin.halochoice.size() + "):");
					for(UUID u : plugin.halochoice.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.halochoice.get(u));
					}
					sender.sendMessage("Halo speed entries (" + plugin.halospeed.size() + "):");
					for(UUID u : plugin.halospeed.keySet()) {
						sender.sendMessage(u.toString() + ": " + plugin.halospeed.get(u));
					}
				} else {
					sender.sendMessage("Unrecognized parameter");
				}
				return true;
			} else {
				Player p = (Player) sender;
				if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
					p.sendMessage("CTParticles by CTMiner.");
					p.sendMessage("Uses DarkStar12's particle library & codename_B's firework effect class.");
					p.sendMessage("/ctp help: This message");
					p.sendMessage("/ctp range [clear/#]: Set the range of visibility of your particles. Default 20.");
					p.sendMessage("/aura: Sets your aura");
					p.sendMessage("/halo: Sets your halo");
					//p.sendMessage("/trail: Sets your trail");
					//p.sendMessage("/firework: Creates firework particles at your location");
				} else {
					if(args[0].equalsIgnoreCase("range")) {
						if(p.hasPermission("ctparticles.range")) {
							if(args.length < 2) {
								p.sendMessage("Please specify either 'clear' or a number.");
							} else if(args[1].equalsIgnoreCase("clear")) {
								if(plugin.particlerange.containsKey(p.getUniqueId())) {
									plugin.particlerange.remove(p.getUniqueId());
								}
								p.sendMessage("Particle range cleared");
								plugin.savePlayer(p.getUniqueId());
							} else if ((Integer) Integer.parseInt(args[1]) instanceof Integer){
								plugin.particlerange.put(p.getUniqueId(), Integer.parseInt(args[1]));
								p.sendMessage("Particle range set to " + args[1]);
								plugin.savePlayer(p.getUniqueId());
							} else {
								p.sendMessage("Please specify either 'clear' or a number.");
							}
						} else {
							p.sendMessage("You do not have permission to use this command.");
						}
					} else {
						p.sendMessage("CTParticles: unknown argument");
					}
				}
				return true;
			}
		}
		return false;
	}
	
}