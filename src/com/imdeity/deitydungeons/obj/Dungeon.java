package com.imdeity.deitydungeons.obj;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;

import com.imdeity.deityapi.DeityAPI;

//Class to store all dungeon data in memory
public class Dungeon {
	
	public ArrayList<Mob> mobs = new ArrayList<Mob>();
	
	String name;
	int numberOfPlayers;
	World world;
	int x;
	int y;
	int z;
	int yaw;
	int pitch;
	Location location;
	
	public Dungeon(String name, int numberOfPlayers, World world, int x, int y, int z, int yaw, int pitch) {
		this.name = name;
		this.numberOfPlayers = numberOfPlayers;
		this.world = world;
		/*
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		*/
		
		location = new Location(world, x, y, z, yaw, pitch);
	}
	
	public World getWorld() {
		return world;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String s) {
		return DeityAPI.getAPI().getDataAPI().getMySQL().write("UPDATE `dungeon_list` SET `name`=? WHERE `name`=?", s, name);
	}
	
	public void addMob(Mob mob) {
		mobs.add(mob);
	}
	
	public void removeMob(Mob mob) {
		mobs.remove(mob);
	}
	
	public boolean hasMob(String name) {
		for(Mob mob : mobs) {
			if(mob.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public Mob getMobByName(String name) {
		for(Mob mob : mobs) {
			if(mob.getName().equals(name)) {
				return mob;
			}
		}
		return null;
	}
}
