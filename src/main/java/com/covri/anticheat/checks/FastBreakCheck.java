package com.covri.anticheat.checks;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.entity.Player;

public class FastBreakCheck {
    private static final long BREAK_THRESHOLD = 100; // Time in milliseconds
    private long lastBreakTime;

    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        long currentTime = System.currentTimeMillis();

        // Check if the time between breaks is too short
        if (currentTime - lastBreakTime < BREAK_THRESHOLD) {
            flagPlayer(player, "Fast break detected!");
        }

        lastBreakTime = currentTime;
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