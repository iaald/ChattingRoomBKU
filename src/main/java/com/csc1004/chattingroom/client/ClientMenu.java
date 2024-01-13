package com.csc1004.chattingroom.client;

import com.csc1004.chattingroom.toolstruct.*;

import java.util.Scanner;

public class ClientMenu {
    private boolean is_running = true;

    /**
     * showMainMenu()
     * Create the main menu and log-in menu.
     */
    public void showMainMenu() {
        while (is_running) {
            System.out.println("\t\t==========WELCOME==========");
            System.out.println("Use command:");
            System.out.println("#login\tto log in.");
            System.out.println("#exit\tto exit the program.");
            Scanner scn = new Scanner(System.in);
            String user_input1 = scn.nextLine();
            //temporary off-line command processor
            if (user_input1.equals("#exit")) {
                is_running = false;
            } else if (user_input1.equals("#login")) {
                System.out.println("\t\t==========WELCOME==========");
                System.out.print("ID: ");
                String user_input2 = scn.nextLine();
                //Go to ClientView page
            } else {
                System.out.println("Invalid instruction.");
            }
        }
    }
}
