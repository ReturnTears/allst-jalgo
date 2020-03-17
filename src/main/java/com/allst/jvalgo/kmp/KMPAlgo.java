package com.allst.jvalgo.kmp;

/**
 * KMP算法
 *
 * @author YiYa
 * @since 2020-03-17 下午 11:15
 */
public class KMPAlgo {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
    }

    /**
     * KMP算法
     * @param str1 源串
     * @param str2 子串
     * @param next 部分匹配表
     * @return 结果
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return  -1;
    }

    // 获取子串的部分匹配值表
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // KMP 算法的核心
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[ j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
