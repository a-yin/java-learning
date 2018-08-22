package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream 文件字节输入流，将文件上的内容读入到内存
 *
 * Created by lingb on 2018/8/4
 */
public class FileInputStreamTest {

//    File file = new File("G:/DevWorkSpace/IDEA/mystudy/hello.txt");
    File file = new File("G:\\DevWorkSpace\\IDEA\\mystudy\\java\\src\\main\\java\\com\\lingb\\mystudy\\java\\day12_1\\FileInputStreamTest.java");

    @Test
    public void test() {

        try {
            FileInputStream fis = new FileInputStream(file);
            int i = fis.read();
            int i1 = fis.read();
            int i2 = fis.read();
            int i3 = fis.read();
            int i4 = fis.read();
            int i5 = fis.read();
            System.out.print((char)i);
            System.out.print((char)i1);
            System.out.print((char)i2);
            System.out.print((char)i3);
            System.out.print((char)i4);
            System.out.print(i5);
            System.out.println();


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        try {
            // 准备一个每次能装1024个字节(1kb)的容器【数组】
            // 容器，简单理解成-> 袋子
            int num = 1024;
            // 袋子1次装的个数
            int temp;
//            int temp = fileInputStream.read();
//            System.out.println((char)temp);
            byte[] bytes = new byte[num];
            // 用循环读
            while ((temp = fis.read(bytes)) != -1) {
                System.out.println(temp);
                System.out.println(new String(bytes, 0, temp, "UTF-8"));
            }

        } finally {
            fis.close();
        }
    }


}
