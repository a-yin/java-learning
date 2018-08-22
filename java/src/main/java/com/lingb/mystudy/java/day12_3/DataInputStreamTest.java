package com.lingb.mystudy.java.day12_3;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataInputStream 数据输入字节流（读入解密）
 *
 * Created by lingb on 2018/8/14
 */
public class DataInputStreamTest {

    @Test
    public void test() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("encode.txt"));
        FileOutputStream fos = new FileOutputStream("decode.txt");

        // 解密
        // String类型 需要1个1个char解密
        System.out.println("解密内容如下：");
        System.out.println(dis.readInt());
        System.out.println(dis.readFloat());
        System.out.println(dis.readDouble());
        System.out.println(dis.readChar());
        // e
        System.out.println(dis.readChar());
        // e
        System.out.println(dis.readChar());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readByte());
        // 104 -> h
        System.out.println(dis.readByte());
        // 101 -> e
        System.out.println((char) dis.readByte());
        // 101 -> e
        System.out.println((char) dis.readByte());


        dis.close();

    }

}
