package com.lingb.mystudy.algorithm.recursion;

/**
 * Created by lingb on 2018-12-20
 */
public class PrintAllSubsquences {

    /**
     * 打印一个字符串所有子序列，包括空字符串
     *
     * @param str
     * @param i
     * @param res
     */
    public static void printAllSub(String str, int i, String res) {
        char[] chars = str.toCharArray();
        if (i == chars.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1, res + String.valueOf(chars[i]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSub(str, 0, "");
    }

}
