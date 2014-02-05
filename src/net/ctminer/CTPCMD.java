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
				p.sendMessage("CTParticles by CTMiner.");
				p.sendMessage("Uses DarkStar12's particle library & codename_B's firework effect class.");
				p.sendMessage("/aura: Sets your aura");
				p.sendMessage("/halo: Sets your halo");
				p.sendMessage("/trail: Sets your trail");
				p.sendMessage("/firework: Creates firework particles at your location");
				return true;
			}
		}
		return false;
	}
	
}
