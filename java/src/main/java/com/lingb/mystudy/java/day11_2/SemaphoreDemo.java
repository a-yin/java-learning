package com.lingb.mystudy.java.day11_2;

import java.util.concurrent.Semaphore;

/**
 * Semaphore信号量
 *
 * @author lingb
 * @date 2019.03.15 11:17
 */
public class SemaphoreDemo {

    /**
     * 使用 Semaphore 信号量实现流量控制（并发访问次数限制）
     *
     * 分析：Semaphore基于计数的信号量，维护的是一个permit 许可集，
     * new Semaphore(int permits) 设定一个阈值permit，多个线程竞争获取许可，
     * 做完自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞
     * Semaphore 通常用于限制可以访问某些资源（物理或逻辑的）的线程数目。
     *
     */

    private Semaphore semaphore = new Semaphore(10);

    private void flowControl() {
        if (!semaphore.tryAcquire()) {
            return;
        }

        // semaphore.acquire();
        try {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            semaphore.release();
        }
    }


    public static void main(String[ ] args){

        SemaphoreDemo s = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {
            Thread[] threads = new Thread[20];
            for (int j = 0; j < 20; j++) {
                // s::flowControl 等价于 () -> s.flowControl()
                Thread t = new Thread(s::flowControl);
                //Thread t = new Thread(() -> s.flowControl());
                threads[j] = t;
                t.start();
            }

            for (int k = 0; k < 20; k++) {
                try {
                    threads[k].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("---------------------");
        }






      /*  Semaphore semaphore = new Semaphore(2);

        *//**
         *  输出结果 : 23
         *//*

        new Thread(()-> {
            try {
                if (semaphore.tryAcquire(3)) {
                    System.out.print(1);

                } else {
                    System.out.print(2);
                }
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (semaphore.tryAcquire()) {
                System.out.print(3);

            } else {
                System.out.print(4);
            }
        }).start();*/

    }
}
