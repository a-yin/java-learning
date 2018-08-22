package com.lingb.mystudy.java.day12_2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 字符输入缓冲流：带有缓冲区
 *
 * Created by lingb on 2018/8/12
 */
public class BufferedReaderTest {

    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("G:\\DevWorkSpace\\IDEA\\mystudy\\java\\src\\main\\java\\com\\lingb\\mystudy\\java\\day12_2\\BufferedReaderTest.java"));

        String temp;
        while ((temp = br.readLine()) != null) {
            System.out.print(temp);
        }

        br.close();
    }


    @Test
    public void test1() {
        // 测试无法键盘输入？？
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
    }

}
