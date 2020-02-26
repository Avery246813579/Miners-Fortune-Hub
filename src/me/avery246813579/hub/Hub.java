package me.avery246813579.hub;

import me.avery246813579.hub.listeners.BlockListener;
import me.avery246813579.hub.listeners.PlayerListener;
import me.avery246813579.hub.listeners.VoteListener;
import me.avery246813579.hub.menus.MenuHandler;
import me.avery246813579.minersfortune.MinersFortune;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin{
	private static MinersFortune minersfortune;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		Bukkit.getPluginManager().registerEvents(new VoteListener(), this);

		new MenuHandler();
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MinersFortune.getPlugin(), new Runnable() {
			public void run() {
				if (Bukkit.getWorld("world").getTime() >= 10000) {
					Bukkit.getWorld("world").setTime(1000);
				}

				if (Bukkit.getWorld("world").hasStorm() || Bukkit.getWorld("world").isThundering()) {
					Bukkit.getWorld("world").setStorm(false);
					Bukkit.getWorld("world").setThundering(false);
				}
			}
		}, 20L, 20L);
	}

	@Override
	public void onDisable() {

	}
	
	public static MinersFortune getMinersfortune() {
		return minersfortune;
	}

	public static void setMinersfortune(MinersFortune minersfortune) {
		Hub.minersfortune = minersfortune;
	}
}
