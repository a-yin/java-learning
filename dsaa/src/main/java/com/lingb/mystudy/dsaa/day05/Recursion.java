package com.lingb.mystudy.dsaa.day05;

/**
 * 递归Recursion : 自己跟自己玩（调用）
 *
 * Created by lingb on 2018/8/26
 */
public class Recursion {

    public static void main(String[] args) {
        print1(100);
    }


    public static void print() {
        System.out.println("Hello World.");
        print();
    }

    public static void print1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print1(n - 1);
    }
}
