package com.lingb.mystudy.datastructure.day01;

/**
 * 无序序线性表
 *
 * Created by lingb on 2018/8/21
 */
public class MyLinearList<T> {

    /**
     * 声明泛型数组
     */
    private T[] arr;

    /**
     * 记录线性表有效数据的长度（即数据的个数，计数器）
     */
    private int elements;

    public MyLinearList(){
        arr = (T[]) new Object[10];
    }

    public MyLinearList(int maxSize) {
        arr = (T[]) new Object[maxSize];
    }

    /**
     * 添加数据
     */
    public void insert(T value) {
        arr[elements] = value;
        elements++;
    }

    /**
     * 显示数据
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 查找数据，根据value
     */
    public int find(T value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (value == arr[i]) {
                break;
            }
        }

        // for循环结束都没有查找到
        if (i == elements) {
            return -1;
        // 否则返回index
        } else {
            return i;
        }

    }

    /**
     * 查找数据，根据index
     */
    public T get(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[index];
    }

    /**
     * 删除数据
     */
    public void delete(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = index; i < elements; i++) {
                arr[i] = arr[i+1];
                System.out.println(arr[i]);
            }
            elements--;
        }

    }

    /**
     * 更新数据
     */
    public void update(int index, T newValue) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        arr[index] = newValue;
    }

}
