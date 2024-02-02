package com.csc1004.chattingroom.client;

import com.csc1004.chattingroom.toolstruct.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientManager {

    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        System.out.println("客户端 socket 返回：" + socket.getClass());
//        OutputStream outputStream = socket.getOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//        oos.writeObject(new Message("HasAdded", "ADMIN", false));
//        oos.writeObject(new Message("Hello, Server", "ADMIN", false));
//        oos.writeObject(new Message("Hello, Server", "ADMIN", false));
//        oos.writeObject(new Message("#recall","ADMIN",true));
//        oos.writeObject(new Message("#exit","ADMIN",true));
//        while(true){
//
//        }
        ClientView clientView = new ClientView(new ClientMenu().showMainMenu());

    }
}
