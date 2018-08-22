package com.lingb.mystudy.java.day03;

import org.junit.Test;

/**
 * 内部类，即类中的类
 * 不过，内部类只是对Java编译器的概念，对于Java虚拟机而言，不存在内部类
 * 本质上，每个内部类最后都会被编译为一个独立的类，生成一个独立的字节码文件
 * 使用内部类最吸引人的原因是：每个内部类都能独立地继承自一个（接口的）实现，所以无论外部类是否已经继承了某个（接口的）实
 * 现，对于内部类都没有影响。如果没有内部类提供的可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。从这个角
 * 度看，内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”
 * 可以实现完全隐藏（声明为private）、更好的封装、更简洁的代码（内部类可直接访问外部类private属性和方法）
 *
 * Created by lingb on 2018/7/12
 */
public class OuterTest {

    private static int staticNum = 100;
    private int nonStaticNum = 101;

    private static void outerStaticMethod() {
        System.out.println("outerStaticMethod...");
    }

    private void outerMethod() {
        System.out.println("outerMethod...");
    }

    /**
     * 在Java中，根据定义的位置和方式的不同，主要有4种内部类（使用范围大 -> 小）
     * 1、静态内部类
     * 2、成员内部类
     * 3、方法内部类
     * 4、匿名内部类
     * 注：Inner classes cannot have static declarations. 即非静态内部类不能有静态声明
     */

    /**
     * 静态内部类，定义位置与静态变量和静态方法一样，带有static 关键字
     * 应用场景：与外部类关系密切，且不依赖与外部类实例（即访问外部类 静态的属性和方法）
     * 注：不可访问实例属性和方法
     */
    private static class StaticInner {
        private static int staticInnerNum = 10;
        private static String str = "staticInnerStr...";

        private void staticInnerMethod() {
            System.out.println("静态内部类-------------------------");
            System.out.println(str);
            System.out.println(staticNum);
            outerStaticMethod();
        }
    }

    /**
     * 成员内部类，即比静态内部类少了关键字static
     * 应用场景：与外部类关系密切，需要访问外部类的实例变量和方法
     * 可以访问所有属性和方法（静态和实例）
     *
     */
    private class MemberInner {
        private int innerNum = 20;

        private void innerMethod() {
            System.out.println("成员内部类-------------------------");
            System.out.println("outer " + staticNum);
            System.out.println("outer " + nonStaticNum);
            outerStaticMethod();
            outerMethod();
        }
    }

    private void outerMethod1() {
        /**
         *  方法内部类，定义在方法体中，也只能被该方法调用，该方法分为两种
         *  1) 静态方法，方法内部类只能访问外部类的静态变量和方法
         *  2）实例方法，可以访问所有属性和方法（静态和实例）
         *
         */
        class MethodInner {
            // 在JDK8之前，变量必须被声明 final
            // JDK8 不再要求
            final String str = "MethodInner";
            private void methodInner() {
                System.out.println("方法内部类-------------------------");
                System.out.println(str);
                System.out.println(staticNum);
                System.out.println(nonStaticNum);
            }
        }

        MethodInner methodInner = new MethodInner();
        methodInner.methodInner();
        System.out.println(methodInner.str);

    }

    /**
     * 匿名内部类，简化版内部类
     */
    private void outerMethod2(final int x, final int y) {
    }


    @Test
    public void test() {
        // 静态内部类
        StaticInner si = new StaticInner();
        si.staticInnerMethod();

        // 成员内部类
        MemberInner mi = new MemberInner();
        mi.innerMethod();

        // 方法内部类
        OuterTest outerTest = new OuterTest();
        outerTest.outerMethod1();

        // 匿名内部类

    }


}
