package com.gmail.therealkingvictoria.factions;

import java.io.File;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
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

    Set<String> names = factionConfig.getConfigurationSection("factions").getKeys(false);
    if(names != null)
      for(String name: names) {
	System.out.println(name);
	Map<String, Object> map = new HashMap<>();
	for(String reference: factionConfig.getConfigurationSection("factions."+name).getKeys(false)) map.put(reference, factionConfig.get("factions."+name+"."+reference));
	map.put("name", name);
	factions.add(new Faction(map));
      } // for
  } // load

  /**
   * Saves factions to factions.yml config file
   */
  public static void save() {
    Map<String, Map<String, Object>> serializedFactions = new HashMap<>();
    for(Faction faction: factions) {
      String name = faction.getName();
      Map<String, Object> map = faction.serialize();
      map.remove("name");
      serializedFactions.put(name, map);
    } // for

    factionConfig.set("factions", serializedFactions);
    
    try {
      factionConfig.save(factionConfigFile);
    } catch (Exception e) {
      plugin.getLogger().log(Level.SEVERE, "Could not save config to " + factionConfigFile, e);
    }
  } // save
} // FactionHandler
