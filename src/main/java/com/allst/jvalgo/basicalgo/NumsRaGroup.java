package com.allst.jvalgo.basicalgo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 用1 2 2 3 4 5 这六个数字组成随机的排列，要求4不能在第三位，3，5不能相连
 * @author June 2019/03/01 下午 11:50
 * @version 1.0
 */
public class NumsRaGroup {
    public static void main(String[] args) {
        new NumsRaGroup().searchMap();
    }
    String[] stra = {"1","2","2","3","4","5"};
    int strn = stra.length;

    boolean[] visited = new boolean[strn];
    String  result = "";
    TreeSet<String> ts = new TreeSet<>();

    int[][] a = new int[strn][strn];

    private void searchMap() {
        for (int i = 0; i < strn; i++) {
            for (int j = 0; j < strn; j++) {
                if (i == j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
        // 3和5不能相连
        a[3][5] = 0;
        a[5][3] = 0;
        // 开始遍历
        for (int i = 0; i < strn; i++) {
            search(i);
        }
        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            String str = it.next();
            // 4不能放在第三位
            if (str.indexOf("4") != 2) {
                System.out.println(str);
            }
        }
    }

    private void search(int startIndex) {
        visited[startIndex] = true;
        result += stra[startIndex];
        if (result.length() == strn) {
            ts.add(result);
        }
        for (int j = 0; j < strn; j++) {
            if (a[j][startIndex] == 1 && visited[j] == false) {
                search(j);
            } else {
                continue;
            }
        }
        result = result.substring(0, result.length() - 1);
        visited[startIndex] = false;
    }
}
