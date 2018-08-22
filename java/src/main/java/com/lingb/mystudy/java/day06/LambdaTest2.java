package com.lingb.mystudy.java.day06;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Lambda 表达式使用要求：
 * 1、新建或现成的函数式接口
 * 2、使用
 *
 * Created by lingb on 2018/7/17
 */
public class LambdaTest2 {

    List<Employee> employees = Arrays.asList(
            new Employee("AA", 12, 1111.11),
            new Employee("BB", 22, 2222.22),
            new Employee("CC", 50, 3333.33),
            new Employee("DD", 55, 4444.44),
            new Employee("GG", 35, 6666.66),
            new Employee("EE", 55, 5555.55)
    );

    @Test
    public void test() {
        Collections.sort(employees, (e1, e2) -> {
            // 比较年龄是否相等
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());

            // 按照年龄降序
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());

            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    @Test
    public void test1(){
        String upperStr = strHandler("abc", (str) -> str.toUpperCase());
        System.out.println(upperStr);
    }

    // ??? 错误写法
    // Error:(57, 27) java: 不兼容的类型: java.lang.String 不是函数接口
//    @Test
//    public void test2(){
//        String upperStr = (str) -> {
//            String upperstr1 = str.toUpperCase();
//            return upperstr1;
//        };
//        System.out.println(upperStr);
//    }


    // 正确写法
    @Test
    public void test3() {
        MyFunction1 mf1 = ((str) -> str.toUpperCase());

        String upperStr = mf1.getValue("abc");
        System.out.println(upperStr);
    }

    // 需求：用于处理字符串
    public String strHandler(String str, MyFunction1 mf1) {
        return mf1.getValue(str);
    }
}
