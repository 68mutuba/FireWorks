package io.github.mutuba.fireworks.event;

import io.github.mutuba.fireworks.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class Special_FireWorks implements Listener {

    private String itemDisplayName = ChatColor.translateAlternateColorCodes('&',Main.instance.getConfig().getString("Item.SpecialFireWorks.DisplayName"));

    @EventHandler
    public void spawnFireWorks(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();

        if (!(player.getInventory().getItemInMainHand().getType() == Material.FIREWORK_ROCKET)){
            return;
        }else{
            if(!(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(itemDisplayName))){
             return;
            }else{
                if (!(action == Action.RIGHT_CLICK_BLOCK)){
                    return;
                }else {
                    event.setCancelled(true);
                    if (!(player.getGameMode() == GameMode.CREATIVE)) {
                        int amount = player.getInventory().getItemInMainHand().getAmount();
                        player.getInventory().getItemInMainHand().setAmount(amount - 1);

                        Random red_random = new Random();
                        Random blue_random = new Random();
                        Random green_random = new Random();
                        Random power_random = new Random();
                        Random shape_random = new Random();
                        Random fade_random = new Random();

                        int red = red_random.nextInt(255);
                        int blue = blue_random.nextInt(255);
                        int green = green_random.nextInt(255);
                        int power = power_random.nextInt(3) + 1;
                        int shape = shape_random.nextInt(5) + 1;
                        boolean fade = fade_random.nextBoolean();

                        Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 1.5, block.getZ() + 0.5);
                        Firework fireworks = (Firework) spawn.getWorld().spawnEntity(spawn, EntityType.FIREWORK);
                        ;
                        FireworkMeta meta = fireworks.getFireworkMeta();

                        if (fade) {
                            Random red_fade_random = new Random();
                            Random blue_fade_random = new Random();
                            Random green_fade_random = new Random();

                            int red_fade = red_fade_random.nextInt(255) + 1;
                            int blue_fade = blue_fade_random.nextInt(255) + 1;
                            int green_fade = green_fade_random.nextInt(255) + 1;
                            if (shape == 1) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);
                            }
                            if (shape == 2) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL_LARGE)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);
                            }
                            if (shape == 3) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BURST)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 4) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.CREEPER)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 5) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.STAR)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                        } else {
                            if (shape == 1) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 2) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL_LARGE)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 3) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BURST)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 4) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.CREEPER)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 5) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.STAR)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                        }
                    }
                    if ((player.getGameMode() == GameMode.CREATIVE)) {
                        Random red_random = new Random();
                        Random blue_random = new Random();
                        Random green_random = new Random();
                        Random power_random = new Random();
                        Random shape_random = new Random();
                        Random fade_random = new Random();

                        int red = red_random.nextInt(255);
                        int blue = blue_random.nextInt(255);
                        int green = green_random.nextInt(255);
                        int power = power_random.nextInt(3) + 1;
                        int shape = shape_random.nextInt(5) + 1;
                        int fade = fade_random.nextInt(1) + 1;

                        Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 1.5, block.getZ() + 0.5);
                        Firework fireworks = (Firework) spawn.getWorld().spawnEntity(spawn, EntityType.FIREWORK);
                        ;
                        FireworkMeta meta = fireworks.getFireworkMeta();

                        if (fade == 1) {
                            Random red_fade_random = new Random();
                            Random blue_fade_random = new Random();
                            Random green_fade_random = new Random();

                            int red_fade = red_fade_random.nextInt(255) + 1;
                            int blue_fade = blue_fade_random.nextInt(255) + 1;
                            int green_fade = green_fade_random.nextInt(255) + 1;
                            if (shape == 1) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);
                            }
                            if (shape == 2) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL_LARGE)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);
                            }
                            if (shape == 3) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BURST)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 4) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.CREEPER)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 5) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.STAR)
                                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                        }
                        if (fade == 2) {
                            if (shape == 1) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 2) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BALL_LARGE)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();
                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 3) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.BURST)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                            if (shape == 4) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.CREEPER)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);
                            }
                            if (shape == 5) {
                                FireworkEffect effect = FireworkEffect
                                        .builder()
                                        .with(FireworkEffect.Type.STAR)
                                        .withColor(Color.fromRGB(red, green, blue))
                                        .build();

                                meta.setPower(power);
                                meta.addEffect(effect);
                                fireworks.setFireworkMeta(meta);

                            }
                        }
                    }
                }
            }
            }
        }

}
