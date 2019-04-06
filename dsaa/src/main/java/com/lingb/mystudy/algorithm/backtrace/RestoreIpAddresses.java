package com.lingb.mystudy.algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP 地址
 *
 * @author lingb
 * @date 2019.03.10 19:15
 */
public class RestoreIpAddresses {

    /**
     * 回溯 + DFS
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses1(String s) {
        if (s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> ips = new ArrayList<>();
        dfs(ips, s, 0, 0);
        return ips;
    }

    /**
     * DFS 深度遍历
     *
     * @param ips
     * @param s
     * @param beginIndex
     * @param segment
     */
    private static void dfs(List<String> ips, String s, int beginIndex, int segment) {
        String[] p = null;
        if (segment == 4 && beginIndex == s.length()) {
            String ip = "" + p[0] + "." + p[1] + "." + p[2] + "." + p[3];
            ips.add(ip);
            return;

        } else if (segment < 4) {
            for (int i = 1; i < 4; i++) {
                if (beginIndex + i <= s.length()) {
                    p[segment] = s.substring(beginIndex, i);
                }

//                if (p[0] == "0" && p[segment])

            }
        }

    }

    /**
     * 暴力解
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> ips = new ArrayList<>();
        // 数字字符串分成4段，每一段的有效性---每一位长度小于3，大于0.数值小于等于255
        // 判定每一段的有效性，若有效则遍历下一段，共三层遍历
        for (int i = 1; i <= 3; i++) {
            String p1 = s.substring(0, i);
            if (isValid(p1)) {
                for (int j = i + 1; j <= 6; j++) {
                    String p2 = s.substring(i, j);
                    if (isValid(p2)) {
                        for (int k = j + 1; k <= 9; k++) {
                            String p3 = s.substring(j, k);
                            if (isValid(p3)) {
                                String p4 = s.substring(k);
                                if (isValid(p4)) {
                                    String ip = "" + p1 + "." + p2 + "." + p3 + "." + p4;
                                    ips.add(ip);
                                }
                            }
                        }
                    }

                }
            }
        }

        return ips;
    }

    private static boolean isValid(String p) {
        if (p.startsWith("0")) {
            return false;
        } else {
            return Integer.parseInt(p) <= 255;
        }
    }

    public static void main(String[] args) {
        String ipStr = "25525511135";
        List<String> ips = restoreIpAddresses(ipStr);
        System.out.print(ips);
    }
}
