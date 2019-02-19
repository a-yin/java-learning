package com.lingb.mystudy.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 爬虫类
 * <p>
 * Created by lingb on 2018-11-25
 */
public class  MySpider {


    /**
     * 一个经典的爬虫程序步骤：

        1.解析根网页（“mit.edu”）,并从这个网页得到它所有的链接。获取每个URL并解析HTML页面，使用Jsoup来处理，Jsoup是一个好用而且方便的java库。


        2.使用步骤1返回回来的URL，解析这些URL。


        3.在做上面两个步骤的时候，需要跟踪哪些页面是之前已经被处理了的，那样的话，每个页面只需被处理一次。这也是为什么需要数据库的原因了。

     */


    public static DBUtil dbUtil = new DBUtil();

    public static void main(String[] args) throws SQLException, IOException {
        dbUtil.runSql2("TRUNCATE record;");
//        processPage("http://www.mit.edu");
        processPage("http://210.38.137.126:8016/xs_main.aspx");
    }

    public static void processPage(String url) throws SQLException, IOException {
        // 检查一下是否给定的URL已经在数据库中
        String sql = "SELECT * FROM record WHERE url = '" + url + "'";
        ResultSet rs = dbUtil.runSql(sql);
        if (rs.next()) {

        } else {
            // 将uRL存储到数据库中避免下次重复
            sql = "INSERT INTO  `spider`.`record` " + "(`url`) VALUES " + "(?);";
            PreparedStatement stmt = dbUtil.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, url);
            stmt.execute();

            //得到有用的信息
            Document doc = Jsoup.connect("http://210.38.137.126:8016/xs_main.aspx").get();

            if (doc.text().contains("research")) {
                System.out.println(url);
            }

            // 得到所有的链接，并递归调用
            Elements questions = doc.select("a[href]");
            for (Element link : questions) {
                if (link.attr("href").contains("http://210.38.137.126:8016/default2.aspx")) {
                    processPage(link.attr("abs:href"));
                }
            }
        }
    }
}
