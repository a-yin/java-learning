package com.lingb.mystudy.datastructure.day07;

import java.math.BigInteger;

/**
 * HashTable: 哈希表
 *
 * Created by lingb on 2018/9/3
 */
public class HashTable {

    /**
     * 底层实现是数组
     */
    private Student[] students;

    /**
     * 默认构造方法
     */
    public HashTable() {
        students = new Student[100];
    }

    /**
     * 带参数的构造方法
     *
     * @param maxSize
     */
    public HashTable(int maxSize) {
        students = new Student[maxSize];
    }


    /**
     * 插入
     *
     * @param student
     */
    public void insert(Student student) {
//        students[student.getKey()] = student;
        students[hashCode(student.getKey())] = student;
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
//    public Student find(int key) {
//        return students[key];
//    }
    public Student find(String key) {
        return students[hashCode(key)];
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
        return hashVal.mod(new BigInteger(String.valueOf(students.length))).intValue();
    }

}

















