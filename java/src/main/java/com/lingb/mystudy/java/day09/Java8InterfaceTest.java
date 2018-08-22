package com.lingb.mystudy.java.day09;

import org.junit.Test;

/**
 * Java8 接口新特性
 *
 * Created by lingb on 2018/7/18
 */
public class Java8InterfaceTest {

    interface MyFun<T> {

        T getValue(T t);

        default String sayHello() {
            return "Hello Java8!###";
        }
    }

    interface MyFun1<T> {

        static void show() {
            System.out.println("Hello MyFun1！");
        }

        default String sayHello() {
            return "Hello Java8!---";
        }


    }

    class MyClass implements MyFun, MyFun1 {

        @Override
        public Object getValue(Object o) {
            return null;
        }

        @Override
        public String sayHello() {
            return MyFun1.super.sayHello();
        }

    }

    @Test
    public void test(){
        MyFun1 mf1 = new MyClass();
        System.out.println(mf1.sayHello());

        MyFun1.show();
    }

}
