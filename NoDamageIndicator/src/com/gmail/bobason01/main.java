package com.gmail.bobason01;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    public static main instance;
    public final Logger MainLogger = this.getLogger();
	public main() {
	}
	
    public void onEnable() {
        instance = this;
        this.MainLogger.info("Starting on " + this.getServer().getVersion());
        Bukkit.getPluginManager().registerEvents(new nodamageindicator(), instance);
    }
    public void onDisable() {
        this.MainLogger.info("Disabled!");
    }
}