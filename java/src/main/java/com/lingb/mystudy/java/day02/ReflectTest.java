package com.lingb.mystudy.java.day02;

import org.junit.Test;

import java.lang.reflect.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * 反射的根源：Class类
 * Class类用于定义类对象的属性和方法。
 *
 * Created by lingb on 2018/7/10
 */
public class ReflectTest {


    /**
     * 获取Class 对象
     * 1) 类名.class
     * 2) 通过Class类的forName方法
     * 3) Object类中的getClass方法
     *
     * @param []
     * @return void
     */
    @Test
    public void testGetClass() {

        // 类名.class获取Testit类的反射对象
        Class clazz1 = Testit.class;
        System.out.println(clazz1);
        try {
            // Class.forName(包名.类名)获取反射对象
            Class clazz2 = Class.forName("com.lingb.mystudy.java.day02.Testit");
            System.out.println(clazz2);
            System.out.println("类名.class 和 Class.forName() 是否同一对象(地址) " + (clazz1 == clazz2));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 对象.getClass 获取Testit类的反射对象
        Testit testit = new Testit();
        Class clazz3 = testit.getClass();
        System.out.println(clazz3);
        System.out.println("类名.class 和 对象.getClass() 是否同一对象(地址) " + (clazz1 == clazz3));

    }


    /**
     * 获取name 信息
     *
     * @param   []
     * @return  void
     */
    public void testGetName(Class<?> clazz) {
        System.out.println("Name -------------------------------");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getPackage());

    }

    /**
     * 获取field 信息
     *
     * @param   []
     * @return  void
     */
    public void testGetField() throws NoSuchFieldException {
        List<String> strList = Arrays.asList("hello", "world");
        Class<?> clazz = strList.getClass();
        for (Field field : clazz.getFields()) {
            try {
                System.out.println(field.getName() + "-" + field.get(strList));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Field --------------------------------------");
        Class clazz1 = URL.class;
        // 返回本类或父类中指定名称的public属性，找不到抛出异常NoSuchFieldException
//        System.out.println(clazz1.getField("aa"));
        // 返回本类指定名称的public属性，找不到抛出异常NoSuchFieldException
//        System.out.println(clazz1.getDeclaredField("bb"));

        // 返回所有的public属性，包括父类的，若属性为空，返回空数组
        System.out.println(clazz1.getFields());
        System.out.println(Arrays.toString(clazz1.getFields()));
        // 返回本类声明的所有属性，包括非public的，但不包括父类的
        System.out.println(clazz1.getDeclaredFields());
        System.out.println(Arrays.toString(clazz1.getDeclaredFields()));

    }

    /**
     * 获取method 信息
     *
     * @param   []
     * @return  void
     */
    @Test
    public void testGetMethod() {
        System.out.println("Method ----------------------------------");
        Class<?> clazz = Integer.class;
        try {
            Method method = clazz.getMethod("parseInt", String.class);
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Constructor 信息
     *
     * @param   []
     * @return  void
     */
    public void testGetConstructor() {
        System.out.println("Constructor --------------------------");
        Constructor[] constructors = String.class.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName()+"   "
                    + Modifier.toString(constructors[i].getModifiers()));
        }
    }

    /**
     * 通过Class反射创建对象
     *
     * @param   []
     * @return  void
     */
    public void testNewInstance() {
        System.out.println("NewInstance ---------------------------");
        try {
            // 调用类的默认构造方法（即无参public 构造方法）
            // 若该类没有该构造方法，会抛出异常 InstantiationException
            ReflectTest reflectTest = ReflectTest.class.newInstance();
            System.out.println(reflectTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReflectTest().testGetClass();
        new ReflectTest().testGetName(String.class);
        try {
            new ReflectTest().testGetField();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        new ReflectTest().testGetMethod();
        new ReflectTest().testGetConstructor();
        new ReflectTest().testNewInstance();
    }
}
