package com.lingb.mystudy.javatools.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.22 18:06
 */
public class DateTimeUtil8 {

    /**
     * JDK1.8中，解决了以前JDK1.7日期和时间类的很多弊端，
     * 比如：时间格式化需要java.text.DateFormat类处理、java.util.Date中既包含了日期，又包含了时间 等问题
     * 在JDK1.8新增了不可变且线程安全的日期库和时间库，This class is immutable and thread-safe.
     * java.time包中常用的类 (final 修饰类、成员属性(private final)，private 修饰构造方法，public static 修饰成员方法)，
     * 分离了日期，时间和时区类，但成员方法大同小异，易用上手
     * Instant : 时间戳
     * Duration ： 持续时间，时间差
     * LocalDate ：只包含日期，比如：2019-01-01
     * LocalTime ： 只包含时间，比如：00:00:00
     * LocalDateTime : 包含日期，比如：2019-01-01 00:00:00
     * Period ：时间段
     * ZoneOffset ： 时区偏移量，比如 +8:00
     * ZonedDateTime ：带时区的日期时间
     * Clock ：时钟，比如获取某个特定时区的 瞬时时间、日期和时间
     *
     * 时间格式工具类：java.time.format
     * DateTimeFormatter ： 时间格式化
     *
     *
     * 用法小结：
     * 该包(java.time包)的API提供了大量相关的方法，一般有一致的方法前缀:
     * of：静态工厂方法
     * parse：静态工厂方法，用于解析
     * get：获取某些东西的值
     * is：检查某些东西的是否为true
     * with：不可变的setter等价物
     * plus：加一些量到某个对象
     * minus：从某个对象减去一些量
     * to：转换到另一个类型
     * at：把这个对象与另一个对象组合起来，比如：date.atTime(time)
     *
     * 由于构造方法是私有的，创建某时区下当前的日期、时间、日期时间、时间戳等的一个实例对象有如下方式：
     * 1.类名.now()        没有参数
     * 2.类名.create(...)  参数是 year、month、day，hour、minute、second
     * 3.类名.of(...)      参数是 LocalDate对象、LocalTime对象、LocalDateTime对象、DateTimeFormatter对象等
     * 4.类名.parse(...)   参数是 CharSequence接口的实现类对象，比如：String等
     * 5.类名.with(...)    参数是 类名的实例对象，复制对象
     *
     */

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Instant getNowInstant() {
        return Instant.now();
    }

    /**
     * 比较两个日期之前时间差
     * ChronoUnit.DAYS 底层调用 DAYS("Days", Duration.ofSeconds(86400))
     *
     * @param a 日期a
     * @param b 日期b
     * @return
     */
    public static long compareTwoDate(LocalDate a, LocalDate b) {
        return a.until(a, ChronoUnit.DAYS);
    }


    /**
     * 获取当前日期
     *
     * @return
     */
    public static LocalDate getNowDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static LocalTime getNowTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前时间，不包含毫秒
     *
     * @return
     */
    public static LocalTime getNowTimeWithoutNano() {
        return LocalTime.now().withNano(0);
    }

    /**
     * 获取当前日期时间
     *
     * @return
     */
    public static LocalDateTime getNowDateTime() {
        return LocalDateTime.now().withNano(0);
    }


    /**
     * 获取当前月份的第一天
     *
     * @return
     */
    public static LocalDate getFirstDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取当前月份的第一天
     *
     * @return
     */
    public static LocalDate getFirstDayOfMonth1() {
        return LocalDate.now().withDayOfMonth(1);
    }

    /**
     * 获取当前月份的最后一天
     *
     * @return
     */
    public static LocalDate getLastDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取当前时间 +nano毫秒
     *
     * @param nanos 指定的毫秒数
     * @return
     */
    public static LocalTime getPlusNanos(int nanos) {
        return LocalTime.now().plusNanos(nanos);
    }

    /**
     * 获取当前时间 +seconds 秒
     *
     * @param seconds 指定的秒数
     * @return
     */
    public static LocalTime getPlusSeconds(int seconds) {
        return LocalTime.now().plusSeconds(seconds);
    }

