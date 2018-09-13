package com.lingb.mystudy.jvm.day02;

/**
 * Created by lingb on 2018/9/11
 */
public class SuperClass {

    public static final String SUPER_STR = "super";

    public static String superHelloWorld = "super:helloWorld";

    // 初始化有且只加载1次
    static {
        System.out.println("SuperClass:This is a static block .");
    }

    // 每实例化1个对象加载1次
    {
        System.out.println("SuperClass:This is a non-static block.");
    }

}
