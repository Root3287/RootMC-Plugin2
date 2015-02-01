package com.rootmc.timothy.RootMC.main;

import org.bukkit.ChatColor;

public class MainFormat {
	
	// The Main Format for my Plugins
	public static String Format(String topic, String Message){
		return mainColor(topic)+secColor("> ")+mainColor(Message);
	}
	
	//The Main Color For my Text
	public static String mainColor(String message){
		return ChatColor.GOLD+""+ChatColor.BOLD+message;
	}
	
	//The Secondary Color for my Text
	public static String secColor(String message){
		return ChatColor.YELLOW+""+ChatColor.BOLD+message;
	}
}
