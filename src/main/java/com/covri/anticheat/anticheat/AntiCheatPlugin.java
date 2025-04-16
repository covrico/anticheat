package com.covri.anticheat.anticheat;

import org.bukkit.plugin.java.JavaPlugin;
import com.covri.anticheat.listeners.PlayerListener;

public class AntiCheatPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("AntiCheat has been enabled!");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiCheat has been disabled!");
    }
}