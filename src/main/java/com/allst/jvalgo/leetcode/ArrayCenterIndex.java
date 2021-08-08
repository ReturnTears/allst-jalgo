package com.allst.jvalgo.leetcode;

import java.util.Arrays;

/**
 * 寻找数组的中心下标（中心下标是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和）
 *
 * @author June
 * @since 2021年05月
 */
public class ArrayCenterIndex {
    public static void main(String[] args) {
        final int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
