package com.lingb.mystudy.java;

/**
 * 子类测试类
 *
 * @author lingb
 * @date 2019.03.03 16:38
 */
public class SubClassTest extends SuperClassTest implements InterfaceTest {

    /**
     * 重载发生在 同一个类
     */
    public void testOverload(String str) {
        System.out.println(str);
    }

    /**
     * 重载报错！！ 返回值类型不同无法重载
     *
     * @return
     */
//    public String testOverload(String str) {
//        return str + "返回类型为 String";
//    }

    /**
     * 重载正确！！ 参数列表不同（类型不同）
     *
     * @param i
     */
    public void testOverload(int i) {
    }

    /**
     * 重载正确！！ 参数列表不同（个数不同）
     *
     * @param str
     */
    public void testOverload(String str, String str1) {
    }

    /**
     * 重载正确！！ 参数列表不同（类型、个数均不同）
     *
     * @param str
     * @param num
     */
    public void testOverload(String str, int num) {
    }



    /**
     * 重写发生在 父类与子类、接口与实现类
     */

    /**
     * 重写报错！！ 返回值类型不同
     *
     */
//    @Override
//    public String testSuperClassOverride() {
//        System.out.println("子类测试类。。报错");
//    }

//    @Override
//    public String testInterfaceOverride() {
//        System.out.println("子类测试类。。报错");
//    }

    /**
     * 重写报错！！ 参数列表不同（类型、个数）
     *
     * @param str
     */
//    @Override
//    public void testSuperClassOverride(String str) {
//        System.out.println("子类测试类。。报错");
//    }

//    @Override
//    public void testInterfaceOverride(String str) {
//        System.out.println("子类测试类。。报错");
//    }


    /**
     * 重写正确，返回类型 + 参数列表 均相同
     */
    @Override
    public void testSuperClassOverride() {
        System.out.println("子类测试类继承父类重写testSuperClassOverride 正确！");
    }

    @Override
    public void testInterfaceOverride() {
        System.out.println("子类测试类实现接口重写testInterfaceOverride 正确！");
    }
}
