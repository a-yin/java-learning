package com.lingb.mystudy.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：O(n * n)
 * 空间复杂度：O(1)
 * 稳定
 *
 * Created by lingb on 2018-12-06
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 10;
        while (n != 0) {
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100);
            }
            System.out.println(Arrays.toString(arr));
            insertionSort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
            n--;
        }
    }

}
