package com.csc1004.chattingroom.toolstruct;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SocketThread extends Thread {
    public Socket socket;
    public boolean is_running = true;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream;
        ObjectInputStream ois;
        try {
            inputStream = this.socket.getInputStream();
            ois = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (is_running) {
            try {
                Message message = (Message) ois.readObject();
                //put this message into the wait-for-processing list;
                System.out.println(message);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void close() throws IOException {
        is_running = false;
        socket.close();
    }
}
