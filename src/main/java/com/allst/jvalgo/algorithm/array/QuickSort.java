package com.allst.jvalgo.algorithm.array;

import java.util.Arrays;

/**
 * 快速排序
 * 快速排序的原理：选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
 * 比基准值大的都在右边（一般是无序的）。 一般选择序列的第一个元素
 * 一次循环： 从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有
 * 继续比较下一个，直到找到第一个比基准值小的值才交换。 找到这个值之后，又从前往后开始比
 * 较，如果有比基准值大的，交换位置，如果没有继续比较下一个，直到找到第一个比基准值大的
 * 值才交换。直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值
 * 来说，左右两边就是有序的了。
 *
 * @author June
 * @since 2021年06月
 */
public class QuickSort {
    public static void main(String... args) {
        int[] array = {1, 4, 7, 2, 5, 8, 3, 6, 9, 11};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] arr, int low, int high) {
        int start = low, end = high, key = arr[low];
        while (end > start) {
            // 从后往前比较
            while (end > start && arr[end] >= key)
                // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 从前往后比较
            while (end > start && arr[start] <= key)
                // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，
            // 右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        // 递归
        if (start > low) sort(arr, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(arr, end + 1, high);// 右边序列。从关键值索引+1 到最后一个
    }
}
