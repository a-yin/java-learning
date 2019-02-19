package com.lingb.mystudy.datastructure;

import org.junit.Test;

/**
 * Created by lingb on 2018-12-10
 */
public class MyQueue<T> {

    private Object[] arr;
    private int front;
    private int end;
    private int size;

    public MyQueue() {
        arr = new Object[5];
        front = 0;
        end = 0;
        size = 0;
    }

//    public MyQueue(int initSize) {
//        arr = new Object[initSize];
//        front = 0;
//        end = 0;
//        size = 0;
//    }

    public boolean add(T val) {
        if (size == arr.length) {
            throw new RuntimeException("The queue is full.");
        }

        size++;
        arr[end++] = val;
        return true;
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("The queue is empty.");
        }

        size--;
        return (T) arr[front++];
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("The queue is empty.");
        }
        return (T) arr[front];
    }


    @Test
    public void test() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void test1() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
