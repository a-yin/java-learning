package com.lingb.mystudy.java.day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.18 23:02
 */
public class IteratorTest {

    /**
     * 问题: foreach中移除(remove)元素
     * https://blog.csdn.net/tmplayer/article/details/79593026
     *
     * 或者 在使用迭代器遍历集合时,为何不能使用集合的remove方法？
     *
     *
     * 分析：若在增强for 循环里调用集合的add/remove/clear 等改变集合结构的操作
     * modCount表示集合对象生成被修改次数（集合 + 迭代器），当add/remove/clear 等改变集合结构的操作时，都会自增 1
     * 而expectedModCount表示迭代器对象期望集合被修改的次数，iterator建立时modCount被赋值给了expectedModCount，
     * expectedModCount 没有改变，即 modCount != expectedModCount 抛出ConcurrentModificationException
     *
     * final void checkForComodification() {
     *    if (modCount != expectedModCount)
     *    throw new ConcurrentModificationException();
     * }
     *
     * 具体流程可javap 反编译分析
     *
     * 结论：要想在集合遍历的过程中add/remove/clear 等改变集合结构的操作，就应使用迭代器相关的方法
     * 迭代的方法会修正expectedModCount = modCount, 以及cursor 的值，避免了上述的异常
     *
     */


    /**
     * 迭代器
     */
    public static void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            if (i.equals(1)) {
                // 迭代器的remove()与集合的remove(),最大的不同是迭代器的remove()包括对cursor和expectedModCount的修正
                itr.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * 普通for 循环
     */
    public static void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(1)) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);
    }


    /**
     * 增强for 循环
     */
    public static void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for (Integer i : list) {
            if (i.equals(1)) {
                System.out.println(111);
                list.remove(i);
            }

            // 不执行，因为此时的cursor = size = 1，即hasNext() 返回 false, 跳出迭代器循环
            if (i.equals(2)) {
                System.out.println(222);
                list.remove(i);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        for (Integer i : list1) {
            // 报错Exception in thread "main" java.util.ConcurrentModificationException
            // 因为此时的cursor = 2，size = 1，即hasNext() 返回 true, 不会跳出迭代器循环，
            // 继续调用next(), 执行checkForComodification(),
            // 发现 expectedModCount != modCount（这是根本原因！！），所以抛出上述异常
            // list1.remove 执行的是ArrayList的remove()，modCount在每一次循环值会发生改变，而expectedModCount并没有发生
            if (i.equals(2)) {
                list1.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        // Exception in thread "main" java.util.ConcurrentModificationException
//        test();

        // 正常
//        test1();

        // 正常
        test2();

    }
}
