package com.lingb.mystudy.java.day10;

/**
 * 单例模式 : 不管在单线程还是多线程，有且仅有一个实例对象
 *
 * @author lingb
 * @date 2019.03.06 22:47
 */
public class SingletonDemo {

    private SingletonDemo() {}

    /**
     * 双重检验方式（常用）
     */

    /** 懒汉式加载， voliate 修饰instance 防止JVM 指令重排，保证多线程也能正常运行 */
    private volatile static SingletonDemo instance = null;

    public static SingletonDemo getInstance() {
        // 先判断对象是否被实例化了，若没有则进入锁代码块，反之返回实例对象的引用
        if (null == instance) {
            // 为实例化预留时间
//            Thread.sleep(2000);
            // 类对象加锁
            synchronized (SingletonDemo.class) {
                if (null == instance) {
                     /*
                      instance = new SingletonDemo(); 分三步执行
                      1）为instance 分配栈内存空间
                      2）初始化 instance
                      3）instance 存储SingletonDemo 实例对象的堆内存地址

                      出现问题：
                      由于 JVM 具有指令重排的特性，执行顺序有可能变成 1）-> 3）-> 2） 指令重排在单线程环境下不会出现问题，
                      但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程T1 执行了 1） 和 3），此时线程T2 调用
                      getInstance() 后发现instance 不为空，因此返回instance，但此时instance 还未被初始化

                      解决方案：使用volatile 关键字
                      */
                    instance = new SingletonDemo();
                }
            }
        }

        return instance;
    }


    /**
     * 静态内部类方式
     */

    private static class StaticInnerClass {
        private static SingletonDemo instance1 = new SingletonDemo();
    }

    public static SingletonDemo getInstance1() {
        return StaticInnerClass.instance1;
    }


    /**
     * 静态代码块方式
     */
    private static SingletonDemo instance2 = null;

    static {
        instance2 = new SingletonDemo();
    }

    public static SingletonDemo getInstance2() {
        return instance2;
    }


    /**
     * 枚举类方式
     */
    public enum EnumInnerClass {
        instanceFactory;
        private SingletonDemo instance3 = null;
        private EnumInnerClass() {}

        public SingletonDemo getInstance3() {
            return instance3;
        }
    }

    public static SingletonDemo getInstance3() {
        return EnumInnerClass.instanceFactory.getInstance3();
    }
}
