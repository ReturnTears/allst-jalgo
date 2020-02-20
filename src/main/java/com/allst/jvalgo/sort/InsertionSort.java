package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author YiYa
 * @since 2020-02-21 上午 01:09
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 88, 7};
        insetSort(arr);
    }

    /**
     * 插入排序
     *
     * @param arr 参数
     */
    private static void insetSort(int[] arr) {
        // 定义待插入的数据
        int insertValue = arr[1];
        int insertIndex = 0;    // 0 = 1 - 1表达待插入数据的前一个下标位置
        /**
         * condition1(insertIndex >= 0): 表示在给待插入数据找插入位置时不越界
         * condition2(insertValue < arr[insertIndex]): 表示待插入数还没有找到插入位置
         */
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            // 将arr[insertIndex]后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // while退出时表示找到了插入的位置
        arr[insertIndex + 1] = insertValue;

        System.out.printf("第1轮排序后结果: %s\n", Arrays.toString(arr));


        insertValue = arr[2];
        insertIndex = 1;    // 1 = 2 - 1表达待插入数据的前一个下标位置
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            // 将arr[insertIndex]后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // while退出时表示找到了插入的位置
        arr[insertIndex + 1] = insertValue;

        System.out.printf("第2轮排序后结果: %s\n", Arrays.toString(arr));


        insertValue = arr[3];
        insertIndex = 2;    // 2 = 3 - 1表达待插入数据的前一个下标位置
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;

        System.out.printf("第2轮排序后结果: %s\n", Arrays.toString(arr));
    }
}
