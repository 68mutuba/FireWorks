package io.github.mutuba.fireworks.command;

import io.github.mutuba.fireworks.type.Base;
import io.github.mutuba.fireworks.type.Special;
import io.github.mutuba.fireworks.Main;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FireWorks implements CommandExecutor, TabCompleter {
    static FileConfiguration config = Main.instance.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String arg0 = args.length >= 1 ? args[0] : "";
        String arg1 = args.length >= 2 ? args[1] : "";
        String arg2 = args.length >= 3 ? args[2] : "";

        if (arg0.equalsIgnoreCase("reload")) {
            Main.instance.reloadConfig();
            sender.sendMessage(format(config.getString("Message.Reload")));
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(format(config.getString("Message.Command.NotPlayer")));
            return false;
        } else {
            Player player = (Player) sender;
            if (!player.hasPermission("fireworks.*")) return false;
            if (arg0.equalsIgnoreCase("get")) {
                if (arg1.equalsIgnoreCase("allPlayer")) {
                    if (arg2.equalsIgnoreCase("random") || arg2.equalsIgnoreCase("spawnrandom")) {
                        Base fw = giveFirework(player, args, 2);
                        if (fw == null) return false;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.getInventory().addItem(fw.getItemStack());
                            p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 1f);
                        }
                        return false;
                    }
                } else if (arg1.equalsIgnoreCase("random") || arg1.equalsIgnoreCase("spawnrandom")) {
                    Base fw = giveFirework(player, args, 1);
                    if (fw == null) return false;
                    player.getInventory().addItem(fw.getItemStack());
                    return false;
                }
            }
            help(player);
        }
        return false;
    }

    Base giveFirework(Player player, String[] args, int integger) {
        String arg1 = args.length >= integger + 1 ? args[integger] : "";
        String arg2 = args.length >= integger + 2 ? args[integger + 1] : "";
        int amount = 1;
        if (NumberUtils.isNumber(arg2)) amount = (int) Double.parseDouble(arg2);
        else if (args.length >= integger + 2) {
            player.sendMessage(format(config.getString("Message.Command.NotNumber")));
            return null;
        }
        Base fw;
        if (arg1.equalsIgnoreCase("spawnrandom")) {
            player.sendMessage(format(config.getString("Message.SpecialFireWorks")));
            fw = special();
        } else fw = normal(player);
        fw.setAmount(amount);
        return fw;
    }

    void help(Player player) {
        String[] command = {"Help", "Random", "SpawnRandom", "Reload", "GetAllRandom", "GetAllSpawnRandom"};
        for (String com : command)
            player.sendMessage(format(config.getString("Message.Command." + com)));
    }

    Base normal(Player player) {
        Base color = new Base();
        String cstring = config.getString(color.sharp());
        if (color.isFade()) {
            cstring = cstring.replace("%fadeout_color%", color.getJavaColor_fade().toString());
        }
        cstring = format(cstring.replace("%first_color%", color.getJavaColor().toString()));
        player.sendMessage(cstring);
        return color;
    }

    public static Base special() {
        Base color = new Special();
        List<String> lore = new ArrayList<>(Arrays.asList(
                "§7§k飛翔時間: ?",
                "§7§k?型",
                "§7§k  カスタム",
                "§7§k  色変化:  ?",
                format(config.getString("Item.SpecialFireWorks.Lore"))));
        color.setLore(lore);
        color.setDisplayName(format(config.getString("Item.SpecialFireWorks.DisplayName")));
        return color;
    }

    /**
     * TabCompleter
     */

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender.hasPermission("fireworks.*"))) return null;
        else {
            switch (args.length) {
                case 1:
                    return setTAB(args);
                case 2:
                    if ("get".equalsIgnoreCase(args[0])) return setTAB(args);
                case 3:
                    if ("allPlayer".equalsIgnoreCase(args[1])) return setTAB(args);
            }
        }
        return null;
    }

    List<String> setTAB(String[] args) {
        String[][] arg0 = {
                {"get", "reload"},
                {"random", "spawnrandom", "allPlayer"},
                {"random", "spawnrandom"}
        };
        List<String> retList = new ArrayList<>();
        for (String s : arg0[args.length - 1])
            if (s.toLowerCase().startsWith(args[args.length - 1].toLowerCase()))
                retList.add(s);
        return retList;
    }

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String[] format(String... text) {
        String[] strs = new String[text.length];
        for (int i = 0; i < text.length; i++) strs[i] = ChatColor.translateAlternateColorCodes('&', text[i]);
        return strs;
    }
}
