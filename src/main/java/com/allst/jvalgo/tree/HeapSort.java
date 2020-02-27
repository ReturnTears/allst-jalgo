package com.allst.jvalgo.tree;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author YiYa
 * @since 2020-02-27 下午 11:27
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /**
     * 堆排序:
     */
    private static void heapSort(int[] arr) {
        /*adHeap(arr, 1, arr.length);
        System.out.println("第一次: " + Arrays.toString(arr));
        adHeap(arr, 0, arr.length);
        System.out.println("第二次: " + Arrays.toString(arr));*/
        for (int i = arr.length / 2 -1; i>= 0; i--) {
            adHeap(arr, i, arr.length);
        }
        System.out.println("数组: " + Arrays.toString(arr));

        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adHeap(arr, 0, j);
        }
        System.out.println("堆排序完成后: " + Arrays.toString(arr));
    }

    /**
     * 将数组（二叉树）调整为大顶堆
     * @param arr       数组
     * @param i         非叶子节点在数组中的所有
     * @param lenght    对多少个元素进行调整，逐渐减少
     */
    private static void adHeap(int[] arr, int i, int lenght) {
        int temp = arr[i];
        // k = i * 2 + 1, k是i节点的左子节点
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
