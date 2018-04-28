package com.gmail.therealkingvictoria.commands;

import java.util.ArrayList;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.gmail.therealkingvictoria.factions.Faction;
import com.gmail.therealkingvictoria.factions.FactionHandler;

public class TestListMemCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player) {
      String query = "";
      for(int i = 0; i < args.length - 1; i++) query += args[i] + " ";
      query += args[args.length - 1];
      for(Faction faction: FactionHandler.factions) {
	if(faction.getName().equalsIgnoreCase(query)) {
	  sender.sendMessage(faction.getName() +"'s Members:");
	  for(OfflinePlayer op: faction.getMembers()) sender.sendMessage(op.getName());
	} // if
      } // for
    } // if
    return true;
  } // onCommand
} // TestCreateCommand
