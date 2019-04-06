package com.lingb.mystudy.datastructure.day08;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by lingb on 9/14/2018
 */
public class MyHashMapTest {
    
    
    @Test
    public void test1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put("AA", 1);
        map.put("BB", 2);
        map.put("CC", 3);
        map.put("DD", 4);
        map.put("E", 5);
        map.put("F", 1);
        map.put("G", 2);
        map.put("H", 3);
        map.put("I", 4);
        map.put("J", 5);
        map.put("K", 1);
        map.put("L", 2);
        map.put("M", 3);
        System.out.println(map.get("AA"));

    }
    
    @Test
    public void test() {
        MyHashMap7<String, Integer> map = new MyHashMap7<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 1);
        map.put("G", 2);
        map.put("H", 3);
        map.put("I", 4);
        map.put("J", 5);
        map.put("K", 1);
        map.put("L", 2);
        map.put("M", 3);
        map.put("N", 4);
        map.put("O", 5);
        map.put("P", 1);
        map.put("Q", 2);
        map.put("R", 3);
        map.put("S", 4);
        map.put("T", 5);
        map.put("U", 1);
        map.put("V", 2);
        map.put("W", 3);
        map.put("X", 4);
        map.put("Y", 5);
        map.put("Z", 5);

        map.remove("D");
        System.out.println(map.get("D"));

        map.put("D", 5);
        map.put("D", 6);
        System.out.println(map.get("D"));
    }
}
