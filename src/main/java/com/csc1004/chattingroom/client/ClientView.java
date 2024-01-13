package com.csc1004.chattingroom.client;

import com.csc1004.chattingroom.toolstruct.*;

public class ClientView {
    String user;
    ClientView(String user){
        this.user = user;
    }
    public void ClientViewMain(){
        ClientManager clientManager = new ClientManager(this);
    }
    public void showClientView(){

    }
}
