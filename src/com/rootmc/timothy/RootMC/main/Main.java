package com.rootmc.timothy.RootMC.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	//Config File
	public static SettingManager sm = SettingManager.getInstance();
	
	
	
	//Loads when the plugin is loading
	@Override
	public void onLoad() {
		 
	}
	
	//Loads When Plugin enable!
	@Override
	public void onEnable() {
		sm.setup(this);
		PluginManager pm = Bukkit.getServer().getPluginManager();
	}
	
	//Loads When Plugin Disable
	@Override
	public void onDisable() {
		
	}
}
