package com.covri.anticheat.checks;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;

public class NoFallCheck {
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                // Check if the player has a NoFall permission
                if (!player.hasPermission("anticheat.nofall")) {
                    flagPlayer(player, "NoFall hack detected!");
                }
            }
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