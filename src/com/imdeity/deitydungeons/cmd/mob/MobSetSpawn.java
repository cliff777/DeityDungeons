package com.imdeity.deitydungeons.cmd.mob;

import org.bukkit.entity.Player;

import com.imdeity.deityapi.DeityAPI;
import com.imdeity.deityapi.api.DeityCommandReceiver;
import com.imdeity.deitydungeons.DungeonManager;
import com.imdeity.deitydungeons.obj.Mob;

public class MobSetSpawn extends DeityCommandReceiver {

	@Override
	public boolean onConsoleRunCommand(String[] args) {
		return false;
	}

	@Override
	public boolean onPlayerRunCommand(Player player, String[] args) {
		if(args.length != 0) {
			return false;
		}
		
		//Make sure the player has a selected mob
		if(!DungeonManager.playerHasMob(player)) {
			DeityAPI.getAPI().getChatAPI().sendPlayerMessage(player, "DeityDungeons", "You must first select a mob.");
			return false;
		}
		
		//Get the mob
		Mob mob = DungeonManager.getPlayersMob(player);
		
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		//Database
		DungeonManager.setMobAttribute(mob, "x", x);
		DungeonManager.setMobAttribute(mob, "y", y);
		DungeonManager.setMobAttribute(mob, "z", z);
		
		//Memory
		mob.setX(x);
		mob.setY(y);
		mob.setZ(z);

		return true;
	}

}