    /**
     * 获取当前时间 +minutes 分
     *
     * @param minutes 指定的分数
     * @return
     */
    public static LocalTime getPlusMinutes(int minutes) {
        return LocalTime.now().plusMinutes(minutes);
    }

    /**
     * 获取当前时间 +hours小时
     *
     * @param hours 指定的时数
     * @return
     */
    public static LocalTime getPlusHours(int hours) {
        return LocalTime.now().plusHours(hours);
    }

    /**
     * 获取当前日期 +days天
     *
     * @param days 指定的天数
     * @return
     */
    public static LocalDate getPlusDays(int days) {
        return LocalDate.now().plusDays(days);
    }
    /**
     * 获取当前日期 +weeks周
     *
     * @param weeks 指定的周数
     * @return
     */
    public static LocalDate getPlusWeeks(int weeks) {
        return LocalDate.now().plusWeeks(weeks);
    }

    /**
     * 获取当前日期 +years年
     *
     * @param years 指定的年数
     * @return
     */
    public static LocalDate getPlusYears(int years) {
        return LocalDate.now().plusYears(years);
    }

    /**
     * 判断是否为闰年
     *
     * @param today 当年某一天
     * @return
     */
    public static boolean isLeapYear(LocalDate oneday) {
        return oneday.isLeapYear();
    }


