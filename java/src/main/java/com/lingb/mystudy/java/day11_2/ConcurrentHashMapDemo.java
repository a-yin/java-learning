package com.lingb.mystudy.java.day11_2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lingb on 2018/7/30
 */
public class ConcurrentHashMapDemo {

    public static void test() {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("0", "AA");
        map.put("1", "BB");

        Thread t = new Thread() {
            @Override
            public void run() {
                for (Map.Entry<String,String> entry : map.entrySet()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(entry.getKey() + "," + entry.getValue());
                }
            }
        };

        t.start();
        try {
            // 确保线程t在主线程main前启动
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map.put("2", "CC");
        
    }

    public static void main(String[] args){
        test();
    }
}
