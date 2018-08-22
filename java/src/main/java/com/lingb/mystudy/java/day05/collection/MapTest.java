package com.lingb.mystudy.java.day05.collection;

import org.junit.Test;

import java.util.*;

/**
 * Map接口与Collection接口并列存在。用于保存具有映射关系的数据:Key-Value
 *
 * Created by lingb on 2018/7/16
 */
public class MapTest {
    
    /**
     * TreeMap: 按照添加进Map中的元素的key的指定属性进行排序。
     * 要求： key必须是同一个类的对象，即泛型实现了
     *
     * Map 中的 key 和  value 都可以是任何引用类型的数据
     * Map 中的 key 用Set来存放，不允许重复，即同一个 Map 对象所对应的类，须重写hashCode()和equals()方法。
     * 常用String类作为Map的“键”。
     * key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到唯一的、确定的 value。
     *
     */


    /**
     * 自定制排序
     *
     * @param   []
     * @return  void
     */
    @Test
    public void testTreeMap1() {
        // 1、创建一个实现了Comparator 接口的对象
        Comparator com = new Comparator() {
            // 向TreeSet 总添加Student类的对象，在此compare() 方法中，指明是按照Student的哪个属性排序的
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student stu1 = (Student) o1;
                    Student stu2 = (Student) o2;
                    int i = stu1.getId().compareTo(stu2.getId());
                    if (i == 0) {
                        return stu1.getName().compareTo(stu2.getName());

                    } else {
                        return i;
                    }

                }
                return 0;
            }
        };

        // 2、将此对象即 Comparator 接口的对象 作为形参传递给TreeSet的构造方法
        Map<Integer, Student> map = new TreeMap<>(com);
        // 3、向TreeSet中添加Comparator接口中的compare()方法中涉及的类的对象
        map.put(111, new Student(1, "CC"));
        map.put(222, new Student(3, "AA"));
        map.put(333, new Student(4, "AA"));
        map.put(444, new Student(2, "BB"));
        map.put(555, new Student(5, "HH"));
        map.put(666, new Student(5, "GG"));

        // 遍历Map
        // 方式一：
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key + "--->" + map.get(key));
        }

        System.out.println();

        // 方式二：
        Set<Map.Entry<Integer, Student>> set1 = map.entrySet();
        for (Map.Entry entry : set1) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }


    /**
     * 自然排序
     *
     * @param   []
     * @return  void
     */
    @Test
    public void testTreeMap() {
        Map<Integer, Person> map = new TreeMap<>();
        map.put(111, new Person("AA", 12));
        map.put(222, new Person("BB", 21));
        map.put(333, new Person("CC", 30));

        // 遍历Map
        // 方式一：
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key + "--->" + map.get(key));
        }

        System.out.println();

        // 方式二：
        Set<Map.Entry<Integer, Person>> set1 = map.entrySet();
        for (Map.Entry entry : set1) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }


    /**
     * 如何遍历Map：
     * Set keySet()
     * Collection values()
     * Set entrySet()
     *
     */
    @Test
    public void testMap1() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put(111, "aa");
        map.put(333, "cc");
        map.put(222, "bb");
        map.put(null, null);
        map.put("444", new Person("dd", 444));

        // 1、遍历key集
        Set<Object> set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }

        // 2、遍历value集
        Collection<Object> coll = map.values();
        for (Object o : coll) {
            System.out.println(coll);
        }

        // 3、如何遍历key-value对
        // 方式一：
        Set<Object> set1 = map.keySet();
        for (Object o : set1) {
            System.out.println(o + "--->" + map.get(o));
        }

        // 方式二：
        Set set2 = map.entrySet();
        for (Object o : set2) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    
    /**
     * HashMap: key 用Set存放的，不可重复；value 用collection存放的，可重复
     * 1、一个key-value对，是一个Entry，所有Entry也是Set存放的，不可重复
     * 2、向HashMap中添加元素时，会调用key所在类的equals() 方法，
     *    判断两个key是否相同，若相同，只能添加后添加的那个元素
     *
     * 元素添加、删除操作：
     * Object put(Object key,Object value):向Map 添加一个元素
     * Object remove(Object key)：根据key删除指定元素
     * void putAll(Map t)：添加新的Map进来
     * void clear()：清空
     * 元素查询的操作：
     * Object get(Object key)：获取指定key的value，若无此key，返回null
     * boolean containsKey(Object key):
     * boolean containsValue(Object value)
     * int size():获取Map的长度
     * boolean isEmpty()：判断是否为空
     * boolean equals(Object obj)
     *
     */
    @Test
    public void testMap() {
        Map<Object, Object> map = new HashMap<>();
        map.put(111, "aa");
        map.put(333, "cc");
        map.put(222, "bb");
        map.put(null, null);
        map.put(444, new Person("dd", 444));
        map.put(444, new Person("ee", 444));
        System.out.println(map.size());
        System.out.println(map);



    }
}
