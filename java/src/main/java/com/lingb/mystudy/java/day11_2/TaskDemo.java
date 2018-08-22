package com.lingb.mystudy.java.day11_2;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lingb on 2018/7/30
 */
public class TaskDemo {

    public TaskDemo() {}

    public TaskDemo(String str) {
        System.out.println(str);
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            System.out.println(sleepSeconds);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException, IllegalAccessException, InstantiationException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Task());
        // 模拟其他线程
        Thread.sleep(1000);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        TaskDemo td1 = new TaskDemo("str");
        System.out.println(td1);

//        Class<TaskDemo> cla = TaskDemo.class;
//        TaskDemo td = new TaskDemo();
//        System.out.println(td);
//        td = cla.newInstance();
//        System.out.println(td);

    }
}
