package com.lingb.mystudy.java.day12_3;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream 序列化流
 *
 * Created by lingb on 2018/8/14
 */
public class ObjectOutputStreamTest {

    @Test
    public void test() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:/DevWorkSpace/IDEA/mystudy/student.txt"));
        oos.writeObject(new Student("甲鸟"));

        oos.flush();
        oos.close();
    }

}
