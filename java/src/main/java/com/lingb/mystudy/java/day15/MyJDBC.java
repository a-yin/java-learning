package com.lingb.mystudy.java.day15;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lingb on 2018-12-04
 */
public class MyJDBC {

    private String url = "jdbc:mysql://localhost:3306/spider?useSSL=false&characterEncoding=utf8";
    private String user = "root";
    private String password = "root";

    @Test
    public void test1() {

    }

    @Test
    public void test() throws SQLException, ClassNotFoundException {


//        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

/*
        // 1.注册（加载）JDBC驱动类
        Driver driver = new com.mysql.jdbc.Driver();

        // 设置url、用户名和密码
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        // 2.连接数据库
        Connection conn = driver.connect(url, props);
        System.out.println(conn);
*/

    }

}
