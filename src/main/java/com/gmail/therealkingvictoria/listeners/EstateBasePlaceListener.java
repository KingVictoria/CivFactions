package com.gmail.therealkingvictoria.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Chest;

public class EstateBasePlaceListener implements Listener {
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
    
    if(!(e.getBlockPlaced().getState() instanceof Chest)) return; // we only lookin for chests meng
    Chest chest = (Chest) e.getBlockPlaced().getState();
    String name = chest.getCustomName();
    if(name == null) return; // dumb normal chests can suck it
    
    if(name.equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Estate Base")) System.out.println("WOWOWOW YOU DUN IT BOI");
  } // onBlockPlace
} // BlockPlaceListener
