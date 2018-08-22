package com.lingb.mystudy.java.day12_3;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream 数据输出字节流（写出加密）
 *
 * Created by lingb on 2018/8/14
 */
public class DataOutputStreamTest {


    @Test
    public void test() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("encode.txt"));

        // 需要加密的数据
        int a = 1;
        float b = 2.1f;
        double c = 3.33;
        char d = 'd';
        String e = "ee";
        boolean f = true;
        byte g = 14;
        byte h = 'h';

        // 加密
        dos.writeInt(a);
        dos.writeFloat(b);
        dos.writeDouble(c);
        dos.writeChar(d);
        dos.writeChars(e);
        dos.writeBoolean(f);
        dos.writeByte(g);
        dos.writeByte(h);
        dos.writeBytes(e);

        dos.flush();
        dos.close();

    }



}
