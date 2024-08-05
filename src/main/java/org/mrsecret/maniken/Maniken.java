package org.mrsecret.maniken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public final class Maniken extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("I've been started");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(this, this);
        createSteveHeadRecipe();

        if (getCommand("setskin") != null) {
            getCommand("setskin").setExecutor(new SetSkinCommand());
        } else {
            getLogger().severe("Command 'changehead' not found in plugin.yml");
        }
    }

    private void createSteveHeadRecipe() {
        ItemStack steveHead = new ItemStack(Material.PLAYER_HEAD, 1);
        steveHead.getItemMeta().setDisplayName(ChatColor.GOLD + "Mannequin");

        NamespacedKey key = new NamespacedKey(this, "steve_head");
        ShapedRecipe recipe = new ShapedRecipe(key, steveHead);
        recipe.shape("LLL", "LHL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('H', Material.OAK_PLANKS);

        Bukkit.addRecipe(recipe);
    }
}
