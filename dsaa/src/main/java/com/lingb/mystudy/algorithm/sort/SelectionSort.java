package com.lingb.mystudy.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(n * n)
 * 空间复杂度：O(1)
 * 不稳定
 *
 * Created by lingb on 2018-12-06
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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
            selectionSort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
            n--;
        }
    }

}
