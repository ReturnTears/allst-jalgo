package com.allst.jvalgo.leetcode;

import java.util.Arrays;

/**
 * 合并有序数组
 * 两个有序整数数组1，2，将2合并到1中，使1成为一个有序数组
 *
 * @author June
 * @since 2021年06月
 */
public class MergeSortArray {
    public static void main(String... args) {
        int[] num1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] num2 = new int[]{2, 4, 6, 8};

        // System.out.println(Arrays.toString(merge(num1, 5, num2, 4)));
        System.out.println(Arrays.toString(merge3(num1, 5, num2, 4)));
    }

    /**
     * 合并数组
     * 时间复杂度O((m+n)log(m+n))
     * 空间复杂度优异
     *
     * @param num1 数组1
     * @param m    参数m: 指定数组1中元素个数
     * @param num2 数组2
     * @param n    参数n: 指定数组2中元素个数
     *
     * @return 结果：合并后数组
     */
    private static int[] merge(int[] num1, int m, int[] num2, int n) {
        /*
         * 参数依次介绍：要拷贝的数组，开始拷贝的位置，目标数组，拷贝到目标数组的那个开始下标，拷贝的元素长度
         */
        System.arraycopy(num2, 0, num1, m, n);
        Arrays.sort(num1);
        return num1;
    }

    /**
     * 利用原数组的有序特性，采用双指针算法
     */
    private static int[] merge2(int[] num1, int m, int[] num2, int n) {
        int[] num1_copy = new int[m];
        System.arraycopy(num1, 0, num1_copy, 0, m);
        int p1 = 0; // 指向num1_copy
        int p2 = 0; // 指向num2
        int p = 0;  // 指向num1
        while (p1 < m && p2 < n) {
            num1[p++] = num1_copy[p1] < num2[p2] ? num1_copy[p1++] : num2[p2++];
        }
        // 如果num1_copy先拷贝完成
        if (p1 < m) {
            System.arraycopy(num1_copy, p1, num1, p1 + p2, m + n - p1 - p2);
        }
        // 如果num2先拷贝完成
        if (p2 < n) {
            System.arraycopy(num2, p2, num1, p1 + p2, m + n - p1 - p2);
        }
        return num1;
    }

    /**
     * 利用原数组的有序特性,采用从数组元素倒序比较进行判断，使用双指针算法
     */
    private static int[] merge3(int[] num1, int m, int[] num2, int n) {
        int p1 = m -1;
        int p2 = n -1;
        int p = m + n - 1; // num1最后一个元素的下标
        while (p1 >= 0 && p2 >= 0) {
            num1[p--] = num1[p1] < num2[p2] ? num2[p2--] : num1[p1--];
        }
        System.arraycopy(num2, 0, num1, 0, p2 + 1);
        return num1;
    }
}
