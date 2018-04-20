package com.gmail.therealkingvictoria.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import com.gmail.therealkingvictoria.factions.Faction;

public class TestCreateCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player) {
      new Faction((Player) sender);
      sender.sendMessage("Faction Created!");
    } // if
    return true;
  } // onCommand
} // TestCreateCommand
