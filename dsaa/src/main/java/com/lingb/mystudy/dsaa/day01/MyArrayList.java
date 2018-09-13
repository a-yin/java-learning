package com.lingb.mystudy.dsaa.day01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 研究ArrayList源码:
 * 1、ArrayList基本概念
 * 2、ArrayList基本操作
 * 3、手写实现简易ArrayList
 *
 * Created by lingb on 2018/9/12
 */
public class MyArrayList<E> implements Iterable<E>{

    /**
     * MyArrayList:
     * 1）底层实现->数组，数组的容量，以及存储在MyArrayList中的当前项。
     * 2）提供一种机制以改变数组的容量（通过new一个新的数组，将老数组复制到新数组来改变数组的容量，虚拟机回收老数组）。
     * 3）size()、isEmpty()、clear()、get()、set()以及两种不同的add()、remove()方法。
     * 4）提供一个内部类实现Iterator接口，该类存储迭代徐磊中的下一元素的index，并提供next()、hasNext()和remove()方法的实现，
     *    MyArraylist的迭代器方法iterator()直接返回该内部类的实例对象。
     */

    // 1
    /**
     * 列表默认容量10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 列表底层实现->数组
     */
    private E[] arr;

    /**
     * 列表当前项（类似计数器）
     */
    private int size;

    // 2

    /**
     * 默认构造方法
     */
    public MyArrayList() {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 自定义构造方法
     *
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity) {
        arr = (E[]) new Object[initialCapacity];
    }

    /**
     * 改变数组的容量的机制的方法
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }

        E[] oldArr = arr;

//        arr = (E[]) new Object[newCapacity];
//        for (int i = 0; i < size(); i++) {
//            arr[i] = oldArr[i];
//        }

        // 等价于上面
       arr = Arrays.copyOf(oldArr, newCapacity);

    }

    /**
     * 数组上下界检测
     */
    public void rangeCheck(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // 3

    /**
     * 获取当前size
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 将这个ArrayList实例的容量capacity作为列表的当前大小size。
     * 应用程序可以使用这个操作来最小化ArrayList实例的存储。
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 列表清空
     */
    public void clear() {
        // 允许虚拟机回收
        for (int i = 0; i < size(); i++) {
            arr[i] = null;
        }

        size = 0;
    }

    /**
     * 获取列表指定index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    /**
     * 用指定的元素替换这个列表中指定index位置的元素。
     *
     * @param index
     * @param elem
     * @return
     */
    public E set(int index, E elem) {
        rangeCheck(index);

        E oldElem = arr[index];
        arr[index] = elem;
        // 返回给用户看最后一眼
        return oldElem;
    }

    /**
     * 将指定的元素附加到列表的末尾。
     *
     * @param elem
     * @return
     */
    public boolean add (E elem) {
        add(size, elem);
        return true;
    }


    /**
     * 在这个列表中指定的位置插入指定的元素。
     * 将当前位置（如果有的话）的元素和后边的任何后续元素都转换（将一个元素添加到它们的索引中）。
     *
     * @param index
     * @param elem
     */
    public void add(int index, E elem) {
//        rangeCheck(index);
        if (arr.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }

        // 向后移
        for (int i = size(); i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = elem;
        size++;
    }


    /**
     * 删除该列表中指定位置的元素。
     * 将任何后续的元素移到前边（从它们的索引中减去一个元素）。
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E oldElem = arr[index];
        // 向前移
        for (int i = index; i < size() - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // 允许虚拟机回收
        arr[--size] = null;

        // 返回给用户看最后一眼
        return oldElem;
    }

    /**
     * 返回该列表的迭代器的实例对象
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        /**
         * 指向下一元素的index
         */
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return arr[cursor++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--cursor);
        }
    }



}
