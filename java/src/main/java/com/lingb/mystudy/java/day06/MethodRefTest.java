package com.lingb.mystudy.java.day06;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若
 *          （可以理解为方法引用是 Lambda表达式的另一种表现形式）
 *
 * 主要有三种语法格式：
 * 1、对象::实例方法
 *
 * 2、类::静态方法
 *
 * 3、类::实例方法
 *
 * 注：
 *  ① Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！（类型推断）
 *  ② 若Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数是，可以使用 类::实例方法
 *
 * 二、构造方法引用：
 *
 *  格式：
 *      ClassName::new
 *
 *  注：需要调用的构造器的参数列表，要与函数式接口中抽象方法的参数列表保持一致！（类型推断）
 *
 * 三、数组引用
 *
 *  格式：Type[]::new
 *
 * Created by lingb on 2018/7/18
 */
public class MethodRefTest {

    /**
     * 数组引用
     */
    // Type[]::new
    @Test
    public void test4(){
        Supplier<Integer[]> su = () -> new Integer[10];
        Integer[] integers = su.get();
        System.out.println(Arrays.toString(integers));
        System.out.println(integers.length);

        // 数组引用方式
        Function<Integer, Integer[]> su1 = Integer[]::new;
        Integer[] integers1 = su1.apply(20);
        integers1[0] = 123;
        integers1[1] = 213;
        integers1[2] = 321;
        System.out.println(Arrays.toString(integers1));
        System.out.println(integers1.length);
    }


    /**
     * 构造方法引用
     */
    // ClassName::new
    @Test
    public void test3(){
        Supplier<Employee> su = () -> new Employee();
        Employee emp = su.get();
        System.out.println(emp);

        // 构造方法引用方式
        // 调用默认无参构造方法
        Supplier<Employee> su1 = Employee::new;
        Employee emp1 = su1.get();
        System.out.println(emp1);

        // 调用一个参数的构造方法
        Function<String, Employee> fun = Employee::new;
        Employee emp2 = fun.apply("AA");
        System.out.println(emp2);

        // 调用两个参数的构造方法
        BiFunction<String, Integer, Employee> bf = Employee::new;
        Employee emp3 = bf.apply("BB" , 12);
        System.out.println(emp3);


    }


    /**
     * 方法引用
     *
     */
    // 类::静态方法
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }
    @Test
    public void test1(){
        Employee emp = new Employee();
        Supplier<String> su = () -> emp.getName();
        String name = su.get();
        System.out.println(name);

        // 方法引用方式
        Supplier<Integer> su1 = emp::getAge;
        Integer age = su1.get();
        System.out.println(age);
    }

    // 对象::实例方法
    @Test
    public void test(){

        Consumer<Integer> con = (x) -> System.out.println(x);
        con.accept(123);

        // 方法引用方式
        PrintStream ps = System.out;
        Consumer<Integer> con1 = ps::println;
        Consumer<Integer> con2 = System.out::println;
        con1.accept(321);
        con2.accept(321);
    }

}
