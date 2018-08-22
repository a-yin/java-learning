package com.lingb.mystudy.java.day13;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lingb on 2018/8/17
 */
public class MyClient1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 2345);
        SendMsg sendMsg = new SendMsg(socket, "Client");
        ReceiveMsg receiveMsg = new ReceiveMsg(socket);

        sendMsg.start();
        receiveMsg.start();
    }
}
