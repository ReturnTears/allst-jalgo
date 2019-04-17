package com.allst.jvalgo.basicalgo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * 不使用循环获取数组中最小值
 * 使用Stream最方便
 * @author June 2019/03/03 上午 11:43
 * @version 1.0
 */
public class ArraySortNotFor {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3, 8};
        getArrayMinEleByStream(arr);
        getArrayMinEleByCollection(arr);
        getArrayMinEleBySort(arr);
    }

    private static void getArrayMinEleByStream(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(min);
    }

    private static void getArrayMinEleByCollection(int[] arr) {
        int min = Collections.min(Arrays.asList(ArrayUtils.toObject(arr)));
        System.out.println(min);
    }

    private static void getArrayMinEleBySort(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
