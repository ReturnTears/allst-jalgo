package com.allst.jvalgo.search;

import java.util.Arrays;
import java.util.List;

/**
 * 插值查找算法
 * 适用于数据量大，有序的序列
 * @author YiYa
 * @since 2020-02-22 上午 01:27
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));

        int index = insertSearch(arr, 0, arr.length - 1, 22);
        System.out.println(index);
    }

    /**
     * 插值查找
     * @param arr       带查找数组
     * @param left      左侧初始索引
     * @param right     右侧初始索引
     * @param value     带查找值
     * @return          结果
     */
    private static int insertSearch(int[] arr, int left, int right, int value) {
        // 判断
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        // 中间值
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value > midValue) {
            return insertSearch(arr, mid + 1, right, value);
        } else if (value < midValue) {
            return insertSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 插值查找2
     * @param arr       带查找数组
     * @param left      左侧初始索引
     * @param right     右侧初始索引
     * @param value     带查找值
     * @return          结果
     */
    private static List<Integer> insertSearch2(int arr, int left, int right, int value) {

        return null;
    }
}
