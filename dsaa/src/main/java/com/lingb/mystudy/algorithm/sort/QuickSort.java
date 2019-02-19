package com.lingb.mystudy.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：O(n * log2n)
 * 空间复杂度：O(n * log2n)   随机快速排序 空间复杂度：O(log2n)
 * 不稳定
 *
 * Created by lingb on 2018-12-06
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机快速排序, 以最后一个元素作为参考
//            swap(arr, l + (int) Math.random() * (r - l + 1), r);

            // 记录划分断点
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // arr[r] 最终归位，即以最后一个元素与more的第一个元素交换
        swap(arr, more, r);
        // 返回划分断点
        return new int[]{less + 1, more};
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
            quickSort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
            n--;
        }
    }
}









