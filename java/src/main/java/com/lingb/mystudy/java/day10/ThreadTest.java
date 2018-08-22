package com.lingb.mystudy.java.day10;

import org.junit.Test;

/**
 * 多线程，即多个线程执行
 * 两种方式创建线程：1）继承Thread 2）实现Runnable接口
 * <p>
 * Created by lingb on 2018/7/18
 */
public class ThreadTest {


    /**
     * Thread类常用的方法：
     * void start():  启动线程，并执行对象的run()方法
     * run():  线程在被调度时执行的操作
     * String getName():  返回线程的名称
     * void setName(String name):设置该线程名称
     * static currentThread(): 返回当前线程对象的引用
     * static  void  yield()：线程让步，暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程，若队列中没有同优先级的线程，忽略此方法
     * join() ：当某个程序执行流中调用其他线程的 join() 方法时，调用线程将被阻塞，直到 join() 方法加入的 join 线程执行完为止 低优先级的线程也可以获得执行
     * static  void  sleep(long millis)：(指定时间:毫秒) 显式令当前活动线程在指定时间段内放弃对CPU控制,使其他线程有机会被执行,时间到后重排队。抛出InterruptedException异常
     * stop(): 强制线程生命期结束
     * boolean isAlive()：返回boolean，判断线程是否还活着
     */

    @Test
    public void test1() {
        SubThread st = new SubThread();
        st.setName("sub...");
        st.start();
        Thread.currentThread().setName("---------main");
        for (int i = 0; i < 20; i++) {
            System.out.println("main...");
//           if (i % 5 == 0) {
//               Thread.yield();
//           }
            if (i == 5) {
                try {
                    st.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(st.isAlive());
    }


    @Test
    public void test() {
        SubThread st = new SubThread();
        st.start();
        System.out.println("main...");
        Runnable rn = new RunnableThread();
        Thread thread = new Thread(rn);
        thread.start();

    }

}