    /**
     * 获取指定时间
     *
     * @param hour   时
     * @param minute 分
     * @param second 秒
     * @return
     */
    public static LocalTime getLocalTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);

    }

    /**
     * 获取指定时间
     *
     * @param time 指定时间，比如 00:00:00
     * @return
     */
    public static LocalTime getLocalTime(String time) {
        return LocalTime.parse(time);
    }

    /**
     * 比较 2个日期哪个在前
     * @param a 日期a
     * @param b 日期b
     * @return
     */
    public static boolean isBefore(LocalDate a, LocalDate b) {
        return a.isBefore(b);
    }

    /**
     * 比较 2个时间哪个在前
     * @param a 时间a
     * @param b 时间b
     * @return
     */
    public static boolean isBefore(LocalTime a, LocalTime b) {
        return a.isBefore(b);
    }

    /**
     * 比较 2个日期哪个在后
     *
     * @param a 日期a
     * @param b 日期b
     * @return
     */
    public static boolean isAfter(LocalDate a, LocalDate b) {
        return a.isAfter(b);
    }

    /**
     * 比较 2个时间哪个在后
     *
     * @param a 时间a
     * @param b 时间b
     * @return
     */
    public static boolean isAfter(LocalTime a, LocalTime b) {
        return a.isAfter(b);
    }

    /**
     * 比较 2个日期是否相等
     *
     * @param a 日期a
     * @param b 日期b
     * @return
     */
    public static boolean isEqual(LocalDate a, LocalDate b) {
        return a.isEqual(b);
    }

    /**
     * 比较 2个日期时间是否相等
     *
     * @param a 日期时间a
     * @param b 日期时间b
     * @return
     */
    public static boolean isEqual(LocalDateTime a, LocalDateTime b) {
        return a.isEqual(b);
    }

    /**
     * 判断是否为特别日期，如：生日、账单日
     *
     * @param oneDay 某一天
     * @return
     */
    public static boolean isSpecialDay(LocalDate oneDay) {
        if (null == oneDay) {
            return false;
        }
        MonthDay today = MonthDay.now();
        MonthDay specialDay = MonthDay.from(oneDay);
        return today.equals(specialDay);
    }

    /**
     * 判断是否为特别日期，如：生日、账单日
     *
     * @param year   某一年
     * @param month  某一月
     * @param hour   某一天
     * @return
     */
    public static boolean isSpecialDay(int year, int month, int hour) {
        MonthDay today = MonthDay.now();
        LocalDate oneDay = LocalDate.of(year, month, hour);
        MonthDay specialDay = MonthDay.from(oneDay);
        return today.equals(specialDay);
    }





    /**
     * 查看当前的时区
     *
     * @return
     */
    public static ZoneId getNowZone() {
        return ZoneId.systemDefault();
    }

    /**
     * 获取系统时区的日期时间
     *
     * @return
     */
    public static ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now();
    }

    /**
     * 获取指定的时区的日期时间
     *
     * @param zone 时区
     * @return
     */
    public static ZonedDateTime getZonedDateTime(ZoneId zone) {
        return ZonedDateTime.now(zone);
    }

    /**
     * 获取指定的时区的日期时间
     *
     * @param zoneStr 时区字符串
     * @return
     */
    public static ZonedDateTime getZonedDateTime(String zoneStr) {
        ZoneId zone = ZoneId.of(zoneStr);
        return ZonedDateTime.now(zone);
    }

    /**
     * 获取默认格式的日期
     *
     * @param dateStr  日期字符串
     * @return
     */
    public static LocalDate getFormattedDate(String dateStr){
        return LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 获取指定格式的日期
     *
     * @param dateStr    日期字符串
     * @param formatter  格式
     * @return
     */
    public static LocalDate getFormattedDate(String dateStr, DateTimeFormatter formatter){
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * 获取指定格式的日期的字符串
     *
     * @param date     日期
     * @param pattern  格式
     * @return
     */
    public static String getFormattedDate(LocalDate date, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }


    /**
     * Instant -> LocalDateTime + DateTimeFormatter -> String
     *
     * @param instant 时间戳
     * @return
     */
    public static String InstantToString(Instant instant) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMDDhhmmss");
        return formatter.format(localDateTime);
    }


    /**
     * Instant -> Date
     *
     * @param instant  时间戳
     * @return
     */
    public static Date InstantToDate(Instant instant) {
        return Date.from(instant);
    }

    /**
     * Date -> Instant
     *
     * @param date  日期
     * @return
     */
    public static Instant DateToInstant(Date date) {
        return date.toInstant();
    }


    /**
     * LocalDate -> LocalDateTime -> Instant -> Date
     * 因为LocalDate不包含时间，所以转Date时，会默认转为当天的起始时间，00:00:00
     *
     * @param localDate  日期
     * @return
     */
    public static Date LocalDateToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


    /**
     * LocalDateTime -> Instant -> Date
     *
     * @param localDateTime  日期时间
     * @return
     */
    public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        Instant instant = Instant.from(localDateTime.atZone(ZoneId.systemDefault()));
        return Date.from(instant);
    }

    /**
     * Date -> Instant -> LocalDateTime
     *
     * @param date 日期
     * @return
     */
    public static LocalDateTime DateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


    public static void testClock() {
        /*
            相当于 System.currentTimeMillis() 的方式有：
            1.Clock.systemUTC().instant()
            2.Clock.systemDefalutZone().instant()
            3.Instant.now()  // 底层调用方式1

            建议使用方式1 UTC（世界协调时间）相对于GMT（格林威治标准时间）更精准
         */

        System.out.println(Clock.systemUTC().instant());
        System.out.println(Clock.systemDefaultZone().instant());
        System.out.println(Instant.now());


        // 系统默认UTC时钟
        Clock c1 = Clock.systemUTC();
        // 相当于System.currentTimeMillis()
        System.out.println(c1.millis());
        // 当前瞬时时间（UTC）
        System.out.println(c1.instant());
        // 当前时钟时区
        System.out.println(c1.getZone());

        // 系统默认时区时钟
        Clock c2 = Clock.systemDefaultZone();
        // 相当于System.currentTimeMillis()
        System.out.println(c2.millis());
        // 当前瞬时时间
        System.out.println(c2.instant());
        // 当前时钟时区
        System.out.println(c2.getZone());

        // 巴黎时区
        Clock c31 = Clock.system(ZoneId.of("Europe/Paris"));
        System.out.println(c31.instant());
        // 上海时区
        Clock c32 = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println(c32.instant());

    }


    public static void main(String[] args) {
//        System.out.println(getNowDate());
//        System.out.println(getNowTime());
//        System.out.println(getNowTimeWithoutNano());
//        System.out.println(getNowDateTime());
//        System.out.println(getFirstDayOfMonth());
//        System.out.println(getFirstDayOfMonth1());
//        System.out.println(getLastDayOfMonth());
//        System.out.println(getPlusDays(1));
//        System.out.println(getPlusWeeks(1));
//        System.out.println(getPlusYears(1));
//        System.out.println(isLeapYear(LocalDate.now()));
//
//        System.out.println(getFormattedDate("20190330"));

        testClock();
    }

}
