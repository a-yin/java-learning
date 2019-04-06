package com.lingb.mystudy.datastructure.day07;

import java.math.BigInteger;

/**
 * HashTable: 哈希表
 *
 * Created by lingb on 2018/9/3
 */
public class HashTable2 {

    /**
     * 底层实现是链表数组
     */
    private LinkList[] arr;

    /**
     * 默认构造方法
     */
    public HashTable2() {
        arr = new LinkList[100];
    }

    /**
     * 带参数的构造方法
     *
     * @param maxSize
     */
    public HashTable2(int maxSize) {
        arr = new LinkList[maxSize];
    }


    /**
     * 插入: 链地址法
     *
     * @param student
     */
    public void insert(Student student) {
        // 获取关键字
        String key = student.getKey();
        int hashVal = hashCode(key);
        //
        if (arr[hashVal] == null) {
            arr[hashVal] = new LinkList<>();
        }

        arr[hashVal].insertHead(student);

    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public Student find(String key) {
        int hashVal = hashCode(key);
        return (Student) arr[hashVal].find(key).data;
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public Student delete(String key) {
        int hashVal = hashCode(key);
        return (Student) arr[hashVal].delete(key).data;
    }


    /**
     * 显示
     *
     * @param key
     */
    public void display(String key) {
        int hashVal = hashCode(key);
        arr[hashVal].display();
    }


    /**
     * 字符串key
     *
     * @param key
     * @return
     */
    public int hashCode(String key) {
//        int hashVal = 0;

        // 将字母转换成ASCII码相加
//        for (int i = key.length() - 1; i >= 0; i--) {
//            // 从后往前取出每个字母
//            int letter = key.charAt(i) - 96;
//            hashVal += letter;
//        }

        // 幂的连乘
//        int pow27 = 1;
//        for (int i = key.length() - 1; i >= 0; i--) {
//            int letter = key.charAt(i) - 96;
//            hashVal += letter * pow27;
//            pow27 *= 27;
//        }

        // 压缩可选值
//        return  hashVal % students.length;

        // 优化int型 hashVal（长度有限）
        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;

            hashVal = hashVal.add(new BigInteger(String.valueOf(letter)).multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }

        // 压缩可选值
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }

}

















