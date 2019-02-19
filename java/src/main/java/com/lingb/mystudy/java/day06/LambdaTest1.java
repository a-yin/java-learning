package com.lingb.mystudy.java.day06;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式在Java 语言中引入了一个新的语法元素和操作符。这个操作符为“->” ，该操作符被称为Lambda 操作符或剪头操作符。它将Lambda 分为两个部分：
 * 左侧：Lambda 表达式需要的所有参数（即函数式接口的抽象方法的参数列表）
 * 右侧：Lambda 体，即Lambda 表达式要执行的功能。（即函数式接口的抽象方法的实现代码体）
 *
 * Created by lingb on 2018/7/17
 */
public class LambdaTest1 {

    /**
     * 语法格式一：无参数，无返回值
     *      () -> System.out.println("Hello Lambda!");
     *
     * 语法格式二：有一个参数，无返回值【推荐】
     *      (x) -> System.out.println(x);
     *
     * 语法格式三：只有一个参数，小括号可不写
     *      x -> System.out.println(x);
     *
     * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
     *		comparator<Integer> com = (x, y) -> {
     *			System.out.println("函数式接口");
     *			return Integer.compare(x, y);
     *		};
     *
     * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写，转成Lambda 表达式【推荐】
     * 		comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     *
     * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
     * 		(Integer x, Integer y) -> Integer.compare(x, y);
     *
     * 上联：左右遇一括号省
     * 下联：左侧推断类型省
     * 横批：能省则省
     *
     * 二、Lambda 表达式需要“函数式接口”的支持
     * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
     * 			 可以检查是否是函数式接口
     */
    @Test
    public void test(){

        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();

        Consumer<Integer> con = (x) -> System.out.println(x);
        con.accept(111);

        Consumer<Integer> con1 = x -> System.out.println(x);
        con.accept(222);

        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = (Integer x, Integer y) -> Integer.compare(x, y);

    }


    @Test
    public void test1(){
        Integer result = operation(100, (x) -> {
            System.out.println("");
            return x * x;
        });
        System.out.println(result);

        Integer result1 = operation(100, (y) -> y + 100);
        System.out.println(result1);
    }

    public Integer operation(Integer num, MyFunction mf) {
        return mf.getValue(num);
    }
}
