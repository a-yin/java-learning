package com.lingb.mystudy.java.day12_4;

import java.io.File;
import java.util.Scanner;

/**
 * 【错误示范】File类、IO类 和 多线程类 的一个小练习
 *
 * @author lingb
 * @date 2019.03.07 00:00
 */
public class FileStatistics {

    /**
     * 输入一个需要统计的路径
     * 输出统计总数（文件 + 文件夹）
     *
     * 要求：
     * 1.当前文件夹也要统计在内
     * 2.若是文件夹时，需要另开一线程统计，若是文件不需要
     * 3.最后统计所有线程的文件+文件夹
     *
     * 思路：
     * 1.
     *
     */

    static class Statistics implements Runnable {

        /** 路径 */
        private String path;

        /** 计数器 */
        private volatile int count;

        public Statistics(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            synchronized (Statistics.class) {
                File file = new File(path);
                File[] files = file.listFiles();
                if (null != files) {
                    for (File f : files) {
                        if (f.isFile()) {
                            add();

                        } else {
                            add();
                            // 死循环！！
                            new Thread() {
                                @Override
                                public void run() {
                                    Statistics.this.run();
                                }

                            }.start();
                        }
                    }

                    System.out.println("该路径下文件+文件夹为" + getCount());
                }

                System.out.println("该路径下文件+文件夹为空");
            }
        }

        private int add() {
            return count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        Statistics s = new Statistics(path);
        Thread t = new Thread(s);
        t.start();
//        System.out.println(s.getCount());
    }
}
