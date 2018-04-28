package com.gmail.therealkingvictoria;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.therealkingvictoria.factions.FactionHandler;
import com.gmail.therealkingvictoria.commands.TestCreateCommand;
import com.gmail.therealkingvictoria.commands.TestDeleteCommand;
import com.gmail.therealkingvictoria.commands.TestListFacsCommand;
import com.gmail.therealkingvictoria.commands.TestListMemCommand;

public class CivFactions extends JavaPlugin {
  private static Plugin plugin;

  /**
   * Gets an instance of CivFactions object
   * @return Plugin CivFactions
   */
  public static Plugin getInstance() { return plugin; }
  
  public void onEnable() {
    plugin = this;

    FactionHandler.load();

    getCommand("testcreate").setExecutor(new TestCreateCommand());
    getCommand("testdelete").setExecutor(new TestDeleteCommand());
    getCommand("testlistfacs").setExecutor(new TestListFacsCommand());
    getCommand("testlistmem").setExecutor(new TestListMemCommand());
  } // onEnable
  
  public void onDisable() {
    FactionHandler.save();
  } // onDisable
} // CivFactions
