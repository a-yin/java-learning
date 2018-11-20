package com.lingb.mystudy.java;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lingb on 2018-10-15
 */
public class XmlUtils {

    public XmlUtils() {}

    /**
     * xml文档Document转对象
     *
     * @param document  
     * @param clazz
     * @return
     */
    public static Object getObject(Document document, Class<?> clazz) {
        Object obj = null;
        //获取根节点
        Element root = document.getRootElement();
        try {
            obj = clazz.newInstance();//创建对象
            List<Element> properties = root.elements();
            for (Element pro : properties) {
                //获取属性名(首字母大写)
                String propertyname = pro.getName();
                String propertyvalue = pro.getText();
                Method m = obj.getClass().getMethod("set" + propertyname, String.class);
                m.invoke(obj, propertyvalue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * xml字符串转对象
     *
     * @param xmlString  
     * @param clazz
     * @return
     */
    public static Object getObject(String xmlString, Class<?> clazz) throws Exception {
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlString);
        } catch (DocumentException e) {
            throw new Exception("获取Document异常" + xmlString);
        }
        //获取根节点
        return getObject(document, clazz);
    }

    /**
     * 对象转xml文件
     *
     * @param b
     * @return
     */
    public static Document getDocument(Object b) {
        Document document = DocumentHelper.createDocument();
        try {
// 创建根节点元素
            Element root = document.addElement(b.getClass().getSimpleName());
            Field[] field = b.getClass().getDeclaredFields(); // 获取实体类b的所有属性，返回Field数组
            for (int j = 0; j < field.length; j++) { // 遍历所有有属性
                String name = field[j].getName(); // 获取属属性的名字
                if (!name.equals("serialVersionUID")) {//去除串行化序列属性
                    name = name.substring(0, 1).toUpperCase()
                            + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    Method m = b.getClass().getMethod("get" + name);
// System.out.println("属性get方法返回值类型:" + m.getReturnType());
                    String propertievalue = (String) m.invoke(b);// 获取属性值
                    Element propertie = root.addElement(name);
                    propertie.setText(propertievalue);
                }
            }


        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();


        }

        return document;
    }

    /**
     * 对象转xml格式的字符串
     *
     * @param b
     * @return
     */
    public static String getXmlString(Object b) {
        return getDocument(b).asXML();
    }

}
