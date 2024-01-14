package com.csc1004.chattingroom.toolstruct;

import com.csc1004.chattingroom.server.SocketContainer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread extends Thread {
    public Socket socket;
    public boolean is_running = true;
    SocketContainer socketContainer;

    public void setSocketContainer(SocketContainer socketContainer) {
        this.socketContainer = socketContainer;
    }

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream;
        OutputStream outputStream;
        ObjectInputStream ois;
        try {
            outputStream = this.socket.getOutputStream();
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
            } catch (IOException | ClassNotFoundException ignored) {

            }
        }
    }

    void askForQuit(SocketThread st_toDelete) throws IOException {
        is_running = false;
        socket.close();
        socketContainer.delete(this);
    }

}
