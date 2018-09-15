package com.lingb.mystudy.dsaa.day08;

import java.util.Map;

/**
 * 研究HashMap源码:
 * 1、HashMap特点（K/V、数组Entry[]+链表(单)+红黑树（JDK8）、尾put、哈希冲突、线程不安全）
 * 2、HashMap实现（Hash算法(高低16位)、扩容机制）
 * 3、手写实现简易HashMap
 * <p>
 * Created by lingb on 9/15/2018
 */
public class MyHashMap8<K, V> implements MyMap<K, V> {

    /**
     * Node数组存储Node结点
     */
    private Node<K, V>[] table = null;

    /**
     * MyHashMap元素的个数
     */
    private int size;

    /**
     * Node数组默认容量
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * MyHashMap默认加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * MyHashMap8 阈值
     */
    private int threshold;


    public MyHashMap8() {
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        if (table == null) {
            // 初始化table
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        }

        // 1、Hash算法：判断 (K,V) 应该存储在table哪个index位置
        int index = getIndex(key, table.length);

        // 3、判断key是否重复
        Node<K, V> node = table[index];
        while (node != null) {
            // key重复
            if (node.key.equals(key)) {
                // 新value覆盖旧value，并返回旧value
                return node.setValue(value);
            }
            // 下一结点
            node = node.next;
        }

        // key不重复
        // 2、创建Node结点对象，并将这个对象放到table中的index位置
        table[index] = new Node<>(key, value, table[index]);


        // 存储数据多了，同一index位置链表过长（哈希冲突）
        // 4、判断是否需要扩容
        if (size >= threshold) {
            resize();
        }

        size++;
        return value;
    }

    private void resize() {
        System.out.println("------开始扩容啦");
        // 1、创建新的table
        Node<K, V>[] newTable = new Node[table.length << 1];
        // 2、复制数据
        copy(newTable);

        // 3、替换
        table = newTable;
        threshold = (int) (newTable.length * DEFAULT_LOAD_FACTOR);

    }

    private void copy(Node<K, V>[] newTable) {
        if (table != null) {
            Node<K, V> node = null;
            // 遍历旧table，复制数据（旧->新）
            for (int i = 0; i < table.length; i++) {
                node = table[i];
                while (node != null) {
                    // 获取旧table这个index位置的下一结点
                    Node<K, V> next = node.next;
                    // 需要重新散列
                    int index = getIndex(node.key, newTable.length);
                    node.setNext(newTable[index]);
                    newTable[index] = node;
                    // 继续下下一结点
                    node = next;
                }
            }
        }
    }

    private int getIndex(K key, int length) {
        if (key == null) {
            return 0;

        }
        // 取与
        return key.hashCode() & length - 1;
    }

    @Override
    public V get(K key) {
        if (table != null) {
            // 1、计算index位置
            int index = getIndex(key, table.length);
            // 2、拿到Node结点，但不一定是
            Node<K, V> node = table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                // 下一结点
                node = node.next;
            }
        }
        return null;
    }


    static class Node<K, V> implements Map.Entry<K, V> {

        /**
         * Key键
         */
        K key;

        /**
         * value值
         */
        V value;

        /**
         * 下一Node结点
         */
        Node<K, V> next;


        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldvalue = this.value;
            this.value = value;
            // 返回给用户看最后一眼
            return oldvalue;
        }


        public Map.Entry<K, V> setNext(Node<K, V> next) {
            Map.Entry<K, V> oldNext = this.next;
            this.next = next;
            return oldNext;

        }
    }
}
