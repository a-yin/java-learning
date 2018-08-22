package com.lingb.mystudy.java.day05.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection 接口是 List、Set 和 Queue 接口的父接口，
 * 该接口里定义的方法既可用于操作 Set 集合，也可用于操作 List 和 Queue 集合
 *
 * Created by lingb on 2018/7/16
 */
public class CollectionTest {

    /**
     * boolean add(E e) 添加e
     * boolean addAll(Collection<? extends E> c) 将指定 collection 中的所有元素都添加到此 collection 中（可选操作）。
     * void clear() 移除此 collection 中的所有元素（可选操作）。
     * boolean contains(Object o) 如果此 collection 包含指定的元素，则返回 true。
     * boolean containsAll(Collection<?> c) 如果此 collection 包含指定 collection 中的所有元素，则返回 true。
     * boolean equals(Object o) 比较此 collection 与指定对象是否相等。
     * int hashCode() 返回此 collection 的哈希码值。
     * boolean isEmpty() 如果此 collection 不包含元素，则返回 true。
     * Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器。
     * boolean remove(Object o) 从此 collection 中移除指定元素的单个实例，如果存在的话（可选操作）
     * boolean removeAll(Collection<?> c) 移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）。
     * boolean retainAll(Collection<?> c) 仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。
     * int size() 返回此 collection 中的元素数。
     * Object[] toArray() 返回包含此 collection 中所有元素的数组。
     * <T> T[]toArray(T[] a) 返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同。
     *
     */
    @Test
    public void testCollection() {
        Collection<Object> coll = new ArrayList<>();
        // 是否为空
        System.out.println(coll.isEmpty());

        // 添加单个元素
        coll.add(1);
        coll.add(10);
        coll.add(100);

        System.out.println(coll);

        Collection<String> coll1 = new ArrayList<>();
        coll1.add("1");
        coll1.add("01");
        coll1.add("001");

        // 将指定collection 中的所有元素都添加到此 collection 中
        // [1, 10, 100, 1, 01, 001, [1, 01, 001]]
        coll.addAll(coll1);
        System.out.println(coll);

//        // [1, 10, 100, [1, 01, 001]]
//        coll.add(coll1);
//        System.out.println(coll);

        // 容量大小
        int size = coll.size();
        System.out.println(size);

        // 是否包含指定元素
        boolean flag = coll.contains(001);
        System.out.println("001 " + flag);

        // 是否包含指定 collection
        boolean flag1 = coll.containsAll(coll1);
        System.out.println("coll1 " + flag1);

        // 仅保留此 collection 中那些也包含在指定 collection 的元素
        boolean flag4 = coll.retainAll(coll);
        System.out.println(coll);

        // 删除指定元素
        boolean flag2 = coll.remove("001");
        System.out.println(flag2);

        // 删除指定 collection
        coll.addAll(coll1);
        boolean flag3 = coll.removeAll(coll1);
        System.out.println(flag3);

        // 返回包含此 collection 中所有元素的数组
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        // 返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同。
        Integer[] arr1 = coll.toArray(new Integer[coll.size()]);
        System.out.println(Arrays.toString(arr1));

        // 迭代器，遍历容器类
        Iterator<Object> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println("###" + it.next());
        }

        // 增强for循环，不影响容器类对象coll
        for (Object o : coll) {
            System.out.println("---" + o);
        }

        // 清空容器
        System.out.println(coll1);
        coll1.clear();
        System.out.println(coll1);
    }
}
