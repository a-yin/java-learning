package com.lingb.mystudy.java.day10;

import java.util.concurrent.*;

/**
 * Created by lingb on 2018/7/31
 */
public class ExecutorThread {

    public static void main(String[] args) {
        // 初始化
//        ExecutorService executor = Executors.newFixedThreadPool(1);
        ExecutorService executor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1));

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("第3种多线程实现方式###");
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第3种多线程实现方式---");
            }
        });

        executor.shutdown();
    }
}
