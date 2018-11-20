package com.lingb.mystudy.java;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by lingb on 2018-10-15
 */
public class TranslatorTest {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String from = sc.nextLine();

//        WordTable wt = getWordTable(translate(from));
//        WordTable wt = convertToJavaBean(translate(from), WordTable.class);
        WordTable wt = (WordTable) XmlUtils.getObject(translate(from), WordTable.class);
        System.out.println(wt.toString());

    }


    public static String translate(String from) throws IOException {
        URL url = new URL("http://ws.webxml.com.cn//WebServices/TranslatorWebService.asmx/getEnCnTwoWayTranslator?Word=" + from);

        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        String tmp = null;
        String xmlStr = "";

        while ((tmp = bf.readLine()) != null) {
            xmlStr += tmp;
        }

        System.out.println(xmlStr);
        bf.close();

        return xmlStr;
    }



    /**
     * xml转换成JavaBean
     *
     * @param xml xml格式字符串
     * @param t 待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> t) throws Exception {
        T obj = null;
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        obj = (T) unmarshaller.unmarshal(new StringReader(xml));
        return obj;
    }



    /**
     * 提取XML格式字符串中的信息
     * 获取WordTable对象
     *
     * @param   [xmlStr]
     * @return  com.lingb.mystudy.java.WordTable
     */
    public static WordTable getWordTable(String xmlStr) throws Exception {

        WordTable wordTable = new WordTable();
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        System.out.println(dbf);
//        DocumentBuilder builder = dbf.newDocumentBuilder();
////        InputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
////        Document doc = builder.parse(inputStream);
//
//        StringReader sr = new StringReader(xmlStr);
//        InputSource is = new InputSource(sr);
//        Document doc = builder.parse(is);


        StringReader stringReader = new StringReader(xmlStr);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = documentBuilder.parse(inputSource);
        System.out.println(doc);

        // 下面开始读取
        Element root = doc.getDocumentElement(); // 获取根元素
        NodeList nodes = root.getElementsByTagName("ArrayOfString");
        for (int i = 0; i < nodes.getLength(); i++) {
            // 一次取得每一个子元素
            Element ss = (Element) nodes.item(i);

            NodeList names = ss.getElementsByTagName("string");
            Element e = (Element) names.item(0);
            Node t = e.getFirstChild();
            wordTable.setFrom(t.getNodeValue());
            System.out.println(t.getNodeValue());

            NodeList ages = ss.getElementsByTagName("string");
            e = (Element) ages.item(0);
            t = e.getFirstChild();
            wordTable.setTo((t.getNodeValue()));
            System.out.println(t.getNodeValue());

        }

        return wordTable;
    }


}
