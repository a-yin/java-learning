package com.lingb.mystudy.algorithm.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.22 11:54
 */
public class SubArrSearch {

    /**
     * 两个无序的数组arr1、arr2，判断 arr2 是否为 arr1 的子集
     */

    /**
     * HashSet
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean subArrWithHashSet(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            // 去重并添加
            if (!hashSet.contains(arr1[i])) {
                hashSet.add(arr1[i]);
            }
        }

        for (int j = 0; j < arr2.length; j++) {
            // 比对
            if (!hashSet.contains(arr2[j])) {
                return false;
            }
        }

        return true;
    }


    /**
     * 排序后比对
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean subArrWithSort(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int m = arr1.length;
        int n = arr2.length;
        if (m < n) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // i 表示 arr1 索引
        // j 表示 arr2 索引
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1[i] > arr2[j]) {
                return false;

            } else if (arr1[i] == arr2[j]) {
                i++;
                j++;

            } else if(arr1[i] < arr2[j]) {
                i++;
            }
        }

        // 若arr2还没遍历到最后，则false，反之true
        if (j < n) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 暴力解：双for 循环
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean subArrWithDoubleFor(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int i = 0;
        int j = 0;

        // 双for循环
        for (i = 0; i < arr1.length; i++) {
            // for 循环每个元素配对
            for (j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    break;
                }
                // for 循环完了都还没配对上，直接false
                if (j == arr2.length) {
                    return false;
                }
            }

        }
        return true;
    }

    private static int[] str2Arr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] strArr = str.split(",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        return arr;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[] arr1 = str2Arr(str1);
        int[] arr2 = str2Arr(str2);

        System.out.println(subArrWithDoubleFor(arr1, arr2));
        System.out.println(subArrWithSort(arr1, arr2));
        System.out.println(subArrWithHashSet(arr1, arr2));
    }
}
