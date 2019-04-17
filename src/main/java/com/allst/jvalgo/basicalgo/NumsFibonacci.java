package com.allst.jvalgo.basicalgo;

import java.util.Scanner;

/**
 * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * @author June 2018-01-13 下午 02:13
 * @version 1.0
 */
public class NumsFibonacci {
    public static void main(String[] args) {
//        fibonacciNum();
        int res = recursionFibonacci(7);
        System.out.println(res);
    }

    /**
     * Fibonacci数列
     */
    private static void fibonacciNum() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数: ");
        int n = scan.nextInt();
        int[] arr = new int[1000000];
        arr[1] = arr[2] =1;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }

    /**
     * 使用递归调用算法计算斐波拉基数列:1 1 2 3 5 8 13 21 ...
     * recursion[] 递归、循环、递归式
     * @param n 数列位数
     * @return 对应位数的值
     */
    private static int recursionFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
        }
    }
}
