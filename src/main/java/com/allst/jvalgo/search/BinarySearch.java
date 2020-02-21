package com.allst.jvalgo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找算法
 *
 * @author YiYa
 * @since 2020-02-22 上午 12:44
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-11, -7, 0, 9, 22, 22, 22, 23, 40, 66, 100, 100, 100};
        int result = binarySearch(arr, 0, arr.length, -7);
        System.out.println("index = " + result);
        List result2 = binarySearch2(arr, 0, arr.length, 100);
        System.out.println("index = " + result2);
    }

    /**
     * 二分查找
     *
     * @param arr   带查找数组
     * @param left  左侧初始化索引
     * @param right 右侧初始化索引
     * @param value 中间值
     * @return 索引
     */
    private static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        // 当left > right时表示递归完成，任未找到
        if (left > right) {
            return -1;
        }
        // 依次判断递归调用
        if (value > midValue) {     // 向右递归
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midValue) {  // 向左递归
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 找到有序数组中的所有满足的索引
     * 思路：
     * 1、在找到mid索引值，不马上返回
     * 2、向mid索引值的左边扫描， 将所有满足条件的元素下标加入到集合中
     * 3、向mid索引值的右边扫描， 将所有满足条件的元素下标加入到集合
     *
     * @param arr       待查找数组
     * @param left      左初始索引
     * @param right     右初始索引
     * @param value     带查找值
     * @return          索引集合
     */
    private static List binarySearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        // 当left > right时表示递归完成，任未找到
        if (left > right) {
            // return -1;
            return new ArrayList<Integer>();
        }
        // 依次判断递归调用
        if (value > midValue) {     // 向右递归
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < midValue) {  // 向左递归
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            List<Integer> list = new ArrayList<>();
            // 向左扫描
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp);
                temp -= 1;
            }
            /*
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
             */
            // 添加本身
            list.add(mid);
            // 向右扫描
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == value) {
                list.add(temp);
                temp += 1;
            }
            /*
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }
             */
            return list;
        }
    }
}
