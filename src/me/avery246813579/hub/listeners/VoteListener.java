package me.avery246813579.hub.listeners;

import me.avery246813579.minersfortune.MinersFortune;
import me.avery246813579.minersfortune.sql.tables.AccountTable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteListener implements Listener{
	@EventHandler
	public void onVote(VotifierEvent event){
		Vote vote = event.getVote();

		AccountTable accountTable = MinersFortune.getPlugin().getSqlHandler().findAccount(vote.getUsername());
		
		if(accountTable != null){
			accountTable.setCredits(accountTable.getCredits() + 15);
			MinersFortune.getPlugin().getSqlHandler().saveAccount(accountTable);
			
			if(Bukkit.getPlayer(vote.getUsername()) != null){
				Bukkit.getPlayer(vote.getUsername()).sendMessage(ChatColor.GREEN + "Vote >> " + ChatColor.YELLOW + "Thank you for voting! You received 15 credits for you vote!");
			}
		}
	}
}
