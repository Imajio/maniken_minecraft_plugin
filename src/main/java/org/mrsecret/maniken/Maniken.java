package org.mrsecret.maniken;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

public final class Maniken extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled!");
        Bukkit.getPluginManager().registerEvents(this, this);
        getCommand("changehead").setExecutor(new SetSkinCommand());
        createSteveHeadRecipe();
    }

    private void createSteveHeadRecipe() {
        ItemStack steveHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) steveHead.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Mannequin");
        steveHead.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "mannequin_head");
        ShapedRecipe recipe = new ShapedRecipe(key, steveHead);
        recipe.shape("LLL", "LPL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('P', Material.OAK_PLANKS);

        Bukkit.addRecipe(recipe);
    }

    public class SetSkinCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length > 0) {
                    String playerName = args[0];
                    // Logic to set skin on the player's head
                    player.sendMessage(ChatColor.GREEN + "Skin set for " + playerName);
                } else {
                    player.sendMessage(ChatColor.RED + "Please specify a player name.");
                }
                return true;
            }
            return false;
        }
    }
}