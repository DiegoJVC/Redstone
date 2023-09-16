package com.cobelpvp.redstone.commands;

import com.cobelpvp.redstone.RedstonePluginSettings;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnviromentCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Redstone Enviroment Dump");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GOLD + "Name: " + ChatColor.WHITE + RedstonePluginSettings.SERVER_NAME);
        sender.sendMessage(ChatColor.GOLD + "Group: " + ChatColor.WHITE + RedstonePluginSettings.SERVER_GROUP);
        return false;
    }
}
