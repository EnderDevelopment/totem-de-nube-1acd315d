package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CloudTotem implements Listener {

    private final Main plugin;

    public CloudTotem(Main plugin) {
        this.plugin = plugin;
    }

    public ItemStack createCloudTotem() {
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = totem.getItemMeta();
        meta.setDisplayName("Totem de Nube");
        totem.setItemMeta(meta);
        return totem;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.TOTEM_OF_UNDYING && item.getItemMeta().getDisplayName().equals("Totem de Nube")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 80));
            player.setFallDistance(0);
            item.setAmount(item.getAmount() - 1);
        }
    }
}