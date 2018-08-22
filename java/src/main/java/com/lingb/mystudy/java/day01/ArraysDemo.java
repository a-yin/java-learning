package com.lingb.mystudy.java.day01;

import java.util.Arrays;

/**
 * Arrays工具类
 *
 * Created by lingb on 2018/7/9
 */
public class ArraysDemo {

    public void testToString() {

        // 声明并初始化一维整形数组
        int[] intArr = {2, 0, 1, 8 , 7, 9};
        // 调用Object类的toString()方法
        System.out.println(intArr);
        System.out.println(intArr.toString());
        // 调用Arrays类的toString()方法
        System.out.println(Arrays.toString(intArr));

        // 声明长度为2 的一维字符串数组
        String[] strArr = new String[2];
        // 初始化
        strArr[0] = "hello,";
        strArr[1] = "world";
        System.out.println(strArr);
        System.out.println(strArr.toString());
        System.out.println(Arrays.toString(strArr));

    }

    public void testSort() {
        // 声明并初始化一维整形数组
        int[] intArr = {2, 0, 1, 8 , 7, 9};
        // 默认升序
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
    }

    public static void main(String[] args) {
        new ArraysDemo().testToString();
        new ArraysDemo().testSort();

        // 获取ArraysTest 的Class 对象
        Class clazz = new ArraysDemo().getClass();
        System.out.println(clazz);
        // 获取ArraysTest 的Class 对象 的全名
        String clazzName = new ArraysDemo().getClass().getName();
        System.out.println(clazzName);

    }
}
