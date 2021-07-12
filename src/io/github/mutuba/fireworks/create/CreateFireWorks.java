package io.github.mutuba.fireworks.create;

import io.github.mutuba.fireworks.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class CreateFireWorks {

    public static void createSpecial(Player player, Location spawn){

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

        Firework fireworks = (Firework) spawn.getWorld().spawnEntity(spawn, EntityType.FIREWORK);

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

    public static void createNormal(Player player) {
        int amount = 64;

        Random random = new Random();

        int red = random.nextInt(255);
        int blue = random.nextInt(255);
        int green = random.nextInt(255);
        int power = random.nextInt(3) + 1;
        int shape = random.nextInt(5) + 1;
        boolean fade = random.nextBoolean();

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET);
        FireworkMeta meta = (FireworkMeta) fireworks.getItemMeta();

        if (fade) {
            int red_fade = random.nextInt(255) + 1;
            int blue_fade = random.nextInt(255) + 1;
            int green_fade = random.nextInt(255) + 1;
            if (shape == 1) {
                FireworkEffect effect = FireworkEffect
                        .builder()
                        .with(FireworkEffect.Type.BALL)
                        .withFade(Color.fromRGB(red_fade, green_fade, blue_fade))
                        .withColor(Color.fromRGB(red, green, blue))
                        .build();
                meta.setPower(power);
                meta.addEffect(effect);
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOn.Ball")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("%fadeout_color%", ChatColor.of(new java.awt.Color(red_fade, green_fade, blue_fade)).toString())
                        .replaceAll("&", "§"));
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
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOn.BallLarge")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("%fadeout_color%", ChatColor.of(new java.awt.Color(red_fade, green_fade, blue_fade)).toString())
                        .replaceAll("&", "§"));
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
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOn.Burst")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("%fadeout_color%", ChatColor.of(new java.awt.Color(red_fade, green_fade, blue_fade)).toString())
                        .replaceAll("&", "§"));
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
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOn.Creeper")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("%fadeout_color%", ChatColor.of(new java.awt.Color(red_fade, green_fade, blue_fade)).toString())
                        .replaceAll("&", "§"));
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
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOn.Star")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("%fadeout_color%", ChatColor.of(new java.awt.Color(red_fade, green_fade, blue_fade)).toString())
                        .replaceAll("&", "§"));
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
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOff.Ball")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("&", "§"));
            }
            if (shape == 2) {
                FireworkEffect effect = FireworkEffect
                        .builder()
                        .with(FireworkEffect.Type.BALL_LARGE)
                        .withColor(Color.fromRGB(red, green, blue))
                        .build();
                meta.setPower(power);
                meta.addEffect(effect);
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOff.BallLarge")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("&", "§"));
            }
            if (shape == 3) {
                FireworkEffect effect = FireworkEffect
                        .builder()
                        .with(FireworkEffect.Type.BURST)
                        .withColor(Color.fromRGB(red, green, blue))
                        .build();

                meta.setPower(power);
                meta.addEffect(effect);
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOff.Burst")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("&", "§"));
            }
            if (shape == 4) {
                FireworkEffect effect = FireworkEffect
                        .builder()
                        .with(FireworkEffect.Type.CREEPER)
                        .withColor(Color.fromRGB(red, green, blue))
                        .build();

                meta.setPower(power);
                meta.addEffect(effect);
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOff.Creeper")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("&", "§"));
            }
            if (shape == 5) {
                FireworkEffect effect = FireworkEffect
                        .builder()
                        .with(FireworkEffect.Type.STAR)
                        .withColor(Color.fromRGB(red, green, blue))
                        .build();

                meta.setPower(power);
                meta.addEffect(effect);
                fireworks.setAmount(amount);
                fireworks.setItemMeta(meta);
                player.getInventory().addItem(fireworks);
                player.sendMessage(Main.config.getConfig().getString("Message.CreateFireWorks.FadeOutOff.Star")
                        .replaceAll("%first_color%", ChatColor.of(new java.awt.Color(red, green, blue)).toString())
                        .replaceAll("&", "§"));
            }
        }
    }
}
