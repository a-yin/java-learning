package com.lingb.mystudy.java.day01;

import java.math.BigDecimal;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.10 20:31
 */
public class IntegerAndFloat {

    public static void main(String[] args) {

        /**
         * 4.02 是 double 浮点型（表示实数、近似值），int 整形（表示整数、准确值）
         * double -> int 强转后精度丢失（小数点后面全丢了）
         * 即 4.02 -> 4
         */
        long tmp = (int)4.02;
        System.out.println(tmp);
        System.out.println(tmp /= 2);
        System.out.println(tmp %= 2);


        /**
         * 涉及到【金额】推荐使用 BigDecimal(String val)
         */
        BigDecimal tmp1 = new BigDecimal(4.02);
        BigDecimal tmp2 = new BigDecimal("4.02");
        // 4.019999999999999573674358543939888477325439453125
        // 4.02
        System.out.println(tmp1);
        System.out.println(tmp2);

        // 2.0099999999999997868371792719699442386627197265625
        // 2.01
        System.out.println(tmp1.divide(new BigDecimal("2")));
        System.out.println(tmp2.divide(new BigDecimal("2")));

    }
}
