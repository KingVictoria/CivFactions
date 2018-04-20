package com.gmail.therealkingvictoria.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.gmail.therealkingvictoria.factions.Faction;
import com.gmail.therealkingvictoria.factions.FactionHandler;

public class TestDeleteCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player) {
      new Faction((Player) sender);
      ArrayList<Faction> toDel = new ArrayList<>();
      for(Faction faction: FactionHandler.getInstance().factions) toDel.add(faction);
      for(Faction faction: toDel) faction.delete();
      sender.sendMessage("Factions Deleted!");
    } // if
    return true;
  } // onCommand
} // TestCreateCommand
