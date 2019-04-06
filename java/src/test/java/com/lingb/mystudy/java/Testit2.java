package com.lingb.mystudy.java;

import org.junit.Test;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.06 16:05
 */
public class Testit2 {

    public StringBuffer operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        return y;
    }

    @Test
    public void test3() {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        System.out.println(a + "," + b);
        StringBuffer sb = operator(a, b);
        System.out.println(sb);
    }
    
    @Test
    public void test2() {
        int x = 4;
        switch (x) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            default:
                System.out.println("default");
                break;
        }

        int y = 4;
        switch (y) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("4");
            default:
                System.out.println("default");
        }

        int z = 5;
        switch (z) {
            default:
                System.out.println("default");
                break;
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("4");
        }
    }

    @Test
    public void test1() {
        System.out.println(3|9);
    }

    @Test
    public void test() {

        String str = null;
        System.out.println(str);
        System.out.println(Math.round(-1.5));
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1));
    }


}
