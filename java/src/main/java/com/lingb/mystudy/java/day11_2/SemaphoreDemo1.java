package com.lingb.mystudy.java.day11_2;

import java.util.concurrent.Semaphore;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.23 21:34
 */
public class SemaphoreDemo1 {

    /**
     * 多个线程顺序打印问题
     * 三个线程分别打印A，B，C，要求这三个线程一起运行，打印n次，输出形如“ABCABCABC…”的字符串
     *
     * 思路：（比较简单、容易理解的解决方案，使用Semaphore）
     * 三个线程对应三个Semaphore，三个Semaphore维护一个permit
     * 当前线程通过对应的Semaphore获取permit，执行打印，并通过下一个线程对应的Semaphore释放permit
     * 类似于permit在当前的线程对应的Semaphore中，传递到了下一个线程对应的Semaphore中
     * 下一个线程通过对应的Semaphore获取permit，
     * 即  A.acquire(); -> System.out.print("A") -> B.acquire(); -> System.out.print("B"); -> C.acquire(); -> System.out.print("C");
     * 继续执行……循环10次
     *
     * 小结：每个线程使用一个Semaphore，一个Permit在不同的Semaphore之间循环传递，当前线程消费完Permit后，
     * 无法立即进行下一次打印，而下一个线程使用的Semaphore刚好获取到了Permit，从而使线程可以交替执行。
     * 不需要额外的线程轮流状态state字段。代码简洁，效率高
     */



    /** 循环打印次数 */
    private int times;

    /** 以A开始的信号量,初始信号量数量为1 */
    private Semaphore semaphoreA = new Semaphore(1);
    /** B、C信号量, A完成后开始,初始信号数量为0 */
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public SemaphoreDemo1(int times) {
        this.times = times;
    }

    private void print(String name, Semaphore current, Semaphore next){
        for (int i = 0; i < times; i++) {
            try {
                // 当前线程获取1个信号量并执行，其它线程信号量为0 进入阻塞状态
                current.acquire();

                System.out.print(name);

                // 下一线程释放信号，下一线程的信号量加1，阻塞 -> 执行
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    private void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    private void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    public static void main(String[] args) {
        SemaphoreDemo1 semaphoreDemo1 = new SemaphoreDemo1(10);

        // 非静态方法引用  x::toString   和() -> x.toString() 是等价的
        new Thread(semaphoreDemo1::printA).start();
        new Thread(semaphoreDemo1::printB).start();
        new Thread(semaphoreDemo1::printC).start();

       /* new Thread(() -> semaphoreDemo1.printA()).start();
        new Thread(() -> semaphoreDemo1.printB()).start();
        new Thread(() -> semaphoreDemo1.printC()).start();*/

    }
}
