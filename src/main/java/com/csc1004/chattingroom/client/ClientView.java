package com.csc1004.chattingroom.client;

import com.csc1004.chattingroom.toolstruct.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientView implements Runnable{
    private Socket socket;
    private final String user;
    private boolean is_running = true;
    ClientView(String user){
        this.user = user;
    }

    public void showClientView() throws IOException {
        try {
            this.socket = new Socket(InetAddress.getLocalHost(),9999);
        } catch (IOException e) {
            System.out.println("Connection failed. Host not found.");
            return;
        }
        Scanner scn = new Scanner(System.in);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//        Thread thread = new Thread(this);
//        thread.start();
        oos.writeObject(new Message("Has connected",user,false));
        while(is_running){
            String content = scn.nextLine();
            Message msg = new Message(content,user,content.charAt(0)=='#');
            oos.writeObject(msg);
        }
    }

    @Override
    public void run(){
        while(is_running){

        }
    }
}
