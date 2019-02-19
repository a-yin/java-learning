package com.lingb.mystudy.datastructure.day01;


/**
 * 有序线性表
 *
 * Created by lingb on 2018/8/21
 */
public class MyOrderLinearList {

    /**
     * 声明泛型数组
     */
    private long[] arr;

    /**
     * 记录线性表有效数据的长度（即数据的个数，计数器）
     */
    private int elements;

    public MyOrderLinearList(){
        arr = new long[10];
    }

    public MyOrderLinearList(int maxSize) {
        arr = new long[maxSize];
    }

    /**
     * 添加数据
     */
    public void insert(long value) {
        int i;
        // for循环找到插入新元素位置的index
        for (i = 0; i < elements; i++) {
            if (arr[i] > value) {
                break;
            }
        }

        // 后面向后移动一位
        for (int j = elements; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        // 在index = i 位置上插入新元素
        arr[i] = value;
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
    public int find(long value) {
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
    public long get(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[index];
    }

    /**
     * 二分查找，基于有序线性表
     */
    public int binarySearch(long value) throws Exception {
        // 中间索引
        int middle;
        // 下限索引
        int low = 0;
        // 上限索引
        int pow = elements;
        while (true) {
            middle = (low + pow) / 2;
            // 直接中间
            if (arr[middle] == value) {
                return middle;
            // 非法情况（上限<下限）
            } else if (pow < low) {
                return -1;

//            } else if (pow == low){
//                throw new Exception("Not Found!");

            // 向左？向右？
            } else {
                // 向左
                if (arr[middle] > value) {
                    pow = middle - 1;
                // 向右
                } else {
                    low = middle + 1;
                }
            }
        }
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
    public void update(int index, long newValue) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        arr[index] = newValue;
    }

}
