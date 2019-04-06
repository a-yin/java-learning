package com.lingb.mystudy.java.day12_4;

import java.io.File;
import java.util.Scanner;

/**
 * File类、IO类 和 多线程类 的一个小练习
 *
 * @author lingb
 * @date 2019.03.18 09:34
 */
public class FileStatistics1 {

    /**
     * 输入一个需要统计的路径
     * 输出统计总数（文件 + 文件夹）
     *
     * 要求：
     * 1.当前文件夹也要统计在内
     * 2.若是文件夹时，需要另开一线程统计，若是文件不需要
     * 3.最后统计所有线程的文件+文件夹
     *
     * 思路如下
     *
     */
    private static int result;

    public static int count(String path) {
        if (path == null || path.equals("")) {
            return result;
        }

        File file = new File(path);
        if (file.exists()) {
            result++;
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    result++;

                } else {
                    new Thread(() -> {
                        count(f.getAbsolutePath());
                    }).start();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        System.out.println(count(path));
    }
}
