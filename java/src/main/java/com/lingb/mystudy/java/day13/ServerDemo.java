package com.lingb.mystudy.java.day13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 模拟服务端
 *
 * Created by lingb on 2018/8/17
 */
public class ServerDemo {

    /**
     * 1、创建指定port的服务器对象serverSocket
     * 2、开启对象serverSocket 进行监听（即调用accept()方法），获取客户端创建的socket对象（保证客户端和服务器同一socket对象）
     * 3、通过socket对象获取IO流
     * 4、IO流发送接收消息
     * 5、关闭socket和相关资源
     *
     */

    public static void main(String[] args) throws IOException {

        // 创建服务器对象
        ServerSocket ss = new ServerSocket(8888);
        // 开启服务器监听
        // 调用accept()方法，服务器端就会进入阻塞状态，等待客户端连接
        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        PrintWriter pw = new PrintWriter(os,true);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        Scanner input = new Scanner(System.in);

        while(true){
            // 接收
            String info = br.readLine();
            System.out.println(info);

            // 发送
            String info1 = input.nextLine();
            pw.println("服务器说："+info1);
            System.out.println("服务器说："+info1);
            if(info1.endsWith("bye")||info.endsWith("bye")){
                break;
            }


        }

    }
}
