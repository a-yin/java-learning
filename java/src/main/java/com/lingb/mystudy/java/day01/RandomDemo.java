package com.lingb.mystudy.java.day01;

import java.util.Arrays;
import java.util.Random;

/**
 * 伪随机数工具类
 * Random 产生的随机数不是真正的随机数，而是"伪随机数"
 * 真正的随机数比较难以产生，计算机程序中的随机数一般都是"伪随机数"
 * 基本原理：
 * 伪随机数都是基于一个种子数（一个真正随机数），然后每需要一个伪随机数，都是对当前种子进行一些数学运算，
 * 得到一个数，基于这个数得到需要的伪随机数和新的种子
 *
 * Created by lingb on 2018/7/9
 */
public class RandomDemo {

    /**
     * 伪随机数常见应用场景：随机密码、洗牌、带权重的随机选择、微信抢红包算法、购车摇号算法...
     *
     */

    /**
     * 随机密码
     * '' 字符
     * "" 字符串
     *
     * @param   []
     * @return  void
     */
    public void testRandomPassword() {
        int len = 6;
        char[] chars = new char[len];
        Random random = new Random();
        for (int j = 0; j<10; j++) {
            for (int i = 0; i<chars.length; i++) {
                // 0 ~ 9
                chars[i] = (char)('0' + random.nextInt(10));
            }

            System.out.println(new String(chars));
        }

    }

    /**
     * 洗牌，即将一个数组或序列随机重新排列
     *
     * @param   [arr, i, j]
     * @return  void
     */
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void shuffle(int[] arr) {
        Random random = new Random();
        // 基本思路：
        // 从后往前，逐个给每个数组位置重新赋值，值是从剩下的元素中随机挑选的
        for (int i = arr.length; i>1; i--) {
            // i-1 当前要赋值的位置
            // random.nextInt(i) 从剩下的元素中随机挑选的
            swap(arr, i-1, random.nextInt(i));
        }
    }

    public void testSwap() {
        int[] arr = {2, 0, 1, 8, 7, 9};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        new RandomDemo().testRandomPassword();
        new RandomDemo().testSwap();
    }
}
