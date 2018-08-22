package com.lingb.mystudy.java.day01;

/**
 * String类 可变、线程不安全
 *
 * Created by lingb on 2018/7/9
 */
public class StringBuilderDemo {

    public void testStringBuilder() {
        // 在Java中，String可以直接使用“+”“+=”运算符，这是Java编译器提供的支持。
        String hello = "hello";
        hello += ",world";
        System.out.println(hello);

        // Java编译器转换成
        StringBuilder hello1 = new StringBuilder("hello");
        hello1.append(",world");
        System.out.println(hello1);
    }

    public static void main(String[] args) {
        new StringBuilderDemo().testStringBuilder();

    }

}
