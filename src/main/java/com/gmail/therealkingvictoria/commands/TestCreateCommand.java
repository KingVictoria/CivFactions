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
      Faction fac;
      if(args.length == 0) fac = new Faction((Player) sender);
      else {
	String name = args[0];
	for(int i = 1; i < args.length; i++) name += " " + args[i];
	fac = new Faction((Player) sender, name);
      }
      sender.sendMessage("The Faction of " + fac.getName() + " Created!");
    } // if
    return true;
  } // onCommand
} // TestCreateCommand
