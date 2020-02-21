package com.allst.jvalgo.search;

/**
 * 线性查找算法
 *
 * @author YiYa
 * @since 2020-02-22 上午 12:24
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {11, 7, 9, 0, -1, 22, 66};
        int value = linearSearch(arr, 7);
        if (value != -1) {
            System.out.printf("待查找参数%d的下标是%d", 7, value);
        } else {
            System.out.println("未找到");
        }
    }

    /**
     * 线程查找算法
     *
     * @param arr   待查找数组
     * @param value 待查找的值
     */
    private static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
