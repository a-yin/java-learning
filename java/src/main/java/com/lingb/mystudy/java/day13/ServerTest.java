package com.lingb.mystudy.java.day13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lingb on 2018/8/17
 */
public class ServerTest {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8989);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os,  true);

        Scanner sc = new Scanner(System.in);
        while (true) {
            // 接收
            String readStr = bf.readLine();
            System.out.println(readStr);

            // 发送
            String writeStr = sc.nextLine();
            pw.println("Server： " + writeStr);
            System.out.println("Server： " + writeStr);

            // 停止
            if (readStr.endsWith("bye") || writeStr.endsWith("bye")) {
                break;
            }

        }

    }
}
