package com.gmail.therealkingvictoria.factions;

import java.util.ArrayList;

import org.bukkit.plugin.Plugin;

public class FactionHandler {
  ArrayList<Faction> factions;
  Plugin plugin;

  /**
   * Creates a FactionHandler object that handles the Factions
   * @param plugin Plugin reference var
   */
  public FactionHandler(Plugin plugin) {
    this.plugin = plugin;
  } // FactionHandler

  public void load() {
    // TODO: load
  } // load

  public void save() {
    // TODO: save
  } // save
} // FactionHandler
