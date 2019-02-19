package com.lingb.mystudy.java;

/**
 * Created by lingb on 2018-12-14
 */
public class Testit {

    public static synchronized void method0() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        method1();
    }

    public static synchronized void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Test ss = new Test();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();

    }

    static class Test implements Runnable {

        @Override
        public void run() {
            try {
                method0();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
