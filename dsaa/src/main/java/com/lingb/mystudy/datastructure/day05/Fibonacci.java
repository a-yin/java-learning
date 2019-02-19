package com.lingb.mystudy.datastructure.day05;

/**
 * Fibonacci数列
 *
 * Created by lingb on 2018/8/26
 */
public class Fibonacci {

    public static int getNumberByRecursion(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return getNumberByRecursion(n - 1) + getNumberByRecursion(n - 2);
    }


    public static int getNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }


}









