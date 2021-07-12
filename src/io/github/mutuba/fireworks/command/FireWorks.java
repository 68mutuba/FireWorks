package io.github.mutuba.fireworks.command;

import io.github.mutuba.fireworks.Main;
import io.github.mutuba.fireworks.create.CreateFireWorks;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class FireWorks implements CommandExecutor, TabCompleter {

    private List<String> arg0 = Arrays.asList("get","reload");
    private List<String> arg1 = Arrays.asList("random", "spawnrandom", "allPlayer");
    private List<String> arg2 = Arrays.asList("random", "spawnrandom");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0].equalsIgnoreCase("reload")){
            Main.instance.reloadConfig();;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.config.getConfig().getString("Message.Reload")));
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.config.getConfig().getString("Message.Command.NotPlayer")
                    .replaceAll("&", "§"));
        } else {
            Player player = (Player) sender;
            if (player.hasPermission("fireworks.*")) {
                if (args.length == 0) {
                    FireWorks.help(player);
                    return true;
                }
                if (!(args[0].equalsIgnoreCase("get"))) {
                    FireWorks.help(player);
                    return true;
                } else {
                    if (args.length < 2) {
                        FireWorks.help(player);
                    }
                    if (args.length >= 2) {
                        if (args[1].equalsIgnoreCase("allPlayer")) {

                            if (args[2].equalsIgnoreCase("random")){

                                for (Player p : Bukkit.getOnlinePlayers()){

                                    CreateFireWorks.createNormal(p);

                                    p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,1f);

                                }
                            }

                            if (args[2].equalsIgnoreCase("spawnrandom")){
                                for (Player p : Bukkit.getOnlinePlayers()){

                                    if (args.length == 3) {
                                        int amount = 64;
                                        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET);
                                        ItemMeta itemMeta = fireworks.getItemMeta();
                                        List<String> lore = new ArrayList<String>();
                                        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.DisplayName")));
                                        lore.add("§7§k飛翔時間: ?");
                                        lore.add("§7§k?型");
                                        lore.add("§7§k  カスタム");
                                        lore.add("§7§k  色変化:  ?");
                                        lore.add(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.Lore")));
                                        itemMeta.setLore(lore);
                                        fireworks.setAmount(amount);
                                        fireworks.setItemMeta(itemMeta);
                                        p.getInventory().addItem(fireworks);
                                        p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,1f);
                                    }
                                }
                            }
                        }

                        if (args[1].equalsIgnoreCase("random")) {
                            if (args.length == 2) {
                                int amount = 1;

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
                                return true;
                            }
                            if (args.length > 2){
                                Random random = new Random();

                                int red = random.nextInt(255);
                                int blue = random.nextInt(255);
                                int green = random.nextInt(255);
                                int power = random.nextInt(3) + 1;
                                int shape = random.nextInt(5) + 1;
                                boolean fade = random.nextBoolean();

                                ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET);
                                FireworkMeta meta = (FireworkMeta) fireworks.getItemMeta();

                                try {
                                    int amount = Integer.parseInt(args[2]);
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
                                } catch (Exception e) {
                                    player.sendMessage(Main.config.getConfig().getString("Message.Command.NotNumber")
                                            .replaceAll("&", "§"));

                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("spawnrandom")) {
                            if (args.length == 2) {
                                int amount = 1;
                                ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET);
                                ItemMeta itemMeta = fireworks.getItemMeta();
                                List<String> lore = new ArrayList<String>();
                                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.DisplayName")));
                                lore.add("§7§k飛翔時間: ?");
                                lore.add("§7§k?型");
                                lore.add("§7§k  カスタム");
                                lore.add("§7§k  色変化:  ?");
                                lore.add(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.Lore")));
                                itemMeta.setLore(lore);
                                fireworks.setAmount(amount);
                                fireworks.setItemMeta(itemMeta);
                                player.getInventory().addItem(fireworks);
                            } else {
                                try {
                                    int amount = Integer.parseInt(args[2]);
                                    ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET);
                                    ItemMeta itemMeta = fireworks.getItemMeta();
                                    List<String> lore = new ArrayList<String>();
                                    itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.DisplayName")));
                                    lore.add("§7§k飛翔時間: ?");
                                    lore.add("§7§k?型");
                                    lore.add("§7§k  カスタム");
                                    lore.add("§7§k  色変化:  ?");
                                    lore.add(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Item.SpecialFireWorks.Lore")));
                                    itemMeta.setLore(lore);
                                    fireworks.setAmount(amount);
                                    fireworks.setItemMeta(itemMeta);
                                    player.getInventory().addItem(fireworks);

                                    player.sendMessage(Main.config.getConfig().getString("Message.SpecialFireWorks").replaceAll("&", "§"));
                                } catch (Exception e) {
                                    player.sendMessage(Main.config.getConfig().getString("Message.Command.NotNumber")
                                            .replaceAll("&", "§"));

                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender.hasPermission("fireworks.*"))) {
            return null;
        } else {
            List<String> retList = new ArrayList<>();
            if (args.length == 1) {
                for (String s : arg0) {
                    if (s.startsWith(args[0])){
                        retList.add(s);
                    }
                }
                return retList;
            } else if (args.length == 2) {
                retList.addAll(arg1);
                if ("get".equals(args[0])) {
                    return retList;
                }
            } else if (args.length == 3){
                retList.addAll(arg2);
                if ("allPlayer".equals(args[1])) {
                    return retList;
                }
            }
        }
        return null;
    }

    private static void help(Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.Help")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.Random")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.SpawnRandom")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.Reload")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.GetAllRandom")));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.config.getConfig().getString("Message.Command.GetAllSpawnRandom")));
    }
}