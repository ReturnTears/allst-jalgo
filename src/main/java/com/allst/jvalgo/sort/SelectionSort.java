package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author YiYa
 * @since 2020-02-21 上午 12:16
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {101, 120, 130, 1};
        selection(arr);
    }

    /**
     * 选择排序
     */
    private static void selection(int[] arr) {
        // --------------------第一轮--------------------------//
        // 设定最小值的索引为0
        int minIndex = 0;       // index = 0
        int minValue = arr[0];  // value = 101
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]) {    // 说明假定的最小值不是最小，交换
                minIndex = i;           // 重置索引
                minValue = arr[i];      // 重置设定最小值
            }
        }
        // 循环完成后就找到了最小值，与索引为0的值交换
        if (minIndex != 0) {            // 优化: minIndex==0表示在循环中没有进行数据交换，即假定的最小值就是最小
            arr[minIndex] = arr[0];
            arr[0] = minValue;
        }

        System.out.printf("第1轮排序后结果: %s\n", Arrays.toString(arr));

        // --------------------第二轮--------------------------//
        minIndex = 1;
        minValue = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (minValue > arr[i]) {    // 说明假定的最小值不是最小，交换
                minIndex = i;           // 重置索引
                minValue = arr[i];      // 重置设定最小值
            }
        }
        // 循环完成后就找到了最小值，与索引为0的值交换
        if (minIndex != 1) {            // 优化: minIndex==0表示在循环中没有进行数据交换，即假定的最小值就是最小
            arr[minIndex] = arr[1];
            arr[1] = minValue;
        }

        System.out.printf("第2轮排序后结果: %s\n", Arrays.toString(arr));

        // --------------------第三轮--------------------------//
        minIndex = 2;
        minValue = arr[2];
        for (int i = 3; i < arr.length; i++) {
            if (minValue > arr[i]) {    // 说明假定的最小值不是最小，交换
                minIndex = i;           // 重置索引
                minValue = arr[i];      // 重置设定最小值
            }
        }
        // 循环完成后就找到了最小值，与索引为0的值交换
        if (minIndex != 2) {            // 优化: minIndex==0表示在循环中没有进行数据交换，即假定的最小值就是最小
            arr[minIndex] = arr[2];
            arr[2] = minValue;
        }

        System.out.printf("第3轮排序后结果: %s\n", Arrays.toString(arr));
    }

}
