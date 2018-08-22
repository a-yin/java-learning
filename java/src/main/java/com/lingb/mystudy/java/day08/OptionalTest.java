package com.lingb.mystudy.java.day08;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional<T> 类(java.util.Optional) 是一个容器类，代表一个值存在或不存在
 *
 * Created by lingb on 2018/7/18
 */
public class OptionalTest {

    /**
     * OPTIONAL 容器类常用的方法：
     * OPTIONAL.OF(T T) : 创建一个OPTIONAL 实例
     * OPTIONAL.EMPTY() : 创建一个空的OPTIONAL 实例
     * OPTIONAL.OFNULLABLE(T T):若T 不为NULL,创建OPTIONAL 实例,否则创建空实例
     * ISPRESENT() : 判断是否包含值
     * ORELSE(T T) : 如果调用对象包含值，返回该值，否则返回T
     * ORELSEGET(SUPPLIER S) :如果调用对象包含值，返回该值，否则返回S 获取的值
     * MAP(FUNCTION F): 如果有值对其处理，并返回处理后的OPTIONAL，否则返回OPTIONAL.EMPTY()
     * FLATMAP(FUNCTION MAPPER):与MAP 类似，要求返回值必须是OPTIONAL
     *
     */

    @Test
    public void test3(){
        Optional<Integer> op = Optional.ofNullable(null);

        boolean present = op.isPresent();
        System.out.println(present);

        Integer i = op.orElse(321);
        System.out.println(i);

        Integer i1 = op.orElseGet(() -> new Integer(321));
        System.out.println(i1);


    }


    @Test
    public void test2(){
        /**
         public static <T> Optional<T> ofNullable(T value) {
             return value == null ? empty() : of(value);
         }

         */
        Optional<String> op = Optional.ofNullable("Hello Optional!");
        System.out.println(op.get());
    }


    @Test
    public void test1(){
        // 创建一个空的Optional 实例
        Optional<String> op = Optional.empty();
        // 抛出异常java.lang.NullPointerException
        System.out.println(op.get());
    }


    @Test
    public void test(){
        // 抛出异常java.lang.NullPointerException
        Optional<String> op = Optional.of(null);
        System.out.println(op.get());
    }


}
