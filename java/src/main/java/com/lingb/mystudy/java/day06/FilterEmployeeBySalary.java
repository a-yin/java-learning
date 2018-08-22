package com.lingb.mystudy.java.day06;

/**
 * Created by lingb on 2018/7/17
 */
public class FilterEmployeeBySalary implements MyProdicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
