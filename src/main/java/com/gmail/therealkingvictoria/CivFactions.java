package com.gmail.therealkingvictoria;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import factions.FactionHandler;

public class CivFactions extends JavaPlugin {
  Plugin plugin;

  FactionHandler fh;
  
  public void onEnable() {
    plugin = this;

    fh = new FactionHandler(plugin);

    fh.load();
  } // onEnable
  
  public void onDisable() {
    fh.save();
  } // onDisable
} // CivFactions
