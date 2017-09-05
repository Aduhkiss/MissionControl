package net.angusbeefgaming.missioncontrol;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	@Override
	public void onEnable() {
		getLogger().info("Mission Control Ready!");
		
		// Command Registry
		
		// Server Sending Commands
		getProxy().getPluginManager().registerCommand(this, new net.angusbeefgaming.missioncontrol.command.CommandHub());
		getProxy().getPluginManager().registerCommand(this, new net.angusbeefgaming.missioncontrol.command.CommandSMP());
		getProxy().getPluginManager().registerCommand(this, new net.angusbeefgaming.missioncontrol.command.CommandFactions());
	}
}
