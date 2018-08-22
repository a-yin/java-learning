package com.lingb.mystudy.dsaa.day02;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lingb on 2018/8/21
 */
public class SortTest {


    /**
     * 验证 ++i 与 i++
     */
    @Test
    public void test3() {
        Sort.autoIncr();
    }

    /**
     * 直接插入排序
     */
    @Test
    public void test2() {
        int[] arr = new int[] {9, 4, 5, 1, 2};
//        int[] arr = new int[] {34, 23, 2, 1, -4};
        System.out.println(Arrays.toString(arr));
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 直接选择排序
     */
    @Test
    public void test1() {
//        long[] arr = new long[] {9, 4, 5, 1, 2};
        long[] arr = new long[] {34, 23, 2, 1, -4};
        System.out.println(Arrays.toString(arr));
        Sort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 冒泡排序
     */
    @Test
    public void test() {
//        long[] arr = new long[] {9, 4, 5, 1, 2};
        long[] arr = new long[] {34, 23, 2, 1, -4};
        System.out.println(Arrays.toString(arr));
        Sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
