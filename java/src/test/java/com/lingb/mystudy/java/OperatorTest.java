package com.lingb.mystudy.java;

import org.junit.Test;

/**
 *
 *
 * @author lingb
 * @date 2019.03.15 10:23
 */
public class OperatorTest {

    @Test
    public void test2() throws InterruptedException {
        System.out.println("Hello");
        Thread.sleep(10000);
    }
    
    @Test
    public void test1() {
        int i = 8;
        // 10
        // 10
        System.out.println(++i + 1);
        System.out.println(i++ + 1);
    }

    @Test
    public void test() {
        int n = 456;
        int result = n / 10;
        System.out.println(result);

        int result1 = n % 10;
        System.out.println(result1);

        int result2 = n / 10 % 10;
        System.out.println(result2);
    }
}
