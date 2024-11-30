package org.thematop.snowball;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.Random;

public final class Snowball extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SnowBall death plugin has been enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("SnowBall death plugin has been disabled");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Random random = new Random();

        int randomNumber = random.nextInt(5) + 1;
        ItemStack snowball = new ItemStack(Material.SNOWBALL);

        ItemMeta meta = snowball.getItemMeta();
        if (meta != null) {
            String colorHex =
                    ChatColor.of("#77fcf5") + "" + ChatColor.BOLD + "I" +
                            ChatColor.of("#6ffaf3") + "" + ChatColor.BOLD + "c" +
                            ChatColor.of("#67f8f1") + "" + ChatColor.BOLD + "y " +
                            ChatColor.of("#5ff6ee") + "" + ChatColor.BOLD + "S" +
                            ChatColor.of("#57f4ec") + "" + ChatColor.BOLD + "n" +
                            ChatColor.of("#4ff2ea") + "" + ChatColor.BOLD + "o" +
                            ChatColor.of("#47f0e8") + "" + ChatColor.BOLD + "w" +
                            ChatColor.of("#3feddf") + "" + ChatColor.BOLD + "b" +
                            ChatColor.of("#37ebdd") + "" + ChatColor.BOLD + "a" +
                            ChatColor.of("#37ebdd") + "" + ChatColor.BOLD + "l" +
                            ChatColor.of("#2fe9db") + "" + ChatColor.BOLD + "l" +
                            ChatColor.of("#27e7d9") + "" + ChatColor.BOLD + "s";
            meta.setDisplayName(colorHex);
            snowball.setItemMeta(meta);
        }

        if (randomNumber == 1) {
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), snowball);
        }
    }
}
