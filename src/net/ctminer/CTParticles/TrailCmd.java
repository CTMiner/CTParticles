package net.ctminer.CTParticles;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrailCmd implements CommandExecutor{
	
	CTParticles plugin;
	
	public TrailCmd(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can run this command.");
		} else {
			Player p = (Player) sender;
			if (args[0].equalsIgnoreCase("trail")) {
				try {
					if(ParticleEffect.fromName(args[1]) != null) {
						if(plugin.aurachoice.containsKey(p.getUniqueId())) {
							plugin.aurachoice.remove(p.getUniqueId());
						}
						if(plugin.auraspeed.containsKey(p.getUniqueId())) {
							plugin.auraspeed.remove(p.getUniqueId());
						}
						if(plugin.auraamount.containsKey(p.getUniqueId())) {
							plugin.auraamount.remove(p.getUniqueId());
						}
						plugin.aurachoice.put(p.getUniqueId(), args[1]);
						if(args.length >= 3 && (args[2].equalsIgnoreCase("true") || ((Integer) Integer.parseInt(args[2]) instanceof Integer))) {
							plugin.auraspeed.put(p.getUniqueId(), (args[2].equalsIgnoreCase("true") ? 5 : Integer.parseInt(args[2])));
						} else {
							plugin.auraspeed.put(p.getUniqueId(), 0);
						}
						if(args.length >= 4 && ((Integer) Integer.parseInt(args[3]) instanceof Integer)) {
							if(Integer.parseInt(args[3]) <= 0) {
								p.sendMessage("Amount of particles has to be >0. Defaulted to 3.");
								plugin.auraamount.put(p.getUniqueId(), 3);
							} else {
								plugin.auraamount.put(p.getUniqueId(), (args[3].equalsIgnoreCase("true") ? 5 : Integer.parseInt(args[3])));
							}
						} else {
							plugin.auraamount.put(p.getUniqueId(), 3);
						}
					} else {
						p.sendMessage("Either you used an invalid particle name, or an error occurred.");
					}
				} catch (Exception e) {
				}
			}
		}
		return false;
	}

}