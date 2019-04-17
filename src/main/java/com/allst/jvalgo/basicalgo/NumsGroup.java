package com.allst.jvalgo.basicalgo;

/**
 * 数字组合算法
 * @author June 2018-01-13
 * @version 1.0
 */
public class NumsGroup {
    public static void main(String[] args) {
        numsCombain();
    }

    /**
     * 有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数 都是多少
     *
     * 可以举一反三
     */
    private static void numsCombain() {
        int count = 0, num = 5;
        for (int i = 1; i < num; i++) {
            for (int j = 1; j < num; j++) {
                for (int k = 1; k < num; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                        System.out.println(i*100 + j*10 + k);
                    }
                }
            }
        }
        System.out.println("无重复三位数总数: " + count);
    }
}
