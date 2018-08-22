package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter 文件字符输出流
 *
 * Created by lingb on 2018/8/12
 */
public class FileWriterTest {

    @Test
    public void test() throws IOException {
        FileWriter fw = new FileWriter("G:/DevWorkSpace/IDEA/mystudy/hello3.txt");

        String str = "hello, 321, 甲鸟。。。";
        // 类型推断
        char[] chars = {'h', 'e', 'l', 'l', 'o', ',', '甲', '鸟'};
//        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o', ',', '甲', '鸟'};
        fw.write(str);
        fw.write(chars);
        fw.flush();
        fw.close();
    }

}
