package com.lingb.mystudy.java.day05.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口是Collection的子接口，set接口没有提供额外的方法
 *
 * Created by lingb on 2018/7/16
 */
public class SetTest {

    /**
     * TreeSet 是 SortedSet 接口的实现类，TreeSet 可以确保集合元素处于排序状态
     * comparator comparator()
     * Object first()
     * Object last()
     * Object lower(Object e)
     * Object higher(Object e)
     * SortedSet subSet(fromElement, toElement)
     * SortedSet headSet(toElement)
     * SortedSet tailSet(fromElement)
     * TreeSet 两种排序方法：自然排序和定制排序。默认情况下，TreeSet 采用自然排序（升序）
     *
     */

    @Test
    public void testTreeSet2() {
        // 1、创建一个实现了Comparator 接口的对象 匿名内部类
        // 2、将此对象即 comparator 接口的对象 作为形参传递给TreeSet的构造方法
        Set<Student> set = new TreeSet<>(new Comparator() {
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
        });
        // 3、向TreeSet中添加Comparator接口中的compare()方法中涉及的类的对象
        set.add(new Student(1, "CC"));
        set.add(new Student(3, "AA"));
        set.add(new Student(4, "AA"));
        set.add(new Student(2, "BB"));
        set.add(new Student(5, "HH"));
        set.add(new Student(5, "GG"));
        for (Student stu : set) {
            System.out.println(stu);

        }
    }


    /**
     * TreeSet：
     * compare() 与 hashCode 以及equals() 三者一致！
     *
     * 定制排序：TreeSet的自然排序是根据集合元素的大小，进行元素升序排列。如果需要定制排序，比如降序排列，可通过Comparator接口的帮助。需要重写compare(T o1,T o2)方法
     * 利用int compare(T o1,T o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2
     * 要实现定制排序，需要将实现Comparator接口的实例作为形参传递给TreeSet的构造器
     * 此时，仍然只能向TreeSet中添加类型相同的对象。否则发生ClassCastException异常
     * 使用定制排序判断两个元素相等的标准是：通过Comparator比较两个元素返回了0
     */
    @Test
    public void testTreeSet1() {
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

        // 2、将此对象即 comparator 接口的对象 作为形参传递给TreeSet的构造方法
        Set<Student> set = new TreeSet<>(com);
        // 3、向TreeSet中添加Comparator接口中的compare()方法中涉及的类的对象
        set.add(new Student(1, "CC"));
        set.add(new Student(3, "AA"));
        set.add(new Student(4, "AA"));
        set.add(new Student(2, "BB"));
        set.add(new Student(5, "HH"));
        set.add(new Student(5, "GG"));
        for (Student stu : set) {
            System.out.println(stu);

        }
    }
    
    /**
     * TreeSet:
     * 1、向TreeSet中添加的袁术必须同一个类的
     * 2、可以按照添加进集合中的元素的指定的顺序遍历，像String、包装类等默认按照升序遍历
     * 3、当向TreeSet中添加自定义类的对象时，有两种排序方法：①自然排序 ②定制排序
     * compareTo() 与 hashCode 以及equals() 三者一致！
     *
     * 自然排序：TreeSet 会调用集合元素的 compareTo(Object obj) 方法来比较每个元素之间的大小关系，然后将集合元素按升序排列
     * 如果试图把一个对象添加到 TreeSet 时，则该对象的类必须实现 java.lang.Comparable 接口，并重写compareTo()方法
     *
     * 实现 Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过 compareTo(Object obj) 方法的返回值来比较大小
     *
     */
    @Test
    public void testTreeSet() {
        Set<Integer> set = new TreeSet<>();
        set.add(1111);
        set.add(11);
        set.add(111);
        System.out.println(set);

        // 自然排序过程：
        // 新增的元素跟容器内已有的元素逐个比较compareTo(Object obj) obj是容器内已有的元素，即被比较的元素对象
        // 按照compareTo(Object obj) 比较结果添加，若新增的元素存在了，不增，反之按序规则插入
        Set<Person> set1 = new TreeSet<>();
        set1.add(new Person("CC", 1));
        set1.add(new Person("AA", 3));
        set1.add(new Person("AA", 2));
        set1.add(new Person("BB", 1));
        set1.add(new Person("GG", 1));
        for (Person p : set1) {
            System.out.println(p);

        }

    }
}
