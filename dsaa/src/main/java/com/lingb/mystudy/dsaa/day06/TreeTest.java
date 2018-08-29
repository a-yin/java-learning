package com.lingb.mystudy.dsaa.day06;

import org.junit.Test;

public class TreeTest {

    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();
        tree.insert(10, "AA");
        tree.insert(20, "BB");
        tree.insert(15, "CC");
        tree.insert(13, "DD");

        System.out.println(tree.root.data);
        System.out.println(tree.root.rightChild.data);
        System.out.println(tree.root.rightChild.leftChild.data);
        System.out.println(tree.root.leftChild.data);

        Node node = tree.find(3);
        System.out.println(node.data);
    }

}
