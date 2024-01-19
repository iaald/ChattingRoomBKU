package com.csc1004.chattingroom.toolstruct;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    public Message(String content, String sender, boolean is_command) {
        this.content = content;
        this.sender = sender;
        Date time = new Date();
        this.time = time.toString();
        this.is_command = is_command;
    }

    public final String content;
    public final String sender;
    public final String time;
    public final boolean is_command;

    @Override
    public String toString() {
        return (time + " " + sender + ": " + content);
    }
}
