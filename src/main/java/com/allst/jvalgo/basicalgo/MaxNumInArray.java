package com.allst.jvalgo.basicalgo;

/**
 * 求n个数中最大者的问题
 *
 * @author Hutu
 * @since 2024-05-17 下午 10:21
 */
public class MaxNumInArray {
    public static void main(String[] args) {
        int[] a = {12, 21, 13, 54, 25, 16, 37, 28, 79, 10};
        int max = a[0];
        for (int i : a) {
            if (i > max)
                max = i;
        }
        System.out.println("最大值：" + max);
    }
}
