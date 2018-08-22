package com.lingb.mystudy.java.day02;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 注解的应用: 定制序列化，即输出格式自定义
 *
 * Created by lingb on 2018/7/10
 */
public class AnnotationTest {

    /**
     * 标签注解
     */
    @Retention(RUNTIME) // 保留策略 -> 运行时
    @Target(FIELD) // 注解目标 -> 属性
    public @interface Label {
        // String 类型默认值必须为"", 不可为null
        String value() default "";
    }

    /**
     * 日期注解
     */
    @Retention(RUNTIME)
    @Target(FIELD)
    public @interface Format {
        String pattern() default "yyyy-MM-dd HH:mm:ss";
        String timezone() default "GMT+8";
    }

    static class Student {
        @Label("姓名")
        private String name;
        @Label("出生日期Date")
        @Format(pattern = "yyyy/MM/dd")
        private Date born;
        @Label("出生日期LocalDate")
        @Format(pattern = "yyyy.MM.dd")
        private LocalDate born1;
        @Label("分数")
        private double score;

        public Student() {
        }

        public Student(String name, Date born, double score) {
            this.name = name;
            this.born = born;
            this.score = score;
        }

        public Student(String name, LocalDate born1, double score) {
            this.name = name;
            this.born1 = born1;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBorn() {
            return born;
        }

        public void setBorn(Date born) {
            this.born = born;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", born=" + born +
                    ", born1=" + born1 +
                    ", score=" + score +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Double.compare(student.score, score) == 0 &&
                    Objects.equals(name, student.name) &&
                    Objects.equals(born, student.born) &&
                    Objects.equals(born1, student.born1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, born, born1, score);
        }
    }

    /**
     * format 调用：
     * 1、获取传入Object 的Class对象实例
     * 2、通过Class对象实例获取Object类的所有属性
     * 3、
     *
     * @param   [object]
     * @return  java.lang.String
     */
    public static String format(Object object) {

        Class clazz = object.getClass();
        StringBuilder sb = new StringBuilder();
        for (Field field : clazz.getDeclaredFields()) {
            // 若没有该属性的访问权限
            if(!field.isAccessible()) {
                // 设为true 表示忽略Java的访问检查机制，以允许读写非public 属性
                field.setAccessible(true);
            }

            Label label = field.getAnnotation(Label.class);
            // 若标签注解非空（存在），即有使用该注解标记该属性，则fieldName = 标签注解的值
            // 反之没有标记，则fieldName = 属性名称
            String fieldName = label != null ? label.value() : field.getName();
            try {
                Object value = field.get(object);
                // JDK1.8前 Date
                if (value != null && field.getType() == Date.class) {
                    value = formatDate(field, value);
                }
                // JDK1.8后 LocalDate
                if (value != null && field.getType() == LocalDate.class) {
                    value = formatLocalDate(field, value);
                }

                sb.append(fieldName + ":" + value + "\n");

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }

        return sb.toString();
    }

    /**
     * JDK1.8之前
     *
     * @param   [field, date]
     * @return  java.lang.Object
     */
    private static Object formatDate(Field field, Object date) {
        Format format = field.getAnnotation(Format.class);
        if (format != null) {
            // 日期格式
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            // 将Date 对象转化为String
            // 并返回
            return sdf.format(date);
        }

        return date;
    }

    /**
     * JDK1.8之后
     *
     * @param   [field, date]
     * @return  java.lang.Object
     */
    private static Object formatLocalDate(Field field, Object date) {
        Format format = field.getAnnotation(Format.class);
        if (format != null) {
            // JDK1.8之后
            // 日期格式
            DateTimeFormatter dtf= DateTimeFormatter.ofPattern(format.pattern());
            // 将LocalDate对象转化为String
            // 并返回
            return dtf.format((TemporalAccessor) date);
        }

        return date;
    }

    @Test
    public void testAnnotation() {
        // JDK1.8之前
        // 将String 转化为Date 对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student("湛江甲鸟前", sdf.parse("2018-07-10", new ParsePosition(0)), 80.9d);
        System.out.println(format(student));

        // JDK1.8之后
        // 将String 转化为LocalDate 对象
        LocalDate localDate = LocalDate.parse("2018-07-10");
        Student student1 = new Student("湛江甲鸟后", localDate, 80.9d);
        System.out.println(format(student1));
    }


}
