package com.lingb.mystudy.datastructure.day04;

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
     * 指针域
     * previous即指向（存储）的上一个结点，相当于 上一车厢
     * next即指向（存储）的下一个结点，相当于 下一车厢
     *
     */
    public Node previous;

    public Node<T> next;

    /**
     * 带参的构造方法（构造带东西的车厢）
     *
     * @param value
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * 显示结点数据
     */
    public void display() {
        System.out.print(data + " ");
    }

}
