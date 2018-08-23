package com.lingb.mystudy.dsaa.day04;

/**
 * 链表，相当于 列车
 *
 * Created by lingb on 2018/8/23
 */
public class LinkList<T> {

    // 头结点
    private Node<T> first;

    public LinkList() {
        first = null;
    }

    /**
     * 插入一个结点（车厢），头结点后插入
     * @param value
     */
    public void insertFirst(T value) {
        // 打包成结点
        Node<T> insertNode = new Node<>(value);
//        insertNode.next = first;
//        first = insertNode;

        if (first == null) {
            first = insertNode;

        } else {
            System.out.print(first.data);
            System.out.print(" ");
            System.out.print(insertNode.data);
            first.next = insertNode;
        }
    }

    /**
     * 显示链表数据
     */
    public void display() {
        Node<T> current = first;
        while (current.next != null) {
            current.display();
            current.next = current;
        }
    }

}
