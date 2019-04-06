package com.lingb.mystudy.javatools.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.22 11:42
 */
public class DateTimeUtil7 {

    /**
     * 日期 -> 字符串
     *
     * @param format  格式
     * @return {@link String}
     */
    public static String dateToString(String format) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(now);
    }

    /**
     * 日期 -> 字符串
     *
     * @param date    日期
     * @param format  格式
     * @return {@link String}
     */
    public static String dateToString(Date date, SimpleDateFormat format) {
        if (null == date) {
            return null;
        }
        return format.format(date);
    }

    /**
     * 日期 -> 字符串
     *
     * @param dateStr  日期字符串
     * @param format   格式
     * @return {@link String}
     */
    public static String dateToString(String dateStr, String format) {
        Date date = null;
        SimpleDateFormat sft = new SimpleDateFormat(format);
        try {
            date= sft.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sft.format(date);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(dateToString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateToString(new Date(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
    }

}
