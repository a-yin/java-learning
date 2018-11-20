package com.lingb.mystudy.java.day03;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理之Java SDK 面向接口代理
 * 实现机制：
 * 1、运行时动态创建一个代理类，通过Proxy.newProxyInstance(...)实现
 * 2、该类实现共同接口，即成为实现类
 * 3、创建一个类实现InvocationHandler接口，实现invoke()方法（可以编写扩展代码、实现扩展功能，如日志打印、事务管理、权限管理、AOP等）
 * 4、代理类执行方法并将业务方法传递给method，method调用invoke()方法
 * <p>
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
         * @param proxy  代理对象本身
         * @param method 代理方法
         * @param args   代理方法参数
         * @return java.lang.Object
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
         * @param [intf, obj]
         * @return T
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

            // 生成代理类($Proxy0 继承Proxy类实现HelloService接口) --> 获取构造器 --> 生成代理对象
            return (T) Proxy.newProxyInstance(intf.getClassLoader(),
                    new Class<?>[]{intf}, new SimpleInvocationHandler(obj));
        }
    }


    /**
     * 获取代理类的Class文件（字节码）
     *
     * @param clazz
     * @param path
     * @throws IOException
     */
    public static void getProxyClassFile(Class<?>[] interfaces, String path) throws IOException {
        // 第一方法
        // 从源码中得知，设置这个值，可以把生成的代理类，输出出来。
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        // 第二种方法
        FileOutputStream fos = null;
        try {
            byte[] proxyClass = ProxyGenerator.generateProxyClass("$Proxy0", interfaces);
            fos = new FileOutputStream(path);
            fos.write(proxyClass);
            fos.flush();

        } finally {
            fos.close();
        }
    }


    public static void main(String[] args) throws IOException {

        HelloService helloService = new HelloServiceImpl();
        SimpleInvocationHandler handler = new SimpleInvocationHandler(helloService);
        // $Proxy0 继承Proxy类实现HelloService接口，即可以转换HelloService 类型的原因
        HelloService helloProxy = SimpleInvocationHandler.getProxy(HelloService.class, helloService);
        helloProxy.sayHello();

//        WorldService worldService = new WorldServiceImpl();
//        WorldService worldProxy = SimpleInvocationHandler.getProxy(WorldService.class, worldService);
//        worldProxy.sayHello();

        HelloService helloProxy1 = (HelloService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), helloService.getClass().getInterfaces(), handler);
        helloProxy1.sayHello();

        String path = "G:/DevWorkSpace/IDEA/mystudy/java/target/classes/com/lingb/mystudy/java/day03/$Proxy0.class";
        getProxyClassFile(helloService.getClass().getInterfaces(), path);


        // 都是使用默认的类加载器，即sun.misc.Launcher$AppClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(HelloService.class.getClassLoader());
        System.out.println(helloService.getClass().getClassLoader());
    }
}
