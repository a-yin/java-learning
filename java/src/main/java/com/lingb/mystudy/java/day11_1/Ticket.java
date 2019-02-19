package com.lingb.mystudy.java.day11_1;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程模拟多用户并发购票
 *
 *
 * Created by lingb on 2018-11-28
 */
public class Ticket {

    /**
     * 倒计时器
     */
    private static CountDownLatch cdl = new CountDownLatch(1);

    /**
     * 初始化库存量
     */
    private Integer stock = 8;

    public void reduce(int num) {
        // 判断可用库存
        if ((stock - num) >= 0) {
            // 为了更好体现线程间的竞争，让线程等待
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stock -= num;
            System.out.println(Thread.currentThread().getName()
                    + "成功：卖出" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        } else {
            System.err.println(Thread.currentThread().getName()
                    + "失败：库存不足" + String.valueOf(num) + "张，库存剩余" + stock + "张");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket();
        // 开启10个线程，模拟10个用户购买电影票
        for (int i = 0; i < 10; i++) {
            new Thread(() -> ticket.reduce(1), "用户" + (i + 1)).start();
            Thread.sleep(1000);
            cdl.countDown();
        }
    }
}
