package com.gmail.therealkingvictoria.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Chest;

import com.gmail.therealkingvictoria.factions.Faction;

public class EstateBasePlaceListener implements Listener {
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
    
    if(!(e.getBlockPlaced().getState() instanceof Chest)) return; // we're only looking for chests
    Chest chest = (Chest) e.getBlockPlaced().getState();
    String name = chest.getCustomName();
    if(name == null) return; // dumb normal chests can suck it
    if(!name.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Estate Base")) return; // if it's not an Estate Base stop here

    // TODO: make new faction with new estate
  } // onBlockPlace
} // BlockPlaceListener
