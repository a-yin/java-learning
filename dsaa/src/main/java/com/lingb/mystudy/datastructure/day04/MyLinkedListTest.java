package com.lingb.mystudy.datastructure.day04;

import org.junit.Test;

/**
 * Created by lingb on 2018/9/13
 */
public class MyLinkedListTest {

    @Test
    public void test() {
        MyLinkedList<Integer> linkList = new MyLinkedList<>();

        linkList.add(1);
        linkList.add(11);
        linkList.add(111);
        linkList.add(1111);
        linkList.add(11111);

//        Iterator iterator = linkList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (Integer integer : linkList) {
            System.out.println(integer);
        }


    }
}
