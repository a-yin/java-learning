package com.lingb.mystudy.java.day10;

/**
 * 方式一：继承Thread
 * 1)  定义子类继承Thread类。
 * 2)  子类中重写Thread类中的run方法。
 * 3)  创建Thread子类对象，即创建了线程对象。
 * 4)  调用线程对象start方法：启动线程，调用run方法。
 *
 * Created by lingb on 2018/7/18
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("before###");
            // 休眠1秒（即阻塞1秒）
            Thread.sleep(1000);
            System.out.println("after---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("SubThread..." + i);

        }
    }


}
/*

interface AA {
}

interface BB {
}

class CC {
}

class DD {
}

enum EE {
}

enum FF {
}*/
