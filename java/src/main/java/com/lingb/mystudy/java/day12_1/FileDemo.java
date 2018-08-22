package com.lingb.mystudy.java.day12_1;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * File类 文件和目录路径名的抽象表示形式（既可以表示文件，也可以表示目录），与平台、IO流无关
 *
 * Created by lingb on 2018/8/4
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

        // 创建File实例对象
        File file = new File("hello1.txt");

        /**
         * 文件元数据：
             getName()
             getPath()
             getAbsoluteFile()
             getAbsolutePath()
             getParent()
         */
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

        /**
         * 文件检测:
             exists()
             canWrite()
             canRead()
             isFile()
             isDirectory()
         */
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        /**
         * 获取常规文件信息:
         lastModified()
         length()
         */
        Instant instant = Instant.ofEpochMilli(file.lastModified());
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime lastModified = LocalDateTime.ofInstant(instant, zone);

        // 一个ASCII码一个字节Byte，一个中文两个字节Byte
        System.out.println(file.length());


        /**
         * 文件操作相关：
         createNewFile()
         delete()
         renameTo(File newName)
         */
        if (!file.exists()) {
            file.createNewFile();
        }
        file.delete();

        /**
         * 目录操作相关:
             mkDir()
             mkDirs()
             list()
             listFiles()
         */
        System.out.println(file.list());
        System.out.println(file.listFiles());

        if (file.isFile()) {
            System.out.println(file);
        }
    }
}
