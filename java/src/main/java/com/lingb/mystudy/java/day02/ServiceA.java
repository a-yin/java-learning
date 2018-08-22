package com.lingb.mystudy.java.day02;

/**
 * Created by lingb on 2018/7/12
 */
public class ServiceA {

    // ServiceA 对ServiceB 依赖
    @SimpleInject
    private ServiceB b;

    public ServiceA(){
    }

    public void callB(){
        b.action();
    }

}
