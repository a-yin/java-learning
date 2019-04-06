package com.lingb.mystudy.java.day07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.31 20:28
 */
public class StreamTest1 {


    /**
     * Stream（接口）产生的原因：
     * 1.对数组和集合的操作（增、删、改、查、聚合、统计、过滤、排序等）不便捷
     * 2.实现类SQL 声明式（编程）处理数据
     *
     * Stream 的特性：
     * 1.无存储。Stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等
     * 2.为函数式编程而生。对Stream的任何修改都不会修改背后的数据源，比如对Stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新Stream。
     * 3.惰式执行。Stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
     * 4.可消费性。Stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
     *
     *
     */

    /**
     * Stream 的创建（方式），以串行流为例
     * 1.通过集合类的 stream()创建，常用
     * 2.通过Stream接口的 of()创建
     */
    @Test
    public void testStreamInstance() {
        // 1.
        List<Integer> nums = Arrays.asList(2, 0, 1, 9, 0, 3, 3, 1);
        Stream<Integer> stream = nums.stream();
        stream.forEach(System.out::print);

        // 2.
        Stream<String> stream1 = Stream.of("Hello", "World");
    }

    /**
     * Stream 中间操作 得到的结果还是一个Stream
     * （Stream有很多中间操作，多个中间操作可以连接起来形成一个流水线，每一个中间操作就像流水线上的一个工人，每人工人都可以对流进行加工，加工后得到的结果还是一个流）
     * 操作      |                目标                       |        输入
     * filter   | 根据指定predicate过滤元素                   |      Predicate
     * map      | 处理和转换元素                             |      Function
     * limit    | 限制结果数量                               |        int
     * sorted   | 流中排序元素                               |      Comparator
     * distinct |根据给定类型的equals方法删除重复的迭代（去重）|
     *
     */
    @Test
    public void testIntermediateOperation() {

        Stream<String> stream = Stream.of("Hello", "", "World", "!");
        // filter() 用于通过设置的条件过滤出元素
        // 中间操作过滤空字符串，产生新的中间流
        // str -> !str.isEmpty() 中的 str 指代Stream 中元素
        Stream<String> midStream = stream.filter(str -> !str.isEmpty());

        // map() 用于映射每个元素到对应的结果
        List<Integer> nums = Arrays.asList(2, 0, 1, 9, 0, 3, 3, 1);
        // 中间操作使元素值变成元素值平方数，产生新的中间流
        Stream<Integer> midStream1 = nums.stream().map(i -> i * i);

        // limit() 返回Stream 的前面n 个元素
        Stream<Integer> midStream2 = nums.stream().limit(3);

        // skip() 是扔掉前n 个元素
        Stream<Integer> midStream3 = nums.stream().skip(3);

        // sorted() 对流元素进行排序
        Stream<Integer> midStream4 = nums.stream().sorted();

        // distinct() 去重
        Stream<Integer> midStream5 = nums.stream().distinct();
    }

    /**
     * Stream 最终操作
     *（最终操作会消耗流，产生一个最终结果。也就是说，在最终操作之后，不能再次使用流，也不能在使用任何中间操作，否则将抛出异常：java.lang.IllegalStateException: stream has already been operated upon or closed）
     * 操作      |          目标          |        输入
     * forEach  | 迭代并输出每一个流中元素 |       Consumer
     * count    | 统计流中的元素个数      |
     * collect  | 将流缩减为所需的集合    |
     *
     */
    @Test
    public void testTerminalOperation() {
        // forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // count
        Stream<String> stream = Stream.of("Hello", "", "World", "!");
        System.out.println(stream.count());

        // collect
        List<Integer> nums = Arrays.asList(2, 0, 1, 9, 0, 3, 3, 1);
        List<Integer> result = nums.stream().collect(Collectors.toList());
        result.forEach(System.out::print);
    }
}


