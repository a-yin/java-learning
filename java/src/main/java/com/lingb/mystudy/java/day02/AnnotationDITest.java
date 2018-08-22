package com.lingb.mystudy.java.day02;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注解的应用：DI容器
 *
 * Created by lingb on 2018/7/11
 */
public class AnnotationDITest {

    private int count = 10;

    /**
     * 简单测试接口
     */
    public interface SimpleTest {
    }

//    /**
//     * @SimpleInject 简单注入，表达依赖关系
//     */
//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.FIELD)
//    public @interface SimpleInject {
//    }

//    /**
//     * @SimpleSingleton 单例模式
//     */
//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.TYPE)
//    public @interface SimpleSingleton {
//    }

    public class SimpleContainer {

        private Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

        //
//    public <T> T getInstance(Class<T> cls) {
//        try {
//            T obj = cls.newInstance();
//            // 获取本类所有属性
//            Field[] fields = cls.getDeclaredFields();
//            // 遍历
//            for (Field field : fields) {
//                if (field.isAnnotationPresent(SimpleInject.class)) {
//                    if (!field.isAccessible()) {
//                        field.setAccessible(true);
//                    }
//                    Class<?> fieldCls = field.getType();
//                    field.set(obj, getInstance(fieldCls));
//                }
//            }
//            return obj;
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }

        /**
         * 创建自身和依赖的对象实例
         *
         * @param   [cls]
         * @return  T
         */
        private  <T> T getInstance(Class<T> cls) {
            try {

                T obj = cls.newInstance();
                Field[] fields = cls.getDeclaredFields();
                System.out.println(Arrays.toString(fields));
                for (Field f : fields) {
                    // 若指定类型的注解标记在该属性上,则返回true，否则返回false
                    if (f.isAnnotationPresent(SimpleInject.class)) {
                        if (!f.isAccessible()) {
                            f.setAccessible(true);
                        }
                        // 返回该属性的类型
                        Class<?> fieldCls = f.getType();
                        // 将指定对象obj 即new ServiceA() 中该属性b的值设为 getInstance(fieldCls)得到的值 即new ServiceB()
                        // 换言之 b = new ServiceB()
                        f.set(obj, getInstance(fieldCls));
                    }
                }
                return obj;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }


        /**
         * 创建自身和依赖的单个对象实例，被所有访问的代码共享
         *
         * @param   [cls]
         * @return  T
         */
        public <T> T getSingletonInstance(Class<T> cls) {
            try {
                // 1、检查类型是否为单例，若不是，直接调用getInstance 创建对象；否则（若是），检查缓存
                // 2、缓存若有，直接返回；否则（若没有），则调用getInstance 创建对象，并放入缓存中
                boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
                if (!singleton) {
                    return getInstance(cls);
                }

                // 检查缓存
                Object obj = instances.get(cls);
                if (obj != null) {
                    return (T) obj;
                }

                synchronized (cls) {
                    obj = instances.get(cls);
                    if (obj == null) {
                        obj = getInstance(cls);
                        instances.put(cls, obj);
                    }
                }
                return (T) obj;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


/*
    class ServiceA {

        // ServiceA 对ServiceB 依赖
        @AnnotationDITest.SimpleInject
        private ServiceB b;

        public ServiceA(){
        }

        public void callB(){
            b.action();
        }

    }

    class ServiceB {

        public ServiceB(){
        }

        public void action() {
            System.out.println("I am B");
        }

    }*/


    @Test
    public void testAnnotationDI() {
//        new ServiceA().callB();

//        System.out.println(SimpleTest.class);
//        System.out.println(SimpleInject.class);
//        System.out.println(ServiceA.class);

        // 通过getInstance() 方法 获取对象实例，而不是自己new
        ServiceA a = new SimpleContainer().getSingletonInstance(ServiceA.class);
        a.callB();

    }

}
