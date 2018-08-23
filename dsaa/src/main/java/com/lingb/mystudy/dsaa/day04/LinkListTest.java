package com.lingb.mystudy.dsaa.day04;

import org.junit.Test;

/**
 * Created by lingb on 2018/8/23
 */
public class LinkListTest {

    @Test
    public void test() {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertFirst(12);
        linkList.insertFirst(21);
        linkList.insertFirst(22);
        linkList.insertFirst(32);
        linkList.insertFirst(54);

//        linkList.display();
    }
}
