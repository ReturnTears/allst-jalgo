package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * bubbling 冒泡
 * 冒泡排序
 *
 * @author YiYa
 * @since 2020-02-20 下午 05:17
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = {13, 9, -1, 10, -7};
        // 定义一个临时变量
        int temp = 0;
        // 将最大值排在最后一位
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.printf("第一趟排序后: %s\n", Arrays.toString(arr));

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.printf("第二趟排序后: %s\n", Arrays.toString(arr));

        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.printf("第三趟排序后: %s\n", Arrays.toString(arr));

        for (int i = 0; i < arr.length - 4; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.printf("第四趟排序后: %s\n", Arrays.toString(arr));
    }

}
