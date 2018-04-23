package com.gmail.therealkingvictoria.estates;

import java.util.Map;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Estate {

  Location signLoc;
  
  public Estate(Location loc) {
    signLoc = loc;
  } // Estate(Location)

  public Estate(Map<String, Object> map) {
    HashMap<String, Object> location = (HashMap<String, Object>) map.get("location");
    String world = (String) map.get("world");
    double x = (int) map.get("x");
    double y = (int) map.get("y");
    double z = (int) map.get("z");
    signLoc = new Location(Bukkit.getWorld(world), x, y, z);
  } // Estate(Map<String, Object)

  public Map<String, Object> serialize() {
    HashMap<String, Object> map = new HashMap<>();

    HashMap<String, Object> location = new HashMap<>();
    location.put("world", center.getWorld().getName());
    location.put("x", center.getBlockX());
    location.put("y", center.getBlockY());
    location.put("z", center.getBlockZ());
    map.put("location", location);

    return map;
  } // serialize

} // Estate
