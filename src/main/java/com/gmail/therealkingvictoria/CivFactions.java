package com.gmail.therealkingvictoria;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CivFactions extends JavaPlugin {

  Plugin plugin;
  
  public void onEnable() {
    getLogger().info("Successfully Enabled");
    plugin = this;
  }
  
  public void onDisable() {
    getLogger().info("Successfully Disabled");
  }

}
