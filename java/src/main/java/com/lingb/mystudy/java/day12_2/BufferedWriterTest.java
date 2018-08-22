package com.lingb.mystudy.java.day12_2;

import org.junit.Test;

import java.io.*;

/**
 * 字符输出缓冲流：带有缓冲区
 *
 * Created by lingb on 2018/8/12
 */
public class BufferedWriterTest {

    @Test
    public void test() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("G:/DevWorkSpace/IDEA/mystudy/hello1.txt"));
        bw.write("甲鸟");
        bw.flush();
        bw.close();
    }

}
