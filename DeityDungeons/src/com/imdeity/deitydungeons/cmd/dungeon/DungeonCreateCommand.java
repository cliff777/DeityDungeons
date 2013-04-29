package com.imdeity.deitydungeons.cmd.dungeon;

import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;
import com.imdeity.deitydungeons.DeityDungeons;
import com.imdeity.deitydungeons.DungeonManager;

public class DungeonCreateCommand extends DeityCommandReceiver {

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		return false;
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		//Basic checking
		if(args.length != 2) return false;
		if(!DeityDungeons.isInt(args[1])) return false;
		String dungeon = args[0];
		int players = Integer.parseInt(args[1]);
		
		//Make sure there isn't an existing dungeon
		if(DungeonManager.dungeonExists(dungeon)) {
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "DeityDungeon", "The dungeon " + dungeon + " already exists");
			return false;
		}
		
		//Make the dungeon
		DungeonManager.createDungeon(player, dungeon, players);
		return true;
	}

}
