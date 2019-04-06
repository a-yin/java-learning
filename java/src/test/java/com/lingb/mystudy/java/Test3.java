package com.lingb.mystudy.java;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.18 10:54
 */
public class Test3 {

    private static int sum() {
        int num = 0;

        try {
            num++;
            return num;

        } finally {
            num++;
            // num = 2
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        // num = 1
        System.out.println(sum());
    }
}
