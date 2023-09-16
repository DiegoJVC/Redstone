package com.cobelpvp.redstone.threads;

import com.cobelpvp.redstone.RedstonePlugin;
import com.cobelpvp.redstone.RedstonePluginSettings;
import com.cobelpvp.redstone.server.ServerState;
import com.cobelpvp.redstone.utils.TPSUtility;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class PayloadThread extends Thread {

    //TODO maybe put this in a commons class when you clean everything up
    private DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public PayloadThread() {
        setName("Redstone-Payload");
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

    private void ping() {
        try(Jedis jedis = RedstonePlugin.getRedisHelper().getPool().getResource()){
            Map<String, String> data = new HashMap<>();
            data.put("OnlinePlayers", Bukkit.getOnlinePlayers().size() + "");
            data.put("MaxPlayers", Bukkit.getMaxPlayers() + "");
            data.put("State", ServerState.getCurrent().getOrdinal() + "");
            data.put("Group", RedstonePluginSettings.SERVER_GROUP);
            //TODO later see if this works
            data.put("TPS", decimalFormat.format(TPSUtility.getRecentTps()[0]));

            jedis.hmset("Redstone-Server:" + RedstonePluginSettings.SERVER_NAME, data);
        }
    }
}
