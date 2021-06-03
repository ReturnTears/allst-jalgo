package com.allst.jvalgo.leetcode;

/**
 * 硬币排列
 * 总共有n枚硬币，将他们摆成一个阶梯形状， 第K行就必须正好有K枚硬币
 * 给定一个数字n，找出可形成完整阶梯行的总行数
 * n是一个非负整数，并且在32位有符号整型的范围内
 *
 * @author June
 * @since 2021年06月
 */
public class CoinArray {
    public static void main(String ...args) {
        System.out.println(arrayCoin(10));
        System.out.println(arrayCoin(11));
        System.out.println(arrayCoin2(11));
        System.out.println(arrayCoin3(11));
    }

    /**
     * 迭代
     */
    private static int arrayCoin(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 二分查找
     */
    private static int arrayCoin2(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int cost = ((mid + 1) * mid) / 2;
            if (cost == n) {
                return mid;
            } else if (cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     * 牛顿迭代
     */
    private static int arrayCoin3(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) sqrt(n , n);
    }

    /**
     * 牛顿迭代原来的公式：
     * (x + n / x) / 2
     * 1到n的和公式： (n * n  + n) / 2 转换得：
     * n * n = 2 * x - n 带入上面得公式得：
     * 求平方根， 把n * n看作n
     * (x + (2 * n - x) / x) / 2
     *
     */
    private static double sqrt(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }
}
