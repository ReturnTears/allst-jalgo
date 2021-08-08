package com.allst.jvalgo.leetcode;

/**
 * 牛顿迭代 计算一个数的平方根
 * 原理：
 *      因为 n / x = x
 *      (n / x + x) / 2 的值无限趋近于n的平方根
 *      所以一直递归调用即可求出n的平方根
 *  牛顿迭代算法比二分查找和暴力匹配算法效率更高
 * @author June
 * @since 2021年06月
 */
public class SqrtX {
    public static void main(String ...args) {
        System.out.println(newton(17));
    }

    private static int newton(int x) {
        if (x == 0) {
            return x;
        }
        return (int) sqrt(x, x);
    }

    private static double sqrt(double i , int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }
}
