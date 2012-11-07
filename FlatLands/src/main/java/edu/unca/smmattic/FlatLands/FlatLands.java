package edu.unca.smmattic.FlatLands;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class FlatLands extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	
	
	public void onEnable() {
		this.logMessage("Enabled!");
	}
	
	public void onDisable(){
		this.logMessage("Disabled!");
	}
	
	public void logMessage(String message){
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + message);
	}
	
	public ChunkGenerator getDefaultWorldGenerator (String worldName, String uid) {
		return new FlatLandsGenerator(this);
	}
}
