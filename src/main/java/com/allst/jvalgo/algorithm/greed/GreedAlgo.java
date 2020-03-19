package com.allst.jvalgo.algorithm.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 *
 * @author YiYa
 * @since 2020-03-19 下午 10:48
 */
public class GreedAlgo {

    public static void main(String[] args) {
        //
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        // 加入map 得出的结果为[K1, K2, K3, K5]
        /*broadCasts.put("K1", set1);
        broadCasts.put("K2", set2);
        broadCasts.put("K3", set3);
        broadCasts.put("K4", set4);
        broadCasts.put("K5", set5);*/

        broadCasts.put("K2", set1);
        broadCasts.put("K1", set2);
        broadCasts.put("K4", set4);
        broadCasts.put("K5", set3);
        broadCasts.put("K3", set5);


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("北京");
        hashSet.add("上海");
        hashSet.add("天津");
        hashSet.add("广州");
        hashSet.add("深圳");
        hashSet.add("成都");
        hashSet.add("杭州");
        hashSet.add("大连");

        ArrayList<String> selects = new ArrayList<>();

        HashSet<String> tempSet = new HashSet<>();

        String maxKey;

        while (hashSet.size() != 0) {
            maxKey = null;
            for (String key : broadCasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(hashSet);
                // 体现了贪心算法
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadCasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                hashSet.removeAll(broadCasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果是" + selects);
    }
}
