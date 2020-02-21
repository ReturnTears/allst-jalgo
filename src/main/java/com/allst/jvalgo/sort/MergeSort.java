package com.allst.jvalgo.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 归并排序
 *
 * @author YiYa
 * @since 2020-02-21 下午 05:25
 */
public class MergeSort {

    public static void main(String[] args) {
        //int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        // 归并需要额外的空间
        //int[] temp = new int[arr.length];
        // 归并排序
        // mergeSort(arr, 0, arr.length - 1, temp);

        Instant instant1 = Instant.now();
        long start = instant1.toEpochMilli();

        int[] testArr = new int[99999];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 9000000);
        }
        // 归并排序
        mergeSort(testArr, 0, testArr.length - 1, new int[testArr.length]);

        Instant instant2 = Instant.now();
        long end = instant2.toEpochMilli();

        //System.out.println("归并排序后的结果: " + Arrays.toString(temp));
        System.out.println("归并排序耗时: " + (end - start));     // 30ms
    }

    /**
     * 分 + 合
     * @param arr       原始数组
     * @param left      左索引
     * @param right     右索引
     * @param temp      中间数组
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr       排序的原始数组
     * @param left      左边初始索引
     * @param mid       中间索引
     * @param right     右边索引
     * @param temp      做中转的数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        // 把左右两边的有序序列按照规则填充到temp数组
        while (i <= mid && j <= right) {
            // 如果左边有序序列的当前元素<=右边有序序列的当前元素，将左边序列的当前元素填充到temp数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {    // 反之，将右边序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // 把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {  // 左边还有剩余元素，依次全部填充
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {  // 右边还有剩余元素，依次全部填充
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // 将temp数组的元素拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {  // 第一次合并tempLeft = 0,
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}
