package com.lingb.mystudy.java.day02;

/**
 * Created by lingb on 2018-10-31
 */
public class Testit {

    public Testit() {
        System.out.println("默认构造函数...");
    }

    {
        System.out.println("非静态初始化...");
    }

    static {
        System.out.println("静态初始化...");
    }
}
