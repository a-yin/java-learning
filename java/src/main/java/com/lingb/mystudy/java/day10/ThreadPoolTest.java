package com.lingb.mystudy.java.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lingb on 2018-11-29
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
           executorService.submit(new Runnable() {
               @Override
               public void run() {
                   lists.add(random.nextInt());
               }
           });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("时间 " + (System.currentTimeMillis() - start));
        System.out.println("size " + lists.size());
    }


}
