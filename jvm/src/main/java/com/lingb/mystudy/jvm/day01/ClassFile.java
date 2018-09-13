package com.lingb.mystudy.jvm.day01;

/**
 * Created by lingb on 2018/9/10
 */
public class ClassFile {

    {
        System.out.println("缺省代码块");
    }

    static {
        System.out.println("static代码块...");
    }

    public String hello = "Hello";
    public static String world = "World";


    public static void main(String[] args) {

    }
}
