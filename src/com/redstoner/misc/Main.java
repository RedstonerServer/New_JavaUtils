package com.redstoner.misc;

import org.bukkit.plugin.java.JavaPlugin;

import com.redstoner.annotations.Version;
import com.redstoner.coremods.moduleLoader.ModuleLoader;
import com.redstoner.misc.mysql.MysqlHandler;

import net.nemez.chatapi.ChatAPI;

/** Main class. Duh.
 * 
 * @author Pepich */
@Version(major = 4, minor = 0, revision = 0, compatible = -1)
public class Main extends JavaPlugin
{
	public static JavaPlugin plugin;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		ChatAPI.initialize(this);
		// Configger.init();
		MysqlHandler.init();
		ModuleLoader.init();
		// Load modules from config
		ModuleLoader.loadFromConfig();
	}
	
	@Override
	public void onDisable()
	{
		ModuleLoader.disableModules();
	}
}
