package com.lingb.mystudy.java.day10;

/**
 * Created by lingb on 2018/7/18
 */
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RunnableThread..." + 3*i);
        }
    }
}
