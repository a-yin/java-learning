package com.lingb.mystudy.datastructure;

import org.junit.Test;

/**
 * Created by lingb on 2018-12-10
 */
public class MyCircleQueue<T> {

    private Object[] arr;
    private int front;
    private int end;
    private int size;

    public MyCircleQueue() {
        arr = new Object[5];
        front = 0;
        end = 0;
        size = 0;
    }

//    public MyCircleQueue(int initSize) {
//        arr = new Object[initSize];
//        front = 0;
//        end = 0;
//        size = 0;
//    }

    public boolean add(T val) {
        if (size == arr.length) {
            throw new RuntimeException("The queue is full.");
        }

        end = end == arr.length ? 0 : end;
        size++;
        arr[end++] = val;
        return true;
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("The queue is empty.");
        }

        front = front == arr.length ? 0 : front;
        size--;
        return (T) arr[front++];
    }


    public T peek() {
        if (size == 0) {
            throw new RuntimeException("The circleQueue is empty.");
        }
        return (T) arr[front];
    }

    @Test
    public void test() {
        MyCircleQueue<Integer> circleQueue = new MyCircleQueue<>();
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(4);
        System.out.println(circleQueue.poll());
        System.out.println(circleQueue.poll());
        System.out.println(circleQueue.poll());
        circleQueue.add(5);
        circleQueue.add(6);
        circleQueue.add(7);

        System.out.println(circleQueue.poll());
        System.out.println(circleQueue.poll());
        System.out.println(circleQueue.poll());
        System.out.println(circleQueue.poll());
    }
}

