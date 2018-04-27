package com.gmail.therealkingvictoria.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Chest;

public class BlockPlaceListener implements Listener {
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
    if(!(e.getBlockPlaced().getState() instanceof Chest)) return;
    Chest chest = (Chest) e.getBlockPlaced().getState();
    String name = chest.getCustomName();
    System.out.println(name);
  } // onBlockPlace
} // BlockPlaceListener
