package com.covri.anticheat.checks;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;

public class SpeedCheck {
    private static final double SPEED_LIMIT = 0.5; // Adjust as needed

    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        double distance = event.getTo().distance(event.getFrom());

        // Check if the distance moved exceeds the speed limit
        if (distance > SPEED_LIMIT) {
            flagPlayer(player, "Speed hack detected! Distance: " + distance);
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