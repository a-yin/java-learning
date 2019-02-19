package com.lingb.mystudy.algorithm.recursion;

/**
 * Created by lingb on 2018-12-20
 */
public class Hanoi {

    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, help, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        hanoi(n - 1, help, to, from);
    }

    public static void main(String[] args) {
        hanoi(3, "左", "中", "右");
    }
}
