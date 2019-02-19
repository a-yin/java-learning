package com.lingb.mystudy.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n * n)
 * 空间复杂度：O(1)
 * 稳定
 *
 * Created by lingb on 2018-12-06
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
            bubbleSort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
            n--;
        }
    }
}
