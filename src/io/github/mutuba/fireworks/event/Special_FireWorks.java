package io.github.mutuba.fireworks.event;

import io.github.mutuba.fireworks.Main;
import io.github.mutuba.fireworks.create.CreateFireWorks;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;
import java.util.Set;

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

                        BlockFace blockFace = event.getBlockFace();

                        if (blockFace == BlockFace.EAST){

                            Location spawn = new Location(block.getWorld(), block.getX() + 1.1, block.getY() + 0.5, block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);


                        } else if (blockFace == BlockFace.WEST){

                            Location spawn = new Location(block.getWorld(), block.getX() - 0.1, block.getY() + 0.5, block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.NORTH){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 0.5, block.getZ() - 0.1);

                            CreateFireWorks.createSpecial(player, spawn);


                        }else if (blockFace == BlockFace.SOUTH){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 0.5, block.getZ() + 1.1);

                            CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.UP){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 1.1, block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.DOWN){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 0.1 , block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);

                        }
                    }
                    if ((player.getGameMode() == GameMode.CREATIVE)) {

                        BlockFace blockFace = event.getBlockFace();

                        if (blockFace == BlockFace.EAST){

                            Location spawn = new Location(block.getWorld(), block.getX() + 1.1, block.getY() + 0.5, block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);


                        } else if (blockFace == BlockFace.WEST){

                                Location spawn = new Location(block.getWorld(), block.getX() - 0.1, block.getY() + 0.5, block.getZ() + 0.5);

                                CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.NORTH){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 0.5, block.getZ() - 0.1);

                            CreateFireWorks.createSpecial(player, spawn);


                        }else if (blockFace == BlockFace.SOUTH){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 0.5, block.getZ() + 1.1);

                            CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.UP){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 1.1, block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);

                        } else if (blockFace == BlockFace.DOWN){

                            Location spawn = new Location(block.getWorld(), block.getX() + 0.5, block.getY() - 0.1 , block.getZ() + 0.5);

                            CreateFireWorks.createSpecial(player, spawn);

                        }

                    }
                }
            }
        }
    }
}
