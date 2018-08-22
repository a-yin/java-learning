package com.lingb.mystudy.java.day13;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InerAddress 标识网络上的硬件资源，表示互联网协议地址
 *
 * Created by lingb on 2018/8/14
 */
public class InetAddressTest {

    @Test
    public void test() throws UnknownHostException {
        // 没有构造方法（无法实例化对象）

        // 通过成员方法 返回对象
        InetAddress address = InetAddress.getLocalHost();
        // 计算机名字/计算机IP（String表示） lingb/192.168.4.2
        System.out.println(address);
        // 计算机名字 lingb
        System.out.println(address.getHostName());
        // 计算机IP（String表示）IPv4地址 192.168.4.2
        System.out.println(address.getHostAddress());

        // 不推荐使用
        // 字节数组表示 byte范围（0，127)
        byte[] bytes = address.getAddress();
        // [-64, -88, 4, 2]
        System.out.println(Arrays.toString(bytes));
    }


}
