package com.csc1004.chattingroom.server;

import com.csc1004.chattingroom.toolstruct.Message;
import com.csc1004.chattingroom.toolstruct.SocketThread;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SocketContainer {
    int connect_num = 0;
    ArrayList<SocketThread> socketContainer;
    ServerManager serverManager;
    SocketCatcher socketCatcher;

    public SocketContainer(ServerManager serverManager) {
        this.serverManager = serverManager;
        this.socketContainer = new ArrayList<>();
    }

    public void initialize() throws IOException {
        socketCatcher = new SocketCatcher(this);
        socketCatcher.start();
    }

    //    create a socket thread and add it to the socket container;
    public void add(Socket new_socket, SocketContainer sktc) {
        connect_num += 1;
        SocketThread temp = new SocketThread(new_socket, sktc);
        socketContainer.add(temp);
        temp.start();
    }

    public void delete(SocketThread skt_toDelete) {
        socketContainer.remove(skt_toDelete);
    }

    public void sendToAll(Message mes) {
        socketContainer.forEach(sktt -> {
            sktt.send(mes);
        });
        serverManager.store(mes);
    }

    public void recall(SocketThread sktt) {
        serverManager.recall(sktt.user);
        flush();
    }

    void flush() {
        sendToAll(new Message("#cls", "Server", true));
        serverManager.getStore().forEach(this::sendToAll);
    }
}
