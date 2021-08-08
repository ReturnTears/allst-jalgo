package com.allst.jvalgo.algorithm.array;

import java.util.Arrays;

/**
 * 希尔排序算法
 * 基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列
 * 中的记录“基本有序” 时，再对全体记录进行依次直接插入排序。
 *
 * @author June
 * @since 2021年06月
 */
public class ShellSort {
    public static void main(String... args) {
        int[] array = {1, 4, 7, 2, 5, 8, 3, 6, 9, 11};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 1) {
            shellInsertSort(arr, dk);
            dk = dk / 2;
        }
    }

    private static void shellInsertSort(int[] arr, int dk) {
        // 类似插入排序，只是插入排序增量是 1，这里增量是 dk,把 1 换成 dk 就可以了
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int x = arr[i];//x 为待插入元素
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && x < arr[j]; j = j - dk) {
                    // 通过循环，逐个后移一位找到要插入的位置。
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = x;//插入
            }
        }
    }
}
