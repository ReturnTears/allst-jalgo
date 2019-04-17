package com.allst.jvalgo.basicalgo;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作数组
 * @author June 2019/03/01 下午 07:22
 * @version 1.0
 */
public class ArrayOptr {
    public static void main(String[] args) {
        test2();
//        RemoveEleByIndex();
//        String[] arr = { "a", "b", "c", "d", "e" };
//        ArrayInnerConn conn = new ArrayInnerConn();
//        conn.testMethod(arr);
    }

    /**
     * 获取数组中的最小值
     */
    private static void minOfArray() {

    }

    /**
     * 打印数组中的内容
     */
    private static void printArr() {
        int[] arrayInt = {1,2,3,4,5};
        String intArrayString = Arrays.toString(arrayInt);
        System.out.print(intArrayString);
    }

    /**
     * 通过数组创建集合
     */
    private static void crtListByArr() {
        String[] stringArr = {"a","b","c","d","e"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stringArr));
        System.out.println(arrayList);
    }

    /**
     * 检查数组中是否包含有特定字符
     */
    private static void chkArrayOfChar() {
        String[] stringArray = { "a", "b", "c", "d", "e" };
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);
    }

    /**
     *
     */
    private static void mergeArrays() {
        int[] numa = {1, 2, 3, 4, 5};
        int[] numb = {6, 7, 8, 9, 10};
        int[] numc = ArrayUtils.addAll(numa, numb);
        String numTemp = Arrays.toString(numc);
        System.out.println(numTemp);
    }

    /**
     * 申明一个数组内连
     */
    private static class ArrayInnerConn {
        String str = "> ";
        private void testMethod(String[] data) {
            for(int i = 0; i < data.length; i++){
                str += data[i] + " > ";
            }
            System.out.println(str);
        }
    }

    /**
     * 反向数组
     */
    private static void RevArray() {
        int[] arr = {5, 2, 1, 4, 3, 8};
        ArrayUtils.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 删除数组指定位置的元素
     */
    private static void RemoveEleByIndex() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] other = ArrayUtils.remove(arr, 3);
        System.out.println(Arrays.toString(other));
    }

    /**
     * 二维数组的长度分为行长度, 列长度
     */
    private static void getTwoArray() {
        int[][] arr = new int[5][4];
        System.out.println("二维数组的长度--行长度 : "+arr.length);
        System.out.println("二维数组的长度--列长度 : "+arr[0].length);
    }

    private static void test() {
        Map<String, Object> mapPuGong = new HashMap<>();
        System.out.println(mapPuGong.size());
        Object ptygValue1 = null;
        for (Map.Entry<String, Object> entry : mapPuGong.entrySet()) {
            ptygValue1 = entry.getKey().contains("普通员工") ? entry.getValue() : "null";
        }
        System.out.println(ptygValue1);
    }

    private static void test2() {
        int[] a = new int[2];
        int res1 = a[0] = 1;
        System.out.println(res1);
        int res2 = a[0] = 11;
        System.out.println(res2);
        System.out.println(res1);
    }
}
