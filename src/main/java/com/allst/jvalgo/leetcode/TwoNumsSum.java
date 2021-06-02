package com.allst.jvalgo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算一个数组中两个数相加的和等于给定的target值， 要求：数字元素不能重复使用，求出元素的下标
 *
 * @author June
 * @since 2021年06月
 */
public class TwoNumsSum {
    public static void main(String... args) {
        System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println(Arrays.toString(solution2(new int[]{1, 2, 3, 4, 5, 6}, 10)));
    }

    /**
     * 暴力破解法1
     * <p>
     * 时间复杂度 O(n2)
     *
     * @param nums   参数
     * @param target 目标值
     *
     * @return 结构
     */
    private static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 优化 暴力破解法1
     * 通过map标记法， 标记已经出现过的元素
     * 时间复杂度O(n)
     *
     * @param nums   参数
     * @param target 目标值
     *
     * @return 结果
     */
    private static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
