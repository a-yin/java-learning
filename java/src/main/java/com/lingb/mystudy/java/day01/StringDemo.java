package com.lingb.mystudy.java.day01;

/**
 * String类 不可变、线程安全
 *
 * Created by lingb on 2018/7/9
 */
public class StringDemo {

    // 【推荐】
    String nice = "今天我很nice";
    String nice1 = "今天我很nice";
    String nice2 = new String("今天我很nice");
    // 【少用】
    String ok = new String(" 今天我也很OK ");

    public void testString() {
        if (!nice.isEmpty()) {
            System.out.println(nice);
        }

        if (!"".equals(ok)) {
            // 掐头去尾空格，返回新的字符串substring(st, len)，原字符串this 不变
            // return ((st > 0) || (len < value.length)) ? substring(st, len) : this;
            String ok1 = ok.trim();
            System.out.println("掐头去尾之前------" + ok);
            System.out.println("掐头去尾之后——————" + ok1);
        }

        System.out.println(nice == nice1);
        System.out.println(nice.equals(nice1));
        // 两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作
        System.out.println(nice == nice2);
        // 两个对象的内容是否相等
        System.out.println(nice.equals(nice2));
        System.out.println(nice.hashCode());
        System.out.println(nice1.hashCode());
        System.out.println(nice2.hashCode());
        System.out.println(ok.hashCode());
    }

    public static void main(String[] args) {
        new StringDemo().testString();

        // 类对象.class
        System.out.println(StringDemo.class);
        // 对象实例.getClass()
        System.out.println(new StringDemo().getClass());

    }

}
