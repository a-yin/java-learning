package com.lingb.mystudy.java.day07;

import com.lingb.mystudy.java.day06.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream API
 *
 * Created by lingb on 2018/7/18
 */
public class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("AA", 12, 1111.11),
            new Employee("BB", 22, 2222.22),
            new Employee("CC", 50, 3333.33),
            new Employee("DD", 40, 4444.44),
            new Employee("GG", 35, 6666.66),
            new Employee("EE", 55, 5555.55)
    );

    /**
     * 创建Stream 对象
     */
    @Test
    public void test1(){
        // 1、Java8 中的Collection 接口被扩展，提供了两个获取流的方法：
        //      default Stream<E> stream() : 返回一个顺序流（串行流）
        //      default Stream<E> parallelStream() : 返回一个并行流
        // Collection接口的实现类对象.stream()
        Collection<String> coll = new ArrayList<>();
        Stream<String> stream = coll.stream();
        System.out.println(stream);

        // Java8 中的Arrays 的静态方法stream() 可以获取数组流
        // 2、Arrays.stream()
        Integer[] integers = new Integer[]{11, 22, 33};
        Stream<Integer> stream1 = Arrays.stream(integers);
        System.out.println(stream1.toArray());
        System.out.println(stream1.toString());

        // 3、由值创建流
        // Stream类静态方法 Stream.of()
        Stream<List> stream2 = Stream.of(employees);

        // 4、由函数创建流：创建无限流
        // Stream类静态方法
        // 迭代：Stream.iterate()
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2)
                                        .limit(10);

        stream3.forEach(System.out::println);

        // 生成：Stream.generate()
        Stream.generate(() -> Math.random())
              .limit(5)
              .forEach(System.out::println);
    }


    // 优化方式四：Stream API
    @Test
    public void test(){
        employees.stream()
                 .filter((employee -> employee.getSalary() > 6000))
                 .forEach(System.out::println);

        System.out.println("-------------------------------------");

        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
    }
}
