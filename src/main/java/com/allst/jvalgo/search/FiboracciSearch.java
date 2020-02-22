package com.allst.jvalgo.search;

import java.util.Arrays;

/**
 * 斐波拉契查找算法
 *
 * @author YiYa
 * @since 2020-02-22 上午 02:14
 */
public class FiboracciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 22, 89, 100, 1234};

        System.out.println("index = " + fiboracciSearch(arr, 100));
    }

    /**
     * 定义斐波拉契数列,因为mid=low+F(k - 1) - 1需要使用到斐波拉契数列， 因此我们需要先获取一个斐波拉契数列
     * 使用非递归的方法获取一个斐波拉契数列
     *
     * @return 结果
     */
    private static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * 斐波拉契查找算法
     *
     * @param arr     待查找数组
     * @param key   待查找关键值
     * @return      结果
     */
    private static int fiboracciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;      // 表示斐波拉契分割数值的下标
        int mid = 0;    // 存放mid值
        int[] fib = fib();  // 获取斐波拉契数列
        // 获取斐波拉契分割数值的下标
        while (high > fib[k] - 1) {
            k++;
        }
        //
        int[] temp = Arrays.copyOf(arr, fib[k]);
        // 用数列中的最大值填充扩容后的数值
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 是while循环找到k
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {  // 满足条件就继续向左查找
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {   // 满足条件就继续向右查找
                low = mid + 1;
                /*
                 * 1、全部元素 = 前面元素 + 后面元素
                 * 2、f[k] = f[k - 1] + f[k - 2]
                 *
                 */
                k -= 2;
            } else {    // 找到
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
