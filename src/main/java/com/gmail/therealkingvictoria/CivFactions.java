package com.gmail.therealkingvictoria;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.therealkingvictoria.factions.FactionHandler;
import com.gmail.therealkingvictoria.commands.TestCreateCommand;
import com.gmail.therealkingvictoria.commands.TestDeleteCommand;

public class CivFactions extends JavaPlugin {
  Plugin plugin;

  FactionHandler fh;
  
  public void onEnable() {
    plugin = this;

    fh = new FactionHandler(plugin);

    fh.load();

    getCommand("testcreate").setExecutor(new TestCreateCommand());
    getCommand("testdelete").setExecutor(new TestDeleteCommand());
  } // onEnable
  
  public void onDisable() {
    fh.save();
  } // onDisable
} // CivFactions
