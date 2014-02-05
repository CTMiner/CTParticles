package net.ctminer;

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
				sender.sendMessage("This command can only be run by a player.");
				return false;
			} else {
				Player p = (Player) sender;
				if(args.length == 0 || args[0].equalsIgnoreCase("help") || args.length == 1) {
					p.sendMessage("Syntax: /ctp [type] [data] [extra]");
					p.sendMessage("Types: 'aura', 'trail', 'halo'");
					p.sendMessage("Data: For aura and halo use the particle name.");
					p.sendMessage("For trails, use the name of the .yml file in the trails directory in the plugin directory");
					p.sendMessage("Extra: Put 'true' to make the aura particles have a speed (pulsate... kinda)");
					return true;
				} else if (args[0].equalsIgnoreCase("aura")) {
					try {
						if(ParticleEffect.fromName(args[1]) != null) {
							if(plugin.aurachoice.containsKey(p.getName())) {
								plugin.aurachoice.remove(p.getName());
							}
							if(plugin.auraspeed.containsKey(p.getName())) {
								plugin.auraspeed.remove(p.getName());
							}
							if(plugin.auraamount.containsKey(p.getName())) {
								plugin.auraamount.remove(p.getName());
							}
							plugin.aurachoice.put(p.getName(), args[1]);
							if(args.length >= 3 && (args[2].equalsIgnoreCase("true") || ((Integer) Integer.parseInt(args[2]) instanceof Integer))) {
								plugin.auraspeed.put(p.getName(), (args[2].equalsIgnoreCase("true") ? 5 : Integer.parseInt(args[2])));
							} else {
								plugin.auraspeed.put(p.getName(), 0);
							}
							if(args.length >= 4 && ((Integer) Integer.parseInt(args[3]) instanceof Integer)) {
								if(Integer.parseInt(args[3]) <= 0) {
									p.sendMessage("Amount of particles has to be >0. Defaulted to 3.");
									plugin.auraamount.put(p.getName(), 3);
								} else {
									plugin.auraamount.put(p.getName(), (args[3].equalsIgnoreCase("true") ? 5 : Integer.parseInt(args[3])));
								}
							} else {
								plugin.auraamount.put(p.getName(), 3);
							}
						} else {
							p.sendMessage("Either you used an invalid particle name, or an error occurred.");
						}
					} catch (Exception e) {
					}
					return true;
				} else if (args[0].equalsIgnoreCase("halo")) {
					p.sendMessage("NYI");
					return true;
				} else if (args[0].equalsIgnoreCase("trail")) {
					p.sendMessage("NYI");
					return true;
				}
			}
		}
		return false;
	}
	
}
