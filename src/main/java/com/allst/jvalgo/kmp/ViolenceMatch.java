package com.allst.jvalgo.kmp;

/**
 * 暴力匹配
 *
 * @author YiYa
 * @since 2020-03-17 下午 10:28
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "你好啊！我好啊！她好啊！";
        String str2 = "好啊！";
        int result = violenceMatch(str1, str2);
        System.out.printf("index = %d" , result);
    }

    // 暴力匹配算法实现(如果有多个匹配默认匹配到第一个~~~)
    public static int violenceMatch(String str1, String str2) {
        // 转换为字符数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        // 字符数组长度
        int s1Len = s1.length;
        int s2Len = s2.length;
        // 初始分别指向字符串的索引
        int i = 0;
        int j = 0;
        // 防止匹配时下标越界
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        }
        return -1;
    }

}
