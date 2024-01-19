package com.csc1004.chattingroom.server;

import com.csc1004.chattingroom.toolstruct.Message;

import java.io.IOException;
import java.util.ArrayList;

public class ServerManager {
    ArrayList<Message> storage;

    public void ServerManagerMain() throws IOException {
        storage = new ArrayList<>();
        SocketContainer socketContainer = new SocketContainer(this);
        socketContainer.initialize();
    }

    public void store(Message msg) {
        storage.add(msg);
    }

    public synchronized void recall(String user) {
        int a = storage.size();
        for (int i = a - 1; i >= 0; i--) {
            if (storage.get(i).sender.equals(user)) {
                storage.remove(i);
            }
        }
    }

    public ArrayList<Message> getStore() {
        return this.storage;
    }

    public static void main(String[] args) throws IOException {
        ServerManager serverManager = new ServerManager();
        serverManager.ServerManagerMain();
    }

}
