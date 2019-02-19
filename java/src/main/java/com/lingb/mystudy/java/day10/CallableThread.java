package com.lingb.mystudy.java.day10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lingb on 2018-11-29
 */
public class CallableThread implements Callable <String>{


    /**
     * task.get() 怎样拿到返回值
     *
     * FutureTask run() > Callable() call() > FutureTask set() > FutureTask get()
     *

     FutureTask run() 方法

     public void run() {
     if (state != NEW ||
     !UNSAFE.compareAndSwapObject(this, runnerOffset,
     null, Thread.currentThread()))
     return;
     try {
     Callable<V> c = callable;
     if (c != null && state == NEW) {
     V result;
     boolean ran;
     try {
     result = c.call();
     ran = true;
     } catch (Throwable ex) {
     result = null;
     ran = false;
     setException(ex);
     }
     if (ran)
     set(result);
     }
     } finally {
     // runner must be non-null until state is settled to
     // prevent concurrent calls to run()
     runner = null;
     // state must be re-read after nulling runner to prevent
     // leaked interrupts
     int s = state;
     if (s >= INTERRUPTING)
     handlePossibleCancellationInterrupt(s);
     }
     }
     */


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new CallableThread());
        new Thread(task).start();

        System.out.println(task.get());

    }


    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
