package net.angusbeefgaming.missioncontrol.command;
/*
 * Command to send player to the SMP Server
 * 
 * Written by Atticus Zambrana
 */
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandSMP extends Command {
	private String targetServer = "SMP-1";
	
	public CommandSMP() {
		super("hub","internal.server.smp",new String[0]);
	}
	
	public void execute(CommandSender sender, String[] args) {
		// Find out if the sender is a player currently proxied
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			// Continue...
			// Check if they are already on the hub
			if (!player.getServer().getInfo().getName().equalsIgnoreCase(targetServer)) {
				// If they are not...
				// Save that servers name
				String oldServer = ((CommandSender) player.getServer()).getName();
				
				// Grab the information about the server...
				ServerInfo target = ProxyServer.getInstance().getServerInfo(targetServer);
				// And connect them to it!
				player.connect(target);
				player.sendMessage(ChatColor.BLUE + "Portal> " + ChatColor.GRAY + "You have been sent from " + ChatColor.GOLD + oldServer + ChatColor.GRAY + " to " + ChatColor.GOLD + "SMP-1");
			}
			else {
				player.sendMessage(ChatColor.RED + "You are already connected to this server!");
			}
		}
		else {
			sender.sendMessages("This command can only be run in-game");
		}
	}
}
