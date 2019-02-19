package com.lingb.mystudy.datastructure.day03;

import java.util.Stack;

/**
 * Created by lingb on 2018-12-10
 */
public class MyStackQueue<T> {

    private Stack<T> stackPush;
    private Stack<T> stackPop;

    public MyStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(T val) {
        stackPush.push(val);
    }

    public T poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        pour();
        return stackPop.pop();
    }

    public T peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        pour();
        return stackPop.peek();
    }


    /**
     * pour "倒" 两个原则：
     * 1. stackPop为空
     * 2. stackPush 一次性pour 完
     */
    private void pour() {
        if (!stackPop.isEmpty()) {
            return;
        }

        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }
}
