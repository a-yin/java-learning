package com.lingb.mystudy.java.day12_2;

import org.junit.Test;

import java.io.*;

/**
 * Created by lingb on 2018/8/12
 */
public class BufferedCopyTest {


    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("G:\\DevWorkSpace\\IDEA\\mystudy\\java\\src\\main\\java\\com\\lingb\\mystudy\\java\\day12_2\\BufferedCopyTest.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("G:/DevWorkSpace/IDEA/mystudy/hello4.txt"));

        String temp;
        while ((temp = br.readLine()) != null) {
            bw.write(temp);
            // 换行
            bw.newLine();
            System.out.println(temp);
        }

        bw.flush();
        br.close();
        bw.close();
    }

}

