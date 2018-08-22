package com.lingb.mystudy.java.day05;

import java.util.Arrays;
import java.util.Random;

/**
 * 动态数组
 *
 * Created by lingb on 2018/7/14
 */
public class DynamicArray<E> {

    /**
     * 定义默认的初始容量值
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 声明Object类型动态数组
     */
    private Object[] elementData;

    /**
     * 动态数组的大小（即包含的元素的数量）
     */
    private int size;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 返回size
     *
     * @param   []
     * @return  int
     */
    public int size() {
        return size;
    }

    /**
     * index越界提示信息
     *
     * @param   [index]
     * @return  java.lang.String
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * 指定最小容量minCapacity 扩展数组
     *
     * @param   [minCapacity]
     * @return  void
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }

        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
            // 复制一个新的以newCapacity为容量的数组
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /**
     * 尾部添加一个元素
     *
     * @param   [e]
     * @return  void
     */
    public void add(E e) {
        // 先扩展
        ensureCapacity(size + 1);
        // 再添加
        elementData[size++] = e;
    }

    /**
     * 替换指定index的元素，返回被替换的旧值
     *
     * @param   [index]
     * @return  E
     */
    public E get(int index) {
        return (E) elementData[index];
    }

    public E set (int index, E e) {
        // 良好习惯之 方法参数前置验证
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        E oldValue = get(index);
        elementData[index] = e;
        return oldValue;

    }

    public static void main(String[] args) {
        DynamicArray<Double> dynamicArray = new DynamicArray<>();
        Random random = new Random();
        int size = 1 + random.nextInt(10);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            dynamicArray.add(Math.random());
            Double d = dynamicArray.get(i);
            System.out.println(d);
        }

    }

}