package com.lingb.mystudy.java.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by lingb on 2018/8/17
 */
public class ReceiveMsg extends Thread {

    private Socket socket;

    public ReceiveMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String message = bf.readLine();
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
