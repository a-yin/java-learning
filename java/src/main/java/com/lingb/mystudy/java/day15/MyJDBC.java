package com.lingb.mystudy.java.day15;

import org.junit.Test;

import java.net.Socket;
import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by lingb on 2018-12-04
 */
public class MyJDBC {

    private String url = "jdbc:mysql://localhost:3306/mystudy?autoReconnect=true&useSSL=false&characterEncoding=utf8";
    private String user = "root";
    private String password = "root";

    public User initUser() {
        User user = new User();
        user.setName("aa");
        user.setPassword("aa");
        user.setLoginDateTime(String.valueOf(LocalDateTime.now().withNano(0)));
        user.setLoginIp(String.valueOf(new Socket().getLocalAddress()));
        user.setMobile("12345678901");
        System.out.println(user);
        return user;

    }

    @Test
    public void test(){

        // 【推荐】1.加载MySQL数据库驱动类
        try {
            // 成功加载后，会将Driver类的实例注册到DriverManager类中
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动类，加载驱动失败！");
            e.printStackTrace();
        }

        // 2.DriverManager获取连接对象，连接数据库
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }

        /*
         3.获取Statement 实例对象，执行SQL语句
         要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3种类型
         1）执行静态SQL语句。通常通过Statement实例实现
         Statement stmt = conn.createStatement() ;
         2）执行动态SQL语句。通常通过PreparedStatement实例实现
         String sql = "insert into tb_user(name,password) values (?,?)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, user.getName());
         pstmt.setString(2, user.getPassword());
         3）执行数据库存储过程。通常通过CallableStatement实例实现
         CallableStatement cstmt = con.prepareCall("{CALL demoSp(? , ?)}") ;

         Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate和execute
         执行静态SQL语句
         1）ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句，返回一个结果集（ResultSet）对象
         2）int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等
         3）execute(sqlString):用于执行返回多个结果集（ResultSet）对象、多个更新计数或二者组合的语句

         PreparedStatement 接口同样三种执行SQL语句的方法：executeQuery 、executeUpdate和execute
         执行动态SQL语句
         */
        try {
            User user = initUser();
            String insertSQL = "insert into tb_user(name, password, login_datetime, login_ip, mobile) values(?,?,?,?,?)";
            String selectSQL = "select * from tb_user";

            if (conn != null) {
                Statement stmt = conn.createStatement();
/*//                int row = stmt.executeUpdate(insertSQL);
                ResultSet rs = stmt.executeQuery(selectSQL);
//                boolean flag = stmt.execute()*/

                PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getLoginDateTime());
                pstmt.setString(4, user.getLoginIp());
                pstmt.setString(5, user.getMobile());
                pstmt.executeUpdate(insertSQL);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void test1() {

        // 【不推荐】 1.注册（加载）JDBC驱动类
        // 注册数据库驱动方法不当导致出现了两次注册，程序通用性低
          /*
          public class Driver extends NonRegisteringDriver implements java.sql.Driver {

          // Register ourselves with the DriverManager

        static {
            try {
                java.sql.DriverManager.registerDriver(new Driver());
            } catch (SQLException E) {
                throw new RuntimeException("Can't register driver!");
            }
         }


           */
//        Driver driver = null;
//        try {
//            driver = new com.mysql.jdbc.Driver();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // 设置url、用户名和密码
//        Properties props = new Properties();
//        props.setProperty("user", user);
//        props.setProperty("password", password);
//
//        // 2.连接数据库
//        Connection conn1 = null;
//        try {
//            conn1 = driver.connect(url, props);
//        } catch (SQLException e) {
//            System.out.println("数据库连接失败！");
//            e.printStackTrace();
//        }
//        System.out.println(conn1);

    }

}
