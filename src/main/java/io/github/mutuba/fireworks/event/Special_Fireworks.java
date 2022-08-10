package io.github.mutuba.fireworks.event;

import io.github.mutuba.fireworks.Main;
import io.github.mutuba.fireworks.type.Base;
import io.github.mutuba.fireworks.type.Special;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Special_Fireworks implements Listener {
    private final String itemDisplayName = Main.instance.getConfig().getString("Item.SpecialFireWorks.DisplayName").replace("&", "§");

    @EventHandler
    public void spawnFireWorks(ProjectileLaunchEvent event) {
        if (!event.getEntity().getType().equals(EntityType.FIREWORK)) return;
        Firework fireworkEntity = (Firework) event.getEntity();
        FireworkMeta fireworkMeta = fireworkEntity.getFireworkMeta();
        if (fireworkMeta.getDisplayName().equals(itemDisplayName)) {
            Base firework = new Special(fireworkEntity);
            fireworkEntity.setFireworkMeta(firework.getFireworkMeta());
        }
    }
}
