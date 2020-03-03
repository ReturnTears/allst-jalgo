package com.allst.jvalgo.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组和一个目标值，找到数组中和为目标值的两个数
 *
 * @author YiYa
 * @since 2020-03-03 下午 09:58
 */
public class TwoSums {

    public static void main(String[] args) {
        int[] arr = {3 ,2, 7, 11, 15, 19};
        int target = 22;
        TwoSums twoSums = new TwoSums();
        List<int[]> result = twoSums.twoSum(arr, target);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
            for (int a : i) {
                System.out.printf("%d \n", arr[a]);
            }
        }

        // System.arraycopy(arr, 0, newArr, 0, result.length);
    }

    public List<int[]> twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        for (int i= 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    // System.out.println(nums[i] + " + " + nums[j] + " = " + target);
                    list.add(new int[] {i, j});
                }
            }
        }
        if (list.size() > 0) {
            return list;
        } else {
            throw new IllegalArgumentException("No two sum solution~~~");
        }
    }
}
