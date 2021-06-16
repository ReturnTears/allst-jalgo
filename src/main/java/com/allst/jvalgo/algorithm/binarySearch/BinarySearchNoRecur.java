package com.allst.jvalgo.algorithm.binarySearch;

/**
 * 二分查找非递归算法
 * 二分查找：又叫折半查找，要求待查找的序列有序。每次取中间位置的值与待查关键字比较，如果中间位置
 * 的值比待查关键字大，则在前半部分循环这个查找的过程，如果中间位置的值比待查关键字小，
 * 则在后半部分循环这个查找的过程。直到查找到了为止，否则序列中没有待查的关键字
 *
 * @author YiYa
 * @since 2020-03-15 下午 05:14
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 22, 33, 55, 100};
        int index = binarySearch(arr, 22);
        System.out.println(index);
    }

    /**
     * 二分查找的非递归实现
     * @param arr 待查找的数组(默认升序)
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示未找到
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
