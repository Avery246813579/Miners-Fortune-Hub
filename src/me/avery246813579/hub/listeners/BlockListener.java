package me.avery246813579.hub.listeners;

import me.avery246813579.minersfortune.ranks.RankManager;
import me.avery246813579.minersfortune.ranks.Ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener{
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(RankManager.findPlayerRank(event.getPlayer()).getRankNumber() < Ranks.ADMIN.getRankNumber()){
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(RankManager.findPlayerRank(event.getPlayer()).getRankNumber() < Ranks.ADMIN.getRankNumber()){
			event.setCancelled(true);
		}
	}
}
