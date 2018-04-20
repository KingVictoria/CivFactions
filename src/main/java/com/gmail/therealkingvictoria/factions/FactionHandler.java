package com.gmail.therealkingvictoria.factions;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FactionHandler {
  ArrayList<Faction> factions;
  Plugin plugin;
  File factionConfigFile;
  FileConfiguration factionConfig;

  /**
   * Creates a FactionHandler object that handles the Factions
   * @param plugin Plugin reference var
   */
  public FactionHandler(Plugin plugin) {
    this.plugin = plugin;

  } // FactionHandler

  /**
   * Loads factions from factions.yml config file
   */
  public void load() {
    factionConfigFile = new File(plugin.getDataFolder(), "factions.yml");
    factionConfig = YamlConfiguration.loadConfiguration(factionConfigFile);

    factions = new ArrayList<>();

    ArrayList<Map<String, Object>> serializedFactions = (ArrayList<Map<String, Object>>) factionConfig.get("factions");
    for(Map<String, Object> map: serializedFactions) factions.add(new Faction(map));
  } // load

  /**
   * Saves factions to factions.yml config file
   */
  public void save() {
    ArrayList<Map<String, Object>> serializedFactions = new ArrayList<>();
    for(Faction faction: factions) serializedFactions.add(faction.serialize());
    factionConfig.set("factions", serializedFactions);
    
    try {
      factionConfig.save(factionConfigFile);
    } catch (Exception e) {
      plugin.getLogger().log(Level.SEVERE, "Could not save config to " + factionConfigFile, e);
    }
  } // save
} // FactionHandler
