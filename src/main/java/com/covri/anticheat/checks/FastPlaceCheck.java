package com.covri.anticheat.checks;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

public class FastPlaceCheck {
    private static final long PLACE_THRESHOLD = 100; // Time in milliseconds
    private long lastPlaceTime;

    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        long currentTime = System.currentTimeMillis();

        // Check if the time between placements is too short
        if (currentTime - lastPlaceTime < PLACE_THRESHOLD) {
            flagPlayer(player, "Fast place detected!");
        }

        lastPlaceTime = currentTime;
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