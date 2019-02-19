package com.lingb.mystudy.datastructure;

import org.junit.Test;

/**
 * Created by lingb on 2018-12-10
 */
public class MyStack<T> {

    private Object[] arr;
    private int top;
    private int size;

    public MyStack() {
        arr = new Object[5];
        top = 0;
        size = 0;
    }

//    public MyStack(int initSize) {
//        arr = new Object[initSize];
//        top = 0;
//        size = 0;
//    }

    public void push(T val) {
        if (size == arr.length) {
            throw new RuntimeException("The RandomPool is overflow.");
        }

        size++;
        arr[top++] = val;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("The RandomPool is empty.");
        }
        size--;
        return (T) arr[--top];
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("The RandomPool is empty.");
        }
        return (T) arr[top];
    }


    @Test
    public void test() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);

        System.out.println(stack.pop());
    }

}
