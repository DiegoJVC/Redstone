package com.cobelpvp.redstone.server;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class ServerData {

    private Server server;
    private int onlinePlayers, maxPlayers;
    private double tps;
    private Set<UUID> whitelistedPlayers;
    private ServerState state;

    public ServerData(Server server) {
        this.server = server;
        this.onlinePlayers = -1;
        this.maxPlayers = -1;
        this.tps = -1;
        this.state = ServerState.ONLINE;
        this.whitelistedPlayers = new HashSet<>();
    }

    public void setState(ServerState state) {
        this.state = state;
    }

    public void setTps(double tps) {
        this.tps = tps;
    }

    public void setOnlinePlayers(int onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Server getServer() {
        return server;
    }

    public int getOnlinePlayers() {
        return onlinePlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public double getTps() {
        return tps;
    }

    public Set<UUID> getWhitelistedPlayers() {
        return whitelistedPlayers;
    }

    public ServerState getState() {
        return state;
    }
}
