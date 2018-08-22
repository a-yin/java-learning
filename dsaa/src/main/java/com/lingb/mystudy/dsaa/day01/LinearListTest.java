package com.lingb.mystudy.dsaa.day01;

import org.junit.Test;

/**
 * Created by lingb on 2018/8/21
 */
public class LinearListTest {
    
    @Test
    public void test1() throws Exception {

        MyOrderLinearList arr = new MyOrderLinearList();
        arr.insert(9);
        arr.insert(2);
        arr.insert(3);
        arr.insert(5);
        arr.insert(7);
        arr.display();

        // 返回有序线性表的index 值，而非插入的顺序
        System.out.println(arr.binarySearch(7));
    }
    
    @Test
    public void test() {
        MyLinearList<Integer> array = new MyLinearList<>();
        array.insert(21);
        array.insert(22);
        array.insert(12);
        array.insert(33);
        array.insert(45);
        array.insert(88);
        array.insert(99);
        array.display();

        System.out.println(array.find(100));
        System.out.println(array.get(1));

        array.delete(0);
        array.display();
        array.update(1, 54);
        array.display();
    }

}
