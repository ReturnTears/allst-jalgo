package com.allst.jvalgo.leetcode;

/**
 * 子数组最大平均数
 * 给一个整数数组， 找出平均数最大且长度为K的下标连续的子数组， 并输出该最大平均数
 * <p>
 * 采用滑动窗口算法
 *
 * @author June
 * @since 2021年06月
 */
public class AvgArray {
    public static void main(String... args) {
        System.out.println(findMaxAvg(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    private static double findMaxAvg(int[] num, int k) {
        int sum = 0;
        int n = num.length;
        // 统计第一个窗口的和
        for (int i = 0; i < k; i++) {
            sum += num[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum = sum - num[i - k] + num[i];
            max = Math.max(sum, max);
        }
        return 1.0 * max / k;
    }
}
