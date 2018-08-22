package com.lingb.mystudy.java.day03;

import org.junit.Test;

/**
 * 枚举
 *
 * Created by lingb on 2018/7/12
 */
public enum WeekEnum {

    // 下面代码实际上调用了7次 protected Enum(String name, int ordinal) {...}
    // new Enum<Enum>("MON",0);
    // new Enum<Enum>("TUE",1);
    // new Enum<Enum>("WED",2);
    //...
    MON, TUE, WED, THU, FRI, SAT, SUN;

}

/**
 * default（缺省）类
 */
class WeekEnumDemo {

    @Test
    public void testEnum() {
        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we.toString());
        }

        System.out.println("----------------我是分隔线------------------");

        WeekEnum we = WeekEnum.TUE;
        switch (we) {
            case TUE:
                System.out.println("今天是星期二");
                break;
            case MON:
                System.out.println("今天是星期一");
                break;
            // ...
            default:
                System.out.println(we);
                break;
        }
    }

    public static void main(String[] args) {
        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we.toString());
        }

        System.out.println("----------------我是分隔线------------------");

        WeekEnum we = WeekEnum.TUE;
        switch (we) {
            case MON:
                System.out.println("今天是星期一");
                break;
            case TUE:
                System.out.println("今天是星期二");
                break;
            // ...
            default:
                System.out.println(we);
                break;
        }
    }

}
