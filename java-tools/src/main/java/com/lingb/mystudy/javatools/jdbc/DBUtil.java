package com.lingb.mystudy.javatools.jdbc;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.util.Properties;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.29 13:12
 */
public class DBUtil {

    private static Connection conn = null;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mystudy?characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "root";

    static {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            Properties p = new Properties();
            p.setProperty(user, user);
            p.setProperty(password, password);
            conn = driver.connect(url, p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement(String sql) throws SQLException {
        return new PreparedStatement((MySQLConnection) conn, sql);
    }
}
