package com.lingb.mystudy.dsaa.day01;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by lingb on 2018/9/13
 */
public class MyArrayListTest {

    @Test
    public void test1() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0);
        myArrayList.add(7);
        myArrayList.add(2);
        myArrayList.add(8);

        Iterator<Integer> iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }


        for (Integer integer : myArrayList) {
            System.out.println(integer);
        }
    }
    
    @Test
    public void test() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add("aa");
        myArrayList.add('a');
        myArrayList.add(1,1.1f);

        Iterator iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object o : myArrayList) {
            System.out.println(o);
        }
    }
}
