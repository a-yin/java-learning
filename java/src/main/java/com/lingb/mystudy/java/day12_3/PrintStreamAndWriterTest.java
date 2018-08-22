package com.lingb.mystudy.java.day12_3;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * 标准打印（输出）流：PrintStream 和 PrintWriter
 *
 * Created by lingb on 2018/8/14
 */
public class PrintStreamAndWriterTest {
    
    @Test
    public void test() {
        /**
            public final static PrintStream out = null;
            怎么理解 out为null，却能调用println() 方法？（解答见下）
            VM 调用了initializeSystemClass() 方法初始化

        */
//         /* register the natives via the static initializer.
//         *
//         * VM will invoke the initializeSystemClass method to complete
//         * the initialization for this class separated from clinit.
//         * Note that to use properties set by the VM, see the constraints
//         * described in the initializeSystemClass method.
//         */
//        private static native void registerNatives();
//        static {
//            registerNatives();
//        }

        PrintStream ps = System.out;
        System.out.println("Hello World!");
        ps.println("Hello World!");
    }
    
    @Test
    public void test1() throws FileNotFoundException {

        PrintStream ps1 = new PrintStream(new FileOutputStream("G:/DevWorkSpace/IDEA/mystudy/hello5.txt", true));
        System.setOut(ps1);
        String str = "Hello, 123, 甲鸟~~~";
        // 打印到指定的文件，即日志
        System.out.println(str);
//        ps1.append(str);
        System.out.println("before：" + LocalDateTime.now().withNano(0));
        log();
        System.out.println("after：" + LocalDateTime.now().withNano(0));
        ps1.close();

    }


    private String log() {
        return "log...";
    }

}
