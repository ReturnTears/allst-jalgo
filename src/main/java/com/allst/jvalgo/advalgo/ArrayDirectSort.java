package com.allst.jvalgo.advalgo;

import java.util.Arrays;

/**
 * 数组直接排序
 * @author June 2019/03/02 下午 05:29
 * @version 1.0
 */
public class ArrayDirectSort {
    public static void main(String[] args) {
        int[] arr = {1,12,23,40,9,24,15,3,18,30};
//        selectSortOne(arr);
        selectSortTwo(arr);
    }

    private static void selectSortOne(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.print(Arrays.toString(a));
    }

    private static void selectSortTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tem = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[tem]) {
                    tem = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[tem];
            arr[tem] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
