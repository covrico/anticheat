package com.covri.anticheat.checks;

import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.entity.Player;

public class FlyCheck {
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        // Check if the player is not in creative mode and is trying to fly
        if (!player.isFlying() && !player.hasPermission("anticheat.fly")) {
            flagPlayer(player, "Fly hack detected!");
        }
    }

    private void flagPlayer(Player player, String message) {
        // Logic to alert staff or log the incident
        alertStaff(player, message);
    }

    private void alertStaff(Player player, String message) {
        for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
            if (onlinePlayer.isOp()) {
                onlinePlayer.sendMessage("ALERT: " + message + " - Player: " + player.getName());
            }
        }
    }
}