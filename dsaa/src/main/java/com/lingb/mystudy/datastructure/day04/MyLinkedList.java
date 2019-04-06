package com.lingb.mystudy.datastructure.day04;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 研究LinkedList源码:
 * 1、LinkedList基本概念
 * 2、LinkedList基本操作
 * 3、手写实现简易LinkedList
 *
 * Created by lingb on 2018/9/13
 */
public class MyLinkedList<E> implements Iterable<E> {

    /**
     * MyLinkedList:
     * 1、Node类，私有的内部类
     * 2、包含头尾的链、表的大小以及一些方法
     * 3、LinkedListIterator类，私有类，实现Iterator接口，并提供了hasNext()、next()、remove()方法的实现。
     */


    // 1
    private static class Node<E> {
        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    // 2
    private int size;

    /**
     * modCount 记录从构造以来对链表改变的次数
     */
    private int modCount = 0;

    private Node<E> head;

    private Node<E> tail;

    /**
     * 默认构造方法
     */
    public MyLinkedList() {
        // 初始化链表
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.next = tail;
        size = 0;
        modCount++;
    }

    public void checkElementIndex(int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> n = null;

        // 二分查找
        if (index < size() / 2) {
            n = head;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return n;

        } else {
            n = tail;
            for (int i = size() - 1; i > index ; i--) {
                n = n.prev;
            }
            return n;
        }

    }

    public E set(int index, E data) {
        checkElementIndex(index);
        Node<E> n = getNode(index);
        E oldData = n.data;
        n.data = data;
        // 返回给用户看最后一眼
        return oldData;
    }

    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).data;
    }


    /**
     * 头插入
     *
     * @param data
     */
    public void linkHead(E data) {
        Node<E> h = head;
        Node<E> newNode = new Node<>(null, data, h);
        head = newNode;
        if (h == null) {
            tail = newNode;

        } else {
            h.next = newNode;
        }

        size++;
        modCount++;
    }


    /**
     * 尾插入
     *
     * @param data
     */
    public void linkTail(E data) {
        Node<E> t = tail;
        Node<E> newNode = new Node<>(t, data, null);
        tail = newNode;
        if (t == null) {
            head = newNode;

        } else {
            t.next = newNode;
        }

        size++;
        modCount++;

    }

    public E unlink(Node<E> n) {
        E elem = n.data;
        Node<E> next = n.next;
        Node<E> prev = n.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            n.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            n.next = null;
        }

        n.data = null;
        size--;
        modCount++;
        return elem;
    }


    /**
     * 添加
     *
     * @return
     */
    public boolean add(E data) {
        // 默认尾插入
        linkTail(data);
        return true;
    }

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        Node<E> n = getNode(index);
        // 返回给用户看最后一眼
        return unlink(n);
    }


    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> n = head; n != null; n = n.next) {
                if (n.data == null) {
                    unlink(n);
                    return true;
                }
            }
        } else {
            for (Node<E> n = head; n != null; n = n.next) {
                if (o.equals(n.data)) {
                    unlink(n);
                    return true;
                }
            }
        }
        return false;
    }


    // 3
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        private Node<E> current = head.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;


        @Override
        public boolean hasNext() {
//            return !current.equals(tail);
            return current != tail;
        }

        @Override
        public Object next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E nextData = current.data;
            current = current.next;
            okToRemove = true;
            return nextData;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }


}
