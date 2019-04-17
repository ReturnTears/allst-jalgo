package com.allst.jvalgo.advalgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组相关操作
 * @author June 2019/03/01 下午 10:16
 * @version 1.0
 */
public class ReNumsOfArray {
    public static void main(String[] args) {
        int[] str = {1,22,3,2,4,44,5,2,7,5,8,5,4,7,6};
        arrayRe(str);
    }

    /**
     * 求出数组中重复元素的个数
     * @param array 数组
     */
    private static void arrayRe(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer integer = map.get(array[i]);
            map.put(array[i], integer == null ? 1 : ++integer);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            System.out.println(entry.getKey() + " 出现: " + entry.getValue() + " 次");
        }
    }
}
