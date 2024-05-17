package com.allst.jvalgo.leetcode;

/**
 * 素数和质数在现代数学中实际上是同一个概念，两者都指的是在大于1的自然数中，只能被1和它本身整除的数
 *
 * @author June
 * @since 2021年05月
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
        System.out.println(isPrime3(17));
    }

    // 素数查找暴力算法
    private static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime2(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime2(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime3(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            int r = i % j;
            if (r == 0) {
                return false;
            }
        }
        return true;
    }

    // 艾斯筛选法
    private static int eratosthenes(int n) {
        // false代表素数
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {// j表示合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
