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
    String ok1 = new String(" 今天我也很OK ");

    private void testString() {
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

    private void testSwap() {
        int a = 1;
        int b = 2;
        String c = "c";
        String d = "d";
        String e = new String("e");
        String f = new String("f");
        // swap(,) 方法交换
        swap(a, b);
        swap(c, d);
        swap(e, f);

        // 交换失败
        // 12cd
        // 12ef
        System.out.println("" + a + b + c + d);
        System.out.println("" + a + b + e + f);


        // tmp 临时变量交换
        String tmp = c;
        c = d;
        d = tmp;

        String tmp1 = e;
        e = f;
        f = tmp1;

        // 交换成功
        // 12dc
        // 12fe
        System.out.println("" + a + b + c + d);
        System.out.println("" + a + b + e + f);

    }

    private void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }
    private void swap(String i, String j) {
        String tmp = i;
        i = j;
        j = tmp;
    }

    private void testStringPool() {
        String c = "aa";
        String a = new String("aa");
        String b = new String("aa");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }

    public static void main(String[] args) {
        new StringDemo().testString();

        // 类对象.class
        System.out.println(StringDemo.class);
        // 对象实例.getClass()
        System.out.println(new StringDemo().getClass());

        // Java只支持值传递（没有引用传递）
        // 经过测试 swap( , ) 方法不能交换基本数据类型以及字符串类型，因为直接赋值
        // 引用类型才可以交换，是因为引用类型直接赋的是地址，地址指向的是同一个对象，所以能改变
        new StringDemo().testSwap();

        new StringDemo().testStringPool();

        // "+"
        String str = "";
        str += 'a';
        System.out.println(str);
        str = str + 100;
        System.out.println(str);
        str = String.valueOf(new StringBuilder().append(str).append(100));
        System.out.println(str);
    }

}
