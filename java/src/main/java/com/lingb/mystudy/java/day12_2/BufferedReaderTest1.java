package com.lingb.mystudy.java.day12_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 缓冲流 + 转换流
 *
 * Created by lingb on 2018/8/12
 */
public class BufferedReaderTest1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 读取以空格为结束符的
        String str = sc.next();
        System.out.println(str);

//        while (sc.hasNext()) {
//            String str1 = sc.next();
//            System.out.println(str);
//        }

        // 输入转换流(字节-->字符)
//        InputStreamReader is = new InputStreamReader(System.in);
//        BufferedReader bf = new BufferedReader(is);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        // 读取整行
        String str1 = bf.readLine();
        bf.close();
        System.out.println(str1);
    }


}
