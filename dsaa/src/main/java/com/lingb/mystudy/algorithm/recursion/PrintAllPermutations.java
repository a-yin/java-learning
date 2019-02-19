package com.lingb.mystudy.algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by lingb on 2018-12-20
 */
public class PrintAllPermutations {

    /**
     * 打印一个字符串全排列
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
     *
     * 输入描述: 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     *
     */
    public static void printAllPermutations(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    private static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.print(String.valueOf(chs) + " ");
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process(chs, i + 1);
            swap(chs, i, j);
        }
    }

    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process1(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> resList = new ArrayList<>();
        if (str == null || str.toCharArray().length > 9) {
            return resList;
        }
        process(resList, str.toCharArray(), 0);
        Collections.sort(resList);
        for (String s : resList) {
            System.out.println(s);
        }
        return resList;
    }

    private static void process(ArrayList<String> list, char[] chrs, int i) {
        if (i == chrs.length - 1) {
            list.add(String.valueOf(chrs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chrs.length; j++) {
            if (!set.contains(chrs[j])) {
                set.add(chrs[j]);
                swap(chrs, i, j);
                process(list, chrs, i + 1);
                swap(chrs, i, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
//            printAllPermutations(sc.nextLine());
            Permutation(sc.nextLine());
        }
    }

}
