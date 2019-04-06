package com.lingb.mystudy.java.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符反转
 *
 * @author lingb
 * @date 2019.03.09 18:42
 */
public class StringReverser {

    public static String reverseString(String inputStr) {
        if (inputStr == "" || inputStr.length() == 0) {
            return "";
        }

        String outputStr = "";
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            outputStr += inputStr.charAt(i);
        }

        return outputStr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        System.out.println(reverseString(inputStr));
        br.close();
    }
}
