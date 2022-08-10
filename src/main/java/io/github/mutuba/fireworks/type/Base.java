package io.github.mutuba.fireworks.type;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Base {
    private final FireworkEffect.Type[] hands = FireworkEffect.Type.values();
    private final FireworkEffect.Type FEType = hands[new Random().nextInt((int) Arrays.stream(hands).count())];
    private final FireworkMeta fireworkMeta;
    private final ItemStack itemstack = new ItemStack(Material.FIREWORK_ROCKET);
    Random random = new Random();
    int color = (int) (Math.random() * 0x1000000);
    int colorFade = (int) (Math.random() * 0x1000000);
    int power = random.nextInt(4);
    int amount = 1;
    boolean fade = random.nextBoolean(), bool = true;
    private FireworkEffect.Builder effect;
    private String displayName = null;
    private List<String> lore = new ArrayList<>();

    public Base() {
        fireworkMeta = (FireworkMeta) itemstack.getItemMeta();
    }

    Base(Firework firework) {
        fireworkMeta = firework.getFireworkMeta();
    }

    public boolean isFade() {
        return fade;
    }

    public ChatColor getJavaColor() {
        return ChatColor.of(new Color(color));
    }

    public ChatColor getJavaColor_fade() {
        return ChatColor.of(new Color(colorFade));
    }

    public org.bukkit.Color getColor() {
        return org.bukkit.Color.fromRGB(color);
    }

    public org.bukkit.Color getColor_fade() {
        return org.bukkit.Color.fromRGB(colorFade);
    }

    public String sharp() {
        String ConfigString = "Message.CreateFireWorks.FadeOut" + (isFade() ? "On" : "Off") + ".";
        String fireworkEffect = switch (FEType) {
            case BALL -> "Ball";
            case BALL_LARGE -> "BallLarge";
            case BURST -> "Burst";
            case CREEPER -> "Creeper";
            case STAR -> "Star";
        };
        return ConfigString + fireworkEffect;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public FireworkMeta getFireworkMeta() {
        if (!StringUtils.isEmpty(displayName)) fireworkMeta.setDisplayName(displayName);
        if (lore != null) fireworkMeta.setLore(lore);
        if (bool) {
            fireworkMeta.setPower(power);
            fireworkMeta.addEffect(getEffect().build());
        }
        return fireworkMeta;
    }

    public ItemStack getItemStack() {
        itemstack.setAmount(amount);
        itemstack.setItemMeta(getFireworkMeta());
        return itemstack;
    }

    public FireworkEffect.Builder getEffect() {
        effect = FireworkEffect.builder().with(FEType).withColor(getColor());
        if (fade) effect.withFade(getColor_fade());
        return effect;
    }

}
