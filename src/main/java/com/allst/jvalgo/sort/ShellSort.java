package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author YiYa
 * @since 2020-02-21 上午 10:24
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort1(arr);
    }

    /**
     * 使用逐步推导的方式实现希尔排序
     *
     * shellSort1采用的交换方式
     */
    private static void shellSort1(int[] arr) {
        int temp = 0;
        // 假设10个元素, 10 ÷ 2 = 5， 第一轮排序将10个元素分成5组
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素(5组，每组2两个元素，步长为5)
            for (int k = i - 5; k >= 0; k -= 5) {
                if (arr[k] > arr[k + 5]) {  // arr[i] = arr[k + 5]
                    temp = arr[k];
                    arr[k] = arr[k + 5];
                    arr[k + 5] = temp;
                }
            }
        }

        System.out.printf("第一次排序后结果: %s\n", Arrays.toString(arr));

        // 假设10个元素, 10 ÷ 2 ÷ 2 = 5 ÷ 2 = 2， 第二轮排序将10个元素分成2组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的元素(5组，每组2两个元素，步长为5)
            for (int k = i - 2; k >= 0; k -= 2) {
                if (arr[k] > arr[k + 2]) {  // arr[i] = arr[k + 2]
                    temp = arr[k];
                    arr[k] = arr[k + 2];
                    arr[k + 2] = temp;
                }
            }
        }

        System.out.printf("第二次排序后结果: %s\n", Arrays.toString(arr));

        // 假设10个元素, 10 ÷ 2 ÷ 2 ÷ 2 = 5 ÷ 2 ÷ 2 = 2 ÷ 2 = 1， 第三轮排序将10个元素分成1组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素(5组，每组2两个元素，步长为5)
            for (int k = i - 1; k >= 0; k -= 1) {
                if (arr[k] > arr[k + 1]) {  // arr[i] = arr[k + 1]
                    temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }

        System.out.printf("第三次排序后结果: %s\n", Arrays.toString(arr));
    }
}
