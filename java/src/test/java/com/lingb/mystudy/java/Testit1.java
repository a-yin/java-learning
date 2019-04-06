package com.lingb.mystudy.java;

/**
 * Created by lingb on 2018-12-14
 */
public class Testit1 {


    public void method1() throws InterruptedException {
        System.out.println("1");
        synchronized(this) {  // this 当前对象

        }
        Thread.sleep(5000);
    }

    public static synchronized void method2() {
        System.out.println("2");
    }

    public static void main(String[] args) throws InterruptedException {
        Testit1 o = new Testit1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                o.method2();
            }
        }).start();

    }
}
