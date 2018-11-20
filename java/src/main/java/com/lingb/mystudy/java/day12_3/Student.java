package com.lingb.mystudy.java.day12_3;

import java.io.Serializable;

/**
 * java.io.Serializable 可序列化接口：没有需要被实现的public abstract 方法，即标识接口
 *
 * Created by lingb on 2018/8/14
 */
public class Student implements Serializable {

    // 只要实现Serializable接口，系统默认提供一个serialVersionUID，但无法保证每次更新的serialVersionUID 相同，即不能被识别

    // 于是自己重写（覆盖）系统提供的serialVersionUID 这样子能够保证无论怎样更新，都能识别出同一实例对象
    final static long serialVersionUID = 1L;

    private String Id;
    private String name;
    private Integer age;


    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "你好！我是" + name;
    }
}

