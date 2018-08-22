package com.lingb.mystudy.java.day12_3;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream 反序列化流
 *
 * Created by lingb on 2018/8/14
 */
public class ObjectInputStreamTest {
    
    @Test
    public void test() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:/DevWorkSpace/IDEA/mystudy/student.txt"));
        Object o = ois.readObject();
        System.out.println(o);

        ois.close();
    }
}
