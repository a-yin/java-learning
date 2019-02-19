package com.lingb.mystudy.datastructure.day09;

/**
 * 串，可以理解成一种包含字符的特殊的线性表
 *
 * Created by lingb on 2018-11-22
 */
public interface MyString {

    /**
     * 返回串的长度（包含的字符数）
     *
     * @return
     */
    int length();

    /**
     * 返回第i(i>=0) 个字符
     *
     * @param i
     * @return
     */
    char charAt(int i);

    /**
     * 返回串中字符序号从begin至end-1 的子串
     *
     * @param begin
     * @param end
     * @return
     */
    MyString substring(int begin, int end);

    /**
     * 设置第i个字符为ch
     *
     * @param i
     * @param ch
     */
    void setCharAt(int i, char ch);

    /**
     * 在第i个字符处插入str串
     *
     * @param i
     * @param str
     * @return
     */
    MyString insert(int i, MyString str);

    /**
     * 删除从begin 到end - 1的子串
     *
     * @param begin
     * @param end
     * @return
     */
    MyString delete(int begin, int end);

    /**
     * 返回模式串pattern 在串中的首次匹配位置（序号）
     *
     * @param pattern
     * @return
     */
    int indexOf(MyString pattern);

    /**
     * KMP算法
     *
     * @param target
     * @param patter
     * @param begin
     * @return
     */
    default int indexOf(String target, String patter, int begin) {


        return -1;
    }


}
