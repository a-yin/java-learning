package com.lingb.mystudy.java.day05.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * List 接口除了继承Collection 接口，还提供了根据索引操作元素的接口
 *
 * Created by lingb on 2018/7/16
 */
public class ListTest {
    
    /**
     * List 集合里添加了一些根据索引来操作集合元素的方法
     * void add(int index, Object ele)
     * boolean addAll(int index, Collection eles)
     * Object get(int index)
     * int indexOf(Object obj)
     * int lastIndexOf(Object obj)
     * Object remove(int index)
     * Object set(int index, Object ele)
     * List subList(int fromIndex, int toIndex)
     */
    @Test
    public void testList() {
        List<Integer> integers = new ArrayList<>(101);
        System.out.println(integers.size());
        // 根据index 插入元素
        // 错误写法，ArrayList 连续存储的，index不可跳跃
        // 报错java.lang.IndexOutOfBoundsException: Index: 10, Size: 1
//        integers.add(0, 1);
//        integers.add(10, 10);
//        integers.add(100, 100);
        // 正确写法
        integers.add(0, 1);
        integers.add(1, 10);
        integers.add(2, 100);
        System.out.println(integers);

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(123);
        integers1.add(321);
        integers1.add(213);
        integers1.add(123);
        integers1.add(123);

        // 根据index 插入collection 所有的元素
        integers.addAll(integers1);
        System.out.println("###" + integers);

        integers.addAll(0, integers1);
        System.out.println("---" + integers);

        // 返回指定元素第一次出现的index
        int index = integers.indexOf(123);
        System.out.println(index);

        // 返回指定元素最后一次出现的index
        int lastIndex = integers.lastIndexOf(123);
        System.out.println(lastIndex);

        // 根据index 删除指定元素
        integers.remove(6);
        System.out.println(integers);

        // 根据index 更新指定元素
        integers.set(0, 101);
        System.out.println(integers);

        // 根据index 获取指定元素
        Integer i = integers.get(0);
        System.out.println(i);

        // 从list 截取子list
        // 注：this.size = toIndex - fromIndex;
        // 即获取前三个元素，（0, 3） 其他同理即可
        List<Integer> integers2 = integers.subList(0, 3);
        System.out.println(integers2);


    }
}
