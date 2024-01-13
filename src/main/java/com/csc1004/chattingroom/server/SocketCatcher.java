package com.csc1004.chattingroom.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketCatcher extends Thread {
    ServerSocket serverSocket;
    public boolean is_running = true;
    SocketContainer user_Socket;

    SocketCatcher(SocketContainer socketContainer) throws IOException {
        this.serverSocket = new ServerSocket(9999);
        user_Socket = socketContainer;
    }

    @Override
    public void run() {
        while (is_running) {
            try {
                user_Socket.add(this.serverSocket.accept());
            } catch (IOException e) {
                System.out.println("[ERROR]:IOException at SocketCatcher.java when adding sockets");
            }
        }
    }

    //close ServerSocket
    public void closeServerSocket() throws IOException {
        //close all sockets recursively
        //
        serverSocket.close();
    }
}
