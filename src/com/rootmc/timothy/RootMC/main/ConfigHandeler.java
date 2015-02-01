package com.rootmc.timothy.RootMC.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class ConfigHandeler {
	private HashMap<String, String> permission = new HashMap<>();
	private HashMap<String, String> Group = new HashMap<>();
	private HashMap<String, List<String>> groupData = new HashMap<>();
	public List<String> allGroup = new ArrayList<String>();
	
	public HashMap<String, String> getPermission(){
		return permission;
	}
	public HashMap<String, String> getGroup(){
		return Group;
	}
	public List<String> getAllGroup(){
		return allGroup;
	}
	public HashMap<String, List<String>> getGroupData(){
		return groupData;
	}
	public void setPermissionMap(HashMap<String, String> map){
		this.permission = map;
	}
	public void setGroupMap(HashMap<String, String> map){
		this.Group = map;
	}
	public void setGroupDataMap(HashMap<String, List<String>> map){
		this.groupData = map;
	}
	public void loadFromFile(FileConfiguration config){
		config = Main.sm.groups;
		groupData.clear();
		
		allGroup.clear();
		
		for(String s: config.getStringList("Order")){
			allGroup.add(s);
		}
		for(String s: allGroup){
			 List<String> tempData = new ArrayList<String>();
			String perm = config.getString("Groups."+s+".Permission");
			String Display = config.getString("Group."+s+".DisplayName");
			String PrimaryColor = config.getString("Group."+s+".PrimaryColor");
			String Staff = config.getString("Group."+s+".Staff");
			String Donor = config.getString("Group."+s+".Donor");
			String Default = config.getString("Group."+s+".Default");
			
			tempData.add(perm);
			tempData.add(Display);
			tempData.add(PrimaryColor);
			tempData.add(Staff);
			tempData.add(Donor);
			tempData.add(Default);
			
			groupData.put(s, tempData);
			permission.put(perm, s);
		}
	}
	// Workaround for the deprecated getOnlinePlayers()
	public List<Player> getOnline() {
	List<Player> list = new ArrayList<>();
	for (World world : Bukkit.getWorlds()) {
	list.addAll(world.getPlayers());
	}
	return Collections.unmodifiableList(list);
	}
	
	public void groupPermission(Player p){
		String permission ="";
		Permission perm;
		for(String s: allGroup){
			List<String> temp = groupData.get(s);
			perm = new Permission(temp.get(0), PermissionDefault.FALSE);
			if (p.hasPermission(perm)) {
				permission = temp.get(0);
			}
		}
	}
}