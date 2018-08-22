package com.lingb.mystudy.java.day12_1;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * FileOutputStream 文件字节输出流，将内存的内容写出到文件上
 *
 * Created by lingb on 2018/8/5
 */
public class FileOutStreamTest {

    File file = new File("G:/DevWorkSpace/IDEA/mystudy/hello1.txt");

    @Test
    public void test() throws IOException {
        FileOutputStream fos = new FileOutputStream(file, true);
        String str = "hello1, 123, 甲鸟";
        byte[] bytes = str.getBytes();
        fos.flush();
        fos.write(bytes);
        fos.close();
        Instant instant = Instant.ofEpochMilli(file.lastModified());
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime lastModified = LocalDateTime.ofInstant(instant, zone);
        System.out.println(lastModified);
    }

}
