package com.allst.jvalgo.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 希尔排序
 * @author YiYa
 * @since 2020-02-21 上午 10:24
 */
public class ShellSort2 {

    public static void main(String[] args) {
        /*int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSortImprove(arr);*/

        // O(n^3)测试
        int[] testArr = new int[80000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 8000000);
        }
        Instant instant1 = Instant.now();
        long start = instant1.toEpochMilli();
        // shellSort(testArr);      // 6817
        shellSortImprove(testArr);  // 32
        Instant instant2 = Instant.now();
        long end = instant2.toEpochMilli();

        System.out.println("希尔排序耗时: " + (end - start));
    }

    /**
     * 使用逐步推导的方式实现希尔排序
     *
     * shellSort采用的交换方式
     */
    private static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 假设10个元素, 10 ÷ 2 = 5， 第一轮排序将10个元素分成5组
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(5组，每组2两个元素，步长为5)
                for (int k = i - gap; k >= 0; k -= gap) {
                    if (arr[k] > arr[k + gap]) {  //
                        temp = arr[k];
                        arr[k] = arr[k + gap];
                        arr[k + gap] = temp;
                    }
                }
            }
            // System.out.printf("第%d次排序后结果: %s\n", ++count, Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序法改进，
     * shellSortImprove 采用移位的方式
     */
    private static void shellSortImprove(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int k = i;
                int temp = arr[k];
                if (arr[k] < arr[k - gap]) {
                    // 插入排序
                    while (k - gap >= 0 && temp < arr[k - gap]) {
                        // 移动数据
                        arr[k] = arr[k - gap];
                        k -= gap;
                    }
                    arr[k] = temp;
                }
            }
            // System.out.printf("第%d次排序后结果: %s\n", ++count, Arrays.toString(arr));
        }
    }
}
