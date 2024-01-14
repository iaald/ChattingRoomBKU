package com.csc1004.chattingroom.server;

import java.io.IOException;

public class ServerManager {

    public void ServerManagerMain() throws IOException {
        SocketContainer socketContainer = new SocketContainer(this);
        socketContainer.initialize();
    }

    public static void main(String[] args) throws IOException {
        ServerManager serverManager = new ServerManager();
        serverManager.ServerManagerMain();
    }

}
