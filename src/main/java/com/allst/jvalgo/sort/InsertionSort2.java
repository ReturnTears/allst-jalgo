package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author YiYa
 * @since 2020-02-21 上午 01:09
 */
public class InsertionSort2 {

    public static void main(String[] args) {
        int[] arr = {101, 34, 88, 7, -7, 1, 99, 22};
        System.out.printf("原数组:%s\n", Arrays.toString(arr));
        insetSort(arr);
    }

    /**
     * 插入排序
     *
     * @param arr 参数
     */
    private static void insetSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数据
            insertValue = arr[i];
            insertIndex = i - 1;    // 0 = 1 - 1表达待插入数据的前一个下标位置
            /**
             * condition1(insertIndex >= 0): 表示在给待插入数据找插入位置时不越界
             * condition2(insertValue < arr[insertIndex]): 表示待插入数还没有找到插入位置
             */
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {        // 从大到小排序修改: inserValue > arr[insertIndex]
                // 将arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // while退出时表示找到了插入的位置
            // 判断是否需要赋值
            if (insertIndex + 1 != i) {     // 优化的部分: 如果insertIndex + 1 = i 则表示待插入位置的值和原值一样arr[insertIndex + 1] = arr[i]
                arr[insertIndex + 1] = insertValue;
            }

            System.out.printf("第%d轮排序后结果: %s\n", i, Arrays.toString(arr));
        }
    }
}
