package com.allst.jvalgo.leetcode2;

/**
 * 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * @author June
 * @since 2021年08月
 */
public class PdStringUnique {
    public static boolean isUnique(String astr) {
        // 用 flag 标记小写字母是否出现过。
        int flag = 0;
        for (char c : astr.toCharArray()) {
            int pos = c - 'a';
            if ((flag & (1 << pos)) != 0) {
                return false;
            }
            flag |= (1 << pos);
        }
        return true;
    }
}
