package com.rootmc.timothy.RootMC.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.rootmc.timothy.RootMC.main.ConfigHandeler;
import com.rootmc.timothy.RootMC.main.Main;
import com.rootmc.timothy.RootMC.main.MainFormat;

public class Crash implements CommandExecutor{
	public static Main plugin;
	public Crash (Main instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		Player p = (Player) sender;
		
		String Success = MainFormat.Format("Crash", "You have crash" + p.getServer().getPlayer(args[0]).getName());
		//TODO: MAKE THE PERMISSION NODE IF IT STAFF	
		if(p.hasPermission("ADMIN")){
			if(args.length == 0||args.length == 1){
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
				p.sendMessage(MainFormat.Format("Command","/crash <target> <CrashError>"));
				p.sendMessage(MainFormat.Format("Crash Type","Time_Out, Read_Time_Out, ISE, Socket_Write_Error, Peer"));
			}else if(args.length == 2){
				
				
				Player t = Bukkit.getServer().getPlayer(args[0]);
				
				if(t !=null){
					if(args[1].equalsIgnoreCase("Time_Out")){
						t.kickPlayer("Timed out");
						p.sendMessage(Success);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
					}else if(args[1].equalsIgnoreCase("Read_Time_Out")){
						t.kickPlayer("Internal exception: java.net.SocketTimeout.Exception: Read timed out");
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
						p.sendMessage(Success);
					}else if(args[1].equalsIgnoreCase("ISE")){
						p.sendMessage(Success);
						t.kickPlayer("Internal server error");
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
					}else if(args[1].equalsIgnoreCase("Socket_write_error")){
						t.kickPlayer("Internal exception; java.net.SocketException: Software caused connection abort: socket write error");
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
						p.sendMessage(Success);
					}else if(args[1].equalsIgnoreCase("Peer")){
						t.kickPlayer("Internal exception: java.net.SocketException: Connection reset by peer: socket write error");
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
						p.sendMessage(Success);
					}else{
						p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
						p.sendMessage(MainFormat.Format("Error", "Thats an invalid argument"));
						MainFormat.Format("Crash Type","Time_Out, Read_Time_Out, ISE, Socket_Write_Error, Peer");
					}
				}
			}
		}else{
			p.sendMessage("null");
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
		}
		return true;
	}
}
