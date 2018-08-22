package com.lingb.mystudy.java.day11_1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lingb on 2018/7/30
 */
public class ReentrantLockDemo {

    static class Counter {
        private final Lock lock = new ReentrantLock();
        private volatile int count;
        public void incr() {
            lock.lock();
            try {
                count++;

            } finally {
                lock.unlock();
            }
        }
        public int getCount() {
            return count;
        }
    }

    static class SubThread extends Thread {
        private SynchronizedDemo.Counter counter;
        private SubThread(SynchronizedDemo.Counter counter) {
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
        SynchronizedDemo.Counter counter = new SynchronizedDemo.Counter();
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
