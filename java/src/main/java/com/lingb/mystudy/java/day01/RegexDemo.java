package com.lingb.mystudy.java.day01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lingb on 2018/7/9
 */
public class RegexDemo {

    /**
     * 验证
     *
     * @param   []
     * @return  void
     */
    public void testValidate() {
        // 检验输入是否为8位数字
        String regex = "\\d{8}";
        String str = "12345678";
        // 首先调用compile 编译regex 为Pattern 对象
        // 再调用Pattern的 matcher() 方法生成一个匹配对象 Matcher
        // 最后Matcher 的matches() 方法返回是否完整匹配
        System.out.println(str.matches(regex));
    }

    /**
     * 查找
     *
     * @param   []
     * @return  void
     */
    public void testFind() {
        // 表示
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        // 首先调用compile 编译regex 为Pattern 对象
        Pattern pattern = Pattern.compile(regex);
        String str = "Today is 2018-07-09, yesterday is 2018-07-08";
        // 再调用Pattern的 matcher() 方法生成一个匹配对象 Matcher
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            // 最后Matcher 的group() 方法返回匹配到完整子字符串
            System.out.println("find " + matcher.group() +
                " position: " + matcher.start() + "-" + matcher.end());
        }
    }

    public void testFindGroup() {
        // 分组 4个
        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        // 首先调用compile 编译regex 为Pattern 对象
        Pattern pattern = Pattern.compile(regex);
        String str = "Today is 2018-07-09, yesterday is 2018-07-08";
        // 再调用Pattern的 matcher() 方法生成一个匹配对象 Matcher
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            // 最后Matcher 的group() 方法返回匹配到相应子字符串
            System.out.println("find " + matcher.group(0) +
                    "，year: " + matcher.group(1) +
                    "，month：" + matcher.group(2)+
                    ", day: " + matcher.group(3));
        }
    }

    public void testReplace() {

    }

    public static void main(String[] args) {
        new RegexDemo().testValidate();
        new RegexDemo().testFind();
        new RegexDemo().testFindGroup();
    }
}
