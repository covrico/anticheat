package com.covri.anticheat.checks;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;

public class MovementCheck {
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // Implement logic to check for illegal movement
        if (isIllegalMovement(player)) {
            flagPlayer(player, "Illegal movement detected!");
        }
    }

    private boolean isIllegalMovement(Player player) {
        // Logic to determine if movement is illegal
        return false; // Replace with actual check
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