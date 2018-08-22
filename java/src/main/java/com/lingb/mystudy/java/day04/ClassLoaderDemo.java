package com.lingb.mystudy.java.day04;

/**
 * 类加载器ClassLoader Demo
 *
 * Created by lingb on 2018/7/13
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        String className = ClassLoader.getSystemClassLoader().getClass().getName();
        System.out.println(className);
        if (cl != null) {
            System.out.println(cl.getClass().getName());
            System.out.println(cl.getParent().getClass().getName());
        }
        // 若ClassLoader 是Bootstrap ClassLoader，返回值为 null
        System.out.println(String.class.getClassLoader());
    }


}
