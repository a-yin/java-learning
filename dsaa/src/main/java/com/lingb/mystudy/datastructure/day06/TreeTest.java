package com.lingb.mystudy.datastructure.day06;

import org.junit.Test;

public class TreeTest {

    @Test
    public void test1() {
        BinaryTree tree = new BinaryTree();
        tree.insert(10, "AA");
        tree.insert(20, "BB");
        tree.insert(15, "CC");
        tree.insert(3, "DD");
        tree.insert(5, "EE");
        tree.insert(54, "FF");
        tree.insert(32, "GG");

        // 前序遍历
        System.out.println("前序遍历------");
        tree.frontOrder(tree.root);

        // 中序遍历
        System.out.println("中序遍历------");
        tree.inOrder(tree.root);

        // 删除结点
        tree.delete(20);

        // 后序遍历
        System.out.println("后台序遍历------");
        tree.afterOrder(tree.root);

    }


    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();
        tree.insert(10, "AA");
        tree.insert(20, "BB");
        tree.insert(15, "CC");
        tree.insert(3, "DD");

        System.out.println(tree.root.data);
        System.out.println(tree.root.rightChild.data);
        System.out.println(tree.root.rightChild.leftChild.data);
        System.out.println(tree.root.leftChild.data);

        Node node = tree.find(20);
        System.out.println(node.data + "," + node.sData);
    }

}
