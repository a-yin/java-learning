package com.lingb.mystudy.java.day05;

import org.junit.Test;

/**
 * 泛型，即类型参数化，处理的数据类型不是固定的，而是可以作为参数传入，
 * 类型参数编译时被替换为Object，应用于接口、类、方法，禁止创建泛型数组
 *
 * Created by lingb on 2018/7/14
 */
public class GenericsTest {

    /**
     * 上界为某个具体类
     * 限定类型后，若类型使用错误，编译器会提示，指定边界后，类型擦除时就不会转为Object 了，而是转为它的边界类型
     */
    private class NumberPair<U extends Number, V extends String, E extends Number> extends Pair<U, V, E> {
        public NumberPair(U first, V sencond, E third) {
            super(first, sencond, third);
        }

        public double sum(){
            return getFirst().doubleValue() + getThird().doubleValue();
        }
    }

    /**
     * 泛型类Pair 而U, V 类型参数
     *
     */
    private class Pair<U, V, E> {
        private U first;
        private V second;
        private E third;

        public Pair() {
        }

        public Pair(U first, V second, E third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public U getFirst() {
            return first;
        }

        public void setFirst(U first) {
            this.first = first;
        }

        public V getSecond() {
            return second;
        }

        public void setSecond(V second) {
            this.second = second;
        }

        public E getThird() {
            return third;
        }

        public void setThird(E third) {
            this.third = third;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    ", third=" + third +
                    '}';
        }
    }

    /**
     * 泛型实例方法 printArray
     * 注:
     * 1）一个方法是否泛型，与它所在的类是否泛型无关
     * 2）禁止用于静态变量和静态方法
     * 3）禁止通过类型参数创建对象
     *
     * @param   [inputArray]
     * @return  void
     */
    public <E> void printArray(E[] inputArray) {
        int count = 0;
        // 输出数组元素
        for ( E element : inputArray ){
            if (count == inputArray.length-1) {
                System.out.println(element);
                return;
            }

            System.out.print(element + ", ");
            count++;
        }
    }


    private <U, V, E> Pair<U, V, E> makePair(U first, V second, E third ) {
        Pair<U, V, E> pair = new Pair<>(first, second, third);
        return pair;
    }

    /**
     * 通过元素比较，找出一个泛型数组中的最大值
     * 要求T 必须实现Comparable 接口
     * @param   [array]
     * @return  T
     */
    private <T extends Comparable<T>> T max(T[] array) {

        T max = array[0];
        for (int i = 1; i< array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }


    @Test
    public void testGenericsClass() {

        // 泛型类在实例化时要指定类型参数的实际类型
        Pair<Integer, String, Integer> pair = new Pair<>(1, "2", 1);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        NumberPair<Integer, String, Integer> pair1 = new NumberPair<>(10, "20", 10);
        System.out.println(pair1.sum());

    }


    @Test
    public void testGenericsMethod() {

        // 创建不同类型数组： Integer, Double 和 Character
        // 注：基本类型不能用于实例化类型参数
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("整型数组元素为:");
        // 传一个整型数组
        printArray(intArray);

        System.out.println("\n双精度型数组元素为:");
        // 传一个双精度型数组
        printArray(doubleArray);

        System.out.println("\n字符型数组元素为:");
        // 传一个字符型数组
        printArray(charArray);

        //-------------------------------------------------
        System.out.println();
        // 与泛型类不同，泛型方法不需要指定类型参数的实际类型，Java编译器的功劳（语法糖）自动推断出来
        System.out.println(makePair(1, "2", 1));

        //-------------------------------------------------
        System.out.println("\n整型数组元素最大值为:" + max(intArray));
        System.out.println("\n双精度型数组元素最大值为:" + max(doubleArray));
        System.out.println("\n字符型数组元素最大值为:" + max(charArray));
    }

}



