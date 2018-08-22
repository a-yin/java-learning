package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.*;

/**
 * 文件复制：字符流CharStream
 *
 * Created by lingb on 2018/8/12
 */
public class FileCopyTest1 {


    File file = new File("G:/DevWorkSpace/IDEA/mystudy/hello.txt");
    File file3 = new File("G:/DevWorkSpace/IDEA/mystudy/hello3.txt");

    @Test
    public void test() throws IOException {
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file3);

        // 容器，简单理解成-> 袋子
        char[] chars = new char[512];
        // 袋子1次装的个数
        int temp;
        while ((temp = fr.read(chars)) != -1) {
            fw.write(chars, 0, temp);
        }
        fw.flush();

        fr.close();
        fw.close();

    }

}
