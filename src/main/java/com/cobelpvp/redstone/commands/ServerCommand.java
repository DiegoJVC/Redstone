package com.cobelpvp.redstone.commands;

import com.cobelpvp.atheneum.util.ColorText;
import com.cobelpvp.redstone.server.Server;
import com.cobelpvp.redstone.server.ServerHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ServerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ColorText.translate("&7&m--------&r  &6&l&nServers&r  &7&m--------"));
        commandSender.sendMessage("");
        for (String serverGroup : ServerHandler.getServerGroups()){
            commandSender.sendMessage(ColorText.translate("&f&l" + serverGroup + " Servers"));
            for (Server server : ServerHandler.getServersFromGroup(serverGroup)) {
                commandSender.sendMessage(ColorText.translate("&f* &a&l" + server.getServerID() + " &7(&f" + server.getData().getOnlinePlayers() + "&7/&f" + server.getData().getMaxPlayers() + "&7) &e" + server.getData().getTps() + "TPS &7- &e" + server.getData().getState()));
            }
            commandSender.sendMessage("");
        }
        commandSender.sendMessage(ColorText.translate("&7&m---------------------------"));
        return false;
    }

}
