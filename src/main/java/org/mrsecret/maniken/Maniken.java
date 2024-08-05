package org.mrsecret.maniken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Maniken extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("I've been started");
        Bukkit.getPluginManager().registerEvents(this, this);
        createSteveHeadRecipe();
        getCommand("setskin").setExecutor(new SetSkinCommand());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.BLUE + "Hello " + event.getPlayer().getName() + " !");
    }

    private void createSteveHeadRecipe() {
        ItemStack steveHead = new ItemStack(Material.PLAYER_HEAD, 1);
        steveHead.getItemMeta().setDisplayName(ChatColor.GOLD + "Mannequin");

        ShapedRecipe recipe = new ShapedRecipe(steveHead);
        recipe.shape("LLL", "LHL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('H', Material.OAK_PLANKS);

        Bukkit.addRecipe(recipe);
    }
}