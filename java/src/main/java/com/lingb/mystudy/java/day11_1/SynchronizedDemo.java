package com.lingb.mystudy.java.day11_1;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by lingb on 2018/7/28
 */
public class SynchronizedDemo {

    static class Counter {
        private int count;
        public synchronized void incr() {
            count++;
        }
        public synchronized int get() {
            return count;
        }
    }

    static class SubThread extends Thread {
        private Counter counter;
        private SubThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            // 自增10000次
            for (int i = 0; i < 10000; i++) {
                counter.incr();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int num = 10000;
        Thread[] threads = new Thread[num];
        LocalDateTime before = LocalDateTime.now();

        // 10000个线程
        for (int i = 0; i < num; i++) {
            threads[i] = new SubThread(counter);
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
