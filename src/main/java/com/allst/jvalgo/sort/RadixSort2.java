package com.allst.jvalgo.sort;

import java.time.Instant;
import java.util.Arrays;

/**
 * 基数排序
 *
 * @author YiYa
 * @since 2020-02-21 下午 06:42
 */
public class RadixSort2 {

    public static void main(String[] args) {
        /*int[] arr = {53, 7, 542, 748, 22, 214};
        radixSort(arr);*/

        // 排序时间测试
        int[] testArr = new int[99999];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 9000000);
        }
        Instant instant1 = Instant.now();
        long start = instant1.toEpochMilli();

        // 基数排序
        radixSort(testArr);

        Instant instant2 = Instant.now();
        long end = instant2.toEpochMilli();

        System.out.printf("基数排序耗时: %dms\n", end - start);
    }

    /**
     * 基数排序方法
     */
    private static void radixSort(int[] arr) {

        // 获取数组中的最大的数的位数，假设数组第一位最大
        int max = arr[0];
        for (int a = 1; a < arr.length; a++) {
            if (max < arr[a]) {
                max = arr[a];
            }
        }
        // 得到最大数的位数
        int maxUnit = (max + "").length();

        // 使用循环处理
        for (int j = 0, n = 1; j < maxUnit; j++, n *= 10) {
            // 针对位数做处理

            // 定义一个二维数组， 表示10个桶， 每个桶都是一个一维数组, 为了防止存放数据时出现数据溢出，则每个一维数组长度为arr.length,典型的空间换时间
            int[][] bucket = new int[10][arr.length];
            // 为了记录每个桶中实际存放了多少个数据， 我们定义一个一维数组来记录各个桶每次存入的数据个数
            int[] bucketEleNums = new int[10];

            // 处理第一轮
            for (int i = 0; i < arr.length; i++) {
                // 依次取出每个元素的(个位,十位，百位....)
                int theUnit = arr[i] / n % 10;
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
            // System.out.printf("第%d轮排序后的结果: %s\n", j + 1, Arrays.toString(arr));
        }
    }

}
