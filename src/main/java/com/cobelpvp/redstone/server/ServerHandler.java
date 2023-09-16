package com.cobelpvp.redstone.server;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler {

    @Getter static List<Server> servers = new ArrayList<>();

    public static void addServer(Server server){
        servers.add(server);
    }

    public static void removeServer(Server server){
        servers.remove(server);
    }

    public static Server getServer(String serverID){
        for (Server server : servers) {
            if (server.getServerID().equalsIgnoreCase(serverID)) {
                return server;
            }
        }
        return null;
    }

    public static List<Server> getServersFromGroup(String serverGroup) {
        List<Server> cachedServers = new ArrayList<>();
        for (Server server : servers) {
            if (server.getGroup().equalsIgnoreCase(serverGroup)){
                cachedServers.add(server);
            }
        }
        return cachedServers;
    }

    public static List<String> getServerGroups() {
        List<String> cachedGroups = new ArrayList<>();
        for (Server server : servers) {
            if (!cachedGroups.contains(server.getGroup())) {
                cachedGroups.add(server.getGroup());
            }
        }
        return cachedGroups;
    }

}
