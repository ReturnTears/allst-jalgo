package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * bubbling 冒泡
 * 冒泡排序, 优化
 * 时间复杂度O(n^2)
 *
 * @author YiYa
 * @since 2020-02-20 下午 05:17
 */
public class BubblingSort3 {

    public static void main(String[] args) {
        int[] arr = {13, 9, -1, 10, 20};
        // 定义一个临时变量
        int temp = 0;
        // 定义一个标识变量， 表示是否进行交换过
        boolean flag = false;
        // 将最大值排在最后一位
        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            System.out.printf("第%d躺排序后: %s\n", k + 1, Arrays.toString(arr));
            // 判断是否交换过
            if (!flag) {
                break;
            } else {
                flag = false;   // 重置flag
            }
        }
        System.out.printf("排序结果: %s\n", Arrays.toString(arr));
    }

}
