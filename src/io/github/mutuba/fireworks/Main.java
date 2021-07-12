package io.github.mutuba.fireworks;

import io.github.mutuba.fireworks.command.FireWorks;
import io.github.mutuba.fireworks.event.Special_FireWorks;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static CustomConfig config;
    public static Main instance;

    @Override
    public void onEnable(){
        instance = this;

        Bukkit.getServer().getConsoleSender().sendMessage("§a[Fire Works Plugin]");
        Bukkit.getServer().getConsoleSender().sendMessage("§aVersion.2.0");

        getCommand("fw").setExecutor(new FireWorks());
        getServer().getPluginManager().registerEvents(new Special_FireWorks(),this);

        saveDefaultConfig();
        // config.ymlを読み込みます。
        config = new CustomConfig(this, "config.yml");
        config.getConfig();
        config.saveDefaultConfig();

    }

    @Override
    public void onDisable() {

    }

    public static void reload() {
        config.reloadConfig();
    }
}
