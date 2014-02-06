package net.ctminer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuraCmd implements CommandExecutor{
	
	CTParticles plugin;
	
	public AuraCmd(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can run this command.");
		} else {
			Player p = (Player) sender;
			try {
				if(args.length < 2 || args[0].equalsIgnoreCase("help")) {
					p.sendMessage("Aura help: /aura [name] [speed] [amount]");
					return true;
				}
				if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("remove")) {
					if(plugin.aurachoice.containsKey(p.getName())) {
						plugin.aurachoice.remove(p.getName());
					}
					if(plugin.auraspeed.containsKey(p.getName())) {
						plugin.auraspeed.remove(p.getName());
					}
					if(plugin.auraamount.containsKey(p.getName())) {
						plugin.auraamount.remove(p.getName());
					}
					p.sendMessage("Aura has been removed.");
					return true;
				}
				if(!p.hasPermission("ctparticles.aura.set")) {
					p.sendMessage("You do not have permission to set your own particle aura.");
					return true;
				}
				if(ParticleEffect.fromName(args[0]) != null) {
					if(!p.hasPermission("ctparticles.aura.particle." + args[0])) {
						p.sendMessage("You do not have permission to use that particle.");
						return true;
					}
					if(plugin.aurachoice.containsKey(p.getName())) {
						plugin.aurachoice.remove(p.getName());
					}
					if(plugin.auraspeed.containsKey(p.getName())) {
						plugin.auraspeed.remove(p.getName());
					}
					if(plugin.auraamount.containsKey(p.getName())) {
						plugin.auraamount.remove(p.getName());
					}
					plugin.aurachoice.put(p.getName(), args[0]);
					if(args.length >= 2 && ((Integer) Integer.parseInt(args[1]) instanceof Integer)) {
						if(!p.hasPermission("ctparticles.aura.speed")) {
							p.sendMessage("You do not have permission to set the speed of your aura particles.");
							plugin.auraspeed.put(p.getName(), 0);
						} else {
							plugin.auraspeed.put(p.getName(), Integer.parseInt(args[1]));
						}
					} else {
						plugin.auraspeed.put(p.getName(), 0);
					}
					if(args.length >= 3 && ((Integer) Integer.parseInt(args[2]) instanceof Integer)) {
						if(!p.hasPermission("ctparticles.aura.amount")) {
							p.sendMessage("You do not have permission to set the amount of particles in your aura.");
						} else if(Integer.parseInt(args[2]) <= 0 || Integer.parseInt(args[2]) > 10 ) {
							p.sendMessage("Amount of particles has to be > 0 and <= 10. Defaulted to 3.");
							plugin.auraamount.put(p.getName(), 3);
						} else {
							plugin.auraamount.put(p.getName(), Integer.parseInt(args[2]));
						}
					} else {
						plugin.auraamount.put(p.getName(), 3);
					}
				} else {
					p.sendMessage("Invalid particle name.");
				}
			} catch (Exception e) {
			}
		}
		return true;
	}

}
