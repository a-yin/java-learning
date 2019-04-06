package com.lingb.mystudy.datastructure.day05;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by lingb on 2018/8/27
 */
public class HanoiTowerTest {

    @Test
    public void test1() {
        HanoiTower.doTower(3, 'A', 'B', 'C');
    }


    @Test
    public void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            n++;
            System.out.println(n);
//            return;

        } else {
            System.out.println(n);
        }

//        n = n + 2;
//
//        System.out.println(n);
    }
    
    public static void test(int n) {

    }


}
