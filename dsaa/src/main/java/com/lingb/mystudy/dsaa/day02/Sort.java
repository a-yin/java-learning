package com.lingb.mystudy.dsaa.day02;

/**
 * 内部排序算法
 *
 * Created by lingb on 2018/8/21
 */
public class Sort {


    /**
     * 验证 ++i 与 i++
     */
    public static void autoIncr() {
        int i = 0;
        int result = 0;
        // 简单理解，吃饭后干活，即先自增后赋值
        result = ++i;
        System.out.println("先自增-------------");
        System.out.print("i=" + i + "，");
        System.out.println("result=" + result);

        // 干活后吃饭，即先赋值后自增
        result = i++;
        System.out.println("后自增-------------");
        System.out.print("i=" + i + "，");
        System.out.println("result=" + result);
    }


    /**
     * 直接插入排序
     * 1、首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入
     * 2、设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1
     * 3、从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位
     * 4、将当前数放置到空着的位置，即j+1
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        System.out.println("直接插入排序---------");
        // 要插入的元素
        int insertNum;
        // 因为第一次不用，所以从1开始
        for (int i = 1; i < arr.length; i++) {
            insertNum = arr[i];
            int j = i - 1;
            // 从后往前循环，将大于insertNum的数向后移动（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面)
            while (j >= 0 && arr[j] >= insertNum) {
                // 向后移
                arr[j + 1] = arr[j];
                j--;
            }

            // 找到位置，插入当前元素
            arr[j + 1] = insertNum;
        }
    }


    /**
     * 直接选择排序
     * 1、首先确定循环次数，并且记住当前数字和当前位置
     * 2、将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置
     * 3、比对完成后，将最小的值与第一个数的值交换
     * 4、重复2、3步
     *
     * @param arr
     */
    public static void selectionSort(long[] arr) {
        System.out.println("直接选择排序---------");
        // 指向最小元素
        int k = 0;
        long tmp = 0;
        // 遍历的次数（跑多少趟）
        for (int i = 0; i < arr.length - 1; i++) {
            // 初始化，即默认指向当前循环index = i的元素（下标为i）
            k = i;
            // 遍历arr选择最小元素
            for (int j = i; j < arr.length; j++) {
                // 找到最小元素
                if (arr[j] < arr[k]) {
                    // 赋值指向最小元素
                    k = j;
                }
            }

            // 找到最小元素再交换（共arr.length次）
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
    }


    /**
     * 冒泡排序
     * 1、设置循环次数
     * 2、设置开始比较的位数，和结束的位数
     * 3、两两比较，将最小的放到前面去
     * 4、重复2、3步，直到循环次数完毕
     *
     * @param arr
     */
    public static void bubbleSort(long[] arr) {
        System.out.println("冒泡排序---------");
        long tmp = 0;
        // 遍历的次数（跑多少趟）
        for (int i = 0; i < arr.length - 1; i++) {
            // 两两比较
            for (int j = arr.length - 1; j > i; j--) {
                // 交换（次数无法确定）
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }
}
