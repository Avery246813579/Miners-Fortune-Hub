package me.avery246813579.hub.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum Locations {
	SPAWN(new Location(Bukkit.getWorld("world"), 80.5, 67, -43.5, 90, 0)),
	ARCHER_GAMES(new Location(Bukkit.getWorld("world"), 32.5, 73, -89.5, 180, 0)),
	SURVIVAL_GAMES(new Location(Bukkit.getWorld("world"), 37.5, 73, -84.5, -90, 0)),
	SEARCHANDDESTROY(new Location(Bukkit.getWorld("world"), 37, 73, -2.5, -90, 0)),
	DOMINATION(new Location(Bukkit.getWorld("world"), 32.5, 73, 2.5, 0, 0));
	
	private Location location;
	
	Locations(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
