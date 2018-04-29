package com.gmail.therealkingvictoria.estates;

import java.util.Map;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Estate {

  String name;
  Location location;

  int resBonus; // resource bonus level
  
  public Estate(String name, Location loc) {
    this.name = name;
    location = loc;
    resBonus = 1;
  } // Estate(Location)

  public Estate(Map<String, Object> map) {
    HashMap<String, Object> loc = (HashMap<String, Object>) map.get("location");
    String world = (String) loc.get("world");
    double x = (int) loc.get("x");
    double y = (int) loc.get("y");
    double z = (int) loc.get("z");
    location = new Location(Bukkit.getWorld(world), x, y, z);

    name = (String) map.get("name");

    resBonus = (int) map.get("resource_bonus");
  } // Estate(Map<String, Object)

  public Map<String, Object> serialize() {
    HashMap<String, Object> map = new HashMap<>();

    HashMap<String, Object> loc = new HashMap<>();
    loc.put("world", location.getWorld().getName());
    loc.put("x", location.getBlockX());
    loc.put("y", location.getBlockY());
    loc.put("z", location.getBlockZ());
    map.put("location", location);

    map.put("name", name);

    map.put("resource_bonus", resBonus);

    return map;
  } // serialize

  public String   getName()     { return name;     }
  public Location getLocation() { return location; }
  public int      getResBonus() { return resBonus; }
} // Estate
