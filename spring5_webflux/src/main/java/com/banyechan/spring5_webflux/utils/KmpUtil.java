package com.banyechan.spring5_webflux.utils;

public class KmpUtil {


    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
                // next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String a = "abacdefdawedasdncfgdasdfxvegsdad";
        String b = "dad";
        Long starts1 = System.currentTimeMillis();
        int result1 = KMP(a, b);
        Long end1 = System.currentTimeMillis();

        long re1 = end1 - starts1;

        System.out.println("----result1=" + result1 + "运行时间=" + (end1 - starts1));

        Long starts2 = System.currentTimeMillis();
        int result2 = forceFind(a, b);
        Long end2 = System.currentTimeMillis();

        long re2 = end2 - starts2;

        System.out.println("----result2=" + result2 + "运行时间=" + (end2 - starts2));

    }

    public static int forceFind(String t, String p) {
        int n = t.length();
        int m = p.length();
        int result = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (t.charAt(i) == p.charAt(j)) {
                if (j < m - 1) {
                    j++;
                    continue;
                } else {
                    result = i - m + 1;
                    break;
                }
            } else {
                j = 0;
            }
        }

        return result;
    }


    public static int bf(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();

        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置

        while (i < t.length && j < p.length) {
            if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归0
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
