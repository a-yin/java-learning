package com.lingb.mystudy.dsaa.day03;

import org.junit.Test;

/**
 * Created by lingb on 2018/8/22
 */
public class StackAndQueueTest {


    @Test
    public void test2() {
        MyCircleQueue mcq = new MyCircleQueue(4);
        mcq.insert(23);
        mcq.insert(32);
        mcq.insert(12);
        mcq.insert(54);

        System.out.println(mcq.isEmpty());
        System.out.println(mcq.isFull());

        System.out.println(mcq.peek());
        System.out.println(mcq.peek());

        while (!mcq.isEmpty()) {
            System.out.print(mcq.remove() + " ");
        }

        System.out.println();
        System.out.println(mcq.isEmpty());
        System.out.println(mcq.isFull());

        mcq.insert(54);
        mcq.insert(45);
        while (!mcq.isEmpty()) {
            System.out.print(mcq.remove() + " ");
        }

        System.out.println();
        mcq.display();
    }


    @Test
    public void test1() {
        MyQueue mq = new MyQueue(4);
        mq.insert(23);
        mq.insert(32);
        mq.insert(12);
        mq.insert(54);

        System.out.println(mq.isEmpty());
        System.out.println(mq.isFull());

        System.out.println(mq.peek());
        System.out.println(mq.peek());

        while (!mq.isEmpty()) {
            System.out.print(mq.remove() + " ");
        }

        System.out.println();
        System.out.println(mq.isEmpty());
        System.out.println(mq.isFull());

        // 普通队列index越界，使用循环队列
//        mq.insert(54);
    }
    
    
    @Test
    public void test() throws Exception {
        MyStack ms = new MyStack(4);
        ms.push(23);
        ms.push(32);
        ms.push(12);
        ms.push(54);
//        ms.push(54);

        System.out.println(ms.isEmpty());
        System.out.println(ms.isFull());

        System.out.println(ms.peek());
        System.out.println(ms.peek());

        while (!ms.isEmpty()) {
            System.out.print(ms.pop() + " ");
        }

        System.out.println();
        System.out.println(ms.isEmpty());
        System.out.println(ms.isFull());

//        System.out.println(ms.pop());
//        System.out.println(ms.peek());

        ms.push(54);
        System.out.println(ms.pop());
    }
}
