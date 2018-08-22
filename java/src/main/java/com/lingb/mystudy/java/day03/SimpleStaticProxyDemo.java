package com.lingb.mystudy.java.day03;

/**
 * 静态代理Demo
 * 实际对象和代理实现同一的接口，Demo中共同的接口HelloService, 实际对象 HelloServiceImpl，代理TraceProxy
 *
 * Created by lingb on 2018/7/13
 */
public class SimpleStaticProxyDemo {
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
     * 代理对象 TraceProxy
     */
    static class TraceProxy implements HelloService {
        // 声明成员变量 helloService
        private HelloService helloService;
        // 初始化实际服务对象
        public TraceProxy(HelloService helloService) {
            this.helloService = helloService;
        }

        @Override
        public void sayHello() {

            System.out.println("entering sayHello");

            // 实际服务对象调用 sayHello()方法
            helloService.sayHello();

            System.out.println("leaving sayHello");
        }

    }

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        TraceProxy traceProxy = new TraceProxy(helloService);
        traceProxy.sayHello();

        new TraceProxy(new HelloServiceImpl()).sayHello();
    }
}
