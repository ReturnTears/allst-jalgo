package com.allst.jvalgo.leetcode;

/**
 * 斐波拉契数列
 *
 * @author June
 * @since 2021年06月
 */
public class Fib {
    public static void main(String... args) {
        System.out.println(calculate(10));
        System.out.println(calculate2(10));
        System.out.println(calculate3(10));
    }

    /**
     * 暴力递归(时间复杂度：2n2)
     *
     * @param num 数列的第几位
     *
     * @return 结果
     */
    private static int calculate(final int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calculate(num - 1) + calculate(num - 2);
    }

    /**
     * 优化: 去重递归
     */
    private static int calculate2(final int num) {
        int[] arr = new int[num + 1];
        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        return recurse(arr, num - 1) + recurse(arr, num - 2);
    }

    /**
     * 优化： 双指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    private static int calculate3(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }
}
