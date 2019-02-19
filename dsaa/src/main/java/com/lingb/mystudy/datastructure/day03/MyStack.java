package com.lingb.mystudy.datastructure.day03;

/**
 * 栈：先进后出FILO
 *
 * Created by lingb on 2018/8/22
 */
public class MyStack {

    /**
     * 底层实现是一个数组
     */
    private int[] arr;

    /**
     * 栈顶（唯一入出口）
     */
    private int top;

    /**
     * 默认构造方法
     */
    public MyStack() {
        arr = new int[10];
        // 指向为空
        top = -1;
    }

    /**
     * 带参数构造方法
     * @param maxSize
     */
    public MyStack(int maxSize) {
        arr = new int[maxSize];
        // 初始化为空
        top = -1;
    }

    /**
     * 添加数据（压栈）
     *
     * @param value
     */
    public void push(int value) throws Exception {

        if (!isFull()) {
            // 初始化 top=0
            arr[++top] = value;

        } else {
            throw new Exception("The RandomPool is overstack.");
        }

    }

    /**
     * 移除数据（出栈）
     *
     * @return
     */
    public int pop() throws Exception {
        if (!isEmpty()) {
//            int value = arr[top];
//            top--;
//            return value;

            // 上面等价于
            return arr[top--];

        } else {
            throw new Exception("The RandomPool is empty.");
        }

    }

    /**
     * 查看栈顶数据
     *
     * @return
     */
    public int peek() throws Exception {
        if (!isEmpty()) {
            return arr[top];

        } else {
            throw new Exception("The RandomPool is empty.");
        }
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
//        if (top == -1) {
//            return true;
//        }
//
//        return false;

        // 上面等价于
        return top == -1;
    }

    /**
     * 判断是否为满
     *
     * @return
     */
    public boolean isFull() {
//        // 0~length-1
//        if (top == arr.length-1) {
//            return true;
//        }
//
//        return false;

        // 上面等价于
        return top == arr.length - 1;
    }

}
