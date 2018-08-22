package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制：字节流ByteStream
 *
 * Created by lingb on 2018/8/5
 */
public class FileCopyTest {

    File file = new File("G:/DevWorkSpace/IDEA/mystudy/hello1.txt");
    File file2 = new File("G:/DevWorkSpace/IDEA/mystudy/hello2.txt");

    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2, true);

        try {
            // 准备一个每次能装1024个字节(1kb)的容器【数组】
            int num = 1024;
            int temp;
            byte[] in = new byte[num];
            byte[] out;
            // 边读边写
            while ((temp = fis.read(in)) != -1) {
//                System.out.println(new String(in, 0, in.length, "UTF-8"));
                out = new String(in, 0, in.length, "UTF-8").getBytes();
                fos.write(out);
            }

        } finally {
            fis.close();
            fos.close();

        }
    }

    @Test
    public void test1() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file2);
            // 准备一个每次能装1024个字节(1kb)的容器【数组】
            int num = 1024;
            int temp;
            byte[] bytes = new byte[num];
            // 边读边写
            while ((temp = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, temp);
            }
            // 强制写
            fos.flush();

        } finally {
            fis.close();
            fos.close();

        }
    }
}
