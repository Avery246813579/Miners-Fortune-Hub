package me.avery246813579.hub.listeners;

import me.avery246813579.hub.menus.MenuHandler;
import me.avery246813579.hub.util.Locations;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerListener implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		player.getInventory().clear();
		player.teleport(Locations.SPAWN.getLocation());
		
		player.getInventory().setItem(0, MenuHandler.compassMenu.getItem());
		player.getInventory().setItem(4, me.avery246813579.minersfortune.menus.MenuHandler.vanityMenu.getItem());
		event.setJoinMessage(null);
		event.getPlayer().sendMessage(ChatColor.GREEN + "Join >> " + ChatColor.YELLOW + "Welcome to Miners Fortune!");
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		event.setQuitMessage(null);
		event.getPlayer().sendMessage(ChatColor.GREEN + "Join >> " + ChatColor.YELLOW + "Welcome to Miners Fortune!");
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			event.setCancelled(true);
		}
		
		if(event.getCause() == DamageCause.VOID){
			event.getEntity().teleport(Locations.SPAWN.getLocation());
		}
	}
	
	@EventHandler
	public void onServerListPing(ServerListPingEvent event){
		event.setMotd(ChatColor.translateAlternateColorCodes('&', "&e&l   Miners Fortune Network >> 1.7.2 - 1.8.1               &9&lFind your fortune today!"));
		event.setMaxPlayers(1000);
	}
	
	@EventHandler
	public void onHungerChange(FoodLevelChangeEvent event){
		event.setCancelled(true);
	}
}
