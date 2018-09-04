package com.lingb.mystudy.dsaa.day07;

/**
 * 学生实体类
 *
 * Created by lingb on 2018/9/3
 */
public class Student {

    /**
     * key
     */
//    private int key;
    private String key;

    /**
     * name
     */
    private String name;

    /**
     * constructor
     *
     * @param key
     * @param name
     */
//    public Student(int key, String name) {
//        this.key = key;
//        this.name = name;
//    }
    public Student(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
