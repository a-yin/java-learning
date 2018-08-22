package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader 文件字符输入流
 *
 * Created by lingb on 2018/8/12
 */
public class FileReaderTest {

    @Test
    public void test() throws IOException {
        FileReader fr = new FileReader("G:/DevWorkSpace/IDEA/mystudy/hello.txt");

        // 1kB
        // 1char = 2byte
        char[] chars = new char[512];
        int temp;
        while ((temp = fr.read(chars)) != -1) {
            System.out.println(temp);
            System.out.println(new String(chars, 0, temp));
        }

        fr.close();
    }

}
