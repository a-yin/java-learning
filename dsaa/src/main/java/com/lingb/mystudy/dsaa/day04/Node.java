package com.lingb.mystudy.dsaa.day04;

/**
 * 结点，相当于 车厢
 *
 * Created by lingb on 2018/8/23
 */
public class Node<T> {

    /**
     * 数据域，相当于 装的东西
     */
    public T data;

    /**
     * 指针域，即指向的下一个结点，相当于 下一车厢
     */
    public Node<T> next;

    /**
     * 带参的构造方法（构造带东西的车厢）
     *
     * @param value
     */
    public Node(T value) {
        this.data = value;
    }

    /**
     * 显示结点数据
     */
    public void display() {
        System.out.print(data + " ");
    }

}
