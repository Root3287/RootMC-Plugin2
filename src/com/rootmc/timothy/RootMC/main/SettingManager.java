package com.rootmc.timothy.RootMC.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingManager {
	private SettingManager(){}
	static SettingManager instance = SettingManager.getInstance();
	
	public static SettingManager getInstance(){
		return instance;
	}
	Plugin p;
	FileConfiguration config;
	FileConfiguration groups;
	File groupsFile;
	File cFile;
	public void setup(Plugin p){
		cFile = new File(p.getDataFolder(), "config.yml");
		config = p.getConfig();
		//config.options().copyDefaults(true);
		//saveConfig();
		if(!(p.getDataFolder().exists())){
			p.getDataFolder().mkdir();
		}
		groupsFile = new File(p.getDataFolder(), "groups.yml");
		if(!groupsFile.exists()){
			try{
				groupsFile.createNewFile();
			}catch(IOException e){
				Bukkit.getServer().broadcastMessage(MainFormat.Format("Error", "Could not create a group file"));
			}
		}
		groups = YamlConfiguration.loadConfiguration(groupsFile);
	}
	
	public FileConfiguration getConfig(){
		return config;
	}
	
	public void saveConfig(){
		try{
			config.save(cFile);
		}catch(IOException e){
			Bukkit.getServer().broadcastMessage(MainFormat.Format("Error", "There was an error in the process of saving the config!"));
			e.printStackTrace();
		}
	}
	
	public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cFile);
	}
	
	public PluginDescriptionFile getDesc() {
        return p.getDescription();
	}
	public FileConfiguration getGroups(){
		return groups;
	}
	
	public void saveGroups(){
		try{
			groups.save(groupsFile);
		}catch(IOException e){
			Bukkit.getServer().broadcastMessage(MainFormat.Format("Error", "There was an error in the process of saving the Groups file!"));
			e.printStackTrace();
		}
	}
	
	public void reloadGroups() {
        groups = YamlConfiguration.loadConfiguration(groupsFile);
	}
}
