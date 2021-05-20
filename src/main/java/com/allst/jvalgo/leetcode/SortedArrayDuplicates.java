package com.allst.jvalgo.leetcode;

/**
 * 原地删除排序数组中重复项， 返回其删除后长度
 *
 * @author June
 * @since 2021年05月
 */
public class SortedArrayDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0, 1, 2, 2, 3, 3, 4}));
    }

    // 双指针算法
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 慢指针
        int i = 0;
        // 快指针
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
