package com.lingb.mystudy.algorithm.search;

/**
 * Created by lingb on 2018-12-10
 */
public class BinarySearch {

    /** 计数器 */
    private static int count;

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
//            System.out.print(m + " ");
            if (arr[m] == num) {
                return true;
            } else if (arr[m] < num) {
                count++;
                l = m + 1;
            } else {
                count++;
                r = m - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        System.out.print(binarySearch(nums, 6));
        System.out.print(" " + count + "\n");
        count = 0;

        int[] nums1 = new int[] {13, 18, 24, 35, 47, 50, 62, 83, 115, 134};
        System.out.print(binarySearch(nums1, 90));
        System.out.print(" " + count);
    }

}
