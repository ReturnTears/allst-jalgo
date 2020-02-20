package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author YiYa
 * @since 2020-02-21 上午 12:16
 */
public class SelectionSort2 {

    public static void main(String[] args) {
        int[] arr = {101, 120, 130, 1};
        selection(arr);
    }

    /**
     * 选择排序
     */
    private static void selection(int[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {
            // 设定最小值的索引为0
            int minIndex = k;       // index = 0
            int minValue = arr[k];  // value = 101
            for (int i = k + 1; i < arr.length; i++) {
                if (minValue > arr[i]) {    // 说明假定的最小值不是最小，交换      // 从大到小排序就是minValue < arr[i]
                    minIndex = i;           // 重置索引
                    minValue = arr[i];      // 重置设定最小值
                }
            }
            // 循环完成后就找到了最小值，与索引为0的值交换
            if (minIndex != k) {            // 优化: minIndex==0表示在循环中没有进行数据交换，即假定的最小值就是最小
                arr[minIndex] = arr[k];
                arr[k] = minValue;
            }

            System.out.printf("第%d轮排序后结果: %s\n", k + 1, Arrays.toString(arr));
        }

    }

}
