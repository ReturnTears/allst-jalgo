package com.allst.jvalgo.leetcode2.array;

/**
 * 删除排序数组中的重复项
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。
 * 解题思路：
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * @author June
 * @since 2022-07-29
 */
public class RemoveDuplicatesInSortArray {

    private static int arrLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    private static int[] newArray(int[] nums, int length) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] newArr = new int[length];
        if (length >= 0) System.arraycopy(nums, 0, newArr, 0, length);
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int length = arrLength(nums);
        System.out.println("新数组长度 : " + length);
        int[] newArr = newArray(nums, length);
        System.out.print("新数组元素 : ");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}
