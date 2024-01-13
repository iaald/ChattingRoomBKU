package com.csc1004.chattingroom.server;

import java.io.IOException;

public class ServerManager {

    public void ServerManagerMain(String[] args) throws IOException {
        SocketContainer socketContainer = new SocketContainer(this);
        SocketCatcher socketCatcher = new SocketCatcher(socketContainer);
        socketCatcher.start();
    }

}
