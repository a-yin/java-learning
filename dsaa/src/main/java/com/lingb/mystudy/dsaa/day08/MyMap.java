package com.lingb.mystudy.dsaa.day08;

/**
 * Created by lingb on 9/15/2018
 */
public interface MyMap<K, V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

}
