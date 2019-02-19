package com.lingb.mystudy.algorithm.search;

/**
 * Created by lingb on 2018-12-10
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("The array is empty.");
        }
        if (arr.length == 1 && arr[0] != num) {
            return false;
        }

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, 6));
    }

}
