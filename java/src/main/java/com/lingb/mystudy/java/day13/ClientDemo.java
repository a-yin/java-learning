package com.lingb.mystudy.java.day13;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 模拟客户端
 *
 * Created by lingb on 2018/8/17
 */
public class ClientDemo {

    /**
     * 1、创建指定IP、port的客户端对象socket 进行访问通信
     * 2、通过对象socket获取IO流
     * 3、IO流发送接收消息
     * 4、关闭socket及相关资源
     *
     */

    public static void main(String[] args) throws IOException {

        // 创建客户端对象
        //Socket socket = new Socket("192.168.4.2", 8888);
        //Socket socket = new Socket("localhost", 8888); //localhost表示本机IP

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os,true);
        // 转换流：字节流->字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        Scanner input = new Scanner(System.in);

        while (true) {
            // 发送
            String info = input.nextLine();
            pw.println("客户端说："+info);
            System.out.println("客户端说："+info);
            // 接收
            String info1 = br.readLine();
            System.out.println(info1);

        if(info1.endsWith("bye")||info.endsWith("bye")){
                break;
            }

        }
    }

}
