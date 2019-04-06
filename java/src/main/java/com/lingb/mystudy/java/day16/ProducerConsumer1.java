package com.lingb.mystudy.java.day16;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ProducerConsumer1 利用java.util.concurrent.BlockingQueue
 *
 * @author lingb
 * @date 2019.03.19 17:30
 */
public class ProducerConsumer1 {

    /** 缓冲区最大容量 */
    private static final int MAX_SIZE = 100;

    /**
     * 生产者：V操作（资源增加）
     */
    static class Producer extends Thread {
        private BlockingQueue<Integer> blockingQueue;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                int num = new Random().nextInt(100);
                try {
                    blockingQueue.put(num);
                    System.out.println("生产者" + Thread.currentThread().getName() +
                            "生产了产品：" + num + "，此时缓冲区数据量为：" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 消费者：P操作（资源减少）
     */
    static class Consumer extends Thread {

        private BlockingQueue<Integer> blockingQueue;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    final Integer num = blockingQueue.take();
                    System.out.println("消费者" + Thread.currentThread().getName() +
                            "消费了产品：" + num + "，此时缓冲区数据量为：" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(MAX_SIZE);

        final Producer producer = new Producer(queue);
        final Producer producer1 = new Producer(queue);

        final Consumer consumer = new Consumer(queue);
        final Consumer consumer1 = new Consumer(queue);

        producer.start();
        producer1.start();

        consumer.start();
        consumer1.start();
    }
}
