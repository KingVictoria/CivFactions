package com.gmail.therealkingvictoria.factions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.gmail.therealkingvictoria.estates.Estate;

/**
 * The basic unit if CivFactions -- Consists of an owner and a bunch of members
 */
public class Faction {
  FactionHandler fh;
  ArrayList<UUID> members;
  UUID ownerUUID;
  String name;
  Estate estate;

  /**
   * Creates a Faction object (if another faction shares this faction's name--defaults to "owner's name" then it will not be created
   * @param owner Player entity creator
   */
  public Faction(Player owner) {
    ownerUUID = owner.getUniqueId();
    members = new ArrayList<>();
    fh = FactionHandler.getInstance();
    name = owner.getName() + "'s Faction";

    for(Faction faction: fh.factions) if(faction.name.equalsIgnoreCase(name)) return;

    fh.factions.add(this);
  } // Faction(Player)

  /**
   * Creates a Faction object (if another faction shares the desired name then it will not be created)
   * @param owner Player entity creator
   * @param name String desired name of faction
   */
  public Faction(Player owner, String name) {
    ownerUUID = owner.getUniqueId();
    members = new ArrayList<>();
    fh = FactionHandler.getInstance();
    this.name = name;

    for(Faction faction: fh.factions) if(faction.name.equalsIgnoreCase(name)) return;
    
    fh.factions.add(this);
  } // Faction(Player, String)

  /**
   * Creates a Faction Object from serial
   */
  public Faction(Map<String, Object> map) {
    name = (String) map.get("name");
    ownerUUID = UUID.fromString((String) map.get("owner"));
    members = new ArrayList<>();
    ArrayList<String> serializedMembers = (ArrayList<String>) map.get("members");
    for(String serializedMember: serializedMembers) members.add(UUID.fromString(serializedMember));
    fh = FactionHandler.getInstance();

    if(map.get("estate") != null) estate = new Estate((HashMap<String, Object>) map.get("estate"));
  } // Faction(Map<String, String>)

  /**
   * Deletes this faction
   */
  public void delete() {
    fh.factions.remove(this);
  } // delete

  /**
   * Serializes this Faction to a Map of String to Object
   * @return Map of String to Object
   */
  public Map<String, Object> serialize() {
    HashMap<String, Object> map = new HashMap<>();

    map.put("name", name);
    
    map.put("owner", ownerUUID.toString());
    
    ArrayList<String> serializedMembers = new ArrayList<>();
    for(UUID uuid: members) serializedMembers.add(uuid.toString());
    map.put("members", serializedMembers);

    map.put("estate", estate.serialize());
    
    return map;
  } // serialize

  /**
   * Changes the name of this faction
   * @param newName String to change the name to
   * @return false if another faction shares the desired name (name will not change)
   */
  public boolean changeName(String newName) {
    for(Faction faction: fh.factions) if(faction.name.equalsIgnoreCase(newName)) return false;
    name = newName;
    return true;
  } // changeName

  /**
   * Sets the Estate of a Faction
   * @param estate Estate to set
   */
  public void setEstate(Estate estate) {
    this.estate = estate;
  } // setEstate

  /**
   * Gets the Estate of a Faction
   * @return Estate of Faction
   */
  public Estate getEstate() {
    return estate;
  } // getEstate

  /**
   * Gets the name of this Faction
   * @return String name
   */
  public String getName() { return name; }

  /**
   * Returns an ArrayList of OfflinePlayer objects corresponding to the members of this faction
   * @return ArrayList of OfflinePlayer objects corresponding to the members of this faction
   */
  public ArrayList<OfflinePlayer> getMembers() {
    ArrayList<OfflinePlayer> players = new ArrayList<>();
    for(UUID uuid: members) players.add(Bukkit.getOfflinePlayer(uuid));
    players.add(Bukkit.getOfflinePlayer(ownerUUID));
    return players;
  } // getMembers

  /**
   * Determines whether a given player is a member of this faction
   * @param member Player to check if is a member
   * @return false if is not a member
   */
  public boolean isMember(Player member) {
    for(UUID uuid: members) if(uuid.equals(member.getUniqueId())) return true;
    if(ownerUUID.equals(member.getUniqueId())) return true;
    return false;
  } // isMember

  /**
   * Adds a player to this faction
   * @param member Player entity to add
   * @return false if the member is already a member of this faction
   */
  public boolean addMember(Player member) {
    if(isMember(member)) return false; // return false if the member is already a member of this faction
    members.add(member.getUniqueId());
    return true;
  } // addMember

  /**
   * Removes a player from this faction
   * @param member Player entity to remove
   * @return false if either not a member or the owner of this faction
   */
  public boolean removeMember(Player member) {
    if(!isMember(member)) return false;
    if(ownerUUID.equals(member.getUniqueId())) return false;
    members.remove(member.getUniqueId());
    return true;
  } // removeMember

  /**
   * Gives this faction a new owner
   * @param newOwner Player entity to set as new owner
   * @return false if Player is not a member of this faction and thus cannot be set as owner
   */
  public boolean setOwner(Player newOwner) {
    if(!isMember(newOwner)) return false;
    members.add(ownerUUID);
    ownerUUID = newOwner.getUniqueId();
    return true;
  }

  /**
   * Gets the OfflinePlayer object for the owner of this faction
   * @return OfflinePlayer object of the owner
   */
  public OfflinePlayer getOwner() {
    return Bukkit.getOfflinePlayer(ownerUUID);
  } // getOwner
} // Faction
