package com.lingb.mystudy.jvm.day02;

/**
 * Created by lingb on 2018/9/11
 */
public class SubClass extends SuperClass {

    public static final String SUB_STR = "sub";

    public static String subHelloWorld = "sub:helloworld";

    //
    static {
        System.out.println("SubClass:This is a static block .");
    }

    {
        System.out.println("SubClass:This is a non-static block.");
    }

    public static void main(String[] args) {
        System.out.println(SuperClass.SUPER_STR);
        System.out.println(SubClass.SUB_STR);
    }
}
