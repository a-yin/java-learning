package com.lingb.mystudy.datastructure.day07;

import org.junit.Test;

/**
 * Created by lingb on 2018/9/3
 */
public class HashTableTest {

    
    @Test
    public void test2() {
        HashTable2 hashTable2  = new HashTable2();

        hashTable2.insert(new Student("a", "AA"));
        hashTable2.insert(new Student("ct", "BB"));
        hashTable2.insert(new Student("b", "CC"));

        System.out.println(hashTable2.find("a").getName());
        System.out.println(hashTable2.find("ct").getName());
        System.out.println(hashTable2.find("b").getName());

        hashTable2.display("a");
        hashTable2.delete("c");
        System.out.println(hashTable2.find("c").getName());
    }
    
    @Test
    public void test1() {
        HashTable1 hashTable1  = new HashTable1();

        hashTable1.insert(new Student("a", "AA"));
        hashTable1.insert(new Student("ct", "BB"));
        hashTable1.insert(new Student("c", "CC"));

        System.out.println(hashTable1.find("a").getName());
        System.out.println(hashTable1.find("ct").getName());
        System.out.println(hashTable1.find("c").getName());

        hashTable1.delete("c");
        System.out.println(hashTable1.find("c").getName());

    }

    @Test
    public void test() {
        HashTable hashTable  = new HashTable();
//        hashTable.insert(new Student(12, "AA"));
//        hashTable.insert(new Student(23, "BB"));
//        hashTable.insert(new Student(34, "CC"));

        // 字符串key
//        hashTable.insert(new Student("abcabcabcabcabcabc", "AA"));
        hashTable.insert(new Student("abc", "AA"));
        hashTable.insert(new Student("bbb", "BB"));
        hashTable.insert(new Student("cba", "CC"));

        System.out.println(hashTable.find("abv").getName());
        System.out.println(hashTable.find("bbb").getName());
        System.out.println(hashTable.find("cba").getName());
    }


}
