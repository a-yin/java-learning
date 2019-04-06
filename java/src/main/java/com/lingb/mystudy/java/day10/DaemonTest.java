package com.lingb.mystudy.java.day10;

/**
 * 主线程、非守护线程（用户线程）、守护线程（后台线程）
 *
 * @author lingb
 * @date 2019.03.20 22:16
 */
public class DaemonTest {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程 " + i);
        }

        // 创建非守护线程（用户线程）
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("非守护线程 " + i);
            }

            System.out.println("非守护线程 end");
        });

        // 非守护线程 -> 守护线程
        t.setDaemon(true);
        t.start();

        System.out.println("主线程 end");

    }
}
