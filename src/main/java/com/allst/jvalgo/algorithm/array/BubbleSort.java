package com.allst.jvalgo.algorithm.array;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * （1）比较前后相邻的二个数据，如果前面数据大于后面的数据，就将这二个数据交换。
 * （2）这样对数组的第 0 个数据到 N-1 个数据进行一次遍历后，最大的一个数据就“沉” 到数组第N-1 个位置。
 * （3） N=N-1，如果 N 不为 0 就重复前面二步，否则排序完成。
 *
 * @author June
 * @since 2021年06月
 */
public class BubbleSort {
    public static void main(String... args) {
        int[] array = {1, 4, 7, 2, 5, 8, 3, 6, 9, 11};
        bubbling(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     */
    private static void bubbling(int[] arr, int n) {
        int i, j;
        for (i = 0; i < n; i++) {     // 表示 n 次排序过程。
            for (j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {// 前面的数字大于后面的数字就交换
                    // 交换 a[j-1]和 a[j]
                    int temp;
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
