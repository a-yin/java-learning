package com.lingb.mystudy.java.day11_1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lingb on 2018/7/28
 */
public class AtomicIntegerDemo {
    private static AtomicInteger counter = new AtomicInteger();
    static class Visitor extends Thread {
        @Override
        public void run() {
            // 自增10000次
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10000;
        Thread[] threads = new Thread[num];
        LocalDateTime before = LocalDateTime.now();
        // 10000个线程
        for (int i = 0; i < num; i++) {
            threads[i] = new Visitor();
            threads[i].start();

        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }

        System.out.println("自增结果：" + counter.get());
        LocalDateTime after = LocalDateTime.now();
        System.out.println("时间差(毫秒): " + Duration.between(before, after).toMillis());
    }
}
