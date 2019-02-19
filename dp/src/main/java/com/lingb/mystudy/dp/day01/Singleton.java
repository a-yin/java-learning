package com.lingb.mystudy.dp.day01;

/**
 * Created by lingb on 2018-11-28
 */
public class Singleton {


    public static void main(String[] args) {
         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        }).start();

         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        }).start();
    }

    private volatile static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
