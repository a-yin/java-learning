package com.lingb.mystudy.dp.day01;

/**
 * 单例模式
 *
 * Created by lingb on 2018-11-28
 */
public class SingletonDemo {


    public static void main(String[] args) {
         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SingletonDemo.getInstance().hashCode());
            }
        }).start();

         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(SingletonDemo.getInstance().hashCode());
            }
        }).start();
    }

    private volatile static SingletonDemo instance;
    private SingletonDemo() {}
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

}
