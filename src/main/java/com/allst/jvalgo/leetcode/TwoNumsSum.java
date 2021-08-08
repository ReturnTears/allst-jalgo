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
        System.out.println(Arrays.toString(solution3(new int[]{1, 2, 3, 4, 5, 6}, 10)));
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

    /**
     * 二分查找
     * 给定一个升序排列的整数数组numbers, 从数组中找出两个满足相加之和等于目标数target
     *
     * @return 返回元素的下标
     */
    private static int[] solution3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i, mid};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{0};
    }

    /**
     * 双指针算法
     * 一个指针向左移， 一个指针向右移， 直致重合， (适合于已排序的数组)
     *  时间的复杂度O(1)
     *  最优解
     *
     * @return 返回元素的下标
     */
    private static int[] solution4(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] {low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{0};
    }
}
