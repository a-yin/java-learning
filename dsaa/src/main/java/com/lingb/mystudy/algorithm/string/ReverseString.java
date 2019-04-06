package com.lingb.mystudy.algorithm.string;

import java.util.Scanner;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.22 21:11
 */
public class ReverseString {

    private static String reverseStr(String str) {
        if (str == null || str.length() == 0 || str.length() > 100) {
            return null;
        }

        StringBuffer sb = new StringBuffer(str);
        String retStr = String.valueOf(sb.reverse());
//        char[] charArr = str.toCharArray();
//        for (int i = str.length() - 1;  i >= 0; i--) {
//            retStr += charArr[i];
//        }
        return retStr;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(reverseStr(sc.nextLine()));
    }
}
