package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author YiYa
 * @since 2020-02-21 下午 04:07
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-7, 78, 0, 123, -22, 100};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr : " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        // 定义快排的最左、最右下标
        int l = left;
        int r = right;
        // 中轴
        int mid = arr[(left + right) / 2];
        // 临时变量， 交换用
        int temp = 0;
        // while循环是为了让比mid值小的放到左边， 比mid值大的放到右边
        while (l < r) {
            // 一直在mid的左边找，找到>=mid才退出
            while (arr[l] < mid) {
                l += 1;
            }
            // 一直在mid的右边找，找到<=mid才退出
            while (arr[r] > mid) {
                r -= 1;
            }
            // 说明左边已经全是<=mid的值，右边全是>=mid的值
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换后，arr[l] == mid，就让r前移: r--
            if (arr[l] == mid) {
                r -= 1;
            }
            // 如果交换后，arr[r] == mid，就让l后移: l++
            if (arr[r] == mid) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

}
