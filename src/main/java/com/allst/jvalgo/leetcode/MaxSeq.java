package com.allst.jvalgo.leetcode;

import java.util.Arrays;

/**
 * 贪心算法:
 * 1、最长连续递增序列 >>
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度
 * 2、三角形的最大周长 >>
 * 给定由一些正数(代表长度)组成的数组arr， 返回由其中三个长度组成的，面积不为0的三角形的最大周长
 * 如果不能形成任何面积不为0的三角形， 返回0
 *
 * @author June
 * @since 2021年06月
 */
public class MaxSeq {
    public static void main(String... args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7}));
        System.out.println(largestPerimeter(new int[]{3, 6, 3, 2}));
    }

    /**
     * 最长连续递增序列
     */
    private static int findLength(int[] nums) {
        int start = 0; // 开始索引
        int max = 0; // 最大序列长度
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    /**
     * 三角形的最大周长
     * 能够形成三角形的边长条件:
     *      a + b > c, 且 c > a, c > b
     */
    private static int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            if (a[i - 1] + a[i - 2] > a[i]) {
                return a[i - 1] + a[i - 2] + a[i];
            }
        }
        return 0;
    }
}
