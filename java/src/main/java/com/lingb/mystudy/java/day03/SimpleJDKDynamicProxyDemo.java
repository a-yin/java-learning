package com.lingb.mystudy.java.day03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理之Java SDK 面向接口代理
 * 实现机制：
 * 1、动态创建一个类
 * 2、该类实现被代理类，成为被代理类的实现类
 * 3、
 *
 * Created by lingb on 2018/7/13
 */
public class SimpleJDKDynamicProxyDemo {
    /**
     * 共同接口HelloService
     */
    static interface HelloService {
        void sayHello();
    }

    /**
     * 实际服务对象 HellServiceImpl
     */
    static class HelloServiceImpl implements HelloService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    /**
     * 共同接口WorldService
     */
    static interface WorldService {
        void sayHello();
    }

    /**
     * 实际服务对象 WorldServiceImpl
     */
    static class WorldServiceImpl implements WorldService {

        @Override
        public void sayHello() {
            System.out.println("world");
        }
    }

    /**
     * default（省略）静态内部类
     */
    static class SimpleInvocationHandler implements InvocationHandler {
        // 声明成员变量 obj
        private Object obj;
        // 初始化实际服务对象
        public SimpleInvocationHandler(Object obj) {
            this.obj = obj;
        }

        /**
         * 调用所有代理接口所有方法
         *
         * @param   proxy 代理对象本身
         * @param   method 代理方法
         * @param   args 代理方法参数
         * @return  java.lang.Object
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());

            Object result = method.invoke(obj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }

        /**
         * 获取代理对象
         *
         * @param   [intf, obj]
         * @return  T
         */
        private static <T> T getProxy(Class<T> intf, T obj) {
            /**
             * public static Object newProxyInstance(ClassLoader loader,
             *                                       Class<?>[] interfaces,
             *                                       InvocationHandler h)
             *       throws IllegalArgumentException{...}
             *  它有三个参数：
             *  1）ClassLoader loader 类加载器
             *  2）Class<?>[] interfaces 代理类要实现的接口数组
             *  3）InvocationHandler h  InvocationHandler是个接口，只定义了一个方法invoke，对代理接口所有方法的调用都会转给该方法
             */
            return  (T) Proxy.newProxyInstance(intf.getClassLoader(),
                    new Class<?>[] {intf}, new SimpleInvocationHandler(obj) );
        }
    }

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService helloProxy = SimpleInvocationHandler.getProxy(HelloService.class, helloService);
        helloProxy.sayHello();
        WorldService worldService = new WorldServiceImpl();
        WorldService worldProxy = SimpleInvocationHandler.getProxy(WorldService.class, worldService);
        worldProxy.sayHello();
    }
}
