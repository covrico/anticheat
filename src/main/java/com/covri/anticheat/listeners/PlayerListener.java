package com.covri.anticheat.listeners;

import com.covri.anticheat.checks.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerListener implements Listener {
    private final MovementCheck movementCheck = new MovementCheck();
    private final SpeedCheck speedCheck = new SpeedCheck();
    private final FlyCheck flyCheck = new FlyCheck();
    private final NoFallCheck noFallCheck = new NoFallCheck();
    private final FastPlaceCheck fastPlaceCheck = new FastPlaceCheck();
    private final FastBreakCheck fastBreakCheck = new FastBreakCheck();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        movementCheck.onPlayerMove(event);
        speedCheck.onPlayerMove(event);
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        flyCheck.onPlayerToggleFlight(event);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        fastPlaceCheck.onPlayerInteract(event);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        noFallCheck.onEntityDamage(event);
    }
}