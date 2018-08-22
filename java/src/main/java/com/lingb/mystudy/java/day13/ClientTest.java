package com.lingb.mystudy.java.day13;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 *
 * Created by lingb on 2018/8/17
 */
public class ClientTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8989);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os,  true);
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));

        Scanner sc = new Scanner(System.in);

        while (true) {

            // 发送
            String writeStr = sc.nextLine();
            pw.println("Client: " + writeStr);
            System.out.println("Client: " + writeStr);

            // 接收
            String readStr = bf.readLine();
            System.out.println(readStr);
            // 停止
            if (readStr.endsWith("bye") || writeStr.endsWith("bye")) {
                break;
            }
        }
    }
}
