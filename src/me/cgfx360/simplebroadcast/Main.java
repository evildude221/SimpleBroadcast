package me.cgfx360.simplebroadcast;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
public final Logger logger = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	
	}
    
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		System.out.println("This plugin was requested by GetSwated!");
		System.out.println("Report any bugs or leave any suggestions by contacting Evildude221 on Bukkit!");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String args[]){
		   
	    if(sender instanceof Player){
	       
	    	if (cmd.getName().equalsIgnoreCase("broadcast")){
	       
	            if(args.length == 0){
	           
	            String Error = getConfig().getString("ErrorMessage");
	            Error = ChatColor.translateAlternateColorCodes('&', Error);	
	            sender.sendMessage(Error);
	           
	            }
	           
	            if(args.length == 1){
	            	if (getConfig().getBoolean("ShowServerName") &&
	            	getConfig().getBoolean("ShowPlayerName")){
	            
	            	String Server = getConfig().getString("ServerName");
	            	Server = ChatColor.translateAlternateColorCodes('&', Server);
	            	String Message = getConfig().getString("MessageColor");
	            	Message = ChatColor.translateAlternateColorCodes('&', Message);
	            	String Player = getConfig().getString("PlayerColor");
	            	Player = ChatColor.translateAlternateColorCodes('&', Player);
	            	Bukkit.broadcastMessage(Server + " " + Message + args[0] + Player + " - " +  sender.getName());
	            	}else{
	            		if (getConfig().getBoolean("ShowServerName") &&
	            				!getConfig().getBoolean("ShowPlayerName")){
	            			String Server = getConfig().getString("ServerName");
	    	            	Server = ChatColor.translateAlternateColorCodes('&', Server);
	    	            	String Message = getConfig().getString("MessageColor");
	    	            	Message = ChatColor.translateAlternateColorCodes('&', Message);
	    	            	String Player = getConfig().getString("PlayerColor");
	    	            	Player = ChatColor.translateAlternateColorCodes('&', Player);
	    	            	Bukkit.broadcastMessage(Server + " " + Message + args[0]);	
	            		
	            	}else{
	            		if (!getConfig().getBoolean("ShowServerName") &&
	            				getConfig().getBoolean("ShowPlayerName")){
	            	
	            		String Message = getConfig().getString("MessageColor");
		            	Message = ChatColor.translateAlternateColorCodes('&', Message);
	            	 	String Player = getConfig().getString("PlayerColor");
		            	Player = ChatColor.translateAlternateColorCodes('&', Player);
		            	Bukkit.broadcastMessage(Message + args[0] + Player + " - " + sender.getName());
		            	
	            		}else{
	            			if (!getConfig().getBoolean("ShowServerName") &&
	            					!getConfig().getBoolean("ShowPlayerName")){
	            				String Message = getConfig().getString("MessageColor");
	    		            	Message = ChatColor.translateAlternateColorCodes('&', Message);
	    	            	 	String Player = getConfig().getString("PlayerColor");
	    		            	Player = ChatColor.translateAlternateColorCodes('&', Player);
	    		            	Bukkit.broadcastMessage(Message + args[0]);
	            			
	            			}
	            		}
	            		
	            		
	            	}
	               }
	             }
	            }
	    	}
	       
	    return false;
	    }
}
