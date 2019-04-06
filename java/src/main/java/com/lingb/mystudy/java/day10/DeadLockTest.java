package com.lingb.mystudy.java.day10;

/**
 * Java 死锁程序
 *
 * @author lingb
 * @date 2019.03.06 22:33
 */
public class DeadLockTest {

    private static Object lock0 = new Object();
    private static Object lock1 = new Object();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (lock0) {
                    System.out.println("Thread0 got lock0.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("Thread0 got lock1.");
                    }
                }
                System.out.println("Thread0 end.");
            }

        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread1 got lock1.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock0) {
                        System.out.println("Thread1 got lock0.");
                    }
                }
                System.out.println("Thread2 end.");
            }

        }.start();

    }
}
