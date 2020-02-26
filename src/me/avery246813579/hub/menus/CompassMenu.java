package me.avery246813579.hub.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.avery246813579.hub.util.Locations;
import me.avery246813579.minersfortune.menus.Menu;

public class CompassMenu extends Menu{
	public CompassMenu() {
		super(createItem(Material.COMPASS, ChatColor.YELLOW + "Browse Servers", new String[]{ChatColor.GRAY + "Click to access"}), "Server Selector");
		this.giveDefaultItems = false;
	}

	@Override
	protected void checkItem(Player player, ItemStack item) {
		Location location = null;
		
		if(item.getType() == Material.BOW){
			location = Locations.ARCHER_GAMES.getLocation();
		} else if(item.getType() == Material.APPLE){
			location = Locations.SURVIVAL_GAMES.getLocation();
		} else if(item.getType() == Material.BLAZE_POWDER){
			location = Locations.SEARCHANDDESTROY.getLocation();
		} else if(item.getType() == Material.STAINED_GLASS){
			location = Locations.DOMINATION.getLocation();
		}
		
		if(location == null){
			return;
		}
		
		player.sendMessage(ChatColor.GREEN + "Teleportation >> " + ChatColor.YELLOW + "You have been teleported to the " + item.getItemMeta().getDisplayName() + " servers!");
		player.teleport(location);
	}

	@Override
	protected Inventory[] createInventories() {
		Inventory inventory = Bukkit.createInventory(null, 27, "Server Selector");
		inventory.setItem(10, createItem(Material.BOW, ChatColor.YELLOW + "Archer Games", new String[]{ChatColor.GRAY + "Click to teleport"}));
		inventory.setItem(12, createItem(Material.APPLE, ChatColor.YELLOW + "Survival Games", new String[]{ChatColor.GRAY + "Click to teleport"}));
		inventory.setItem(14, createItem(Material.BLAZE_POWDER, ChatColor.YELLOW + "Search & Destroy", new String[]{ChatColor.GRAY + "Click to teleport"}));
		inventory.setItem(16, createItem(Material.STAINED_GLASS, ChatColor.YELLOW + "Domination", new String[]{ChatColor.GRAY + "Click to teleport"}));
		return new Inventory[]{inventory};
	}

	@Override
	protected Inventory[] createInventories(Player arg0) {
		return null;
	}
}
