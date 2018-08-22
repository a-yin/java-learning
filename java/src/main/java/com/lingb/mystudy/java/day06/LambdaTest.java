package com.lingb.mystudy.java.day06;

import org.junit.Test;

import java.util.*;

/**
 * Lambda 表达式：紧凑式传递
 *               （可以理解为Lambda表达式是匿名内部类的一种优化方式，但不是匿名内部类）
 *
 * Created by lingb on 2018/7/17
 */
public class LambdaTest {

    List<Employee> employees = Arrays.asList(
            new Employee("AA", 12, 1111.11),
            new Employee("BB", 22, 2222.22),
            new Employee("CC", 50, 3333.33),
            new Employee("DD", 40, 4444.44),
            new Employee("GG", 35, 6666.66),
            new Employee("EE", 55, 5555.55)
    );

    @Test
    public void test() {
        // 匿名内部类
        new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World！");
            }
        }.run();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World！");
            }
        };
        r.run();

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        Set<Integer> treeSet = new TreeSet<>(com);

    }

    @Test
    public void test1() {
        // Lambda 表达式（一段可以传递的代码，即代码像数据一样进行传递）
        // 语法：方法参数 -> 方法体
        // 要求：
        // 1、只包含一个抽象方法的接口，称为函数式接口
        // 2、
        Runnable r1 = () -> System.out.println("Hello Lambda！");
        r1.run();

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Set<Integer> treeSet = new TreeSet<>(com);


    }


    @Test
    public void test2() {

        List<Employee> employees1 = filterEmployees(employees);
        for (Employee employee : employees1) {
            System.out.println(employee);
        }
    }

    // 优化方式一:策略设计模式
    @Test
    public void test3() {

        List<Employee> employees1 = filterEmployees(employees, new FilterEmployeeByAge());
        for (Employee employee : employees1) {
            System.out.println(employee);
        }

        System.out.println();

        List<Employee> employees2 = filterEmployees(employees, new FilterEmployeeBySalary());
        for (Employee employee : employees2) {
            System.out.println(employee);
        }
    }

    // 优化方式二：匿名内部类
    @Test
    public void test4() {

        List<Employee> emps = filterEmployees(employees, new MyProdicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 6000;
            }
        });

        System.out.println(emps);

    }


    // 优化方式三：Lambda 表达式
    @Test
    public void test5(){

        List<Employee> emps = filterEmployees(employees, (e) -> e.getSalary() <= 6000);
        emps.forEach(System.out::println);
    }

    // 优化方式四：Stream API
    @Test
    public void test6(){
        employees.stream()
                 .filter((employee -> employee.getSalary() > 6000))
                 .forEach(System.out::println);

        System.out.println("-------------------------------------");

        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
    }

    // 需求：获取当前公司中员工年龄大于35岁的员工信息
    public List<Employee> filterEmployees(List<Employee> employees) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getAge() >= 35) {
                emps.add(emp);
            }
        }

        return emps;

    }


    public List<Employee> filterEmployees(List<Employee> list, MyProdicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();

        for (Employee emp : list) {
            if (mp.test(emp)) {
                emps.add(emp);
            }
        }

        return emps;

    }
}
