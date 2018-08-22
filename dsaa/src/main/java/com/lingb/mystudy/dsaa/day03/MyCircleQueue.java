package com.lingb.mystudy.dsaa.day03;

/**
 * 循环队列：先进先出FIFO
 *
 * Created by lingb on 2018/8/22
 */
public class MyCircleQueue {

    /**
     * 底层实现是一个数组
     */
    private int[] arr;

    /**
     * 记录队列有效数据的长度（即数据的个数，计数器）
     */
    private int elements;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int end;

    /**
     * 默认构造方法
     */
    public MyCircleQueue() {
        arr = new int[10];
        elements = 0;
        front = 0;
        // 队尾为空
        end = -1;
    }

    /**
     * 带参数的构造方法
     *
     * @param maxSize
     */
    public MyCircleQueue(int maxSize) {
        arr = new int[maxSize];
        elements = 0;
        front = 0;
        // 队尾为空
        end = -1;
    }

    /**
     * 添加数据，队尾插入
     *
     * @param value
     */
    public void insert(int value) {
        // 队尾指向最后一个数据
        if (end == arr.length - 1) {
            // 初始化，指向为空
            end = -1;
        }
        arr[++end] = value;
        elements++;
    }

    /**
     * 删除数据，队头删除
     */
    public long remove() {
        // 队头指向最后一个数据
        if (front == arr.length) {
            // 初始化，指向第一个数据
            front = 0;
        }

        int value = arr[front++];
//        // 队头指向最后一个数据
//        if (front == arr.length) {
//            // 初始化，指向第一个数据
//            front = 0;
//        }
        elements--;
        return value;
    }


    /**
     * 查看队头数据
     *
     * @return
     */
    public int peek() {
        return arr[front];
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return elements == 0;
    }


    /**
     * 判断是否为满
     * @return
     */
    public boolean isFull() {
       return elements == arr.length;
    }


    /**
     * 查看数组数据
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

}




