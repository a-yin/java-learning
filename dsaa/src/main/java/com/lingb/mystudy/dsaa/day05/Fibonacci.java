package com.lingb.mystudy.dsaa.day05;

/**
 * Fibonacci数列
 *
 * Created by lingb on 2018/8/26
 */
public class Fibonacci {

    public static int getNumberByRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return getNumberByRecursion(n - 1) + getNumberByRecursion(n - 2);
    }

}
