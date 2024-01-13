package com.csc1004.chattingroom.server;

import com.csc1004.chattingroom.toolstruct.SocketThread;

import java.net.Socket;
import java.util.ArrayList;

public class SocketContainer {
    int connect_num = 0;
    ArrayList<SocketThread> socketContainer;
    ServerManager serverManager;

    public SocketContainer(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    //    create a socket thread and add it to the socket container;
    public void add(Socket new_socket) {
        connect_num += 1;
        SocketThread temp = new SocketThread(new_socket);
        socketContainer.add(temp);
        temp.start();
    }
    public void delete(){

    }
}
