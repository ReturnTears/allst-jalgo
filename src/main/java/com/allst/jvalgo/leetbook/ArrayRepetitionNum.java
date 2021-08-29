package com.allst.jvalgo.leetbook;

import java.util.*;

/**
 * 找出数组中重复的数字：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author June
 * @since 2021年08月
 */
public class ArrayRepetitionNum {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3, 2};
        int result = getTheFirstRepetitionNum(array);
        System.out.println(result);

        int result2 = getTheRandomRepetitionNum(array);
        System.out.println(result2);

        System.out.println(findRepeatNumber(array));
    }

    /**
     * 计算第一个重复数字
     *
     * @param array 数组
     *
     * @return 返回值, 若没有重复数字返回0
     */
    private static int getTheFirstRepetitionNum(int[] array) {
        if (array.length < 2) {
            return array[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            Integer count = map.get(value);
            map.put(value, count == null ? 1 : ++count);
            if (count != null && count > 1) {
                return map.get(value);
            }
        }
        return 0;
    }

    /**
     * 获取随机任意一个重复数字
     *
     * @param array 数组
     *
     * @return 返回值
     */
    private static int getTheRandomRepetitionNum(int[] array) {
        if (array.length < 2) {
            return array[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            Integer count = map.get(value);
            map.put(value, count == null ? 1 : ++count);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        int i = new Random().nextInt(result.size());
        return result.get(i);
    }

    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) return nums[i];
        }
        return -1;
    }
}
