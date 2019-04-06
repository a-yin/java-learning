package com.lingb.mystudy.java.day05.collection.list;

import java.util.HashSet;
import java.util.Set;

/**
 * LinkedList 详解
 *
 * @author lingb
 * @date 2019.03.15 15:01
 */
public class LinkedListTest {

    /**
     * LinkedList 双向链表、增删快、查找慢

     private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
         }
     }

     */

    /**
     * 怎样判断单链表是否存在打结（环）？
     * 详解：http://blog.jobbole.com/106227
     */

    private static class Node<E> {
        E item;
        private Node next;

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /**
     * HashSet 方式
     * 时间复杂度：O(D+S)  可以理解为 O(N)  注：D 表示链表头节点到入环点的距离， S 表示链表的环长
     * 空间复杂度：O(D+S-1)可以理解为 O(N)
     *
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(Node<Integer> head) {
        Set<Node> nodeSet = new HashSet<>();
        Node<Integer> node = head;
        while (node != null) {
            if (nodeSet.contains(node)) {
                return true;

            } else {
                nodeSet.add(node);
            }
            node = node.next;
        }
        
        return false;
    }


    /**
     * 快慢指针 方式
     * 时间复杂度：O(D+S)  可以理解为 O(N)  注：D 表示链表头节点到入环点的距离， S 表示链表的环长
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
     public boolean hasCycleByTowPointers(Node<Integer> head) {
         if (head == null || head.next == null) {
             return false;
         }

         Node<Integer> slow = head;
         Node<Integer> fast = head;

         while (slow != fast) {
             if (fast == null || fast.next == null) {
                 return false;
             }
             slow = slow.next;
             fast = fast.next.next;
         }

         return true;
     }



}
