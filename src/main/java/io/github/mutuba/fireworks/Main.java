package io.github.mutuba.fireworks;

import io.github.mutuba.fireworks.command.FireWorks;
import io.github.mutuba.fireworks.event.Special_Fireworks;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main instance;
    public static CustomConfig config;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("fw").setExecutor(new FireWorks());
        getServer().getPluginManager().registerEvents(new Special_Fireworks(), this);

        config = new CustomConfig(this, "config.yml");
        config.getConfig();
        config.saveDefaultConfig();
    }
}
