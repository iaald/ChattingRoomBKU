package com.csc1004.chattingroom.toolstruct;

import com.csc1004.chattingroom.server.SocketContainer;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread {
    public Socket socket;
    public boolean is_running = true;
    SocketContainer socketContainer;
    InputStream inputStream;
    OutputStream outputStream;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public String user;
    public SocketThread(Socket socket, SocketContainer sktc) {
        this.socket = socket;
        this.socketContainer = sktc;
    }

    @Override
    public void run() {
        try {
            outputStream = this.socket.getOutputStream();
            inputStream = this.socket.getInputStream();
            ois = new ObjectInputStream(inputStream);
            oos = new ObjectOutputStream(outputStream);
            Message message0 = (Message) ois.readObject();
            user = message0.sender;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (is_running) {
            try {
                Message message = (Message) ois.readObject();
                //put this message into the wait-for-processing list;
                System.out.println(message);
                if (!message.is_command) {
                    this.socketContainer.sendToAll(message);
                    continue;
                }
                this.execute(message.content);
            } catch (IOException | ClassNotFoundException ignored) {
            }
        }
        askForQuit();
    }

    public <T> void send(T msg){
        try {
            this.oos.writeObject(msg);
        } catch (IOException e) {
            System.out.println("[ERROR] in sending ["+ msg.getClass() +"], socket does not exist");
            this.is_running = false;
        }
    }

    void askForQuit() {
        send(socketContainer.getStore());
        send(new Message("#ex","Server",true));
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        socketContainer.delete(this);
    }

    void execute(String cmd) {
        if (cmd.equals("#exit")) {
            this.is_running = false;
        } else if (cmd.equals("#recall")) {
            socketContainer.recall(this);
        }
    }

}
