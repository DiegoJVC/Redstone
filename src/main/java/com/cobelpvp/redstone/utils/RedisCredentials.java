package com.cobelpvp.redstone.utils;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RedisCredentials {

    private String ip, password;
    private int port;

    public RedisCredentials(String ip, String password, int port) {
        this.ip = ip;
        this.password = password;
        this.port = port;
    }

    public boolean isAuth(){
        return password != null;
    }

    public String getIp() {
        return ip;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }
}

