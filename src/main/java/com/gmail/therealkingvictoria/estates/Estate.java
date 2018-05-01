package com.gmail.therealkingvictoria.estates;

import java.util.Map;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.MemorySection;

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
    location = (Location) map.get("location");

    name = (String) map.get("name");

    resBonus = (int) map.get("resource_bonus");
  } // Estate(Map<String, Object)

  public Map<String, Object> serialize() {
    Map<String, Object> map = new HashMap<>();
    
    map.put("location", location);

    map.put("name", name);

    map.put("resource_bonus", resBonus);

    return map;
  } // serialize

  public String   getName()     { return name;     }
  public Location getLocation() { return location; }
  public int      getResBonus() { return resBonus; }
} // Estate
