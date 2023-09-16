package com.cobelpvp.redstone.threads;

import com.cobelpvp.redstone.server.ServerState;
import com.cobelpvp.redstone.RedstonePlugin;
import com.cobelpvp.redstone.server.Server;
import com.cobelpvp.redstone.server.ServerHandler;
import redis.clients.jedis.Jedis;
import java.util.Set;

public class FetchThread extends Thread {

    public FetchThread() {
        setName("Redstone-Fetch");
    }

    @Override
    public void run() {
        while (true) {
            ping();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ping(){
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            final Set<String> servers = jedis.keys("Redstone-Server:*");
            for (String loopServer : servers){
                String serverName = loopServer.replaceAll("Redstone-Server:", "");
                Server server = ServerHandler.getServer(serverName);
                if (server == null){
                    server = new Server(serverName);
                    ServerHandler.addServer(server);
                }
                server.setGroup(jedis.hget("Redstone-Server:" + serverName, "Group"));
                server.getData().setState(ServerState.getFromOrdinal(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "State"))));
                server.getData().setTps(Double.valueOf(jedis.hget("Redstone-Server:" + serverName, "TPS")));
                server.getData().setOnlinePlayers(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "OnlinePlayers")));
                server.getData().setMaxPlayers(Integer.valueOf(jedis.hget("Redstone-Server:" + serverName, "MaxPlayers")));
            }
        }
    }
}
