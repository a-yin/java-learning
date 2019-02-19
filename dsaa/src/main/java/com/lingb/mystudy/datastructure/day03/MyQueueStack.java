package com.lingb.mystudy.datastructure.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * Created by lingb on 2018-12-10
 */
public class MyQueueStack<T> {

    private Queue<T> data;
    private Queue<T> help;

    public MyQueueStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(T val) {
        data.add(val);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("The RandomPool is empty.");
        }

        while (data.size() > 1) {
            help.add(data.poll());
        }

        T res = (T) data.poll();
        swap();
        return res;
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("The RandomPool is empty.");
        }

        while (data.size() > 1) {
            help.add(data.poll());
        }

        T val = (T) data.poll();
        help.add(val);
        swap();
        return val;
    }


    private void swap() {
        Queue<T> tmp = help;
        help = data;
        data = tmp;
    }
}
