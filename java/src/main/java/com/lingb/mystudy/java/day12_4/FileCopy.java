package com.lingb.mystudy.java.day12_4;

import java.io.*;
import java.util.Scanner;

/**
 * File 工具类
 *
 * @author lingb
 * @date 2019.03.17 11:17
 */
public class FileCopy {

    /**
     * 把源文件夹下的所有子文件夹及文件 复制到 目标文件夹下
     */

    public static void copyDir(String srcDirPath, String dstDirPath) throws IOException {
        // 参数判空
        if (null == srcDirPath || "".equals(srcDirPath) || null == dstDirPath || "".equals(dstDirPath)) {
            return;
        }

        // 创建目标文件夹
        File dstFile = new File(dstDirPath);
        if (!dstFile.exists()) {
            dstFile.mkdir();
        }

        // 创建源文件夹
        File srcFile = new File(srcDirPath);
        if (srcFile.exists()) {
            File[] subFiles = srcFile.listFiles();
                if (subFiles != null) {
                // 遍历源文件夹路径下的所有子文件夹及文件
                for (File subFile : subFiles) {
                    // 如果是一个子文件夹
                    if (subFile.isDirectory()) {
                        // subFile.getAbsolutePath() 等价于 srcDirPath + "\\" + subFile.getName()
                        copyDir(srcDirPath + "\\" + subFile.getName(), dstDirPath + "\\" + subFile.getName());

                        // 反之是一个文件
                    } else {
                        copyFile(srcDirPath + "\\" + subFile.getName(), dstDirPath + "\\" + subFile.getName());
                    }
                }
            }
        }
    }

    public static void copyFile (String srcDirPath, String dstDirPath) throws IOException {
        // 参数判空
        if (srcDirPath == null || srcDirPath.equals("") || dstDirPath == null || dstDirPath.equals("")) {
            return;
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcDirPath));
            bos = new BufferedOutputStream(new FileOutputStream(dstDirPath));
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }

        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String srcDirPath = sc.nextLine();
        String dstDirPath = sc.nextLine();
        copyDir(srcDirPath, dstDirPath);
    }
}
