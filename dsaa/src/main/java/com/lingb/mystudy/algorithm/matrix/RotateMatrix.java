package com.lingb.mystudy.algorithm.matrix;

/**
 * Created by lingb on 2018-12-12
 */
public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        // 左行
        int a = 0;
        // 左列
        int b = 0;
        // 右行
        int c = matrix.length - 1;
        // 右列
        int d = matrix[0].length - 1;
        while (a < c) {
            rotateMatrix(matrix, a++, b++, c--, d--);
        }

    }

    /**
     * 顺时针旋转
     *
     * @param m
     * @param a
     * @param b
     * @param c
     * @param d
     */
    private static void rotateMatrix(int[][] m, int a, int b, int c, int d) {
        int times = c - a;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[a][b + i];
            m[a][b + i] = m[c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("============");
        printMatrix(matrix);
    }

}
