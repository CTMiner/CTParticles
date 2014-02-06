package net.ctminer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HaloCmd implements CommandExecutor{
	
	CTParticles plugin;
	
	public HaloCmd(CTParticles plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can run this command.");
		} else {
			Player p = (Player) sender;
			try {
				if(args.length < 1 || args[0].equalsIgnoreCase("help")) {
					p.sendMessage("Halo help: /halo [name] [speed/data]");
					return true;
				}
				if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("remove")) {
					if(plugin.halochoice.containsKey(p.getName())) {
						plugin.halochoice.remove(p.getName());
						p.sendMessage("Halo has been removed.");
						return true;
					}
				}
				if(!p.hasPermission("ctparticles.halo.set")) {
					p.sendMessage("You do not have permission to set your own particle halo.");
					return true;
				}
				if(ParticleEffect.fromName(args[0]) != null) {
					if(!p.hasPermission("ctparticles.halo.particle." + args[0])) {
						p.sendMessage("You do not have permission to use that particle.");
						return true;
					}
					if(plugin.halochoice.containsKey(p.getName())) {
						plugin.halochoice.remove(p.getName());
					}
					plugin.halochoice.put(p.getName(), args[0]);
				} else {
					p.sendMessage("Invalid particle name.");
				}
				if(args.length >= 2 && ((Integer) Integer.parseInt(args[1]) instanceof Integer)) {
					if(!p.hasPermission("ctparticles.halo.speed")) {
						p.sendMessage("You do not have permission to set the speed of your halo particles.");
						plugin.halospeed.put(p.getName(), 0);
					} else {
						plugin.halospeed.put(p.getName(), Integer.parseInt(args[1]));
					}
				} else {
					plugin.halospeed.put(p.getName(), 0);
				}
			} catch (Exception e) {
			}
		}
		return true;
	}

}
