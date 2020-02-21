package com.allst.jvalgo.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author YiYa
 * @since 2020-02-21 下午 06:42
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 7, 542, 748, 22, 214};
        radixSort(arr);
    }

    /**
     * 基数排序方法
     */
    private static void radixSort(int[] arr) {
        // 定义一个二维数组， 表示10个桶， 每个桶都是一个一维数组, 为了防止存放数据时出现数据溢出，则每个一维数组长度为arr.length,典型的空间换时间
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中实际存放了多少个数据， 我们定义一个一维数组来记录各个桶每次存入的数据个数
        int[] bucketEleNums = new int[10];

        // 处理第一轮
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素的个位
            int theUnit = arr[i] % 10;
            // 放入到对应的桶中
            bucket[theUnit][bucketEleNums[theUnit]] = arr[i];
            bucketEleNums[theUnit]++;
        }
        // 按照桶的顺序依次取出桶里面的值放入数组
        int index = 0;
        for (int k = 0; k < bucketEleNums.length; k++) {
            // 桶中有数据才放入
            if (bucketEleNums[k] != 0) {
                // 循环第k个桶(对应的一维数组)，放入
                for (int i = 0; i < bucketEleNums[k]; i++) {
                    // 取出数据
                    arr[index++] = bucket[k][i];
                }
            }
            // 每一轮处理完需要对桶置零
            bucketEleNums[k] = 0;
        }
        System.out.println("第一轮排序后的结果: " + Arrays.toString(arr));

        // 处理第二轮
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素的个位
            int theUnit = arr[i] / 10 % 10;
            // 放入到对应的桶中
            bucket[theUnit][bucketEleNums[theUnit]] = arr[i];
            bucketEleNums[theUnit]++;
        }
        // 按照桶的顺序依次取出桶里面的值放入数组
        index = 0;
        for (int k = 0; k < bucketEleNums.length; k++) {
            // 桶中有数据才放入
            if (bucketEleNums[k] != 0) {
                // 循环第k个桶(对应的一维数组)，放入
                for (int i = 0; i < bucketEleNums[k]; i++) {
                    // 取出数据
                    arr[index++] = bucket[k][i];
                }
            }
            bucketEleNums[k] = 0;
        }
        System.out.println("第二轮排序后的结果: " + Arrays.toString(arr));

        // 处理第三轮
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素的个位
            int theUnit = arr[i] / 100 % 10;
            // 放入到对应的桶中
            bucket[theUnit][bucketEleNums[theUnit]] = arr[i];
            bucketEleNums[theUnit]++;
        }
        // 按照桶的顺序依次取出桶里面的值放入数组
        index = 0;
        for (int k = 0; k < bucketEleNums.length; k++) {
            // 桶中有数据才放入
            if (bucketEleNums[k] != 0) {
                // 循环第k个桶(对应的一维数组)，放入
                for (int i = 0; i < bucketEleNums[k]; i++) {
                    // 取出数据
                    arr[index++] = bucket[k][i];
                }
            }
        }
        System.out.println("第三轮排序后的结果: " + Arrays.toString(arr));
    }

}
