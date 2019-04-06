package com.lingb.mystudy.java.day12_4;

import java.io.File;
import java.util.Scanner;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.18 11:06
 */
public class FileDelete {

    /**
     * 删除当前路径下所有的文件和子文件夹
     */
    private static boolean deleteDir(String path) {
        if (path == null || "".equals(path)) {
            return false;
        }

        File file = new File(path);
        File[] files = file.listFiles();
        if (null != files) {
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();

                } else {
                    f.delete();
                    deleteDir(f.getAbsolutePath());
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(deleteDir(sc.nextLine()));
    }
}
