package com.allst.jvalgo.basicalgo;

/**
 * 一个数恰好等于它的因数之和，就称这个数为“完数”，例如6=1+2+3，找出1000以内的全部“完数”
 * @author June 2019/03/01 下午 11:56
 * @version 1.0
 */
public class NumsWanShu {
    public static void main(String[] args) {
        wanshu();
    }

    private static void wanshu() {
        for (int m = 2; m < 1000; m++) {
            int s = 0;
            for (int i = 1; i < m; i++) {
                if (m % i == 0) {
                    s += i;
                }
            }
            if (s == m) {
                System.out.print(m + " : ");
                for (int j = 1; j < m; j++) {
                    if (m % j == 0) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
