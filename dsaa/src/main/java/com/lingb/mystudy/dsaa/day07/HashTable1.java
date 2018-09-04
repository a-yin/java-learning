package com.lingb.mystudy.dsaa.day07;

import java.math.BigInteger;

/**
 * HashTable: 哈希表
 *
 * Created by lingb on 2018/9/3
 */
public class HashTable1 {

    /**
     * 底层实现是数组
     */
    private Student[] students;

    /**
     * 默认构造方法
     */
    public HashTable1() {
        students = new Student[100];
    }

    /**
     * 带参数的构造方法
     *
     * @param maxSize
     */
    public HashTable1(int maxSize) {
        students = new Student[maxSize];
    }


    /**
     * 插入
     *
     * @param student
     */
    public void insert(Student student) {
        // 开发地址法
        // 获取关键字
        String key = student.getKey();
        // 关键字所对应的哈希值
        int hashVal = hashCode(key);
        // 判断当前数组索引已经被占用了，而且存储的是一个未被删除的数据，循环往下找，直到找到为止（除非数组全占用了）
        while (students[hashVal] != null && students[hashVal].getName() != null) {
            // 寻找下一个地址
            hashVal++;
            // 取模循环找
            hashVal %= students.length;
        }

        students[hashVal] = student;
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public Student find(String key) {
        int hashVal = hashCode(key);
        while (students[hashVal] != null) {
            if (students[hashVal].getKey().equals(key)) {
                return students[hashVal];

            }
            // 寻找下一个地址
            hashVal++;
            // 取模循环找
            hashVal %= students.length;
        }

        return null;
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public Student delete(String key) {
        int hashVal = hashCode(key);
        while (students[hashVal] != null) {
            if (students[hashVal].getKey().equals(key)) {
                Student student = students[hashVal];
                student.setName(null);
                return student;

            }
            // 寻找下一个地址
            hashVal++;
            // 取模循环找
            hashVal %= students.length;
        }

        return null;
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

















