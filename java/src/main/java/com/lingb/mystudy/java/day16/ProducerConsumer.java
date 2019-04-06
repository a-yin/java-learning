package com.lingb.mystudy.java.day16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 生产者、消费者
 *
 * @author lingb
 * @date 2019.03.19 17:03
 */
public class ProducerConsumer {

    /** 队列缓冲区，数据为 Integer */
    private static Queue<Integer> queue = new LinkedList<>();

    /** 缓冲区最大容量 */
    private static final int MAX_SIZE = 100;


    /**
     * 生产者：V操作（资源增加）
     */
    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    // 如果缓冲区还没达到最大容量，则生产一个产品（n个也行）放入缓冲区，并唤醒其它所有线程
                    if (queue.size() < MAX_SIZE) {
                        int num = new Random().nextInt(100);
                        queue.offer(num);
                        queue.notifyAll();
                        System.out.println("生产者" + Thread.currentThread().getName() +
                                "生产了产品：" + num + "，此时缓冲区数据容量为：" + queue.size());

                    // 反之已是最大容量，使自己进入缓冲区的等待池（放弃锁 + CPU）
                    } else {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }

    /**
     * 消费者：P操作（资源减少）
     */
    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    // 如果缓冲区有数据，则从缓冲区取出一个产品（n个也行），并唤醒所有线程
                    if (queue.size() > 0) {
                        int num = queue.poll();
                        queue.notifyAll();
                        System.out.println("消费者" + Thread.currentThread().getName() +
                                "消费了产品：" + num + "，此时缓冲区数据量为：" + queue.size());

                    // 反之没有数据，使自己进入缓冲区的等待池
                    } else {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        // 一个 生产者， 一个消费者
        Producer p = new Producer();
        Consumer c = new Consumer();

        new Thread(c).start();
        new Thread(p).start();

    }

}
