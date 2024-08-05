package org.mrsecret.maniken;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SetSkinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                if (itemInHand.getType() == Material.PLAYER_HEAD) {
                    SkullMeta meta = (SkullMeta) itemInHand.getItemMeta();
                    meta.setOwner(args[0]);
                    itemInHand.setItemMeta(meta);
                    player.sendMessage(ChatColor.GREEN + "Skin changed to " + args[0]);
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "You must hold a Player Head.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Usage: /changehead <playername>");
            }
        }
        return false;
    }
}