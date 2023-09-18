package com.allst.jvalgo.leetcode2.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * 在LeetCode 双指针
 *
 * @author Hutu
 * @since 2023-09-18 下午 03:49
 */
public class CalcTwoSortSum {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 7, 8, 11, 13, 15};
        int target = 20;
        int[] twoSum = twoSum(numbers, target);
        Map<Integer, Integer> map = Map.of(twoSum[0], twoSum[1], twoSum[2], twoSum[3]);
        System.out.println(map);

        boolean judgeSquare = judgeSquareSum(13);
        System.out.println("judgeSquare : " + judgeSquare);

        String s = "leetcode";
        String reverseVowels = reverseVowels(s);
        System.out.println("reverseVowels : " + reverseVowels);
    }

    /**
     * 在有序数组中找出两个数，使它们的和为 target。
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 1、如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 2、如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 3、如果 sum < target，移动较小的元素，使 sum 变大一些。
     * <p>
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, numbers[i], j + 1, numbers[j]};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    /**
     * 题目描述：判断一个非负整数是否为两个整数的平方和。
     * <p>
     * 可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，如果能找到，则返回 true，表示 target 是两个整数的平方和。
     */
    public static boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
     * <p>
     * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
     * <p>
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     */
    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
