package com.lingb.mystudy.datastructure.day08;

import java.util.Map;

/**
 * 研究HashMap7源码:
 * 1、HashMap7特点（K/V、数组Entry[]+链表(单)（JDK7）、头put、哈希冲突、线程不安全）
 * 2、HashMap7实现（Hash算法、扩容机制）
 * 3、手写实现简易HashMap7
 * <p>
 * Created by lingb on 9/14/2018
 */
public class MyHashMap7<K, V> implements MyMap<K, V> {

    /**
     * Entry数组存储entry
     */
    private Entry<K, V>[] table;

    /**
     * MyHashMap7键值对的个数
     */
    private int size;

    /**
     * Entry数组默认容量（长度）
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * MyHashMap7默认加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * MyHashMap7 阈值
     */
    private int threshold;


    public MyHashMap7() {
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    }

    @Override
    public V put(K key, V value) {
        if (table == null) {
            // 初始化table
            table = new Entry[DEFAULT_INITIAL_CAPACITY];
        }

        // 1、Hash算法：判断 (K,V) 应该存储在table哪个index位置
        int index = getIndex(key, table.length);

        // 3、判断key是否重复
        Entry<K, V> e = table[index];
        while (e != null) {
            // key重复
            if (e.key.equals(key)) {
                // 新value覆盖旧value，并返回旧value
                return e.setValue(value);
            }
            // 下一结点
            e = e.next;
        }

        // key不重复
        // 2、创建Entry实例对象，并将这个实例对象放到table中的index位置
        table[index] = new Entry<>(key, value, table[index]);

        // 存储数据多了，同一index位置链表过长（哈希冲突）
        // 4、判断数组容量是否达到阈值，需要扩容
        if (++size > threshold) {
            resize();
        }

        return value;
    }

    private void resize() {
        System.out.println("------开始扩容啦");
        // 1、创建新的table
        Entry<K, V>[] newTable = new Entry[table.length << 1];
        // 2、复制数据
        copy(newTable);

        // 3、替换
        table = newTable;
        threshold = (int) (newTable.length * DEFAULT_LOAD_FACTOR);

    }

    private void copy(Entry<K, V>[] newTable) {
        if (table != null) {
            Entry<K, V> e = null;
            // 遍历旧table，复制数据（旧->新）
            for (int i = 0; i < table.length; i++) {
                e = table[i];
                while (e != null) {
                    // 获取旧table这个index位置的下一entry
                    Entry<K, V> next = e.next;
                    // 需要重新散列
                    int index = getIndex(e.key, newTable.length);
                    e.setNext(newTable[index]);
                    newTable[index] = e;
                    // 继续遍历下一结点
                    e = next;
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
            // 2、拿到Entry结点，但不一定是
            Entry<K, V> e = table[index];
            while (e != null) {
                if (e.key.equals(key)) {
                    return e.value;
                }
                // 继续遍历下一结点
                e = e.next;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        Entry<K, V> prev;
        // 将要移除的Entry
        Entry<K, V> e;

        // 先查后删
        if (table != null) {
            // 1、计算index位置
            int index = getIndex(key, table.length);
            // 2、拿到Entry结点，但不一定是
            prev = table[index];
            e = prev;

            while (e != null) {
                if (e.key.equals(key)) {
                    // 移除头结点
                    if (prev == e) {
                        // 设为null
                        table[index] = e.next;

                    // 移除非头结点
                    } else {
                        prev.next = e.next;
                    }
                    --size;
                    return e.value;
                }
                // 下一结点
                e = e.next;
            }
        }

        return null;
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        /**
         * key键
         */
        K key;

        /**
         * value值
         */
        V value;

        /**
         * 下一entry
         */
        Entry<K, V> next;


        public Entry(K key, V value, Entry<K, V> next) {
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

        public Map.Entry<K, V> setNext(Entry<K, V> next) {
            Map.Entry<K, V> oldNext = this.next;
            this.next = next;
            return oldNext;

        }
    }

}