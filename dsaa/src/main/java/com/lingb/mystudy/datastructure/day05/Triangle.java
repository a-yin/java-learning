package com.lingb.mystudy.datastructure.day05;

/**
 * 三角数字
 *
 * Created by lingb on 2018/8/26
 */
public class Triangle {

    /**
     * 循环方式
     *
     * @param n
     * @return
     */
    public static int getNumber(int n) {
        int sum = 0;
        while (true) {
            sum = sum + n;
            n--;
            if (n == 0) {
                break;
            }
        }

        // 等价于上面
//        for (int i = 1; i <= n; i++) {
//            sum = sum + i;
//        }
        return sum;
    }

    /**
     * 递归方式
     *
     * @param n
     * @return
     */
    public static int getNumberByRecursion(int n) {
        if (n == 1) {
            return 1;
        }

        return n + getNumberByRecursion(n - 1);
    }

}
