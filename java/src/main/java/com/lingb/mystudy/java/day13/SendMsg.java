package com.lingb.mystudy.java.day13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lingb on 2018/8/17
 */
public class SendMsg extends Thread {

    private Socket socket;
    private String username;

    public SendMsg(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            while (true) {
                String message = username + ":" + sc.nextLine();
                pw.println(message);
                System.out.println(message);

                if (message.endsWith("bye")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
