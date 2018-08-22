package com.lingb.mystudy.java.day03;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理之 cglib 面向类
 * 实现机制：
 * 1、动态创建一个类
 * 2、该类继承被代理类，即成为了被代理类的子类
 * 3、
 *
 * Created by lingb on 2018/7/13
 */
public class SimpleCGLibDemo {
    static class HelloServiceImpl {
        public void sayHello() {
            System.out.println("hello");
        }
    }
    static class SimpleInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering " + method.getName());
            // 被代理的父类
            Object result = methodProxy.invokeSuper(obj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }

        /**
         * 获取代理对象，并可以安全地转换成被代理的类
         *
         * @param   [cls]
         * @return  T
         */
        private static <T> T getProxy(Class<T> cls) {
            Enhancer enhancer = new Enhancer();
            // 设置被代理的类，即被代理的父类
            enhancer.setSuperclass(cls);
            // 设置被代理类的public 非final方法被调用时的代理类（重写了被代理类所有public非final方法）
            // 即回调函数，就是为了执行public Object intercept() 方法的.
            enhancer.setCallback(new SimpleInterceptor());
            return (T) enhancer.create();
        }
    }

    public static void main(String[] args) {
        HelloServiceImpl proxyService = SimpleInterceptor.getProxy(HelloServiceImpl.class);
        proxyService.sayHello();
    }
}
