package com.lingb.mystudy.dsaa.day04;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by lingb on 2018/8/23
 */
public class LinkListTest {

    
    public static void main(String[] args) {

        LinkList<Integer> linkList = new LinkList<>();
        Scanner sc = new Scanner(System.in);

        // 添加链表结点
        linkList.insertTail(sc.nextInt());
        linkList.insertTail(sc.nextInt());
        linkList.insertTail(sc.nextInt());
        linkList.insertTail(sc.nextInt());
        linkList.insertTail(sc.nextInt());
        // 删除链表指定data的结点
        linkList.delete(12);
        // 打印链表
        linkList.display();
        // 打印链表长度
        System.out.println(linkList.size());
    }

    
    @Test
    public void test5() {
        DoubleLinkList<Integer> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.insertTail(12);
        doubleLinkList.insertTail(21);
        doubleLinkList.insertTail(22);
        doubleLinkList.insertTail(32);
        doubleLinkList.insertTail(54);
        doubleLinkList.display();

        doubleLinkList.deleteTail();
        doubleLinkList.display();
      
    }
    
    @Test
    public void test4() {
        DoubleLinkList<Integer> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.insertHead(12);
        doubleLinkList.insertHead(21);
        doubleLinkList.insertHead(22);
        doubleLinkList.insertHead(32);
        doubleLinkList.insertHead(54);
        doubleLinkList.display();

        doubleLinkList.deleteHead();
        doubleLinkList.display();
    }
    
    @Test
    public void test3() {
        DoubleEndLinkList<Integer> doubleEndLinkList = new DoubleEndLinkList<>();
        doubleEndLinkList.insertTail(12);
        doubleEndLinkList.insertTail(21);
        doubleEndLinkList.insertTail(22);
        doubleEndLinkList.insertTail(32);
        doubleEndLinkList.insertTail(54);

        doubleEndLinkList.display();

        doubleEndLinkList.deleteTail();
        doubleEndLinkList.display();
    }


    @Test
    public void test2() {
        DoubleEndLinkList<Integer> doubleEndLinkList = new DoubleEndLinkList<>();
        doubleEndLinkList.insertHead(12);
        doubleEndLinkList.insertHead(21);
        doubleEndLinkList.insertHead(22);
        doubleEndLinkList.insertHead(32);
        doubleEndLinkList.insertHead(54);

        doubleEndLinkList.display();

        doubleEndLinkList.deleteHead();
        doubleEndLinkList.display();

    }

    @Test
    public void test1() {

        LinkList<Integer> linkList = new LinkList<>();

        // 添加链表结点
        linkList.insertTail(12);
        linkList.insertTail(21);
        linkList.insertTail(22);
        linkList.insertTail(32);
        linkList.insertTail(54);
        // 删除链表指定data的结点
        linkList.delete(12);
        // 打印链表
        linkList.display();
        // 打印链表长度
        System.out.println(linkList.size());

        // 删除链表结点
        linkList.deleteTail();
        linkList.deleteTail();
        linkList.deleteTail();
        linkList.deleteTail();
        linkList.deleteTail();
        System.out.println(linkList.size());
        linkList.display();
    }
    
    @Test
    public void test() {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insertHead(12);
        linkList.insertHead(21);
        linkList.insertHead(22);
        linkList.insertHead(32);
        linkList.insertHead(54);
        linkList.delete(12);
        System.out.println(linkList.size());

        linkList.display();
        linkList.deleteHead();
        linkList.deleteHead();
        linkList.deleteHead();
        linkList.deleteHead();
        linkList.deleteHead();
        System.out.println(linkList.size());
        linkList.display();



    }
}
