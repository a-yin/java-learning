package com.lingb.mystudy.java.day13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lingb on 2018/8/17
 */
public class MyServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(2345);
        Socket socket = ss.accept();

        SendMsg sendMsg = new SendMsg(socket, "Server");
        ReceiveMsg receiveMsg = new ReceiveMsg(socket);

        sendMsg.start();
        receiveMsg.start();

    }
}
