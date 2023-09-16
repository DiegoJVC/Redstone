package com.cobelpvp.redstone.server;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Server {

    private String group;
    private String serverID;
    private ServerData data;

    public Server(String serverID){
        this.serverID = serverID;
        this.data = new ServerData(this);
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public String getGroup() {
        return group;
    }

    public String getServerID() {
        return serverID;
    }

    public ServerData getData() {
        return data;
    }
}
