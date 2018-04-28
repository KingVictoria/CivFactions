package com.gmail.therealkingvictoria.factions;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.therealkingvictoria.CivFactions;

public class FactionHandler {
  public static ArrayList<Faction> factions;

  private static Plugin            plugin;
  private static File              factionConfigFile;
  private static FileConfiguration factionConfig;

  /*
   * void load() loads factions
   * void save() saves factions
   */

  /**
   * Loads factions from factions.yml config file
   */
  public static void load() {
    plugin = CivFactions.getInstance();
    
    factionConfigFile = new File(plugin.getDataFolder(), "factions.yml");
    factionConfig = YamlConfiguration.loadConfiguration(factionConfigFile);

    factions = new ArrayList<>();

    ArrayList<Map<String, Object>> serializedFactions = (ArrayList<Map<String, Object>>) factionConfig.get("factions");
    if(serializedFactions != null) for(Map<String, Object> map: serializedFactions) factions.add(new Faction(map));
  } // load

  /**
   * Saves factions to factions.yml config file
   */
  public static void save() {
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
