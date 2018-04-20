package com.gmail.therealkingvictoria.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.gmail.therealkingvictoria.factions.Faction;
import com.gmail.therealkingvictoria.factions.FactionHandler;

public class TestListFacsCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player) {
      for(Faction faction: FactionHandler.getInstance().factions) sender.sendMessage(faction.getName());
    } // if
    return true;
  } // onCommand
} // TestCreateCommand
