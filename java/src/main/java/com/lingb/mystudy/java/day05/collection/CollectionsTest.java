package com.lingb.mystudy.java.day05.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 辅助容器类的工具类Collections
 *
 * Created by lingb on 2018/7/15
 */
public class CollectionsTest {

    /**
     * Collections 是一个操作 Set、List 和 Map 等集合的工具类
     * Collections 中提供了大量方法对集合元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
     *
     * 排序操作：工具类.静态方法
     * reverse(List)：反转 List 中元素的顺序
     * shuffle(List)：对 List 集合元素进行随机排序
     * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */
    @Test
    public void testCollections() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(2);
        System.out.println("操作前 " + integers);

        // 反转
        Collections.reverse(integers);
        System.out.println("反转后 " + integers);

        // 随机排序
        Collections.shuffle(integers);
        System.out.println("随机排序后 " + integers);

        // 升序
        Collections.sort(integers);
        System.out.println("升序后 " + integers);

        // 交换
        Collections.swap(integers, 0, 2);
        System.out.println("交换后 " + integers);
    }
    
    /**
     * 最大最小替换操作：工具类.静态方法
     * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest, List src) : 将src的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
     * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void testCollections1() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(3);
        integers.add(2);
        System.out.println("操作前 " + integers);

        // 最大值
        System.out.println(Collections.max(integers));

        // 最小值
        System.out.println(Collections.min(integers));

        // 出现次数
        System.out.println(Collections.frequency(integers, 1));

        // 复制
        // 错误实现1
//        List integers1 = new ArrayList();
        // 错误实现2
//        List integers1 = new ArrayList(integers.size());
        // 正确实现
        // 注： List<Integer> integers1 = Arrays.asList(new Object[integers.size()]);  报错【小容器装大容器】
        //      List<Object> integers1 = Arrays.asList(new Integer[integers.size()]);  OK可以【大容器装小容器】
        // 我猜想底层实现原理：asList()方法 使用了E[] a 指向了传入的数组引用或者数组元素，再以a 参数返回 new ArrayList() 对象实例
//        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4);
//        List<Integer> integers2 = Arrays.asList(new Integer[]{1, 2, 3, 4});
        List<Integer> integers2 = Arrays.asList(new Integer[integers.size()]);
        Collections.copy(integers2, integers);
        System.out.println("复制后 " + integers2);

        // 通过synchronizedList 保证List 线程安全
        List<Integer> integers3 = Collections.synchronizedList(integers);
        System.out.println("synchronizedList 后" + integers3);
    }
}
