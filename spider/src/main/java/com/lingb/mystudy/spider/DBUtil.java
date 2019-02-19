package com.lingb.mystudy.spider;

import java.sql.*;

/**
 * 数据连接类
 * <p>
 * Created by lingb on 2018-11-25
 */
public class DBUtil {

    public Connection conn = null;

    public DBUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/spider?useSSL=false&characterEncoding=utf8";
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("conn built");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runSql(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        return sta.executeQuery(sql);
    }

    public boolean runSql2(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        return sta.execute(sql);
    }

    @Override
    protected void finalize() throws Throwable {
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        new DBUtil();
    }
}
