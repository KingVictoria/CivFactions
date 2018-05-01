package com.gmail.therealkingvictoria.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Chest;

import com.gmail.therealkingvictoria.estates.Estate;
import com.gmail.therealkingvictoria.factions.Faction;

public class EstateBasePlaceListener implements Listener {
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
    
    if(!(e.getBlockPlaced().getState() instanceof Chest)) return; // we're only looking for chests
    Chest chest = (Chest) e.getBlockPlaced().getState();
    String name = chest.getCustomName();
    if(name == null) return; // dumb normal chests can suck it
    if(!name.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Estate Base")) return; // if it's not an Estate Base stop here

    Estate estate = new Estate(e.getPlayer().getName() + "'s Estate", chest.getLocation());
    Faction faction = new Faction(e.getPlayer(), estate);

    e.getPlayer().sendMessage(ChatColor.YELLOW + "The Faction of " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + faction.getName() + ChatColor.YELLOW + " has been created with the estate "
			      + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + estate.getName());
  } // onBlockPlace
} // BlockPlaceListener
